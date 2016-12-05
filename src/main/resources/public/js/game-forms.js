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

$( "#endTurn" ).submit(function( event ) {
    $.post("/game/endturn", JSON.stringify({"api":null}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});

