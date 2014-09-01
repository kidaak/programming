// Helper script for SVG examples.
// To Do:  Implement as an anonymous or named function expression to prevent polution of the global space.

var nsSvg="http://www.w3.org/2000/svg",
  nsXlink="http://www.w3.org/1999/xlink",
  root,
  doc,
  grid,
  nodeShape = "circle",
  nodeR = 5.5,
  units = "px",
  nodeFill = "white",
  nodeStroke = "darkslategray",
  filesAdded = ""; //list of files loaded dynamically

function startup(evt){
	root=document.documentElement;
  grid = document.getElementById("grid");
  var text;
  
  // Draw grid
	drawlines(100,10,0,0);
}


// Load external files dynamically
function loadScriptFile(fileName, fileType){
  if (fileType=="js" || fileType=="es")
  {
    var scriptElement = document.createElementNS(nsSvg, "script");
    scriptElement.setAttributeNS(null, "type", "application/ecmascript");
    scriptElement.setAttributeNS(nsXlink, "xlink:href", fileName);
  }
  if (typeof scriptElement!="undefined")
  {
    document.documentElement.appendChild(scriptElement); 
  }
  //return scriptElement;
}

function checkLoadScriptFile(fileName, fileType){
  if (filesAdded.indexOf("[" +fileName+ "]")==-1)
  {
    loadScriptFile(fileName, fileType);
    filesAdded += "["+fileName+"]";
  }
  else {alert("File already added!");}
}

// Load script dependencies
checkLoadScriptFile("script/helper.js", "js"); //success