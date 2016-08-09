package com.threads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lyz on 2016/7/30.
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/testHello.in")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.getWriter().write("hello world!");
        return null;
    }

}

