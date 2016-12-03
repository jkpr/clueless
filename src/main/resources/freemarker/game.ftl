<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>WebsSockets</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="chatControls">
    <input id="message" placeholder="Type your message">
    <button id="send">Send</button>
</div>
<ul id="userlist"> <!-- Built by JS --> </ul>
<div id="chat">    <!-- Built by JS --> </div>
<script type="text/javascript" src="js/reconnecting-websocket.min.js"></script>
<script type="text/javascript" src="js/websocket.js"></script>
</body>
</html>