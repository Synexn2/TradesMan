<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="tradesman.* , java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8" />
    <title>Tradesman App | Create Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>


<% 

ApplicationDAO appDao = new ApplicationDAO();


		

	 
if(session.getAttribute("currentUser") != null){
	
	if("Create Profile".equals(request.getParameter("submit"))){
		
		//String email = request.getParameter("email");
	    double hourlyrate = Double.parseDouble(request.getParameter("hourlyrate"));
	    //byte picture= Byte.parseByte(request.getParameter("picture"));
	    int tradetype= Integer.parseInt(request.getParameter("tradetype"));
	    String skillset= request.getParameter("skillset");
	    String reference= request.getParameter("reference");
	    String previousjobs= request.getParameter("previousjobs");
	    //String pin= request.getParameter("pin");
	    //String busydates= request.getParameter("busydates");
	    //String country= request.getParameter("country");
		
		
		User user = (User)session.getAttribute("currentUser");
		  System.out.println("User id logged in for creating profile is: "+user.getId());
		
		Tradesman tradesman = new Tradesman();
		
		//Tradesman tradesman = (Tradesman)user;
		tradesman.setUserId(user.getId());
		tradesman.setHourlyRate(hourlyrate);
		//user.setPicture(picture);
		tradesman.setTradeType(tradetype);
		tradesman.setSkillSet(skillset);
		tradesman.setReference(reference);
		tradesman.setPreviousJobs(previousjobs);
		//tradesman.setPin(pin);
		//user.setBusydates(busydates);
		
	tradesman.createProfile();
	//appDao.updateProfile(tradesman);

	}
}

else{
	
	 String redirectURL = "login.jsp";
	 response.sendRedirect(redirectURL);
}


%>



<div class="container">
<div class="page-header">
    <h1>Profile form <small>Tradesman App</small></h1>
</div>
<!-- Registration form - START -->
<div class="container-fluid" style = "margin-top:30px;">

   <div class="row">
    <div class = "col-lg-4 well">
	
		<ul class="nav nav-pills nav-stacked">
		<li><img src="images/prof_pic.jpg" alt="..." class="img-thumbnail" width = "100" height = "100"/></li>
		  <li role="presentation" class=""><a href="profile.jsp">Home</a></li>
		  <li role="presentation"><a href="createprofile.jsp">Profile</a></li>
		  <li role="presentation"><a href="login.jsp">LogOut</a></li>

		</ul>
	
	</div>
	<div class = "col-lg-8">
        <form role="form" action = "createprofile.jsp" class= "form-horizontal">
            <div class="col-lg-8">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                
                <div class="form-group">
                    <label for="InputEmail"> Hourly Rate</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="hourlyrate" name="hourlyrate" placeholder=" hourly rate" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail"> Trade Type</label>
                    <div class="input-group">
                        <select class="form-control" name = "tradetype">
							  <%
							  
							 Trade trade = new Trade();
							  	 Vector<Trade> vector = trade.getTrades();
                    		
                    		for(Trade trd:vector)
                    		{ %>
                    		
                    		 <option value = "<%= trd.getId() %>"><%= trd.getName() %></option>
                    		<% 
                    		}
							  %>
							</select>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail"> Skill Set</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="skillset" name="skillset" placeholder=" skill set" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail"> Reference</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="reference" name="reference" placeholder=" Reference" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail"> Previous Jobs</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="previousjobs" name="previousjobs" placeholder=" Previous jobs" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail"> Pin</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="pin" name="pin" placeholder=" pin" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
           
                
                <input type="submit" name="submit" id="submit" value="Create Profile" class="btn btn-info pull-right">
            </div>
        </form>
        </div>
    </div>
</div>
<!-- Registration form - END -->

</div>

</body>
</html>