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

    var url = "GetDetailsXML_Update?ImageId=" + escape(itemName);
    request.open("GET", url, true);
    request.onreadystatechange = displayDetailsXML_Update;
    request.send(null);
}

function displayDetails() {
    if (request.readyState === 4) {
        if (request.status === 200) {
            detailDiv = document.getElementById("description");

            for (var i = detailDiv.childNodes.length; i > 0; i--) {
                detailDiv.removeChild(detailDiv.childNodes[i - 1]);
            }

            var response = request.responseText;
            var itemDetails = response.split(",");
            var descriptionP = document.createElement("p");
            descriptionP.appendChild(document.createTextNode("Description: " + itemDetails[1]));
            detailDiv.appendChild(descriptionP);
            var priceP = document.createElement("p");
            priceP.appendChild(document.createTextNode("Price: $" + itemDetails[2]));
            detailDiv.appendChild(priceP);
            var list = document.createElement("ul");
            for (var i = 3; i < itemDetails.length; i++) {
                var li = document.createElement("li");
                var a = document.createElement("a");
                a.setAttribute("href", itemDetails[i]);
                a.appendChild(document.createTextNode(itemDetails[i]));
                li.appendChild(a);
                list.appendChild(li);
            }
            detailDiv.appendChild(list);
        }
    }
}

function displayDetailsXML(){
    if(request.readyState === 4)
        if(request.status === 200){
            var detailDiv = document.getElementById("description");
            
            for(var i = detailDiv.childNodes.length; i >0; i--){
                detailDiv.removeChild(detailDiv.childNodes[i-1]);
            }
            
            var responseDoc = request.responseXML;
            
            var description = responseDoc.getElementsByTagName("description")[0];
            var descriptionText = description.firstChild.nodeValue;
            var descriptionP = document.createElement("p");
            descriptionP.appendChild(document.createTextNode("Description: " + descriptionText));
            detailDiv.appendChild(descriptionP);
            
            var price = responseDoc.getElementsByTagName("price")[0];
            var priceText = price.firstChild.nodeValue;
            var priceP = document.createElement("p");
            priceP.appendChild(document.createTextNode("Price: " + priceText));
            detailDiv.appendChild(priceP);
            
            var list = document.createElement("ul");
            var urlElements = responseDoc.getElementsByTagName("url");
            for(var i = 0; i < urlElements.length; i++){
                var url = urlElements[i].firstChild.nodeValue;
                var li = document.createElement("li");
                var a = document.createElement("a");
                a.setAttribute("href", url);
                a.appendChild(document.createTextNode(url));
                li.appendChild(a);
                list.appendChild(li);
            }
            detailDiv.appendChild(list);
        }
}

function displayDetailsXML_Update(){
    if(request.readyState === 4)
        if(request.status === 200){
            var detailDiv = document.getElementById("description");
            
            for(var i = detailDiv.childNodes.length; i >0; i--){
                detailDiv.removeChild(detailDiv.childNodes[i-1]);
            }
            
            var responseDoc = request.responseXML;
            var categories = responseDoc.getElementsByTagName("category");
            for(var i = 0; i < categories.length; i++){
                var category = categories[i];
                var nameElement = category.getElementsByTagName("name")[0];
                var categoryName = nameElement.firstChild.nodeValue;
                var categoryType = category.getAttribute("type");
                if((categoryType === null) || (categoryType !== "list")){
                    var valueElement = category.getElementsByTagName("value")[0];
                    var categoryValue = valueElement.firstChild.nodeValue;
                    var p = document.createElement("p");
                    var text = document.createTextNode(categoryName + ": " + categoryValue);
                    p.appendChild(text);
                    detailDiv.appendChild(p);
                }else{
                    var p = document.createElement("p");
                    p.appendChild(document.createTextNode(categoryName));
                    var list = document.createElement("ul");
                    var values = category.getElementsByTagName("value");
                    for(var j = 0; j < values.length; j++){
                        var li = document.createElement("li");
                        li.appendChild(document.createTextNode(values[j].firstChild.nodeValue));
                        list.appendChild(li);
                    }
                    detailDiv.appendChild(p);
                    detailDiv.appendChild(list);
                }
            }
        }
}


