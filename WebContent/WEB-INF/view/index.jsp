<%-- 
    Document   : index
    Created on : Jan 7, 2012, 1:39:14 PM
    Author     : miguelgomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<jsp:include page="header.jsp"/>
    	<div id="loginBox">
	        <form name="login" action="authenticate" method="post">
	            <h1 id="loginHeader">Login Page</h1>
				<table id="loginFields">
					<tr class="formRow">
			            <td class="inputLabel">Username</td>
						<td class="inputContent"><input type="text" name="user_name" size="20"/></td>
					</tr>
		            <tr class="formRow">
			        	<td class="inputLabel">Password</td>
						<td class="inputContent"><input type="password" name="user_password" size="15"/><br/></td>
					</tr>
		        </table>
		        <div class="formRow">
			        <input type="submit" class="formButton" name="bt_login" value="Login"/>
	            	<input type="reset" class="formButton" name="bt_reset" value="Clear"/>
	            </div>
	            <div class="formRow"><a class="linkButton" href="/Foobar-Messenger/register">Register Here</a></div>
	        </form>
	    </div>
    </body>
</html>
