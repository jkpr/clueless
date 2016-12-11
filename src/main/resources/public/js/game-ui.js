// Depends on jQuery

function setSuccessMsg(msg) {
    $("#notificationArea").html(
    "<div class=\"alert alert-success alert-dismissible\">\n" +
    "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">&times;</button>\n" +
    msg + "\n" +
    "</div>\n"
    );
}

function setErrorMsg(msg) {
    $("#notificationArea").html(
    "<div class=\"alert alert-danger alert-dismissible\">\n" +
    "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">&times;</button>\n" +
    msg + "\n" +
    "</div>\n"
    );
}

function setStatusMessage(msg) {
    $("#status-message").html(msg);
}

function setMove(moveList) {
    var moveSelect = $("#moveModalBody .form-control");
    moveSelect.html("");
    for (var i = 0; i < moveList.length; i++) {
        moveSelect.append($('<option>', {
            text: moveList[i]
        }));
    }
}

function setDisproveCards(cardList) {
    var cardSelect = $("#disproveSuggestionModalBody .form-control");
    cardSelect.html("");
    for (var i = 0; i < cardList.length; i++) {
        cardSelect.append($('<option>', {
            text: cardList[i]
        }));
    }
}

function setActions(actions, status) {
    // TODO: actions from WebSocket
    if (status == "SETUP") {
        $("#clue-actions .setup-phase").removeClass("hidden");
        $("#clue-actions .active-phase").addClass("hidden");
    } else if (status == "ACTIVE" || status == "ACTIVE_SUGGESTION") {
        $("#clue-actions .setup-phase").addClass("hidden");
        $("#clue-actions .active-phase").removeClass("hidden");
    }

    if ("AddPlayer" in actions) {
        $("#addPlayerBtn").prop("disabled", false);
    } else {
        $("#addPlayerBtn").prop("disabled", true);
    }

    if ("SetToken" in actions) {
        $("#setTokenBtn").prop("disabled", false);
        var setTokenArr = actions["SetToken"];
        if (setTokenArr.indexOf("Ms. Scarlet") >= 0) {
            $("#setTokenModalBody option")[0].disabled = false;
        } else {
            $("#setTokenModalBody option")[0].disabled = true;
        }

        if (setTokenArr.indexOf("Col. Mustard") >= 0) {
            $("#setTokenModalBody option")[1].disabled = false;
        } else {
            $("#setTokenModalBody option")[1].disabled=true;
        }

        if (setTokenArr.indexOf("Mrs. White") >= 0) {
            $("#setTokenModalBody option")[2].disabled = false;
        } else {
            $("#setTokenModalBody option")[2].disabled=true;
        }

        if (setTokenArr.indexOf("Mr. Green") >= 0) {
            $("#setTokenModalBody option")[3].disabled = false;
        } else {
            $("#setTokenModalBody option")[3].disabled=true;
        }

        if (setTokenArr.indexOf("Mrs. Peacock") >= 0) {
            $("#setTokenModalBody option")[4].disabled = false;
        } else {
            $("#setTokenModalBody option")[4].disabled=true;
        }

        if (setTokenArr.indexOf("Prof. Plum") >= 0) {
            $("#setTokenModalBody option")[5].disabled = false;
        } else {
            $("#setTokenModalBody option")[5].disabled=true;
        }
    } else {
        $("#setTokenBtn").prop("disabled", true);
    }

    if ("StartGame" in actions) {
        $("#startGameBtn").prop("disabled", false);
    } else {
        $("#startGameBtn").prop("disabled", true);
    }


    if ("Move" in actions) {
        $("#moveBtn").prop("disabled", false);
        setMove(actions["Move"]);
    } else {
        $("#moveBtn").prop("disabled", true);
    }

    if ("MakeSuggestion" in actions) {
        $("#makeSuggestionBtn").prop("disabled", false);
    } else {
        $("#makeSuggestionBtn").prop("disabled", true);
    }

    if ("DisproveSuggestion" in actions) {
        $("#disproveSuggestionBtn").prop("disabled", false);
        setDisproveCards(actions["DisproveSuggestion"]);
    } else {
        $("#disproveSuggestionBtn").prop("disabled", true);
    }

    if ("MakeAccusation" in actions) {
        $("#makeAccusationBtn").prop("disabled", false);
    } else {
        $("#makeAccusationBtn").prop("disabled", true);
    }

    if ("EndTurn" in actions) {
        $("#endTurnBtn").prop("disabled", false);
    } else {
        $("#endTurnBtn").prop("disabled", true);
    }



}

