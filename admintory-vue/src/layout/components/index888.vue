<template>
		<div class="sidebar">
			<div class="logo-details">
				<i class='bx bxl-slack'></i>
				<span class="logo_name">ADMINTORY</span>
			</div>
			<div class="menu">
				<ul class="nav-links">
					<li>
						<a href="#" class="link-href" menu_id="1" menu_name="控制条" menu_url="./test.html">
							<i class='bx bx-grid-alt'></i>
							<span class="link_name">控制台</span>
						</a>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="#">控制台</a></li>
						</ul>
					</li>
					<li class="has-sub">
						<div class="icon-link">
							<a href="#">
								<i class='bx bx-collection'></i>
								<span class="link_name">Category</span>
							</a>
							<i class='bx bxs-chevron-down arrow'></i>
						</div>
						<ul class="sub-menu">
							<li><a class="link_name" href="#">Category</a></li>
							<li><a class="link-href" href="#" menu_id="2" menu_name="控制条111111" menu_url="./input.html">HTML & CSS</a></li>
							<li><a href="#">JavaScript</a></li>
							<li><a href="#">PHP & MySQL</a></li>
						</ul>
					</li>
					<li class="has-sub">
						<div class="icon-link">
							<a href="#">
								<i class='bx bx-collection'></i>
								<span class="link_name">Posts</span>
							</a>
							<i class='bx bxs-chevron-down arrow'></i>
						</div>
						<ul class="sub-menu">
							<li><a class="link_name" href="#">Posts</a></li>
							<li><a class="link-href" href="#" menu_id="3" menu_name="控制条2222" menu_url="www.baidu.com">Web Design</a></li>
							<li><a href="#">Login Form</a></li>
							<li><a href="#">Card Design</a></li>
						</ul>
					</li>
<!-- 					<li>
						<div class="icon-link">
							<a href="#">
								<span class="link_name">Posts</span>
							</a>
								<i class='bx bx-book-alt'></i>
							<i class='bx bxs-chevron-down arrow'></i>
						</div>
						<ul class="sub-menu">
							<li><a class="link_name" href="#">Posts</a></li>
							<li><a href="#">Web Design</a></li>
							<li><a href="#">Login Form</a></li>
							<li><a href="#">Card Design</a></li>
						</ul>
					</li> -->
					<li>
						<div class="icon-link">
							<a href="#">
								<i class='bx bx-pie-chart-alt-2'></i>
								<span class="link_name">Analytics</span>
							</a>
						</div>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="#">Analytics</a></li>
						</ul>
					</li>
					<li>
						<div class="icon-link">
							<a class="link-href" href="#" menu_name="Chart" menu_id="Chart" menu_url="123">
								<i class='bx bx-line-chart'></i>
								<span class="link_name">Chart</span>
							</a>
						</div>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="#">Chart</a></li>
						</ul>
					</li>
					<li>
						<div class="icon-link">
							<a href="#">
								<i class='bx bx-plug'></i>
								<span class="link_name">Plugins</span>
							</a>
							<i class='bx bxs-chevron-down arrow'></i>
						</div>
						<ul class="sub-menu">
							<li><a class="link_name" href="#">Plugins</a></li>
							<li><a href="#">UI Face</a></li>
							<li><a href="#">Pigments</a></li>
							<li><a href="#">Box Icons</a></li>
						</ul>
					</li>
					<li>
						<a href="#">
							<i class='bx bx-compass'></i>
							<span class="link_name">Explore</span>
						</a>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="#">Explore</a></li>
						</ul>
					</li>
					<li>
						<a href="#">
							<i class='bx bx-history'></i>
							<span class="link_name">History</span>
						</a>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="#">History</a></li>
						</ul>
					</li>
					<li>
						<a href="#">
							<i class='bx bx-cog'></i>
							<span class="link_name">Setting</span>
						</a>
						<ul class="sub-menu blank">
							<li><a class="link_name" href="#">Setting</a></li>
						</ul>
					</li>
					<li>

					</li>
				</ul>
			</div>
		</div>
</template>

<script>
export default {
    name: 'Layout',
    data(){
        return {
            msg : 'Welcome'
        };
    },
    methods: {
        //换主题
        theme(type) {
        window.document.documentElement.setAttribute( "data-theme", type );
        }
    }
}
</script>

<style>

</style>