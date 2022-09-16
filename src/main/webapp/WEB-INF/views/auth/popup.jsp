<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Header -->
    <%@include file="../include/header.jsp" %>
    <!-- Header End -->
</head>
<body class="popup_body">
	<button type="button" class="close" aria-label="Close" style=" margin-right: 7px; margin-top: 5px; " onclick="close_popup();">
	  <span aria-hidden="true">&times;</span>
	</button>
	<!-- For Demo Purpose -->
	<div class="container py-5 main-color">
	    <header class="text-center text-white">
	    	<img src="https://cache.wemixnetwork.com/web-auth/img/light/logo_wemix.png" alt="" class="sc-jrAGrp kDjmBz">
	        <h1 class="display-4">OAuth 2.0</h1>
	        <p class="lead mb-0">Source code that expresses my coding style and skills</p>
	        <p class="font-italic">By 
	            <a href="https://clever-team-32f.notion.site/6b53193216ab4fc99804c427a0c7deb3" class="text-white">
	                <u>tyrannojung</u>
	            </a>
	        </p>
	    </header>
	</div>
	<div class="container">
	    <div class="row">
	        <div class="col-lg-7 mx-auto text-center">
	            <div class="card mb-4 shadow-sm">
	                <div class="card-body p-5 sub-color">
	                    <!-- Block Social Links-->
	                    <ul class="list-unstyled">   
	                    	<li class="mb-2">
	                            <!-- Google--><a href="javascript:void(0);" class="social-link social-google-plus d-flex align-items-center py-2 rounded-pill shadow-sm" onclick="google_login();"><span class="icon py-1"><i class="fa fa-google fa-fw"></i></span><span class="font-weight-bold">Login with Google</span></a>
	                        </li>
	                        <li class="mb-2">
	                            <!-- Apple --><a href="javascript:void(0);" class="social-link social-apple d-flex align-items-center py-2 rounded-pill shadow-sm" onclick="apple_login();"><span class="icon py-1"><i class="fa fa-apple fa-fw"></i></span><span class="font-weight-bold">Login with Apple</span></a>
	                        </li>
	                        <li class="mb-2">
	                            <!-- Facebook--><a href="javascript:void(0);" class="social-link social-facebook d-flex align-items-center py-2 rounded-pill shadow-sm" onclick="facebook_login();"><span class="icon py-1"><i class="fa fa-facebook-f fa-fw"></i></span><span class="font-weight-bold">Login with Facebook</span></a>
	                        </li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
<script>

//부모팝업 닫기
function close_popup(){
	parent.closeIFrame();
	
}

function google_login(){
	window.name = "parentForm";
	window.open('${googleOauthUrl}', "childForm", "width=400, height=750, left=100, top=50");
	
}

function apple_login(){
	window.name = "parentForm";
	window.open('${appleOauthUrl}', "childForm", "width=400, height=750, left=100, top=50");

}

function facebook_login(){
	window.name = "parentForm";
	window.open('${facebookOauthUrl}', "childForm", "width=400, height=750, left=100, top=50");
	
}

</script>
</body>
</html>