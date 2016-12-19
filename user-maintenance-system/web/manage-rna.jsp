<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Manage RNA - User Maintenance System</title>

  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
<!-- style -->
  <link href="css/style.css" rel="stylesheet">
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>

     <!-- header section begin here -->
         <jsp:include page="/WEB-INF/_header.jsp"></jsp:include>
         <!-- header section end here -->
         
         <div class="container theme-showcase" role="main">
              <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">
                <span class="glyphicon glyphicon-certificate"></span>   Manage RNA
            </h2>
        </div>
    </div>
              <div class="row">
            <table class="table table-hover table-striped">
        <thead>
            <tr>
                <th>S.N</th>
                <th>Name</th>
                <th>Description</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${rnaList}" var="item" varStatus="loop">
                <tr>
                     <td><c:out value="${loop.index +1}" /></td>
                    <td><c:out value="${item.typeName}" /></td>
                     <td><c:out value="${item.description}" /></td>
                    <td><a class="btn btn-info" href="${pageContext.request.contextPath}/rna?action=edit&rnaId=<c:out value="${item.rnaId}"/>">Update</a></td>
                    <td><a class="btn btn-info" onclick="return confirm('Are you sure you want to delete this rna?');" href="${pageContext.request.contextPath}/rna?action=delete&rnaId=<c:out value="${item.rnaId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a class="btn btn-default" href="${pageContext.request.contextPath}/rna?action=insert">Create RNA</a></p>
              </div>
             

          <jsp:include page="/WEB-INF/_footer.jsp"></jsp:include>
         </div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>