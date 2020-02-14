package com.github.bouldi.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/greeting")
    public String greeting(Model model) {

        Greeting greeting = restTemplate.getForObject(
                "http://localhost:8081/greeting?name=Nikita", Greeting.class);

        model.addAttribute("name", greeting.getContent());
        return "greeting";


    }


}
