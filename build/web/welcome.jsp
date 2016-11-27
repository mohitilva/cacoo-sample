<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cacoo - Welcome</title>
	</head>	
	<body>	
            <div>
               To use this app, you should already by logged in to your Cacoo account.
            </div>
		<form action="MainServlet">			
			 Please enter your apiKey <br>
			<input type="text" name="apiKey"size="20px">
			<input type="submit" value="submit">						
		</form>		
	</body>	
</html>