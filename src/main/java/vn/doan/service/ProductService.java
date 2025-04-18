package vn.doan.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



import vn.doan.dto.JW31;
import vn.doan.dto.SearchModel;
import vn.doan.model.Category;
import vn.doan.model.Product;
import vn.doan.model.ProductImage;

@Service
public class ProductService extends BaseService<Product> implements JW31{

	@Override
	public Class<Product> clazz() {
		// TODO Auto-generated method stub
		return Product.class;
	}
	
	public List<Product> findActive() {
		String sql =" SELECT * FROM tbl_product WHERE status = 1";
		return super.executeNativeSql(sql);
		
	}
	
	public List<Product> findSearch(int status, int categoryId, String keyword) {
		String sql =" SELECT * FROM tbl_product p WHERE 1 = 1";
		if(status != 2) sql +=" AND p.status = "+status ;
		if(categoryId > 0) sql +=" AND p.category_id = " +categoryId;
		if(keyword != null) sql += " AND (LOWER(p.name) LIKE '%" + keyword.toLowerCase() + "%' " +
		           "OR LOWER(p.status) LIKE '%" + keyword.toLowerCase() + "%')";
		return super.executeNativeSql(sql);
		
	}
	

	
	//Kiem tra file co ton tai hay khong?
		public boolean isExistFile(MultipartFile file) {
			if (file != null && !StringUtils.isEmpty(file.getOriginalFilename())) {
				return true;
			}
			return false;
			
		}
		
		//Kiem tra file co ton tai hay khong?
			public boolean isExistFiles(MultipartFile[] files) {
				if (files != null && files.length > 0) {
					return true;
				}
				return false;
				
			}
			
			@Transactional
			public Product saveEditProduct(Product product, MultipartFile avatarFile,
					MultipartFile[] imageFiles) throws IOException {
				
				//Kiem tra xem co upload avatar khong?
				if (isExistFile(avatarFile)) {//co upload
					
					// kiem tra xem co avtta cu khong
					
						//co thi phai xoa cai cu
						String path = FOLDER_UPLOAD + "Product/Avatar/" 
								+ avatarFile.getOriginalFilename();
						File file = new File(path);
						avatarFile.transferTo(file);
					
					product.setavatar("Product/Avatar/" + avatarFile.getOriginalFilename());
					
				}
				
				//Kiem tra xem co upload images khong?
				if (isExistFiles(imageFiles)) {//Co upload
					for (MultipartFile image : imageFiles) {
						if (isExistFile(image)) {
							//Luu file vao thu muc Product/Image
							String path = FOLDER_UPLOAD + "Product/Image/" 
									+ image.getOriginalFilename();
					
							File file = new File(path);
							image.transferTo(file);
							//Luu duong dan vao bang tbl_product_image
							ProductImage productImage = new ProductImage();
							productImage.setPath("Product/Image/" + image.getOriginalFilename());//cho nó vào thư mục product ở upload file
							productImage.setTitle(image.getOriginalFilename());
							productImage.setCreateDate(new Date());
							productImage.setStatus(true);
							productImage.setProduct(product);
							product.addRelationalProductImage(productImage);
						}
					}
				}
				if(product.getPrice()== null)product.setPrice(BigDecimal.ZERO);
				if(product.getSalePrice()== null)product.setSalePrice(BigDecimal.ZERO);
				return saveOrUpdate(product);
			}
		
		@Transactional
		public Product saveProduct(Product product, MultipartFile avatarFile,
				MultipartFile[] imageFiles) throws IOException {
			
			//Kiem tra xem co upload avatar khong?
			if (isExistFile(avatarFile)) {//co upload
				
				// kiem tra xem co avtta cu khong
				if(product.getavatar() != null && !StringUtils.isEmpty(product.getavatar())) {
					//co thi phai xoa cai cu
					String path = FOLDER_UPLOAD + product.getavatar();
					File file = new File(path);
					file.delete();
					
				}
				product.setavatar("Product/Avatar/" + avatarFile.getOriginalFilename());
				//Luu file vao thu muc Product/Avatar
				String path = FOLDER_UPLOAD + "Product/Avatar/" 
								+ avatarFile.getOriginalFilename();
				
				File file = new File(path);
				avatarFile.transferTo(file);
				
		
			}
			
			//Kiem tra xem co upload images khong?
			if (isExistFiles(imageFiles)) {//Co upload
				for (MultipartFile image : imageFiles) {
					if (isExistFile(image)) {
						//Luu file vao thu muc Product/Image
						String path = FOLDER_UPLOAD + "Product/Image/" 
								+ image.getOriginalFilename();
				
						File file = new File(path);
						image.transferTo(file);
						//Luu duong dan vao bang tbl_product_image
						ProductImage productImage = new ProductImage();
						productImage.setPath("Product/Image/" + image.getOriginalFilename());//cho nó vào thư mục product ở upload file
						productImage.setTitle(image.getOriginalFilename());
						productImage.setCreateDate(new Date());
						productImage.setStatus(true);
						productImage.setProduct(product);
						product.addRelationalProductImage(productImage);
					}
				}
			}
			if(product.getPrice()== null)product.setPrice(BigDecimal.ZERO);
			if(product.getSalePrice()== null)product.setSalePrice(BigDecimal.ZERO);
			return saveOrUpdate(product);
		}

}
