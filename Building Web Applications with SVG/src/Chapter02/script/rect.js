// Helper script for SVG examples, implemented as a function expression 
// to help keep the global space clean.

var xmlns="http://www.w3.org/2000/svg",
  Root,
  Doc,
  Grid,
  Col=new Array("red","cyan","green","yellow"),
  P=new Array();

function startup(evt){
	Root=document.documentElement;
	Doc=document;
  Grid = Doc.getElementById("grid");
	Root.setAttribute("onclick","ClickPoint(evt)");
	// Draw the grid
	drawlines(100,10);
  // Add labels
  coolabel(50,50,0,5.5,"x,y","darkslategray");
  coolabel(50,0,-10,15);
  coolabel(0,220,15,10);
  coolabel(280,100,0,0,"rx","chocolate",true);
  coolabel(185,265,0,0,"width","darkgreen",true);
  coolabel(390,150,0,0,"height","darkgreen",true);
  coolabel(50,290,0,0,"Required Attributes","darkgreen",true);
  coolabel(50,310,0,0,"Optional Attributes","chocolate",true);
}

function drawlines(u,t){
	B=Root.getBBox()
	var w=B.width
	var h=B.height
	
  for (i=0;i<=w/t;i++){
		L=Doc.createElementNS(xmlns,"line")
		L.setAttribute("x1",i*t)
		L.setAttribute("x2",i*t)
		L.setAttribute("y1",0)
		L.setAttribute("y2",8)
		L.setAttribute("stroke","gray")
		L.setAttribute("stroke-width","1")
		Root.insertBefore(L,Grid)
		
    if (i%10==0){
			L=Doc.createElementNS(xmlns,"line")
			L.setAttribute("x1",i*t)
			L.setAttribute("x2",i*t)
			L.setAttribute("y1",0)
			L.setAttribute("y2",h)
			L.setAttribute("stroke","gray")
			L.setAttribute("stroke-width","1")
      L.setAttribute("stroke-opacity","0.5")
      //Root.appendChild(L)
			Root.insertBefore(L,Grid)
		}
	}
	for (i=0;i<=h/t;i++){
		L=Doc.createElementNS(xmlns,"line")
		L.setAttribute("x1",0)
		L.setAttribute("x2",8)
		L.setAttribute("y1",i*t)
		L.setAttribute("y2",i*t)
		L.setAttribute("stroke","gray")
		L.setAttribute("stroke-width","1")
		Root.insertBefore(L,Grid)
		
    if (i%10==0){
			L=Doc.createElementNS(xmlns,"line")
			L.setAttribute("x1",0)
			L.setAttribute("x2",w)
			L.setAttribute("y1",i*t)
			L.setAttribute("y2",i*t)
			L.setAttribute("stroke","gray")
			L.setAttribute("stroke-width","1")
      L.setAttribute("stroke-opacity","0.5")
			Root.insertBefore(L,Grid)
		}
	}
}

function coolabel(x,y,ox,oy,l,color,hideNode){
	if (l==null) label=x+","+y
	else label=l
	
  if (hideNode==null || hideNode==false)
  {
    E=Doc.createElementNS(xmlns,"circle")
    E.setAttribute("cx",x)
    E.setAttribute("cy",y)
    E.setAttribute("r",6)
    E.setAttribute("stroke","darkslategray")
    E.setAttribute("stroke-width","1")
    E.setAttribute("opacity","1")
    E.setAttribute("fill","white")
    Root.appendChild(E)
    
    L=Doc.createElementNS(xmlns,"line")
    L.setAttribute("x1",x)
    L.setAttribute("x2",x+ox)
    L.setAttribute("y1",y+5.5)
    L.setAttribute("y2",y+oy)
    L.setAttribute("stroke","darkred")
    L.setAttribute("stroke-width","2")
    L.setAttribute("stroke-opacity","0.5")
    Root.appendChild(L)
  }
	
  T=Doc.createElementNS(xmlns,"text")
	T.setAttribute("x",x+ox-label.length*2)
	if (oy>0)
    T.setAttribute("y",y+oy+15)
	else
    T.setAttribute("y",y+oy-4)
	
  if (l==null) 
  {
  	T.setAttribute("font-size",14)
  }
	else 
  {
  	T.setAttribute("font-size",17)
    T.setAttribute("font-weight","bold")
  }
  
  if (color==null)
    T.setAttribute("fill","black")
  else
    T.setAttribute("fill",color)
    
	msg=Doc.createTextNode(label)
	T.appendChild(msg)
	Root.appendChild(T)
}