$(function(){
      $('#menu li').click(function(){
          $('#menu li').removeClass();
          $(this).addClass('active');
          $('.pagination li ').removeClass('active');
      });
  });
      
      $(document).ready(function () {
        $('.pagination li').on('click', function (event) {
          $('.pagination li ').removeClass('active');
          $(this).closest('li').addClass('active');
          $('#menu li').removeClass();
        });      
      });
      
    
      function sendRequest(url, data, method, callback) {
    		$.ajax({
    			url : url,
    			type : method,
    			data : data,
    			contentType : 'application/json',
    			success : callback,
    			error : function(request, msg, error) {
    				// handle failure
    			}
    		});
    	};

    	
     function getProduct(id, mode) {
    		location.href='products/getProduct?id=' + id + "&mode=" + mode;
    	};
    	
    function getCart(id) {
    	location.href='cart/add?id=' + id;    		
    	};
    	
    function sendRequest(url, data, method, callback) {
    		$.ajax({
    			url : url,
    			type : method,
    			data : data,
    			contentType : 'application/json',
    			success : callback,
    			error : function(request, msg, error) {
    				// handle failure
    			}
    		});
    	};

    	function sendGetRequest(url, callback) {
    		sendRequest(url, "", 'GET', callback);
    	};

    	function sendPostRequest(url, data, callback) {
    		sendRequest(url, data, 'POST', callback);
    	};

    	function sendPutRequest(url, data, callback) {
    		sendRequest(url, data, 'PUT', callback);
    	};

    	function sendDeleteRequest(url, callback) {
    		sendRequest(url, "", 'DELETE', callback);
    	};

    	function addProduct() {
    		location.href='addProduct';
    	}

    	function viewProduct(id) {
    		location.href='viewproduct?id=' + id 
    	};
    	function listcategory(id){
    		location.href='listcategory?id=' + id 
    	};

    	function editProduct(id) {
    		location.href='editproduct?id=' + id 
    	};

    	function category(id) {
    		location.href='category?id=' + id    		
    	};

    	function deleteProduct(id) {
    		var r = confirm("Do you want to delete this product?");
    		if (r == true) {
    			
    			location.href='deleteproduct?id='+ id;
    		}	
    	};

    