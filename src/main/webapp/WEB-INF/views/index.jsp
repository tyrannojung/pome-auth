<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <style>
  /*
*
* ==========================================
* CUSTOM UTIL CLASSES
* ==========================================
*
*/
.social-link {
    color: #fff;
    background: #ff3f3f;
    display: block;
    transition: all 0.3s;
}

.social-link:hover, .social-link:focus {
    color: white;
    text-decoration: none;
}
.social-link .icon {
    width: 4rem;
    text-align: center;
    margin-right: 1.5rem;
    border-right: 1px solid rgba(255, 255, 255, 0.4);
}

.social-facebook {
    background: #3b5998;
}
.social-facebook:hover, .social-facebook:focus {
    background: #2d4373;
}
.social-link-gradient.social-facebook {
    background: linear-gradient(to right, #3b5998, #718dc8);
}

.social-google-plus {
    background: #dd4b39;
}
.social-google-plus:hover, .social-google-plus:focus {
    background: #c23321;
}
.social-link-gradient.social-google-plus {
    background: linear-gradient(to right, #dd4b39, #ec9a90);
}

.social-apple{
    background: #000000;
}

.social-apple:hover, .social-apple:focus {
    background: #323131;
}

.social-link-gradient.social-apple {
    background: linear-gradient(to right, #04C259, #53AA47);
}
		
.social-wechat{
    background: #04C259;
}
.social-wechat:hover, .social-wechat:focus {
    background: #53AA47;
}
.social-link-gradient.social-wechat {
    background: linear-gradient(to right, #04C259, #53AA47);
}		
		
/*
*
* ==========================================
* FOR DEMO PURPOSES
* ==========================================
*
*/
body {
    min-height: 100vh;
    background-color: #e8cbc0;
    background-image: linear-gradient(147deg, #e8cbc0 0%, #636fa4 100%);
}



.sub-color {
    background-color: #E6987A;
    background-image: linear-gradient(147deg, #CFD3E6 0%, #E6987A 100%);
}
  </style>
</head>
<body>
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
                            <!-- Google--><a href="" class="social-link social-google-plus d-flex align-items-center py-2 rounded-pill shadow-sm"><span class="icon py-1"><i class="fa fa-google fa-fw"></i></span><span class="font-weight-bold">Login with Google</span></a>
                        </li>
                        <li class="mb-2">
                            <!-- Apple --><a href="" class="social-link social-apple d-flex align-items-center py-2 rounded-pill shadow-sm"><span class="icon py-1"><i class="fa fa-apple fa-fw"></i></span><span class="font-weight-bold">Login with Apple</span></a>
                        </li>
                        <li class="mb-2">
                            <!-- Facebook--><a href="" class="social-link social-facebook d-flex align-items-center py-2 rounded-pill shadow-sm"><span class="icon py-1"><i class="fa fa-facebook-f fa-fw"></i></span><span class="font-weight-bold">Login with Facebook</span></a>
                        </li>
                       	<li class="mb-2">
                            <!-- Wechat --><a href="" class="social-link social-wechat d-flex align-items-center py-2 rounded-pill shadow-sm"><span class="icon py-1"><i class="fa fa-wechat fa-fw"></i></span><span class="font-weight-bold">Login with Wechat</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>