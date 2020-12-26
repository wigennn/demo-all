package com.redbyte.platform.demoflowable.service;

import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
public interface ProcessService {

    ProcessInstance startProcess(String key, Map<String, Object> params);

    List<Task> getTasks(String assignee);

    String operation(String taskId, Map<String, Object> map);
}