// ACTIONs onClick
$( "#addPlayerBtn" ).click(function( event ) {
    $.post("/game/join", JSON.stringify({"api":null}), function(data) {
        var responseData = JSON.parse(data);
        var msg = responseData.msg;
        if (msg != "") {
            // TODO: might get success message when coming from Websocket...
            setSuccessMsg(msg);
        } else {
            setSuccessMsg("Successfully joined game");
        }
    }).fail( function(data) {
        var responseData = JSON.parse(data.responseText);
        var msg = responseData.msg;
        if (msg != "") {
            setErrorMsg(msg);
        } else {
            setErrorMsg("Internal server error when joining game");
        }
    });
    event.preventDefault();
});

$( "#setTokenModalOk" ).click(function(event) {
    var who = $("#setTokenModalBody").find(':selected').text();
    $.post("/game/token", JSON.stringify({"api":null, "who": who}), function(data) {
        var responseData = JSON.parse(data);
        var msg = responseData.msg;
        if (msg != "") {
            // TODO: might get success message when coming from Websocket...
            setSuccessMsg(msg);
        } else {
            setSuccessMsg("Successfully set token.");
        }
    }).fail( function(data) {
        var responseData = JSON.parse(data.responseText);
        var msg = responseData.msg;
        if (msg != "") {
            setErrorMsg(msg);
        } else {
            setErrorMsg("Internal server error when setting token.");
        }
    });
});

$( "#moveModalOk" ).click(function(event) {
    var moveTo = $("#moveModalBody").find(':selected').text();
    $.post("/game/move", JSON.stringify({"api":null, "to": moveTo}), function(data) {
        var responseData = JSON.parse(data);
        var msg = responseData.msg;
        if (msg != "") {
            // TODO: might get success message when coming from Websocket...
            setSuccessMsg(msg);
        } else {
            setSuccessMsg("Successfully set token.");
        }
    }).fail( function(data) {
        var responseData = JSON.parse(data.responseText);
        var msg = responseData.msg;
        if (msg != "") {
            setErrorMsg(msg);
        } else {
            setErrorMsg("Internal server error when setting token.");
        }
    });
});

$( "#makeSuggestionModalOk" ).click(function(event) {
    var character = $("#makeSuggestionModalBody .character-list").find(':selected').text();
    var weapon = $("#makeSuggestionModalBody .weapon-list").find(':selected').text();
    $.post("/game/suggest", JSON.stringify({"api":null, "character": character, "weapon": weapon}), function(data) {
        var responseData = JSON.parse(data);
        var msg = responseData.msg;
        if (msg != "") {
            // TODO: might get success message when coming from Websocket...
            setSuccessMsg(msg);
        } else {
            setSuccessMsg("Successfully set token.");
        }
    }).fail( function(data) {
        var responseData = JSON.parse(data.responseText);
        var msg = responseData.msg;
        if (msg != "") {
            setErrorMsg(msg);
        } else {
            setErrorMsg("Internal server error when setting token.");
        }
    });
});


$( "#disproveSuggestionModalOk" ).click(function(event) {
    var card = $("#disproveSuggestionModalBody").find(':selected').text();
    $.post("/game/disprove", JSON.stringify({"api":null, "card": card}), function(data) {
        var responseData = JSON.parse(data);
        var msg = responseData.msg;
        if (msg != "") {
            // TODO: might get success message when coming from Websocket...
            setSuccessMsg(msg);
        } else {
            setSuccessMsg("Successfully set token.");
        }
    }).fail( function(data) {
        var responseData = JSON.parse(data.responseText);
        var msg = responseData.msg;
        if (msg != "") {
            setErrorMsg(msg);
        } else {
            setErrorMsg("Internal server error when setting token.");
        }
    });
});

$( "#makeAccusationModalOk" ).click(function(event) {
    var character = $("#makeAccusationModalBody .character-list").find(':selected').text();
    var weapon = $("#makeAccusationModalBody .weapon-list").find(':selected').text();
    var room = $("#makeAccusationModalBody .room-list").find(':selected').text();
    $.post("/game/accuse", JSON.stringify({"api":null, "character": character, "weapon": weapon, "room": room}), function(data) {
        var responseData = JSON.parse(data);
        var msg = responseData.msg;
        if (msg != "") {
            // TODO: might get success message when coming from Websocket...
            setSuccessMsg(msg);
        } else {
            setSuccessMsg("Successfully set token.");
        }
    }).fail( function(data) {
        var responseData = JSON.parse(data.responseText);
        var msg = responseData.msg;
        if (msg != "") {
            setErrorMsg(msg);
        } else {
            setErrorMsg("Internal server error when setting token.");
        }
    });
});

