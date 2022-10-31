<%-- 
    Document   : Registrations
    Created on : Oct 26, 2022, 2:21:49 PM
    Author     : aehig
--%>


<%@page import="edu.jsu.mcis.lab6.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id ="daoFactory" class="edu.jsu.mcis.lab6.dao.DAOFactory" scope="application"/>

<%       
        RegistrationDAO registrationdao = daoFactory.getRegistrationDAO();
        TrainingSessionsDAO trainingsessionsdao = daoFactory.getTrainingSessionsDAO();
        AttendeesDAO attendeesdao = daoFactory.getAttendeesDAO();
%>

<!DOCTYPE html>


<html>
    <head>
        <title>Registration Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Registration Page</div>
        <br>
        
        <form id="register">
    <fieldset>
        <legend>New Attendees Registration</legend>
        <br>
        <label for="firstname">First Name:</label>
        <input type="text" name="firstname" id="firstname">
        <br><br>
        <label for="lastname">Last Name:</label>
        <input type="text" name="lastname" id="lastname">
        <br><br>
        <label for="displayname">Display Name:</label>
        <input type="text" name="firstname" id="firstname">
        
       <p>Sessions Menu<span id="sessionsmenu">
               <%= trainingsessionsdao.getSessionListAsHTML()%>
               
               <button type = "submit" value= "Register" onclick="return Lab6.onClickPost();">Register</button>

            </span></p>
    </fieldset>
    </form>
        
        <p>Click <a href = "index.html">here</a> to navigate back to the main menu.</p>
        
    </body>
    </html>
    
    <script type="text/javascript">
    onClickPost: function() {
        $.ajax({
            type: 'POST',
            url: '',
            data: $('#form').serialize();
            
        })
    }
</script>