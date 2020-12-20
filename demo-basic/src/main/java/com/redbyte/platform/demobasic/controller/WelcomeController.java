package com.redbyte.platform.demobasic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@RestController
public class WelcomeController {

    @RequestMapping("welcome")
    public String welcome() {
        return "welcome";
    }
}
