package com.yiscn.headoftheheadactivity;

import com.yiscn.common.util.JsonUtil;
import com.yiscn.entity.ScUser;
import com.yiscn.service.IScUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadoftheheadactivityApplicationTests {

	@Autowired
	private IScUserService scUserService;

	@Test
	public void contextLoads() {

		Calendar cale = Calendar.getInstance();
		int month = cale.get(Calendar.MONTH);
		int year = cale.get(Calendar.YEAR);

		System.out.println(month + year);
	}

	@Test
	public void get() {
		ScUser scUser = scUserService.get(2);
		System.out.print(JsonUtil.toJSONString(scUser));
	}
}
