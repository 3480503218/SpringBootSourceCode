package com.wisely.ch7_6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Ch76Application.class)
@SpringBootApplication
@WebAppConfiguration
public class Ch76ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
