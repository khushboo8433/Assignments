package com.example.restfullapi.restfullapiday1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
@SpringBootApplication
public class Restfullapiday1Application {

	public static void main(String[] args) {

		SpringApplication.run(Restfullapiday1Application.class, args);
	}
//@Bean
//	public LocaleResolver localeResolver()
//{
//	SessionLocaleResolver localeResolver=new SessionLocaleResolver();
//	localeResolver.setDefaultLocale(Locale.US);
//	return localeResolver;
//}
//@Bean
//	public ResourceBundleMessageSource messageSource()
//	{
//		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//	}
@Bean
public LocaleResolver localeResolver() {
	AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
	localeResolver.setDefaultLocale(Locale.US);
	return localeResolver;
}
}
