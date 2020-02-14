package com.github.bouldi.servingwebcontent;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/formular")
    public String formular(Model model) {
        model.addAttribute("user", new User());
        return "formular";
    }

    @GetMapping("/userlist")
    public String userlist(Model model) {

        ResponseEntity<UsersResponse> response = restTemplate.getForEntity(
                "http://localhost:8082/people", UsersResponse.class);
        model.addAttribute("users", response.getBody().getEmbedded().getPeople());
        return "userlist";
    }

    @PostMapping("/user")
    public String userSubmit(@ModelAttribute User user) {

        user = restTemplate.postForObject(
                "http://localhost:8082/people", user, User.class);

        return "result";
    }


}
