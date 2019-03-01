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

    /**
     * configures the security of the website
     * defines whitch HTML files that are allowed for users who are not logged in, user who are logged in
     * ass applicant, and users who are logged in as recruit
     * Defines the login page for the framework to handle log in
     * @param http and object of Security Builder
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                headers()
                    .frameOptions().disable()
                    .and()
                .authorizeRequests()
                    .antMatchers("/admin/**").hasAuthority("recruit")
                    .antMatchers("/app/**").hasAuthority("recruit")
                    .antMatchers("/user/**").hasAnyAuthority("recruit", "applicant")
                    .antMatchers("/pub/**").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/console/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/pub/login").permitAll()
                    .failureUrl("/pub/login?error=f").permitAll()
                    .defaultSuccessUrl("/pub/home")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                .logout()
                .logoutSuccessUrl("/pub/login")
                    .permitAll()
                    .and()
                .csrf().disable();
    }

    /**
     * Creates a password encoder
     * @return password encoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Defines which class that handles the login of a user
     * Defines which encoder to be used in the framework
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(loginService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    /**
     * Configures the authentication parameters and resources for the Spring Security Framework
     * @param auth - Security Builder object
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
