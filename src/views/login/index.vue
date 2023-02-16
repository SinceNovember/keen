<template>
    <!--begin::Root-->
    <div class="d-flex flex-column flex-root" id="kt_app_root">
        <!--begin::Authentication - Sign-in -->
        <div class="d-flex flex-column flex-lg-row flex-column-fluid">
            <!--begin::Aside-->
            <div class="d-flex flex-lg-row-fluid w-lg-50 bgi-size-cover bgi-position-center login-bg">
                <!--begin::Content-->
                <div class="d-flex flex-column flex-center p-6 p-lg-10 w-100">
                    <!--begin::Logo-->
                    <a href="https://preview.keenthemes.com/keen/demo1/index.html" class="mb-0 mb-lg-20">
                        <img alt="Logo" src="@/assets/media/login/default-white.svg" class="h-40px h-lg-50px">
                    </a>
                    <!--end::Logo-->

                    <!--begin::Image-->
                    <img class="d-none d-lg-block mx-auto w-300px w-lg-75 w-xl-500px mb-10 mb-lg-20"
                        src="@/assets/media/login/auth-screens.png" alt="">
                    <!--end::Image-->

                    <!--begin::Title-->
                    <h1 class="d-none d-lg-block text-white fs-2qx fw-bold text-center mb-7">
                        Fast, Efficient and Productive
                    </h1>
                    <!--end::Title-->

                    <!--begin::Text-->
                    <div class="d-none d-lg-block text-white fs-base text-center">
                        In this kind of post, <a
                            href="https://preview.keenthemes.com/keen/demo1/authentication/layouts/corporate/sign-in.html#"
                            class="opacity-75-hover text-warning fw-semibold me-1">the blogger</a>

                        introduces a person they’ve interviewed <br> and provides some background information about

                        <a href="https://preview.keenthemes.com/keen/demo1/authentication/layouts/corporate/sign-in.html#"
                            class="opacity-75-hover text-warning fw-semibold me-1">the interviewee</a>
                        and their <br> work following this is a transcript of the interview.
                    </div>
                    <!--end::Text-->
                </div>
                <!--end::Content-->
            </div>
            <!--begin::Aside-->

            <!--begin::Body-->
            <div class="d-flex flex-column flex-lg-row-fluid w-lg-50 p-10">
                <!--begin::Form-->
                <div class="d-flex flex-center flex-column flex-lg-row-fluid">
                    <!--begin::Wrapper-->
                    <div class="w-lg-500px p-10">

                        <!--begin::Form-->
                        <form class="form w-100 fv-plugins-bootstrap5 fv-plugins-framework" novalidate="novalidate"
                            id="kt_sign_in_form" data-kt-redirect-url="/keen/demo1/../demo1/index.html"
                            action="https://preview.keenthemes.com/keen/demo1/authentication/layouts/corporate/sign-in.html#">
                            <!--begin::Heading-->
                            <div class="text-center mb-11">
                                <!--begin::Title-->
                                <h1 class="text-dark fw-bolder mb-3">
                                    Sign In
                                </h1>
                                <!--end::Title-->

                                <!--begin::Subtitle-->
                                <div class="text-gray-500 fw-semibold fs-6">
                                    Your Social Campaigns
                                </div>
                                <!--end::Subtitle--->
                            </div>
                            <!--begin::Heading-->

                            <!--begin::Login options-->
                            <div class="row g-3 mb-9">
                                <!--begin::Col-->
                                <div class="col-md-6">
                                    <!--begin::Google link--->
                                    <a href="https://preview.keenthemes.com/keen/demo1/authentication/layouts/corporate/sign-in.html#"
                                        class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
                                        <img alt="Logo" src="@/assets/media/login/google-icon.svg" class="h-15px me-3">
                                        Sign in with Google
                                    </a>
                                    <!--end::Google link--->
                                </div>
                                <!--end::Col-->

                                <!--begin::Col-->
                                <div class="col-md-6">
                                    <!--begin::Google link--->
                                    <a href="https://preview.keenthemes.com/keen/demo1/authentication/layouts/corporate/sign-in.html#"
                                        class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
                                        <img alt="Logo" src="@/assets/media/login/apple-black.svg"
                                            class="theme-light-show h-15px me-3">
                                        <img alt="Logo" src="@/assets/media/login/apple-black-dark.svg"
                                            class="theme-dark-show h-15px me-3">
                                        Sign in with Apple
                                    </a>
                                    <!--end::Google link--->
                                </div>
                                <!--end::Col-->
                            </div>
                            <!--end::Login options-->

                            <!--begin::Separator-->
                            <div class="separator separator-content my-14">
                                <span class="w-125px text-gray-500 fw-semibold fs-7">Or with email</span>
                            </div>
                            <!--end::Separator-->

                            <!--begin::Input group--->
                            <div class="fv-row mb-8 fv-plugins-icon-container">
                                <!--begin::Email-->
                                <input type="text" v-model="loginForm.username" placeholder="账号" name="username"
                                    autocomplete="off" class="form-control bg-transparent">
                                <!--end::Email-->
                                <div class="fv-plugins-message-container invalid-feedback"></div>
                            </div>

                            <!--end::Input group--->
                            <div class="fv-row mb-3 fv-plugins-icon-container">
                                <!--begin::Password-->
                                <input type="password" v-model="loginForm.password" placeholder="密码" name="password"
                                    autocomplete="off" class="form-control bg-transparent">
                                <!--end::Password-->
                                <div class="fv-plugins-message-container invalid-feedback"></div>
                            </div>
                            <!--end::Input group--->

                            <!--begin::Wrapper-->
                            <div class="d-flex flex-stack flex-wrap gap-3 fs-base fw-semibold mb-8">
                                <div></div>

                                <!--begin::Link-->
                                <a href="https://preview.keenthemes.com/keen/demo1/authentication/layouts/corporate/reset-password.html"
                                    class="link-primary">
                                    Forgot Password ?
                                </a>
                                <!--end::Link-->
                            </div>
                            <!--end::Wrapper-->

                            <!--begin::Submit button-->
                            <div class="d-grid mb-10">
                                <a class="btn btn-primary" @click="handleLogin">

                                    <!--begin::Indicator label-->
                                    <span class="indicator-label">
                                        Sign In</span>
                                    <!--end::Indicator label-->

                                    <!--begin::Indicator progress-->
                                    <span class="indicator-progress">
                                        Please wait... <span
                                            class="spinner-border spinner-border-sm align-middle ms-2"></span>
                                    </span>
                                    <!--end::Indicator progress-->
                                </a>
                            </div>
                            <!--end::Submit button-->

                            <!--begin::Sign up-->
                            <div class="text-gray-500 text-center fw-semibold fs-6">
                                Not a Member yet?

                                <a href="https://preview.keenthemes.com/keen/demo1/authentication/layouts/corporate/sign-up.html"
                                    class="link-primary">
                                    Sign up
                                </a>
                            </div>
                            <!--end::Sign up-->
                        </form>
                        <!--end::Form-->
                    </div>
                    <!--end::Wrapper-->
                </div>
                <!--end::Form-->

                <!--begin::Footer-->
                <div class="d-flex flex-center flex-wrap px-5">
                    <!--begin::Links-->
                    <div class="d-flex fw-semibold text-primary fs-base">
                        <a href="https://keenthemes.com/" class="px-5" target="_blank">Terms</a>

                        <a href="https://devs.keenthemes.com/" class="px-5" target="_blank">Plans</a>

                        <a href="https://themes.getbootstrap.com/product/keen-the-ultimate-bootstrap-admin-theme/"
                            class="px-5" target="_blank">Contact Us</a>
                    </div>
                    <!--end::Links-->
                </div>
                <!--end::Footer-->
            </div>
            <!--end::Body-->
        </div>
        <!--end::Authentication - Sign-in-->



    </div>
</template>
<script>
export default {
    name: 'login',
    data() {
        return {
            loginForm: {
                username: "",
                password: "",
                rememberMe: false,
            },
        }
    },
    watch: {
        $route: {
            handler: function (route) {
                const query = route.query;
                if (query) {
                    this.redirect = query.redirect;
                    this.otherQuery = this.getOtherQuery(query);
                }
            },
            immediate: true
        }
    },
    methods: {
        handleLogin() {
            console.log(this.loginForm)
            if (!this.loginForm.username || !this.loginForm.password) {
                this.$Message.warning('账号或密码不能为空')
                return;
            }
            this.$store.dispatch("user/login", this.loginForm).then(() => {
                this.redirect = '/user'
                this.$router.push({
                    path: this.redirect || "/",
                    query: this.otherQuery
                });
            })
        },
        getOtherQuery(query) {
            return Object.keys(query).reduce((acc, cur) => {
                if (cur !== "redirect") {
                    acc[cur] = query[cur];
                }
                return acc;
            }, {});
        }
    }
}
</script>
<style>
.login-bg {
    background-image: url('../../assets/media/login/auth-bg.png');
}
</style>