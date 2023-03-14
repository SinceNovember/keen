<template>
    <el-card shadow="nerve">
        <!--begin::Card header-->
        <div slot="header" class="cursor-pointer  d-flex flex-stack">
            <!--begin::Card title-->
            <div class="card-title m-0">
                <h3 class="fw-bold m-0">Profile Details</h3>
            </div>
            <!--end::Card title-->
            <!--begin::Action-->
            <a  v-if="isCurrent" class="btn btn-sm btn-primary align-self-center" @click="toSettings" >Edit
                Profile</a>
            <!--end::Action-->
        </div>
        <!--begin::Card header-->

        <!--begin::Card body-->
        <div class="p-9">
            <!--begin::Row-->
            <div class="row mb-7">
                <!--begin::Label-->
                <label class="col-lg-4 fw-semibold text-gray-600">昵称</label>
                <!--end::Label-->

                <!--begin::Col-->
                <div class="col-lg-8">
                    <span class="fw-bold fs-6 text-gray-600">{{ userInfo.nickname }}</span>
                </div>
                <!--end::Col-->
            </div>
            <!--end::Row-->
            <!--begin::Row-->
            <div class="row mb-7">
                <!--begin::Label-->
                <label class="col-lg-4 fw-semibold text-gray-600">用户名</label>
                <!--end::Label-->

                <!--begin::Col-->
                <div class="col-lg-8">
                    <span class="fw-bold fs-6 text-gray-600">{{ userInfo.username }}</span>
                </div>
                <!--end::Col-->
            </div>
            <!--end::Row-->



            <!--begin::Input group-->
            <div class="row mb-7">
                <!--begin::Label-->
                <label class="col-lg-4 fw-semibold text-gray-600">
                    手机号
                </label>
                <!--end::Label-->

                <!--begin::Col-->
                <div class="col-lg-8 d-flex align-items-center">
                    <span class="fw-bold fs-6 text-gray-600 me-2">{{ userInfo.mobile }}</span>

                </div>
                <!--end::Col-->
            </div>
            <!--end::Input group-->

            <!--begin::Input group-->
            <div class="row mb-7">
                <!--begin::Label-->
                <label class="col-lg-4 fw-semibold text-gray-600">邮箱</label>
                <!--end::Label-->

                <!--begin::Col-->
                <div class="col-lg-8">
                    <a href="#" class="fw-bold fs-6 text-gray-600 text-hover-primary">{{ userInfo.email }}</a>
                </div>
                <!--end::Col-->
            </div>
            <!--end::Input group-->

            <!--begin::Input group-->
            <div class="row mb-7">
                <!--begin::Label-->
                <label class="col-lg-4 fw-semibold text-gray-600">
                    性别
                </label>
                <!--end::Label-->

                <!--begin::Col-->
                <div class="col-lg-8">
                    <span class="fw-bold fs-6 text-gray-600">{{ userInfo.sex | SexFilter }}</span>
                </div>
                <!--end::Col-->
            </div>
            <!--end::Input group-->

            <!--begin::Input group-->
            <div class="row mb-7">
                <!--begin::Label-->
                <label class="col-lg-4 fw-semibold text-gray-600">
                    状态
                </label>
                <!--end::Label-->

                <!--begin::Col-->
                <div class="col-lg-8">
                    <span class="badge " :class="userInfo.status == 'VALID' ? 'badge-success' : 'badge-danger'">{{
                        userInfo.status | StatusTypeFilter
                    }}</span>

                    <!-- <span class="fw-bold fs-6 text-gray-800">启用</span> -->
                </div>
                <!--end::Col-->
            </div>
            <!--end::Input group-->

            <!--begin::Input group-->
            <div class="row mb-7">
                <!--begin::Label-->
                <label class="col-lg-4 fw-semibold text-gray-600">部门</label>
                <!--begin::Label-->

                <!--begin::Label-->
                <div class="col-lg-8">
                    <span class="fw-bold fs-6 text-gray-600">{{ userInfo.deptName }}</span>
                </div>
                <!--begin::Label-->
            </div>
            <!--end::Input group-->

            <!--begin::Input group-->
            <div class="row mb-7">
                <!--begin::Label-->
                <label class="col-lg-4 fw-semibold text-gray-600">角色</label>
                <!--end::Label-->

                <!--begin::Col-->
                <div class="col-lg-8">
                    <span class="fw-bold fs-6 text-gray-600">{{ userInfo.roleNames }}</span>
                </div>
                <!--end::Col-->
            </div>
            <!--end::Input group-->
        </div>
        <!--end::Card body-->
    </el-card>
</template>
<script>
export default {
    name: 'Overview',
    props: {
        userInfo: Object,
        isCurrent: Boolean
    },
    data() {
        return {
        }
    },
    methods: {
        toSettings() {
            this.$router.push({ path: 'overview' })
        }
    }
}
</script>
<style lang="scss" scoped>

</style>