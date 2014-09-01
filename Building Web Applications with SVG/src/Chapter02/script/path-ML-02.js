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

      // Add Cool Labels
      helper.addCooLabel(70,290,-15,15);
      helper.addCooLabel(150,150,15,-15);
      helper.addCooLabel(200,250,15,15);
      helper.addCooLabel(40,250,-12,15);
      helper.addCooLabel(100,150,-12,-15);
      helper.addCooLabel(170,290,12,15);
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