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

function setActions(actions) {
    // TODO: actions from WebSocket
    if ("AddPlayer" in actions) {
        $("#addPlayerBtn").removeClass("hidden");
    } else {
        $("#addPlayerBtn").addClass("hidden");
    }

    if ("SetToken" in actions) {
        $("#setTokenBtn").removeClass("hidden");
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
        $("#setTokenBtn").addClass("hidden");
    }

    if ("StartGame" in actions) {
        $("#startGameBtn").removeClass("hidden");
    } else {
        $("#startGameBtn").addClass("hidden");
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
            setSuccessMsg("Successfully set token");
        }
    }).fail( function(data) {
        var responseData = JSON.parse(data.responseText);
        var msg = responseData.msg;
        if (msg != "") {
            setErrorMsg(msg);
        } else {
            setErrorMsg("Internal server error when setting token");
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

function setHand(hand) {
    // TODO: hand of dealt cards from WebSocket
    $("#handModalBody img").removeClass("hidden");
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
        $("#handModalBody").text("You do not have any cards.");
    } else {
        $("#handModalBody").text("");
    }
}

function setCharacter(character) {
    console.log(character);
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
    highlightCharacter(json["who"]);
    setActions(json["action"]);
    setStatusMessage(json["statusMessage"]);
    if (json["notification"] != "") {
        setNotification(json["notification"]);
    }
    setHand(json["yourHand"]);
    setCharacter(json["yourCharacter"]);
}