
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
  mapWidth : 2048,               // multiple of 256. Should be >= window.screen.width
  mapHeight : 1536,              // multiple of 256. Should be >= window.screen.height
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
    },
    layers : {
      title : "Layers",
      items : {
        svgOpen2011 : {
          string : "SVG Open 2011",
          check : false,
          target : function () {
            return {
              layer : bingWin.layers.svgOpen2011,
              center : {lat : 42.36131, lon : -71.08124},
              zoom : 17,
              view : "road"
            };
          },
          fn : 'toggleLayer'
        },
        copyright : {
          string : "Copyright",
          check : true,
          target : function () {return bingWin.childDoc.copyright;},
          fn : function () {        // user function (see documentation for possible formats)
            if (!this.target()) return;
            var l = bingWin.layers.copyright;
            l.display = l.display == "block" ? "none" : "block";
            this.target().setAttributeNS(null, "display", l.display);
          }
        }
      }
    }
  },
  views : {
    aerial : {},
    aerialWithLabels : {},
    road : {}
  },
  layers : {
    copyright : {
      feature : false,
      display : "block"
    },
    svgOpen2011 : {
      feature : true,
      display : "none"
    }
  },
  contains : function () {return this.mapMaker()}
});



bingWin.menu.layers.list.svgOpen2011.toggleLayer = function (evt) {
  var target = this.target(),
      o = target.layer,
      currentMap = pergola.Window.currentMap;

  if (target.view) {
    currentMap.mapViewsToggle(target.view);
  }

  if (!o.container) {
    currentMap.map.add(polymaps.geoJson(o)
    .features([
      {
        "geometry" : {
          "type" : "Point",
          "coordinates" : [-71.08124, 42.36131],
          "elements" : pergola.symbols.signalPaddle
        }
      }
    ]));
  }
  currentMap.centerMap(target.center);
  currentMap.mapZoom(target.zoom);
  currentMap.showMapFeatureLayer(o);
}

