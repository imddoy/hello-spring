package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        //값에 대한 속성을 넣어줌
        model.addAttribute("data", "spring!!");

        //스프링부트 템플릿엔진 기본 viewName 매핑
        //resources에 있는 같은 이름 파일 찾아 렌더링
        //`resources:tempaltes/`+{ViewName}+`.html`
        return "hello";
    }
}
