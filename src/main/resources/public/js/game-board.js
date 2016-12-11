var startBoard = {
  "Ms. Scarlet": "Scarlet start",
  "Col. Mustard": "Mustard start",
  "Mrs. White": "White start",
  "Mr. Green": "Green start",
  "Mrs. Peacock": "Peacock start",
  "Prof. Plum": "Plum start",
  "Candlestick": "Study",
  "Knife": "Hall",
  "Pipe": "Lounge",
  "Revolver": "Conservatory",
  "Rope": "Billiard room",
  "Wrench": "Kitchen"
};

var allKitchenBoard = {
  "Ms. Scarlet": "Kitchen",
  "Col. Mustard": "Kitchen",
  "Mrs. White": "Kitchen",
  "Mr. Green": "Kitchen",
  "Mrs. Peacock": "Kitchen",
  "Prof. Plum": "Kitchen",
  "Candlestick": "Kitchen",
  "Knife": "Kitchen",
  "Pipe": "Kitchen",
  "Revolver": "Kitchen",
  "Rope": "Kitchen",
  "Wrench": "Kitchen"
};

var allBallroomBoard = {
  "Ms. Scarlet": "Ballroom",
  "Col. Mustard": "Ballroom",
  "Mrs. White": "Ballroom",
  "Mr. Green": "Ballroom",
  "Mrs. Peacock": "Ballroom",
  "Prof. Plum": "Ballroom",
  "Candlestick": "Ballroom",
  "Knife": "Ballroom",
  "Pipe": "Ballroom",
  "Revolver": "Ballroom",
  "Rope": "Ballroom",
  "Wrench": "Ballroom"
};

var allConservatoryBoard = {
  "Ms. Scarlet": "Conservatory",
  "Col. Mustard": "Conservatory",
  "Mrs. White": "Conservatory",
  "Mr. Green": "Conservatory",
  "Mrs. Peacock": "Conservatory",
  "Prof. Plum": "Conservatory",
  "Candlestick": "Conservatory",
  "Knife": "Conservatory",
  "Pipe": "Conservatory",
  "Revolver": "Conservatory",
  "Rope": "Conservatory",
  "Wrench": "Conservatory"
};

var allDiningRoomBoard = {
  "Ms. Scarlet": "Dining room",
  "Col. Mustard": "Dining room",
  "Mrs. White": "Dining room",
  "Mr. Green": "Dining room",
  "Mrs. Peacock": "Dining room",
  "Prof. Plum": "Dining room",
  "Candlestick": "Dining room",
  "Knife": "Dining room",
  "Pipe": "Dining room",
  "Revolver": "Dining room",
  "Rope": "Dining room",
  "Wrench": "Dining room"
};

var allBilliardRoomBoard = {
  "Ms. Scarlet": "Billiard room",
  "Col. Mustard": "Billiard room",
  "Mrs. White": "Billiard room",
  "Mr. Green": "Billiard room",
  "Mrs. Peacock": "Billiard room",
  "Prof. Plum": "Billiard room",
  "Candlestick": "Billiard room",
  "Knife": "Billiard room",
  "Pipe": "Billiard room",
  "Revolver": "Billiard room",
  "Rope": "Billiard room",
  "Wrench": "Billiard room"
};

var allLibraryBoard = {
  "Ms. Scarlet": "Library",
  "Col. Mustard": "Library",
  "Mrs. White": "Library",
  "Mr. Green": "Library",
  "Mrs. Peacock": "Library",
  "Prof. Plum": "Library",
  "Candlestick": "Library",
  "Knife": "Library",
  "Pipe": "Library",
  "Revolver": "Library",
  "Rope": "Library",
  "Wrench": "Library"
};

var allLoungeBoard = {
  "Ms. Scarlet": "Lounge",
  "Col. Mustard": "Lounge",
  "Mrs. White": "Lounge",
  "Mr. Green": "Lounge",
  "Mrs. Peacock": "Lounge",
  "Prof. Plum": "Lounge",
  "Candlestick": "Lounge",
  "Knife": "Lounge",
  "Pipe": "Lounge",
  "Revolver": "Lounge",
  "Rope": "Lounge",
  "Wrench": "Lounge"
};

