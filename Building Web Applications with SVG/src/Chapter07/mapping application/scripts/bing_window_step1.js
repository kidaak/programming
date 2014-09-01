
//====================   Pergola - Bing tiles window example  ==========================


/*
 *                                ATTENTION !
 *                                 
 * THIS WORK USES A MODIFIED, UNOFFICIAL AND UNPUBLISHED VERSION OF POLYMAPS.
 * IT IS FORBIDDEN TO DISTRIBUTE THIS VERSION OF POLYMAPS.
 * 
 * Latest Polymaps release at: http://polymaps.org/
*/




var bingWin = new pergola.Window("Bing Maps");

bingWin.build({
	isFull : true,
	type : "map",
	mapWidth : 2048,
	mapHeight : 1536,
	fill : "#010413",
	menu : {
		views : {
      title : "Views",
      items : {
        aerial : {
          string : "Aerial",
          check : false,
          exclusive : true,
          view : "aerial",
          fn : tileSource
        },
        aerialLabels : {
          string : "Aerial With Labels",
          check : true,
          exclusive : true,
          view : "aerialWithLabels",
          fn : tileSource
        },
        road : {
          string : "Road",
          check : false,
          exclusive : true,
          view : "road",
          fn : tileSource
        }
      }
    }
	},
	views : {
		aerial : {},
    aerialWithLabels : {},
    road : {}
	},
	contains : function () {return this.mapMaker()}
});





