<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer</title>
    <link href="../../resources/customerDetailStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
<form action="/customer/{id}" method="get">
    <div class="wrapper1">
        <div class="label">Id</div>
        <div class="label">Firstname</div>
        <div class="label">Surname</div>
        <div class="label">Age</div>
        <div class="label">Client number</div>
    </div>
    <div class="wrapper2">
        <div class="text">${Customer.id}</div>
        <div class="text">${Customer.firstname}</div>
        <div class="text">${Customer.surname}</div>
        <div class="text">${Customer.age}</div>
        <div class="text">${Customer.client_number}</div>
    </div>
</form>

<form action = "/customer/update/${Customer.id}" method = "post" >
    <div class="updateWr1" >
        <h2 > Update customer</h2>
    </div >
    <div class="updateWr2" >
        <div class="label" > Firstname </div >
        <div class="label" > Surname </div >
        <div class="label" > Age </div >
        <div class="label" > Client number </div >
    </div >
    <div class="updateWr3" >
        <div class="space" ><input type = "text" name = "firstname" required ></div >
        <div class="space" ><input type = "text" name = "surname" required ></div >
        <div class="space" ><input type = "text" name = "age" required pattern="^[ 0-9]+$" ></div >
        <div class="space" ><input type = "text" name = "client_number" required ></div >
    </div >

    <div class="forSubmit" >
        <button type = "submit" class="btn" > Submit </button >
    </div >
</form>

<div class="goBack" >
    <button class="btn" onclick="location.href='/customer'">Go back</button >
</div >
</body>
</html>
