<!--
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
-->
<!DOCTYPE html>
<!-- FIXME fan 
    本页面的需求:
    1.要有确认密码的功能,两次输入密码不一致要提示
    2.参数post给RegisterServlet-->
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Sign up</title>
</head>

<body>
    

        <div class="row">
            <div class="col col-lg-12" style="height: 200px;">
            </div>
        </div>

        <div class="row">
           <div class="col col-lg-4" style="height: auto;">
            </div>
            <div class="col col-lg-4" style="height: 575px;">
                <form action="Register">
                    <div class="form-group">
                        <label>Your User name</label>
                        <input class="form-control" name="username" placeholder="Choice your own username">
                        <small id="usernamehelp" class="form-text text-muted">You may user your email as your user name</small>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" name="password" placeholder="Password">
                        <small id="usernamehelp" class="form-text text-muted">
                            <span>Be a minimum of eight (8) characters in length;</span><br>
                            <span>Contain at least one (1) character from three (3) of the following categories:</span><br>
                            <span> * Uppercase letter (A-Z);</span><br>
                            <span> * Lowercase letter (A-Z);</span><br>
                            <span> * Special character (~`!@#$%^&*()+=_-{}[]\|:;”’?/<>,.) </span><br>
                        </small>
                    </div>
                    <div class="form-group">
                        <label>Enter your password again</label>
                        <input type="password" class="form-control" id="password" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
            
            <div class="col col-lg-4" style="height: auto;">
            </div>
        </div>
        
         <div class="row" >
            <div class="col col-lg-12" style="height: 50px;background-color: black">
            </div>
        </div>


</body>
</html>