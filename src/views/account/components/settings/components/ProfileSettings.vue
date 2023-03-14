<template>
    <el-card shadow="nerve">
        <div slot="header" class="cursor-pointer min-h-35px d-flex flex-stack">
            <!--begin::Card title-->
            <div class="card-title m-0">
                <h3 class="fw-bold m-0">Profile Details</h3>
            </div>

        </div>
        <div id="kt_account_settings_profile_details" class="collapse show px-9 pt-7">
            <!--begin::Form-->
            <el-form :model="profileInfo" ref="formValidate" label-width="370px" label-position="left"
                class="form-container">
                <div class="image-input image-input-outline image-input-placeholder image-input-position ">
                    <img class="image-input-wrapper" :src="profileInfo.avatar" />
                    <el-upload class="upload-demo" action="" :auto-upload="false" :show-file-list="false"
                        :on-change="changeUpload">
                        <label class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow"
                            data-kt-image-input-action="change">
                            <i class="bi bi-pencil-fill fs-7"></i>
                        </label>
                    </el-upload>
                    <span class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow"
                        data-kt-image-input-action="remove" @click="cancelAvatar">
                        <i class="bi bi-x fs-2"></i>
                    </span>
                    <div class="form-text">Allowed file types: png, jpg, jpeg.</div>
                </div>

                <el-row>
                    <el-col>
                        <el-form-item label="昵称">
                            <el-input v-model="profileInfo.nickname" class="h-40px"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-form-item label="手机号">
                        <el-input v-model="profileInfo.mobile" class="h-40px"></el-input>
                    </el-form-item>
                </el-row>

                <el-row>
                    <el-form-item label="邮箱">
                        <el-input v-model="profileInfo.email" class="h-40px"></el-input>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="性别">
                        <el-select v-model="profileInfo.sex" class="w-100 h-40px" placeholder="请选择性别">
                            <el-option v-for="item in sexOptions" :key="item.value" :label="item.label"
                                :value="item.value"></el-option>
                        </el-select>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item label="简介">
                        <el-input v-model="profileInfo.description" type="textarea" :row="4"></el-input>
                    </el-form-item>
                </el-row>

            </el-form>
            <div class="card-footer d-flex justify-content-end py-6">
                <el-button class=" me-2" @click="cancel">取 消</el-button>
                <el-button type="primary" @click="save">保 存</el-button>
            </div>
            <cropper ref="cropper" :cropperImg="cropperImg" @upload-img="uploadImg"></cropper>

        </div>
    </el-card>
</template>
<script>
import { getUser, addOrUpdateUser, uploadImg } from '@/api/system/user'
import { getSexOption } from '@/api/option'
import Cropper from "@/components/Cropper"


export default {
    name: 'ProfileSettings',
    components: {
        Cropper
    },
    props: {
        userInfo: Object,
    },
    data() {
        return {
            cropperImg: '', // 需要裁剪的图片
            fileName: "",
            profileInfo: JSON.parse(JSON.stringify(this.userInfo)),
            sexOptions: [
                {
                    value: 'MALE',
                    label: '男'
                },
                {
                    value: 'FEMALE',
                    label: '女'
                },
                {
                    value: 'UNKNOWN',
                    label: '未知'
                }
            ],
        }
    },
    mounted() {
        this.loadSexOptionModel()
    },
    methods: {
        loadSexOptionModel() {
            getSexOption().then(res => {
                if (res.data) {
                    this.sexOptions = res.data
                }
            })
        },
        save() {
            this.$refs['formValidate'].validate((valid) => {
                if (valid) {
                    addOrUpdateUser(this.profileInfo)
                        .then(res => {
                            this.$emit('refreshInfo')
                            this.$message.success("保存成功")
                            
                        })
                }
            })
        },
        cancel() {

        },
        changeUpload(file, fileList) {
            const isLt5M = file.size / 1024 / 1024 < 5
            if (!isLt5M) {
                this.$message.error('上传文件大小不能超过 5MB!')
                return false
            }
            //提前存一下文件名字 一会转文件的时候能用
            this.fileName = file.name
            let url = URL.createObjectURL(file.raw)
            // 上传成功后将图片地址赋值给裁剪框显示图片
            this.$nextTick(() => {
                this.cropperImg = url
                this.$refs.cropper.openDialog()
            })
        },
        cancelAvatar() {
            this.profileInfo.avatar = this.userInfo.avatar
        },
        uploadImg(data) {
            let file = new window.File([data], this.fileName, { type: 'image/jpeg' })
            var formData = new FormData();
            formData.append('file', file);
            let config = {
                headers: { "Content-Type": "multipart/form-data" }
            };
            uploadImg(formData, config).then(res => {
                this.profileInfo.avatar = res.data;
            });
        },
    }
}
</script>
<style lang="scss" scoped>
.image-input-position {
    height: 120px;
    width: 120px;
    top: -12px;
    left: 380px;
    margin-bottom: 10px;

    .form-text {
        margin-top: 0px;
        width: 200px;
    }

}
</style>