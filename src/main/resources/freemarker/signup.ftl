<#include "/top-matter.ftl">
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4 well well-sm">
            <legend><i class="glyphicon glyphicon-globe"></i> Sign up!</legend>

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
                <input class="form-control" name="username" placeholder="Username" type="text" />
                <input class="form-control" name="youremail" placeholder="Your Email" type="email" />
                <input class="form-control" name="password" placeholder="New Password" type="password" />
                <input class="form-control" name="reenter" placeholder="Re-enter password" type="password" />
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
            </form>
        </div>
    </div>
</div>
<#include "bottom-matter.ftl">