var allHallBoard = {
  "Ms. Scarlet": "Hall",
  "Col. Mustard": "Hall",
  "Mrs. White": "Hall",
  "Mr. Green": "Hall",
  "Mrs. Peacock": "Hall",
  "Prof. Plum": "Hall",
  "Candlestick": "Hall",
  "Knife": "Hall",
  "Pipe": "Hall",
  "Revolver": "Hall",
  "Rope": "Hall",
  "Wrench": "Hall"
};

var allStudyBoard = {
  "Ms. Scarlet": "Study",
  "Col. Mustard": "Study",
  "Mrs. White": "Study",
  "Mr. Green": "Study",
  "Mrs. Peacock": "Study",
  "Prof. Plum": "Study",
  "Candlestick": "Study",
  "Knife": "Study",
  "Pipe": "Study",
  "Revolver": "Study",
  "Rope": "Study",
  "Wrench": "Study"
};


function transformToken(token, room, offsetX, offsetY) {
    var baseX = 0;
    var baseY = 0;

    if (room == "Kitchen") {
        baseX = 12;
        baseY = 12;
    } else if (room == "Ballroom") {
        baseX = 6;
        baseY = 12;
    } else if (room == "Conservatory") {
        baseX = 0;
        baseY = 12;
    } else if (room == "Dining room") {
        baseX = 12;
        baseY = 6;
    } else if (room == "Billiard room") {
        baseX = 6;
        baseY = 6;
    } else if (room == "Library") {
        baseX = 0;
        baseY = 6;
    } else if (room == "Lounge") {
        baseX = 12;
        baseY = 0;
    } else if (room == "Hall") {
        baseX = 6;
        baseY = 0;
    } else if (room == "Study") {
        baseX = 0;
        baseY = 0;
    } else if (room == "Scarlet start") {
        baseX = 11;
        baseY = 1;
    } else if (room == "Mustard start") {
        baseX = 15;
        baseY = 5;
    } else if (room == "White start") {
        baseX = 11;
        baseY = 15;
    } else if (room == "Green start") {
        baseX = 5;
        baseY = 15;
    } else if (room == "Peacock start") {
        baseX = 1;
        baseY = 11;
    } else if (room == "Plum start") {
        baseX = 1;
        baseY = 5;
    } else if (room == "Hall-Study") {
        baseX = 5;
        baseY = 2;
    } else if (room == "Hall-Lounge") {
        baseX = 11;
        baseY = 2;
    } else if (room == "Library-Study") {
        baseX = 2;
        baseY = 5;
    } else if (room == "Billiard room-Hall") {
        baseX = 8;
        baseY = 5;
    } else if (room == "Dining room-Lounge") {
        baseX = 14;
        baseY = 5;
    } else if (room == "Billiard room-Library") {
        baseX = 5;
        baseY = 8;
    } else if (room == "Billiard room-Dining room") {
        baseX = 11;
        baseY = 8;
    } else if (room == "Conservatory-Library") {
        baseX = 2;
        baseY = 11;
    } else if (room == "Ballroom-Billiard room") {
        baseX = 8;
        baseY = 11;
    } else if (room == "Dining room-Kitchen") {
        baseX = 14;
        baseY = 11;
    } else if (room == "Ballroom-Conservatory") {
        baseX = 5;
        baseY = 14;
    } else if (room == "Ballroom-Kitchen") {
        baseX = 11;
        baseY = 14;
    }

    var x = baseX + offsetX;
    var y = baseY + offsetY;

    token.style["transform"] = "translate(" + x*30 + "px, " + y*30 + "px)";
}

function setMsScarlet(room) {
    var token = id("msScarletToken");
    if (room == "Scarlet start") {
        transformToken(token, room, 0, 0);
    } else if (room == "Kitchen") {
        transformToken(token, room, 2, 0);
    } else if (room == "Ballroom") {
        transformToken(token, room, 2, 0);
    } else if (room == "Conservatory") {
        transformToken(token, room, 2, 0);
    } else if (room == "Dining room") {
        transformToken(token, room, 2, 0);
    } else if (room == "Billiard room") {
        transformToken(token, room, 2, 0);
    } else if (room == "Library") {
        transformToken(token, room, 2, 0);
    } else if (room == "Lounge") {
        transformToken(token, room, 2, 1);
    } else if (room == "Hall") {
        transformToken(token, room, 2, 0);
    } else if (room == "Study") {
        transformToken(token, room, 2, 0);
    } else if (room == "Hall-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Hall-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Library-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Hall") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Dining room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Conservatory-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Billiard room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Kitchen") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Conservatory") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Kitchen") {
        transformToken(token, room, 0, 0);
    }
}

