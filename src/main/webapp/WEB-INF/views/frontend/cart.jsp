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
    <title>Document</title>	
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${root}/frontend/css/cart.css">
    <link rel="stylesheet" href="${root}/frontend/layout/css/css.jsp">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
    <div class="head">
        <div class="head1" >
            <p>Track My Order</p>
            <p>INT/£</p>
        </div>
        <!-- end head1 -->

        <div class="head2 shop">
            <div class="head2_left1">
                <ul><img src="${root }/frontend/player/itemPlayer/logo.jpg">
                    <li>KITS</li>
                    <li class="shop"><a href="#">SHOP BY PLAYER</a></li>
                    <li>TRAINING</li>
                    <li>LIFESTYLE</li>
                    <li>GIFTS</li>
                    <li>SALE</li>
                </ul>
            </div>
            <!-- end head2_left1 -->

            <div class="head2_right">
          
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
            <div class="content2">
                <div class="content2_left">
                	<h2>Your Cart</h2>
<!-- forech -->
					<c:forEach var="cartProduct" items="${cart.cartProducts }" varStatus="loop">
					<c:if test="${cartProduct.quantity > 0}">
                	<div class="content2_left_product">
                		<img src="${root}/UploadFiles/${cartProduct.avatar}">
                		<div class="product_left">
                			<div class="quantity-container">

    
                                <button type="button" onclick="updateProductQuantity(${cartProduct.id} ,-1)"> <b>-</b></button> 
                                <strong><span id="productQuantity_${cartProduct.id}">${cartProduct.quantity}</span></strong>
                                <button type="button" onclick="updateProductQuantity(${cartProduct.id} ,1)"> <b>+</b></button>
                            </div>
                			<p><b>${cartProduct.name}</b></p>
                			<p>Size:</p>
                			<p>Sale : ${cartProduct.saleCurrency() }</p>
                			<p><b>Price :  &nbsp; <fmt:formatNumber value="${cartProduct.price}" 
                			minFractionDigits="0"></fmt:formatNumber></b> vnd</p>  
                			<p class="delete"><a href="${root}/cart-view/delete/${loop.index }"
                			 role="button" class="btn btn-secondary">&#10006;</a></p>                        
                		</div>
                	</div>
                	</c:if>               	
   					<c:if test="${cartProduct.quantity <= 0}"></c:if>
   					</c:forEach>	
<!-- end forech content left--> 
                </div>              
                <div class="content2_right">
                	<h2>ToTal</h2>
                	<div class="contact_price">
                		<div class="price">
                			<p>Total Price </p> 

                			<h3 id="totalPriceNoSale">£ <fmt:formatNumber  
                			minFractionDigits="0">${cart.totalPriceNoSale()}</fmt:formatNumber></h3>
                		</div>
                		<div class="price">
                			<p>Discout </p>
                			<h3 id="sale">- £ <fmt:formatNumber value="${cart.totalSale()}" 
                			minFractionDigits="0"></fmt:formatNumber></h3>
                		</div>
                        <div class="price">
                            <p><b>Price</b></p>
                            <h3 id = "totalCartPriceId">£ <fmt:formatNumber value="${cart.totalPrice()}" 
                			minFractionDigits="0"></fmt:formatNumber></h3>
                        </div>
                        
                		<button type="button">
                				<a href="/cartct"><b>BUY NOW</b></a>
                		</button>
                		<button type="button"><a href="/home/rodri"><b>BACK TO SHOPPING</b></a></button>
                		<c:if test="${cart == null}">
                		<script>
    						alert("Chưa có món hàng nào!");
						</script>
                		</c:if>
                	</div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="fotter">
        <div class="fotter_head">
            <img src="${root }/frontend/player/itemPlayer/img19jpg.jpg" alt="">
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
            <img src="${root }/frontend/player/itemPlayer/img20.jpg" alt="">
        </div>
    </div>
    <script type="text/javascript">
    $(document).ready(function() {
        // Khai báo hàm updateProductQuantity
        window.updateProductQuantity = function(_productId, _quantity) {

            let data = { 
                id: _productId, 
                quantity: _quantity 
            };

            $.ajax({
                url: "/update-product-quantity",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(data),
                dataType: "json",
                success: function(jsonResult) {
                    $("#productQuantity_" + jsonResult.productId).html(jsonResult.newQuantity);
                    $("#totalCartPriceId").html(jsonResult.totalCartPrice);
                    $("#totalPriceNoSale").html(jsonResult.totalPriceNoSale);
                    $("#totalPrice_" + jsonResult.productId).html(jsonResult.totalPrice);
                    $("#totalCartProducts").html(jsonResult.totalCartProducts);
                    $("#sale").html(jsonResult.sale);
                },
                error: function() {
                    alert("An error occurred while updating the product quantity.");
                }
            });
        };
    });
    </script>
</body>

</html>
