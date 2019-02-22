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
$(document).ready(function() {
	$('#thumb a').click(function(e) {
		e.preventDefault();
		$('.imgBox img').attr("src", $(this).attr("href"))
	});

});
$(document).ready(function() {
	$(".menu li ").on('click', function(event) {
		$('.menu li ').removeClass('active');
		$(this).closest('li').addClass('active')

	});
});

$(document).ready(function() {
	$("#thumb li ").on('click', function(event) {
		$('#thumb li ').removeClass('change');
		$(this).closest('li').addClass('change')

	});
});