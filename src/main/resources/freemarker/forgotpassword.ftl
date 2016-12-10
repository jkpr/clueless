<#include "/top-matter.ftl">
<div class="container">

    <div id="forgotpassword" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading">
                <div class="panel-title">Forgot Password</div>

            </div>

            <div style="padding-top:30px" class="panel-body" >

                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                <form id="loginform" class="form-horizontal" role="form" action="#" method="post">

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="login-username" type="text" class="form-control" name="email" placeholder="E-mail">
                    </div>

                    <div style="margin-top:10px" class="form-group">
                        <!-- Button -->

                        <div class="col-sm-12 controls"><button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                            <a href="/login" class="pull-right need-help">Back to Login </a><span class="clearfix"></span>


                        </div>
                    </div>



                </form>



            </div>
        </div>
    </div>
</div>
<#include "/bottom-matter.ftl">
