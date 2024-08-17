package org.structuralPattern.proxy.impl;

import org.structuralPattern.proxy.impl.agent.Select;

public interface IUserDao {

    @Select("select userName for user where id = #{uId}")
    String queryUserInfo(String uId);
}
