<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CountryList</title>
    <link href="../../resources/countryAllstyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
<form action="/country" method="get">
    <div class="wrapper1">
        <div class="label">Id</div>
        <div class="label">Name</div>
        <div class="label">Region</div>
        <div class="label">Population</div>
        <div class="label">Action</div>
    </div>
    <div>
        <c:forEach  items="${CountryList}" var ="country">
            <div class="wrapper2">
                <div class="text">${country.id}</div>
                <div class="text">${country.name}</div>
                <div class="text">${country.region}</div>
                <div class="text">${country.population}</div>
                <div class="text">
                    <a type="button", class="btnAction", href="/country/${country.id}">Detail</a>
                    <a type="button", class="btnAction", href="/country/delete/${country.id}">Delete</a>
                </div>
            </div>
        </c:forEach>
    </div>
</form>

<div class="goBack" >
    <button class="btn" onclick="location.href='/'">Go back</button >
</div >

<form action = "/country/create" method = "post" >
    <div class="createWr1" >
        <h2> Add new country</h2>
    </div>
    <div class="createWr2" >
        <div class="label" > Name </div >
        <div class="label" > Region </div >
        <div class="label" > Population </div >
    </div >
    <div class="createWr3" >
        <div class="space" ><input type = "text" name = "name" required ></div >
        <div class="space" ><input type = "text" name = "region" required ></div >
        <div class="space" ><input type = "text" name = "population" required pattern="^[ 0-9]+$" ></div >
    </div >

    <div class="forSubmit" >
        <button type = "submit" class="btn" > Submit </button >
    </div >
</form>
</body>
</html>
