$(function() {
    var t = $(".recent-post-item img");
    0 === t.length && (t = $("#post-content img"));
    for (var a = 0; a < t.length; a++) {
        var o = $('<a href="' + t[a].src + '" data-fancybox="group" data-caption="' + t[a].alt + '" class="fancybox"></a>'),
        n = t[a].alt,
        e = $(t[a]).wrap(o);
        n && e.after('<div class="img-alt">' + n + "</div>")
    }
    $().fancybox({
        selector: "[data-fancybox]",
        loop: !0,
        transitionEffect: "slide",
        buttons: ["share", "slideShow", "fullScreen", "download", "thumbs", "close"]
    });
    var c = $(".gallery-item"),
    i = [];
    c.each(function(t, a) {
        i.push({
            src: $(a).data("url"),
            opts: {
                caption: $(a).data("title")
            }
        })
    }),
    c.on("click",
    function() {
        return $.fancybox.open(i, {
            loop: !0,
            transitionEffect: "slide"
        },
        c.index(this)),
        !1
    })
});