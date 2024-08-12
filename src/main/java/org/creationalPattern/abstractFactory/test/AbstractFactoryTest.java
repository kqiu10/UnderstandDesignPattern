package org.creationalPattern.abstractFactory.test;

import org.creationalPattern.abstractFactory.impl.CacheService;
import org.creationalPattern.abstractFactory.impl.factory.JDKProxyFactory;
import org.creationalPattern.abstractFactory.impl.redis.cluster.EGMCacheAdapter;
import org.creationalPattern.abstractFactory.impl.redis.cluster.IIRCacheAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class AbstractFactoryTest {

    private static final Logger logger = LogManager.getLogger(AbstractFactoryTest.class);

    @Test
    public void callCorrectFactory() throws Exception {
        final CacheService proxy_EGM = JDKProxyFactory.getProxy(CacheService.class, EGMCacheAdapter.class);
        proxy_EGM.set("user_name_01", "Greg");
        final String val01 = proxy_EGM.get("user_name_01");
        logger.info("缓存服务 EGM 测试，proxy_EGM.get 测试结果：{}", val01);

        final CacheService proxy_IIR = JDKProxyFactory.getProxy(CacheService.class, IIRCacheAdapter.class);
        proxy_IIR.set("user_name_02", "Qiu");
        final String val02 = proxy_IIR.get("user_name_02");
        logger.info("缓存服务 IIR 测试，proxy_IIR.get 测试结果：{}", val02);

    }

}
