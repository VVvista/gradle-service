package com.gsgradle.service.admin;

import com.gsgradle.service.core.Core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wen TingTing by 2019/11/18
 */
@SpringBootApplication
@RestController
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @GetMapping("/request")
    public String request() {
        Core core = new Core("Hello frist gradle request!");
        return core.getContent();
    }
}
