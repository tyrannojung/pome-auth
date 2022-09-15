<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Header -->
	<%@include file="include/header.jsp" %>
    <!-- Header End -->
</head>
<body>
    <div class="loading loading_view" id="loading_bar">
      <div class="spinner-grow text-success" style="left: 50%; top: 50%; position: absolute;"></div>
    </div>
	<section class="wrap py-5">
	    <div class="container">
	        <!-- FOR DEMO PURPOSE -->
	        <div class="row">
	            <div class="col-lg-6 mx-auto">
	                <header class="text-center pb-5">
	                    <h1 class="h2">Bootstrap custom quote</h1>
	                    <p>Build a nicely styled quote in Bootstrap 4.<br>Bootstrap snippet by <a href="https://bootstrapious.com/snippets" class="font-italic text-info">Bootstrapious</a></p>
	                </header>
	            </div>
	        </div>
	        <!-- END -->
	        <div class="row">
	            <div class="col-lg-6 mx-auto">
	                <!-- CUSTOM BLOCKQUOTE -->
	                <blockquote class="blockquote blockquote-custom bg-white p-5 shadow rounded">
	                    <div class="blockquote-custom-icon bg-info shadow-sm"><i class="fa fa-quote-left text-white"></i></div>
	                    <p class="mb-0 mt-2 font-italic">"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod  tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
	                     ".
	                     <a href="javascript:void(0);" class="text-info" onclick="login_popup();">@consequat</a>
	                     </p>
	                    <footer class="blockquote-footer pt-4 mt-4 border-top">Someone famous in
	                        <cite title="Source Title">Source Title</cite>
	                    </footer>
	                </blockquote>
	                <!-- END -->
	            </div>
	        </div>
	    </div>
	</section>
</body>
<script>
	function login_popup(){
		$('.loading').css('display', 'block');
		setTimeout(function() {
			$('.wrap').append(
					'<div class="login_back" id="popup">'
						+ '<iframe class="iframe_custom" src="http://localhost:8081/run" frameborder="0" scrolling="no" title="web-auth"></iframe>'	
					+ '</div>'

		      );
			$('.loading').css('display', 'none');
			}, 1000);
	}
	
	$(function(){
		$('html').click(function(e){
			if($(e.target).parents('#popup').length < 1){
				if($("#popup").length){
					$('#popup').remove();
					
				}
		    }
		});
	});
	
	function closeIFrame(){
	     $('#popup').remove();
	}
</script>
</html>