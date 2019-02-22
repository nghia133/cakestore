$(document).ready(function() 
		{
			var formInputs = $('input[type="email"],input[type="password"],input[type="text"]');
			formInputs.focus(function() {
				$(this).parent().children('p.formLabel').addClass('formTop');
				$('div#formWrapper').addClass('darken-bg');
				$('div.logo').addClass('logo-active');

				formInputs.focusout(function() {
					if ($.trim($(this).val()).length == 0) {
						$(this).parent().children('p.formLabel').removeClass(
								'formTop');
					}
					$('div#formWrapper').removeClass('darken-bg');
					$('div.logo').removeClass('logo-active');
				});
				
				
				$('p.formLabel').click(function() {
					$(this).parent().children('.form-style').focus();
				});
			});
	
});

$(document).ready(function() {
    $(".login").validate({
        rules: {           
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 6
            },
            confirm_password: {
                required: true,
                minlength: 6,
                equalTo: "#password"
            },
            phonenumber: {
                required: true,
                number: true
            }            
        },
        messages: { 
        	 email: {
                 required: "please enter your email",
                 email: "please enter a valid email"
             },
        
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 6 characters long"
            		},
            confirm_password: {
                 required: "Please provide a password",
                 minlength: "Your password must be at least 6 characters long",
                 equalTo: "Please enter the same password as above"
                   },            
            phonenumber: {
                required: "Please enter your phone number",
                number: "Please enter only numeric value"
            }           
           
        }
    });
});

