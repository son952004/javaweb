<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- muốn dùng phải khai báo directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link rel="stylesheet" href="${root}/frontend/css/rodri.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="head">
        <div class="head1" >
            <p>Track My Order</p>
            <p>INT/£</p>
            <p><a href="/login">Login<span class="icon"><i class="fa-solid fa-user"></i></span></a></p>
        </div>
        <!-- end head1 -->

        <div class="head2 shop">
            <div class="head2_left1">
                <ul><img src="${root}/frontend/player/logo.jpg">
                    <li>KITS</li>
                    <li class="shop"><a href="${root}/frontend/#">SHOP BY PLAYER</a></li>
                    <li>TRAINING</li>
                    <li>LIFESTYLE</li>
                    <li>GIFTS</li>
                    <li>SALE</li>
                </ul>
            </div>
            <!-- end head2_left1 -->

            <div class="head2_right">
             
                
                <!-- cart -->
                <div class="cart-container">
                	<a href="/cart-view"><i class="fas fa-shopping-cart cart-icon"></i>
                	<span class="cart-count">${totalCartProducts }</span></a>
                </div>
            </div>
        </div>
        <!-- end head2 -->

    </div>
    <!-- end head all -->
    

    <div class="content">
        <div class="content1">
            <div class="content1_discount">
                <p>HOME KIT :GET 40% OFF</p>
            </div>
            <!-- end content_discount -->

            <img src="${root}/frontend/player/rodri1.png" width="100%">
            <!-- end banner -->
            <!-- coppy -->


            <div class="list">
                <ul>
                    <li>Home -</li>
                    <li>Shop by player -</li>
                    <li>Men's team -</li>
                    <li>Forwards -</li>
                    <li><b>Erling Haaland</b></li>
                </ul>
            </div>
            <div class="after_list">
                <ul>
                    <li>FILTER</li>
                    <li>SORT</li>
                </ul>
            </div>
            <div class="img">
            	<c:forEach var="product" items="${products }" varStatus="loop">
            	
               		<div class="content2_item1_content1">
                    	<a href="${root}/player/pl/${product.id}">
                    	<img src="${root}/UploadFiles/${product.avatar }">
                    	<p>${product.name}<br><br><b>£ <fmt:formatNumber
															value="${product.price }" minFractionDigits="0">
														</fmt:formatNumber></b></p></a>
                	</div>
                	<!-- end content1 -->
                </c:forEach>
            </div>
    </div>
    <div class="fotter">
        <div class="fotter_head">
            <img src="${root}/frontend/player/img19jpg.jpg" alt="">
        </div>
        <div class="fotter_body">
            
                <h3>FAQ & CONTACT</h3>
                <h3>DELIVERY & SHIPPING</h3>
                <h3>TRACK MY ORDER</h3>
        </div>
        <div class="fotter_end">
            <ul>
                <li>Terms & Conditions</li>
                <li> Privacy</li>
                <li>About Us</li>
                <li>Cookie Policy</li>
                <li>Return Policy</li>
            </ul>
            <img src="${root}/frontend/player/img20.jpg" alt="">
        </div>
    </div>
</body>
</html>