package com.redbyte.platform.demobasic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Slf4j
@RestController
public class WelcomeController {

    @RequestMapping("welcome")
    public String welcome() {
        log.info("welcome come in....");
        return "welcome";
    }
}
