/**
 * 
 */

welcomPaneShowing = true;
window.onload = initPage;
function initPage() {
    var tabs = document.getElementById("tabs").getElementsByTagName(
            "a");
    for (var i = 0; i < tabs.length; i++) {
        var currentTab = tabs[i];
        addEventHandler(currentTab, "mouseover", showHint);
        addEventHandler(currentTab, "mouseout", hideHint, false);
        addEventHandler(currentTab, "click", showTab, false);
    }

    var buttons = document.getElementById("navigation").getElementsByTagName("a");
    for (var i = 0; i < buttons.length; i++) {
        var currentBtn = buttons[i];
        addEventHandler(currentBtn, "mouseover", showHint);
        addEventHandler(currentBtn, "mouseout", hideHint);
        addEventHandler(currentBtn, "click", showTab);
        addEventHandler(currentBtn, "mouseover", buttonOver);
        addEventHandler(currentBtn, "mouseout", buttonOut);
    }
}

function showHint(e) {
    if (!welcomPaneShowing) {
        return;
    }
    switch (getActivatedObject(e).title) {
        case "beginners":
            var hintText = "Just getting started? Come join us!";
            break;
        case "intermediate":
            var hintText = "Take your flexibility to the next level!";
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
}

function hideHint(e) {
    if (welcomPaneShowing) {
        var contentPane = document.getElementById("content");
        contentPane.innerHTML = "<h3>Click a tab to display the course schedule for the class!</h3>";
    }
}
;

function showTab(e) {
    var selectedTab = getActivatedObject(e).title;

    if (selectedTab === "welcom") {
        welcomPaneShowing = true;
        document.getElementById("content").innerHTML = "<h3>Click a tab to display the course schedule for the class!</h3>";
    } else {
        welcomPaneShowing = false;
    }

    var tabs = document.getElementById("tabs").getElementsByTagName("a");
    for (var i = 0; i < tabs.length; i++) {
        var currentTab = tabs[i];
        if (currentTab.title === selectedTab) {
            currentTab.className = "active";
        } else {
            currentTab.className = "inactive";
        }
    }

    var request = createRequest();
    if (request === null) {
        alert("Unable to create request");
        return;
    }
    request.onreadystatechange = showSchedule;
    request.open("GET", selectedTab + ".html", true);
    request.send(null);
}

function showSchedule(e) {
    if (request.readyState === 4)
        if (request.status === 200) {
            document.getElementById("content").innerHTML = request.responseText;
        }
}

function buttonOver(e) {
    getActivatedObject(e).className = "active";
}

function buttonOut(e) {
    getActivatedObject(e).className = "";
}