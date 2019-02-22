$(document).ready(function() {
    $("#login").validate({
        rules: {           
        	email: {
                required: true,
                email: true
            },
            userProfiles:"required"
        },
        messages: {        	 
        	email: {
                required: "please enter your email",
                email: "please enter a valid email"
            },
            userProfiles: "please choose"
        }
    });
});