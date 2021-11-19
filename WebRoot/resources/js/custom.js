$(document).ready(function(){
	//FLEXISLIDER
	jQuery('.flexslider').flexslider({
		animation: "slide",
		start: function(slider){
		  $('body').removeClass('loading');
		}
	});
	
	//JCAROUSEL
	jQuery('.first-and-second-carousel').jcarousel();
	
	
	//SLIDE TOGGLE
	jQuery(".minicart_link").toggle(function() {
		 $('.cart_drop').slideDown(300);	
		 }, function(){
		 $('.cart_drop').slideUp(300);		 
	});	
	
	
	//FORM ELEMENTS
	jQuery("select").uniform(); 

});