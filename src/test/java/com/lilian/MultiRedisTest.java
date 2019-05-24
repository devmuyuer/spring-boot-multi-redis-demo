package com.lilian;

import com.lilian.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-12-03 10:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiRedisTest {

    @Resource(name = "defaultRedisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "cacheRedisTemplate")
    private RedisTemplate<String, Object> redisTemplate1;

    @Test
    public void stringRedisWriteTest() {

        redisTemplate.opsForValue().set("muyuer", "aaa");
        redisTemplate1.opsForValue().set("yxg", "bbb");

    }

    @Test
    public void objectRedisWriteTest() {
        redisTemplate.opsForValue().set("person", new Person("张三", 27, "成都", "182443947@qq.com", "13540724777"));
        redisTemplate1.opsForValue().set("person", new Person("李四", 28, "会理", "182443947@qq.com", "13551849577"));
        Person person = (Person)redisTemplate.opsForValue().get("person");
        String a = person.getEmail();
    }

    @Test
    public void objectRedisGetTest() {
        Person person = (Person)redisTemplate.opsForValue().get("person");
        String a = person.getEmail();
        Person person1 = (Person)redisTemplate1.opsForValue().get("person");
        String a1 = person1.getEmail();
    }

}
