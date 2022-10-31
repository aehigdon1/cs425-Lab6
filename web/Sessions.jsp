<%-- 
    Document   : Sessions
    Created on : Oct 26, 2022, 2:25:47 PM
    Author     : aehig
--%>
<%@page import="edu.jsu.mcis.lab6.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id ="daoFactory" class="edu.jsu.mcis.lab6.dao.DAOFactory" scope="application"/>
<%
        TrainingSessionsDAO trainingsessionsdao = daoFactory.getTrainingSessionsDAO();
%>


<!DOCTYPE html>
<html>
    <head>
        <title>Sessions Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Sessions Page</div>
        <br>
        
        <form id="session">
            <fieldset>
        <legend>Manage Registration</legend>
        <br>
        
        <label for="cancel">Cancel Session:</label>
        <%= trainingsessionsdao.getSessionListAsHTML() %>
        <button type = "submit" value= "Cancel" onclick="return Lab6.onClickDelete();">Cancel</button><br>
        <br>
        
        
        <label for="edit">Edit Session:</label>
        <%= trainingsessionsdao.getSessionListAsHTML() %>
        <br><br>
        <label for="firstname">First Name:</label>
        <input type="text" name="firstname" id="firstname">
        <br><br>
        <label for="lastname">Last Name:</label>
        <input type="text" name="lastname" id="lastname">
        <br><br>
        <button type = "submit" value= "Edit" onclick="return Lab6.onClickPut();">Edit</button>

        
        
    </fieldset>
        </form>
            
        
        <p>Click <a href = "index.html">here</a> to navigate back to the main menu.</p>
    </body>
</html>

<script type="text/javascript">
    onClickDelete: function() {
        $.ajax({
            type: 'DELETE',
            url: '',
            data: $('#form').serialize();
            
        })
    }
    
</script>

