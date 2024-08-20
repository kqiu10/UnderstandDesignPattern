package org.behaviorPattern.mediator.impl.dao;

import org.behaviorPattern.mediator.impl.po.User;

public interface IUserDao {

    User queryUserInfoById(Long id);

}
