<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Car</title>
    <link href="../../resources/carDetailStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
<form action="/car/{id}" method="get">
    <div class="wrapper1">
        <div class="label">Id</div>
        <div class="label">Brand</div>
        <div class="label">Model</div>
        <div class="label">Price</div>
        <div class="label">Color</div>
    </div>
    <div class="wrapper2">
        <div class="text">${Car.id}</div>
        <div class="text">${Car.brand}</div>
        <div class="text">${Car.model}</div>
        <div class="text">${Car.prise}</div>
        <div class="text">${Car.color}</div>
    </div>
</form>

<form action = "/car/update/${Car.id}" method = "post" >
    <div class="updateWr1" >
        <h2 > Update car</h2>
    </div >
    <div class="updateWr2" >
        <div class="label" > Brand </div >
        <div class="label" > Model </div >
        <div class="label" > Price </div >
        <div class="label" > Color </div >
    </div >
    <div class="updateWr3" >
        <div class="space" ><input type = "text" name = "brand" required ></div >
        <div class="space" ><input type = "text" name = "model" required ></div >
        <div class="space" ><input type = "text" name = "prise" required pattern="^[ 0-9]+$" ></div >
        <div class="space" ><input type = "text" name = "color" required ></div >
    </div >

    <div class="forSubmit" >
        <button type = "submit" class="btn" > Submit </button >
    </div >
</form>

<div class="goBack" >
    <button class="btn" onclick="location.href='/car'">Go back</button >
</div >
</body>
</html>
