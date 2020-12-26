package com.redbyte.platform.demoflowable.service.impl;

import com.redbyte.platform.demoflowable.service.ProcessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
class ProcessServiceImplTest {

    @Autowired
    private ProcessService processService;

    @Test
    void startProcess() {
        processService.startProcess("oneTaskProcess", null);
    }

    @Test
    void getTasks() {
    }

    @Test
    void operation() {
    }
}