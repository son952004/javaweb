# Java Web Project - Spring Boot + Hibernate + MySQL

-Đây là một ứng dụng web sử dụng Java Spring Boot, Hibernate, và MySQL. Dự án này được xây dựng để quản lý và bán sản phẩm và thực hiện các thao tác cơ bản.

## 🛠 Công nghệ sử dụng

- **Java**: Phiên bản 11
- **Spring Boot**: Phiên bản 2.1.4.RELEASE
- **Hibernate**: Thông qua Spring Data JPA
- **Cơ sở dữ liệu**: MySQL
- **JSP**: JavaServer Pages cho giao diện người dùng
- **Maven**: Quản lý phụ thuộc và xây dựng dự án

## 📦 Các thư viện chính

- `spring-boot-starter-web`: Khởi tạo ứng dụng web với Spring MVC
- `spring-boot-starter-data-jpa`: Tích hợp Hibernate cho thao tác với cơ sở dữ liệu
- `mysql-connector-java`: Kết nối với MySQL
- `spring-boot-starter-security`: Bảo mật ứng dụng
- `jstl`: JavaServer Pages Standard Tag Library

## ⚙️ Cài đặt

- **Eclipse** : phiên bản 2018 trở lên
- **JDK** : phiên bản 11 trở lên
-**SQL WorkBen** : phiên bản 8.0 trở lên
  
## 📝 Hướng dẫn khởi chạy
- **Dowload Project**: tải các files trên về máy lưu vào 1 project.
- **Daata.sql**
+ B1 : Thực hiện cài đặt và tạo tài khoản cho sql.
 ⚠️ **Chú ý:** : *hostname*, *port*, *user* và *password* phải khớp với file *application* trong folder:
 📁 src
  └── 📁 resouce
      └── application.properties
+ B2 : Sau khi đăng nhập,thấy *góc bên trái* chọn *open sql script file* tìm file *daata.sql* đã lưu ,sau khi mở nhấn `Ctrl` + `Shift` + `Enter` để chạy chương trình.
+ B3 : Góc trái **Schemas** ấn refresh 🔄 và hiện ra data tạo sẵn.

-**Eclipse** 
+ B1 : *Góc trái* chọn file, bên dưới tìm *open projects from file*, trong đây ta thấy góc bên phải chọn *directory* chọn project đã lưu dự án và ấn finish.
+ B2 : 🖱️ Nhấp chuột phải vào `📁 project vừa tạo` ,tìm `Maven` chọn `Update Project`.


## 🚀 Chạy dự án
- B1 : Trong Eclipse vào dự án
 📁 Java Resources
  └── 📁 src/main/java
      └── 📁vn.doan
  * Mở `file StartSeverJavaWeb.java` trong packet `vn.doan`.
 - B2 : Click biểu tượng ▶️ màu xanh lá trên thanh công cụ, dưới tìm `RunAs` tìm `Java Application` hoặc giữ `Alt` + `Shift` + `x` > bấm `j`
 - B3 : Mở google truy cập `http://localhost:9090/home/view` hoặc trang admin : `http://localhost:9090/admin`
  ## 🔐 Tài khoản đăng nhập thử với trang admin

| Tài khoản | Mật khẩu   | Vai trò      |
|-----------|------------|--------------|
| doan ngoc son     | 952004     | Quản trị viên |


## ✍️ Tác giả

- **Tên:** Đoàn Ngọc Sơn  
- **Email:** [doanson3504@gmail.com](mailto:doanson3504@gmail.com)  
- **GitHub:** [@son952004](https://github.com/son952004)
