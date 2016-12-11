/**
 * Created by chris1chang on 12/6/2016.
 */
// Create the canvas
var canvas = document.createElement("canvas");
var ctx = canvas.getContext("2d");
canvas.width = 720;
canvas.height = 675;
document.getElementById("game").appendChild(canvas);

/*
canvas.addEventListener("mousedown", getPosition, false);
function getPosition(event)
{
    var x = event.x - 25;
    var y = event.y - 25;
    var canvas = document.getElementById("canvas");
    alert("x:" + x + " y:" + y);
}
*/

// Images
// Background image
var bgReady = false;
var bgImage = new Image();
bgImage.onload = function () {
    bgReady = true;
};
bgImage.src = "../img/final-board-small-1020px.jpg";

//Characters
// Col Mustard
var mustardReady = false;
var mustardImage = new Image();
mustardImage.onload = function () {
    mustardReady = true;
};
mustardImage.src = "../img/colMustard.png";

// Miss Scarlett
var scarlettReady = false;
var scarlettImage = new Image();
scarlettImage.onload = function () {
    scarlettReady = true;
};
scarlettImage.src = "../img/msScarlet.png";

// Mr Green
var greenReady = false;
var greenImage = new Image();
greenImage.onload = function () {
    greenReady = true;
};
greenImage.src = "../img/mrGreen.png";

// Mrs Peacock
var peacockReady = false;
var peacockImage = new Image();
peacockImage.onload = function () {
    peacockReady = true;
};
peacockImage.src = "../img/mrsPeacock.png";

// Mrs White
var whiteReady = false;
var whiteImage = new Image();
whiteImage.onload = function () {
    whiteReady = true;
};
whiteImage.src = "../img/mrsWhite.png";

// Professor Plum
var plumReady = false;
var plumImage = new Image();
plumImage.onload = function () {
    plumReady = true;
};
plumImage.src = "../img/profPlum.png";

//Weapons
//knife
var knifeReady = false;
var knifeImage = new Image();
knifeImage.onload = function () {
    knifeReady = true;
};
knifeImage.src = "../img/knife.png";

//candlestick
var candleReady = false;
var candleImage = new Image();
candleImage.onload = function () {
    candleReady = true;
};
candleImage.src = "../img/candlestick.png";

//pipe
var pipeReady = false;
var pipeImage = new Image();
pipeImage.onload = function () {
    pipeReady = true;
};
pipeImage.src = "../img/pipe.png";

//revolver
var revolverReady = false;
var revolverImage = new Image();
revolverImage.onload = function () {
    revolverReady = true;
};
revolverImage.src = "../img/revolver.png";

//rope
var ropeReady = false;
var ropeImage = new Image();
ropeImage.onload = function () {
    ropeReady = true;
};
ropeImage.src = "../img/knife.png";

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
    ColMustard.x = 590;
    ColMustard.y = 200;

    MissScarlett.x = 465;
    MissScarlett.y = 80;

    MrGreen.x = 215;
    MrGreen.y = 555;

    MrsPeacock.x = 85;
    MrsPeacock.y = 435;

    MrsWhite.x = 465;
    MrsWhite.y = 555

    ProfessorPlum.x = 85;
    ProfessorPlum.y = 200;
};
// Draw everything
var render = function () {
    if (bgReady) {
        ctx.drawImage(bgImage, 0, 0, 720, 675);
    }
    if (plumReady) {
        ctx.drawImage(plumImage, ProfessorPlum.x, ProfessorPlum.y, 51.2, 48);
    }
    if (peacockReady) {
        ctx.drawImage(peacockImage, MrsPeacock.x, MrsPeacock.y, 51.2, 48);
    }
    if (greenReady) {
        ctx.drawImage(greenImage, MrGreen.x, MrGreen.y, 51.2, 48);
    }
    if (whiteReady) {
        ctx.drawImage(whiteImage, MrsWhite.x, MrsWhite.y, 51.2, 48);
    }
    if (scarlettReady) {
        ctx.drawImage(scarlettImage, MissScarlett.x, MissScarlett.y, 51.2, 48);
    }
    if (mustardReady) {
        ctx.drawImage(mustardImage, ColMustard.x, ColMustard.y, 51.2, 48);
    }
    // Score
    ctx.fillStyle = "rgb(250, 250, 250)";
    ctx.font = "24px Helvetica";
    ctx.textAlign = "left";
    ctx.textBaseline = "top";
};


