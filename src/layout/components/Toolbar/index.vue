<template>
    <div id="kt_app_toolbar" class="app-toolbar  py-3 py-lg-6 ">
        <!--begin::Toolbar container-->
        <div id="kt_app_toolbar_container" class="app-container d-flex flex-stack" :class="settings.widthMode.val">
            <page-title></page-title>
            <!--begin::Actions-->
            <div class="d-flex align-items-center gap-2 gap-lg-3">
                <!--begin::Filter menu-->
                <div class="d-flex">
                    <select name="campaign-type" data-control="select2" data-hide-search="true"
                        class="form-select form-select-sm bg-body border-body w-175px select2-hidden-accessible"
                        data-select2-id="select2-data-7-pp5k" tabindex="-1" aria-hidden="true" data-kt-initialized="1">
                        <option value="Twitter" selected="selected" data-select2-id="select2-data-9-0axq">Select
                            Campaign</option>
                        <option value="Twitter">Twitter Campaign</option>
                        <option value="Twitter">Facebook Campaign</option>
                        <option value="Twitter">Adword Campaign</option>
                        <option value="Twitter">Carbon Campaign</option>
                    </select><span class="select2 select2-container select2-container--bootstrap5" dir="ltr"
                        data-select2-id="select2-data-8-iti9" style="width: 100%;"><span class="selection"><span
                                class="select2-selection select2-selection--single form-select form-select-sm bg-body border-body w-175px"
                                role="combobox" aria-haspopup="true" aria-expanded="false" tabindex="0"
                                aria-disabled="false" aria-labelledby="select2-campaign-type-a1-container"
                                aria-controls="select2-campaign-type-a1-container"><span
                                    class="select2-selection__rendered" id="select2-campaign-type-a1-container"
                                    role="textbox" aria-readonly="true" title="Select Campaign">Select
                                    Campaign</span><span class="select2-selection__arrow" role="presentation"><b
                                        role="presentation"></b></span></span></span><span class="dropdown-wrapper"
                            aria-hidden="true"></span></span>

                    <a href="#" class="btn btn-icon btn-sm btn-success flex-shrink-0 ms-4" data-bs-toggle="modal"
                        data-bs-target="#kt_modal_create_campaign">
                        <!--begin::Svg Icon | path: icons/duotune/arrows/arr075.svg-->
                        <span class="svg-icon svg-icon-2"><svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                                xmlns="http://www.w3.org/2000/svg">
                                <rect opacity="0.5" x="11.364" y="20.364" width="16" height="2" rx="1"
                                    transform="rotate(-90 11.364 20.364)" fill="currentColor"></rect>
                                <rect x="4.36396" y="11.364" width="16" height="2" rx="1" fill="currentColor"></rect>
                            </svg></span>
                        <!--end::Svg Icon-->
                    </a>
                </div>
                <!--end::Filter menu-->


                <!--begin::Secondary button-->
                <!--end::Secondary button-->

                <!--begin::Primary button-->
                <!--end::Primary button-->
            </div>
            <!--end::Actions-->
        </div>
        <!--end::Toolbar container-->
    </div>
</template>
<script>
import PageTitle from '../PageTitle'
import { mapGetters } from "vuex"
export default {
    name: 'Toolbar',
    components: {
        PageTitle
    },
    computed: {
        ...mapGetters(["settings"]),
    },
}
</script>