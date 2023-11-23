package hello.hellospring.controller;

import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    //    @ResponseBody 를 사용
    //    - HTTP의 BODY에 문자 내용을 직접 반환
    //    - viewResolver 대신에 HTTPMessageConverter 가 동작
    //    - 기본 문자처리 : StringHttpMessageConverter
    //    - 기본 객체러리 : MappingJackson2HttpMessageConverter
    //    - byte 처리 등 기타 여러 HttpMessageConvverter가 기본으로 등록되어 있음
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; //"hello spring" 냅다 문자
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //json 기본적으로는 json 방식
    }
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
