package FairGrounds.Config;


import FairGrounds.Application.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginService loginService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                headers()
                    .frameOptions().disable()
                    .and()
                .authorizeRequests()
                    .antMatchers("/admin/**").hasAuthority("ADMIN")
                    .antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER")
                    .antMatchers("/pub/**").permitAll()
                    .antMatchers("/console/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/pub/login").permitAll()
                    .failureUrl("/pub/login?error=f").permitAll()
                    .defaultSuccessUrl("/user/logintestUser")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(loginService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
