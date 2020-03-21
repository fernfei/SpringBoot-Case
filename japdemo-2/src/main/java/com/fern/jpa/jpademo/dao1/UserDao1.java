/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserDao1
 * Author:   Administrator
 * Date:     2019/12/30 13:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fern.jpa.jpademo.dao1;

import com.fern.jpa.jpademo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/30
 * @since 1.0.0
 */
public interface UserDao1 extends JpaRepository<User, Integer> {


}