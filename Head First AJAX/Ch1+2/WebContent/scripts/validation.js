/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = initPage;
function initPage() {
    document.getElementById("username").onblur = checkUsername;
    document.getElementById("register").disabled = true;
}

function checkUsername() {
    request = createRequest();
    if (request === null) {
        alert("Unable to create request");
    } else {
        document.getElementById("username").className = "thinking";
        var theName = document.getElementById("username").value;
        var username = escape(theName);
        var url = "checkName?username=" + username;
        request.onreadystatechange = showUsernameStatus;
        request.open("GET", url, true);
        request.send(null);
    }
}

function showUsernameStatus() {
    if (request.readyState === 4)
        if (request.status === 200)
            if (request.responseText === "okay") {
                console.log(request.responseText);
                document.getElementById("username").className = "approved";
                document.getElementById("register").disabled = false;
            } else {
                console.log(request.responseText);
                document.getElementById("username").className = "denied";
                document.getElementById("username").focus();
                document.getElementById("username").select();
                document.getElementById("register").disabled = true;
            }
}

