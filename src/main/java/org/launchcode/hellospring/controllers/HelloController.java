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


    @RequestMapping(value="helloPost", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null || name.equals("")) {
            name = "World";
        }
        String message = HelloController.createMessage(name, language);
        return message;
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
                "<form action='helloPost' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option>English</option>" +
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

    public static String createMessage(String name, String language) {
        String message = "Hello, ";
        switch (language) {
            case "english":
                message = "Hello, ";
                break;
            case "Spanish":
                message = "¡Hola, ";
                break;
            case "French":
                message = "Bonjour, ";
                break;
            case "Tagalog":
                message = "Mabuhay, ";
                break;
            case "Klingon":
                message = "NuqneH, ";
                break;
            case "Gaelic":
                message = "Dia duit, ";
                break;
        }
        return message + name + "!";
    }
}
