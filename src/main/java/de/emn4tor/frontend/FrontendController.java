package de.emn4tor.frontend;

/*
 *  @author: Emn4tor
 *  @created: 23.03.2025
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FrontendController {

    @RequestMapping("/")
    public String welcome() {
        return "index.html";
    }
}