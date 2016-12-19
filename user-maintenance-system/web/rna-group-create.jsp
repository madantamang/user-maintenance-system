<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>RNA Group - User Maintenance System</title>

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
                <span class="glyphicon glyphicon-align-justify"></span>   Manage RNA Group
                    </h2>
                </div>
            </div>
             <form class="form-horizontal" action="rnagroup" method="POST">
                <div class="row">
                    
        <div class="col-xs-5">
            <select name="from[]" id="multiselect" class="form-control" size="13" multiple="multiple">
                <c:forEach items="${rnaList}" var="item" >
                <option value="${item.rnaId}">${item.typeName} </option>
                </c:forEach>
            </select>
        </div>
        
        <div class="col-xs-2">
            <button type="button" id="multiselect_undo" class="btn btn-primary btn-block">undo</button>
            <button type="button" id="multiselect_rightAll" class="btn btn-default btn-block"><i class="glyphicon glyphicon-forward"></i></button>
            <button type="button" id="multiselect_rightSelected" class="btn btn-default btn-block"><i class="glyphicon glyphicon-chevron-right"></i></button>
            <button type="button" id="multiselect_leftSelected" class="btn btn-default btn-block"><i class="glyphicon glyphicon-chevron-left"></i></button>
            <button type="button" id="multiselect_leftAll" class="btn btn-default btn-block"><i class="glyphicon glyphicon-backward"></i></button>
            <button type="button" id="multiselect_redo" class="btn btn-warning btn-block">redo</button>
        </div>
        
        <div class="col-xs-5">
            <select name="to[]" id="multiselect_to" class="form-control" size="13" multiple="multiple"></select>
                    <div class="row">
            <div class="col-sm-6">
                <button type="button" id="multiselect_move_up" class="btn btn-block"><i class="glyphicon glyphicon-arrow-up"></i></button>
            </div>
            <div class="col-sm-6">
                <button type="button" id="multiselect_move_down" class="btn btn-block col-sm-6"><i class="glyphicon glyphicon-arrow-down"></i></button>
            </div>
        </div>
        </div>
        </div>
                 <div class="row" style="margin-top: 20px;">
                 <div class="form-group">
                     <label for="group" class="col-sm-2 control-label">Group Name:</label>
                     <div class="col-sm-10">
                    <input type="text" class="form-control" name='groupname' id="group" placeholder="enter group name here.." required="">
                    <span class="help-block">*Group will be created if you select some RNA item.</span>
                     </div>
                  </div>
                    <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button type="submit" class="btn btn-primary btn-info">Save</button>
                    </div>
                    </div>
                 </div>
             </form>

        <jsp:include page="/WEB-INF/_footer.jsp"></jsp:include>
         </div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="http://crlcu.github.io/multiselect/dist/js/multiselect.min.js"></script>
    <script type="text/javascript">
    jQuery(document).ready(function($) {
        $('#multiselect').multiselect();
    });
    </script>
</body>
</html>