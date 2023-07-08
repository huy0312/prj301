<%-- 
    Document   : Login
    Created on : Feb 21, 2022, 6:28:53 AM
    Author     : 84915
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="Component/import.jsp" %>
        <title>Apartment Management</title>
    </head>
    <body>

        <section class="vh-100" style="background-color: #508bfc;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card shadow-2-strong" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">
                                <form action="Login" method="POST">
                                    <h3 class="mb-5">Sign in</h3>
                                    <div class="form-outline mb-4">
                                        <input style="border: solid black 1px; border-radius: 20px" name="username" type="" id="typeEmailX-2" class="form-control form-control-lg" placeholder="Username"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <input style="border: solid black 1px; border-radius: 20px" name="password" type="password" id="typePasswordX-2" class="form-control form-control-lg" placeholder="Password" />
                                    </div>
                                    <button class="btn btn-primary btn-lg btn-block" type="submit" >Login</button>
                                    <a href="register.jsp"><button class="btn btn-primary btn-lg btn-block" style="margin-top: 3px" type="button">Register</button></a>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
