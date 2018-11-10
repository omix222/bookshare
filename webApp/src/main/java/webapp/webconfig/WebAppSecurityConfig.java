package webapp.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**","/css/**","/fonts/**","/html/**","/images/**","/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //
			.antMatchers("/login").permitAll() // ログイン画面
			.anyRequest().authenticated(); // その他の全リクエストに対して認証を要求
		http.formLogin() //
			.loginPage("/login").usernameParameter("user").passwordParameter("password") // ログイン画面
			.successForwardUrl("/stocklist") // ログイン成功時に表示するURL
			.permitAll();
		http.logout() //
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // logoutUrl()はPOSTに対応していない
			.logoutSuccessUrl("/login") // ログアウト成功時に表示するURL
			.deleteCookies("JSESSIONID").invalidateHttpSession(true).permitAll();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
