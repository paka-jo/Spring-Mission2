package com.paka.mvcmission2.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/*")
public class MainController {

    @RequestMapping("/")
    public String defaultLocation() {
        return "main";
    }

    @RequestMapping("/main")
    public void main() {}


}
