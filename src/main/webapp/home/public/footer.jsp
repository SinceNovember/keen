<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <footer class="footer-bg" style="background-image:url(${pageContext.request.contextPath}/${page.imagePath })">
   <div class="layout" id="footer">
    <div class="copyright">
     &copy;2018 - 2019 By SinceNovember
    </div>
    <div class="framework-info">
     <span>Driven - </span>
     <a href="https://hexo.io"><span>Hexo</span></a>
     <span class="footer-separator">|</span>
     <span>Theme - </span>
     <a href="https://github.com/Molunerfinn/hexo-theme-melody"><span>Melody</span></a>
    </div>
   </div>
  </footer>
  
  
  
  <i class="fa fa-arrow-up" id="go-up" aria-hidden="true"></i>
    <section class="rightside" id="rightside">
   <i class="fa fa-moon nightshift_pc kk" id="nightshift_pc"></i>
   <div class="progress_show">
    <span class="progress-num">0</span>
   </div>
  </section>
  
    <div class="search-dialog" id="local-search">
	<div class="search-dialog__title" id="local-search-title">
				本地搜索
			</div>
			<div id="local-input-panel">
				<div id="local-search-input">
					<div class="local-search-box">
						<input class="local-search-box--input" placeholder="搜索文章" onkeyup="searchWord(this)">
					</div>
				</div>
			</div>
			<hr>
			<div id="local-search-results">
				<div id="local-hits">
					<div class="search-result-list">
			<div id="display">
<!-- 			显示查询的结果 -->
			</div>
					</div>
				</div>
			</div>
			<span class="search-close-button">
				<i class="fa fa-times">
				</i>
			</span>
  </div>
  <div class="search-mask"></div>