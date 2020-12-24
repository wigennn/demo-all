package com.redbyte.platform.demowebsocket.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Data
public class MessageFormat implements Serializable {

    private static final long serialVersionUID = -2099288352623917801L;
    private String receiveId;
    private String sourceId;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-mm-dd hh:MM:ss")
    private String sendTime;
}
