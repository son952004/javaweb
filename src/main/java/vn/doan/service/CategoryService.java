package vn.doan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.doan.model.Category;


@Service
public class CategoryService extends BaseService<Category>{

	@Override
	public Class<Category> clazz() {
		// TODO Auto-generated method stub
		return Category.class;
	}
	
	public List<Category> findActive() {
		String sql =" SELECT * FROM tbl_category WHERE status = 1";
		return super.executeNativeSql(sql);
		
	}
}
