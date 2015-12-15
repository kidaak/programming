$(document).ready(function(){
    $('#selected-plays > li').addClass('horizontal');
    $('#selected-plays li:not(.horizontal)').addClass('sub-level');
    $('a[href^="mailto:"]').addClass("mailto");
    $('a[href$=".pdf"]').addClass("pdflink");
    $('a[href^="http"][href*="henry"]').addClass('henrylink');
    //$('tr:even').addClass('alt');
    $('tr:nth-child(odd)').addClass('alt');
    $('td:contains(Henry)').nextAll().addBack().addClass('highlight');
    $('a').filter(function() {
        console.log(this.hostname);
        console.log(location.hostname);
        return this.hostname && this.hostname != location.hostname;
    }).addClass('external');
});