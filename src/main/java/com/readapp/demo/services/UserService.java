package com.readapp.demo.services;

import com.readapp.demo.common.Result;
import com.readapp.demo.entity.User;

public interface UserService {

    /**
     * 增加用户
     *
     * @param user 待新增的用户
     * @return 增加成功的用户
     */
    Result<User> create(User user);

    /**
     * 删除用户
     *
     * @param user 待删除的用户
     * @return 删除状态
     */
    Boolean deleteUser(User user);

    /**
     * 修改用户
     *
     * @param user 待修改的用户
     * @return 修改成功的用户
     */
    Result<User> updateUser(User user);


    /**
     * 用于微信注册用户查找：根据openId查找用户
     *
     * @param openId 微信openId
     * @return openId对应的用户
     */
    Result<User> findByOpenId(String openId);

}
