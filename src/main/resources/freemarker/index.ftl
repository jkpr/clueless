<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>Welcome to Clue-less.</h1>
    <p>This is freemarker.</p>
    <h2>Team members</h2>
    <ul>
<#list members as member>
        <li>${member}</li>
</#list>
    </ul>
    <#if footer??><#include footer></#if>
</body>
</html>