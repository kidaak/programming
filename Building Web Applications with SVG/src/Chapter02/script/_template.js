// Helper script for SVG examples.
var svgns="http://www.w3.org/2000/svg";
var xlinkns="http://www.w3.org/1999/xlink";
var filesAdded = ""; //list of files 

// Once the SVG document is loaded, then use the helper library 
// to dynamically add the helper decorations to the code.
window.onload = function() {
  
  (function(){helper.example = {};

    helper.example.startup = function (evt) {
      // Draw grid
      helper.drawlines(100,10,0,0);

      // Add Text
      var textNode = helper.createSVGElement("text", {x:50, y:290, fill:"darkgreen", "font-size":15, 
        "font-family":"Tahoma,serif", "font-weight":"bold", "text-anchor":"begin"});
      textNode.appendChild(document.createTextNode("Required Attributes"));
      helper.appendChildToRoot(textNode);
      textNode = helper.createSVGElement("text", {x:50, y:310, fill:"chocolate", "font-size":15, 
        "font-family":"Tahoma,serif", "font-weight":"bold", "text-anchor":"begin"});
      textNode.appendChild(document.createTextNode("Optional Attributes"));
      helper.appendChildToRoot(textNode);
      textNode = helper.createSVGElement("text", {x:190, y:135, fill:"darkgreen", "font-size":15, 
        "font-family":"Tahoma,serif", "font-weight":"bold", "text-anchor":"begin"});
      textNode.appendChild(document.createTextNode("r"));
      helper.appendChildToRoot(textNode);

      // Add Cool Labels
      helper.addCooLabel(150,150,0,5.5,"(cx,cy)","chocolate",15);
      helper.addCooLabel(150,0,5,15);
      helper.addCooLabel(0,150,12,15);  
    };
  })();
  // Load the example.
  helper.example.startup();
}

// Load external files dynamically
function loadScriptFile (fileName, fileType){
  if (fileType=="js" || fileType=="es")
  {
    var scriptElement = document.createElementNS(svgns, "script");
    scriptElement.setAttributeNS(null, "type", "application/ecmascript");
    scriptElement.setAttributeNS(xlinkns, "xlink:href", fileName);
  }
  if (typeof scriptElement!="undefined")
  {
    document.documentElement.appendChild(scriptElement); 
  }
}

function checkLoadScriptFileAndInitialize (fileName, fileType){
  if (filesAdded.indexOf("[" +fileName+ "]")==-1)
  {
    loadScriptFile(fileName, fileType);
    filesAdded += "["+fileName+"]";
  }
  else {alert("File already added!");}
}

function checkLoadScriptFile (fileName, fileType){
  if (filesAdded.indexOf("[" +fileName+ "]")==-1)
  {
    loadScriptFile(fileName, fileType);
    filesAdded += "["+fileName+"]";
  }
  else {alert("File already added!");}
}

// First load the script dependencies
checkLoadScriptFile("script/helper.js", "js"); //success