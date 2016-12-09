<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="http://localhost:4567/user">User Profile</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:4567">Home</a></li>
            <li><a href="game.html">Game</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="http://localhost:4567/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="http://localhost:4567/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <h2>User Profile Page</h2>
    <p>Here is a draft version of user profile. </p>
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>GAMES_WON</th>
                <th>GAMES_PLAYED</th>
                <th>LAST_LOGIN</th>
                <th>CREATE_DATE</th>
                <th>MODIFY_DATE</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>12</td>
                <td>Yesterday</td>
                <td>12-2-2016</td>
                <td>12-2-2016</td>
            </tr>
            <tr>
                <td>2</td>
                <td>10</td>
                <td>Yesterday</td>
                <td>12-2-2016</td>
                <td>12-2-2016</td>
            </tr>
            <tr>
                <td>3</td>
                <td>15</td>
                <td>Yesterday</td>
                <td>12-2-2016</td>
                <td>12-2-2016</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>