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

    /**
     * @param applicationContext The application context used by the running
     *                           application.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Create a org.springframework.web.servlet ViewResolver bean
     * this bean handles all templates for the Thymeleaf template eugenie
     * it also specifies the encoding of the templates
     */
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setContentType("text/html; charset=UTF-8");
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    /**
     * Create a org.thymeleaf.ITemplateEngine bean that manages
     * this bean manages the integration of the templates with the Spring framework.
     * added two dialects to the template engine
     * Layout dialect for reusing layout, fragments, in HTML files
     * Security dialect for using the "sec" annotation in HTML files
     */
    @Bean(name = "FairGroundsTemplateEngine")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.addDialect(new LayoutDialect());
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }

    /**
     * Create a org.thymeleaf.templateresolver.ITemplateResolver
     * This bean handles template integration with the Spring framework
     * The source of the HTML files is defined and the suffix, the HTML files can be referenced with name
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver =
                new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("classpath:/web-root/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    /**
     * Tells the framework where it can find the static files of the website
     **/
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

    /**
     * Starts a i18n servlet that stores the current Locale of the user in the session object
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    /**
     * Manages the Locale for the session
     * set the current Locale code to the parameter lang in the request
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        String[] allowedHttpMethodsForLocaleChange = {"GET", "POST"};
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        lci.setHttpMethods(allowedHttpMethodsForLocaleChange);
        lci.setIgnoreInvalidLocale(true);
        return lci;
    }

    /**
     * Tells the i18n the location of the messages that are to be generated in the HTML file
     * depending on the current Locale
     */
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

    /**
     * Register the i18n interceptor.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
