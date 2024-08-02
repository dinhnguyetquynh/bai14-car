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
	<a href="/bai14-car/form-add">Add Car</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>    
                <th>Model Year</th>
                <th>Description</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cars}" var="car">
            	<c:url var="deleteLink" value="/delete-car">
					<c:param name="carId" value="${car.carId}"></c:param>
				</c:url>
				
				<c:url var="updateLink" value="/form-update-car">
					<c:param name="carId" value="${car.carId}"></c:param>
				</c:url>
				
                <tr>
                    <td>${car.carId}</td>
                    <td>${car.name}</td>
                    <td>${car.price}</td>
                    <td>${car.modelYear}</td>
                    <td>${car.carDes}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/${car.imgURL}" alt="${car.name}" width="100" height="100"/>
                    </td>
                    <td>
                    	<a href="${updateLink}">Update</a>
                    	<a href="${deleteLink}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
