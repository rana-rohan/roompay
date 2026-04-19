package com.roompay;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
                person = "Rohan Rana";
                break;

            case "partha":
                upi = "8695379031@kotak811";
                person = "Partha Saha";
                break;

            case "prince":
                upi = "YOUR_REAL_PRINCE_UPI";
                person = "Prince Panda";
                break;

            case "bibek":
                upi = "sharmasbibek0@okhdfcbank";
                person = "Bibek Sharma";
                break;

            case "bhaskar":
                upi = "broy98451@okaxis";
                person = "Bhaskar Roy";
                break;
        }

        String url =
                "upi://pay?pa=" + upi +
                        "&pn=" + URLEncoder.encode(person, StandardCharsets.UTF_8) +
                        "&am=10.00" +
                        "&cu=INR";

        return "redirect:" + url;
    }
}