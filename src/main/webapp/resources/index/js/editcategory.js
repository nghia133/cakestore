$(document).ready(function() {
    $("#login").validate({
        rules: {           
        	name:"required"
        }, 
        messages: {    	 
        	name: "please enter category name"
                 
            }          
        
    });
});