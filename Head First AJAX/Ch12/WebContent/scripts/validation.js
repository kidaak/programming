/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = initPage;
var usernameValid = false;
var passwordValid = false;
function initPage() {
    document.getElementById("username").onblur = checkUsername;
    document.getElementById("register").disabled = true;
    document.getElementById("password2").onblur = checkPassword;
    document.getElementById("register").onclick = registerUser;
}

function checkUsername() {
    userNameRequest = createRequest();
    if (userNameRequest === null) {
        alert("Unable to create request");
    } else {
        document.getElementById("username").className = "thinking";
        var theName = document.getElementById("username").value;
        var username = escape(theName);
        var url = "checkName";
        var requestData = "username=" + username;
        userNameRequest.onreadystatechange = showUsernameStatus;
        userNameRequest.open("POST", url, true);
        userNameRequest.setRequestHeader("Content-Type",
                "application/x-www-form-urlencoded");
        userNameRequest.send(requestData);
    }
}

function checkPassword() {
    var password1 = document.getElementById("password1");
    var password2 = document.getElementById("password2");
    password1.className = "thinking";

    //First compare the two password
    if (password1.value === "" || password1.value !== password2.value) {
        password1.className = "denied";
        return;
    }

    //Password match, so send request to server
    passwordRequest = createRequest();
    if (passwordRequest === null) {
        alert('Unable to create request');
    } else {
        var password = escape(password1.value);
        var url = "checkPass";
        var requestData = "password=" + password;
        passwordRequest.onreadystatechange = showPasswordStatus;
        passwordRequest.open("POST", url, true);
        passwordRequest.setRequestHeader("Content-Type",
                "application/x-www-form-urlencoded");
        passwordRequest.send(requestData);
    }
}

function showUsernameStatus() {
    if (userNameRequest.readyState === 4)
        if (userNameRequest.status === 200) {
            if (userNameRequest.responseText === "okay") {
                document.getElementById("username").className = "approved";
                usernameValid = true;
            } else {
                document.getElementById("username").className = "denied";
                document.getElementById("username").focus();
                document.getElementById("username").select();
                usernameValid = false;
            }
            checkFormStatus();
        }
}

function showPasswordStatus() {
    if (passwordRequest.readyState === 4)
        if (passwordRequest.status === 200) {
            var password1 = document.getElementById("password1");
            if (passwordRequest.responseText === "okay") {
                password1.className = "approved";
                passwordValid = true;
            } else {
                password1.focus();
                password1.select();
                document.getElementById("register").disabled = true;
                passwordValid = false;
            }
            checkFormStatus();
        }
}

function checkFormStatus() {
    if (usernameValid && passwordValid) {
        document.getElementById("register").disabled = false;
    } else {
        document.getElementById("register").disabled = true;
    }
}

function registerUser() {
    t = setInterval("scrollImages()", 50);
    document.getElementById("register").value = "Processing...";
    registerRequest = createRequest();
    if (registerRequest === null) {
        alert("Unable to create request.");
    } else {
        var url = "register-feedback.php";
        var requestData = "username=" +
                escape(document.getElementById("username").value) + "&password=" +
                escape(document.getElementById("password1").value) + "&firstname=" +
                escape(document.getElementById("firstname").value) + "&lastname=" +
                escape(document.getElementById("lastname").value) + "&email=" +
                escape(document.getElementById("email").value) + "&genre=" +
                escape(document.getElementById("genre").value) + "&favorite=" +
                escape(document.getElementById("favorite").value) + "&tastes=" +
                escape(document.getElementById("tastes").value);
        registerRequest.onreadystatechange = registrationProcessed;
        registerRequest.open("POST", url, true);
        registerRequest.setRequestHeader("Content-Type",
                "application/x-www-form-urlencoded");
        registerRequest.send(requestData);
    }
}

function registrationProcessed() {
    if (registerRequest.readyState === 4) {
        if (registerRequest.status === 200) {
            document.getElementById('wrapper').innerHTML =
                    registerRequest.responseText;
        }
    }
}

function scrollImages() {
    var coverBarDiv = document.getElementById("coverBar");
    var images = coverBarDiv.getElementsByTagName("img");
    for (var i = 0; i < images.length; i++) {
        var left = images[i].style.left.substr(0, images[i].style.left.length - 2);
        if (left <= -86) {
            left = 532;
        }
        images[i].style.left = (left - 1) + "px";
    }
}
