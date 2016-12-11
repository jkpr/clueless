<#include "/top-matter.ftl">
<div id="notificationArea" class="container">
    <!-- THIS IS COMMENTED OUT FOR NOW
    <div class="alert alert-success alert-dismissible">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">&times;</button>
        <strong>Success!</strong> Indicates a successful or positive action.
    </div>
    -->
</div>
<div id="clue-content">
    <div id="clue-status"><span id="status-text">Game status:</span> <span id="status-message">...</span> <span id="clue-character">Your character: Ms. Scarlet.</span></div>
    <div style="clear: both;"></div>
    <div id="clue-chat">
        <ul id="userlist"> <li>james</li><li>john</li><!-- Built by JS --> </ul>
        <div id="chat"> <!-- Built by JS --> </div>
        <div id="chatControls">
            <input id="message" placeholder="Type your message">
            <button id="send">Send</button>
        </div>
    </div>
    <div id="clue-game">
        <img class="token" id="msScarletToken" src="img/msScarlet.png"/>
        <img class="token" id="colMustardToken" src="img/colMustard.png"/>
        <img class="token" id="mrsWhiteToken" src="img/mrsWhite.png"/>
        <img class="token" id="mrGreenToken" src="img/mrGreen.png"/>
        <img class="token" id="mrsPeacockToken" src="img/mrsPeacock.png"/>
        <img class="token" id="profPlumToken" src="img/profPlum.png"/>

        <img class="token" id="candlestickToken" src="img/candlestick.png"/>
        <img class="token" id="knifeToken" src="img/knife.png"/>
        <img class="token" id="pipeToken" src="img/pipe.png"/>
        <img class="token" id="revolverToken" src="img/revolver.png"/>
        <img class="token" id="ropeToken" src="img/rope.png"/>
        <img class="token" id="wrenchToken" src="img/wrench.png"/>

        <img class="token-highlight hidden" id="characterHighlight" src="img/selection.png"/>
    </div>
    <div id="clue-actions">
        <div class="btn-group-vertical btn-block">
            <button id="addPlayerBtn" type="button" class="btn btn-primary btn-block">Join</button>
            <button id="setTokenBtn" type="button" class="btn btn-primary btn-block hidden">Set token</button>
            <button id="startGameBtn" type="button" class="btn btn-primary btn-block hidden">Start game</button>
            <button id="moveBtn" type="button" class="btn btn-primary btn-block hidden">Move</button>
            <button id="makeSuggestionBtn" type="button" class="btn btn-primary btn-block hidden">Make suggestion</button>
            <button id="disproveSuggestionBtn" type="button" class="btn btn-primary btn-block hidden">Disprove suggestion</button>
            <button id="makeAccusationBtn" type="button" class="btn btn-primary btn-block hidden">Make accusation</button>
            <button id="endTurnBtn" type="button" class="btn btn-primary btn-block hidden">End turn</button>
        </div>
        <button id="handBtn" type="button" class="btn btn-info btn-block">My cards</button>
    </div>
    <div id="clue-notes">
        <textarea>My notes...</textarea>
    </div>
</div>
<div style="clear: both;"></div>
<div id="footer">
</div>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/reconnecting-websocket.min.js"></script>
<script src="js/game.js"></script>
<script src="js/game-ui.js"></script>
<script src="js/game-websocket.js"></script>
</body>
</html>