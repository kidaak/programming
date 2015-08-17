/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = initPage;
var frequencyTable = new Array(
        "a", "a", "a", "a", "a", "a", "a", "a", "b", "c", "c", "c", "d", "d", "d",
        "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "f", "f", "g",
        "g", "h", "h", "h", "h", "h", "h", "i", "i", "i", "i", "i", "i", "i", "j",
        "k", "l", "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o",
        "o", "o", "o", "o", "o", "o", "p", "p", "q", "q", "q", "q", "q", "q", "r",
        "r", "r", "r", "r", "r", "s", "s", "s", "s", "s", "s", "s", "s", "t", "t",
        "t", "u", "u", "v", "v", "w", "x", "y", "z");

function initPage() {
    randomizeTiles();
}

function randomizeTiles() {
    var letterbox = document.getElementById("letterbox");
    var tiles = letterbox.getElementsByTagName("a");
    var className;
    for (var i = 0; i < tiles.length; i++) {
        className = tiles[i].className;
        className += (" l" + frequencyTable[Math.floor(Math.random() * 100)]);
        tiles[i].className = className;
        tiles[i].onclick = addLetter;
    }
}

function enalbleAllTiles() {
    var letterbox = document.getElementById("letterbox");
    var tiles = letterbox.getElementsByTagName("a");
    var className;
    for (var i = 0; i < tiles.length; i++) {
        className = tiles[i].className;
        tiles[i].className = className.replace("disabled", "");
        tiles[i].onclick = addLetter;
    }
    
    var submitbutton = document.getElementById("submit").firstElementChild;
    submitbutton.onclick = "";
    submitbutton.className = "disabled";
}

function addLetter() {
    var tileClass = this.className;
    var letter = tileClass.charAt(10);

    var currentWord = document.getElementById("currentWord");
    var p = currentWord.firstElementChild;
    if (!p) {
        p = document.createElement("p");
        var letterText = document.createTextNode("");
        p.appendChild(letterText);
        currentWord.appendChild(p);
    }
    var textNode = p.firstChild;
    textNode.nodeValue += letter;
    this.className += " disabled";
    this.onclick = "";

    var submitbutton = document.getElementById("submit").firstElementChild;
    submitbutton.onclick = submitWord;
    submitbutton.className = "";
}

function submitWord() {
    request = createRequest();
    if (request === null) {
        alert("Unable to create a request");
        return;
    }
    var word = document.getElementById("currentWord").firstElementChild.firstChild.nodeValue;
    var url = "lookupword?word=" + escape(word);
    request.open("GET", url, false);
    request.send(null);

    var addedScore = addScore();
    displayResult(addedScore, word);
    enalbleAllTiles();
}

function addScore() {
    var addedScore = parseInt(request.responseText);
    var scoreDiv = document.getElementById("score");
    var score = parseInt(scoreDiv.firstChild.nodeValue.substring(7));
    score += addedScore;
    scoreDiv.firstChild.nodeValue = "Score: " + score;
    return addedScore;
}

function displayResult(addedScore, word) {
    if (addedScore > 0) {
        var wordListDiv = document.getElementById("wordList");
        var p = document.createElement("p");
        var textNode = document.createTextNode(escape(word));
        p.appendChild(textNode);
        wordListDiv.appendChild(p);
    } else {
        alert("You have entered an invalid word. Try again!");
    }

    document.getElementById("currentWord").firstElementChild.firstChild.nodeValue = "";
}


