/**
 * Created by chris1chang on 12/6/2016.
 */
// Create the canvas
var canvas = document.createElement("canvas");
var ctx = canvas.getContext("2d");
canvas.width = 720;
canvas.height = 675;
document.body.appendChild(canvas);


canvas.addEventListener("mousedown", getPosition, false);

function getPosition(event)
{
    var x = event.x - 25;
    var y = event.y - 25;

    var canvas = document.getElementById("canvas");

    alert("x:" + x + " y:" + y);
}


// Images
// Background image
var bgReady = false;
var bgImage = new Image();
bgImage.onload = function () {
    bgReady = true;
};
bgImage.src = "../public/images/final-board-small-1020px.jpg";

//Characters
// Col Mustard
var mustardReady = false;
var mustardImage = new Image();
mustardImage.onload = function () {
    mustardReady = true;
};
mustardImage.src = "../public/images/colMustard.png";

// Miss Scarlett
var scarlettReady = false;
var scarlettImage = new Image();
scarlettImage.onload = function () {
    scarlettReady = true;
};
scarlettImage.src = "../public/images/msScarlet.png";

// Mr Green
var greenReady = false;
var greenImage = new Image();
greenImage.onload = function () {
    greenReady = true;
};
greenImage.src = "../public/images/mrGreen.png";

// Mrs Peacock
var peacockReady = false;
var peacockImage = new Image();
peacockImage.onload = function () {
    peacockReady = true;
};
peacockImage.src = "../public/images/mrsPeacock.png";

// Mrs White
var whiteReady = false;
var whiteImage = new Image();
whiteImage.onload = function () {
    whiteReady = true;
};
whiteImage.src = "../public/images/mrsWhite.png";

// Professor Plum
var plumReady = false;
var plumImage = new Image();
plumImage.onload = function () {
    plumReady = true;
};
plumImage.src = "../public/images/profPlum.png";

//Weapons
//knife
var knifeReady = false;
var knifeImage = new Image();
knifeImage.onload = function () {
    knifeReady = true;
};
knifeImage.src = "../public/images/knife.png";

//candlestick
var candleReady = false;
var candleImage = new Image();
candleImage.onload = function () {
    candleReady = true;
};
candleImage.src = "../public/images/candlestick.png";

//pipe
var pipeReady = false;
var pipeImage = new Image();
pipeImage.onload = function () {
    pipeReady = true;
};
pipeImage.src = "../public/images/pipe.png";

//wrench
var wrenchReady = false;
var wrenchImage = new Image();
wrenchImage.onload = function () {
    wrenchReady = true;
};
wrenchImage.src = "../public/images/wrench.png";

//revolver
var revolverReady = false;
var revolverImage = new Image();
revolverImage.onload = function () {
    revolverReady = true;
};
revolverImage.src = "../public/images/revolver.png";

//rope
var ropeReady = false;
var ropeImage = new Image();
ropeImage.onload = function () {
    ropeReady = true;
};
ropeImage.src = "../public/images/knife.png";

// Objects
var ColMustard = {};
var MissScarlett = {};
var MrGreen = {};
var MrsPeacock = {};
var MrsWhite = {};
var ProfessorPlum = {};
var Knife = {};
var CandleStick = {};
var Pipe = {};
var Revolver = {};
var Rope = {};

// Reset the game and place characters back in place
// DO NOT CHANGE!!!!!!!
var reset = function () {
    ColMustard.x = 630;
    ColMustard.y = 200;

    MissScarlett.x = 465;
    MissScarlett.y = 35;

    MrGreen.x = 215;
    MrGreen.y = 590;

    MrsPeacock.x = 45;
    MrsPeacock.y = 435;

    MrsWhite.x = 465;
    MrsWhite.y = 590;

    ProfessorPlum.x = 45;
    ProfessorPlum.y = 200;
};
// Draw everything
var render = function () {
    if (bgReady) {
        ctx.drawImage(bgImage, 0, 0, 720, 675);
    }
    if (plumReady){
        ctx.drawImage(plumImage, ProfessorPlum.x, ProfessorPlum.y, 51.2, 48);
    }
    if (peacockReady){
        ctx.drawImage(peacockImage, MrsPeacock.x, MrsPeacock.y, 51.2, 48);
    }
    if (greenReady){
        ctx.drawImage(greenImage, MrGreen.x, MrGreen.y, 51.2, 48);
    }
    if (whiteReady){
        ctx.drawImage(whiteImage, MrsWhite.x, MrsWhite.y, 51.2, 48);
    }
    if (scarlettReady){
        ctx.drawImage(scarlettImage, MissScarlett.x, MissScarlett.y, 51.2, 48);
    }
    if (mustardReady){
        ctx.drawImage(mustardImage, ColMustard.x, ColMustard.y, 51.2, 48);
    }
    // Score
    ctx.fillStyle = "rgb(250, 250, 250)";
    ctx.font = "24px Helvetica";
    ctx.textAlign = "left";
    ctx.textBaseline = "top";
};


