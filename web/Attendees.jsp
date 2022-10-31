<%-- 
    Document   : Attendees
    Created on : Oct 26, 2022, 2:25:35 PM
    Author     : aehig
--%>

<%@page import="edu.jsu.mcis.lab6.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id ="daoFactory" class="edu.jsu.mcis.lab6.dao.DAOFactory" scope="application"/>
<%
    AttendeesDAO attendeesdao = daoFactory.getAttendeesDAO();
%>


<!DOCTYPE html>

<html>
    <head>
        <title>Attendees Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Attendees Page</div>
        <br>
        
        <form id="register">
    <fieldset>
        
        <p>Choose an Attendee</p>
        
        <!<!-- edit with put request to completely change -->    
        <label for="edit">Edit Session:</label>
        <%= attendeesdao.getAttendeesListAsHTML() %>
        <br><br>
        <label for="firstname">First Name:</label>
        <input type="text" name="firstname" id="firstname">
        <br><br>
        <label for="lastname">Last Name:</label>
        <input type="text" name="lastname" id="lastname">
        <br><br>
        <button type = "submit" value= "Edit" onclick="return Lab6.onClick();">Edit</button>
    </fieldset>
    </form>
        
        <p>Click <a href = "index.html">here</a> to navigate back to the main menu.</p>
    </body>
</html>

<script type="text/javascript">
    onClick: function() {
        $.ajax({
            type: 'PUT',
            url: '',
            data: $('#form').serialize();
            
        })
    }
</script>