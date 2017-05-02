package industree.Configuration;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "industree")
public class AppConfig extends WebMvcConfigurerAdapter
{

	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver
			= new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/images/**").addResourceLocations("file:///Users/varshateratipally/Documents/RiomhaireApp/src/main/webapp/WEB-INF/images/");
	}
}