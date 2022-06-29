package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "/add/3/and/4", method = RequestMethod.GET)
    @ResponseBody
    public int add() {
        return 7;
    }

    @GetMapping("/subtract/3/from/10")
    @ResponseBody
    public int subtract() {
        return 7;
    }

    @RequestMapping(path = "/multiply/4/and/5", method = RequestMethod.GET)
    @ResponseBody
    public int multiply() {
        return 20;
    }

    @GetMapping("/divide/6/by/3")
    @ResponseBody
    public int divide() {
        return 2;
    }

}
