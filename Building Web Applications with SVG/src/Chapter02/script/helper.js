/**
 * Helper application for SVG book examples.
 *
 * @module helper
 */
(function(){helper = {};
  // Declare and set the document and shape-related variables.
  var count = 0, 
    root = document.documentElement,
    grid = document.getElementById("grid"),
    nodeShape = "circle",
    nodeR = 5.5,
    units = "px",
    nodeFill = "white",
    nodeStroke = "darkslategray",
    svgns = "http://www.w3.org/2000/svg",
    xmlns = "http://www.w3.org/2000/xmlns/",
    xlinkns = "http://www.w3.org/1999/xlink";

  helper.addCooLabel = function (x, y, ox, oy, labelText, labelColor, fontSize){
    var fontWeight = "bold";
    
    // Add node
    root.appendChild(helper.createSVGElement(nodeShape, {cx:x+units, cy:y+units, r:nodeR+units, fill:nodeFill, stroke:nodeStroke, "stroke-width":1+units}));
    
    // Add line between node and text label.
    var line = helper.createSVGElement("line", {x1:x+units, x2:(x+ox)+units, y1:(y+nodeR)+units, y2:(y+oy)+units, stroke:"darkred", "stroke-width":2+units, "stroke-opacity":0.5});
    root.appendChild(line);
    
    // Add text label
    if (labelText==null) {labelText = x+","+y; fontWeight = "normal";}
    if (fontSize==null) {fontSize = 15;}
    
    if (oy>0) {y = y+oy+10;}
    else {y = y+oy-4;}
    
    if (labelColor==null) {labelColor = "black";}

    var text = helper.createSVGElement("text", {x:x+ox-labelText.length*2, y:(y+nodeR)+units, fill:labelColor, "font-size":fontSize+units, "font-family":"Tahoma,serif", "font-weight":fontWeight, "text-anchor":"begin"});
    text.appendChild(document.createTextNode(labelText));
    root.appendChild(text);
  };

  helper.drawlines = function (u, t){
    var B = root.getBBox(),
      w = B.width,
      h = B.height,
      line,
      i = 0,
      j = 0;

    for (; i<=w/t; i+=1){
      // Add line between node and text label.
      line = helper.createSVGElement("line", {x1:(i*t)+units, x2:(i*t)+units, y1:0+units, y2:8+units, stroke:"gray", "stroke-width":1+units});
      root.insertBefore(line,grid)
      if (i%10==0){
        line = helper.createSVGElement("line", {x1:(i*t)+units, x2:(i*t)+units, y1:0+units, y2:h+units, stroke:"gray", "stroke-width":1+units, "stroke-opacity":0.5});
        root.insertBefore(line,grid);
      }
    }
    
    for (; j<=h/t; j+=1){
      line = helper.createSVGElement("line", {x1:0+units, x2:8+units, y1:(j*t)+units, y2:(j*t)+units, stroke:"gray", "stroke-width":1+units});
      root.insertBefore(line,grid)
      if (j%10==0){
        line = helper.createSVGElement("line", {x1:0+units, x2:w+units, y1:(j*t)+units, y2:(j*t)+units, stroke:"gray", "stroke-width":1+units, "stroke-opacity":0.5});
        root.insertBefore(line,grid);
      }
    }
  };

  helper.createSVGElement = function (tagName, attributeList){
    var svgElement = document.createElementNS(svgns, tagName);
    if (attributeList!=undefined)
    for (var attribute in attributeList){
      var value = attributeList[attribute];
      //switch(attribute) {
        //default : svgElement.setAttributeNS((attribute == "xlink:href") ? xlinkns : null, attribute, value);
      //}
      svgElement.setAttributeNS((attribute == "xlink:href") ? xlinkns : null, attribute, value);
    }
    return svgElement;
  };

  helper.appendChildToRoot = function (node){
    root.appendChild(node);
  }
  
  // Support logging to the console using HTML textarea as fallback as 
  // this feature is not built into older browsers.
  helper.logToConsole = function (){
    // If a native console is unavailable then implement via script and visual textarea.
    if (typeof(console) == 'undefined' || console == null){
      var T=document.createElement("textarea")
      T.setAttribute("rows",8)
      T.setAttribute("cols",78)
      document.body.appendChild(T)
      console={
        log:function(){
          var i
          //T.value+="typeof this is "+typeof(this)+"\n"
          for (i in arguments) T.value+=arguments[i]+"\n"
        }
      }
    }
    else console.log(typeof(console))

    var man={hands:2,legs:2,head:1}
    var s=""

    for (i in man){
      if (man.hasOwnProperty(i)) {
        s+=i+":"+man[i]+","
      }
    }
    console.log(s)
  },

  // Utility function to support testing of arrays in all browsers.
  helper.testIsArray = function (a){
    if (typeof Array.isArray === "undefined"){
      Array.isArray=function (arg) {
        return arg+" is an array? "+(Object.prototype.toString.call(arg)=== "[object Array]")
      }
    }
    console.log(Array.isArray(a))
  };
  
  helper.isLoaded = function(){
    alert('in helper.utils');
  };
})();

//helper.utils.isLoaded();