package Restaurant.Restaurant.User.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/users/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .logout()
                .logoutUrl("/logout");

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER").and()
                .withUser("admin").password(("admin")).roles("ADMIN");
    }

    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }


}
