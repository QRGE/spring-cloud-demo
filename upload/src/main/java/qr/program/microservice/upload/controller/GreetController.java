package qr.program.microservice.upload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qr
 * @Date 2022/5/6-21:23
 */
@RestController
@RequestMapping("/greet")
public class GreetController {

    @RequestMapping("/hello")
    public String greet() {
        return "你好哇";
    }
}
