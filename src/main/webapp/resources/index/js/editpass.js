$(document).ready(function() {
    $("#login").validate({
        rules: {           
            password: {
                required: true,
                minlength: 6
            },
            confirm_password: {
                required: true,
                minlength: 6,
                equalTo: "#password"
            }     
        },
        messages: {        	 
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 6 characters long"
            		},
            confirm_password: {
                 required: "Please provide a password",
                 minlength: "Your password must be at least 6 characters long",
                 equalTo: "Please enter the same password as above"
                   }
        }
    });
});