package com.redbyte.platform.demoskywalking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangwq
 */
@RestController
public class WelcomeController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
