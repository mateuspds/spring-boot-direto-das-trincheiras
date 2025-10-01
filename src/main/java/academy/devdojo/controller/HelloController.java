package academy.devdojo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "hi")
    public  String hi(){
        return "omae wa mou shinde iru";
    }
}
