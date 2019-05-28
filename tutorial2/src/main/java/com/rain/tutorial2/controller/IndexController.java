package com.rain.tutorial2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){

        return "index";
    }

    @RequestMapping("index2")
    public String index2(){

        return "index";
    }

}
