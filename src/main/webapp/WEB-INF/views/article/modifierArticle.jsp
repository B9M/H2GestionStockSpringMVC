<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@ include file="/WEB-INF/views/includes/include.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><fmt:message code="common.titre"/></title>

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
							<fmt:message code="article.modifier" />
						</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>



				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<fmt:message code="article.modifier" />
							</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
							
							<c:url value="/article/enregistrer" var="urlEnregistrer"/>
								<f:form modelAttribute="article" action="${urlEnregistrer }"
									method="POST" enctype="multipart/form-data">
									
			                        <f:hidden path="idArticle"/>
									<f:hidden path="photo"/>
									
									<div class="form-group">
										<label><fmt:message code="article.codeArticle" /></label>
										<f:input path="codeArticle" class="form-control" placeholder="Code Article ..." />
									</div>

									<div class="form-group">
										<label><fmt:message code="article.designation" /></label>
										<f:input path="designation" class="form-control"
											placeholder="Designation ..." />
									</div>

									<div class="form-group">
										<label><fmt:message code="article.prixUnitaireHT" /></label>
										<f:input id="prixUnitaireHT" path="prixUnitaireHT" class="form-control"
											placeholder="Prix Unitaire HT ..." />
									</div>

									<div class="form-group">
										<label><fmt:message code="article.tauxTva" /></label>
										<f:input id="tauxTva" path="tauxTva" class="form-control"
											placeholder="Taux TVA ..." />
									</div>
									
									<div class="form-group">
										<label><fmt:message code="article.prixUnitaireTTC" /></label>
										<f:input  id="prixUnitaireTTC" path="prixUnitaireTTC" class="form-control"
											placeholder="Prix Unitaire TTC ..." />
									</div>
									
									 <div class="form-group">
										<label><fmt:message code="article.idCategory" /></label>
	<f:select class="form-control" id="articleSelect" name="articleSelect" path="category.idCategory">

    <c:forEach var="categories" items="${categories }">
        <f:option value="${categories.idCategory }"><c:out value="${categories.codeCategory } ::: ${categories.designation}"/></f:option>
    </c:forEach>
</f:select>

									</div> 
									
										<!-- 

I don't think so. Either have a getFullName() getter in your object returning the concatenation of last and first names, 
or display the options one by one, in a loop:

<form:select id="userSelect" name="userId" path="user.id">
    <option value="">Select to Edit</option>
    <c:forEach var="theUser" items="${user.userList}">
        <form:option value="${theUser.id}"><c:out value="${theUser.lastname} ${theUser.firstname}"/></form:option>
    </c:forEach>
</form:select>

With concatenation performed by user.getFullName():

<form:select path="user"
   items="${user.userList}"
   itemValue="id"
   itemLabel="fullName">
</form:select>

									 -->
									
									<div class="form-group">
										<label><fmt:message code="common.photo" /> </label> 
										<input type="file" name="file" >
									</div>


									<div class="panel-footer">
										<button type="submit" class="btn btn-primary">
											<i class="fa fa-save">&nbsp;<fmt:message
													code="common.enregistrer" /></i>
										</button>

										<a href="<c:url value="/article/"/>" class="btn btn-danger">
											<i class="fa fa-arrow-left"> <fmt:message
													code="common.annuler" /></i>
										</a>
									</div>



								</f:form>
								<!-- /.table-responsive -->
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>



				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

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
			<!-- add Tva Auto Calcul  -->
	<script
		src="<%=request.getContextPath()%>/resources/javascript/article.js"></script>

</body>

</html>
