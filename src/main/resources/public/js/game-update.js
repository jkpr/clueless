/**
 * Created by jpringle on 12/10/16.
 */

$.get("/game?type=json", function(data) {
    updateGame(JSON.parse(data));
});