function setColMustard(room) {
    var token = id("colMustardToken");
    if (room == "Mustard start") {
        transformToken(token, room, 0, 0);
    } else if (room == "Kitchen") {
        transformToken(token, room, 1, 3);
    } else if (room == "Ballroom") {
        transformToken(token, room, 1, 3);
    } else if (room == "Conservatory") {
        transformToken(token, room, 1, 3);
    } else if (room == "Dining room") {
        transformToken(token, room, 1, 3);
    } else if (room == "Billiard room") {
        transformToken(token, room, 1, 3);
    } else if (room == "Library") {
        transformToken(token, room, 1, 3);
    } else if (room == "Lounge") {
        transformToken(token, room, 0, 4);
    } else if (room == "Hall") {
        transformToken(token, room, 1, 3);
    } else if (room == "Study") {
        transformToken(token, room, 1, 3);
    } else if (room == "Hall-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Hall-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Library-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Hall") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Dining room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Conservatory-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Billiard room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Kitchen") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Conservatory") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Kitchen") {
        transformToken(token, room, 0, 0);
    }
}

function setMrsWhite(room) {
    var token = id("mrsWhiteToken");
    if (room == "White start") {
        transformToken(token, room, 0, 0);
    } else if (room == "Kitchen") {
        transformToken(token, room, 0, 2);
    } else if (room == "Ballroom") {
        transformToken(token, room, 0, 2);
    } else if (room == "Conservatory") {
        transformToken(token, room, 1, 1);
    } else if (room == "Dining room") {
        transformToken(token, room, 2, 4);
    } else if (room == "Billiard room") {
        transformToken(token, room, 0, 2);
    } else if (room == "Library") {
        transformToken(token, room, 0, 2);
    } else if (room == "Lounge") {
        transformToken(token, room, 0, 2);
    } else if (room == "Hall") {
        transformToken(token, room, 0, 2);
    } else if (room == "Study") {
        transformToken(token, room, 1, 1);
    } else if (room == "Hall-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Hall-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Library-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Hall") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Dining room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Conservatory-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Billiard room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Kitchen") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Conservatory") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Kitchen") {
        transformToken(token, room, 0, 0);
    }
}

function setMrGreen(room) {
    var token = id("mrGreenToken");
    if (room == "Green start") {
        transformToken(token, room, 0, 0);
    } else if (room == "Kitchen") {
        transformToken(token, room, 1, 4);
    } else if (room == "Ballroom") {
        transformToken(token, room, 1, 4);
    } else if (room == "Conservatory") {
        transformToken(token, room, 1, 4);
    } else if (room == "Dining room") {
        transformToken(token, room, 0, 3);
    } else if (room == "Billiard room") {
        transformToken(token, room, 1, 4);
    } else if (room == "Library") {
        transformToken(token, room, 0, 3);
    } else if (room == "Lounge") {
        transformToken(token, room, 1, 4);
    } else if (room == "Hall") {
        transformToken(token, room, 0, 3);
    } else if (room == "Study") {
        transformToken(token, room, 1, 4);
    } else if (room == "Hall-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Hall-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Library-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Hall") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Dining room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Conservatory-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Billiard room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Kitchen") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Conservatory") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Kitchen") {
        transformToken(token, room, 0, 0);
    }
}

