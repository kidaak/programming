/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = initPage;

function initPage() {
    var table = document.getElementById("puzzleGrid");
    var cells = table.getElementsByTagName("td");
    for (var i = 0; i < cells.length; i++) {
        cells[i].onclick = tileClick;
    }
}

function tileClick() {
    if (cellIsEmpty(this)) {
        alert("Please click on a numbered tile.");
        return;
    } else {
        var cellId = this.getAttribute("id");
        var currentRow = cellId.charAt("4");
        var currentCol = cellId.charAt("5");

        if (currentRow > 1) {
            var testRow = Number(currentRow) - 1;
            var testCell = document.getElementById("cell" + testRow + currentCol);
            if (cellIsEmpty(testCell)) {
                swapTiles(this, testCell);
                return;
            }
        }

        if (currentRow < 4) {
            var testRow = Number(currentRow) + 1;
            var testCell = document.getElementById("cell" + testRow + currentCol);
            if (cellIsEmpty(testCell)) {
                swapTiles(this, testCell);
                return;
            }
        }

        if (currentCol > 1) {
            var testCol = Number(currentCol) - 1;
            var testCell = document.getElementById("cell" + currentRow + testCol);
            if (cellIsEmpty(testCell)) {
                swapTiles(this, testCell);
                return;
            }
        }

        if (currentCol < 4) {
            var testCol = Number(currentCol) + 1;
            var testCell = document.getElementById("cell" + currentRow + testCol);
            if (cellIsEmpty(testCell)) {
                swapTiles(this, testCell);
                return;
            }
        }
    }
}

function swapTiles(selectedCell, destinationCell) {
    selectedImage = selectedCell.firstElementChild;
    destinationImage = destinationCell.firstElementChild;
    selectedCell.appendChild(destinationImage);
    destinationCell.appendChild(selectedImage);
    
    if(puzzleIsComplete()){
        document.getElementById("puzzleGrid").className = "win";
    }
}

function cellIsEmpty(cell) {
    var image = cell.firstElementChild;
    if (image.alt === "empty") {
        return true;
    } else {
        return false;
    }
}

function puzzleIsComplete() {
    var tiles = document.getElementById("puzzleGrid").getElementsByTagName("img");
    var tileOrder = "";
    for (var i = 0; i < tiles.length; i++) {
        var num = tiles[i].src.substr(-6, 2);
        if (num !== "ty") {
            tileOrder += num;
        }
    }
    if (tileOrder === "010203040506070809101112131415")
        return true;
    return false;
}