$( "#startGameBtn" ).click(function( event ) {
    $.post("/game/start", JSON.stringify({"api":null}), function(data) {
        var responseData = JSON.parse(data);
        var msg = responseData.msg;
        if (msg != "") {
            // TODO: might get success message when coming from Websocket...
            setSuccessMsg(msg);
        } else {
            setSuccessMsg("Successfully joined game.");
        }
    }).fail( function(data) {
        var responseData = JSON.parse(data.responseText);
        var msg = responseData.msg;
        if (msg != "") {
            setErrorMsg(msg);
        } else {
            setErrorMsg("Internal server error when joining game.");
        }
    });
});

$( "#endTurnBtn" ).click(function( event ) {
    $.post("/game/endturn", JSON.stringify({"api":null}), function(data) {
        var responseData = JSON.parse(data);
        var msg = responseData.msg;
        if (msg != "") {
            // TODO: might get success message when coming from Websocket...
            setSuccessMsg(msg);
        } else {
            setSuccessMsg("Successfully joined game.");
        }
    }).fail( function(data) {
        var responseData = JSON.parse(data.responseText);
        var msg = responseData.msg;
        if (msg != "") {
            setErrorMsg(msg);
        } else {
            setErrorMsg("Internal server error when joining game.");
        }
    });
});

function setHand(hand) {
    console.log(hand);
    // TODO: hand of dealt cards from WebSocket
    $("#handModalBody img").addClass("hidden");
    for (var i = 0; i < hand.length; i++) {
        var thisCard = hand[i];
        if (thisCard == "Ms. Scarlet") {
            $("#msScarletCard").removeClass("hidden");
        } else if (thisCard == "Col. Mustard") {
            $("#colMustardCard").removeClass("hidden");
        } else if (thisCard == "Mrs. White") {
            $("#mrsWhiteCard").removeClass("hidden");
        } else if (thisCard == "Mr. Green") {
            $("#mrGreenCard").removeClass("hidden");
        } else if (thisCard == "Mrs. Peacock") {
            $("#mrsPeacockCard").removeClass("hidden");
        } else if (thisCard == "Prof. Plum") {
            $("#profPlumCard").removeClass("hidden");
        } else if (thisCard == "Candlestick") {
            $("#candlestickCard").removeClass("hidden");
        } else if (thisCard == "Knife") {
            $("#knifeCard").removeClass("hidden");
        } else if (thisCard == "Pipe") {
            $("#pipeCard").removeClass("hidden");
        } else if (thisCard == "Revolver") {
            $("#revolverCard").removeClass("hidden");
        } else if (thisCard == "Rope") {
            $("#ropeCard").removeClass("hidden");
        } else if (thisCard == "Wrench") {
            $("#wrenchCard").removeClass("hidden");
        } else if (thisCard == "Kitchen") {
            $("#kitchenCard").removeClass("hidden");
        } else if (thisCard == "Ballroom") {
            $("#ballroomCard").removeClass("hidden");
        } else if (thisCard == "Conservatory") {
            $("#conservatoryCard").removeClass("hidden");
        } else if (thisCard == "Dining room") {
            $("#diningRoomCard").removeClass("hidden");
        } else if (thisCard == "Billiard room") {
            $("#billiardRoomCard").removeClass("hidden");
        } else if (thisCard == "Library") {
            $("#libraryCard").removeClass("hidden");
        } else if (thisCard == "Lounge") {
            $("#loungeCard").removeClass("hidden");
        } else if (thisCard == "Hall") {
            $("#hallCard").removeClass("hidden");
        } else if (thisCard == "Study") {
            $("#studyCard").removeClass("hidden");
        }
    }

    if (hand.length == 0) {
        $("#handModalBody span").text("You do not have any cards.");
    } else {
        $("#handModalBody span").text("");
    }
}

function setCharacter(character) {
    if (character != "") {
        $("#clue-character").html("Your character: " + character);
    } else {
        $("#clue-character").html("");
    }
}

function setNotification(msg) {
    setSuccessMsg(msg);
}

// CHAT!!!

//Update the chat-panel, and the list of connected users
function updateChat(data) {
    insert("chat", data.usermessage);
    id("userlist").innerHTML = "";
    data.userlist.forEach(function (user) {
        insert("userlist", "<li>" + user + "</li>");
    });
}

//Helper function for inserting HTML as the first child of an element
function insert(targetId, message) {
    id(targetId).insertAdjacentHTML("afterbegin", message);
}

function updateGame(json) {
    setBoard(json["board"]);
    highlightCharacter(json["statusWho"]);
    setActions(json["action"], json["status"]);
    setStatusMessage(json["statusMessage"]);
    if (json["notification"] != "") {
        setNotification(json["notification"]);
    }
    setHand(json["yourHand"]);
    setCharacter(json["yourCharacter"]);
}