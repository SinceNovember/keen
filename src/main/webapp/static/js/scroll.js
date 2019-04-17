$(function() {
    var t = 0;
    function e(t) {
        $(t).velocity("stop").velocity("scroll", {
            duration: 500,
            easing: "easeInOutQuart"
        })
    }
    $(".toc-child").hide(),
    $(window).scroll(throttle(function(e) {
        var i = $(this).scrollTop();
        isMobile() || (function(t) {
            var e = $("#content-outer").height(),
            i = $(window).height(),
            o = e > i ? e - i: $(document).height() - i,
            a = t / o,
            s = Math.round(100 * a),
            n = s > 100 ? 100 : s;
            $(".progress-num").text(n),
            $(".sidebar-toc__progress-bar").velocity("stop").velocity({
                width: n + "%"
            },
            {
                duration: 100,
                easing: "easeInOutQuart"
            })
        } (i),
        function(t) {
            if (0 === $(".toc-link").length) return ! 1;
            var e = "";
            $("#post-content").find("h1,h2,h3,h4,h5,h6").each(function() {
                var i = $(this);
                t > i.offset().top - 25 && (e = "#" + $(this).attr("id"))
            }),
            "" === e && ($(".toc-link").removeClass("active"), $(".toc-child").hide());
            var i = $(".toc-link.active");
            if (e && i.attr("href") !== e) {
                n = e,
                window.history.replaceState && n !== window.location.hash && window.history.replaceState(void 0, void 0, n),
                $(".toc-link").removeClass("active");
                var o = $('.toc-link[href="' + e + '"]');
                o.addClass("active");
                var a = o.parents(".toc-child"),
                s = a.length > 0 ? a.last() : o; !
                function(t) {
                    if (t.is(":visible")) return;
                    t.velocity("stop").velocity("transition.fadeIn", {
                        duration: 500,
                        easing: "easeInQuart"
                    })
                } (s.closest(".toc-item").find(".toc-child")),
                s.closest(".toc-item").siblings(".toc-item").find(".toc-child").hide()
            }
            var n
        } (i));
        var o = function(e) {
            var i = e > t;
            return t = e,
            i
        } (i);
        i > 56 ? (o ? $("#page-header").hasClass("visible") ? $("#page-header").removeClass("visible") : console.log() : $("#page-header").hasClass("visible") ? console.log() : $("#page-header").addClass("visible"), $("#page-header").addClass("fixed"), "0" === $("#go-up").css("opacity") && $("#go-up").velocity("stop").velocity({
            translateX: -30,
            rotateZ: 360,
            opacity: 1
        },
        {
            easing: "easeOutQuart",
            duration: 200
        })) : (0 === i && $("#page-header").removeClass("fixed").removeClass("visible"), $("#go-up").velocity("stop").velocity({
            translateX: 0,
            rotateZ: 180,
            opacity: 0
        },
        {
            easing: "linear",
            duration: 200
        }))
    },
    50, 100)),
    $("#go-up").on("click",
    function() {
        $("body").velocity("stop").velocity("scroll", {
            duration: 500,
            easing: "easeOutQuart"
        })
    }),
    $("#post-content").find("h1,h2,h3,h4,h5,h6").on("click",
    function(t) {
        e("#" + $(this).attr("id"))
    }),
    $(".toc-link").on("click",
    function(t) {
        t.preventDefault(),
        e($(this).attr("href"))
    })
});