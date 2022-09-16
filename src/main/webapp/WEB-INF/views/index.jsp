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
	                    <h1 class="h2">위메이드 면접 과제</h1>
	                    <p>Subject : Google Apple Facebook Login<br>Github link : <a href="https://github.com/tyrannojung/pome-auth" class="font-italic text-info" target='_blank'>tyrannojung</a></p>
	                </header>
	            </div>
	        </div>
	        <!-- END -->
	        <div class="row">
	            <div class="col-lg-6 mx-auto">
	                <!-- CUSTOM BLOCKQUOTE -->
	                <blockquote class="blockquote blockquote-custom bg-white p-5 shadow rounded">
	                    <div class="blockquote-custom-icon bg-info shadow-sm"><i class="fa fa-quote-left text-white"></i></div>
	                    <p class="mb-0 mt-2 font-italic">위믹스 홈페이지(<a href="https://wemixauction.com/" class="font-italic text-info" target='_blank'>링크</a>)를 참고하여 만들었습니다.
	                     <br/>
	                     <br/>
	                     주제 :
	                     <kbd>REST API</kbd>를 활용한 OAuth 2.0 
	                     <br/>
	                     <br/>
	                     활용기술 :
	                     <br/>
	                     <code>
	                     	JAVA-SPRING-GRADLE, HTML, CSS, JAVASCRIPT, JQUERY, BOOTSTRAP, OAUTH
	                     </code>
	                     <br/>
	                     <br/>
	                     결과물 :
	                     <br/>
	                     <br/>
	                     <button type="button" class="btn btn-primary btn-block" onclick="login_popup();">LOGIN</button>
	                     </p>
	                    <footer class="blockquote-footer pt-4 mt-4 border-top">Someone famous in
	                        <cite title="Source Title">Source Title</cite>
	                    </footer>
	                </blockquote>
	                <!-- END -->
	        <div class="row">
	            <div class="col-lg-6 mx-auto">
	                <header class="text-center">
	                    <i class="fa fa-arrow-circle-o-down" style="font-size:36px"></i>
	                    <p>Response</p>
	                </header>
	           	</div>
	        </div>
	        <blockquote class="blockquote blockquote-custom bg-white p-5 shadow rounded">
	        <div class="blockquote-custom-icon bg-info shadow-sm"><i class="fa fa-quote-left text-white"></i></div>
		        <div class="content_box">
	            <div>
		            <pre id="resultValue">

		            </pre>
	            </div>
	          </div>
          </blockquote>
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
						+ '<iframe class="iframe_custom" src="https://pome.nodehome.io/run" frameborder="0" scrolling="no" title="web-auth"></iframe>'	
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

	function connectIFrame(userInfo){
		$('#popup').remove();
		var joFunc = JSON.parse(userInfo);
		selectText = JSON.stringify(joFunc, null, 2);
        $("#resultValue").empty();
        $("#resultValue").append(selectText);

	}
</script>
</html>