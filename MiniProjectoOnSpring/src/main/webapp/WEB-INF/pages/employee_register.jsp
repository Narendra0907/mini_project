<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:blue;text-align:center">Register employee</h1>
<frm:form method="POST" modelAttribute="emp" action="employee_add">


<table boder="1" bgcolor="cyan" align="center"> 

<tr>
<td>Employee name</td>
<td><frm:input path="ename"/></td>
</tr>

<tr>
<td>Employee Degn</td>
<td><frm:input path="job"/></td>
</tr>

<tr>
<td>Employee Salarly</td>
<td><frm:input path="sal"/></td>
</tr>

<tr>
<td colspan="2" align="center" ><input type="submit" value="register"></td>  
</tr>
</table>

</frm:form>
