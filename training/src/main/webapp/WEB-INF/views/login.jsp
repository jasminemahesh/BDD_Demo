<!DOCTYPE html>
<html>
<head>
<title>HCL Academy</title>
<link href="resources/assets/css/screen.css" rel="stylesheet" media="screen">
<link href="resources/assets/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="resources/assets/js/jquery.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
    rel="stylesheet" type="text/css" />
<style>
 .table{
			 font-weight: normal !important;
			font-size: 13px !important;
			border: black !important;
		 }
		 
		 .table td{
			white-space: nowrap;  /** added **/
		}
		
		.top-head {
			border-bottom: none !important;
		}
		.h3, h3{
	color:white !important;
	font-size:26px !important;
}
.top-head h2{
	font-size:20px !important;
	
}
.top-head{
	padding:10px 0 20px 0 !important;
}
</style>
<script type="text/javascript">
function getAllCustomers() {
// get the form values
//var name = $('#name').val();
//var education = $('#education').val();

$.ajax({
    type: "GET",
    url: "customer/list",
    
    success: function(results){
		
        // we have the response
				$('#info').html("");
				var table = $('<table class="table table-striped table-bordered"/>').appendTo($('#info'));
		//	   var table = $('<table border="1"/>').appendTo($('#info'));
				 $('<tr/>').appendTo(table).append($('<th/>').text("Account ID")).append($('<th/>').text("Firstname"))
				 .append($('<th/>').text("Lastname")).append($('<th/>').text("Gender")).append($('<th/>').text("Phone"))
				 .append($('<th/>').text("Email")).append($('<th/>').text("National ID"))
				 .append($('<th/>').text("Address")).append($('<th/>').text("City"))
				 .append($('<th/>').text("Postal Code")).append($('<th/>').text("Country"))
				 .append($('<th/>').text("Account type")).append($('<th/>').text("Balance"));
				 
                $(results).each(function(i, response) {
                    $('<tr/>').appendTo(table)
                   		.append($('<td/>').text(response.accountId))
                        .append($('<td/>').text(response.firstname))
                        .append($('<td/>').text(response.lastname))
                        .append($('<td/>').text(response.gender))
                        .append($('<td/>').text(response.phone))
                        .append($('<td/>').text(response.email))
                        .append($('<td/>').text(response.nationalId))
                        .append($('<td/>').text(response.address))
                        .append($('<td/>').text(response.city))
                        .append($('<td/>').text(response.postalCode))
                        .append($('<td/>').text(response.country))
                        .append($('<td/>').text(response.accountType))
                        .append($('<td/>').text(response.balance))
                });
          
       
    }
}

);
}

function getCustomerById() {
// get the form values
var customerId = $('#search').val();
//var education = $('#education').val();

$.ajax({
    type: "GET",
    url: 'customer/get/'+customerId,
    
    success: function(results){
		$('#info').html("");
        // we have the response
				var table = $('<table class="table table-striped table-bordered"/>').appendTo($('#info'));
		//	   var table = $('<table border="1"/>').appendTo($('#info'));
				 $('<tr/>').appendTo(table).append($('<th/>').text("Account ID")).append($('<th/>').text("Firstname"))
				 .append($('<th/>').text("Lastname")).append($('<th/>').text("Gender")).append($('<th/>').text("Phone"))
				 .append($('<th/>').text("Email")).append($('<th/>').text("National ID"))
				 .append($('<th/>').text("Address")).append($('<th/>').text("City"))
				 .append($('<th/>').text("Postal Code")).append($('<th/>').text("Country"))
				 .append($('<th/>').text("Account type")).append($('<th/>').text("Balance"));
				 
                $(results).each(function(i, response) {
                    $('<tr/>').appendTo(table)
                   		.append($('<td/>').text(response.accountId))
                        .append($('<td/>').text(response.firstname))
                        .append($('<td/>').text(response.lastname))
                        .append($('<td/>').text(response.gender))
                        .append($('<td/>').text(response.phone))
                        .append($('<td/>').text(response.email))
                        .append($('<td/>').text(response.nationalId))
                        .append($('<td/>').text(response.address))
                        .append($('<td/>').text(response.city))
                        .append($('<td/>').text(response.postalCode))
                        .append($('<td/>').text(response.country))
                        .append($('<td/>').text(response.accountType))
                        .append($('<td/>').text(response.balance))
                });
          
       
    },


error: function(error, ajax, errorstatus){
	var table = $('<table class="table table-striped table-bordered"/>').appendTo($('#info'));
	$('<tr/>').appendTo(table).append($('<td/>').text("User Not Found"));
	
    }

}
);
}
function callCreateCustomer() {
// get the form values
var customerId = $('#search').val();
//var education = $('#education').val();

 window.location.href = "customer/create";	


}
</script>

</head>

<body>

<header class="header">
	<div class="container">
		<h3>Internet Banking</h3>
		
	</div>
</header>

<section class="content">
<div class="container">
	<div>
		<div class="top-head">
			<h2>Customer Management</h2>
		</div>
	</div>
	
			<form>
					<input type="text" id="search" placeholder=""/> 
					<input type="button" id="searchById" value="Search Customer By Id" onclick="getCustomerById()" class="btn" /> 
					<input type="button" id="getCustomerList" value="Get All Customers" onclick="getAllCustomers()" class="btn" /> 
					<input type="button" id="createCustomer" value="Create Account" onclick="callCreateCustomer()" class="btn" />
					
					
			</form>
			<br/><br/><br/>
			
			<div id="info"></div>
			<div id="dialog" style="display: none" align = "center">
			This is a jQuery Dialog.
			</div>
</div>		
</section>			
		
	
	


<footer class="footer">
	<div class="container">
		<ul class="ftr-link">
			<li><a href="#">Feedback</a></li>
			<li><a href="#">Privacy</a></li>
			<li><a href="#">Terms &amp; Conditions</a></li>
		</ul>	
		<p>&copy; HCL Technologies 2016</p>
	</div>
</footer>


<!-- Include JS File Here -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>

</html>