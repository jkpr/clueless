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

}

function setHand(hand) {
    // TODO: hand of dealt cards from WebSocket
}

function setCharacter(character) {
    if (character != "") {
        $("#game-character").html("Your character: " + character);
    } else {
        $("#game-character").html("");
    }
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
