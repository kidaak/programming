
//=============================   Pergola configuration file   =======================


pergola.settings = {

// String - Use an existing property name of the pergola.skins object
  skin : "rubber",

// String - values: color keyword; custom color name; color in any legal format.
  theme : "city"

};

pergola.path = "../../pergola/";

// values: true, false, or the number of lines. Default number of lines is 20.
pergola.debug = false;



/*
 * HTML
 * Pergola defines document.documentElement as the default container in a standalone svg context.
 * You can override it here for use in html context by uncommenting the next two lines and
 * selecting the appropriate html element. See the html examples.
*/
//pergola.container = document.getElementById("svg");
//pergola.doc = $C({element : "svg", width : "100%", height : "100%", appendTo : pergola.container});




// DO NOT EDIT BELOW THIS LINE

pergola.defs = $C({element : "defs", id : "pergola_defs", appendTo : pergola.doc});

