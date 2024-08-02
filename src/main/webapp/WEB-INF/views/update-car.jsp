<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Car</title>
</head>
<body>

    <div id="dvPreview1"></div>

    <form:form action="update-car" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Name</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><form:input path="price" /></td>
            </tr>
            <tr>
                <td>Model Year</td>
                <td><form:input path="modelYear" /></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><form:input path="carDes" /></td>
            </tr>
            <tr>
                <td>Select File:</td>
                <td><input type="file" name="file" id="fileToUpload"/></td>
            </tr>
        </table>
        <input type="submit" value="Update"/>
    </form:form>
    <c:if test="${not empty filesuccess}">
        <p>${filesuccess}</p>
    </c:if>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#fileToUpload").change(function(){
                var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.jpg|.jpeg|.gif|.png|.bmp)$/;
                if(regex.test($(this).val().toLowerCase())){
                    if(typeof (FileReader)!="undefined"){
                        var reader = new FileReader();
                        reader.onload = function(e){
                            $("#dvPreview1").html("<img src='" + e.target.result + "' width='100' height='100'/>");
                        }
                        reader.readAsDataURL($(this)[0].files[0]);
                    }else{
                        alert("This browser does not support FileReader.");
                    }
                } else {
                    alert("Please select a valid image file.");
                }
            });
        });
    </script>
</body>
</html>
