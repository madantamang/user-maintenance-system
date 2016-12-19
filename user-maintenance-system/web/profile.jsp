<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Profile - User Maintenance System</title>

  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
  <link href="bootstrap/css/datepicker.css" rel="stylesheet" type="text/css"/>
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
             <div id="main">
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">
                <span class="glyphicon glyphicon-user"></span>  My Profile
            </h2>
        </div>
    </div>

    <!-- start:real estates detail -->
    <div class="row" id="real-profile-detail">
        <div class="col-lg-4 col-md-4 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <header class="panel-title">
                        <div class="text-center">
                            <strong>${currentSessionUser.firstName}</strong> <strong>${currentSessionUser.lastName}</strong>
                        </div>
                    </header>
                </div>
                <div class="panel-body">
                    <div class="text-center" id="author">
                        <img src="http://placehold.it/215" alt=''/>
                        <h3>@${currentSessionUser.userName}</h3>
                        <small class="label label-info">${currentSessionUser.gender}</small>
                        
                        <p>The purpose of this project is to create a **user maintenance system** that allows a user to sign up, create a profile, activity details and login in to the system.</p>
                        <p>Last Login :<fmt:formatDate type="both" 
            value="${profileDetails.lastLoginDate}" /> </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-8 col-md-8 col-xs-12">
            <div class="panel">
                <div class="panel-body">
                    <ul id="myTab" class="nav nav-pills">
                       
                        <li class="active"><a href="#detail" data-toggle="tab">Detail</a></li>
                        <li class=""><a href="#myrnagroup" data-toggle="tab">My Group</a></li>
                        <li class=""><a href="#activity" data-toggle="tab">Activity</a></li>
                        <li class=""><a href="#updateinfo" data-toggle="tab">Profile Update</a></li>
                        <li class=""><a href="#profilepic" data-toggle="tab">Profile Picture</a></li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                    
                        <div class="tab-pane fade active in" id="detail">
                            <p></p>
                            <h4>Short Detail</h4>
                            <p>The purpose of this project is to create a user maintenance system that allows a user to sign up, create a profile, activity details and login in to the system.</p>
                            <table class="table table-striped">
                                <tbody>
                                    <tr><td class="active">First Name</td><td>${profileDetails.firstName} </td></tr>
                                    <tr><td class="active">Last Name </td><td>${profileDetails.lastName}</td></tr>
                                    <tr><td class="active">Email</td><td>${profileDetails.email} </td></tr>
                                    <tr><td class="active">Address </td><td>${profileDetails.address} </td></tr>
                                    <tr><td class="active">Phone No. </td><td>${profileDetails.phoneno}</td></tr>
                                    <tr><td class="active">Birth Date </td><td>${profileDetails.dob}</td></tr>
                                     <tr><td class="active">Total RNA Group </td><td>5 </td></tr>
                                    <tr><td class="active"> Update Details</td><td><a href="#updateinfo" data-toggle="tab" aria-expanded="false">Click here</a></td></tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane fade in" id="myrnagroup">
                            
                            <table class="table table-hover table-striped">
                        <thead>
                            <tr>
                                <th>S.N</th>
                                <th>Group Name</th>
                                <th>Total RNA</th>
                            </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${currentUserRNAGroup}" var="item" varStatus="loop">
                                 <tr>
                                        <td><c:out value="${loop.index + 1}" /></td>
                                        <td><c:out value="${item.groupName}" /></td>
                                        <td><c:set var="idsval" value="${fn:split(item.rnaIds, ',')}" />
                                         <c:set var="idsvallenth" value="${fn:length(idsval)}" />
                                         <c:out value="${idsvallenth}" /> </td>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>
                        </div>
                                     
                        <div class="tab-pane fade in" id="activity">
                                 <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Activity</th>
                                        <th>Description</th>
                                        <th>Date/Time</th>

                                    </tr>
                                </thead>
                                <tbody>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>

                                        </tr>

                                </tbody>
                            </table>
                            
                        </div>
                        <div class="tab-pane fade" id="updateinfo">
                            <p></p>
                            <form role="form" method="POST" action='${pageContext.request.contextPath}/profile'>
                                <div class="form-group">
                                    <label>First name</label>
                                    <input type="text" name="firstname" value="<c:out value="${profileDetails.firstName}" />" class="form-control rounded" placeholder="Enter first name">
                                </div>
                                <div class="form-group">
                                    <label>Last name</label>
                                    <input type="text" name="lastname" value='<c:out value="${profileDetails.lastName}" />' class="form-control rounded" placeholder="Enter last name">
                                </div>
                                <div class="form-group">
                                    <label>Email </label>
                                    <input type="email" name="email" value='<c:out value="${profileDetails.email}" />' class="form-control rounded" placeholder="Enter email Id">
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <input type="text" name="address" value='<c:out value="${profileDetails.address}" />' class="form-control rounded" placeholder="Enter address">
                                </div>
                                  <div class="form-group">
                                <label for="state">State</label>
                                   <select class="form-control" id="state" name="state">
                                   <option value="0">--select state--</option>
                                  <option value="AL">Alabama</option>
                                  <option value="AK">Alaska</option>
                                  <option value="AZ">Arizona</option>
                                  <option value="AR">Arkansas</option>
                                  <option value="CA">California</option>
                                  <option value="CO">Colorado</option>
                                  <option value="CT">Connecticut</option>
                                  <option value="DE">Delaware</option>
                                  <option value="DC">District Of Columbia</option>
                                  <option value="FL">Florida</option>
                                  <option value="GA">Georgia</option>
                                  <option value="HI">Hawaii</option>
                                  <option value="ID">Idaho</option>
                                  <option value="IL">Illinois</option>
                                  <option value="IN">Indiana</option>
                                  <option value="IA">Iowa</option>
                                  <option value="KS">Kansas</option>
                                  <option value="KY">Kentucky</option>
                                  <option value="LA">Louisiana</option>
                                  <option value="ME">Maine</option>
                                  <option value="MD">Maryland</option>
                                  <option value="MA">Massachusetts</option>
                                  <option value="MI">Michigan</option>
                                  <option value="MN">Minnesota</option>
                                  <option value="MS">Mississippi</option>
                                  <option value="MO">Missouri</option>
                                  <option value="MT">Montana</option>
                                  <option value="NE">Nebraska</option>
                                  <option value="NV">Nevada</option>
                                  <option value="NH">New Hampshire</option>
                                  <option value="NJ">New Jersey</option>
                                  <option value="NM">New Mexico</option>
                                  <option value="NY">New York</option>
                                  <option value="NC">North Carolina</option>
                                  <option value="ND">North Dakota</option>
                                  <option value="OH">Ohio</option>
                                  <option value="OK">Oklahoma</option>
                                  <option value="OR">Oregon</option>
                                  <option value="PA">Pennsylvania</option>
                                  <option value="RI">Rhode Island</option>
                                  <option value="SC">South Carolina</option>
                                  <option value="SD">South Dakota</option>
                                  <option value="TN">Tennessee</option>
                                  <option value="TX">Texas</option>
                                  <option value="UT">Utah</option>
                                  <option value="VT">Vermont</option>
                                  <option value="VA">Virginia</option>
                                  <option value="WA">Washington</option>
                                  <option value="WV">West Virginia</option>
                                  <option value="WI">Wisconsin</option>
                                  <option value="WY">Wyoming</option>
                          </select>		
                              </div>
                                <div class="form-group">
                                    <label>Phone</label>
                                    <input type="text" name="phoneno" value='<c:out value="${profileDetails.phoneno}" />' class="form-control rounded" placeholder="Format (000)0000000">
                                </div>
                                  <div class="form-group">
                                    <label>Birth Date</label>
                                    <input type="text" data-date-format="dd-mm-yyyy" name="dob" value='<c:out value="${profileDetails.dob}" />' class="form-control rounded datepicker" placeholder="Enter birth date">
                                </div>
                                <div class="form-group">
                                    <label>About Me</label>
                                    <textarea name="aboutme" class="form-control rounded" style="height: 100px;"><c:out value="${profileDetails.aboutMe}" /></textarea>
                                    <p class="help-block">Please be polite and professional</p>
                                </div>
                                <div class="form-group">
                                    <button type="submit" name="profileupdate" class="btn btn-danger" data-original-title="" title="">Update Profile</button>
                                </div>
                            </form>
                        </div>
                        <div class="tab-pane fade" id="profilepic">
                              <h4>Update your Profile Image</h4>
                              <p>Please do not upload large size file. File size 215 px * 215 px will be better.</p>
                              <form action="" method="post" enctype="multipart/form-data" id="js-upload-form">
                            <div class="form-inline">
                              <div class="form-group">
                                <input type="file" name="files[]" id="js-upload-files" multiple>
                              </div>
                              <button type="submit" class="btn btn-sm btn-primary" id="js-upload-submit">Upload files</button>
                            </div>
                          </form>
                              
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
             
              <jsp:include page="/WEB-INF/_footer.jsp"></jsp:include>
         </div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap-datepicker.js" type="text/javascript"></script>
<script type="text/javascript">
    $('.datepicker').datepicker();
</script>
</body>
</html>