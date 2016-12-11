$( "#addPlayer" ).submit(function( event ) {
  $.post("/game/join", JSON.stringify({"api":null}), function(data) {
        $( "#postResult" ).html(data);
  }).fail( function(data) {
      $( "#postResult" ).html(data.responseText);
    });
  event.preventDefault();
});

$( "#setToken" ).submit(function( event ) {
    var who = $("#setToken").find('input[name="who"]').val();
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
    var moveTo = $("#move").find('input[name="to"]').val();
    $.post("/game/move", JSON.stringify({"api":null, "to": moveTo}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});

$( "#makeSuggestion" ).submit(function( event ) {
    var character = $("#makeSuggestion").find('input[name="character"]').val();
    var weapon = $("#makeSuggestion").find('input[name="weapon"]').val();
    $.post("/game/suggest", JSON.stringify({"api":null, "character": character, "weapon": weapon}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});

$( "#disproveSuggestion" ).submit(function( event ) {
    var card = $("#disproveSuggestion").find('input[name="card"]').val();
    $.post("/game/disprove", JSON.stringify({"api":null, "card": card}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});

$( "#makeAccusation" ).submit(function( event ) {
    var character = $("#makeAccusation").find('input[name="character"]').val();
    var weapon = $("#makeAccusation").find('input[name="weapon"]').val();
    var room = $("#makeAccusation").find('input[name="room"]').val();
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
