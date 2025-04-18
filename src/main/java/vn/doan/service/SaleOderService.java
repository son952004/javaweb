package vn.doan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import vn.doan.model.Category;
import vn.doan.model.SaleOder;

@Service
public class SaleOderService extends BaseService<SaleOder> {

	@Override
	public Class<SaleOder> clazz() {
		// TODO Auto-generated method stub
		return SaleOder.class;
	}
	
	public List<SaleOder> findActive() {
		String sql =" SELECT * FROM tbl_sale_oder WHERE status = 1";
		return super.executeNativeSql(sql);
	}
	@Transactional
	public SaleOder saveSaleOder(SaleOder save) {		
		return saveOrUpdate(save);
	} 
}

