<!-- JSTL directive -->



<!--  thay dấu "." file bằng  ${root }/fontend (tên thư mục cần đang trỏ)
// còn link trực tiếp thì k canf thay--> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root"  value="${pageContext.servletContext.contextPath}"></c:set>