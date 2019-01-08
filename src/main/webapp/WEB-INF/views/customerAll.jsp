<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CustomersList</title>
    <link href="../../resources/customerAllstyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
<form action="/customer" method="get">
    <div class="wrapper1">
        <div class="label">Id</div>
        <div class="label">Firstname</div>
        <div class="label">Surname</div>
        <div class="label">Age</div>
        <div class="label">Client number</div>
        <div class="label">Action</div>
    </div>
    <div>
        <c:forEach  items="${CustomerList}" var ="customer">
            <div class="wrapper2">
                <div class="text">${customer.id}</div>
                <div class="text">${customer.firstname}</div>
                <div class="text">${customer.surname}</div>
                <div class="text">${customer.age}</div>
                <div class="text">${customer.client_number}</div>
                <div class="text">
                    <a type="button", class="btnAction", href="/customer/${customer.id}">Detail</a>
                    <a type="button", class="btnAction", href="/customer/delete/${customer.id}">Delete</a>
                </div>
            </div>
        </c:forEach>
    </div>
</form>

<div class="goBack" >
    <button class="btn" onclick="location.href='/'">Go back</button >
</div >

<form action = "/customer/create" method = "post" >
    <div class="createWr1" >
        <h2> Add new customer</h2>
    </div>
    <div class="createWr2" >
        <div class="label" > Firstname </div >
        <div class="label" > Surname </div >
        <div class="label" > Age </div >
        <div class="label" > Client number </div >
    </div >
    <div class="createWr3" >
        <div class="space" ><input type = "text" name = "firstname" required ></div >
        <div class="space" ><input type = "text" name = "surname" required ></div >
        <div class="space" ><input type = "text" name = "age" required pattern="^[ 0-9]+$" ></div >
        <div class="space" ><input type = "text" name = "client_number" required ></div >
    </div >

    <div class="forSubmit" >
        <button type = "submit" class="btn" > Submit </button >
    </div >
</form>
</body>
</html>
