package com.example.restfullapi.restfullapiday1.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;


//mapping a get request to hello world
@RestController
public class HelloWorldController {
    @Autowired
    private ResourceBundleMessageSource messageSource;


   // @RequestMapping(method= RequestMethod.GET,path="/hello-khushboo")
    @GetMapping(path="/hello-world")
    public String helloWorld()
    {
        return "hello world";
    }
    //mappping a get request using bean
    @GetMapping(path="/hello-world-bean")
    public  HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("hello world beans");
    }
    //maping using path variable
    @GetMapping(path="/hello-world/path-variable/{Name}")
    public  HelloWorldBean helloWorldPathVariable(@PathVariable(name="Name") String Name)
    {
        return new HelloWorldBean(String.format("hello world path variable,%s",Name));
    }
//    @GetMapping(path="/hello-world-internationalized")
//    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale)
//    {
//        return messageSource.getMessage("good.morning.message",null,locale);
//    }
@GetMapping(path="/hello-world-internationalized")
public String helloWorldInternationalized()
{
    return messageSource.getMessage("good.morning.message","Khushboo", LocaleContextHolder.getLocale());
}
}
