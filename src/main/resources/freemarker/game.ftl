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
    <div id="clue-status"><span id="status-text">Game status:</span> <span id="status-message">...</span> <span id="clue-character"></span></div>
    <div style="clear: both;"></div>
    <div id="clue-chat">
        <ul id="userlist"><!-- Built by JS --> </ul>
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
        <div class="btn-group-vertical btn-block setup-phase">
            <button id="addPlayerBtn" type="button" class="btn btn-primary btn-block">Join</button>
            <button id="setTokenBtn" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#setTokenModal">Set token</button>
            <button id="startGameBtn" type="button" class="btn btn-primary btn-block">Start game</button>
        </div>
        <div class="btn-group-vertical btn-block active-phase hidden">
            <button id="moveBtn" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#moveModal">Move</button>
            <button id="makeSuggestionBtn" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#makeSuggestionModal">Make suggestion</button>
            <button id="disproveSuggestionBtn" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#disproveSuggestionModal">Disprove suggestion</button>
            <button id="makeAccusationBtn" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#makeAccusationModal">Make accusation</button>
            <button id="endTurnBtn" type="button" class="btn btn-primary btn-block">End turn</button>
        </div>
        <button id="handBtn" type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#handModal">My cards</button>
    </div>
    <div id="clue-notes">
        <textarea>My notes...</textarea>
    </div>
</div>
<div style="clear: both;"></div>
<div id="footer">
</div>

<!-- Disprove Suggestion Modal -->
<div class="modal fade" id="disproveSuggestionModal" tabindex="-1" role="dialog" aria-labelledby="Disprove suggestion modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="disproveSuggestionModalLabel">Disprove with a card</h4>
            </div>
            <div class="modal-body" id="disproveSuggestionModalBody">
                <p>Disprove the suggestion with one of your cards.</p>
                <select class="form-control">
                    <!-- built by JS -->
                </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="disproveSuggestionModalOk">Disprove</button>
            </div>
        </div>
    </div>
</div>

<!-- Make Accusation Modal -->
<div class="modal fade" id="makeAccusationModal" tabindex="-1" role="dialog" aria-labelledby="Make accusation modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="makeAccusationModalLabel">Make an accusation</h4>
            </div>
            <div class="modal-body" id="setAccusationModalBody">
                <h4>Accuse a character</h4>
                <select class="form-control character-list">
                    <option>Ms. Scarlet</option>
                    <option>Col. Mustard</option>
                    <option>Mrs. White</option>
                    <option>Mr. Green</option>
                    <option>Mrs. Peacock</option>
                    <option>Prof. Plum</option>
                </select>

                <h4>Select a weapon</h4>
                <select class="form-control weapon-list">
                    <option>Candlestick</option>
                    <option>Knife</option>
                    <option>Pipe</option>
                    <option>Revolver</option>
                    <option>Rope</option>
                    <option>Wrench</option>
                </select>

                <h4>Select a room</h4>
                <select class="form-control room-list">
                    <option>Kitchen</option>
                    <option>Ballroom</option>
                    <option>Conservatory</option>
                    <option>Dining room</option>
                    <option>Billiard room</option>
                    <option>Library</option>
                    <option>Lounge</option>
                    <option>Hall</option>
                    <option>Study</option>
                </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="makeAccusationModalOk">Accuse</button>
            </div>
        </div>
    </div>
</div>

<!-- Make Suggestion Modal -->
<div class="modal fade" id="makeSuggestionModal" tabindex="-1" role="dialog" aria-labelledby="Make suggestion modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="makeSuggestionModalLabel">Make a suggestion</h4>
            </div>
            <div class="modal-body" id="makeSuggestionModalBody">
                <h4>Suggest a character</h4>
                <select class="form-control character-list">
                    <option>Ms. Scarlet</option>
                    <option>Col. Mustard</option>
                    <option>Mrs. White</option>
                    <option>Mr. Green</option>
                    <option>Mrs. Peacock</option>
                    <option>Prof. Plum</option>
                </select>

                <h4>Select a weapon</h4>
                <select class="form-control weapon-list">
                    <option>Candlestick</option>
                    <option>Knife</option>
                    <option>Pipe</option>
                    <option>Revolver</option>
                    <option>Rope</option>
                    <option>Wrench</option>
                </select>
                <br />
                <p>Note: the room you are in now is the suggested room</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="makeSuggestionModalOk">Suggest</button>
            </div>
        </div>
    </div>
</div>

