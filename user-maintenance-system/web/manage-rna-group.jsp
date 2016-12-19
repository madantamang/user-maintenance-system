<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>My RNA Group - User Maintenance System</title>

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
                <span class="glyphicon glyphicon-dashboard"></span>   My RNA Group
                    </h2>
                </div>
            </div>
              <div class="row">
            <table class="table table-hover table-striped">
        <thead>
            <tr>
                <th>S.N</th>
                <th>Name</th>
                <th>Total RNA in group</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userRnaGroupList}" var="item" varStatus="loop">
                <tr>
                     <td><c:out value="${loop.index + 1}" /></td>
                    <td><c:out value="${item.groupName}" /></td>
                     <td>
                         <c:set var="idsval" value="${fn:split(item.rnaIds, ',')}" />
                         <c:set var="idsvallenth" value="${fn:length(idsval)}" />
                         <span class="label label-primary"><c:out value="${idsvallenth}" /> RNA</span>
                     </td>
                    <td><a class="btn btn-info" href="${pageContext.request.contextPath}/rnagroup?action=edit&userRnaGroupId=<c:out value="${item.userGroupId}"/>">Update</a></td>
                    <td><a class="btn btn-info" onclick="return confirm('Are you sure you want to delete this rna?');" href="${pageContext.request.contextPath}/rnagroup?action=delete&userRnaGroupId=<c:out value="${item.userGroupId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a class="btn btn-default" href="${pageContext.request.contextPath}/rnagroup?action=insert">Create RNA Group</a></p>
              </div>
        <jsp:include page="/WEB-INF/_footer.jsp"></jsp:include>
         </div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>