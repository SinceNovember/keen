<template>
    <!--begin::App layout builder-->
    <div id="kt_app_layout_builder" class="bg-body">
        <!--begin::Card-->
        <div class="card border-0 shadow-none rounded-0 w-100">
            <!--begin::Card header-->
            <div class="card-header bgi-position-y-bottom bgi-position-x-end bgi-size-cover bgi-no-repeat rounded-0 border-0 py-4"
                id="kt_app_layout_builder_header">
                <!--begin::Card title-->
                <h3 class="card-title fs-3 fw-bold text-white flex-column m-0">
                    Keen Builder
                    <small class="text-white opacity-50 fs-7 fw-semibold pt-1">Get your product deeply
                        customized</small>
                </h3>
                <!--end::Card title-->

                <!--begin::Card toolbar-->
                <div class="card-toolbar">
                    <button type="button"
                        class="btn btn-sm btn-icon bg-white bg-opacity-25 btn-color-white p-0 w-20px h-20px rounded-1"
                        id="kt_app_layout_builder_close" @click="closeDrawer">
                        <!--begin::Svg Icon | path: icons/duotune/arrows/arr061.svg-->
                        <span class="svg-icon svg-icon-3"><svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                                xmlns="http://www.w3.org/2000/svg">
                                <rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1"
                                    transform="rotate(-45 6 17.3137)" fill="currentColor" />
                                <rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)"
                                    fill="currentColor" />
                            </svg>

                        </span>
                        <!--end::Svg Icon--> </button>
                </div>
                <!--end::Card toolbar-->
            </div>
            <!--end::Card header-->
            <!--begin::Card body-->
            <div class="card-body position-relative" id="kt_app_layout_builder_body">
                <!--begin::Content-->
                <div id="kt_app_settings_content" class="position-relative scroll-y me-n5 pe-5">

                    <!--begin::Form-->
                    <form class="form" method="POST" id="kt_app_layout_builder_form" action="./keen/demo1/index.php">
                        <input type="hidden" id="kt_app_layout_builder_action" />
                        <!--begin::Card body-->
                        <div class="card-body p-0">
                            <!--begin::Form group-->
                            <div class="form-group">
                                <!--begin::Heading-->
                                <div class="mb-6">
                                    <h4 class="fw-bold text-dark">Theme Mode</h4>
                                    <div class="fw-semibold text-muted fs-7 d-block lh-1">
                                        Enjoy Dark & Light modes.

                                        <a class="fw-semibold"
                                            href="https://preview.keenthemes.com/html./keen/docs/getting-started/dark-mode"
                                            target="_blank">See docs</a>
                                    </div>
                                </div>
                                <!--end::Heading-->

                                <!--begin::Options-->
                                <div class="row" data-kt-buttons="true"
                                    data-kt-buttons-target=".form-check-image,.form-check-input">
                                    <!--begin::Col-->
                                    <div class="col-6">
                                        <!--begin::Option-->
                                        <label class="form-check-image" :class="{ 'active': settings.theme == 'light' }"
                                            @click="changeTheme('light')">
                                            <!--begin::Image-->
                                            <div class="form-check-wrapper">
                                                <img src="@/assets/media/misc/layout/demo1-light.png" class="mw-100"
                                                    alt="" />
                                            </div>
                                            <div class="form-check form-check-custom">
                                                <el-radio v-model="settings.theme" label="light">
                                                    <span class="fw-bold text-gray-700">Light</span>
                                                </el-radio>
                                            </div>
                                            <!--end::Check-->
                                        </label>
                                        <!--end::Option-->
                                    </div>
                                    <!--end::Col-->
                                    <!--begin::Col-->
                                    <div class="col-6">
                                        <!--begin::Option-->
                                        <label class="form-check-image" :class="{ 'active': settings.theme == 'dark' }"
                                            @click="changeTheme('dark')">
                                            <!--begin::Image-->
                                            <div class="form-check-wrapper">
                                                <img src="@/assets/media/misc/layout/demo1-dark.png" class="mw-100"
                                                    alt="" />
                                            </div>
                                            <!--end::Image-->

                                            <div class="form-check form-check-custom">
                                                <el-radio v-model="settings.theme" label="dark">
                                                    <span class="fw-bold text-gray-700">Dark</span>
                                                </el-radio>
                                            </div>
                                        </label>
                                        <!--end::Option-->
                                    </div>
                                    <!--end::Col-->

                                </div>
                                <!--end::Options-->
                            </div>
                            <!--end::Form group-->

                            <!--begin::Separator-->
                            <div class="separator separator-dashed my-5"></div>
                            <!--end::Separator-->

                            <!--begin::Form group-->
                            <div class="form-group">
                                <!--begin::Heading-->
                                <div class="d-flex flex-column mb-4">
                                    <h4 class="fw-bold text-dark">Width Mode</h4>
                                    <div class="fs-7 fw-semibold text-muted">Page width options</div>
                                </div>

                                <div class="d-flex">
                                    <el-radio-group v-model="settings.widthMode.name" @change="changeWidthMode">
                                        <el-radio label="default"><span
                                                class="text-gray-700 fw-bold">Default</span></el-radio>
                                        <el-radio label="fluid"><span
                                                class="text-gray-700 fw-bold">Fluid</span></el-radio>
                                        <el-radio label="fixed"><span
                                                class="text-gray-700 fw-bold">Fixed</span></el-radio>
                                    </el-radio-group>
                                </div>
                            </div>

                            <!--begin::Separator-->
                            <div class="separator separator-dashed my-5"></div>
                            <!--end::Separator-->


                            <!--begin::Form group-->
                            <div class="form-group">
                                <!--begin::Heading-->
                                <div class="d-flex flex-column mb-4">
                                    <h4 class="fw-bold text-dark">Content</h4>
                                    <div class="fs-7 fw-semibold text-muted">Header content type</div>
                                </div>
                                <!--end::Heading-->

                                <!--begin::Options-->
                                <div class="d-flex">
                                    <el-radio-group v-model="settings.header.content" @change="changeHeaderContent">
                                        <el-radio label="menu"><span
                                                class="text-gray-700 fw-bold">Menu</span></el-radio>
                                        <el-radio label="pageTitle"><span class="text-gray-700 fw-bold">Page
                                                Title</span></el-radio>
                                    </el-radio-group>
                                </div>
                                <!--end::Options-->
                            </div>
                            <!--end::Form group-->

                            <!--begin::Separator-->
                            <div class="separator separator-dashed my-5"></div>
                            <!--end::Separator-->



                            <!--begin::Form group-->
                            <div class="form-group">
                                <!--begin::Heading-->
                                <div class="mb-6">
                                    <h4 class="fw-semibold text-dark">Layouts</h4>
                                    <span class="fw-semibold text-muted fs-7 lh-1">
                                        4 main layouts.
                                    </span>
                                    <a href="./keen/demo1/../demo1/layout-builder.html"
                                        class="fw-semibold text-primary">More layout
                                        options</a>
                                </div>
                                <!--end::Heading-->

                                <!--begin::Options-->
                                <div class="row gy-3">
                                    <!--begin::Col-->
                                    <div class="col-6">
                                        <!--begin::Option-->
                                        <label class="form-check-image" @click="changeLayout('dark-sidebar')"
                                            :class="{ 'active': settings.layout.color == 'dark' && settings.layout.type == 'sidebar' }">
                                            <!--begin::Image-->
                                            <div class="form-check-wrapper">
                                                <img src="@/assets/media/misc/layout/dark-sidebar.png" class="mw-100"
                                                    alt="" />
                                            </div>

                                            <div class="form-check form-check-custom ">
                                                <el-radio v-model="settings.layout.color + '-' + settings.layout.type"
                                                    label="dark-sidebar">
                                                    <span class="fw-bold text-gray-700">Dark Sidebar </span>
                                                </el-radio>
                                            </div>
                                            <!--end::Check-->
                                        </label>
                                        <!--end::Option-->
                                    </div>
                                    <!--end::Col-->
                                    <!--begin::Col-->
                                    <div class="col-6">
                                        <!--begin::Option-->
                                        <label class="form-check-image " @click="changeLayout('light-sidebar')"
                                            :class="{ 'active': settings.layout.color == 'light' && settings.layout.type == 'sidebar' }">
                                            <!--begin::Image-->
                                            <div class="form-check-wrapper">
                                                <img src="@/assets/media/misc/layout/light-sidebar.png" class="mw-100"
                                                    alt="" />
                                            </div>
                                            <!--end::Image-->

                                            <!--begin::Check-->

                                            <div class="form-check form-check-custom ">
                                                <el-radio v-model="settings.layout.color + '-' + settings.layout.type"
                                                    label="light-sidebar">
                                                    <span class="fw-bold text-gray-700">Light Sidebar </span>
                                                </el-radio>
                                            </div>
                                            <!--end::Check-->
                                        </label>
                                        <!--end::Option-->
                                    </div>
                                    <!--end::Col-->
                                    <!--begin::Col-->
                                    <div class="col-6">
                                        <!--begin::Option-->
                                        <label class="form-check-image" @click="changeLayout('dark-header')"
                                            :class="{ 'active': settings.layout.color == 'dark' && settings.layout.type == 'header' }">
                                            <!--begin::Image-->
                                            <div class="form-check-wrapper">
                                                <img src="@/assets/media/misc/layout/dark-header.png" class="mw-100"
                                                    alt="" />
                                            </div>
                                            <!--end::Image-->

                                            <!--begin::Check-->

                                            <div class="form-check form-check-custom ">
                                                <el-radio v-model="settings.layout.color + '-' + settings.layout.type"
                                                    label="dark-header">
                                                    <span class="fw-bold text-gray-700">Dark Header </span>
                                                </el-radio>
                                            </div>
                                            <!--end::Check-->
                                        </label>
                                        <!--end::Option-->
                                    </div>
                                    <!--end::Col-->
                                    <!--begin::Col-->
                                    <div class="col-6">
                                        <label class="form-check-image " @click="changeLayout('light-header')"
                                            :class="{ 'active': settings.layout.color == 'light' && settings.layout.type == 'header' }">
                                            <div class="form-check-wrapper">
                                                <img src="@/assets/media/misc/layout/light-header.png" class="mw-100"
                                                    alt="" />
                                            </div>
                                            <div class="form-check form-check-custom ">
                                                <el-radio v-model="settings.layout.color + '-' + settings.layout.type"
                                                    label="light-header">
                                                    <span class="fw-bold text-gray-700">Light Header </span>
                                                </el-radio>
                                            </div>
                                        </label>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!--end::Card body-->


        </div>
        <!--end::Card-->
    </div>
    <!--end::App layout builder-->
</template>
<script>
import { mapGetters } from "vuex"
export default {
    name: "LayoutSettings",
    computed: {
        ...mapGetters(["settings"]),
    },
    date() {
        return {
        }
    },
    methods: {
        changeTheme(val) {
            this.$store.dispatch("app/changeTheme", val)
        },
        changeLayout(val) {
            this.$store.dispatch("app/changeLayout", val)
        },
        changeWidthMode(val) {
            this.$store.dispatch("app/changeWidthMode", val)
        },
        changeHeaderContent(val) {
            this.$store.dispatch("app/changeHeaderContent", val)
        },
        closeDrawer() {
            this.$emit('closeDrawer')
        }
    }
}
</script>