package FairGrounds.Config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.Locale;

@EnableTransactionManagement // Needed for @Transactional attribute outside
// repositories.
@EnableWebMvc
@Configuration
public class FairGroundsConfig implements WebMvcConfigurer, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setContentType("text/html; charset=UTF-8");
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Bean(name = "bankTemplateEngine")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
        // speed up execution in most scenarios, but might be incompatible
        // with specific cases when expressions in one template are reused
        // across different data types, so this flag is "false" by default
        // for safer backwards compatibility.
        //templateEngine.setEnableSpringELCompiler(true);
        //Add the layout dialect, which enables reusing layout html pages.
        templateEngine.addDialect(new LayoutDialect());
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }

    /** DO I NEED THIS???????
    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }
     **/

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver =
                new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        // Templates file shall have the path /web-root/<template name>.html
        templateResolver.setPrefix("classpath:/web-root/");
        templateResolver.setSuffix(".html");
        // HTML is the default template mode, added here for the sake of
        // clarity.
        //templateResolver.setTemplateMode(TemplateMode.HTML);
        // Template cache is true by default. Set to false to automatically
        // update templates that have been modified.
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        int cachePeriodForStaticFilesInSecs = 1;
        String rootDirForStaticFiles = "classpath:/web-root/";


        registry.addResourceHandler("/**")
                .addResourceLocations(rootDirForStaticFiles)
                .setCachePeriod(cachePeriodForStaticFilesInSecs)
                .resourceChain(true).addResolver(new PathResourceResolver());

    }

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        String[] allowedHttpMethodsForLocaleChange = {"GET", "POST"};
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        lci.setHttpMethods(allowedHttpMethodsForLocaleChange);
        lci.setIgnoreInvalidLocale(true);
        return lci;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        String message = "classpath:/message";
        String validationMessage = "classpath:/ValidationMessages";
        ReloadableResourceBundleMessageSource resource =
                new ReloadableResourceBundleMessageSource();
        resource.addBasenames(message, validationMessage);
        resource.setDefaultEncoding("UTF-8");
        resource.setFallbackToSystemLocale(false);
        return resource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}
