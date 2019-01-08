<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sign in</title>
    <link href="../../resources/registrationStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <div class="main">
        <form method="post" action="${contextPath}/registration">
            <h2>Sign in</h2>

            <div class="form-group ${error != null ? 'has-error' : ''}">
                <label for="username">Input username:</label>
                <input name="username"  id="username" type="text" class="form-control" placeholder="Username"
                       autofocus="true"/>
                <br>
                <label for="password">Input password:</label>
                <input name="password" id="password" type="password" class="form-control" placeholder="Password"/>
                <span>${errorMsg}</span>
                <br>
                <div class="role">
                    <label for="role">Select role:</label>
                    <select name="role" id="role">
                        <option>Admin</option>
                        <option>User</option>
                    </select>
                </div>
                <br>
                <button class="btn" type="submit">Sign in</button>
            </div>
        </form>
    </div>
</body>
</html>