$(document).ready(function () {
    console.log("ready!");
    $("#endTurn2").click(function () {

        if ($("#characterList option:selected").text() != "" && $("#roomList option:selected").text() != "") {
            var character = $("#characterList option:selected").text();
            var room = $("#roomList option:selected").text();

            if (character == "Professor Plum") {
                if (room == "Library") {
                    ProfessorPlum.x = 85;
                    ProfessorPlum.y = 300;
                }
                if (room == "Study") {
                    ProfessorPlum.x = 85;
                    ProfessorPlum.y = 80;
                }
                if (room == "Hall") {
                    ProfessorPlum.x = 340;
                    ProfessorPlum.y = 80;
                }
                if (room == "Lounge") {
                    ProfessorPlum.x = 590;
                    ProfessorPlum.y = 80;
                }
                if (room == "Billiard Room") {
                    ProfessorPlum.x = 340;
                    ProfessorPlum.y = 300;
                }
                if (room == "Dining Room") {
                    ProfessorPlum.x = 590;
                    ProfessorPlum.y = 300;
                }
                if (room == "Conservatory") {
                    ProfessorPlum.x = 85;
                    ProfessorPlum.y = 555;
                }
                if (room == "BallRoom") {
                    ProfessorPlum.x = 340;
                    ProfessorPlum.y = 555;
                }
                if (room == "Kitchen") {
                    ProfessorPlum.x = 590;
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
            }

            if (character == "Mrs. Peacock") {
                if (room == "Library") {
                    MrsPeacock.x = 115;
                    MrsPeacock.y = 300;
                }
                if (room == "Study") {
                    MrsPeacock.x = 115;
                    MrsPeacock.y = 80;
                }
                if (room == "Hall") {
                    MrsPeacock.x = 370;
                    MrsPeacock.y = 80;
                }
                if (room == "Lounge") {
                    MrsPeacock.x = 620;
                    MrsPeacock.y = 80;
                }
                if (room == "Billiard Room") {
                    MrsPeacock.x = 370;
                    MrsPeacock.y = 300;
                }
                if (room == "Dining Room") {
                    MrsPeacock.x = 620;
                    MrsPeacock.y = 300;
                }
                if (room == "Conservatory") {
                    MrsPeacock.x = 115;
                    MrsPeacock.y = 555;
                }
                if (room == "BallRoom") {
                    MrsPeacock.x = 370;
                    MrsPeacock.y = 555;
                }
                if (room == "Kitchen") {
                    MrsPeacock.x = 620;
                    MrsPeacock.y = 555;
                }
            }
            if (character == "Mr. Green") {
                if (room == "Library") {
                    MrGreen.x = 145;
                    MrGreen.y = 300;
                }
                if (room == "Study") {
                    MrGreen.x = 145;
                    MrGreen.y = 80;
                }
                if (room == "Hall") {
                    MrGreen.x = 400;
                    MrGreen.y = 80;
                }
                if (room == "Lounge") {
                    MrGreen.x = 650;
                    MrGreen.y = 80;
                }
                if (room == "Billiard Room") {
                    MrGreen.x = 400;
                    MrGreen.y = 300;
                }
                if (room == "Dining Room") {
                    MrGreen.x = 650;
                    MrGreen.y = 300;
                }
                if (room == "Conservatory") {
                    MrGreen.x = 145;
                    MrGreen.y = 555;
                }
                if (room == "BallRoom") {
                    MrGreen.x = 400;
                    MrGreen.y = 555;
                }
                if (room == "Kitchen") {
                    MrGreen.x = 650;
                    MrGreen.y = 555;
                }
            }
            if (character == "Mrs. White") {
                if (room == "Library") {
                    MrsWhite.x = 85;
                    MrsWhite.y = 350;
                }
                if (room == "Study") {
                    MrsWhite.x = 85;
                    MrsWhite.y = 130;
                }
                if (room == "Hall") {
                    MrsWhite.x = 340;
                    MrsWhite.y = 130;
                }
                if (room == "Lounge") {
                    MrsWhite.x = 590;
                    MrsWhite.y = 130;
                }
                if (room == "Billiard Room") {
                    MrsWhite.x = 340;
                    MrsWhite.y = 350;
                }
                if (room == "Dining Room") {
                    MrsWhite.x = 590;
                    MrsWhite.y = 350;
                }
                if (room == "Conservatory") {
                    MrsWhite.x = 85;
                    MrsWhite.y = 605;
                }
                if (room == "BallRoom") {
                    MrsWhite.x = 340;
                    MrsWhite.y = 605;
                }
                if (room == "Kitchen") {
                    MrsWhite.x = 590;
                    MrsWhite.y = 605;
                }
            }
        }

        else {
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