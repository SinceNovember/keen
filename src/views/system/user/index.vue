<template>
    <div class="card">
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="Main" name="first">
                <div class="tab-content pt-3">
                    <div class="tab-pane active show" id="kt_builder_main" role="tabpanel">
                        <div class="row">
                            <div class="col-lg-6 pe-lg-15">
                                <div class="form-group">
                                    <div class="mb-6">
                                        <h4 class="fw-semibold text-dark">Theme Mode</h4>
                                        <div class="fw-semibold text-muted fs-7 d-block lh-1">
                                            Enjoy Dark &amp; Light modes.

                                            <a class="" href="@/assets/media/misc/layout/demo1-light.png"
                                                target="_blank">See docs</a>
                                        </div>
                                    </div>
                                    <div class="row" data-kt-buttons="true"
                                        data-kt-buttons-target=".form-check-image,.form-check-input"
                                        data-kt-initialized="1">
                                        <div class="col-6">
                                            <label class="form-check-image form-check-success">
                                                <div class="form-check-wrapper">
                                                    <img src="@/assets/media/misc/layout/demo1-light.png" class="mw-100"
                                                        alt="">
                                                </div>
                                                <div
                                                    class="form-check form-check-custom form-check-solid form-check-sm form-check-success">
                                                    <input class="form-check-input" type="radio" value="light"
                                                        name="theme_mode" id="kt_layout_builder_theme_mode_light">
                                                    <div class="form-check-label text-gray-700">
                                                        Light </div>
                                                </div>
                                            </label>
                                        </div>
                                        <div class="col-6">
                                            <label class="form-check-image form-check-success active">
                                                <div class="form-check-wrapper">
                                                    <img src="@/assets/media/misc/layout/demo1-dark.png" class="mw-100"
                                                        alt="">
                                                </div>
                                                <div
                                                    class="form-check form-check-custom form-check-solid form-check-sm form-check-success">
                                                    <input class="form-check-input" type="radio" value="dark"
                                                        name="theme_mode" id="kt_layout_builder_theme_mode_dark">

                                                    <div class="form-check-label text-gray-700">
                                                        Dark </div>
                                                </div>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="separator separator-dashed my-6"></div>
                        <div class="form-group d-flex flex-stack">
                            <div class="d-flex flex-column">
                                <h4 class="fw-semibold text-dark">RTL Mode</h4>
                                <div class="fs-7 fw-semibold text-muted">
                                    Change Language Direction.

                                    <a class="" href="https://preview.keenthemes.com/html/keen/docs/getting-started/rtl"
                                        target="_blank">See docs</a>
                                </div>
                            </div>
                            <div class="d-flex justify-content-end">
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-switch">
                                    <input type="hidden" value="false" name="layout-builder[layout][app][general][rtl]">
                                    <input class="form-check-input w-45px h-30px" type="checkbox" value="true"
                                        name="layout-builder[layout][app][general][rtl]" id="kt_builder_rtl">
                                </div>
                            </div>
                        </div>
                        <div class="separator separator-dashed my-6"></div>

                        <!--begin::Form group-->
                        <div class="form-group d-flex flex-stack">
                            <!--begin::Heading-->
                            <div class="d-flex flex-column">
                                <h4 class="fw-semibold text-dark">Width Mode</h4>
                                <div class="fs-7 fw-semibold text-muted">Page width options</div>
                            </div>
                            <!--end::Heading-->

                            <!--begin::Options-->
                            <div class="d-flex">
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-success form-check-solid form-check-sm me-7">
                                    <input class="form-check-input" type="radio" checked="" value="default"
                                        id="kt_builder_page_width_default"
                                        name="layout-builder[layout][app][general][page-width]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-semibold text-nowrap"
                                        for="kt_builder_page_width_default">
                                        Default </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-success form-check-solid form-check-sm me-7">
                                    <input class="form-check-input" type="radio" value="fluid"
                                        id="kt_builder_page_width_fluid"
                                        name="layout-builder[layout][app][general][page-width]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-semibold text-nowrap"
                                        for="kt_builder_page_width_fluid">
                                        Fluid </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-success form-check-solid form-check-sm me-7">
                                    <input class="form-check-input" type="radio" value="fixed"
                                        id="kt_builder_page_width_fixed"
                                        name="layout-builder[layout][app][general][page-width]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-semibold text-nowrap"
                                        for="kt_builder_page_width_fixed">
                                        Fixed </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                            </div>
                            <!--end::Options-->
                        </div>
                        <!--end::Form group-->

                        <!--begin::Separator-->
                        <div class="separator separator-dashed my-6"></div>
                        <!--end::Separator-->

                        <!--begin::Form group-->
                        <div class="form-group d-flex flex-stack">
                            <!--begin::Heading-->
                            <div class="d-flex flex-column">
                                <h4 class="fw-semibold text-dark">Menu Icon</h4>
                                <div class="fs-7 fw-semibold text-muted">Sidebar menu icon options</div>
                            </div>
                            <!--end::Heading-->

                            <!--begin::Option-->
                            <div class="d-flex justify-content-end">
                                <!--begin::Check-->
                                <div class="form-check form-check-custom form-check-success form-check-solid me-7">
                                    <input class="form-check-input w-20px h-20px" type="radio" checked="" value="svg"
                                        id="kt_builder_icon_svg"
                                        name="layout-builder[layout][app][sidebar][default][menu][icon-type]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-semibold text-nowrap"
                                        for="kt_builder_icon_svg">
                                        SVG Duotone </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                                <!--begin::Check-->
                                <div class="form-check form-check-custom form-check-success form-check-solid me-7">
                                    <input class="form-check-input w-20px h-20px" type="radio" value="font"
                                        id="kt_builder_icon_font"
                                        name="layout-builder[layout][app][sidebar][default][menu][icon-type]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-semibold text-nowrap"
                                        for="kt_builder_icon_font">
                                        Font Icons </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                            </div>
                            <!--end::Option-->
                        </div>
                        <!--end::Form group-->

                        <!--begin::Separator-->
                        <div class="separator separator-dashed my-6"></div>
                        <!--end::Separator-->

                        <!--begin::Form group-->
                        <div class="form-group d-flex flex-stack">
                            <!--begin::Heading-->
                            <div class="d-flex flex-column">
                                <h4 class="fw-semibold text-dark">Page Loader</h4>
                                <div class="fs-7 fw-semibold text-muted">Display page loading indicator</div>
                            </div>
                            <!--end::Heading-->

                            <!--begin::Option-->
                            <div class="d-flex justify-content-end">
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-success form-check-solid form-check-sm me-7">
                                    <input class="form-check-input" type="radio" checked="" value="none"
                                        id="kt_builder_page_loader_type_none"
                                        name="layout-builder[layout][app][page-loader][type]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-semibold text-nowrap"
                                        for="kt_builder_page_loader_type_none">
                                        None </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-success form-check-solid form-check-sm me-7">
                                    <input class="form-check-input" type="radio" value="default"
                                        id="kt_builder_page_loader_type_default"
                                        name="layout-builder[layout][app][page-loader][type]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-semibold text-nowrap"
                                        for="kt_builder_page_loader_type_default">
                                        Default </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-success form-check-solid form-check-sm me-7">
                                    <input class="form-check-input" type="radio" value="spinner-message"
                                        id="kt_builder_page_loader_type_spinner-message"
                                        name="layout-builder[layout][app][page-loader][type]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-semibold text-nowrap"
                                        for="kt_builder_page_loader_type_spinner-message">
                                        Message </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-success form-check-solid form-check-sm me-7">
                                    <input class="form-check-input" type="radio" value="spinner-logo"
                                        id="kt_builder_page_loader_type_spinner-logo"
                                        name="layout-builder[layout][app][page-loader][type]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-semibold text-nowrap"
                                        for="kt_builder_page_loader_type_spinner-logo">
                                        Logo </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                            </div>
                            <!--end::Option-->
                        </div>
                        <!--end::Form group-->
                    </div>
                    <!--end::Tab pane-->

                    <!--begin::Tab pane-->
                    <div class="tab-pane" id="kt_builder_layout" role="tabpanel">
                        <!--begin::Heading-->
                        <div class="mb-6">
                            <h4 class="fw-semibold text-dark">Layouts</h4>
                            <span class="fw-semibold text-muted fs-7 lh-1">
                                4 main layout options.
                            </span>
                        </div>
                        <!--end::Heading-->

                        <!--begin::Options-->
                        <div class="row gy-5" data-kt-buttons="true"
                            data-kt-buttons-target=".form-check-image:not(.disabled),.form-check-input:not([disabled])"
                            data-kt-initialized="1">
                            <!--begin::Col-->
                            <div class="col-lg-3">
                                <!--begin::Option-->
                                <label class="form-check-image form-check-success active  ">
                                    <!--begin::Image-->
                                    <div class="form-check-wrapper">
                                        <img src="/keen/demo1/assets/media/misc/layout/dark-sidebar.png" class="mw-100"
                                            alt="">
                                    </div>
                                    <!--end::Image-->

                                    <!--begin::Check-->
                                    <div
                                        class="form-check form-check-custom form-check-success form-check-sm form-check-solid">
                                        <input class="form-check-input" type="radio" checked="" value="dark-sidebar"
                                            name="layout-builder[layout][app][general][layout]">

                                        <!--begin::Label-->
                                        <div class="form-check-label text-gray-800">
                                            Dark Sidebar </div>
                                        <!--end::Label-->
                                    </div>
                                    <!--end::Check-->
                                </label>
                                <!--end::Option-->
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-lg-3">
                                <!--begin::Option-->
                                <label class="form-check-image form-check-success   ">
                                    <!--begin::Image-->
                                    <div class="form-check-wrapper">
                                        <img src="/keen/demo1/assets/media/misc/layout/light-sidebar.png" class="mw-100"
                                            alt="">
                                    </div>
                                    <!--end::Image-->

                                    <!--begin::Check-->
                                    <div
                                        class="form-check form-check-custom form-check-success form-check-sm form-check-solid">
                                        <input class="form-check-input" type="radio" value="light-sidebar"
                                            name="layout-builder[layout][app][general][layout]">

                                        <!--begin::Label-->
                                        <div class="form-check-label text-gray-800">
                                            Light Sidebar </div>
                                        <!--end::Label-->
                                    </div>
                                    <!--end::Check-->
                                </label>
                                <!--end::Option-->
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-lg-3">
                                <!--begin::Option-->
                                <label class="form-check-image form-check-success   ">
                                    <!--begin::Image-->
                                    <div class="form-check-wrapper">
                                        <img src="/keen/demo1/assets/media/misc/layout/dark-header.png" class="mw-100"
                                            alt="">
                                    </div>
                                    <!--end::Image-->

                                    <!--begin::Check-->
                                    <div
                                        class="form-check form-check-custom form-check-success form-check-sm form-check-solid">
                                        <input class="form-check-input" type="radio" value="dark-header"
                                            name="layout-builder[layout][app][general][layout]">

                                        <!--begin::Label-->
                                        <div class="form-check-label text-gray-800">
                                            Dark Header </div>
                                        <!--end::Label-->
                                    </div>
                                    <!--end::Check-->
                                </label>
                                <!--end::Option-->
                            </div>
                            <!--end::Col-->
                            <!--begin::Col-->
                            <div class="col-lg-3">
                                <!--begin::Option-->
                                <label class="form-check-image form-check-success   ">
                                    <!--begin::Image-->
                                    <div class="form-check-wrapper">
                                        <img src="/keen/demo1/assets/media/misc/layout/light-header.png" class="mw-100"
                                            alt="">
                                    </div>
                                    <!--end::Image-->

                                    <!--begin::Check-->
                                    <div
                                        class="form-check form-check-custom form-check-success form-check-sm form-check-solid">
                                        <input class="form-check-input" type="radio" value="light-header"
                                            name="layout-builder[layout][app][general][layout]">

                                        <!--begin::Label-->
                                        <div class="form-check-label text-gray-800">
                                            Light Header </div>
                                        <!--end::Label-->
                                    </div>
                                    <!--end::Check-->
                                </label>
                                <!--end::Option-->
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Options-->
                    </div>
                    <!--end::Tab pane-->

                    <!--begin::Tab pane-->
                    <div class="tab-pane" id="kt_builder_sidebar" role="tabpanel">

                        <!--begin::Form group-->
                        <div class="form-group d-flex flex-stack d-none">
                            <!--begin::Heading-->
                            <div class="d-flex flex-column">
                                <h4 class="fw-bold text-dark">Fixed</h4>
                                <div class="fs-7 fw-semibold text-muted">
                                    Fixed sidebar mode
                                </div>
                            </div>
                            <!--end::Heading-->

                            <!--begin::Option-->
                            <div class="d-flex justify-content-end">
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-switch">
                                    <input type="hidden" value="false"
                                        name="layout-builder[layout][app][sidebar][default][fixed][desktop]">
                                    <input class="form-check-input w-45px h-30px" type="checkbox" checked=""
                                        value="true"
                                        name="layout-builder[layout][app][sidebar][default][fixed][desktop]"
                                        id="kt_builder_sidebar_fixed_desktop">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_sidebar_fixed_desktop"></label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                            </div>
                            <!--end::Option-->
                        </div>
                        <!--end::Form group-->

                        <!--begin::Separator-->
                        <div class="separator separator-dashed my-6 d-none"></div>
                        <!--end::Separator-->


                        <!--begin::Form group-->
                        <div class="form-group d-flex flex-stack">
                            <!--begin::Heading-->
                            <div class="d-flex flex-column">
                                <h4 class="fw-bold text-dark">Minimize</h4>
                                <div class="fs-7 fw-semibold text-muted">
                                    Sidebar minimize mode
                                </div>
                            </div>
                            <!--end::Heading-->

                            <!--begin::Option-->
                            <div class="d-flex align-items-center justify-content-end">
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-switch">
                                    <input type="hidden" value="false"
                                        name="layout-builder[layout][app][sidebar][default][minimize][desktop][enabled]">
                                    <input class="form-check-input w-45px h-30px" type="checkbox" checked=""
                                        value="true"
                                        name="layout-builder[layout][app][sidebar][default][minimize][desktop][enabled]"
                                        id="kt_builder_sidebar_minimize_desktop_enabled">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_sidebar_minimize_desktop_enabled" data-bs-toggle="tooltip"
                                        data-bs-original-title="Enable Sidebar minimize toggle"
                                        data-kt-initialized="1">Minimize Toggle</label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->

                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-switch ms-10">
                                    <input type="hidden" value="false"
                                        name="layout-builder[layout][app][sidebar][default][minimize][desktop][hoverable]">
                                    <input class="form-check-input w-45px h-30px" type="checkbox" value="true"
                                        name="layout-builder[layout][app][sidebar][default][minimize][desktop][hoverable]"
                                        id="kt_builder_sidebar_minimize_desktop_hoverable">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_sidebar_minimize_desktop_hoverable" data-bs-toggle="tooltip"
                                        data-bs-original-title="Expand minimized sidebar on hover"
                                        data-kt-initialized="1">Hoverable</label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->

                                <!--begin::Check info-->
                                <i class="fas fa-exclamation-circle text-gray-400 ms-2 fs-7" data-bs-toggle="popover"
                                    data-bs-placement="top" data-bs-html="true" data-bs-trigger="hover focus"
                                    data-bs-content="Add <code>data-kt-app-sidebar-hoverable=&quot;on&quot;</code> attribute to the body element to enable the hoverable sidebar menu."
                                    data-kt-initialized="1">
                                </i>
                                <!--end::Check info-->

                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-switch ms-10">
                                    <input type="hidden" value="false"
                                        name="layout-builder[layout][app][sidebar][default][minimize][desktop][default]">
                                    <input class="form-check-input w-45px h-30px" type="checkbox" value="true"
                                        name="layout-builder[layout][app][sidebar][default][minimize][desktop][default]"
                                        id="kt_builder_sidebar_minimize_desktop_default">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_sidebar_minimize_desktop_default" data-bs-toggle="tooltip"
                                        data-bs-original-title="Set Sidebar minimized by default"
                                        data-kt-initialized="1">Default Minimized</label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->

                                <!--begin::Check info-->
                                <i class="fas fa-exclamation-circle text-gray-400 ms-2 fs-7" data-bs-toggle="popover"
                                    data-bs-placement="top" data-bs-html="true" data-bs-trigger="hover focus"
                                    data-bs-content="<ul class=&quot;px-5 py-0 m-0&quot;>
                <li class=&quot;py-2&quot;>Add <code>data-kt-app-sidebar-minimize=&quot;on&quot;</code> attribute on the body element.</li>
                <li class=&quot;py-2&quot;>Add <code>active</code> class on the toggle element.</li>
                <li class=&quot;py-2&quot;>Set <code>data-kt-toggle-state=&quot;active&quot;</code> attribute on the toggle element.</li>
            </ul>" data-kt-initialized="1">
                                </i>
                                <!--end::Check info-->
                            </div>
                            <!--end::Option-->
                        </div>
                        <!--end::Form group-->
                    </div>
                    <!--end::Tab pane-->

                    <!--begin::Tab pane-->
                    <div class="tab-pane" id="kt_builder_header" role="tabpanel">

                        <!--begin::Form group-->
                        <div class="form-group d-flex flex-stack">
                            <!--begin::Heading-->
                            <div class="d-flex flex-column">
                                <h4 class="fw-bold text-dark">Fixed</h4>
                                <div class="fs-7 fw-semibold text-muted">
                                    Fixed toolbar mode
                                </div>
                            </div>
                            <!--end::Heading-->

                            <!--begin::Option-->
                            <div class="d-flex justify-content-end">
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-switch me-10">
                                    <input type="hidden" value="false"
                                        name="layout-builder[layout][app][header][default][fixed][desktop]">
                                    <input class="form-check-input w-45px h-30px" type="checkbox" checked=""
                                        value="true" name="layout-builder[layout][app][header][default][fixed][desktop]"
                                        id="kt_builder_header_fixed_desktop">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_header_fixed_desktop">Desktop Mode</label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->

                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-switch">
                                    <input type="hidden" value="false"
                                        name="layout-builder[layout][app][header][default][fixed][mobile]">
                                    <input class="form-check-input w-45px h-30px" type="checkbox" value="true"
                                        name="layout-builder[layout][app][header][default][fixed][mobile]"
                                        id="kt_builder_header_fixed_mobile">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_header_fixed_mobile">Mobile Mode</label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                            </div>
                            <!--end::Option-->
                        </div>
                        <!--end::Form group-->

                        <!--begin::Separator-->
                        <div class="separator separator-dashed my-6"></div>
                        <!--end::Separator-->

                        <!--begin::Form group-->
                        <div class="form-group d-flex flex-stack">
                            <!--begin::Heading-->
                            <div class="d-flex flex-column">
                                <h4 class="fw-bold text-dark">Content</h4>
                                <div class="fs-7 fw-semibold text-muted">
                                    Header content type
                                </div>
                            </div>
                            <!--end::Heading-->

                            <!--begin::Option-->
                            <div class="d-flex justify-content-end">
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-success form-check-solid form-check-sm ms-10">
                                    <input class="form-check-input" type="radio" checked="" value="menu"
                                        id="kt_builder_header_content_menu"
                                        name="layout-builder[layout][app][header][default][content]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold text-nowrap"
                                        for="kt_builder_header_content_menu">
                                        Menu </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-success form-check-solid form-check-sm ms-10">
                                    <input class="form-check-input" type="radio" value="page-title"
                                        id="kt_builder_header_content_page-title"
                                        name="layout-builder[layout][app][header][default][content]">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold text-nowrap"
                                        for="kt_builder_header_content_page-title">
                                        Page Title </label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                            </div>
                            <!--end::Option-->
                        </div>
                        <!--end::Form group-->

                        <!--begin::Separator-->
                        <div class="separator separator-dashed my-6"></div>
                        <!--end::Separator-->

                        <!--begin::Form group-->
                        <div class="form-group d-flex flex-stack">
                            <!--begin::Heading-->
                            <div class="d-flex flex-column">
                                <h4 class="fw-bold text-dark">Page Title</h4>
                                <div class="fs-7 fw-semibold text-muted">
                                    Page title layout options
                                </div>
                            </div>
                            <!--end::Heading-->

                            <!--begin::Option-->
                            <div class="d-flex justify-content-end">
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-check-sm me-10">
                                    <input class="form-check-input" type="radio" checked="" value="column"
                                        name="layout-builder[layout][app][page-title][direction]"
                                        id="kt_builder_page_title_direction_column">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_page_title_direction_column" data-bs-toggle="tooltip"
                                        data-bs-original-title="Page title, description and breadcrumbs are stacked"
                                        data-kt-initialized="1">Column</label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->

                                <!--begin::Check-->
                                <div class="form-check form-check-custom form-check-solid form-check-success">
                                    <input class="form-check-input" type="radio" value="row"
                                        name="layout-builder[layout][app][page-title][direction]"
                                        id="kt_builder_page_title_direction_row">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_page_title_direction_row" data-bs-toggle="tooltip"
                                        data-bs-original-title="Page title, description and breadcrumbs are laid out&nbsp;in&nbsp;a&nbsp;line"
                                        data-kt-initialized="1">Row</label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                            </div>
                            <!--end::Option-->
                        </div>
                        <!--end::Form group-->
                    </div>
                    <!--end::Tab pane-->

                    <!--begin::Tab pane-->
                    <div class="tab-pane " id="kt_builder_toolbar" role="tabpanel">
                        <!--begin::Form group-->
                        <div class="form-group d-flex flex-stack">
                            <!--begin::Heading-->
                            <div class="d-flex flex-column">
                                <h4 class="fw-bold text-dark">Display</h4>
                                <div class="fs-7 fw-semibold text-muted">
                                    Enable or disable Toolbar
                                </div>
                            </div>
                            <!--end::Heading-->

                            <!--begin::Option-->
                            <div class="d-flex justify-content-end">
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-switch">
                                    <input type="hidden" value="false"
                                        name="layout-builder[layout][app][toolbar][display]">
                                    <input class="form-check-input w-45px h-30px" type="checkbox" checked=""
                                        value="true" name="layout-builder[layout][app][toolbar][display]"
                                        id="kt_builder_toolbar_display">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_toolbar_display"></label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                            </div>
                            <!--end::Option-->
                        </div>
                        <!--end::Form group-->

                        <!--begin::Separator-->
                        <div class="separator separator-dashed my-6"></div>
                        <!--end::Separator-->

                        <!--begin::Form group-->
                        <div class="form-group d-flex flex-stack">
                            <!--begin::Heading-->
                            <div class="d-flex flex-column">
                                <h4 class="fw-bold text-dark">Fixed</h4>
                                <div class="fs-7 fw-semibold text-muted">
                                    Fixed toolbar mode
                                </div>
                            </div>
                            <!--end::Heading-->

                            <!--begin::Option-->
                            <div class="d-flex justify-content-end">
                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-switch me-10">
                                    <input type="hidden" value="false"
                                        name="layout-builder[layout][app][toolbar][fixed][desktop]">
                                    <input class="form-check-input w-45px h-30px" type="checkbox" value="true"
                                        name="layout-builder[layout][app][toolbar][fixed][desktop]"
                                        id="kt_builder_toolbar_fixed_desktop">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_toolbar_fixed_desktop">Desktop Mode</label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->

                                <!--begin::Check-->
                                <div
                                    class="form-check form-check-custom form-check-solid form-check-success form-switch">
                                    <input type="hidden" value="false"
                                        name="layout-builder[layout][app][toolbar][fixed][mobile]">
                                    <input class="form-check-input w-45px h-30px" type="checkbox" value="true"
                                        name="layout-builder[layout][app][toolbar][fixed][mobile]"
                                        id="kt_builder_toolbar_fixed_mobile">

                                    <!--begin::Label-->
                                    <label class="form-check-label text-gray-700 fw-bold"
                                        for="kt_builder_toolbar_fixed_mobile">Mobile Mode</label>
                                    <!--end::Label-->
                                </div>
                                <!--end::Check-->
                            </div>
                            <!--end::Option-->
                        </div>
                        <!--end::Form group-->
                    </div>
                    <!--end::Tab pane-->
                </div>

            </el-tab-pane>
            <el-tab-pane label="Layout" name="second">配置管理</el-tab-pane>
            <el-tab-pane label="Sidebar" name="third">角色管理</el-tab-pane>
            <el-tab-pane label="Header" name="fourth">定时任务补偿</el-tab-pane>
        </el-tabs>
    </div>
</template>
<script>
export default {
    name: 'index',
    data() {
        return {}
    },
    methods: {}
}
</script>
<style>

</style>