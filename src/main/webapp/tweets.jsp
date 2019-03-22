<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tweetcool</title>
    <link href="style.css" rel="stylesheet">
</head>

<body>

    <header>
        <a href="index.html"><h1>Tweetcool</h1></a>
    </header>

    <nav>
        <ul>
            <a href="index.html"><li>New tweet</li></a>
            <a href="filter"><li>See tweets</li></a>
        </ul>
    </nav>

    <form action="filter" method="POST">
        Limit:
        <select id="limit" name="limit">
            <option value="10" selected>10</option>
            <option value="20">20</option>
            <option value="30">30</option>
            <option value="40">40</option>
        </select>
        <br>
        Offset:
        <select id="offset" name="offset">
            <option value="0" selected>0</option>
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
        </select>
        <br>
        Poster:
        <input type="text" name="poster">
        <br>
        Date:
        <input type="datetime-local" name="date" />
        <br>
        <p><input type="submit" value="Filter tweets"></p>
    </form>

    <c:forEach var="tweet" items="${tweetList}">
        <div class="tweetbox">
        <div class="tweettext">
        <c:out value="${tweet.getName()}"/> : <c:out value="${tweet.getTweet()}"/><br>
        </div>
        <c:out value="${tweet.getTimestamp()}"/><br>
        </div>
        <br>
    </c:forEach>


</body>
</html>
