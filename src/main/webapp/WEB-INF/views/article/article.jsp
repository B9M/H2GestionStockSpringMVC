<%@ include file="/WEB-INF/views/includes/include.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><fmt:message code="common.titre" /></title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- DataTables CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<!-- Top Menu -->
			<%@ include file="/WEB-INF/views/menu_top/topMenu.jsp"%>
			<!-- Top Menu -->
			<!-- /.navbar-top-links -->
			<!-- Menu Left -->
			<%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp"%>
			<!--/.Menu Left  -->
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							<fmt:message code="common.article" />
						</h1>
					</div>


					<div class="row">
						<div class="col-lg-12">
							<ol class="breadcrumb">
								<li><a href="<c:url value="/article/nouveau"/>"><i
										class="fa fa-plus">&nbsp;<fmt:message code="common.ajouter" /></i></a></li>
								<li><a href="#"><i class="fa fa-download">&nbsp;<fmt:message
												code="common.exporter" /></i></a></li>
								<li><a href="#"><i class="fa fa-upload">&nbsp;<fmt:message
												code="common.importer" /></i></a></li>
							</ol>
						</div>
					</div>




					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<fmt:message code="article.liste" />
								</div>
								<!-- /.panel-heading -->
								<div class="panel-body">
									<table width="100%"
										class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th><fmt:message code="common.photo" /></th>
												<th><fmt:message code="article.codeArticle" /></th>
												<th><fmt:message code="article.designation" /></th>
												<th><fmt:message code="article.prixUnitaireHT" /></th>
												<th><fmt:message code="article.tauxTva" /></th>
												<th><fmt:message code="article.prixUnitaireTTC" /></th>
												<th><fmt:message code="article.idCategory" /></th>
												<th><fmt:message code="common.action"/></th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${articles }" var="article">
												<tr class="odd gradeX">
													<td class="center"><img src="${article.getPhoto() }"
														width="50px" height="50px" /></td>
													<td>${article.getCodeArticle() }</td>
													<td>${article.getDesignation() }</td>
													<td>${article.getPrixUnitaireHT() }</td>
													<td>${article.getTauxTva() }</td>
													<td>${article.getPrixUnitaireTTC() }</td>
													<td>${article.category.codeCategory }&nbsp;:::&nbsp;${article.category.designation } </td>
													
													
													
													
													
													
													
													
													
													
													
													
													
													
													<td><c:url
															value="/article/modifier/${article.getIdArticle() }"
															var="artModif" /> <a href="${artModif }"><i
															class="fa fa-edit"></i></a>&nbsp;|&nbsp; <a
														href="javascript:void(0)" data-toggle="modal"
														data-target="#modalArticle${article.getIdArticle() }"><i
															class="fa fa-trash-o">&nbsp;</i></a>
														<div class="modal fade"
															id="modalArticle${article.getIdArticle() }" tabindex="-1"
															role="dialog" aria-labelledby="myModalLabel"
															aria-hidden="true">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close"
																			data-dismiss="modal" aria-hidden="true">&times;</button>
																		<h4 class="modal-title" id="myModalLabel">
																			<fmt:message code="common.confirm.supprimer" />
																			:
																		</h4>
																	</div>
																	<div class="modal-body">
																		<fmt:message code="article.confirm.suppression.msg" />
																		: <br>
																		<br> <img src="${article.getPhoto() }"
																			width="100px" height="120px" /> &nbsp;&nbsp;&nbsp;
																			
												<label>  Code Article :&nbsp; </label>${article.getCodeArticle() } &nbsp;|||&nbsp;
													<label> <fmt:message code="article.designation"/> :&nbsp; </label>${article.getDesignation() } 
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-default"
																			data-dismiss="modal">
																			<fmt:message code="common.annuler" />
																		</button>
																		<c:url
																			value="/article/supprimer/${article.getIdArticle() }"
																			var="urlSuppression"></c:url>
																		<a href="${urlSuppression }" class="btn btn-danger"><i
																			class="fa fa-trash-o"></i>&nbsp;<fmt:message
																				code="common.confirmer" /></a>
																	</div>
																</div>
																<!-- /.modal-content -->
															</div>
															<!-- /.modal-dialog -->
														</div></td>
												</tr>
											</c:forEach>




										</tbody>
									</table>
									<!-- /.table-responsive -->
								</div>
								<!-- /.panel-body -->
							</div>
							<!-- /.panel -->
						</div>
						<!-- /.col-lg-12 -->
					</div>










					<!-- jQuery -->
					<script
						src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

					<!-- Bootstrap Core JavaScript -->
					<script
						src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

					<!-- Metis Menu Plugin JavaScript -->
					<script
						src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

					<!-- Custom Theme JavaScript -->
					<script
						src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>
					<!-- DataTables JavaScript -->
					<script
						src="<%=request.getContextPath()%>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
					<script
						src="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
					<script
						src="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

					<!-- Custom Theme JavaScript -->
					<script
						src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>

					<!-- Page-Level Demo Scripts - Tables - Use for reference -->
					<script>
						$(document).ready(function() {
							$('#dataTables-example').DataTable({
								responsive : true
							});
						});
					</script>
</body>

</html>
