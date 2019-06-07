<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="tradesman.* , java.util.*"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8" />
    <title>Tradesman App | User Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class = "container">
<% User user = (User)session.getAttribute("currentUser");  %>
<div class="page-header">
    <h1>Profile Page <small>Tradesman App: <%= user.getFirstName()  %></small></h1>
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
		<table class = "table ">
			<tr><th colspan="2" class = "success" >Personal Details</th></tr>
			<tr>
				<td>Name</td>
				<td><%= user.getFirstName() + " " +  user.getLastName() %></td>
			</tr>
			
			<tr>
				<td>Address</td>
				<td><%= user.getStreetName() + "<br>" + user.getCity() + "<br>" + user.getCounty() + "<br>" + user.getCountry() %></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><%= user.getPhoneNumber() %></td>
			</tr>
		</table>
		<table class = "table  ">
			<tr><th colspan="5" class = "success" >Professional Details</th></tr>
			<tr>
				<th>Trade</th>
				<th>Skills</th>
				<th>Hourly Rate</th>
				<th>References</th>
				<th>Previous Jobs</th>
			</tr>
			
			 				<%
							  
							 Tradesman tradesman = new Tradesman();
							  	 Vector<Tradesman> vector = tradesman.getProfile(user.getId());
							 Trade trade = new Trade();
                    		
                    		for(Tradesman trd:vector)
                    		{ %>
                    		
                    		<tr>
								<td><%= trade.getTradeName(trd.getTradeType()) %></td>
								<td><%= trd.getSkillSet() %></td>
								<td><%= trd.getHourlyRate() %></td>
								<td><%= trd.getReference() %></td>
								<td><%= trd.getPreviousJobs() %></td>
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