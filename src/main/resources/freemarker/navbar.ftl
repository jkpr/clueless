<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Boddy Builders</a>
        </div><#if currentUser??>
        <ul class="nav navbar-nav">
            <li><a href="/game">Game</a></li>
        </ul></#if>
        <ul class="nav navbar-nav navbar-right"><#if currentUser??>
            <li><a href="/user"><span class="glyphicon glyphicon-user"></span> ${currentUser}</a></li>
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li><#else>
            <li><a href="/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li></#if>
        </ul>
    </div>
</nav>
