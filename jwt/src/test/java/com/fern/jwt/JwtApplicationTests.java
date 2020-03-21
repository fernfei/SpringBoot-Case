package com.fern.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        String date = format.format(new Date(System.currentTimeMillis() + 60 * 60 * 1000));
        System.out.println(date);
    }

}
