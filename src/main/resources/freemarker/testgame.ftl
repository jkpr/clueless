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
        Who:
        <input type="hidden" name="api" value="12345" />
        <input type="text" name="who" />
        <br/>
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
        To:
        <input type="hidden" name="api" value="12345" />
        <br/>
        <input type="text" name="to" />
        <input type="submit" value="move" />
    </form>
</div>
<hr/>
<div id="makeSuggestion">
    <form>
        Character:
        <input type="text" name="character" />
        <br/>
        Weapon:
        <input type="text" name="weapon" />
        <br/>
        <input type="hidden" name="api" value="12345" />
        <input type="submit" value="makeSuggestion" />
    </form>
</div>
<hr/>
<div id="disproveSuggestion">
    <form>
        Card:
        <input type="text" name="card" />
        <br/>
        <input type="hidden" name="api" value="12345" />
        <input type="submit" value="disproveSuggestion" />
    </form>
</div>
<hr/>
<div id="makeAccusation">
    <form>
        Character:
        <input type="text" name="character" />
        <br/>
        Weapon:
        <input type="text" name="weapon" />
        <br/>
        Room:
        <input type="text" name="room" />
        <br/>
        <input type="hidden" name="api" value="12345" />
        <input type="submit" value="makeAccusation" />
    </form>
</div>
<hr/>
<div id="endTurn">
    <form>
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