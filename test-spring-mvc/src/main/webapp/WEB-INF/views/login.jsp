
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
  
  <form action="/login"  method="post">
  
  <p><font color="red">${errorMessage}</font></p>
 Name: <input type="text" name="username" /> Password:<input type="password" name="password" /> <input type="submit" value="Log In"/>
  </form>
  
   
<%@ include file="common/footer.jspf"%>