<template>
    <div class="d-flex flex-column flex-lg-row">
        <!--begin::Content-->
        <div class="flex-lg-row-fluid">
            <!--begin::Card-->
            <div class="card">
                <div class="card-header align-items-center py-5 gap-2 gap-md-5">
                    <!--begin::Actions-->
                    <div class="d-flex align-items-center flex-wrap gap-2">
                        <!--begin::Search-->
                        <div class="d-flex align-items-center position-relative">
                            <!--begin::Svg Icon | path: icons/duotune/general/gen021.svg-->
                            <span class="svg-icon svg-icon-2 position-absolute ms-4"><svg width="24" height="24"
                                    viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1"
                                        transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
                                    <path
                                        d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z"
                                        fill="currentColor"></path>
                                </svg>
                            </span>
                            <!--end::Svg Icon--> <input type="text" data-kt-inbox-listing-filter="search"
                                class="form-control form-control-sm form-control-solid mw-100 min-w-125px min-w-lg-150px min-w-xxl-200px ps-12"
                                placeholder="Search Inbox">
                        </div>
                        <!--end::Search-->

                        <!--begin::Toggle-->
                        <a href="#" class="btn btn-sm btn-icon btn-color-primary btn-light btn-active-light-primary"
                            data-bs-toggle="tooltip" data-bs-dismiss="click" data-bs-placement="top"
                            id="kt_inbox_aside_toggle" aria-label="Toggle inbox menu"
                            data-bs-original-title="Toggle inbox menu" data-kt-initialized="1">
                            <!--begin::Svg Icon | path: icons/duotune/general/gen059.svg-->
                            <span class="svg-icon svg-icon-3 m-0"><svg width="16" height="15" viewBox="0 0 16 15"
                                    fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <rect y="6" width="16" height="3" rx="1.5" fill="currentColor"></rect>
                                    <rect opacity="0.3" y="12" width="8" height="3" rx="1.5" fill="currentColor"></rect>
                                    <rect opacity="0.3" width="12" height="3" rx="1.5" fill="currentColor"></rect>
                                </svg>
                            </span>
                            <!--end::Svg Icon--> </a>
                        <!--end::Toggle-->
                    </div>
                    <!--end::Actions-->

                    <!--begin::Actions-->
                    <div class="d-flex flex-wrap gap-2">

                        <!--begin::Reload-->
                        <a href="#" class="btn btn-sm btn-icon btn-light btn-active-light-primary"
                            data-bs-toggle="tooltip" data-bs-dismiss="click" data-bs-placement="top" aria-label="Reload"
                            data-bs-original-title="Reload" data-kt-initialized="1">
                            <!--begin::Svg Icon | path: icons/duotune/arrows/arr029.svg-->
                            <span class="svg-icon svg-icon-2">
                                <svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M14.5 20.7259C14.6 21.2259 14.2 21.826 13.7 21.926C13.2 22.026 12.6 22.0259 12.1 22.0259C9.5 22.0259 6.9 21.0259 5 19.1259C1.4 15.5259 1.09998 9.72592 4.29998 5.82592L5.70001 7.22595C3.30001 10.3259 3.59999 14.8259 6.39999 17.7259C8.19999 19.5259 10.8 20.426 13.4 19.926C13.9 19.826 14.4 20.2259 14.5 20.7259ZM18.4 16.8259L19.8 18.2259C22.9 14.3259 22.7 8.52593 19 4.92593C16.7 2.62593 13.5 1.62594 10.3 2.12594C9.79998 2.22594 9.4 2.72595 9.5 3.22595C9.6 3.72595 10.1 4.12594 10.6 4.02594C13.1 3.62594 15.7 4.42595 17.6 6.22595C20.5 9.22595 20.7 13.7259 18.4 16.8259Z"
                                        fill="currentColor"></path>
                                    <path opacity="0.3"
                                        d="M2 3.62592H7C7.6 3.62592 8 4.02592 8 4.62592V9.62589L2 3.62592ZM16 14.4259V19.4259C16 20.0259 16.4 20.4259 17 20.4259H22L16 14.4259Z"
                                        fill="currentColor"></path> -->
                                </svg>
                            </span>
                            <!--end::Svg Icon--> </a>
                        <!--end::Reload-->

                        <!--begin::Archive-->
                        <a href="#" class="btn btn-sm btn-icon btn-light btn-active-light-primary"
                            data-bs-toggle="tooltip" data-bs-dismiss="click" data-bs-placement="top"
                            aria-label="Archive" data-bs-original-title="Archive" data-kt-initialized="1">
                            <!--begin::Svg Icon | path: icons/duotune/communication/com010.svg-->
                            <span class="svg-icon svg-icon-2">
                                <svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <rect opacity="0.5" x="11" y="18" width="12" height="2" rx="1"
                                        transform="rotate(-90 11 18)" fill="currentColor"></rect>
                                    <rect x="6" y="11" width="12" height="2" rx="1" fill="currentColor"></rect>
                                </svg>
                            </span>
                            <!--end::Svg Icon--> </a>
                        <!--end::Archive-->
                        <a href="#" data-bs-toggle="tooltip" data-bs-dismiss="click" data-bs-placement="top"
                            aria-label="Reload" data-bs-original-title="Reload" data-kt-initialized="1"
                            class="btn btn-sm btn-icon btn-light btn-active-light-primary">
                            <span class="svg-icon svg-icon-2">
                                <svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M5 9C5 8.44772 5.44772 8 6 8H18C18.5523 8 19 8.44772 19 9V18C19 19.6569 17.6569 21 16 21H8C6.34315 21 5 19.6569 5 18V9Z"
                                        fill="currentColor"></path>
                                    <path opacity="0.5"
                                        d="M5 5C5 4.44772 5.44772 4 6 4H18C18.5523 4 19 4.44772 19 5V5C19 5.55228 18.5523 6 18 6H6C5.44772 6 5 5.55228 5 5V5Z"
                                        fill="currentColor"></path>
                                    <path opacity="0.5"
                                        d="M9 4C9 3.44772 9.44772 3 10 3H14C14.5523 3 15 3.44772 15 4V4H9V4Z"
                                        fill="currentColor"></path>
                                </svg>
                            </span>
                        </a>

                        <!--begin::Filter-->
                        <div>
                            <a href="#" class="btn btn-sm btn-icon btn-light btn-active-light-primary"
                                data-kt-menu-trigger="click" data-kt-menu-placement="bottom-start">
                                <!--begin::Svg Icon | path: icons/duotune/arrows/arr072.svg-->
                                <span class="svg-icon svg-icon-2"><svg width="24" height="24" viewBox="0 0 24 24"
                                        fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path
                                            d="M11.4343 12.7344L7.25 8.55005C6.83579 8.13583 6.16421 8.13584 5.75 8.55005C5.33579 8.96426 5.33579 9.63583 5.75 10.05L11.2929 15.5929C11.6834 15.9835 12.3166 15.9835 12.7071 15.5929L18.25 10.05C18.6642 9.63584 18.6642 8.96426 18.25 8.55005C17.8358 8.13584 17.1642 8.13584 16.75 8.55005L12.5657 12.7344C12.2533 13.0468 11.7467 13.0468 11.4343 12.7344Z"
                                            fill="currentColor"></path>
                                    </svg>
                                </span>
                                <!--end::Svg Icon--> </a>
                            <!--begin::Menu-->
                            <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-semibold fs-7 w-125px py-4"
                                data-kt-menu="true">
                                <!--begin::Menu item-->
                                <div class="menu-item px-3">
                                    <a href="#" class="menu-link px-3" data-kt-inbox-listing-filter="show_all">
                                        All
                                    </a>
                                </div>
                                <!--end::Menu item-->

                                <!--begin::Menu item-->
                                <div class="menu-item px-3">
                                    <a href="#" class="menu-link px-3" data-kt-inbox-listing-filter="show_read">
                                        Read
                                    </a>
                                </div>
                                <!--end::Menu item-->

                                <!--begin::Menu item-->
                                <div class="menu-item px-3">
                                    <a href="#" class="menu-link px-3" data-kt-inbox-listing-filter="show_unread">
                                        Unread
                                    </a>
                                </div>
                                <!--end::Menu item-->

                                <!--begin::Menu item-->
                                <div class="menu-item px-3">
                                    <a href="#" class="menu-link px-3" data-kt-inbox-listing-filter="show_starred">
                                        Starred
                                    </a>
                                </div>
                                <!--end::Menu item-->

                                <!--begin::Menu item-->
                                <div class="menu-item px-3">
                                    <a href="#" class="menu-link px-3" data-kt-inbox-listing-filter="show_unstarred">
                                        Unstarred
                                    </a>
                                </div>
                                <!--end::Menu item-->
                            </div>
                            <!--end::Menu-->
                        </div>
                        <!--end::Filter-->

                        <!--begin::Sort-->
                        <span>
                            <a href="#" class="btn btn-sm btn-icon btn-light btn-active-light-primary"
                                data-bs-toggle="tooltip" data-bs-dismiss="click" data-bs-placement="top"
                                aria-label="Sort" data-bs-original-title="Sort" data-kt-initialized="1">
                                <!--begin::Svg Icon | path: icons/duotune/general/gen052.svg-->
                                <span class="svg-icon svg-icon-3 m-0"><svg width="24" height="24" viewBox="0 0 24 24"
                                        fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <rect x="10" y="10" width="4" height="4" rx="2" fill="currentColor"></rect>
                                        <rect x="17" y="10" width="4" height="4" rx="2" fill="currentColor"></rect>
                                        <rect x="3" y="10" width="4" height="4" rx="2" fill="currentColor"></rect>
                                    </svg>
                                </span>
                                <!--end::Svg Icon--> </a>
                            <!--begin::Menu-->
                            <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-semibold fs-7 w-125px py-4"
                                data-kt-menu="true">
                                <!--begin::Menu item-->
                                <div class="menu-item px-3">
                                    <a href="#" class="menu-link px-3" data-kt-inbox-listing-filter="filter_newest">
                                        Newest
                                    </a>
                                </div>
                                <!--end::Menu item-->

                                <!--begin::Menu item-->
                                <div class="menu-item px-3">
                                    <a href="#" class="menu-link px-3" data-kt-inbox-listing-filter="filter_oldest">
                                        Oldest
                                    </a>
                                </div>
                                <!--end::Menu item-->

                                <!--begin::Menu item-->
                                <div class="menu-item px-3">
                                    <a href="#" class="menu-link px-3" data-kt-inbox-listing-filter="filter_unread">
                                        Unread
                                    </a>
                                </div>
                                <!--end::Menu item-->
                            </div>
                            <!--end::Menu-->
                        </span>
                        <!--end::Sort-->
                    </div>
                    <!--end::Actions-->


                </div>

                <div class="card-body p-0">

                    <!--begin::Table-->
                    <div id="kt_inbox_listing_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
                        <div class="table-responsive">
                            <table class="table table-hover table-row-dashed fs-6 gy-5 my-0 dataTable no-footer"
                                id="kt_inbox_listing">
                                <!--begin::Table head-->
                                <thead class="d-none">
                                    <tr>
                                        <th class="sorting" tabindex="0" aria-controls="kt_inbox_listing" rowspan="1"
                                            colspan="1" aria-label="Checkbox: activate to sort column ascending"
                                            style="width: 0px;">Checkbox</th>
                                        <th class="sorting" tabindex="0" aria-controls="kt_inbox_listing" rowspan="1"
                                            colspan="1" aria-label="Actions: activate to sort column ascending"
                                            style="width: 0px;">Actions</th>
                                        <th class="sorting" tabindex="0" aria-controls="kt_inbox_listing" rowspan="1"
                                            colspan="1" aria-label="Author: activate to sort column ascending"
                                            style="width: 0px;">Author</th>
                                        <th class="sorting" tabindex="0" aria-controls="kt_inbox_listing" rowspan="1"
                                            colspan="1" aria-label="Title: activate to sort column ascending"
                                            style="width: 0px;">Title</th>
                                        <th class="sorting" tabindex="0" aria-controls="kt_inbox_listing" rowspan="1"
                                            colspan="1" aria-label="Date: activate to sort column ascending"
                                            style="width: 0px;">Date</th>
                                    </tr>
                                </thead>
                                <!--end::Table head-->

                                <!--begin::Table body-->
                                <tbody>













                                    <tr class="odd">
                                        <td class="ps-9">
                                            <!--begin::Checkbox-->
                                            <div
                                                class="form-check form-check-sm form-check-custom form-check-solid mt-3">
                                                <input class="form-check-input" type="checkbox" value="1">
                                            </div>
                                            <!--end::Checkbox-->
                                        </td>

                                        <td class="min-w-80px">
                                            <!--begin::Star-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Star"
                                                data-bs-original-title="Star" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen029.svg-->
                                                <span class="svg-icon svg-icon-3"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Star-->

                                            <!--begin::Important-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right"
                                                aria-label="Mark as important"
                                                data-bs-original-title="Mark as important" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen056.svg-->
                                                <span class="svg-icon svg-icon-4 mt-1"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M16.0077 19.2901L12.9293 17.5311C12.3487 17.1993 11.6407 17.1796 11.0426 17.4787L6.89443 19.5528C5.56462 20.2177 4 19.2507 4 17.7639V5C4 3.89543 4.89543 3 6 3H17C18.1046 3 19 3.89543 19 5V17.5536C19 19.0893 17.341 20.052 16.0077 19.2901Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Important-->
                                        </td>

                                        <!--begin::Author-->
                                        <td class="w-150px w-md-175px">
                                            <a href="/keen/demo1/../demo1/apps/inbox/reply.html"
                                                class="d-flex align-items-center text-dark">
                                                <!--begin::Avatar-->
                                                <div class="symbol symbol-35px me-3">
                                                    <div class="symbol-label bg-light-danger">
                                                        <span class="text-danger">M</span>
                                                    </div>
                                                </div>
                                                <!--end::Avatar-->

                                                <!--begin::Name-->
                                                <span class="fw-semibold">Melody Macy</span>
                                                <!--end::Name-->
                                            </a>
                                        </td>
                                        <!--end::Author-->

                                        <!--begin::Title-->
                                        <td>
                                            <div class="text-dark mb-1">
                                                <!--begin::Heading-->
                                                <a href="/keen/demo1/../demo1/apps/inbox/reply.html" class="text-dark">
                                                    <span class="fw-bold">Digital PPV Customer Confirmation</span>
                                                    <span class="fw-bold d-none d-md-inine"> - </span>
                                                    <span class="d-none d-md-inine text-muted">Thank you for ordering
                                                        UFC 240 Holloway vs
                                                        Edgar Alternate camera angles...</span>
                                                </a>
                                                <!--end::Heading-->
                                            </div>

                                            <!--begin::Badges-->
                                            <div class="badge badge-light-primary">inbox</div>
                                            <div class="badge badge-light-warning">task</div>
                                            <!--end::Badges-->
                                        </td>
                                        <!--end::Title-->

                                        <!--begin::Date-->
                                        <td class="w-100px text-end fs-7 pe-9">
                                            <span class="fw-semibold">8:30 PM</span>
                                        </td>
                                        <!--end::Date-->
                                    </tr>
                                    <tr class="even">
                                        <td class="ps-9">
                                            <!--begin::Checkbox-->
                                            <div
                                                class="form-check form-check-sm form-check-custom form-check-solid mt-3">
                                                <input class="form-check-input" type="checkbox" value="1">
                                            </div>
                                            <!--end::Checkbox-->
                                        </td>

                                        <td class="min-w-80px">
                                            <!--begin::Star-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Star"
                                                data-bs-original-title="Star" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen029.svg-->
                                                <span class="svg-icon svg-icon-3"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Star-->

                                            <!--begin::Important-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right"
                                                aria-label="Mark as important"
                                                data-bs-original-title="Mark as important" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen056.svg-->
                                                <span class="svg-icon svg-icon-4 mt-1"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M16.0077 19.2901L12.9293 17.5311C12.3487 17.1993 11.6407 17.1796 11.0426 17.4787L6.89443 19.5528C5.56462 20.2177 4 19.2507 4 17.7639V5C4 3.89543 4.89543 3 6 3H17C18.1046 3 19 3.89543 19 5V17.5536C19 19.0893 17.341 20.052 16.0077 19.2901Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Important-->
                                        </td>

                                        <!--begin::Author-->
                                        <td class="w-150px w-md-175px">
                                            <a href="/keen/demo1/../demo1/apps/inbox/reply.html"
                                                class="d-flex align-items-center text-dark">
                                                <!--begin::Avatar-->
                                                <div class="symbol symbol-35px me-3">
                                                    <span class="symbol-label"
                                                        style="background-image:url(/keen/demo1/assets/media/avatars/300-1.jpg)"></span>
                                                </div>
                                                <!--end::Avatar-->

                                                <!--begin::Name-->
                                                <span class="fw-semibold">Max Smith</span>
                                                <!--end::Name-->
                                            </a>
                                        </td>
                                        <!--end::Author-->

                                        <!--begin::Title-->
                                        <td>
                                            <div class="text-dark mb-1">
                                                <!--begin::Heading-->
                                                <a href="/keen/demo1/../demo1/apps/inbox/reply.html" class="text-dark">
                                                    <span class="fw-bold">Your iBuy.com grocery shopping
                                                        confirmation</span>
                                                    <span class="fw-bold d-none d-md-inine"> - </span>
                                                    <span class="d-none d-md-inine text-muted">Please make sure that you
                                                        have one of the
                                                        following cards with you when we deliver your order...</span>
                                                </a>
                                                <!--end::Heading-->
                                            </div>

                                        </td>
                                        <!--end::Title-->

                                        <!--begin::Date-->
                                        <td class="w-100px text-end fs-7 pe-9">
                                            <span class="fw-semibold">day ago</span>
                                        </td>
                                        <!--end::Date-->
                                    </tr>
                                    <tr class="odd">
                                        <td class="ps-9">
                                            <!--begin::Checkbox-->
                                            <div
                                                class="form-check form-check-sm form-check-custom form-check-solid mt-3">
                                                <input class="form-check-input" type="checkbox" value="1">
                                            </div>
                                            <!--end::Checkbox-->
                                        </td>

                                        <td class="min-w-80px">
                                            <!--begin::Star-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Star"
                                                data-bs-original-title="Star" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen029.svg-->
                                                <span class="svg-icon svg-icon-3"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Star-->

                                            <!--begin::Important-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right"
                                                aria-label="Mark as important"
                                                data-bs-original-title="Mark as important" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen056.svg-->
                                                <span class="svg-icon svg-icon-4 mt-1"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M16.0077 19.2901L12.9293 17.5311C12.3487 17.1993 11.6407 17.1796 11.0426 17.4787L6.89443 19.5528C5.56462 20.2177 4 19.2507 4 17.7639V5C4 3.89543 4.89543 3 6 3H17C18.1046 3 19 3.89543 19 5V17.5536C19 19.0893 17.341 20.052 16.0077 19.2901Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Important-->
                                        </td>

                                        <!--begin::Author-->
                                        <td class="w-150px w-md-175px">
                                            <a href="/keen/demo1/../demo1/apps/inbox/reply.html"
                                                class="d-flex align-items-center text-dark">
                                                <!--begin::Avatar-->
                                                <div class="symbol symbol-35px me-3">
                                                    <span class="symbol-label"
                                                        style="background-image:url(/keen/demo1/assets/media/avatars/300-5.jpg)"></span>
                                                </div>
                                                <!--end::Avatar-->

                                                <!--begin::Name-->
                                                <span class="fw-semibold">Sean Bean</span>
                                                <!--end::Name-->
                                            </a>
                                        </td>
                                        <!--end::Author-->

                                        <!--begin::Title-->
                                        <td>
                                            <div class="text-dark mb-1">
                                                <!--begin::Heading-->
                                                <a href="/keen/demo1/../demo1/apps/inbox/reply.html" class="text-dark">
                                                    <span class="fw-bold">Your Order #224820998666029 has been
                                                        Confirmed</span>
                                                    <span class="fw-bold d-none d-md-inine"> - </span>
                                                    <span class="d-none d-md-inine text-muted">Your Order
                                                        #224820998666029 has been placed
                                                        on Saturday, 29 June</span>
                                                </a>
                                                <!--end::Heading-->
                                            </div>

                                        </td>
                                        <!--end::Title-->

                                        <!--begin::Date-->
                                        <td class="w-100px text-end fs-7 pe-9">
                                            <span class="fw-semibold text-muted">11:20 PM</span>
                                        </td>
                                        <!--end::Date-->
                                    </tr>
                                    <tr class="even">
                                        <td class="ps-9">
                                            <!--begin::Checkbox-->
                                            <div
                                                class="form-check form-check-sm form-check-custom form-check-solid mt-3">
                                                <input class="form-check-input" type="checkbox" value="1">
                                            </div>
                                            <!--end::Checkbox-->
                                        </td>

                                        <td class="min-w-80px">
                                            <!--begin::Star-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Star"
                                                data-bs-original-title="Star" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen029.svg-->
                                                <span class="svg-icon svg-icon-3"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Star-->

                                            <!--begin::Important-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right"
                                                aria-label="Mark as important"
                                                data-bs-original-title="Mark as important" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen056.svg-->
                                                <span class="svg-icon svg-icon-4 mt-1"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M16.0077 19.2901L12.9293 17.5311C12.3487 17.1993 11.6407 17.1796 11.0426 17.4787L6.89443 19.5528C5.56462 20.2177 4 19.2507 4 17.7639V5C4 3.89543 4.89543 3 6 3H17C18.1046 3 19 3.89543 19 5V17.5536C19 19.0893 17.341 20.052 16.0077 19.2901Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Important-->
                                        </td>

                                        <!--begin::Author-->
                                        <td class="w-150px w-md-175px">
                                            <a href="/keen/demo1/../demo1/apps/inbox/reply.html"
                                                class="d-flex align-items-center text-dark">
                                                <!--begin::Avatar-->
                                                <div class="symbol symbol-35px me-3">
                                                    <span class="symbol-label"
                                                        style="background-image:url(/keen/demo1/assets/media/avatars/300-25.jpg)"></span>
                                                </div>
                                                <!--end::Avatar-->

                                                <!--begin::Name-->
                                                <span class="fw-semibold">Brian Cox</span>
                                                <!--end::Name-->
                                            </a>
                                        </td>
                                        <!--end::Author-->

                                        <!--begin::Title-->
                                        <td>
                                            <div class="text-dark mb-1">
                                                <!--begin::Heading-->
                                                <a href="/keen/demo1/../demo1/apps/inbox/reply.html" class="text-dark">
                                                    <span class="fw-bold">Payment Notification DLOP2329KD</span>
                                                    <span class="fw-bold d-none d-md-inine"> - </span>
                                                    <span class="d-none d-md-inine text-muted">Your payment of 4500USD
                                                        to AirCar has been
                                                        authorized and confirmed, thank you your account. This...</span>
                                                </a>
                                                <!--end::Heading-->
                                            </div>

                                            <!--begin::Badges-->
                                            <div class="badge badge-light-danger">new</div>
                                            <!--end::Badges-->
                                        </td>
                                        <!--end::Title-->

                                        <!--begin::Date-->
                                        <td class="w-100px text-end fs-7 pe-9">
                                            <span class="fw-semibold text-muted">2 days ago</span>
                                        </td>
                                        <!--end::Date-->
                                    </tr>
                                    <tr class="odd">
                                        <td class="ps-9">
                                            <!--begin::Checkbox-->
                                            <div
                                                class="form-check form-check-sm form-check-custom form-check-solid mt-3">
                                                <input class="form-check-input" type="checkbox" value="1">
                                            </div>
                                            <!--end::Checkbox-->
                                        </td>

                                        <td class="min-w-80px">
                                            <!--begin::Star-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Star"
                                                data-bs-original-title="Star" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen029.svg-->
                                                <span class="svg-icon svg-icon-3"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Star-->

                                            <!--begin::Important-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right"
                                                aria-label="Mark as important"
                                                data-bs-original-title="Mark as important" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen056.svg-->
                                                <span class="svg-icon svg-icon-4 mt-1"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M16.0077 19.2901L12.9293 17.5311C12.3487 17.1993 11.6407 17.1796 11.0426 17.4787L6.89443 19.5528C5.56462 20.2177 4 19.2507 4 17.7639V5C4 3.89543 4.89543 3 6 3H17C18.1046 3 19 3.89543 19 5V17.5536C19 19.0893 17.341 20.052 16.0077 19.2901Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Important-->
                                        </td>

                                        <!--begin::Author-->
                                        <td class="w-150px w-md-175px">
                                            <a href="/keen/demo1/../demo1/apps/inbox/reply.html"
                                                class="d-flex align-items-center text-dark">
                                                <!--begin::Avatar-->
                                                <div class="symbol symbol-35px me-3">
                                                    <div class="symbol-label bg-light-warning">
                                                        <span class="text-warning">C</span>
                                                    </div>
                                                </div>
                                                <!--end::Avatar-->

                                                <!--begin::Name-->
                                                <span class="fw-semibold">Mikaela Collins</span>
                                                <!--end::Name-->
                                            </a>
                                        </td>
                                        <!--end::Author-->

                                        <!--begin::Title-->
                                        <td>
                                            <div class="text-dark mb-1">
                                                <!--begin::Heading-->
                                                <a href="/keen/demo1/../demo1/apps/inbox/reply.html" class="text-dark">
                                                    <span class="fw-bold">Congratulations on your iRun Coach
                                                        subscription</span>
                                                    <span class="fw-bold d-none d-md-inine"> - </span>
                                                    <span class="d-none d-md-inine text-muted">Congratulations on your
                                                        iRun Coach
                                                        subscription. You made no space for excuses and you</span>
                                                </a>
                                                <!--end::Heading-->
                                            </div>

                                        </td>
                                        <!--end::Title-->

                                        <!--begin::Date-->
                                        <td class="w-100px text-end fs-7 pe-9">
                                            <span class="fw-semibold text-muted">July 25</span>
                                        </td>
                                        <!--end::Date-->
                                    </tr>
                                    <tr class="even">
                                        <td class="ps-9">
                                            <!--begin::Checkbox-->
                                            <div
                                                class="form-check form-check-sm form-check-custom form-check-solid mt-3">
                                                <input class="form-check-input" type="checkbox" value="1">
                                            </div>
                                            <!--end::Checkbox-->
                                        </td>

                                        <td class="min-w-80px">
                                            <!--begin::Star-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Star"
                                                data-bs-original-title="Star" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen029.svg-->
                                                <span class="svg-icon svg-icon-3"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Star-->

                                            <!--begin::Important-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right"
                                                aria-label="Mark as important"
                                                data-bs-original-title="Mark as important" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen056.svg-->
                                                <span class="svg-icon svg-icon-4 mt-1"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M16.0077 19.2901L12.9293 17.5311C12.3487 17.1993 11.6407 17.1796 11.0426 17.4787L6.89443 19.5528C5.56462 20.2177 4 19.2507 4 17.7639V5C4 3.89543 4.89543 3 6 3H17C18.1046 3 19 3.89543 19 5V17.5536C19 19.0893 17.341 20.052 16.0077 19.2901Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Important-->
                                        </td>

                                        <!--begin::Author-->
                                        <td class="w-150px w-md-175px">
                                            <a href="/keen/demo1/../demo1/apps/inbox/reply.html"
                                                class="d-flex align-items-center text-dark">
                                                <!--begin::Avatar-->
                                                <div class="symbol symbol-35px me-3">
                                                    <span class="symbol-label"
                                                        style="background-image:url(/keen/demo1/assets/media/avatars/300-9.jpg)"></span>
                                                </div>
                                                <!--end::Avatar-->

                                                <!--begin::Name-->
                                                <span class="fw-semibold">Francis Mitcham</span>
                                                <!--end::Name-->
                                            </a>
                                        </td>
                                        <!--end::Author-->

                                        <!--begin::Title-->
                                        <td>
                                            <div class="text-dark mb-1">
                                                <!--begin::Heading-->
                                                <a href="/keen/demo1/../demo1/apps/inbox/reply.html" class="text-dark">
                                                    <span class="fw-bold">Pay bills &amp; win up to 600$
                                                        Cashback!</span>
                                                    <span class="fw-bold d-none d-md-inine"> - </span>
                                                    <span class="d-none d-md-inine text-muted">Congratulations on your
                                                        iRun Coach
                                                        subscription. You made no space for excuses and you decided on a
                                                        healthier and
                                                        happier life...</span>
                                                </a>
                                                <!--end::Heading-->
                                            </div>

                                        </td>
                                        <!--end::Title-->

                                        <!--begin::Date-->
                                        <td class="w-100px text-end fs-7 pe-9">
                                            <span class="fw-semibold text-muted">July 24</span>
                                        </td>
                                        <!--end::Date-->
                                    </tr>
                                    <tr class="odd">
                                        <td class="ps-9">
                                            <!--begin::Checkbox-->
                                            <div
                                                class="form-check form-check-sm form-check-custom form-check-solid mt-3">
                                                <input class="form-check-input" type="checkbox" value="1">
                                            </div>
                                            <!--end::Checkbox-->
                                        </td>

                                        <td class="min-w-80px">
                                            <!--begin::Star-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Star"
                                                data-bs-original-title="Star" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen029.svg-->
                                                <span class="svg-icon svg-icon-3"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Star-->

                                            <!--begin::Important-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right"
                                                aria-label="Mark as important"
                                                data-bs-original-title="Mark as important" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen056.svg-->
                                                <span class="svg-icon svg-icon-4 mt-1"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M16.0077 19.2901L12.9293 17.5311C12.3487 17.1993 11.6407 17.1796 11.0426 17.4787L6.89443 19.5528C5.56462 20.2177 4 19.2507 4 17.7639V5C4 3.89543 4.89543 3 6 3H17C18.1046 3 19 3.89543 19 5V17.5536C19 19.0893 17.341 20.052 16.0077 19.2901Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Important-->
                                        </td>

                                        <!--begin::Author-->
                                        <td class="w-150px w-md-175px">
                                            <a href="/keen/demo1/../demo1/apps/inbox/reply.html"
                                                class="d-flex align-items-center text-dark">
                                                <!--begin::Avatar-->
                                                <div class="symbol symbol-35px me-3">
                                                    <div class="symbol-label bg-light-danger">
                                                        <span class="text-danger">O</span>
                                                    </div>
                                                </div>
                                                <!--end::Avatar-->

                                                <!--begin::Name-->
                                                <span class="fw-semibold">Olivia Wild</span>
                                                <!--end::Name-->
                                            </a>
                                        </td>
                                        <!--end::Author-->

                                        <!--begin::Title-->
                                        <td>
                                            <div class="text-dark mb-1">
                                                <!--begin::Heading-->
                                                <a href="/keen/demo1/../demo1/apps/inbox/reply.html" class="text-dark">
                                                    <span class="fw-bold">Activate your LIPO Account today</span>
                                                    <span class="fw-bold d-none d-md-inine"> - </span>
                                                    <span class="d-none d-md-inine text-muted">Thank you for creating a
                                                        LIPO Account.
                                                        Please click the link below to activate your account.</span>
                                                </a>
                                                <!--end::Heading-->
                                            </div>

                                            <!--begin::Badges-->
                                            <div class="badge badge-light-warning">task</div>
                                            <!--end::Badges-->
                                        </td>
                                        <!--end::Title-->

                                        <!--begin::Date-->
                                        <td class="w-100px text-end fs-7 pe-9">
                                            <span class="fw-semibold text-muted">July 13</span>
                                        </td>
                                        <!--end::Date-->
                                    </tr>
                                    <tr class="even">
                                        <td class="ps-9">
                                            <!--begin::Checkbox-->
                                            <div
                                                class="form-check form-check-sm form-check-custom form-check-solid mt-3">
                                                <input class="form-check-input" type="checkbox" value="1">
                                            </div>
                                            <!--end::Checkbox-->
                                        </td>

                                        <td class="min-w-80px">
                                            <!--begin::Star-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Star"
                                                data-bs-original-title="Star" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen029.svg-->
                                                <span class="svg-icon svg-icon-3"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Star-->

                                            <!--begin::Important-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right"
                                                aria-label="Mark as important"
                                                data-bs-original-title="Mark as important" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen056.svg-->
                                                <span class="svg-icon svg-icon-4 mt-1"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M16.0077 19.2901L12.9293 17.5311C12.3487 17.1993 11.6407 17.1796 11.0426 17.4787L6.89443 19.5528C5.56462 20.2177 4 19.2507 4 17.7639V5C4 3.89543 4.89543 3 6 3H17C18.1046 3 19 3.89543 19 5V17.5536C19 19.0893 17.341 20.052 16.0077 19.2901Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Important-->
                                        </td>

                                        <!--begin::Author-->
                                        <td class="w-150px w-md-175px">
                                            <a href="/keen/demo1/../demo1/apps/inbox/reply.html"
                                                class="d-flex align-items-center text-dark">
                                                <!--begin::Avatar-->
                                                <div class="symbol symbol-35px me-3">
                                                    <div class="symbol-label bg-light-primary">
                                                        <span class="text-primary">N</span>
                                                    </div>
                                                </div>
                                                <!--end::Avatar-->

                                                <!--begin::Name-->
                                                <span class="fw-semibold">Neil Owen</span>
                                                <!--end::Name-->
                                            </a>
                                        </td>
                                        <!--end::Author-->

                                        <!--begin::Title-->
                                        <td>
                                            <div class="text-dark mb-1">
                                                <!--begin::Heading-->
                                                <a href="/keen/demo1/../demo1/apps/inbox/reply.html" class="text-dark">
                                                    <span class="fw-bold">About your request for PalmLake</span>
                                                    <span class="fw-bold d-none d-md-inine"> - </span>
                                                    <span class="d-none d-md-inine text-muted">What you requested can't
                                                        be arranged ahead
                                                        of time but PalmLake said they'll do their best to accommodate
                                                        you upon
                                                        arrival....</span>
                                                </a>
                                                <!--end::Heading-->
                                            </div>

                                        </td>
                                        <!--end::Title-->

                                        <!--begin::Date-->
                                        <td class="w-100px text-end fs-7 pe-9">
                                            <span class="fw-semibold text-muted">May 25</span>
                                        </td>
                                        <!--end::Date-->
                                    </tr>
                                    <tr class="odd">
                                        <td class="ps-9">
                                            <!--begin::Checkbox-->
                                            <div
                                                class="form-check form-check-sm form-check-custom form-check-solid mt-3">
                                                <input class="form-check-input" type="checkbox" value="1">
                                            </div>
                                            <!--end::Checkbox-->
                                        </td>

                                        <td class="min-w-80px">
                                            <!--begin::Star-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Star"
                                                data-bs-original-title="Star" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen029.svg-->
                                                <span class="svg-icon svg-icon-3"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Star-->

                                            <!--begin::Important-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right"
                                                aria-label="Mark as important"
                                                data-bs-original-title="Mark as important" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen056.svg-->
                                                <span class="svg-icon svg-icon-4 mt-1"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M16.0077 19.2901L12.9293 17.5311C12.3487 17.1993 11.6407 17.1796 11.0426 17.4787L6.89443 19.5528C5.56462 20.2177 4 19.2507 4 17.7639V5C4 3.89543 4.89543 3 6 3H17C18.1046 3 19 3.89543 19 5V17.5536C19 19.0893 17.341 20.052 16.0077 19.2901Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Important-->
                                        </td>

                                        <!--begin::Author-->
                                        <td class="w-150px w-md-175px">
                                            <a href="/keen/demo1/../demo1/apps/inbox/reply.html"
                                                class="d-flex align-items-center text-dark">
                                                <!--begin::Avatar-->
                                                <div class="symbol symbol-35px me-3">
                                                    <span class="symbol-label"
                                                        style="background-image:url(/keen/demo1/assets/media/avatars/300-23.jpg)"></span>
                                                </div>
                                                <!--end::Avatar-->

                                                <!--begin::Name-->
                                                <span class="fw-semibold">Dan Wilson</span>
                                                <!--end::Name-->
                                            </a>
                                        </td>
                                        <!--end::Author-->

                                        <!--begin::Title-->
                                        <td>
                                            <div class="text-dark mb-1">
                                                <!--begin::Heading-->
                                                <a href="/keen/demo1/../demo1/apps/inbox/reply.html" class="text-dark">
                                                    <span class="fw-bold">Welcome, Patty</span>
                                                    <span class="fw-bold d-none d-md-inine"> - </span>
                                                    <span class="d-none d-md-inine text-muted">Discover interesting
                                                        ideas and unique
                                                        perspectives. Read, explore and follow your interests. Get
                                                        personalized
                                                        recommendations delivered to you....</span>
                                                </a>
                                                <!--end::Heading-->
                                            </div>

                                        </td>
                                        <!--end::Title-->

                                        <!--begin::Date-->
                                        <td class="w-100px text-end fs-7 pe-9">
                                            <span class="fw-semibold">April 15</span>
                                        </td>
                                        <!--end::Date-->
                                    </tr>
                                    <tr class="even">
                                        <td class="ps-9">
                                            <!--begin::Checkbox-->
                                            <div
                                                class="form-check form-check-sm form-check-custom form-check-solid mt-3">
                                                <input class="form-check-input" type="checkbox" value="1">
                                            </div>
                                            <!--end::Checkbox-->
                                        </td>

                                        <td class="min-w-80px">
                                            <!--begin::Star-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right" aria-label="Star"
                                                data-bs-original-title="Star" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen029.svg-->
                                                <span class="svg-icon svg-icon-3"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Star-->

                                            <!--begin::Important-->
                                            <a href="#"
                                                class="btn btn-icon btn-color-gray-400 btn-active-color-primary w-35px h-35px"
                                                data-bs-toggle="tooltip" data-bs-placement="right"
                                                aria-label="Mark as important"
                                                data-bs-original-title="Mark as important" data-kt-initialized="1">
                                                <!--begin::Svg Icon | path: icons/duotune/general/gen056.svg-->
                                                <span class="svg-icon svg-icon-4 mt-1"><svg width="24" height="24"
                                                        viewBox="0 0 24 24" fill="none"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M16.0077 19.2901L12.9293 17.5311C12.3487 17.1993 11.6407 17.1796 11.0426 17.4787L6.89443 19.5528C5.56462 20.2177 4 19.2507 4 17.7639V5C4 3.89543 4.89543 3 6 3H17C18.1046 3 19 3.89543 19 5V17.5536C19 19.0893 17.341 20.052 16.0077 19.2901Z"
                                                            fill="currentColor"></path>
                                                    </svg>
                                                </span>
                                                <!--end::Svg Icon--> </a>
                                            <!--end::Important-->
                                        </td>

                                        <!--begin::Author-->
                                        <td class="w-150px w-md-175px">
                                            <a href="/keen/demo1/../demo1/apps/inbox/reply.html"
                                                class="d-flex align-items-center text-dark">
                                                <!--begin::Avatar-->
                                                <div class="symbol symbol-35px me-3">
                                                    <div class="symbol-label bg-light-danger">
                                                        <span class="text-danger">E</span>
                                                    </div>
                                                </div>
                                                <!--end::Avatar-->

                                                <!--begin::Name-->
                                                <span class="fw-semibold">Emma Bold</span>
                                                <!--end::Name-->
                                            </a>
                                        </td>
                                        <!--end::Author-->

                                        <!--begin::Title-->
                                        <td>
                                            <div class="text-dark mb-1">
                                                <!--begin::Heading-->
                                                <a href="/keen/demo1/../demo1/apps/inbox/reply.html" class="text-dark">
                                                    <span class="fw-bold">Free Video Marketing Guide</span>
                                                    <span class="fw-bold d-none d-md-inine"> - </span>
                                                    <span class="d-none d-md-inine text-muted">Video has rolled into
                                                        every marketing
                                                        platform or channel, leaving...</span>
                                                </a>
                                                <!--end::Heading-->
                                            </div>

                                            <!--begin::Badges-->
                                            <div class="badge badge-light-success">project</div>
                                            <!--end::Badges-->
                                        </td>
                                        <!--end::Title-->

                                        <!--begin::Date-->
                                        <td class="w-100px text-end fs-7 pe-9">
                                            <span class="fw-semibold text-muted">April 3</span>
                                        </td>
                                        <!--end::Date-->
                                    </tr>
                                </tbody>
                                <!--end::Table body-->
                            </table>
                        </div>
                        <div class="row px-9 pt-3 pb-5">
                            <div
                                class="col-sm-12 col-md-5 d-flex align-items-center justify-content-center justify-content-md-start">
                                <div class="dataTables_length" id="kt_inbox_listing_length"><label><select
                                            name="kt_inbox_listing_length" aria-controls="kt_inbox_listing"
                                            class="form-select form-select-sm form-select-solid">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select></label></div>
                            </div>
                            <div
                                class="col-sm-12 col-md-7 d-flex align-items-center justify-content-center justify-content-md-end">
                                <div class="dataTables_paginate paging_simple_numbers" id="kt_inbox_listing_paginate">
                                    <ul class="pagination">
                                        <li class="paginate_button page-item previous disabled"
                                            id="kt_inbox_listing_previous"><a href="#" aria-controls="kt_inbox_listing"
                                                data-dt-idx="0" tabindex="0" class="page-link"><i
                                                    class="previous"></i></a></li>
                                        <li class="paginate_button page-item active"><a href="#"
                                                aria-controls="kt_inbox_listing" data-dt-idx="1" tabindex="0"
                                                class="page-link">1</a></li>
                                        <li class="paginate_button page-item "><a href="#"
                                                aria-controls="kt_inbox_listing" data-dt-idx="2" tabindex="0"
                                                class="page-link">2</a></li>
                                        <li class="paginate_button page-item next" id="kt_inbox_listing_next"><a
                                                href="#" aria-controls="kt_inbox_listing" data-dt-idx="3" tabindex="0"
                                                class="page-link"><i class="next"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end::Table-->
                </div>
            </div>
            <!--end::Card-->

        </div>
        <!--end::Content-->
    </div>
</template>
<script>
import { mapGetters } from "vuex"
export default {
    name: 'index',
    data() {
        return {}
    },
    computed: {
        ...mapGetters(["settings"]),
    },
    methods: {}
}
</script>
<style lang="scss" scoped>

</style>