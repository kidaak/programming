
//=============================   Pergola configuration file   =======================

pergola.settings = {

// Use an existing pergola.skins property name
  skin : "rubber",

// Use a color keyword name, a custom color name or specify a color in any legal format.
  theme : "lightslategray"

};

pergola.path = "../../pergola/";

// values: true, false, or the number of lines. Default number of lines is 20.
pergola.debug = false;



/*
 *  Pergola defines document.documentElement as the default container in a standalone svg context.
 *  You can override it here for use in html context by uncommenting the next two lines and
 *  selecting the appropriate html element. See the html examples.
*/
//pergola.container = document.querySelector("#svg");
//pergola.doc = $C({element : "svg", width : "100%", height : "100%", appendTo : pergola.container});




// DO NOT EDIT BELOW THIS LINE

pergola.defs = $C({element : "defs", id : "pergola_defs", appendTo : pergola.doc});
