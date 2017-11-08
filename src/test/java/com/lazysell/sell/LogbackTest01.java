package com.lazysell.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * LogbackTest01
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell
 * Created by Lazy on 2017/11/8 22:52
 * Version: 0.1
 * Info: @TODO:...
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LogbackTest01 {
    private final Logger logger= LoggerFactory.getLogger(LogbackTest01.class);
    @Test
    public void test01() {
        log.info("aa");
        log.error("00000000000000000000000000000000");
    }
}
