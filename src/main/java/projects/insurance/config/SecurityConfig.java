//package projects.insurance.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  private final UserDetailsService userDetailsService;
//
//  private final OAuth2UserAuthSuccessHandler oAuth2UserAuthSuccessHandler;
//
//  private final PasswordEncoder passwordEncoder;
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//

//    http
//        .authorizeRequests()
//        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//        .antMatchers("/index", "/login-form**", "/register-form**").permitAll()
//        .antMatchers("/**").authenticated()
//
//        .and().formLogin()
//          .loginPage("/login")
//          .loginProcessingUrl("/login/authenticate")
//          .failureForwardUrl("/login-error")
//          .successForwardUrl("/home")
//
//        .and().logout()
//          .logoutUrl("/logout")
//          .logoutSuccessUrl("/login")
//          .invalidateHttpSession(true)
//          .and().oauth2Login()
//          .loginPage("/login")
//          .successHandler(oAuth2UserAuthSuccessHandler);
//
//  }
//
//  @Autowired
//  public void configureGlobal(AuthenticationManagerBuilder auth)
//      throws Exception {
//    auth.userDetailsService(userDetailsService).passwordEncoder(
//        passwordEncoder);
//  }
//}
