$(function() {
    $(".toggle-menu").on("click",
    function() {
        $(".menus").is(":visible") ? $(".menus").velocity("stop").velocity("transition.slideUpOut", {
            duration: 300
        }) : $(".menus").velocity("stop").velocity("transition.slideDownIn", {
            duration: 300
        })
    }),
    $(document).on("click",
    function(i) { ! ($(".menus")[0].contains(i.target) || $(".toggle-menu")[0].contains(i.target)) && $(".toggle-menu").is(":visible") && $(".menus").velocity("stop").velocity("transition.slideUpOut", {
            duration: 300
        })
    }),
    $(window).on("resize",
    function(i) {
        $(".toggle-menu").is(":visible") || $(".menus").is(":visible") || $(".menus").velocity("stop").velocity("transition.slideDownIn", {
            duration: 300
        })
    })
});