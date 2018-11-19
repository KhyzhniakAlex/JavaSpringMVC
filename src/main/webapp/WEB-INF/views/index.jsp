<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CarsList</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            //border: 1px solid red;
        }

        .wrapper1 {
            display: grid;
            width: 60%;
            margin: auto;
            grid-template-columns: repeat(5, 1fr);
            align-content: center;
            padding-top: 2%;
        }

        .label {
            padding: 10px;
            text-align: center;
            font-size: 18px;
            border: 1px solid grey;
            background-color: black;
            color: white;
        }

        .wrapper2 {
            display: grid;
            grid-template-columns: repeat(5, 1fr);
            align-content: center;
            width: 60%;
            margin: auto;
        }

        .text {
            padding: 10px;
            text-align: center;
            font-size: 18px;
            border: 1px solid black;
            background-color: grey;
            color: black;
        }

        .goBack {
            margin-top: 2%;
            text-align: center;
        }

        .btn {
            font-size: 15px;
            padding: 5px;
        }
    </style>
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
        <div>
                <div class="wrapper2">
                    <div class="text">${car.id}</div>
                    <div class="text">${car.brand}</div>
                    <div class="text">${car.model}</div>
                    <div class="text">${car.prise}</div>
                    <div class="text">${car.color}</div>
                </div>
        </div>
    </form>

    <div class="goBack" >
        <button class="btn" >Go back</button >
    </div >
</body>
</html>
