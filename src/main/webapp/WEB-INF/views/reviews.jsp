<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<mtt:mainlayout>
    <section style="padding-top: 1px;">
        <h1 style="color: #E1D070;text-align: center;margin-top: 3%;">Reviews</h1>
        <c:forEach var="review" items="${requestScope.reviews}">
        <div class="container1">
            <img src="/w3images/bandmember.jpg" alt="Avatar">
            <p>${review.reviewMessage}</p>
            <span class="time-left">${review.date}</span>
            <div style="position:absolute;bottom:0;right: 10px;">
                <c:forEach var = "i" begin = "1" end = "${review.star}">
                    <span class="fa fa-star checked"></span>
                </c:forEach>
                <c:forEach var = "i" begin = "1" end = "${5 - review.star}">
                    <span class="fa fa-star"></span>
                </c:forEach>
            </div>
        </div>
        </c:forEach>
        <form method="POST" action="reviews" >
        <input type="hidden" name="command" value="addNewReview" />
            <h2 style="color: #E1D070;text-align: center;margin-top: 3%;margin-bottom: 2%;">Add Your comment</h2>
            <label>
                <input id="reviewData" type="text" name="review" style="width: 400px;height: 200px;margin-left: 22%;border-radius: 6px; background: #383D50; color: #E1D070; opacity: 70%;">
            </label>
            <input type="hidden" name="star" value="1" />
          <input type="submit" class="bot1" value="Add review"/>
        </form>
    </section>
</mtt:mainlayout>
