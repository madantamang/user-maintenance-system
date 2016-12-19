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
  <title>User List - User Maintenance System</title>

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
                <span class="glyphicon glyphicon-user"></span>   All Users
            </h2>
        </div>
    </div>
              <div class="row">
            <table class="table table-hover table-striped">
        <thead>
            <tr>
                <th>S.N</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>DOB</th>
                <th>Email</th>
                <th>Username</th>
                <th>Address</th>
                <th>Phone No</th>
                <th>Join Date</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="item" varStatus="loop">
                <tr>
                    <td><c:out value="${loop.index + 1}" /></td>
                    <td><c:out value="${item.firstName}" /></td>
                    <td><c:out value="${item.lastName}" /></td>
                     <td><c:out value="${item.gender}" /></td>
                    <td>
                        <c:choose>
                        <c:when test="${empty item.dob}">
                            -
                        </c:when>
                        <c:otherwise>
                           <c:out value="${item.dob}" />
                        </c:otherwise>
                    </c:choose>
                        
                    </td>
                    <td><c:out value="${item.email}" /></td>
                    <td><c:out value="${item.userName}" /></td>
                    <td>
                         <c:choose>
                        <c:when test="${empty item.address}">
                            -
                        </c:when>
                        <c:otherwise>
                           <c:out value="${item.address}" />
                        </c:otherwise>
                    </c:choose>
                    </td>
                    <td>
                         <c:choose>
                        <c:when test="${empty item.phoneno}">
                            -
                        </c:when>
                        <c:otherwise>
                           <c:out value="${item.phoneno}" />
                        </c:otherwise>
                    </c:choose>
                    </td>
                    <td><c:out value="${item.joinDate}" /></td>
                    
                    <td>
                        <a class="btn btn-info"  onclick="return confirm('Are you sure you want to delete this user?');" href="${pageContext.request.contextPath}/users?action=delete&userId=<c:out value="${item.userId}" />">Delete</a>
                                                
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a class="btn btn-default" href="${pageContext.request.contextPath}/users?action=insert">Add User</a></p>
              </div>
          <jsp:include page="/WEB-INF/_footer.jsp"></jsp:include>
         </div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>