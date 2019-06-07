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
<% 

ApplicationDAO appDao = new ApplicationDAO();

if(session.getAttribute("currentUser") != null){
	
	if("Add Trade".equals(request.getParameter("trade"))){
		
		//String email = request.getParameter("email");
	    
		 String name = request.getParameter("name");
   		 String description = request.getParameter("description");
		Trade trade = new Trade(name,description);
   		 
		trade.createTrade();

	}
}

else{
	
	 String redirectURL = "login.jsp";
	 response.sendRedirect(redirectURL);
}


%>
<div class="container">

<div class="page-header">
    <h1>Create Trade <small>Tradesman App</small></h1>
</div>

<!-- Registration form - START -->
<div class="container">
    <div class="row">
        <form role="form">
            <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <div class="form-group">
                    <label for="InputName">Name</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="name" id="tradename" placeholder="Enter tradename" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>     
                
                <div class="form-group">
                    <label for="InputName">Description</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="description" id="tradename" placeholder="Enter tradename" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div> 
                         
                
                <input type="submit" name="trade" id="submit" value="Add Trade" class="btn btn-info pull-right">
                 
            </div>
          
        </form>
        
       
        
        <div class="col-lg-5 col-md-push-1">
            <div class="col-md-12">
                <div class="alert alert-success">
                    <strong><span class="glyphicon glyphicon-ok"></span> Success! Message sent.</strong>
                </div>
                <div class="alert alert-danger">
                    <span class="glyphicon glyphicon-remove"></span><strong> Error! Please check all page inputs.</strong>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Registration form - END -->

</div>

</body>
</html>