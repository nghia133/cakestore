$(document).ready(function () {

	$.validator.addMethod("valueNotEquals", function(value, element, arg){
		  return arg != value;
		 }, "Value must not equal arg.");

		 // configure your validation
		 $("#login").validate({
		  rules: {
		   "category.id": { valueNotEquals: "default" }
		  },
		  messages: {
		   "category.id": { valueNotEquals: "Please select an item!" }
		  }  
		 });

   
});