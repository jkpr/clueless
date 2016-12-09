<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>game-instance</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="fonts/font-awesome.min.css">
    <link rel="stylesheet" href="css/game-play.css">
</head>

<body>
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header"><a class="navbar-brand navbar-link" href="/"><i class="glyphicon glyphicon-pawn"></i> Clue-Less</a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active" role="presentation"><a href="/">End Game</a></li>
                    <li role="presentation"><a href="/user">Profile </a></li>
                    <li role="presentation"><a href="/">Sign Out</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="jumbotron hero">
        <div class="outer-opacity-filter">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3 chat-container">
                        <h1 class="text-center notes-heading">Chat </h1>
                        <div class="mr-boddy-mockup">
                            <div id="chatControls">
                                <input id="message" placeholder="Type your message">
                                <button id="send">Send</button>
                            </div>
                            <ul id="userlist">
                                <!-- Built by JS -->
                            </ul>
                            <div id="chat">
                                <!-- Built by JS -->
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-md-pull-3 game game-container">
                        <div class="board-img-container">
                            <div id="game">
                                <!-- TO BE FILLED IN BY SCRIPT -->
                                <pre>
                                    ${game}
                                </pre>
                            </div>
                        </div>
                        <p><a class="btn btn-primary btn-lg" role="button" href="#">Move </a><a class="btn btn-success btn-lg"
                                role="button" href="#">Disprove </a><a class="btn btn-primary btn-lg" role="button" href="#">Suggest </a>
                            <a class="btn btn-success btn-lg" role="button" href="#">Accuse </a><a class="btn btn-primary btn-lg"
                                role="button" href="#">End Turn</a></p>
                    </div>
                    <div class="col-lg-2 col-md-2 game game-notes-container">
                        <h1 class="text-center notes-heading">Game Notes</h1><img src="img/game-notes.png" width="100%"></div>
                </div>
            </div>
        </div>
    </div>
    <section class="rules">
        <h2 class="text-center"><em>[Might put rules here]</em></h2>
    </section>

    <section class="test-btns">
        <div>
            <h1>HTTP POST Result</h1>
            <div id="postResult"></div>
        </div>
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
                <select id="tokenCharacterList" onchange="chooseCharacter()">
                    <option></option>
                    <option>Prof. Plum</option>
                    <option>Ms. Scarlet</option>
                    <option>Col. Mustard</option>
                    <option>Mrs. Peacock</option>
                    <option>Mr. Green</option>
                    <option>Mrs. White</option>
                </select>
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
                <select id="moveRoomList" onchange="chooseRoom()">
                    <option></option>
                    <option>Study</option>
                    <option>Hall</option>
                    <option>Lounge</option>
                    <option>Library</option>
                    <option>Billiard room</option>
                    <option>Dining room</option>
                    <option>Conservatory</option>
                    <option>Ballroom</option>
                    <option>Kitchen</option>
                    <option>Scarlet start</option>
                    <option>Mustard start</option>
                    <option>White start</option>
                    <option>Green start</option>
                    <option>Peacock start</option>
                    <option>Plum start</option>
                    <option>Hall-Study</option>
                    <option>Hall-Lounge</option>
                    <option>Library-Study</option>
                    <option>Billiard room-Hall</option>
                    <option>Dining room-Lounge</option>
                    <option>Billiard room-Library</option>
                    <option>Billiard room-Dining room</option>
                    <option>Conservatory-Library</option>
                    <option>Ballroom-Billiard room</option>
                    <option>Dining room-Kitchen</option>
                    <option>Ballroom-Conservatory</option>
                    <option>Ballroom-Kitchen</option>
                </select>
                <input type="submit" value="move" />
            </form>
        </div>
        <hr/>
        <div id="makeSuggestion">
            <form>
                Character:
                <select id="suggestionCharacterList" onchange="chooseCharacter()">
                    <option></option>
                    <option>Prof. Plum</option>
                    <option>Ms. Scarlet</option>
                    <option>Col. Mustard</option>
                    <option>Mrs. Peacock</option>
                    <option>Mr. Green</option>
                    <option>Mrs. White</option>
                </select>
                <br/> Weapon:
                <select id="suggestionWeaponList" onchange="chooseCharacter()">
                    <option></option>
                    <option>candlestick</option>
                    <option>knife</option>
                    <option>pipe</option>
                    <option>revolver</option>
                    <option>rope</option>
                    <option>wrench</option>
                </select>
                <br/>
                <input type="hidden" name="api" value="12345" />
                <input type="submit" value="makeSuggestion" />
            </form>
        </div>
        <hr/>
        <div id="disproveSuggestion">
            <form>
                Card:
                <select id="disproveList" onchange="chooseCard()">
                    <option></option>
                    <option>Prof. Plum</option>
                    <option>Ms. Scarlet</option>
                    <option>Col. Mustard</option>
                    <option>Mrs. Peacock</option>
                    <option>Mr. Green</option>
                    <option>Mrs. White</option>
                    <option>candlestick</option>
                    <option>knife</option>
                    <option>pipe</option>
                    <option>revolver</option>
                    <option>rope</option>
                    <option>wrench</option>
                </select>
                <br/>
                <input type="hidden" name="api" value="12345" />
                <input type="submit" value="disproveSuggestion" />
            </form>
        </div>
        <hr/>
        <div id="makeAccusation">
            <form>
                Character:
                <select id="accusationCharacterList" onchange="chooseCharacter()">
                    <option></option>
                    <option>Prof. Plum</option>
                    <option>Ms. Scarlet</option>
                    <option>Col. Mustard</option>
                    <option>Mrs. Peacock</option>
                    <option>Mr. Green</option>
                    <option>Mrs. White</option>                
                </select>
                <br/> Weapon:
                <select id="accusationWeaponList" onchange="chooseCard()">
                    <option></option>
                    <option>candlestick</option>
                    <option>knife</option>
                    <option>pipe</option>
                    <option>revolver</option>
                    <option>rope</option>
                    <option>wrench</option>
                </select>
                <br/> Room:
                <select id="accusationRoomList" onchange="chooseRoom()">
                    <option></option>
                    <option>Study</option>
                    <option>Hall</option>
                    <option>Lounge</option>
                    <option>Library</option>
                    <option>Billiard room</option>
                    <option>Dining room</option>
                    <option>Conservatory</option>
                    <option>Ballroom</option>
                    <option>Kitchen</option>
                </select>
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
    </section>

    <section class="features">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h2>Clue-Less</h2>
                    <p>Game developed by James Pringle, Christopher Chang, Ibrahim Salla, and Federico Esparza, as a team project
                        in the Fall 2016 semester of Johns Hopkins University graduate level course: Foundations of Software
                        Engineering
                    </p>
                </div>
                <div class="col-md-6">
                    <div class="row icon-features">
                        <div class="col-xs-4 icon-feature"><i class="glyphicon glyphicon-cloud"></i>
                            <p>Heroku Deployed</p>
                        </div>
                        <div class="col-xs-4 icon-feature"><i class="fa fa-github-alt glyphicon"></i>
                            <p>Github Repo</p>
                        </div>
                        <div class="col-xs-4 icon-feature"><i class="glyphicon glyphicon-education"></i>
                            <p>Johns Hopkins University Software Engineering</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer class="site-footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <h5>BoddyBuilders © 2016</h5>
                </div>
            </div>
        </div>
    </footer>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/reconnecting-websocket.min.js"></script>
    <script type="text/javascript" src="js/websocket.js"></script>
    <script type="text/javascript" src="js/final-game-forms.js"></script>
</body>

</html>