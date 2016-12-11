<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <#if login??>
    <link href="css/login.css" rel="stylesheet"></#if>
</head>

<body>
<#include "/navbar.ftl">
<#if greenMsg??>
    <div class="container">
    <div class="alert alert-success alert-dismissible">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
        ${greenMsg}
    </div>
    </div>
</#if>
<#if redMsg??>
    <div class="container">
    <div class="alert alert-danger alert-dismissible">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
        ${redMsg}
    </div>
    </div>
</#if>