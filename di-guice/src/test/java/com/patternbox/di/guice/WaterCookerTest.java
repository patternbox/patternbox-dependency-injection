/**
 * ************************** Copyright notice ********************************
 *
 * Copyright (C)2013 by D. Ehms, http://www.patternbox.com All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. 2. Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution. THIS SOFTWARE IS PROVIDED BY THE
 * AUTHOR AND CONTRIBUTORS ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ****************************************************************************
 */
package com.patternbox.di.guice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
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
	public void testGuiceDependencyInjection() throws Exception {
		Injector injector = Guice.createInjector(new WaterCookerModule());
		waterCooker = injector.getInstance(WaterCooker.class);
		Assert.assertFalse(waterCooker.isHot());
		waterCooker.start();
		Assert.assertTrue(waterCooker.isHot());
	}
}
