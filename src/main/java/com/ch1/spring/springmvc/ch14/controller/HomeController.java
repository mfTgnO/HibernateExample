package com.ch1.spring.springmvc.ch14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/home_ch14")
public class HomeController {
    @RequestMapping(value = "/method0")
    @ResponseBody
    public String method0() {
        return "method0";
    }

    @RequestMapping(value = {"/method0", "/method1/second"})
    @ResponseBody
    public String method1() {
        return "method1";
    }

    @RequestMapping(value = "/method2", method = RequestMethod.POST)
    @ResponseBody
    public String method2() {
        return "method2";
    }

    @RequestMapping(value = "/method3", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String method3() {
        return "method3";
    }

    @RequestMapping(value = "/method4", headers = "name-pankaj")
    @ResponseBody
    public String method4() {
        return "method4";
    }

    @RequestMapping(value = "/method5", headers = {"name=pankaj", "id=1"})
    @ResponseBody
    public String method5() {
        return "method5";
    }

    @RequestMapping(value = "/method6", produces = {"application/json", "application/xml"}, consumes = "text/html")
    @ResponseBody
    public String method6() {
        return "method6";
    }

    @RequestMapping(value = "/method7/{id}")
    @ResponseBody
    public String method7(@PathVariable("id") int id) {
        return "method7 with id=" + id;
    }

    @RequestMapping(value = "/method8/{id:[\\d]+}/{name}")
    @ResponseBody
    public String method8(@PathVariable("id") long id, @PathVariable("name") String name) {
        return "method8 with id= " + id + " and name=" + name;
    }

    @RequestMapping(value = "/method9")
    @ResponseBody
    public String method9(@RequestParam("id") int id) {
        return "method9 with id= " + id;
    }

    @RequestMapping()
    @ResponseBody
    public String defaultMethod() {
        return "default method";
    }

    @RequestMapping("*")
    @ResponseBody
    public String fallbackMethod() {
        return "fallback method";
    }
}
