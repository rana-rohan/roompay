package com.roompay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/pay/{name}")
    public String pay(@PathVariable String name) {

        String upi = "";
        String person = "";

        switch (name.toLowerCase()) {

            case "rohan":
                upi = "rohan76991709631@ybl";
                person = "Rohan";
                break;

            case "partha":
                upi = "8695379031@kotak811";
                person = "Partha";
                break;

            case "prince":
                upi = "princepanda7029-1@okhdfcbank";
                person = "Prince";
                break;

            case "bibek":
                upi = "bibeksharma@apl";
                person = "Bibek";
                break;

            case "bhaskar":
                upi = "broy98451@okaxis";
                person = "Bhaskar";
                break;
        }

        return "redirect:upi://pay?pa=" + upi + "&pn=" + person;
    }
}