<!-- Move Modal -->
<div class="modal fade" id="moveModal" tabindex="-1" role="dialog" aria-labelledby="Move modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="moveModalLabel">Move</h4>
            </div>
            <div class="modal-body" id="moveModalBody">
                <select class="form-control">
                    <!-- built by JS -->
                </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="moveModalOk">Move</button>
            </div>
        </div>
    </div>
</div>

<!-- Set Token Modal -->
<div class="modal fade" id="setTokenModal" tabindex="-1" role="dialog" aria-labelledby="Set token modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="setTokenModalLabel">Choose new token</h4>
            </div>
            <div class="modal-body" id="setTokenModalBody">
                <select class="form-control">
                    <option>Ms. Scarlet</option>
                    <option>Col. Mustard</option>
                    <option>Mrs. White</option>
                    <option>Mr. Green</option>
                    <option>Mrs. Peacock</option>
                    <option>Prof. Plum</option>
                </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="setTokenModalOk">Set token</button>
            </div>
        </div>
    </div>
</div>

<!-- Hand Modal -->
<div class="modal fade" id="handModal" tabindex="-1" role="dialog" aria-labelledby="Hand modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="handModalLabel">My hand</h4>
            </div>
            <div class="modal-body" id="handModalBody">
                <span>You do not have any cards.</span>
                <img id="ballroomCard" src="img/ballroomCard.jpg" class="img-rounded hidden" alt="Ballroom card" width="130" height="200">
                <img id="billiardRoomCard" src="img/billiardRoomCard.jpg" class="img-rounded hidden" alt="Billiard room card" width="130" height="200">
                <img id="conservatoryCard" src="img/conservatoryCard.jpg" class="img-rounded hidden" alt="Conservatory card" width="130" height="200">
                <img id="diningRoomCard" src="img/diningRoomCard.jpg" class="img-rounded hidden" alt="Dining room card" width="130" height="200">
                <img id="hallCard" src="img/hallCard.jpg" class="img-rounded hidden" alt="Hall card" width="130" height="200">
                <img id="kitchenCard" src="img/kitchenCard.jpg" class="img-rounded hidden" alt="Kitchen card" width="130" height="200">
                <img id="libraryCard" src="img/libraryCard.jpg" class="img-rounded hidden" alt="Library card" width="130" height="200">
                <img id="loungeCard" src="img/loungeCard.jpg" class="img-rounded hidden" alt="Lounge card" width="130" height="200">
                <img id="studyCard" src="img/studyCard.jpg" class="img-rounded hidden" alt="Study card" width="130" height="200">

                <img id="msScarletCard" src="img/msScarletCard.jpg" class="img-rounded hidden" alt="Ms. Scarlet card" width="130" height="200">
                <img id="colMustardCard" src="img/colMustardCard.jpg" class="img-rounded hidden" alt="Col. Mustard card" width="130" height="200">
                <img id="mrsWhiteCard" src="img/mrsWhiteCard.jpg" class="img-rounded hidden" alt="Mrs. White card" width="130" height="200">
                <img id="mrGreenCard" src="img/mrGreenCard.jpg" class="img-rounded hidden" alt="Mr. Green card" width="130" height="200">
                <img id="mrsPeacockCard" src="img/mrsPeacockCard.jpg" class="img-rounded hidden" alt="Mrs Peacock card" width="130" height="200">
                <img id="profPlumCard" src="img/profPlumCard.jpg" class="img-rounded hidden" alt="Prof plum card" width="130" height="200">

                <img id="candlestickCard" src="img/candlestickCard.jpg" class="img-rounded hidden" alt="Candlestick card" width="130" height="200">
                <img id="knifeCard" src="img/knifeCard.jpg" class="img-rounded hidden" alt="Knife card" width="130" height="200">
                <img id="pipeCard" src="img/pipeCard.jpg" class="img-rounded hidden" alt="Pipe card" width="130" height="200">
                <img id="revolverCard" src="img/revolverCard.jpg" class="img-rounded hidden" alt="Revolver card" width="130" height="200">
                <img id="ropeCard" src="img/ropeCard.jpg" class="img-rounded hidden" alt="Rope card" width="130" height="200">
                <img id="wrenchCard" src="img/wrenchCard.jpg" class="img-rounded hidden" alt="Wrench card" width="130" height="200">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>



<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/reconnecting-websocket.min.js"></script>
<script src="js/game-board.js"></script>
<script src="js/game-ui.js"></script>
<script src="js/game-websocket.js"></script>
<script src="js/game-update.js"></script>
</body>
</html>