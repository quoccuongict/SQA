<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Trang chủ</title>
	
	<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
    <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
</head>

<body class="no-skin">
	<div id="navbar" class="navbar navbar-default          ace-save-state">
	    <div class="navbar-container ace-save-state" id="navbar-container">
	        <div class="navbar-header pull-left">
	            <a href="#" class="navbar-brand">
	                <small>
	                    <i class="fa fa-leaf"></i>
	                    Trang quản trị
	                </small>
	            </a>
	        </div>
	        <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
	            <ul class="nav ace-nav">
	                <li class="light-blue dropdown-modal">
	                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
	                        Xin chào, [Admin]
	                    </a>
	                </li>
	                <li class="light-blue dropdown-modal">
	                    <a href="">
	                        <i class="ace-icon fa fa-power-off"></i>
	                        Thoát
	                    </a>
	                </li>
	            </ul>
	        </div>
	    </div>
	</div>
	
	<div class="main-container" id="main-container">
    	<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>
		
		<!-- menu -->
    	<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
		    <script type="text/javascript">
		        try{ace.settings.loadState('sidebar')}catch(e){}
		    </script>
		    <div class="sidebar-shortcuts">
		        <div class="sidebar-shortcuts-large">
		            <button class="btn btn-success">
		                <i class="ace-icon fa fa-signal"></i>
		            </button>
		
		            <button class="btn btn-info">
		                <i class="ace-icon fa fa-pencil"></i>
		            </button>
		
		            <button class="btn btn-warning">
		                <i class="ace-icon fa fa-users"></i>
		            </button>
		
		            <button class="btn btn-danger">
		                <i class="ace-icon fa fa-cogs"></i>
		            </button>
		        </div>
		        <div class="sidebar-shortcuts-mini">
		            <span class="btn btn-success"></span>
		
		            <span class="btn btn-info"></span>
		
		            <span class="btn btn-warning"></span>
		
		            <span class="btn btn-danger"></span>
		        </div>
		    </div>
		    <ul class="nav nav-list">
		        <li >
		            <a href="#" class="dropdown-toggle">
		                <i class="menu-icon fa fa-list"></i>
		                <span class="menu-text"></span>
		                Quản lí bảo hiểm y tế
		                <b class="arrow fa fa-angle-down"></b>
		            </a>
		            <b class="arrow"></b>
		            <ul class="submenu">
		                <li>
		                    <a href='<c:url value="/admin-insurrance?type=list&page=1&maxPageItem=2&sortName=startdate&sortBy=asc"/>'>
		                        <i class="menu-icon fa fa-caret-right"></i>
		                        Quản lí danh sách
		                    </a>
		                    <b class="arrow"></b>
		                </li>
		                <li>
		                    <a href="">
		                        <i class="menu-icon fa fa-caret-right"></i>
		                        Báo cáo
		                    </a>
		                    <b class="arrow"></b>
		                </li>
		                <li>
		                    <a href='<c:url value="/config-insurrance?type=list"/>'>
		                        <i class="menu-icon fa fa-caret-right"></i>
		                        Cấu hình
		                    </a>
		                    <b class="arrow"></b>
		                </li>
		            </ul>
		        </li>
		    </ul>
		    <div class="sidebar-toggle sidebar-collapse">
		        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
		    </div>
		</div>
    	<!-- menu -->
    	
    	<!-- main content -->
    	
    	<div class="main-content">
		    <div class="main-content-inner">
		        <div class="breadcrumbs" id="breadcrumbs">
		            <script type="text/javascript">
		                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
		            </script>
		            <ul class="breadcrumb">
		                <li>
		                    <i class="ace-icon fa fa-home home-icon"></i>
		                    <a href="#">Trang chủ</a>
		                </li>
		                <li class="active">Chỉnh sửa bảo hiểm</li>
		            </ul><!-- /.breadcrumb -->
		        </div>
		        <div class="page-content">
		            <div class="row">
		                <div class="col-xs-12">
		                        <c:if test="${not empty messageResponse}">
											<div class="alert alert-${alert}">
		  										${messageResponse}
											</div>
								</c:if>
		                        <form id="formSubmit" action="<c:url value='/edit-insurrance'/>" method="get">
		                            <div class="form-group">
		                                <label class="col-sm-3 control-label no-padding-right">Mức bảo hiểm</label>
		                                <div class="col-sm-9">
		                                    <input type="text" class="form-control" id="typeLevel" name="typeLevel" value="${levelPrice.typeLevel}"/>
		                                </div>
		                            </div>
		                            <br/>
		                            <br/>
		                            <div class="form-group">
		                                <label class="col-sm-3 control-label no-padding-right">Giá bảo hiểm</label>
		                                <div class="col-sm-9">
		                                    <input type="text" class="form-control" id="price" name="price" value="${levelPrice.price}"/>
		                                </div>
		                            </div>
		                            <br/>
		                            <br/>
		                            <div class="form-group">
		                                <label class="col-sm-3 control-label no-padding-right">Mô tả</label>
		                                <div class="col-sm-9">
		                                    <input type="text" class="form-control" id="description" name="description" value="${levelPrice.description}"/>
		                                </div>
		                            </div>
		                            <br/>
		                            <br/>
		                            <div class="form-group">
		                                <div class="col-sm-12">
		                                    <c:if test="${not empty levelPrice.id}">
		                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Cập nhật mức bảo hiểm" id="btnAddOrUpdateNew"/>
		                                    </c:if>
		                                    <c:if test="${empty levelPrice.id}">
		                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Thêm mức bảo hiểm" id="btnAddOrUpdateNew"/>
		                                    </c:if>
		                                </div>
		                            </div>
		                            <input type="hidden" value="${levelPrice.id}" id="id" name="id"/>
		                        </form>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
    	<!-- end main content -->
		
		<!-- footer -->
    	<div class="footer">
		    <div class="footer-inner">
		        <div class="footer-content">
								<span class="bigger-120">
									<span class="blue bolder">Ace</span>
									Application &copy; 2013-2014
								</span>
		
		            &nbsp; &nbsp;
		            <span class="action-buttons">
									<a href="#">
										<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
									</a>
		
									<a href="#">
										<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
									</a>
		
									<a href="#">
										<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
									</a>
								</span>
		        </div>
		    </div>
		</div>
    	<!-- footer -->
    	
    	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
    </div>

	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
	
	<!-- page specific plugin scripts -->
	<script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
	
</body>
</html>