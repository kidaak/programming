$(document).ready(function(){
    var $speech = $('div.speech');
    var defaultSize = parseFloat($speech.css('fontSize'));
    $('#switcher button').click(function(event){
        var num = parseFloat($speech.css('fontSize'));
        switch(this.id){
            case 'switcher-large':
                num *= 1.4;    
                break;
            case 'switcher-small':
                num /= 1.4;
                break;
            default:
                num = defaultSize;
                break;
        }
        //$speech.css('fontSize', num + 'px');
        $speech.animate({fontSize: num + 'px'}, 'slow');
    });
    
    //hide, show
    var $firstPara = $('p').eq(1);
    $firstPara.hide();
    $('a.more').click(function(event){
        event.preventDefault();
        /*
        if($firstPara.is(':hidden')){
            $firstPara.fadeIn('slow');
            $(this).text('read less');
        }else{
            $firstPara.fadeOut('slow');
            $(this).text('read more');
        }
        */
        $firstPara.animate({height: 'toggle'}, 'slow');
        var $link = $(this);
        if($link.text() === 'read more'){
            $link.text('read less');
        }else{
            $link.text('read more');
        }
    });
    
    //complex effect
    $('div.label').click(function(){
        var paraWidth = $('div.speech p') .outerWidth();
        var $switcher =$(this).parent();
        var switcherWidth = $switcher.outerWidth();
        $switcher.css('position', 'relative').animate({
            borderWidth: '5px',
            left: paraWidth - switcherWidth,
            height: '+=20px'
        }, 'slow');
    });
});