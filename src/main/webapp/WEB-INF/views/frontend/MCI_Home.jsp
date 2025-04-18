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
    <link rel="stylesheet" href="${root}/frontend/css/MCI_Home.css">
    <link rel="stylesheet" href="${root}/frontend/layout/css/css.jsp">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="head">
        <div class="head1" >
            <p>Track My Order</p>
            <p>INT/£</p>
            <c:if test="${sessionScope.user == null}">
            <p><a href="/login">Login<span class="icon"><i class="fa-solid fa-user"></i></span></a></p>
			</c:if>
			<c:if test="${sessionScope.user != null}">
            <p><a href="/login">Hi Guest!<span class="icon"><i class="fa-solid fa-user"></i></span></a></p>
            </c:if>
        </div>
        <!-- end head1 -->

        <div class="head2 shop">
            <div class="head2_left1">
                <ul><img src="${root}/frontend/img/logo.jpg">
                    <li>KITS</li>
                    <li class="shop"><a href="${root}/frontend/rodri.html">SHOP BY PLAYER</a></li>
                    <li>TRAINING</li>
                    <li>LIFESTYLE</li>
                    <li>GIFTS</li>
                    <li>SALE</li>
                </ul>
            </div>
            <!-- end head2_left1 -->

            <div class="head2_right">
                  
                <%--<form><span><i class="fa-solid fa-magnifying-glass kinhnup"></i></span>
                    <input type="text" placeholder="Search">
                </form>--%>
                
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

            <div><img src="${root}/frontend/img/img1.jpg" width="100%"></div>
            <!-- end banner -->

            <div class="content1_p">
                <h2>HOME KIT SALE</h2>
                <p>Get 40% off on all home kit items, including printing</p>
                <p>SHOP NOW</p>
            </div>
            <!-- end content1 p -->

        </div>
        <!-- end content1 -->

        <div class="content2">
               <h1>OUR TOP PICKS</h1>
            <!-- end title -->

            <div class="content2_item1_content">
                <div class="content2_item1_content1">
                    <a href="/home/rodri"><p>-40%</p><br>
                    <img src="${root}/frontend/img/img2_170_245.jpg" alt="">
                    <p>Kids' Manchester City Home Jersey 2023/24<br><br><b>Â£ 36,00</b></p>
                    </a>
                </div>
                <!-- end content1 -->

                <div class="content2_item1_content1">
                    <a href="/home/rodri"><p>-40%</p><br>
                    <img src="${root}/frontend/img/img3.jpg" alt="">
                    <p>Kids' Manchester City Home Jersey 2023/24 with HAALAND 9 printing <br><br><b>Â£ 76,00 </b></p></a>
                </div>
                <!-- end content2 -->

                <div class="content2_item1_content1">
                    <a href="/home/rodri"><p>-40%</p><br>
                    <img src="${root}/frontend/img/img3_177_245.jpg" alt="">
                    <p>Manchester City Authentic Home Jersey 2023/24 In Gift Box<br><br><b>Â£ 76,00</b></p></a>
                </div>
                <!-- end content3 -->

                <div class="content2_item1_content1">
                    <a href="/home/rodri"><p>-40%</p><br>
                    <img src="${root}/frontend/img/img4.jpg" alt="">
                    <p>Kids' Manchester City Home Jersey 2023/24<br><br><b>Â£ 36,00</b></p></a>
                </div>
                <!-- end content4 -->
            </div>
            <!-- end content2_item1_content -->
        </div>
        <!-- end content2 -->

        <div class="content2">
            <h1>SHOP BY PLAYER</h1>
            <div class="content2_container">
                <div class="content2_container1"><a href="/home/rodri"><img src="${root}/frontend/img/imghalland.jpg" ><h3>#9HaaLand</h3></a></div>
                <div class="content2_container1"><a href="/home/rodri"><img src="${root}/frontend/img/img5.jpg" ><h3>#17DeBrune</h3></a></div>
                <div class="content2_container1"><a href="/home/rodri"><img src="${root}/frontend/img/img6.jpg" ><h3>#47Foden</h3></a></div>
                <div class="content2_container1"><a href="/home/rodri"><img src="${root}/frontend/img/img5.jpg" ><h3>#17DeBrune</h3></a></div>
                <div class="content2_container1"><a href="/home/rodri"><img src="${root}/frontend/img/img7.jpg" ><h3>#10Grealish</h3></a></div>
            </div>
            <div class="content2_container2">
                <div class="content2_container22"><a href="/home/rodri"><img src="${root}/frontend/img/img8.jpg" alt=""><h3>Away Kit: Get 20% Off</h3></a></div>
                <div class="content2_container22"><a href="/home/rodri"><img src="${root}/frontend/img/img9.jpg" alt=""><h3>Training Gear: 30% Off</h3></a></div>
            </div>
            <div class="content2_container3">
                <div class="content2_container33"><a href="/home/rodri"><img src="${root}/frontend/img/img10.jpg"><h3>Home Kit</h3></a></div>
                <div class="content2_container33"><a href="/home/rodri"><img src="${root}/frontend/img/img11.pg.jpg"><h3>Away Kit</h3></a></div>
                <div class="content2_container33"><a href="/home/rodri"><img src="${root}/frontend/img/kavin.jpg"><h3>Third Kit</h3></a></div>
                <div class="content2_container33"><a href="/home/rodri"><img src="${root}/frontend/img/eson.jpg"><h3>Goalkeeper Kits</h3></a></div>
                
            </div>
        </div>
        <!-- end content3 -->
    </div>
    <!-- end content -->
    <div class="fotter">
        <div class="fotter_head">
            <img src="${root}/frontend/img/img19jpg.jpg" alt="">
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
            <img src="${root}/frontend/img/img20.jpg" alt="">
        </div>
    </div>
</body>
</html>