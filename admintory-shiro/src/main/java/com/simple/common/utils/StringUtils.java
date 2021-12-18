package com.simple.common.utils;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static final Pattern CHINESE_PATTERN = Pattern.compile("[\u4e00-\u9fa5]");

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;        // 实例化模板对象



    /**
     * @Description: 生成唯一图片名称
     * @Param: fileName
     * @return: 云服务器fileName
     */
    public static String getRandomImgName(String fileName) {

        int index = fileName.lastIndexOf(".");

        if ((fileName == null || fileName.isEmpty()) || index == -1){
            throw new IllegalArgumentException();
        }
        // 获取文件后缀
        String suffix = fileName.substring(index);
        // 生成UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 生成上传至云服务器的路径
        String path = "code/duck/" + LocalDate.now() + "-" + uuid + suffix;
        return path;
    }

    /**
     * 判断是否包含中文
     *
     * @param value 内容
     * @return 结果
     */
    public static boolean containChinese(String value) {
        if (isBlank(value)) {
            return false;
        }
        Matcher matcher = CHINESE_PATTERN.matcher(value);
        return matcher.find();
    }

    public static String getPath(String path) {
        if (isEmpty(path)) {
            return path;
        }
        if (!(path.startsWith("/"))) {
            return "/" + path;
        }
        return path;
    }

    public static String getComponentPath(String path){
        if (isNotBlank(path) && path.substring(0, 1).equals("/")) {
            return path.substring(1);
        }
        return path;
    }

    public static String spliceLastStr(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.endsWith(separator)) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }


    public static String formatDateStr(String strDate) {
        try{
            Date d = dateFormat.parse(strDate) ;
            return dateFormat.format(d);
        } catch(Exception e){            // 如果提供的字符串格式有错误，则进行异常处理
            e.printStackTrace() ;       // 打印异常信息
        }
        return null;
    }

    public static String keyGenerate(Object key){
        return String.format("shiro:token:%s", key.toString());
    }

    public static String relateKeyGenerate(Object key) {
        return String.format("shiro:token:session:%s", key.toString());

    }
}
