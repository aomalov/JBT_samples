function ajaxExampleSum(){
	var num1 = $('.num1').val();
	var num2 = $('.num2').val();
	
	var url = 'http://localhost:8080/AjaxExample/sum?num1'+"="+num1+"&num2="+num2; 
	
	$.ajax({
		type:'get',
		//contentType: "charset=utf-8",
		url:url,		
		//data: myString,
		contentType:'application/json',
		//success: successCallbackFunction,
		success:function(msg)
		{
			$('#result').text(msg.result);
		},
		failure: function(errMsg){
			alert(errMsg);
		}			
	});
	
	// This line shows that ajax is asynchronious.
	// The ajax command has been executed before the alert, but the client code does not wait for the 
	// response from the server (which we will delay), and moves on.
	// The ajax code (the callback) will be executed ONLY after a response from the server will arrive.
	//alert("This text is displayed before getting the response for the ajax request, even though it's called after it");
	
}