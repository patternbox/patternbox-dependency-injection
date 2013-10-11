package com.patternbox.di.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patternbox.di.cooking.WaterCooker;

/**
 * @author <a href='http://www.patternbox.com'>D. Ehms, Patternbox<a>
 */
public class WaterCookerTest {

	private WaterCooker waterCooker;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		waterCooker = new WaterCooker();
	}

	/**
	 * Test method for {@link com.patternbox.di.cooking.WaterCooker#start()}.
	 */
	@Test(expected = NullPointerException.class)
	public void testMissingDependencyInjection() {
		waterCooker.start();
	}

	/**
	 * Test method for {@link com.patternbox.di.cooking.WaterCooker#start()}.
	 */
	@Test
	public void testSpringDependencyInjection() throws Exception {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		waterCooker = (WaterCooker) context.getBean("waterCooker");
		Assert.assertFalse(waterCooker.isHot());
		waterCooker.start();
		Assert.assertTrue(waterCooker.isHot());
	}
}
