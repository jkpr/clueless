$( "#addPlayer" ).submit(function( event ) {
  $.post("/game/join", JSON.stringify({"api":null}), function(data) {
        $( "#postResult" ).html(data);
  }).fail( function(data) {
      $( "#postResult" ).html(data.responseText);
    });
  event.preventDefault();
});

$( "#setToken" ).submit(function( event ) {
    var who = $("#tokenCharacterList option:selected").text();
    $.post("/game/token", JSON.stringify({"api":null, "who": who}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});

$( "#startGame" ).submit(function( event ) {
    $.post("/game/start", JSON.stringify({"api":null}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});

$( "#move" ).submit(function( event ) {
    var moveTo = $("#moveRoomList option:selected").text();
    $.post("/game/move", JSON.stringify({"api":null, "to": moveTo}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});

$( "#makeSuggestion" ).submit(function( event ) {
    var character = $("#suggestionCharacterList optionLselected").text();
    var weapon = $("#suggestionWeaponList optionLselected").text();
    $.post("/game/suggest", JSON.stringify({"api":null, "character": character, "weapon": weapon}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});

$( "#disproveSuggestion" ).submit(function( event ) {
    var card = $("#disproveList optionLselected").text();
    $.post("/game/disprove", JSON.stringify({"api":null, "card": card}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});

$( "#makeAccusation" ).submit(function( event ) {
    var character = $("#accusationCharacterList optionLselected").text();
    var weapon = $("#accusationWeaponList optionLselected").text();
    var room = $("#accusationRoomList optionLselected").text();
    $.post("/game/accuse", JSON.stringify({"api":null, "character": character, "weapon": weapon, "room": room}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});

$( "#endTurn" ).submit(function( event ) {
    $.post("/game/endturn", JSON.stringify({"api":null}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});
