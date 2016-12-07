/**
 * Created by chris1chang on 12/5/2016.
 */
// Create the canvas
var canvas = document.createElement("canvas");
var ctx = canvas.getContext("2d");
canvas.width = 720;
canvas.height = 675;
document.body.appendChild(canvas);

// Images
// Background image
var bgReady = false;
var bgImage = new Image();
bgImage.onload = function () {
    bgReady = true;
};
bgImage.src = "images/final-board-small-1020px.jpg";

// Col Mustard
var mustardReady = false;
var mustardImage = new Image();
mustardImage.onload = function () {
    mustardReady = true;
};
mustardImage.src = "images/Col_Mustard.PNG";

// Miss Scarlett
var scarlettReady = false;
var scarlettImage = new Image();
scarlettImage.onload = function () {
    scarlettReady = true;
};
scarlettImage.src = "images/Miss_Scarlett.PNG";

// Mr Green
var greenReady = false;
var greenImage = new Image();
greenImage.onload = function () {
    greenReady = true;
};
greenImage.src = "images/Mr_Green.PNG";

// Mrs Peacock
var peacockReady = false;
var peacockImage = new Image();
peacockImage.onload = function () {
    peacockReady = true;
};
peacockImage.src = "images/Mrs_Peacock.PNG";

// Mrs White
var whiteReady = false;
var whiteImage = new Image();
whiteImage.onload = function () {
    whiteReady = true;
};
whiteImage.src = "images/Mrs_White.PNG";

// Professor Plum
var plumReady = false;
var plumImage = new Image();
plumImage.onload = function () {
    plumReady = true;
};
plumImage.src = "images/Professor_Plum.PNG";


// Objects
var ColMustard = {};
var MissScarlett = {};
var MrGreen = {};
var MrsPeacock = {};
var MrsWhite = {};
var ProfessorPlum = {};

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
}
// Draw everything
var render = function () {
    if (bgReady) {
        ctx.drawImage(bgImage, 0, 0, 720, 675);
    }
    if (plumReady){
        ctx.drawImage(plumImage, ProfessorPlum.x, ProfessorPlum.y, 42.6666666667, 40);
    }
    if (peacockReady){
        ctx.drawImage(peacockImage, MrsPeacock.x, MrsPeacock.y, 42.6666666667, 40);
    }
    if (greenReady){
        ctx.drawImage(greenImage, MrGreen.x, MrGreen.y, 42.6666666667, 40);
    }
    if (whiteReady){
        ctx.drawImage(whiteImage, MrsWhite.x, MrsWhite.y, 42.6666666667, 40);
    }
    if (scarlettReady){
        ctx.drawImage(scarlettImage, MissScarlett.x, MissScarlett.y, 42.6666666667, 40);
    }
    if (mustardReady){
        ctx.drawImage(mustardImage, ColMustard.x, ColMustard.y, 42.6666666667, 40);
    }
    // Score
    ctx.fillStyle = "rgb(250, 250, 250)";
    ctx.font = "24px Helvetica";
    ctx.textAlign = "left";
    ctx.textBaseline = "top";
};


//Update: TODO
var update = {};

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
var then = Date.now();
reset();
main();
