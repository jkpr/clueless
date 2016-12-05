<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/test-style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<div id="game">
<!-- TO BE FILLED IN BY SCRIPT -->
${game}
</div>
<div>
<hr/>
<div id="addPlayer">
    <input type="hidden" name="api" value="12345" />
    <form><input type="submit" value="join game" /></form>
</div>
<hr/>
<div id="setToken">
    <form>
        Who:<br/>
        <input type="hidden" name="api" value="12345" />
        <input type="text" name="who" />
        <input type="submit" value="setToken" />
    </form>
</div>
<hr/>
<div id="startGame">
    <form>
        <input type="hidden" name="api" value="12345" />
        <input type="submit" value="startGame" />
    </form>
</div>
<hr/>
<div id="move">
    <form>
        To:<br/>
        <input type="hidden" name="api" value="12345" />
        <input type="text" name="to" />
        <input type="submit" value="move" />
    </form>
</div>
<hr/>
<div id="endTurn">
    <form>
        To:<br/>
        <input type="hidden" name="api" value="12345" />
        <input type="submit" value="endTurn" />
    </form>
</div>
</div>
<div>
<h1>HTTP POST Result</h1>
<div id="postResult"></div>
</div>

<script type="text/javascript" src="js/reconnecting-websocket.min.js"></script>
<script type="text/javascript" src="js/test-websocket.js"></script>
<script type="text/javascript" src="js/game-forms.js"></script>
</body>
</html>