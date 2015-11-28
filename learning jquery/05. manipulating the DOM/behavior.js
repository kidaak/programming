$(document).ready(function(){
   $('div.chapter a[href*=wikipedia]').attr({
       rel : 'external',
       title : 'Learn more' + $(this).text() + ' at Wikipedia',
       id : function(index, oldValue){
           return 'wikilink-' + index;
       }
   });
    
    $('<a href="#top">back to top</a>').insertAfter('div.chapter p');
    $('<a id="top"></a>').prependTo('body');
    
    //$('span.footnote').insertBefore('#footer').wrapAll('<ol id="notes"></ol>').wrap('<li></li>');
    
    var $notes = $('<ol id="notes"></ol>').insertBefore('#footer');
    $('span.footnote').each(function(index) {
        //$('<sup>' + (index + 1) + '</sup>').insertBefore(this);
        $(this).before(['<a href="#footnote-', index + 1,'" id="context-', index + 1, '" class="context">','<sup>', index + 1, '</sup></a>'].join(''))
        .appendTo($notes)
        .append(['&nbsp;(<a href="#context-', index + 1, '">context</a>)'].join(''))
        .wrap('<li id="footnote-' + (index + 1) +  '"></li>');
    });
});