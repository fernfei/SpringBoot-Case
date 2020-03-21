/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2020/3/4 20:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.swagger2.controller;

import com.fern.swagger2.bean.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/3/4
 * @since 1.0.0
 */
@RestController
@Api(tags = "用户数据接口")
@ApiIgnore
public class UserController {
    @ApiOperation(value = "查询用户",notes = "根据用户ID查询用户")
    @ApiImplicitParam(name = "id",value = "用户Id",required = true,defaultValue = "99")
    @GetMapping("/user")
    public User getUserById(@RequestParam(required = true) Integer id) {
        User user = new User();
        user.setName("z3");
        user.setAddress("北京");
        return user;
    }

    @ApiOperation(value = "删除用户", notes = "根据用户ID删除用户")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, defaultValue = "99")
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    @DeleteMapping("/user/{id}")
    public void delUserById(@PathVariable Integer id) {

        System.out.println("delUserById:" + id);
    }
    @ApiOperation(value = "修改用户",notes = "根据Id修改用户名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",required = true,defaultValue = "admin"),
            @ApiImplicitParam(name = "id",value = "用户id",required = true,defaultValue = "99")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "修改成功"),
            @ApiResponse(code = 500, message = "修改失败")
    })
    @PutMapping("/update")

    public User updateUserById(@RequestParam(required = true) String name,@RequestParam(required = true) Integer id) {
        User user = new User();
        user.setName(name);
        user.setAddress("日本");
        return user;
    }
    @ApiOperation(value = "添加用户",notes = "根据用户传入的对象添加用户")
    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        System.out.println("添加成功");
    }
}