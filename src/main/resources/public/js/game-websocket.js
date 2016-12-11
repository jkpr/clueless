// Support TLS-specific URLs, when appropriate.
if (window.location.protocol == "https:") {
    var ws_scheme = "wss://";
} else {
    var ws_scheme = "ws://";
};

var webSocket = new ReconnectingWebSocket(ws_scheme + location.hostname + ":" + location.port + "/message");

webSocket.onmessage = function (msg) {
    // TODO receive a message here, determine its type, then update the appropriate area
    var json = JSON.parse(msg.data);
    console.log(json);
    if (json.type == "chat") {
        updateChat(json.data);
    } else if (json.type == "game") {
        updateGame(json.data);
    }
};

webSocket.onclose = function () { /*alert("WebSocket connection closed")*/ };

//Send message if "Send" is clicked
id("send").addEventListener("click", function () {
    sendMessage(id("message").value);
});

//Send message if enter is pressed in the input field
id("message").addEventListener("keypress", function (e) {
    if (e.keyCode === 13) { sendMessage(e.target.value); }
});

//Send a message if it's not empty, then clear the input field
function sendMessage(message) {
    if (message !== "") {
        webSocket.send(message);
        id("message").value = "";
    }
}
