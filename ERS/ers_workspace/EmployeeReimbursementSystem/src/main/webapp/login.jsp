<html>

<body>

    <div class="container" disabled>
        <div class="jumbotron">
            <h1>Login Page.</h1>
        </div>
        <br>
        <form action="login.do" method="POST">
            <label for="username">Username:</label>
            <br>
            <input type="text" name="username" id="username" required placeholder="Please enter username">
            <br>
            <br>
            <label for="password">Password:</label>
            <br>
            <input type="text" name="password" id="password" required placeholder="Please enter password">
            <br>
            <br>
            <input id="loginBtn" type="submit" value="Login">
        </form>

    </div>

</body>

</html>