function setMrsPeacock(room) {
    var token = id("mrsPeacockToken");
    if (room == "Peacock start") {
        transformToken(token, room, 0, 0);
    } else if (room == "Kitchen") {
        transformToken(token, room, 1, 2);
    } else if (room == "Ballroom") {
        transformToken(token, room, 1, 1);
    } else if (room == "Conservatory") {
        transformToken(token, room, 2, 3);
    } else if (room == "Dining room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room") {
        transformToken(token, room, 0, 1);
    } else if (room == "Library") {
        transformToken(token, room, 1, 2);
    } else if (room == "Lounge") {
        transformToken(token, room, 0, 4);
    } else if (room == "Hall") {
        transformToken(token, room, 1, 2);
    } else if (room == "Study") {
        transformToken(token, room, 1, 2);
    } else if (room == "Hall-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Hall-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Library-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Hall") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Dining room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Conservatory-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Billiard room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Kitchen") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Conservatory") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Kitchen") {
        transformToken(token, room, 0, 0);
    }
}

function setProfPlum(room) {
    var token = id("profPlumToken");
    if (room == "Plum start") {
        transformToken(token, room, 0, 0);
    } else if (room == "Kitchen") {
        transformToken(token, room, 2, 1);
    } else if (room == "Ballroom") {
        transformToken(token, room, 2, 1);
    } else if (room == "Conservatory") {
        transformToken(token, room, 2, 1);
    } else if (room == "Dining room") {
        transformToken(token, room, 0, 1);
    } else if (room == "Billiard room") {
        transformToken(token, room, 1, 1);
    } else if (room == "Library") {
        transformToken(token, room, 2, 1);
    } else if (room == "Lounge") {
        transformToken(token, room, 0, 1);
    } else if (room == "Hall") {
        transformToken(token, room, 2, 1);
    } else if (room == "Study") {
        transformToken(token, room, 2, 1);
    } else if (room == "Hall-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Hall-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Library-Study") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Hall") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Lounge") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Billiard room-Dining room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Conservatory-Library") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Billiard room") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room-Kitchen") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Conservatory") {
        transformToken(token, room, 0, 0);
    } else if (room == "Ballroom-Kitchen") {
        transformToken(token, room, 0, 0);
    }
}

function setCandlestick(room) {
    var token = id("candlestickToken");
    if (room == "Kitchen") {
        transformToken(token, room, 3, 2);
    } else if (room == "Ballroom") {
        transformToken(token, room, 3, 0);
    } else if (room == "Conservatory") {
        transformToken(token, room, 0, 0);
    } else if (room == "Dining room") {
        transformToken(token, room, 4, 0);
    } else if (room == "Billiard room") {
        transformToken(token, room, 4, 0);
    } else if (room == "Library") {
        transformToken(token, room, 2, 4);
    } else if (room == "Lounge") {
        transformToken(token, room, 3, 3);
    } else if (room == "Hall") {
        transformToken(token, room, 3, 2);
    } else if (room == "Study") {
        transformToken(token, room, 2, 4);
    }
}

function setKnife(room) {
    var token = id("knifeToken");
    if (room == "Kitchen") {
        transformToken(token, room, 4, 2);
    } else if (room == "Ballroom") {
        transformToken(token, room, 4, 2);
    } else if (room == "Conservatory") {
        transformToken(token, room, 4, 2);
    } else if (room == "Dining room") {
        transformToken(token, room, 4, 2);
    } else if (room == "Billiard room") {
        transformToken(token, room, 4, 2);
    } else if (room == "Library") {
        transformToken(token, room, 4, 2);
    } else if (room == "Lounge") {
        transformToken(token, room, 4, 2);
    } else if (room == "Hall") {
        transformToken(token, room, 4, 2);
    } else if (room == "Study") {
        transformToken(token, room, 4, 2);
    }
}

function setPipe(room) {
    var token = id("pipeToken");
    if (room == "Kitchen") {
        transformToken(token, room, 4, 4);
    } else if (room == "Ballroom") {
        transformToken(token, room, 4, 4);
    } else if (room == "Conservatory") {
        transformToken(token, room, 4, 1);
    } else if (room == "Dining room") {
        transformToken(token, room, 4, 3);
    } else if (room == "Billiard room") {
        transformToken(token, room, 4, 4);
    } else if (room == "Library") {
        transformToken(token, room, 3, 2);
    } else if (room == "Lounge") {
        transformToken(token, room, 4, 4);
    } else if (room == "Hall") {
        transformToken(token, room, 4, 3);
    } else if (room == "Study") {
        transformToken(token, room, 4, 1);
    }
}

