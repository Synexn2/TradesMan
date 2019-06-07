<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="tradesman.* , java.util.*"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8" />
    <title>Tradesman App | Search Result</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class = "container">

<div class="page-header">
    <h1>Search Result <small>Tradesman App</small></h1>
</div>
<div class = "row">
	<div class = "col-md-4 well">
	
		<ul class="nav nav-pills nav-stacked">
		<li><img src="images/prof_pic.jpg" alt="..." class="img-thumbnail" width = "100" height = "100"/></li>
		  <li role="presentation" class=""><a href="profile.jsp">Home</a></li>
		  <li role="presentation"><a href="createprofile.jsp">Profile</a></li>

		</ul>
	
	</div>
	<div class = "col-md-8">
		
		<table class = "table  ">
			<tr><th colspan="5" class = "success" >Tradesman Details</th></tr>
			<tr>
				<th>FirstName</th>
				<th>Lastname</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Hourly Rate</th>
			</tr>
			
			 				<%
							  
							 Tradesman tradesman = new Tradesman();
							  	 Vector<Tradesman> vector = tradesman.getTradesMen(request.getParameter("search"));
							 Trade trade = new Trade();
                    		
                    		for(Tradesman trd:vector)
                    		{ %>
                    		
                    		<tr>
								<td><%= trd.getFirstName() %></td>
								<td><%= trd.getLastName() %></td>
								<td><%= trd.getPhoneNumber() %></td>
								<td><%= trd.getEmail() %></td>
								<td><%= trd.getHourlyRate() %></td>
							</tr>
                    		<% 
                    		}
							  %>
			
		</table>
	</div>
</div>

</div>
</body>
</html>