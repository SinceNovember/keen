package com.simple.common.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.simple.common.config.CloudStorageConfig;
import com.simple.common.service.UploadImageService;

import java.io.FileInputStream;

/**
 * 七牛云上传图片
 */
public class QiNiuUploadImageServiceImpl implements UploadImageService {

    // 七牛文件上传管理器
    private UploadManager uploadManager;
    //认证token
    private String token;
    // 七牛认证管理
    private Auth auth;

    private CloudStorageConfig config;

    public QiNiuUploadImageServiceImpl(CloudStorageConfig config) {
        this.config = config;
        init();
    }

    private void init(){
        // 构造一个带指定Zone对象的配置类, 注意这里的Zone.zone0需要根据主机选择
        uploadManager = new UploadManager(new Configuration(Zone.zone2()));
        auth = Auth.create(config.getQiniuAccessKey(), config.getQiniuSecretKey());
        // 根据命名空间生成的上传token
        token = auth.uploadToken(config.getQiniuBucketName());
    }

    @Override
    public String uploadImg(FileInputStream file, String key) {
        try{
            // 上传图片文件
            Response res = uploadManager.put(file, key, token, null, null);
            if (!res.isOK()) {
                throw new RuntimeException("上传七牛出错：" + res.toString());
            }
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);

            String path = config.getQiniuDomain() + "/" + putRet.key;
            // 这个returnPath是获得到的外链地址,通过这个地址可以直接打开图片
            return path;
        }catch (QiniuException e){
            e.printStackTrace();
        }
        return "";
    }
}
