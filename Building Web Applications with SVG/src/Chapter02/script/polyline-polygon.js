// Helper script for SVG examples.
var svgns="http://www.w3.org/2000/svg";
var xlinkns="http://www.w3.org/1999/xlink";
var filesAdded = ""; //list of files 

// Once the SVG document is loaded, then use the helper library 
// to dynamically add the helper decorations to the code.
window.onload = function() {
  
  (function(){helper.example = {};

    helper.example.startup = function (evt) {
      var nodeShape = "circle",
        nodeR = 5.5,
        nodeFill = "white",
        nodeStroke = "darkslategray";
        
      // Draw grid
      helper.drawlines(100,10,0,0);

      // Add Text
      var textNode = helper.createSVGElement("text", {x:190, y:30, fill:"darkgreen", "font-size":13.5, 
        "font-family":"Tahoma,serif", "font-weight":"bold", "text-anchor":"begin"});
      textNode.appendChild(document.createTextNode("points='200,60 240,230 310,230 350,60'"));
      helper.appendChildToRoot(textNode);
      textNode = helper.createSVGElement("text", {x:15, y:30, fill:"darkgreen", "font-size":13.5, 
        "font-family":"Tahoma,serif", "font-weight":"bold", "text-anchor":"begin"});
      textNode.appendChild(document.createTextNode("points='100,50 115, ...'"));
      helper.appendChildToRoot(textNode);
      textNode = helper.createSVGElement("text", {x:20, y:290, fill:"darkgreen", "font-size":13.5, 
        "font-family":"Tahoma,serif", "font-weight":"bold", "text-anchor":"begin"});
      textNode.appendChild(document.createTextNode("Required Attributes"));
      helper.appendChildToRoot(textNode);

      // Add nodes or simple shapes
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:100, cy:50, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:150, cy:150, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:115, cy:120, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:115, cy:180, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:100, cy:250, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:85, cy:180, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:50, cy:150, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:50, cy:150, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:85, cy:120, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:200, cy:60, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:240, cy:230, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:310, cy:230, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
      helper.appendChildToRoot(helper.createSVGElement(nodeShape, {cx:350, cy:60, r:nodeR, fill:nodeFill, stroke:nodeStroke}));
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