<#include "/top-matter.ftl">
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4 col-sm-offset-3">
            <div class="account-wall">
                <img class="profile-img" src="/img/bb-logo-square.png" alt="">
                <form class="form-signin" role="form" action="" method="post">
                    <input type="text" class="form-control" name="username" placeholder="username or email" required autofocus>
                    <input type="password" class="form-control" name="password" placeholder="Password" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login"> Sign in</button>
                    <a href="/forgotpassword" class="pull-right need-help">Forgot Password? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="/signup" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>
<#include "/bottom-matter.ftl">
