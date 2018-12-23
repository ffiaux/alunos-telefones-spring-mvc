package com.alunos.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = "com.alunos.spring")
@Configuration
public class ClientWebConfig implements WebMvcConfigurer
{
	/**
	 * Config para upload de arquivos
	 * 
	 * @return
	 */
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver()
	{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(16777216); // 16MB

		return multipartResolver;
	}

	/**
	 * Config para arquivos estaticos, como JS e CSS
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	/**
	 * Config para encaminhamento de paginas JSP
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver bean = new InternalResourceViewResolver();

		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");

		return bean;
	}
}