<%-- 
    Document   : register
    Created on : Mar 9, 2023, 8:58:36 PM
    Author     : toden
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="Component/import.jsp" %>
        <link rel="stylesheet" href="css/register.css">
        <title>Apartment Management</title>
    </head>
    <body>
        <form action="Register" method="post">
            <section class="vh-100 gradient-custom">

                <div class="container py-5 h-100">
                    <div class="row justify-content-center align-items-center h-100">
                        <div class="col-12 col-lg-9 col-xl-7">
                            <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                                <div class="card-body p-4 p-md-5">
                                    <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                                    <form>

                                        <div class="row">
                                            <div class="col-md-6 mb-4">

                                                <div class="form-outline">
                                                    <input required="" name="username" type="text" id="firstName" class="form-control form-control-lg" />
                                                    <label class="form-label" for="firstName">Account Name</label>
                                                    <span style="color: red" id="errorName">${requestScope.errName}</span>
                                                </div>

                                            </div>
                                            <div class="col-md-6 mb-4">

                                                <div class="form-outline">
                                                    <input required name="KHname" type="text" id="lastName" class="form-control form-control-lg" />
                                                    <label class="form-label" for="lastName">Full Name</label>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6 mb-4 d-flex align-items-center">

                                                <div class="form-outline datepicker w-100">
                                                    <input minlength="6" required name="password" type="password" class="form-control form-control-lg" id="birthdayDate" />
                                                    <label for="birthdayDate" class="form-label">Password</label>
                                                </div>

                                            </div>
                                            <div class="col-md-6 mb-4">

                                                <h6 class="mb-2 pb-1">Gender: </h6>

                                                <div class="form-check form-check-inline">
                                                    <input checked="true" name="gender" class="" type="radio" name="inlineRadioOptions" id="femaleGender"
                                                           value="1" checked />
                                                    <label class="form-check-label" for="femaleGender">Male</label>
                                                </div>

                                                <div class="form-check form-check-inline">
                                                    <input  name="gender" class="" type="radio" name="inlineRadioOptions" id="maleGender"
                                                            value="2" />
                                                    <label class="form-check-label" for="maleGender">Female</label>
                                                </div>

                                                <div class="form-check form-check-inline">
                                                    <input  name="gender" class="" type="radio" name="inlineRadioOptions" id="otherGender"
                                                            value="3" />
                                                    <label class="form-check-label" for="otherGender">Other</label>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6 mb-4 pb-2">

                                                <div class="form-outline">
                                                    <input required name="CMND" pattern="[0-9]{12}" type="" id="emailAddress" class="form-control form-control-lg" />
                                                    <label class="form-label" for="emailAddress">CMND</label> 
                                                    <span style="color: red" id="errorCMND">${requestScope.errCMND}</span>
                                                </div>

                                            </div>
                                            <div class="col-md-6 mb-4 pb-2">

                                                <div class="form-outline">
                                                    <input required name="sdt" pattern="[0-9]{10}" type="tel" id="phoneNumber" class="form-control form-control-lg" />
                                                    <label class="form-label" for="phoneNumber">Phone Number</label>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-12">

                                                <!--                                            <select class="select form-control-lg">
                                                                                                <option value="1" disabled>Choose option</option>
                                                                                                <option value="2">Subject 1</option>
                                                                                                <option value="3">Subject 2</option>
                                                                                                <option value="4">Subject 3</option>
                                                                                            </select>
                                                                                            <label class="form-label select-label">Choose option</label>-->

                                            </div>
                                        </div>

                                        <div class="mt-4 pt-2">
                                            <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
                                        </div>

                                        </section>
                                    </form>


                                    </body>
                                    </html>
