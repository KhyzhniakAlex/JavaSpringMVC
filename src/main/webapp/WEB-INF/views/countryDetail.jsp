<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Country</title>
    <link href="../../resources/countryDetailStyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
<form action="/country/{id}" method="get">
    <div class="wrapper1">
        <div class="label">Id</div>
        <div class="label">Name</div>
        <div class="label">Region</div>
        <div class="label">Population</div>
    </div>
    <div class="wrapper2">
        <div class="text">${Country.id}</div>
        <div class="text">${Country.name}</div>
        <div class="text">${Country.region}</div>
        <div class="text">${Country.population}</div>
    </div>
</form>

<form action = "/country/update/${Country.id}" method = "post" >
    <div class="updateWr1" >
        <h2 > Update country</h2>
    </div >
    <div class="updateWr2" >
        <div class="label" > Name </div >
        <div class="label" > Region </div >
        <div class="label" > Population </div >
    </div >
    <div class="updateWr3" >
        <div class="space" ><input type = "text" name = "name" required ></div >
        <div class="space" ><input type = "text" name = "region" required ></div >
        <div class="space" ><input type = "text" name = "population" required pattern="^[ 0-9]+$" ></div >
    </div >

    <div class="forSubmit" >
        <button type = "submit" class="btn" > Submit </button >
    </div >
</form>

<div class="goBack" >
    <button class="btn" onclick="location.href='/country'">Go back</button >
</div >
</body>
</html>
