
// DS: based on http://bl.ocks.org/1216850 by Jon Frost.

var wormWin = new pergola.Window("Worms");

wormWin.contents = function() {
  var repCountSpace = 80,
      mouse = {x : 400, y : 400},
      zoom = 1,
      color = d3.scale.linear()
        .domain([0, repCountSpace])
        .interpolate(d3.interpolateHsl)
        .range(["hsl(250,0%,100%)", "hsl(180,100%,50%)"]),
      vis = d3.select(this.childDoc.transformable),
      node = vis.node();

  var gradient = $C({element : "linearGradient", id : "worm-gradient", x1 : "0%", y1 : "20%", x2 : "20%", y2 : "100%", appendTo : node});
  $C({element : "stop", offset : "20%", "stop-color" : "yellow", appendTo : gradient});
  $C({element : "stop", offset : "50%", "stop-color" : "blue", appendTo : gradient});
  $C({element : "stop", offset : "100%", "stop-color" : "orange", appendTo : gradient});

  this.excite = function (timer) {
    timer.count ++;
    timer.target.attr("transform", function(d, i) {
      d.center[0] = (d.center[0] + ((mouse.x / zoom + timer.offset - d.center[0]) / (i + 10))).trim(2);
      d.center[1] = (d.center[1] + ((mouse.y / zoom - d.center[1]) / (i + 10))).trim(2);
      d.angle = (d.angle + (Math.sin((timer.count + i) / 10) * 3)).trim(2);
      return "translate(" + d.center + ") rotate(" + d.angle + ")";
    });
  };

  this.george = d3.select(
    $C({element : "g", "stroke-width" : 5, "stroke-opacity" : .2, fill : "url(#worm-gradient)", appendTo : node})
  );

  this.george.e = this.george.selectAll()
      .data(d3.range(repCountSpace))
    .enter().append("svg:ellipse")
      .attr("rx", function(d) { return repCountSpace - d; })
      .attr("ry", function(d) { return ((repCountSpace - d) * .66); })
      .attr("stroke", function(d) { return color(d); })
      .map(function(d) { return {center: [250, 250], angle: 30}; });

  this.george.timer = pergola.Timer()
  .initialize({
    handle : this,
    callback : this.excite,
    frequence : 25,
    target : this.george.e,
    offset : -110,
    count : 0
  });

  this.albertina = d3.select(
    $C({element : "g", "stroke-width" : 48, "stroke-opacity" : .04, fill : "url(#worm-gradient)", appendTo : node})
  );

  this.albertina.e = this.albertina.selectAll()
      .data(d3.range(repCountSpace))
    .enter().append("svg:ellipse")
      .attr("rx", function(d) { return repCountSpace - d; })
      .attr("ry", function(d) { return ((repCountSpace - d) * .66); })
      .attr("stroke", function(d) { return color(d); })
      .map(function(d) { return {center: [250, 250], angle: 30}; });

  this.albertina.timer = pergola.Timer()
  .initialize({
    handle : this,
    callback : this.excite,
    frequence : 25,
    target : this.albertina.e,
    offset : 110,
    count : 0
  });

  this.registerEvents(this.background.rect, "mouseover", function (evt) {
    var c = wormWin.childDoc,
        offsetX = c.absoluteX(c.port),
        offsetY = c.absoluteY(c.port);

    zoom = c.scaleFactor;
    pergola.dragarea.resize(offsetX, offsetY, c.width(), c.height());

    pergola.dragarea.activate({
      handle : wormWin,
      fn : function (evt) {
        var m = pergola.mousePoint(evt);
        mouse.x = m.x - this.offsetX;
        mouse.y = m.y - this.offsetY;
      },
      offsetX : offsetX,
      offsetY : offsetY,
      updateCoordinates : false
    });
  });

};

wormWin.build({
  isFull : true,
  x : 120,
  y : 120,
  width : 600,
  height : 420,
  fill : "black",
  contains : function () {this.contents();}
});

















