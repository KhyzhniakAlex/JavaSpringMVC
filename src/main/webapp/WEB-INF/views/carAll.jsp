<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CarsList</title>
    <link href="../../resources/carAllstyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
<form action="/car" method="get">
    <div class="wrapper1">
        <div class="label">Id</div>
        <div class="label">Brand</div>
        <div class="label">Model</div>
        <div class="label">Price</div>
        <div class="label">Color</div>
        <div class="label">Action</div>
    </div>
    <div>
        <c:forEach  items="${CarList}" var ="car">
            <div class="wrapper2">
                <div class="text">${car.id}</div>
                <div class="text">${car.brand}</div>
                <div class="text">${car.model}</div>
                <div class="text">${car.prise}</div>
                <div class="text">${car.color}</div>
                <div class="text">
                    <a type="button", class="btnAction", href="/car/${car.id}">Detail</a>
                    <a type="button", class="btnAction", href="/car/delete/${car.id}">Delete</a>
                </div>
            </div>
        </c:forEach>
    </div>
</form>

<div class="goBack" >
    <button class="btn" onclick="location.href='/'">Go back</button >
</div >

<form action = "/car/create" method = "post" >
    <div class="createWr1" >
        <h2> Add new car</h2>
    </div>
    <div class="createWr2" >
        <div class="label" > Brand </div >
        <div class="label" > Model </div >
        <div class="label" > Price </div >
        <div class="label" > Color </div >
    </div >
    <div class="createWr3" >
        <div class="space" ><input type = "text" name = "brand" required ></div >
        <div class="space" ><input type = "text" name = "model" required ></div >
        <div class="space" ><input type = "text" name = "prise" required pattern="^[ 0-9]+$" ></div >
        <div class="space" ><input type = "text" name = "color" required ></div >
    </div >

    <div class="forSubmit" >
        <button type = "submit" class="btn" > Submit </button >
    </div >
</form>
</body>
</html>
