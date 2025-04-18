package vn.doan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.doan.model.SaleOderProduct;

@Service
public class SaleOderProductService extends BaseService<SaleOderProduct> {

	@Override
	public Class<SaleOderProduct> clazz() {
		// TODO Auto-generated method stub
		return SaleOderProduct.class;
	}
	
	public List<SaleOderProduct> findActive() {
		String sql =" SELECT * FROM tbl_sale_oder_product WHERE status = 1";
		return super.executeNativeSql(sql);
		
	}

}

