package org.medicine_check.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
public class TestController {

    @ResponseBody
    @GetMapping("/1")
    public String test1() {
        return "hello word";
    }

    @ResponseBody
    @RequestMapping("/test2")
    public String test2() {
        return "<h1>hello word<h2>";
    }

}
