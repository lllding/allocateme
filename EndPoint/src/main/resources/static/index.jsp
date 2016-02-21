<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="SG">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src = "jquery.js"></script>
<script type="text/javascript" src = "bootstrap.min.js"></script>
<script type="text/javascript" src = "lib/angular.min.js"></script>
<script type="text/javascript" src = "app.js"></script>
</head>
<body ng-app = "SG" ng-controller="mainController" >

<div class="intro-message">
<h1>First Page</h1>
<h3></h3>
<div>
<section>
<ul class = "nav nav-pills">
<li ng-class ="{active:tab ===1}"> <a href ng-click="tab =1">Submit job</a></li>
<li ng-class ="{active:tab ===2}"><a href ng-click="tab =2">Monitor Job</a></li>
<li ng-class ="{active:tab ===3}">	<a href ng-click="tab =3">CanceJob</a></li>
</ul>
</section>
</div>
<div class = "panel" ng-show="tab ===1">

<div class="container">
<div class="col-sm-8 col-sm-offset-2">
    
    <!-- PAGE HEADER -->
    <div class="page-header"><h1>Open Source Form Validation</h1></div>
   
    <!-- FORM -->
    <!-- pass in the variable if our form is valid or invalid -->
    <form name="userForm" ng-submit="submitForm(userForm.$valid)" action="/submit" novalidate> <!-- novalidate prevents HTML5 validation since we will be validating ourselves -->

        <!-- NAME -->
        <div class="form-group">
            <label>Name</label>
            <input type="text" name="name" class="form-control" ng-model="name" required>
            <p ng-show="userForm.name.$invalid" class="help-block">You name is required.</p>
            
        </div>

        <!-- USERNAME -->
        <div class="form-group">
            <label>Username</label>
            <input type="text" name="username" class="form-control" ng-model="user.username" ng-minlength="3" ng-maxlength="8">
			<p ng-show="userForm.name.$invalid" class="help-block">You name is required.</p>
        </div>
        
        <!-- EMAIL -->
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" class="form-control" ng-model="email">
            <p ng-show="userForm.email.$invalid" class="help-block">Enter a valid email.</p>
        </div>
        
            <!-- NO OF HOURS -->
        <div class="form-group">
            <label>No of Hours</label>
            <input type="number" name="size" class="form-control" ng-model="size" ng->
        </div>
        
        <!-- SUBMIT BUTTON -->
        <button type="submit" class="btn btn-primary" ng-disabled = "userForm.$invalid">Submit</button>
        
    </form>

</div><!-- col-sm-8 -->
</div><!-- /container -->


<div class = "panel" ng-show="tab ===2">
<h3>Monitor Job Form</h3>

</div>
<div class = "panel" ng-show="tab ===3">
<h3>Cancel Job Form</h3>

</div>
</body>
</html>