<template>
    <div class="progress-vertical">
        <div class="progress-vertical gap-2">
            <el-input v-model="params.codeName" style="width: 200px;" small prefix-icon="el-icon-search"
                @change="search" placeholder="请输入代码名称"></el-input>
            <a href="#" class="btn btn-sm btn-icon btn-color-primary btn-light  btn-active-light-primary">
                <span class="svg-icon svg-icon-3 m-0"><svg width="16" height="15" viewBox="0 0 16 15" fill="none"
                        xmlns="http://www.w3.org/2000/svg">
                        <rect y="6" width="16" height="3" rx="1.5" fill="currentColor"></rect>
                        <rect opacity="0.3" y="12" width="8" height="3" rx="1.5" fill="currentColor"></rect>
                        <rect opacity="0.3" width="12" height="3" rx="1.5" fill="currentColor"></rect>
                    </svg>
                </span>
            </a>
        </div>

        <div class="d-flex flex-wrap gap-2">
            <!--begin::Reload-->
            <a class="btn btn-sm btn-icon btn-light btn-active-light-primary" @click="refreshTable">
                <!--begin::Svg Icon | path: icons/duotune/arrows/arr029.svg-->
                <span class="svg-icon svg-icon-2">
                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path
                            d="M14.5 20.7259C14.6 21.2259 14.2 21.826 13.7 21.926C13.2 22.026 12.6 22.0259 12.1 22.0259C9.5 22.0259 6.9 21.0259 5 19.1259C1.4 15.5259 1.09998 9.72592 4.29998 5.82592L5.70001 7.22595C3.30001 10.3259 3.59999 14.8259 6.39999 17.7259C8.19999 19.5259 10.8 20.426 13.4 19.926C13.9 19.826 14.4 20.2259 14.5 20.7259ZM18.4 16.8259L19.8 18.2259C22.9 14.3259 22.7 8.52593 19 4.92593C16.7 2.62593 13.5 1.62594 10.3 2.12594C9.79998 2.22594 9.4 2.72595 9.5 3.22595C9.6 3.72595 10.1 4.12594 10.6 4.02594C13.1 3.62594 15.7 4.42595 17.6 6.22595C20.5 9.22595 20.7 13.7259 18.4 16.8259Z"
                            fill="currentColor"></path>
                        <path opacity="0.3"
                            d="M2 3.62592H7C7.6 3.62592 8 4.02592 8 4.62592V9.62589L2 3.62592ZM16 14.4259V19.4259C16 20.0259 16.4 20.4259 17 20.4259H22L16 14.4259Z"
                            fill="currentColor"></path>
                    </svg>
                </span>
            </a>
            <!--end::Reload-->

            <a class="btn btn-sm btn-icon btn-light btn-active-light-primary" @click="openAdd">
                <span class="svg-icon svg-icon-2">
                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <rect opacity="0.5" x="11.364" y="20.364" width="16" height="2" rx="1"
                            transform="rotate(-90 11.364 20.364)" fill="currentColor" />
                        <rect x="4.36396" y="11.364" width="16" height="2" rx="1" fill="currentColor" />
                    </svg>
                </span>
            </a>

            <a class="btn btn-sm btn-icon btn-light btn-active-light-primary" @click="deleteSelected">
                <span class="svg-icon svg-icon-2">
                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path
                            d="M5 9C5 8.44772 5.44772 8 6 8H18C18.5523 8 19 8.44772 19 9V18C19 19.6569 17.6569 21 16 21H8C6.34315 21 5 19.6569 5 18V9Z"
                            fill="currentColor"></path>
                        <path opacity="0.5"
                            d="M5 5C5 4.44772 5.44772 4 6 4H18C18.5523 4 19 4.44772 19 5V5C19 5.55228 18.5523 6 18 6H6C5.44772 6 5 5.55228 5 5V5Z"
                            fill="currentColor"></path>
                        <path opacity="0.5" d="M9 4C9 3.44772 9.44772 3 10 3H14C14.5523 3 15 3.44772 15 4V4H9V4Z"
                            fill="currentColor"></path>
                    </svg>
                </span>
            </a>

            <!--begin::Filter-->
            <div>
                <a href="#" class="btn btn-sm btn-icon btn-light btn-active-light-primary">
                    <!--begin::Svg Icon | path: icons/duotune/arrows/arr072.svg-->
                    <span class="svg-icon svg-icon-2"><svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                            xmlns="http://www.w3.org/2000/svg">
                            <path
                                d="M11.4343 12.7344L7.25 8.55005C6.83579 8.13583 6.16421 8.13584 5.75 8.55005C5.33579 8.96426 5.33579 9.63583 5.75 10.05L11.2929 15.5929C11.6834 15.9835 12.3166 15.9835 12.7071 15.5929L18.25 10.05C18.6642 9.63584 18.6642 8.96426 18.25 8.55005C17.8358 8.13584 17.1642 8.13584 16.75 8.55005L12.5657 12.7344C12.2533 13.0468 11.7467 13.0468 11.4343 12.7344Z"
                                fill="currentColor"></path>
                        </svg>
                    </span>
                    <!--end::Svg Icon--> </a>

            </div>
            <!--end::Filter-->

            <!--begin::Sort-->
            <span>
                <a href="#" class="btn btn-sm btn-icon btn-light btn-active-light-primary">
                    <!--begin::Svg Icon | path: icons/duotune/general/gen052.svg-->
                    <span class="svg-icon svg-icon-3 m-0"><svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                            xmlns="http://www.w3.org/2000/svg">
                            <rect x="10" y="10" width="4" height="4" rx="2" fill="currentColor"></rect>
                            <rect x="17" y="10" width="4" height="4" rx="2" fill="currentColor"></rect>
                            <rect x="3" y="10" width="4" height="4" rx="2" fill="currentColor"></rect>
                        </svg>
                    </span>
                    <!--end::Svg Icon--> </a>

            </span>
            <!--end::Sort-->
        </div>

        <!-- <el-dialog title="提示" :visible.sync="dialog" width="680px" top="50px">
            <div slot="title">
                <img alt="Logo" src="@/assets/media/logos/default-small.svg">
                <span class="header-title">
                    添加代码
                </span>
            </div>
            <code-main-add ref="add" :codeMainInfo="codeMainInfo" @search="refreshTable"
                @cancel="cancel"></code-main-add>
            <span slot="footer" class="dialog-footer">
                <el-button @click="cancel">取 消</el-button>
                <el-button type="primary" @click="save">确 定</el-button>
            </span>
        </el-dialog> -->

        <keen-dialog :visible.sync="dialog" title="添加代码" @cancel="dialog = false" @save="save">
            <code-main-add ref="add" :codeMainInfo="codeMainInfo" @search="refreshTable"
                @cancel="cancel"></code-main-add>
        </keen-dialog>
    </div>
</template>
<script>
import CodeMainAdd from './CodeMainAdd'
export default {
    name: 'CodeMainHeader',
    components: {
        CodeMainAdd
    },
    data() {
        return {
            dialog: false,
            params: {
                codeName: '',
                pageNum: 1,
            },
            codeMainInfo: {
                orderNum: 0
            },
        }
    },
    methods: {
        openAdd() {
            this.codeMainInfo = {
                orderNum: 0,
            }
            this.dialog = true
        },
        openEditDialog(codeMainInfo) {
            this.codeMainInfo = codeMainInfo
            this.dialog = true
        },
        save() {
            this.$refs.add.save()
        },
        search() {
            this.$emit('search', this.params)
        },
        refreshTable() {
            this.$emit('search')
        },
        deleteSelected() {
            this.$emit('deleteSelected')
        },
        cancel() {
            this.dialog = false
        }
    }
}
</script>
<style lang="scss" scoped>

</style>