package com.redbyte.platform.demoflowable.controller;

import com.redbyte.platform.demoflowable.service.ProcessService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@RestController
public class ExpenseController {

    @Autowired
    private ProcessService processService;

    @RequestMapping("/add")
    public String addExpense(String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        ProcessInstance instance = processService.startProcess("expanse", map);
        return "提交成功, 流程id为" + instance.getId();
    }

    @RequestMapping("/list")
    public Object list(String uid) {
        return processService.getTasks(uid);
    }

    @RequestMapping("/apply")
    public String apply(String taskId) {
        Map<String, Object> map = new HashMap<>();
        map.put("outcome", "");
        processService.operation(taskId, map);
        return "apply success!";
    }

    @RequestMapping("/reject")
    public String reject(String taskId) {
        Map<String, Object> map = new HashMap<>();

        map.put("outcome", "驳回");
        processService.operation(taskId, map);
        return "reject success!";
    }
}
