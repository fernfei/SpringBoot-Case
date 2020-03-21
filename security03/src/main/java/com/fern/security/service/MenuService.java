/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MenuService
 * Author:   Administrator
 * Date:     2020/1/14 8:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.service;

import com.fern.security.bean.Menu;
import com.fern.security.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/14
 * @since 1.0.0
 */
@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;
    public List<Menu> getMenus() {
        return menuMapper.getMenus();
    }
}