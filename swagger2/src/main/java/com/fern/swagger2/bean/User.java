/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: User
 * Author:   Administrator
 * Date:     2020/3/4 20:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.swagger2.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/4
 * @since 1.0.0
 */
@ApiModel(value = "用户实体类", description = "用户实体类")
public class User {
    @ApiModelProperty(value = "用户id")
    private String name;
    @ApiModelProperty(value = "用户地址")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}