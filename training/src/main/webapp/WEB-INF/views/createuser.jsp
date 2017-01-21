<!DOCTYPE html>
<html>
<head>
<title>Customer Management - Create Customer</title>

<link href="../resources/assets/css/screen.css" rel="stylesheet" media="screen">
<link href="../resources/assets/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="../resources/assets/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
    rel="stylesheet" type="text/css" />
	
	

<style>
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


.form-label label{
	color:rgba(111, 111, 113, 1);
	font-size:13px;
	display:inline-block;
	width:100px;
	text-align:left;
	margin-right:15px;
}

.form-label select{
	width:160px;
}

.form-label input select{
	color:rgba(111, 111, 113, 1);
	background:#fff;
	border:1px solid rgba(223, 223, 223, 1);
	height:30px;	
}

</style>

<script type="text/javascript">


function submitCreateUser() {
        var customer = {
            firstname: $("#firstname").val(),
            lastname:$("#lastname").val(),
			gender:$("#gender").val(),
            phone:$("#phone").val(),
			email: $("#email").val(),
            nationalId:$("#nationalId").val(),
            address:$("#address").val(),
			city: $("#city").val(),
            postalCode:$("#postalCode").val(),
            country:$("#country").val(),
            accountType:$("#accountType").val(),
            balance:$("#balance").val()
			
        }

        
        $.ajax({
            url: 'create',
            type: 'post',
            dataType: 'json',
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(customer),
            success: function (data) {
               // $('#target').html(data.msg);
				window.location.href = "../";	
            }
            
        });
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
		<div class="top-head">
			<h2>Create Account</h2>
			<p>Please provide details below. All fields are mandatory.</p>
		</div>
		
			<form>
				<div class="form-label">
					<label class="form-label">First Name:</label>
					<input type="text" id="firstname" placeholder=""/>
				</div>
				<div class="form-label">
					<label>Last Name:</label>
					<input type="text" id="lastname" />
				</div>
				<div class="form-label">
					<label>Gender:</label>
					<select id="gender">
						<option>- Select -</option>
						<option>Female</option>
						<option>Male</option>
					</select>
				</div>
				<div class="form-label">
					<label>Phone Number:</label>
					<input type="text" id="phone" />
				</div>
				<div class="form-label">
					<label>E-mail Address:</label>
					<input type="text" id="email" />
				</div>
				<div class="form-label">
					<label>National ID:</label>
					<input type="text" id="nationalId" />
				</div>
				<div class="form-label">
					<label>Address:</label>
					<input type="text" id="address" />
				</div>
				<div class="form-label">
					<label>City:</label>
					<input type="text" id="city" />
				</div>
				<div class="form-label">
					<label>Postal Code:</label>
					<input type="text" id="postalCode" />
				</div>
				<div class="form-label">
					<label>Country:</label>
					<input type="text" id="country" />
				</div>
				<div class="form-label">
					<label>Account Type:</label>
					<select id="accountType">
						<option>- Select -</option>
						<option>Savings</option>
						<option>Current</option>
					</select>
				</div>
				<div class="form-label">
					<label>Opening Balance:</label>
					<input type="text" id="balance" />
				</div>
				
				
				
				<input type="button" onclick="submitCreateUser()" class="btn mrgbtn" value="Create Customer" id="createCustomer"/>
			</form>
			
		
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