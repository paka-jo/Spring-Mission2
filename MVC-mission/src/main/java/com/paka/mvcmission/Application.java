package com.paka.mvcmission;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller // 웹 요청을 처리하는 어노테이션
@RequestMapping("/inventory/*") // /menu url용청을 처리하도록 매핑하는 역할
@SessionAttributes("id") //세션의 속성을 관리하는 역할
public class Application {

    @GetMapping("regist") //데이터를 가져옴
    public void regist() {}

    @PostMapping("regist") //데이터를 생성 , model  컨트롤러와 뷰 사이의 데이터 전달을 담당, 메소드 호출 시인자로 값을 전달함
    public String registThing(Model model, WebRequest request) {

        String name = request.getParameter("name");  //name에 대해서 불러옴
        int price = Integer.parseInt(request.getParameter("price")); // price를 입력 받은 값을 정수형으로 바꿔줌
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode")); // categoryCode 입력 받은 값을 정수형으로 바꿔줌

        String message = name + "을 상품의 목록의" +categoryCode + "번 카테고리에" +price+  "원으로 등록하셨습니다";
        System.out.println(message);

        model.addAttribute("message",message); //model을 통해 뷰로 정보전달

        return "inventory/messageout";
    }

    @GetMapping("modify")
    public void modify() {}

    @PostMapping("modify")
    public String modifyThingPrice(Model model,
                                   @RequestParam(required = false) String modifyName, // 이 파라미터가 필수x
                                   @RequestParam(defaultValue = "0") int modifyPrice) // 이 피라미터를 전송하지 않으면 기본값이 0으로 설정
        {String message = modifyName + "상품 가격을 " + modifyPrice + "원으로 가격을 변경하였습니다.";
            System.out.println("message = " + message);

            model.addAttribute("message", message);

            return "first/messageout";

        }




}