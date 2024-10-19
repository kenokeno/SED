// JavaScript Document
$(document).ready(function(e) {
    //***************menu**********
		$('.slider ul ul').css({
			display:"none"    
    	});	
		var contenido = $('#contenido');
		contenido= true;
		
		$('.slider li').hover(function(){
			$(this).find(' > ul').stop(true,true).slideDown('slow');
		});
		$('.slider li').mouseleave(function(){
			$(this).find('> ul').stop(true,true).slideUp('slow');
		});
    
    //***************Efecto menu**********
           //************----1------********    
		$('.slider #a1').click(function(){
			if(contenido == true){
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}else{
				$('#contenido').stop(true,true).slideUp('slow')
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}
		});
		$('.slider #a1').click(function(){
			//$('#logo').css({height:"250px", width:"180px"});
			$('#logo').hide('slow');
		});
            //************----2------********    
            $('.slider #b1').click(function(){
			if(contenido == true){
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}else{
				$('#contenido').stop(true,true).slideUp('slow')
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}
		});
		$('.slider #b1').click(function(){
			//$('#logo').css({height:"250px", width:"180px"});
			$('#logo').hide('slow');
		});
            //************----3------********
            $('.slider #c1').click(function(){
			if(contenido == true){
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}else{
				$('#contenido').stop(true,true).slideUp('slow')
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}
		});
		$('.slider #c1').click(function(){
			//$('#logo').css({height:"250px", width:"180px"});
			$('#logo').hide('slow');
		});
            //************------4----********
            $('.slider #d1').click(function(){
			if(contenido == true){
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}else{
				$('#contenido').stop(true,true).slideUp('slow')
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}
		});
		$('.slider #d1').click(function(){
			//$('#logo').css({height:"250px", width:"180px"});
			$('#logo').hide('slow');
		});
            //************-----5-----********
            $('.slider #e1').click(function(){
			if(contenido == true){
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}else{
				$('#contenido').stop(true,true).slideUp('slow')
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}
		});
		$('.slider #e1').click(function(){
			//$('#logo').css({height:"250px", width:"180px"});
			$('#logo').hide('slow');
		});
            //************----------********
           
   //***************Efecto Logo**********
		$('.slider #a2').click(function(){
			$('#logo').show('slow');
			$('#contenido').hide('slow');
		});
		
                /*
               $('.slider').click(function(){
                   $(this).find('#a1')
                   if(contenido == true){
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}else{

				$('#contenido').stop(true,true).slideUp('slow')
				$('#contenido').stop(true,true).slideDown('slow');
				contenido=false;		
			}
                        $('#logo').hide('slow');
                   
                });
                */
	});