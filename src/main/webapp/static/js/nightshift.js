$(function () {



    var next_mode = $('body').hasClass('night-mode') ? 'day' : 'night';
    // setLocalData('read-mode', next_mode);
    changeReadModel();


    $(".kk").click(function () {

        switchReadMode();

        // var next_mode = $('body').hasClass('night-mode') ? 'day' : 'night';
        // setLocalData('read-mode', next_mode);


    })

    function switchReadMode() {
        var next_mode = $('body').hasClass('night-mode') ? 'day' : 'night';
        setLocalData('read-mode', next_mode);
        changeReadModel();
    }

    function changeReadModel() {

        if (getLocalData('read-mode') == 'night') {


            $('body').addClass('night-mode');
            $("#nightshift_pc,#nightshift_id").removeClass("fas fa-moon");
            $("#nightshift_pc,#nightshift_id").addClass("fas fa-sun");

            $("body").css("color", "#99a9bf");

            $("footer").addClass("dfooter");

            $("#sidebar").css({ "background": "#2d3035  ", "box-shadow": "-0.25rem 0 0.25rem #2d3035  " });
        
            $("#local-search").addClass("dsearch");
            $(".at-share-btn-elements").addClass("dshare");

            $("h1, h2, h3, h4, h5, h6").css("color", "#99a9bf");

            $(".article-container code").css({ "background": "#7A5353", "color": "#99a9bf" });

            
            $("#vcomment").addClass("vc");

            // $("#top-container,#nav").css("background-image", "url('/img/top1.jpg')");
            // $(".footer-bg").css("background-image", "url('/img/top1.jpg')");

            $(".recent-post-item .article-title").css("color", "#99a9bf");

            


            $("#page-header").addClass("dpagehead");


            $("blockquote").css({ "border-left": "0.2rem solid #7A5353", "color": "#99a9bf" });

            $(".post-meta__tags,hr").css("background", "0");

            $(".donate-btn").css("background-color", "#616A6B");



            // 代碼框
            $(".article-container .highlight").addClass("dhighlight");


            //friendlink
            $(".post-cards,.md-links-item").addClass("dfriendlink");
            $(".md-links a").css("color", "#99a9bf");

            //music
            $(".aplayer").css({ "color": "#000000", "filter": "brightness(0.6)" });


            //archives
            $(".article-sort-item__title").css("color", "#99a9bf");

            
            //categories
            $(".category-list a").css("color", "#99a9bf");

            $(".translate_pc,.nightshift_pc").css("background-color", "#009d92");

            //打賞
            $("#donate-modal-container .donate-modal-background .donate-modal").css("background", "#2d3035");

            $(".translate_pc,.nightshift_pc,.progress_show").css("background-color", "#2d3035");

            //图片
            $("img").css("filter", "brightness(0.6)");
            // $("#nav").css("filter", "brightness(0.6)");
            // $("#top-container").css("filter","brightness(0.6)");


            //手機界面
            
                
                    
                    var _width = $(window).width();

                    if (_width <= 768) {
                        $("#page-header .menus a").css({ "color": "#99a9bf", "background": "#2d3035" });
                    }

                    if (_width <= 850) {
                        $("body").css("background-color", "rgb(45, 48, 53)");
                    }
                    else {
                        $("body").css("background-color", "#000");
                        $(".recent-post-item").css("background", "#2d3035 ");

                        

                    }
                
                    if (location.pathname == '/') {
                    }
                    else {
                        $("div#content-inner").css("background", "#2d3035  ");
                    }

            // 取消背景特效
            $("canvas").css("display", "none");

           
        }


        // 非夜間模式
        if ( getLocalData('read-mode') == 'day' ) {

            $('body').removeClass('night-mode');

            $("#nightshift_pc,#nightshift_id").removeClass("fas fa-sun");
            $("#nightshift_pc,#nightshift_id").addClass("fas fa-moon");
            
            $("body").css("color", "#4c4948");
            $("body").css("background-color", "white");
           

            $("footer").removeClass("dfooter");
            $("#local-search").removeClass("dsearch");
            $(".at-share-btn-elements").removeClass("dshare");
            
            $("#sidebar").css({ "background": "#f6f8fa  ", "box-shadow": "-0.25rem 0 0.25rem rgba(232,237,250,.6)   " });



            $("h1, h2, h3, h4, h5, h6").css("color", "#344c67");

            $(".article-container code").css({ "background": "rgba(27,31,35,.05)", "color": "#1f2d3d" });

            // $("#top-container,#nav").css("background-image", "url('/img/top.png')");
            // $(".footer-bg").css("background-image", "url('/img/top.png')");

            $(".recent-post-item .article-title").css("color", "#2e2e2e");

           


            $("#page-header").removeClass("dpagehead");


            $("blockquote").css({ "border-left": ".2rem solid #dfe2e5", "color": "#6a737d" });

            $(".post-meta__tags,hr").css("background", "0");

            $(".donate-btn").css("background-color", "#44b549");

            $("#vcomment").removeClass("vc");
            // 代碼框
            $(".article-container .highlight").removeClass("dhighlight");

            // -------------------------------------------------------------------
            //friendlink
            $(".post-cards,.md-links-item").removeClass("dfriendlink");
            $(".md-links a").css("color", "#333");

            //music
            $(".aplayer").css({ "color": "#000000", "filter": "brightness(1)" });


            //archives
            $(".article-sort-item__title").css("color", "#4c4948");

            

            //categories
            $(".category-list a").css("color", "#4c4948");

            $(".translate_pc,.nightshift_pc,.progress_show").css("background-color", "#49b1f5");

            //打賞
            $("#donate-modal-container .donate-modal-background .donate-modal").css("background", "#FFFFFF");


 
            //图片

            $("img").css("filter", "brightness(1)");
            // $("#nav").css("filter", "brightness(1)");
            // $("#top-container").css("filter","brightness(1)");

            //手機界面

            
                
                    var _width = $(window).width();
                    
                    if (_width <= 768) {
                        $("#page-header .menus a").css({ "color": "#000000", "background": "#FFFFFF" });
                    }

            
                    if (_width <= 850) {
                    
                    }
                    else {
                
                        $(".recent-post-item").css("background", "#fff ");
                        
                    }
                
                    if (location.pathname == '/') {
                    }
                    else {
                        $("div#content-inner").css("background", "#fff  ");
                    }

           
            //恢復背景特效
            $("canvas").css("display", "inline-block");


          
    }
        }
    





    function setLocalData(key, value) {
        if (window.localStorage) {
            window.localStorage.setItem(key, value);
        }
    }

    function getLocalData(key) {
        if (window.localStorage) {
            return window.localStorage.getItem(key);
        }
    }
}
)