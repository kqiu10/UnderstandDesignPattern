package org.behaviorPattern.mediator.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.mediator.impl.interpreter.SqlSession;
import org.behaviorPattern.mediator.impl.interpreter.SqlSessionFactory;
import org.behaviorPattern.mediator.impl.interpreter.SqlSessionFactoryBuilder;
import org.behaviorPattern.mediator.impl.po.User;
import org.junit.jupiter.api.Test;

import com.alibaba.fastjson2.JSON;

public class MediatorTest {
    private static final Logger log = LogManager.getLogger();

    @Test
    public void test_queryUserInfoById() {
        String resource = "mediatorConfig/mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User user = session.selectOne("org.behaviorPattern.mediator.impl.dao.IUserDao.queryUserInfoById", 1L);
                log.info("Result：{}", JSON.toJSONString(user));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_queryUserList() {
        String resource = "mediatorConfig/mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User req = new User();
                req.setAge(18);
                List<User> userList = session.selectList("org.behaviorPattern.mediator.impl.dao.IUserDao.queryUserList", req);
                log.info("Result：{}", JSON.toJSONString(userList));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
