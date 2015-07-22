$(document).ready(function() {
	$("#logout").click(function() {
		$.post("logout", function(data) {
			location.reload();
		});
	});
		
	$("#customJsonSender").click(function() {
		$.ajax({
			  type: "POST",
			  url: "customJSON",
			  data: JSON.stringify({"name" : "John Doe"}),
			  contentType : 'application/json',
			  success: function(data) {
				  alert("success!");
			  },
			  failure: function(data) {
				  alert("fail!");
			  }
		});
	});
});