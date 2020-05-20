<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h1>First page</h1>
<div class="form-style-2">

    <div class="form-style-2-heading">
        Please Sign Up!
    </div>
    <form method="post" action="/jsp_hibernate_project_war/index">
        <label for="login">User login
            <input class="input-field" type="text" id="login" name="login">
        </label>
        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <input type="submit" value="Sign Up">
    </form>


    <form action="/jsp_hibernate_project_war/admin">
        <input type="submit" value="Read User's List"/>
    </form>

    <form action="/jsp_hibernate_project_war/create">
        <input type="submit" value="Create the New User"/>
    </form>

</div>
</body>
</html>