$( document ).ready(function() {
    console.log( "ready!" );
    $( "#endTurn" ).click(function() {

        if ($( "#characterList option:selected" ).text() != "" && $( "#roomList option:selected" ).text() != "")
        {
            //console.log("fck dicks");
            var character = $("#characterList option:selected").text()
            var room = $("#roomList option:selected").text()

            if (character == "Professor Plum")
            {
                if (room == "Library")
                {
                    ProfessorPlum.x = 85;
                    ProfessorPlum.y = 300;
                }
                if (room == "Study")
                {
                    ProfessorPlum.x = 85;
                    ProfessorPlum.y = 80;
                }
                if (room == "Hall")
                {
                    ProfessorPlum.x = 340;
                    ProfessorPlum.y = 80;
                }
                if (room == "Lounge")
                {
                    ProfessorPlum.x = 590;
                    ProfessorPlum.y = 80;
                }
                if (room == "Billiard Room")
                {
                    ProfessorPlum.x = 340;
                    ProfessorPlum.y = 300;
                }
                if (room == "Dining Room")
                {
                    ProfessorPlum.x = 590;
                    ProfessorPlum.y = 300;
                }
                if (room == "Conservatory")
                {
                    ProfessorPlum.x = 85;
                    ProfessorPlum.y = 555;
                }
                if (room == "BallRoom")
                {
                    ProfessorPlum.x = 340;
                    ProfessorPlum.y = 555;
                }
                if (room == "Kitchen")
                {
                    ProfessorPlum.x = 590;
                    ProfessorPlum.y = 555;
                }
                if (room == "Hall-Study")
                {
                    ProfessorPlum.x = 215;
                    ProfessorPlum.y = 80;
                }
                if (room == "Hall-Lounge")
                {
                    ProfessorPlum.x = 465;
                    ProfessorPlum.y = 80;
                }
                if (room == "Library-Study")
                {
                    ProfessorPlum.x = 85;
                    ProfessorPlum.y = 200;
                }
                if (room == "Billiard room-Hall")
                {
                    ProfessorPlum.x = 340;
                    ProfessorPlum.y = 200;
                }
                if (room == "Dining room-Lounge")
                {
                    ProfessorPlum.x = 590;
                    ProfessorPlum.y = 200;
                }
                if ( room == "Billiard room-Library")
                {
                    ProfessorPlum.x = 215;
                    ProfessorPlum.y = 310;
                }
                if (room == "Billiard room-Dining room")
                {
                    ProfessorPlum.x = 465;
                    ProfessorPlum.y = 310;
                }
                if ( room == "Conservatory-Library")
                {
                    ProfessorPlum.x = 85;
                    ProfessorPlum.y = 435;
                }
                if (room == "Ballroom-Billiard room")
                {
                    ProfessorPlum.x = 340;
                    ProfessorPlum.y = 435;
                }
                if ( room == "Dining room-Kitchen")
                {
                    ProfessorPlum.x = 590;
                    ProfessorPlum.y = 435;
                }
                if (room == "Ballroom-Conservatory")
                {
                    ProfessorPlum.x = 215;
                    ProfessorPlum.y = 555;
                }
                if ( room == "Ballroom-Kitchen")
                {
                    ProfessorPlum.x = 465;
                    ProfessorPlum.y = 555;
                }
            }

            if (character == "Miss Scarlet") {
                if (room == "Library") {
                    MissScarlett.x = 55;
                    MissScarlett.y = 300;
                }
                if (room == "Study") {
                    MissScarlett.x = 55;
                    MissScarlett.y = 80;
                }
                if (room == "Hall") {
                    MissScarlett.x = 310;
                    MissScarlett.y = 80;
                }
                if (room == "Lounge") {
                    MissScarlett.x = 550;
                    MissScarlett.y = 80;
                }
                if (room == "Billiard Room") {
                    MissScarlett.x = 310;
                    MissScarlett.y = 300;
                }
                if (room == "Dining Room") {
                    MissScarlett.x = 560;
                    MissScarlett.y = 300;
                }
                if (room == "Conservatory") {
                    MissScarlett.x = 55;
                    MissScarlett.y = 555;
                }
                if (room == "BallRoom") {
                    MissScarlett.x = 310;
                    MissScarlett.y = 555;
                }
                if (room == "Kitchen") {
                    MissScarlett.x = 560;
                    MissScarlett.y = 555;
                }
                if (room == "Hall-Study")
                {
                    MissScarlett.x = 215;
                    MissScarlett.y = 80;
                }
                if (room == "Hall-Lounge")
                {
                    MissScarlett.x = 465;
                    MissScarlett.y = 80;
                }
                if (room == "Library-Study")
                {
                    MissScarlett.x = 85;
                    MissScarlett.y = 200;
                }
                if (room == "Billiard room-Hall")
                {
                    MissScarlett.x = 340;
                    MissScarlett.y = 200;
                }
                if (room == "Dining room-Lounge")
                {
                    MissScarlett.x = 590;
                    MissScarlett.y = 200;
                }
                if ( room == "Billiard room-Library")
                {
                    MissScarlett.x = 215;
                    MissScarlett.y = 310;
                }
                if (room == "Billiard room-Dining room")
                {
                    MissScarlett.x = 465;
                    MissScarlett.y = 310;
                }
                if ( room == "Conservatory-Library")
                {
                    MissScarlett.x = 85;
                    MissScarlett.y = 435;
                }
                if (room == "Ballroom-Billiard room")
                {
                    MissScarlett.x = 340;
                    MissScarlett.y = 435;
                }
                if ( room == "Dining room-Kitchen")
                {
                    MissScarlett.x = 590;
                    MissScarlett.y = 435;
                }
                if (room == "Ballroom-Conservatory")
                {
                    MissScarlett.x = 215;
                    MissScarlett.y = 555;
                }
                if ( room == "Ballroom-Kitchen")
                {
                    MissScarlett.x = 465;
                    MissScarlett.y = 555;
                }
            }

            if (character == "Colonel Mustard") {
                if (room == "Library") {
                    ColMustard.x = 25;
                    ColMustard.y = 300;
                }
                if (room == "Study") {
                    ColMustard.x = 25;
                    ColMustard.y = 80;
                }
                if (room == "Hall") {
                    ColMustard.x = 280;
                    ColMustard.y = 80;
                }
                if (room == "Lounge") {
                    ColMustard.x = 520;
                    ColMustard.y = 80;
                }
                if (room == "Billiard Room") {
                    ColMustard.x = 280;
                    ColMustard.y = 300;
                }
                if (room == "Dining Room") {
                    ColMustard.x = 530;
                    ColMustard.y = 300;
                }
                if (room == "Conservatory") {
                    ColMustard.x = 25;
                    ColMustard.y = 555;
                }
                if (room == "BallRoom") {
                    ColMustard.x = 280;
                    ColMustard.y = 555;
                }
                if (room == "Kitchen") {
                    ColMustard.x = 530;
                    ColMustard.y = 555;
                }
                if (room == "Hall-Study")
                {
                    ColMustard.x = 215;
                    ColMustard.y = 80;
                }
                if (room == "Hall-Lounge")
                {
                    ColMustard.x = 465;
                    ColMustard.y = 80;
                }
                if (room == "Library-Study")
                {
                    ColMustard.x = 85;
                    ColMustard.y = 200;
                }
                if (room == "Billiard room-Hall")
                {
                    ColMustard.x = 340;
                    ColMustard.y = 200;
                }
                if (room == "Dining room-Lounge")
                {
                    ColMustard.x = 590;
                    ColMustard.y = 200;
                }
                if ( room == "Billiard room-Library")
                {
                    ColMustard.x = 215;
                    ColMustard.y = 310;
                }
                if (room == "Billiard room-Dining room")
                {
                    ColMustard.x = 465;
                    ColMustard.y = 310;
                }
                if ( room == "Conservatory-Library")
                {
                    ColMustard.x = 85;
                    ColMustard.y = 435;
                }
                if (room == "Ballroom-Billiard room")
                {
                    ColMustard.x = 340;
                    ColMustard.y = 435;
                }
                if ( room == "Dining room-Kitchen")
                {
                    ColMustard.x = 590;
                    ColMustard.y = 435;
                }
                if (room == "Ballroom-Conservatory")
                {
                    ColMustard.x = 215;
                    ColMustard.y = 555;
                }
                if ( room == "Ballroom-Kitchen")
                {
                    ColMustard.x = 465;
                    ColMustard.y = 555;
                }
            }

            if (character == "Mrs. Peacock")
            {
                if (room == "Library")
                {
                    MrsPeacock.x = 115;
                    MrsPeacock.y = 300;
                }
                if (room == "Study")
                {
                    MrsPeacock.x = 115;
                    MrsPeacock.y = 80;
                }
                if (room == "Hall")
                {
                    MrsPeacock.x = 370;
                    MrsPeacock.y = 80;
                }
                if (room == "Lounge")
                {
                    MrsPeacock.x = 620;
                    MrsPeacock.y = 80;
                }
                if (room == "Billiard Room")
                {
                    MrsPeacock.x = 370;
                    MrsPeacock.y = 300;
                }
                if (room == "Dining Room")
                {
                    MrsPeacock.x = 620;
                    MrsPeacock.y = 300;
                }
                if (room == "Conservatory")
                {
                    MrsPeacock.x = 115;
                    MrsPeacock.y = 555;
                }
                if (room == "BallRoom")
                {
                    MrsPeacock.x = 370;
                    MrsPeacock.y = 555;
                }
                if (room == "Kitchen")
                {
                    MrsPeacock.x = 620;
                    MrsPeacock.y = 555;
                }
                if (room == "Hall-Study")
                {
                    MrsPeacock.x = 215;
                    MrsPeacock.y = 80;
                }
                if (room == "Hall-Lounge")
                {
                    MrsPeacock.x = 465;
                    MrsPeacock.y = 80;
                }
                if (room == "Library-Study")
                {
                    MrsPeacock.x = 85;
                    MrsPeacock.y = 200;
                }
                if (room == "Billiard room-Hall")
                {
                    MrsPeacock.x = 340;
                    MrsPeacock.y = 200;
                }
                if (room == "Dining room-Lounge")
                {
                    MrsPeacock.x = 590;
                    MrsPeacock.y = 200;
                }
                if ( room == "Billiard room-Library")
                {
                    MrsPeacock.x = 215;
                    MrsPeacock.y = 310;
                }
                if (room == "Billiard room-Dining room")
                {
                    MrsPeacock.x = 465;
                    MrsPeacock.y = 310;
                }
                if ( room == "Conservatory-Library")
                {
                    MrsPeacock.x = 85;
                    MrsPeacock.y = 435;
                }
                if (room == "Ballroom-Billiard room")
                {
                    MrsPeacock.x = 340;
                    MrsPeacock.y = 435;
                }
                if ( room == "Dining room-Kitchen")
                {
                    MrsPeacock.x = 590;
                    MrsPeacock.y = 435;
                }
                if (room == "Ballroom-Conservatory")
                {
                    MrsPeacock.x = 215;
                    MrsPeacock.y = 555;
                }
                if ( room == "Ballroom-Kitchen")
                {
                    MrsPeacock.x = 465;
                    MrsPeacock.y = 555;
                }
            }
            if (character == "Mr. Green")
            {
                if (room == "Library")
                {
                    MrGreen.x = 145;
                    MrGreen.y = 300;
                }
                if (room == "Study")
                {
                    MrGreen.x = 145;
                    MrGreen.y = 80;
                }
                if (room == "Hall")
                {
                    MrGreen.x = 400;
                    MrGreen.y = 80;
                }
                if (room == "Lounge")
                {
                    MrGreen.x = 650;
                    MrGreen.y = 80;
                }
                if (room == "Billiard Room")
                {
                    MrGreen.x = 400;
                    MrGreen.y = 300;
                }
                if (room == "Dining Room")
                {
                    MrGreen.x = 650;
                    MrGreen.y = 300;
                }
                if (room == "Conservatory")
                {
                    MrGreen.x = 145;
                    MrGreen.y = 555;
                }
                if (room == "BallRoom")
                {
                    MrGreen.x = 400;
                    MrGreen.y = 555;
                }
                if (room == "Kitchen")
                {
                    MrGreen.x = 650;
                    MrGreen.y = 555;
                }
                if (room == "Hall-Study")
                {
                    MrGreen.x = 215;
                    MrGreen.y = 80;
                }
                if (room == "Hall-Lounge")
                {
                    MrGreen.x = 465;
                    MrGreen.y = 80;
                }
                if (room == "Library-Study")
                {
                    MrGreen.x = 85;
                    MrGreen.y = 200;
                }
                if (room == "Billiard room-Hall")
                {
                    MrGreen.x = 340;
                    MrGreen.y = 200;
                }
                if (room == "Dining room-Lounge")
                {
                    MrGreen.x = 590;
                    MrGreen.y = 200;
                }
                if ( room == "Billiard room-Library")
                {
                    MrGreen.x = 215;
                    MrGreen.y = 310;
                }
                if (room == "Billiard room-Dining room")
                {
                    MrGreen.x = 465;
                    MrGreen.y = 310;
                }
                if ( room == "Conservatory-Library")
                {
                    MrGreen.x = 85;
                    MrGreen.y = 435;
                }
                if (room == "Ballroom-Billiard room")
                {
                    MrGreen.x = 340;
                    MrGreen.y = 435;
                }
                if ( room == "Dining room-Kitchen")
                {
                    MrGreen.x = 590;
                    MrGreen.y = 435;
                }
                if (room == "Ballroom-Conservatory")
                {
                    MrGreen.x = 215;
                    MrGreen.y = 555;
                }
                if ( room == "Ballroom-Kitchen")
                {
                    MrGreen.x = 465;
                    MrGreen.y = 555;
                }
            }
            if (character == "Mrs. White")
            {
                if (room == "Library")
                {
                    MrsWhite.x = 85;
                    MrsWhite.y = 350;
                }
                if (room == "Study")
                {
                    MrsWhite.x = 85;
                    MrsWhite.y = 130;
                }
                if (room == "Hall")
                {
                    MrsWhite.x = 340;
                    MrsWhite.y = 130;
                }
                if (room == "Lounge")
                {
                    MrsWhite.x = 590;
                    MrsWhite.y = 130;
                }
                if (room == "Billiard Room")
                {
                    MrsWhite.x = 340;
                    MrsWhite.y = 350;
                }
                if (room == "Dining Room")
                {
                    MrsWhite.x = 590;
                    MrsWhite.y = 350;
                }
                if (room == "Conservatory")
                {
                    MrsWhite.x = 85;
                    MrsWhite.y = 605;
                }
                if (room == "BallRoom")
                {
                    MrsWhite.x = 340;
                    MrsWhite.y = 605;
                }
                if (room == "Kitchen")
                {
                    MrsWhite.x = 590;
                    MrsWhite.y = 605;
                }
                if (room == "Hall-Study")
                {
                    MrsWhite.x = 215;
                    MrsWhite.y = 80;
                }
                if (room == "Hall-Lounge")
                {
                    MrsWhite.x = 465;
                    MrsWhite.y = 80;
                }
                if (room == "Library-Study")
                {
                    MrsWhite.x = 85;
                    MrsWhite.y = 200;
                }
                if (room == "Billiard room-Hall")
                {
                    MrsWhite.x = 340;
                    MrsWhite.y = 200;
                }
                if (room == "Dining room-Lounge")
                {
                    MrsWhite.x = 590;
                    MrsWhite.y = 200;
                }
                if ( room == "Billiard room-Library")
                {
                    MrsWhite.x = 215;
                    MrsWhite.y = 310;
                }
                if (room == "Billiard room-Dining room")
                {
                    MrsWhite.x = 465;
                    MrsWhite.y = 310;
                }
                if ( room == "Conservatory-Library")
                {
                    MrsWhite.x = 85;
                    MrsWhite.y = 435;
                }
                if (room == "Ballroom-Billiard room")
                {
                    MrsWhite.x = 340;
                    MrsWhite.y = 435;
                }
                if ( room == "Dining room-Kitchen")
                {
                    MrsWhite.x = 590;
                    MrsWhite.y = 435;
                }
                if (room == "Ballroom-Conservatory")
                {
                    MrsWhite.x = 215;
                    MrsWhite.y = 555;
                }
                if ( room == "Ballroom-Kitchen")
                {
                    MrsWhite.x = 465;
                    MrsWhite.y = 555;
                }
            }
        }

        else
        {
            //Do nothing
            console.log("Empty");
        }

    });

});
// The main game loop
var main = function () {

    render();

    // Request to do this again ASAP
    requestAnimationFrame(main);
};

// Cross-browser support for requestAnimationFrame
var w = window;
requestAnimationFrame = w.requestAnimationFrame || w.webkitRequestAnimationFrame || w.msRequestAnimationFrame || w.mozRequestAnimationFrame;

// Let's play this game!
reset();
main();