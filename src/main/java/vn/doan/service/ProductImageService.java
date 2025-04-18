package vn.doan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.doan.model.Category;
import vn.doan.model.Product;
import vn.doan.model.ProductImage;

@Service
public class ProductImageService extends BaseService<ProductImage>{

	@Override
	public Class<ProductImage> clazz() {
		// TODO Auto-generated method stub
		return ProductImage.class;
	}
	
	@Transactional
	public void deteleImagesByProductId(int productId) {
		String sql =" DETELE * FROM tbl_product_image WHERE product_id = "+productId;
		super.executeNativeSql(sql);
	}
	
	
	public List<ProductImage> getImagesByProductId(int productId) {
		String sql =" SELECT * FROM tbl_product_image WHERE product_id = "+productId;
		return super.executeNativeSql(sql);
		
	}
}