function setRevolver(room) {
    var token = id("revolverToken");
    if (room == "Kitchen") {
        transformToken(token, room, 3, 1);
    } else if (room == "Ballroom") {
        transformToken(token, room, 2, 4);
    } else if (room == "Conservatory") {
        transformToken(token, room, 3, 1);
    } else if (room == "Dining room") {
        transformToken(token, room, 3, 0);
    } else if (room == "Billiard room") {
        transformToken(token, room, 3, 0);
    } else if (room == "Library") {
        transformToken(token, room, 4, 3);
    } else if (room == "Lounge") {
        transformToken(token, room, 3, 0);
    } else if (room == "Hall") {
        transformToken(token, room, 3, 1);
    } else if (room == "Study") {
        transformToken(token, room, 3, 1);
    }
}

function setRope(room) {
    var token = id("ropeToken");
    if (room == "Kitchen") {
        transformToken(token, room, 2, 3);
    } else if (room == "Ballroom") {
        transformToken(token, room, 2, 3);
    } else if (room == "Conservatory") {
        transformToken(token, room, 2, 4);
    } else if (room == "Dining room") {
        transformToken(token, room, 2, 3);
    } else if (room == "Billiard room") {
        transformToken(token, room, 2, 4);
    } else if (room == "Library") {
        transformToken(token, room, 3, 1);
    } else if (room == "Lounge") {
        transformToken(token, room, 2, 4);
    } else if (room == "Hall") {
        transformToken(token, room, 2, 3);
    } else if (room == "Study") {
        transformToken(token, room, 2, 3);
    }
}

function setWrench(room) {
    var token = id("wrenchToken");
    if (room == "Kitchen") {
        transformToken(token, room, 3, 3);
    } else if (room == "Ballroom") {
        transformToken(token, room, 3, 1);
    } else if (room == "Conservatory") {
        transformToken(token, room, 3, 3);
    } else if (room == "Dining room") {
        transformToken(token, room, 3, 3);
    } else if (room == "Billiard room") {
        transformToken(token, room, 3, 4);
    } else if (room == "Library") {
        transformToken(token, room, 3, 3);
    } else if (room == "Lounge") {
        transformToken(token, room, 3, 4);
    } else if (room == "Hall") {
        transformToken(token, room, 3, 3);
    } else if (room == "Study") {
        transformToken(token, room, 3, 3);
    }
}

function setBoard(board) {
    setMsScarlet(board["Ms. Scarlet"]);
    setColMustard(board["Col. Mustard"]);
    setMrsWhite(board["Mrs. White"]);
    setMrGreen(board["Mr. Green"]);
    setMrsPeacock(board["Mrs. Peacock"]);
    setProfPlum(board["Prof. Plum"]);
    setCandlestick(board["Candlestick"]);
    setKnife(board["Knife"]);
    setPipe(board["Pipe"]);
    setRevolver(board["Revolver"]);
    setRope(board["Rope"]);
    setWrench(board["Wrench"]);
}

function highlightCharacter(character) {
    var highlight = id("characterHighlight");
    if (character == "Ms. Scarlet") {
        highlight.style["transform"] = id("msScarletToken").style["transform"];
        highlight.className = "token-highlight";
    } else if (character == "Col. Mustard") {
        highlight.style["transform"] = id("colMustardToken").style["transform"];
        highlight.className = "token-highlight";
    } else if (character == "Mrs. White") {
        highlight.style["transform"] = id("mrsWhiteToken").style["transform"];
        highlight.className = "token-highlight";
    } else if (character == "Mr. Green") {
        highlight.style["transform"] = id("mrGreenToken").style["transform"];
        highlight.className = "token-highlight";
    } else if (character == "Mrs. Peacock") {
        highlight.style["transform"] = id("mrsPeacockToken").style["transform"];
        highlight.className = "token-highlight";
    } else if (character == "Prof. Plum") {
        highlight.style["transform"] = id("profPlumToken").style["transform"];
        highlight.className = "token-highlight";
    } else {
        highlight.className = "token-highlight hidden";
    }
}

function id(id) {
    return document.getElementById(id);
}

setBoard(startBoard);
//highlightCharacter("Col. Mustard");