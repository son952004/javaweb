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
    <title>${title }</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${root}/frontend/css/halland.css">
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
                
                <!-- cart -->
                <div class="cart-container">
                	<a href="/cart-view"><i class="fas fa-shopping-cart cart-icon"></i>
                	<span class="cart-count" id="totalCartProducts">${totalCartProducts }</span></a>
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
            <div class="content2">
                
                <div class="left">
                    <img id="current-image" src="" alt="Ảnh 1">
                </div>

                <div class="right">
                    <ul>
                        <li>SHOP BY PLAYER ></li>
                        <li>FORWARDS ></li>
                        <li>ERLING HAALAND </li>
                    </ul><br>
                    <h1>${product.name}</h1><br><b> <fmt:formatNumber
															value="${product.price }" minFractionDigits="0">
														</fmt:formatNumber>
												</b><span class="sale">- ${product.salePrice }</span><br>
                    <h3><b>SELECT PLAYER</b></h3><br>
                    <div class="select">9.Erling Haaland</div>
                    <h3><b>SELECT FONT</b></h3>
                    <div class="font">
                        <h4>PREMIER LEAGUE</h4>
                        <h4>MAN CITY</h4>
                    </div>
                    <button type="button" onclick="addToCart(${product.id} ,1 ,'${product.name}')"> <b>ADD TO CARK</b></button>
                    
                    <p>+ Returns This custom printed item cannot be returned.</p>
                    <p>+ Customisation shipping Estimated dispatch within 4 business days.</p>
                    <p>+ Customisation shipping Official Premier League printing.</p><br><br>
                    <p>With the Manchester City 2023/24 Home Kit, we celebrate the 20th anniversary of City at the Etihad Stadium and all those who call it home. Inspired by the stadium walkways and the jersey worn during the inaugural season. Featuring the club crest and PUMA Cat logo on the chest. Designed with a modern V-neck and executed in a sophisticated classic short sleevefor kids'. Details include the words CITY embroided in the back of the neck and the Etihad stadium print inside the neckline. Be at home with the 2023/24 season's Man City Home jersey.</p>
                </div>
            </div>
        </div>
    </div>
  
	           
    <div class="fotter">
        <div class="fotter_head">
            <img src="${root }/frontend/img/player/itemPlayer/19jpg.jpg" alt="">
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
            <img src="${root }/frontend/img/player/itemPlayer/img20.jpg" alt="">
        </div>
    </div>  <script>
    $(document).ready(function() {
        // Tạo mảng images từ dữ liệu JSP
        const images = [
            <c:forEach var="productImages" items="${images}" varStatus="loop">
                "<c:out value="${root}/UploadFiles/${productImages.path}" />"
                <c:if test="${!loop.last}">,</c:if>
            </c:forEach>
        ];

        // Đảm bảo ảnh đầu tiên được hiển thị ngay khi tải trang
        $('#current-image').attr('src', images[0]);

        let currentIndex = 0; // Chỉ số của ảnh hiện tại

        // Hàm cập nhật ảnh và số thứ tự ảnh
        function updateImage() {
            $('#current-image').fadeOut(500, function() {
                $(this).attr('src', images[currentIndex]).fadeIn(500);
            });
        }

        // Tự động lướt qua ảnh mỗi 3 giây
        setInterval(function() {
            currentIndex = (currentIndex + 1) % images.length;
            updateImage();
        }, 3000);
    });
	</script>
	
	<!-- Add to cart -->
	<script type="text/javascript">
		addToCart = function(_productId, _quantity, _productName) {		
			let data = {
				id: _productId, //lay theo id
				quantity: _quantity,
				name: _productName,
			};
				
			//$ === jQuery
			jQuery.ajax({
				url : "/add-to-cart",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json
				
				success : function(jsonResult) {
					$("#totalCartProducts").html(jsonResult.totalCartProducts);
				},
				
				
				error : function(jqXhr, textStatus, errorMessage) {
					alert(jsonResult.code + ': Đã có lỗi xay ra...!')
				},
			});
		}
	</script>
</body>
</html>