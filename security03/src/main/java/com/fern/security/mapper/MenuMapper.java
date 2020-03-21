/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: MenuMapper
 * Author:   Administrator
 * Date:     2020/1/14 8:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.security.mapper;

import com.fern.security.bean.Menu;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/14
 * @since 1.0.0
 */
public interface MenuMapper {

    List<Menu> getMenus();
}