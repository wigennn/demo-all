package com.redbyte.platform.demoflowable.service.impl;

import com.redbyte.platform.demoflowable.service.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.ProcessEngineImpl;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Slf4j
@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;
//    @Autowired
//    private ProcessEngine processEngine;

    @Override
    @Transactional
    public ProcessInstance startProcess(String key, Map<String, Object> params) {
        Deployment deployment = repositoryService.createDeploymentQuery().processDefinitionKey(key).singleResult();
        if (deployment == null) {
            log.error("没有该流程, keyName:", key);
            return null;
        }
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, params);
        return processInstance;
    }

    @Override
    public List<Task> getTasks(String assignee) {
        System.out.println("Number of process definitions : "
                + repositoryService.createProcessDefinitionQuery().count());
        System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
        runtimeService.startProcessInstanceByKey("oneTaskProcess");
        System.out.println("Number of tasks after process start: "
                + taskService.createTaskQuery().count());
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    @Override
    public String operation(String taskId, Map<String, Object> map) {
        taskService.complete(taskId, map);
        return null;
    }
}
