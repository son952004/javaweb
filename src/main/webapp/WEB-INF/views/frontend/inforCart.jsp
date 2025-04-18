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
    <link rel="stylesheet" href="${root}/frontend/css/inforUserCart.css">
    <link rel="stylesheet" href="${root}/frontend/layout/css/css.jsp">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<c:if test="${sessionScope.user == null}">
    <%
        response.sendRedirect("/login");
    %>
	</c:if>
	<c:if test="${sessionScope.user != null}">
    <div class="head">
        <img src="${root }/frontend/player/itemPlayer/logo.jpg">
    </div>
    <!-- end head all -->
    <div class="content">

        <div class="title">
            <h1>Thông tin khách hàng</h1>
        </div>
        <div class="thongtin">
            <div class="thongtin1">
                <div class="contain1"><label for="name">Customer name(*) :</label></div>
                <div class="contain2"><input type="text" class="form-control" id="txtName"
                name="txtName" placeholder="your name" value="${loginedUser.name }" ></div>
            </div>
            <div class="thongtin1">
                <div class="contain1"><label for="mobile">Customer mobile(*) :</label> </div>
                <div class="contain2"><input type="text" class="form-control" id="txtMobile"
                name="txtMobile" placeholder="your phone number" value="${loginedUser.mobile }"></div>
            </div>
            <div class="thongtin1">
                <div class="contain1"><label for="phone">Customer email :</label> </div>
                <div class="contain2"><input type="email" class="form-control" id="txtEmail" 
                name="txtEmail" placeholder="your email" value="${loginedUser.email }" ></div>
            </div>
            <div class="thongtin1">
                <div class="contain1"><label for="phone">Customer address :</label></div>
                <div class="contain2"><input type="text" class="form-control" id="txtAddress"
                 name="txtAddress" placeholder="your address" value="${loginedUser.address }" ></div>
            </div>
            <div class="thongtin1 thongtin4">
                <button class="btn btn-primary" onclick="_placeOrder()">
                Place orders</button>
            </div>
            <p>( * k được để trống! )</p>
        </div>
        <a href="{root}/MCI_Home.jsp"><b>< BACK TO SHOPPING</b></a>
    </div>
    <!-- end content -->
    <div class="fotter">
    </div>
   <script type="text/javascript">
        function _placeOrder() {
            //javascript object
            let data = {                
                ctName : jQuery("#txtName").val(),
                ctEmail : jQuery("#txtEmail").val(), //Get by Id
                ctMobile : jQuery("#txtMobile").val(),
                ctAdress : jQuery("#txtAddress").val(),
            };
            
            //$ === jQuery
            jQuery.ajax({
                url : "/place-order",
                type : "POST",
                contentType: "application/json",
                data : JSON.stringify(data),
                dataType : "json", //Kieu du lieu tra ve tu controller la json
                
                success : function(jsonResult) {
                    alert(jsonResult.code + ": " + jsonResult.message);
                    //$("#placeOrderSuccess").html(jsonResult.message);
                },
                
                error : function(jqXhr, textStatus, errorMessage) {
                    alert("An error occur");
                }
            });
        }
    </script>
    </c:if>       
</body>
</html>