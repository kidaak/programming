var c = getCanvas();
c.width = 400;
c.height = 400;
var ctx = c.getContext("2d");

function doIt(){
	var imageData = ctx.getImageData(0,0,400,400);
	var length = imageData.data.length / 4;
	for (var i = 0; i < length; i++){
		imageData.data[i * 4 + 0] = 255 - imageData.data[i * 4 + 0];
		imageData.data[i * 4 + 1] = 255 - imageData.data[i * 4 + 1];
		imageData.data[i * 4 + 2] = 255 - imageData.data[i * 4 + 2];
	}
	ctx.putImageData(imageData, 0, 0);
}

var image = new Image();
image.onload = function(){
	ctx.drawImage(image, 0, 0);
	doIt();
}
image.src = "img_the_scream.jpg";

function getCanvas(){
	var c = document.getElementById("c");
	return c;
}
