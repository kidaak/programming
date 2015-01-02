/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function createRequest() {
    try {
        request = new XMLHttpRequest();
    } catch (tryMS) {
        try {
            request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (otherMS) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                request = null;
            }
        }
    }

    return request;
}

function addEventHandler(obj, eventName, handler) {
    if (document.attachEvent) {
        obj.attachEvent("on" + eventName, handler);
    } else {
        obj.addEventListener(eventName, handler, false);
    }
}

function getActivatedObject(e) {
    var obj;
    if (!e) {
        //early version of IE
        obj = window.event.srcElement;
    } else if (e.srcElement) {
        //IE 7 or later
        obj = e.srcElement;
    } else {
        //DOM Level 2 browser
        obj = e.target;
    }
    return obj;
}

function capitaliseFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

function isValidURL(string) {
    var regexp = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
    return regexp.test(string);
}

