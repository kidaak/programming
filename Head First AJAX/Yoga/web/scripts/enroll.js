/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = initPage;

function initPage() {
    addEventHandler(document.getElementById("firstname"), "blur", fieldIsFilled);
    addEventHandler(document.getElementById("firstname"), "blur", fieldIsLetters);
    addEventHandler(document.getElementById("lastname"), "blur", fieldIsFilled);
    addEventHandler(document.getElementById("lastname"), "blur", fieldIsLetters);
    addEventHandler(document.getElementById("email"), "blur", fieldIsFilled);
    addEventHandler(document.getElementById("email"), "blur", emailIsProper);
}

var warnings = {
    "firstname": {
        "required": "Please enter in your first name.",
        "letters": "Only letters are allowed in a first name.",
        "err": 0
    },
    "lastname": {
        "required": "Please enter in your last name.",
        "letters": "Only letters are allowed in a last name.",
        "err": 0
    },
    "email": {
        "required": "Please enter in your e-mail address.",
        "format": "Please enter your e-mail in the form 'name@domain.com'.",
        "err": 0
    }
};

function fieldIsFilled(e) {
    var target = getActivatedObject(e);
    if (target.value === "") {
        warn(target, "required");
    } else {
        unwarn(target, "required");
    }
}

function fieldIsLetters(e) {
    var me = getActivatedObject(e);
    var nonAlphaChars = /[^a-zA-Z]/;
    if (nonAlphaChars.test(me.value)) {
        warn(me, "letters");
    } else {
        unwarn(me, "letters");
    }
}

function emailIsProper(e) {
    var me = getActivatedObject(e);
    if (!/^[\w\.-_\+]+@[\w-]+(\.\w{2,4})+$/.test(me.value)) {
        warn(me, "format");
    } else {
        unwarn(me, "format");
    }
}

function warn(field, warningType) {
    var parentNode = field.parentNode;
    var warning = eval('warnings.' + field.id + '.' + warningType);
    if (parentNode.getElementsByTagName('p').length === 0) {
        var p = document.createElement('p');
        field.parentNode.appendChild(p);
        var warningNode = document.createTextNode(warning);
        p.appendChild(warningNode);
    } else {
        var p = parentNode.getElementsByTagName('p')[0];
        p.childNodes[0].nodeValue = warning;
    }
    document.getElementById("enroll").disabled = true;
}

function unwarn(field, warningType) {
    if (field.parentNode.getElementsByTagName("p").length > 0) {
        var p = field.parentNode.getElementsByTagName("p")[0];
        var currentWarning = p.childNodes[0].nodeValue;
        var warning = eval('warnings.' + field.id + '.' + warningType);
        if (currentWarning === warning) {
            field.parentNode.removeChild(p);
        }
    }
    var fieldsets =
            document.getElementById("content").getElementsByTagName("fieldset");
    for (var i = 0; i < fieldsets.length; i++) {
        var fieldWarnings = fieldsets[i].getElementsByTagName("p").length;
        if (fieldWarnings > 0) {
            document.getElementById("enroll").disabled = true;
            return;
        }
    }
    document.getElementById("enroll").disabled = false;
}

