package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") // hello라는 url로 요청이 오면 이 컨트롤러 호출됨
    public String hello(Model model) { // Model을 이용해서 데이터를 실어서 컨트롤러에서 뷰로 넘길 수가 있다
        model.addAttribute("data", "hello!!"); // data라는 키에 - hello!!!라는 값을 넣어 넘긴다
        return "hello"; // return은 화면이름이다. .html확장자는 자동으로 붙으니 제외 = src/main/resources의 tempates폴더에 hello.html라는이름의 view 만든다. 안녕
    }
}
