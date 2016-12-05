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
    console.log(who);
    $.post("/game/token", JSON.stringify({"api":null, "who": who}), function(data) {
        $( "#postResult" ).html(data);
    }).fail( function(data) {
        $( "#postResult" ).html(data.responseText);
    });
    event.preventDefault();
});