package cn.violin.home.school.h2;

import cn.violin.home.school.controller.LocationController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class H2Test {

    @Autowired
    private LocationController controller;

    @Before
    public void setup() {
        this.testLocaiton();
    }

    @Test
    public void testLocaiton() {
        this.setup();
//        Configuration conf = new Configuration();
//        conf.configure("hibernate.cfg.xml");
//        SessionFactory factory = conf.buildSessionFactory();
//        Session session = factory.openSession();
//
//        Location location = session.load(Location.class, 11);
//        controller.hello();
//        controller.hello();
    }


}
