<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car List</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>    
                <th>Model Year</th>
                <th>Description</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td>${car.carId}</td>
                    <td>${car.name}</td>
                    <td>${car.price}</td>
                    <td>${car.modelYear}</td>
                    <td>${car.carDes}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/${car.imgURL}" alt="${car.name}" width="100" height="100"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
