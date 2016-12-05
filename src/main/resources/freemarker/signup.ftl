<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>

        .form-control { margin-bottom: 10px; }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.html">Boddy Builder</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:4567/">Home</a></li>
            <li><a href="game.html">Game</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="http://localhost:4567/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="http://localhost:4567/signup"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4 well well-sm">
            <legend><a href="http://www.jquery2dotnet.com"><i class="glyphicon glyphicon-globe"></i></a> Sign up!</legend>

            <form action="#" method="post" class="form" role="form">
                <div class="row">
                    <div class="col-xs-6 col-md-6">
                        <input class="form-control" name="firstname" placeholder="First Name" type="text"
                               required autofocus />
                    </div>
                    <div class="col-xs-6 col-md-6">
                        <input class="form-control" name="lastname" placeholder="Last Name" type="text" required />
                    </div>
                </div>
                <input class="form-control" name="youremail" placeholder="Your Email" type="email" />
                <input class="form-control" name="reenteremail" placeholder="Re-enter Email" type="email" />
                <input class="form-control" name="password" placeholder="New Password" type="password" />
                <label for="">
                    Birth Date</label>
                <div class="row">
                    <div class="col-xs-4 col-md-4">
                        <select class="form-control">
                            <option value="Month">Month</option>
                        </select>
                    </div>
                    <div class="col-xs-4 col-md-4">
                        <select class="form-control">
                            <option value="Day">Day</option>
                        </select>
                    </div>
                    <div class="col-xs-4 col-md-4">
                        <select class="form-control">
                            <option value="Year">Year</option>
                        </select>
                    </div>
                </div>
                <label class="radio-inline">
                    <input type="radio" name="sex" id="inlineCheckbox1" value="male" />
                    Male
                </label>
                <label class="radio-inline">
                    <input type="radio" name="sex" id="inlineCheckbox2" value="female" />
                    Female
                </label>
                <br />
                <br />
                <button onclick="location.href='index.html'" class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign up</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>