package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    // handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // with RequestMapping at top of Class, now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //  creates greeting based on selected language
    public static String createMessage(String name, String language) {
        String message = "Hello, ";
        if (language.equals("english")) {
            message = "Hello, ";
        } else if (language.equals("Spanish")) {
            message = "¡Hola, ";
        } else if (language.equals("French")) {
            message = "Bonjour, ";
        } else if (language.equals("Tagalog")) {
            message = "Mabuhay, ";
        } else if (language.equals("Klingon")) {
            message = "NuqneH, ";
        } else if (language.equals("Gaelic")) {
            message = "Dia duit, ";
        }
        return message + name + "!";
    }

    @RequestMapping(value="form", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
//        if (name == null) {
//            name = "World";
//        }
        return createMessage(name, language);
    }

    //  handles requests of the form /hello/query?name="LaunchCode"
    @RequestMapping(value="hello/query", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //  handles requests of the form /hello/{name}
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello/query' method='post'>" +
                "<input type='text' name='name'>" +
                "<select id=language-select>" +
                "<option selected>English</option>" +
                "<option>Spanish</option>" +
                "<option>French</option>" +
                "<option>Tagalog</option>" +
                "<option>Gaelic</option>" +
                "<option>Klingon</option>" +
                "/<select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
