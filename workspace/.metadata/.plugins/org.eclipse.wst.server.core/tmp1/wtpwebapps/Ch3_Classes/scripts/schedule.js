/**
 * 
 */

welcomPaneShowing = true;
window.onload = initPage;
function initPage() {
	var image = document.getElementById("schedulePane").getElementsByTagName(
			"img");
	for (var i = 0; i < image.length; i++) {
		var currentImage = image[i];
		currentImage.onmouseover = showHint;
		currentImage.onmouseout = hideHint;
		currentImage.onclick = showTab;
	}
};

function showHint() {
	if (!welcomPaneShowing) {
		return;
	}
	switch (this.title) {
	case "beginners":
		var hintText = "Just getting started? Come join us!";
		break;
	case "intermediate":
		var hintText = "Take your flexibility to the next level!"
		break;
	case "advanced":
		var hintText = "Perfectly join your body and mind with these intensive workout!";
		break;
	default:
		var hintText = "Click a tab to display the course schedule for the class!";
		break;
	}

	var contentPane = document.getElementById("content");
	contentPane.innerHTML = "<h3>" + hintText + "</h3>";
};

function hideHint() {
	if (welcomPaneShowing) {
		var contentPane = document.getElementById("content");
		contentPane.innerHTML = "<h3>Click a tab to display the course schedule for the class!</h3>";
	}
};

function showTab() {
	var selectedTab = this.title;
	var images = document.getElementById("tabs").getElementsByTagName("img");
	for (var i = 0; i < images.length; i++) {
		var currentImage = images[i];
		if (currentImage.title == selectedTab) {
			currentImage.src = "images/" + selectedTab + "TabActive.png";
		} else {
			currentImage.src = "images/" + selectedTab + "TabInactive.png";
		}
	}
};