package vn.doan.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.doan.model.User;

@Service
public class UserDetailsServiceJw extends BaseService<User> implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		String sql = "SELECT * FROM tbl_user u WHERE u.username='"+username+"' and u.status=1 ";
		User user = this.getEntityByNativeSQL(sql);
		if(user != null) {
			return user;
		}
		else return new User();
		
	}

	@Override
	public Class<User> clazz() {
		// TODO Auto-generated method stub
		return User.class;
	}

}
