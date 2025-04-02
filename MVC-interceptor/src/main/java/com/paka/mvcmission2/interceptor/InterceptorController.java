package com.paka.mvcmission2.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //http 요청을 처리하는 역할
@RequestMapping("/*") // 컨트롤러 메서드와 html을 매핑하는 역할
public class InterceptorController {

    @GetMapping("input")
    public String handlerMethod() {

        return "result";
    }
}
