package com.patternbox.di.jee;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.patternbox.di.cooking.ElectricHeater;
import com.patternbox.di.cooking.Heater;
import com.patternbox.di.cooking.WaterCooker;

import de.akquinet.jbosscc.needle.annotation.InjectInto;
import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.junit.NeedleRule;

/**
 * @author <a href='http://www.patternbox.com'>D. Ehms, Patternbox<a>
 */
public class WaterCookerTest {

	/** Needle container setup */
	@Rule
	public NeedleRule needleRule = new NeedleRule();

	@ObjectUnderTest
	private WaterCooker waterCooker;

	@InjectInto(targetComponentId = "waterCooker")
	private final Heater heater = new ElectricHeater();

	/**
	 * Test method for {@link com.patternbox.di.cooking.WaterCooker#start()}.
	 */
	@Test
	public void testJeeDependencyInjection() throws Exception {
		Assert.assertNotNull(waterCooker);
		Assert.assertFalse(waterCooker.isHot());
		waterCooker.start();
		Assert.assertTrue(waterCooker.isHot());
	}
}
