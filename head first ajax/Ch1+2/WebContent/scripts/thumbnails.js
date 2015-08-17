/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = initPage;
function initPage() {
    //find the thumbnails on the page
    thumbs = document.getElementById('thumbnailPane').getElementsByTagName('img');
    //set the handler for each image
    for (var i = 0; i < thumbs.length; i++) {
        image = thumbs[i];
        //create the onclick function
        image.onclick = function () {
            //find the full-size image name
            detailURL = 'images/' + this.title + '-detail.jpg';
            document.getElementById("itemDetail").src = detailURL;
            getDetails(this.title);
        };
    }
}

function getDetails(itemName) {
    request = createRequest();
    if (request === null) {
        alert("Unable to create request");
        return;
    }

    var url = "getDetails?ImageId=" + escape(itemName);
    request.open("GET", url, true);
    request.onreadystatechange = displayDetails;
    request.send(null);
}

function displayDetails() {
    if (request.readyState === 4) {
        if (request.status === 200) {
            detailDiv = document.getElementById("description");
            detailDiv.innerHTML = request.responseText;
        }
    }
}


