package com.redbyte.platform.demowebsocket.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
    private Date sendTime;
}
