<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clue Game</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<script src="../js/game.js"></script>
<script>
    function chooseCharacter()
    {
        var characterList = document.getElementById("characterList");
        document.getElementById("character").value=characterList.options[characterList.selectedIndex].text;
    }
</script>
<script>
    function chooseRoom()
    {
        var roomList = document.getElementById("roomList");
        document.getElementById("room").value=roomList.options[roomList.selectedIndex].text;
    }
</script>
<form>
    Select your Character:
    <select id="characterList" onchange="chooseCharacter()">
        <option></option>
        <option>Professor Plum</option>
        <option>Miss Scarlet</option>
        <option>Colonel Mustard</option>
        <option>Mrs. Peacock</option>
        <option>Mr. Green</option>
        <option>Mrs. White</option>
    </select>
    <p>Your character is: <input type="text" id="character" size="20"></p>
</form>
<form>
    Select a room to move to:
    <select id="roomList" onchange="chooseRoom()">
        <option></option>
        <option>Study</option>
        <option>Hall</option>
        <option>Lounge</option>
        <option>Library</option>
        <option>Billiard Room</option>
        <option>Dining Room</option>
        <option>Conservatory</option>
        <option>BallRoom</option>
        <option>Kitchen</option>
    </select>
    <p>Move to room: <input type="text" id="room" size="20"></p>
</form>
<button id="endTurn">End Turn</button>
</body>
</html>