<%@ page 
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" scope="request"
  value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Starter</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="${base}/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${base}/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${base}/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${base}/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
  <link rel="stylesheet" href="${base}/dist/css/skins/skin-blue.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- 导入导航栏 -->
  <c:import url="/WEB-INF/inc/header.jsp"/>

  <!-- OK -->
  <c:import url="/WEB-INF/inc/left-side.jsp"></c:import>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>用户管理
        <small>管理用户信息</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->

        <div class="row">
          <div class="col-md-12">
            <div class="box">
              <div class="box-header with-border">
                <h3 class="box-title">添加用户
                  <small>${error}</small>
                </h3>
              </div>
              <!-- /.box-header -->
              <div class="box-body">
                
                <!-- 表单 -->

                <!-- form start -->
                <form class="form-horizontal" 
                  method="post" action="${base}/user/save.do">  
                  <div class="box-body">
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
        
                      <div class="col-sm-10">
                        <input type="text" class="form-control" 
                          id="inputEmail3" placeholder="用户名"
                          name="username">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
        
                      <div class="col-sm-10">
                        <input type="password" class="form-control"
                         id="inputPassword3" placeholder="密码"
                         name="password">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputConfirm" class="col-sm-2 control-label">确认密码</label>
        
                      <div class="col-sm-10">
                        <input type="password" class="form-control" 
                         id="inputConfirm" placeholder="确认密码"
                         name="confirm">
                      </div>
                    </div>

                    <div class="form-group">
                      <label for="inputEmail" class="col-sm-2 control-label">e-mail</label>
        
                      <div class="col-sm-10">
                        <input type="email" class="form-control" 
                        id="inputEmail" placeholder="e-mail"
                        name="email">
                      </div>
                    </div>

                    <div class="form-group">
                      <label for="inputMobile" class="col-sm-2 control-label">电话</label>
        
                      <div class="col-sm-10">
                        <input type="text" class="form-control"
                         id="inputMobile" placeholder="电话"
                         name="mobile">
                      </div>
                    </div>
                  </div>
                  <!-- /.box-body -->
                  <div class="box-footer">
                    <button type="submit" class="btn btn-info pull-right">保存</button>
                  </div>
                  <!-- /.box-footer -->
                </form>

       
              </div>
              <!-- /.box-body -->

            </div>
            <!-- /.box -->
          </div>
       </div>



    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Footer -->
  <c:import url="/WEB-INF/inc/footer.jsp"></c:import>
  
  <c:import url="/WEB-INF/inc/sidebar.jsp"></c:import>
 
 
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="${base}/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${base}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${base}/dist/js/adminlte.min.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>
