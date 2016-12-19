<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">User Maintenance System</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li><a href="${pageContext.request.contextPath}/">Home</a></li>
         <li class="active"><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
          <li><a href="${pageContext.request.contextPath}/rna?action=list">Manage RNA</a></li>
          <li><a href="${pageContext.request.contextPath}/rnagroup?action=list">RNA Group</a></li>
          <li><a href="${pageContext.request.contextPath}/users?action=list">Users</a></li>
      </ul>
         <ul class="nav navbar-nav navbar-right">
             <li><a href="${pageContext.request.contextPath}/profile"> Welcome ${currentSessionUser.firstName}</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
         </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>