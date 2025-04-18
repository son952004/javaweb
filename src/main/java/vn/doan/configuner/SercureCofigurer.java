package vn.doan.configuner;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import vn.doan.service.UserDetailsServiceJw;

@Configuration
@EnableWebSecurity
public class SercureCofigurer extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()// bat cac request
		//cho phep truy cap vao cac trang k can rang buoc login
		.antMatchers("/frontend/**", "/backend/**", "/UploadFiles/**", "/login", "/logout").permitAll()
		// request /admin o dau phai dag nhap login
		.antMatchers("/admin/**").authenticated()
		
		//cac request kieu /admin/.. phai co role admin
		.antMatchers("/admin/**").hasAuthority("ADMIN")// trong data base role cung phai la ADMIN
		
		.and()
		//chua login thi request den trang login
		.formLogin().loginPage("/login").loginProcessingUrl("/login_processing_url")
		
		//.defaultSuccessUrl("/admin/home/view", true)// login thanh cong den home
		
		//login thanh cong : den request phu hop voi role
		.successHandler(new AuthenticationSuccessHandlerImp())
		
		// login khong  thanh cog
		.failureUrl("/login?login_error=true")
		
		.and()
		//cau hinh logout
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login")// bắt url roi out tai khoan va chuyen ve login 
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.and()
		//luu session login
		.rememberMe().key(null).tokenValiditySeconds(86400);//
	}
	@Autowired
	private UserDetailsServiceJw userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(
				// ma hoa 4 bit password
				new BCryptPasswordEncoder(4));
	}
//	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder(4).encode("952004"));
//		
//	}
}
