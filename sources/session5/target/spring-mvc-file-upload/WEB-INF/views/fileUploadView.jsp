<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="utf-8"
         isELIgnored="false"
%>

<!DOCTYPE html>
<html>

<body>
<h2>Submitted File with Data (<code>@ModelAttribute</code>)</h2>
<table>
    <tr>
        <td>Name :</td>
        <td>${formData.name}</td>
    </tr>
    <tr>
        <td>Email :</td>
        <td>${formData.email}</td>
    </tr>
    <tr>
        <td>OriginalFileName :</td>
        <td>${formData.file.originalFilename}</td>
    </tr>
    <tr>
        <td>Type :</td>
        <td>${formData.file.contentType}</td>
    </tr>
</table>
</body>
</html>

