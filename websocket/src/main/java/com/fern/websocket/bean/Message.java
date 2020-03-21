/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: Message
 * Author:   Administrator
 * Date:     2020/1/17 16:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.websocket.bean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/17
 * @since 1.0.0
 */
public class Message {
    private String name;
    private String content;
    private String FERN;

    public String getFERN() {
        return FERN;
    }

    public void setFERN(String FERN) {
        this.FERN = FERN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}