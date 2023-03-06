<template>
    <el-form :model="userInfo" ref="formValidate" label-width="80px" class="form-container">
        <!-- <cropper
		:src="img"
		@change="change"
	/> -->
        <div class="image-input image-input-outline image-input-placeholder image-input-position">
            <img class="image-input-wrapper w-150px h-150px" :src="userInfo.avatar" />
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
        </div>
        <el-row class="w-75">
            <el-col :span="20">
                <el-form-item label="用户名">
                    <el-input v-model="userInfo.username"></el-input>
                </el-form-item>
            </el-col>

        </el-row>
        <el-row class="w-75">
            <el-col :span="20">
                <template v-if="userInfo.id">
                    <el-form-item label="密码">
                        <el-input value="************" disabled type="password"></el-input>
                    </el-form-item>
                </template>
                <template v-else>
                    <el-form-item label="密码">
                        <el-input v-model="userInfo.password" type="password"></el-input>
                    </el-form-item>
                </template>
            </el-col>
        </el-row>
        <el-row class="w-75">
            <el-col :span="20">
                <el-form-item label="昵称">
                    <el-input v-model="userInfo.nickname"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="12">
                <el-form-item label="手机号">
                    <el-input v-model="userInfo.mobile"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="邮箱">
                    <el-input v-model="userInfo.email"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="12">
                <el-form-item label="性别">
                    <el-select v-model="userInfo.sex" class="w-100" placeholder="请选择性别">
                        <el-option v-for="item in sexOptions" :key="item.value" :label="item.label"
                            :value="item.value"></el-option>
                    </el-select>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="状态">
                    <el-select v-model="userInfo.status" class="w-100" placeholder="请选择状态">
                        <el-option v-for="item in statusOptions" :key="item.value" :label="item.label"
                            :value="item.value"></el-option>
                    </el-select>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="12">
                <el-form-item label="部门">
                    <tree-select :value="userInfo.deptId" :options="treeModelData" class="w-100"
                        @getValue="getValue($event)"></tree-select>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="角色">
                    <el-select v-model="userInfo.roleIds" class="w-100" multiple placeholder="请选择状态">
                        <el-option v-for="item in roleOptions" :key="item.value" :label="item.label"
                            :value="item.value"></el-option>
                    </el-select>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-form-item label="简介">
                <el-input v-model="userInfo.description" type="textarea" :row="4"></el-input>
            </el-form-item>
        </el-row>
        <cropper :dialogVisible="dialogVisible" :cropperImg="cropperImg" @upload-img="uploadImg"
            @colse-dialog="closeDialog"></cropper>
    </el-form>
</template>
<script>
import { addOrUpdateUser, uploadImg } from '@/api/system/user'
import { getSexOption, getStatusOption } from '@/api/option'
import { fetchDeptTreeModel } from '@/api/system/dept'
import { fetchRoleOptionModel } from '@/api/system/role'
import TreeSelect from "@/components/TreeSelect"
import Cropper from "@/components/Cropper"

export default {
    name: 'UserAdd',
    components: {
        TreeSelect,
        Cropper,
    },
    props: {
        userInfo: Object,
    },
    data() {
        return {
            dialogVisible: false,
            loading: false,
            fileName: "",
            cropperImg: '', // 需要裁剪的图片
            treeModelData: [],
            roleOptions: [],
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
            statusOptions: [
                {
                    value: 'VALID',
                    label: '启用'
                },
                {
                    value: 'LOCK',
                    label: '禁用'
                },
            ],
            ruleForm: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
        };
    },
    mounted() {
        this.loadTreeModel()
        this.loadRoleOptionModel()
        this.loadUserSexOptionModel()
        this.loadStatusOptionModel()
    },
    methods: {
        loadTreeModel() {
            fetchDeptTreeModel().then(res => {
                this.treeModelData = res.data
            })
        },
        loadRoleOptionModel() {
            fetchRoleOptionModel().then(res => {
                this.roleOptions = res.data
            })
        },
        loadUserSexOptionModel() {
            getSexOption().then(res => {
                if (res.data) {
                    this.sexOptions = res.data
                }
            })
        },
        loadStatusOptionModel() {
            getStatusOption().then(res => {
                if (res.data) {
                    this.statusOptions = res.data
                }
            })
        },
        search() {
            this.$emit("search")
        },
        save() {
            this.$refs['formValidate'].validate((valid) => {
                if (valid) {
                    addOrUpdateUser(this.userInfo)
                        .then(res => {
                            this.$emit("cancel")
                            this.$message.success("添加成功")
                            this.search()
                        })
                }
            })
        },
        beforeAvatarUpload(file) {
            const isImg = file.type === "image/jpeg" || file.type === "image/png";
            const isLt2M = file.size / 1024 / 1024 < 2;

            if (!isImg) {
                this.$message.error("上传头像图片只能是 JPG/PNG 格式!");
            }
            if (!isLt2M) {
                this.$message.error("上传头像图片大小不能超过 2MB!");
            }
            if (isImg && isLt2M) {
                let param = new FormData(); // 创建form对象
                param.append("file", file, file.name); // file对象是 beforeUpload参数
                let config = {
                    headers: { "Content-Type": "multipart/form-data" }
                };
                uploadImg(param, config).then(res => {
                    this.userInfo.avatar = res.data;
                });
            }
            return false;
        },
        cancelAvatar() {
            this.userInfo.avatar = 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg'
        },
        getValue(value) {
            this.userInfo.deptId = value
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
                this.dialogVisible = true
            })
        },
        uploadImg(data) {
            let file = new window.File([data], this.fileName, { type: 'image/jpeg' })
            console.log(file)
            var formData = new FormData();
            formData.append('file', file);
            let config = {
                headers: { "Content-Type": "multipart/form-data" }
            };
            uploadImg(formData, config).then(res => {
                this.userInfo.avatar = res.data;
                this.dialogVisible = false
            });
        },
        // 关闭窗口
        closeDialog() {
            this.dialogVisible = false;
        }
    }
}
</script>
<style lang="scss" scoped>
.form-container {
    padding: 15px 0px;

    .image-input-position {
        position: absolute;
        right: 70px;
    }

    .image-input {
        [data-kt-image-input-action=remove] {
            top: 86%;
        }
    }
}

.UploadImg {
    .el-upload {
        display: block;
        width: 100px;
        margin: 30px auto 0;
    }

    .upload-icon {
        display: block;
        margin: 0 auto;
        height: 44px;
        width: 52px;
        // background-image: url(~@/assets/img/upload-image.png);
        background-position: 100% 100%;
        margin-bottom: 20px;
    }

    .video-image {
        display: flex;

        figure {
            width: 100px;

            img {
                width: 100%;
                display: block;
            }
        }
    }
}

.cropper-content {
    .cropper {
        text-align: center;
        width: auto;
        height: 400px;
    }
}
</style>