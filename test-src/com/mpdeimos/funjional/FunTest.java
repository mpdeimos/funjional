package com.mpdeimos.funjional;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** Tests for composing functions. */
public class FunTest
{
	/** Tests composition */
	@Test
	public void testMul()
	{
		assertEquals(6, (int) Fun.mul(Integer.class).call(2).call(3));
		assertEquals(6, (int) Fun.mul(Integer.class).call(2, 3));
	}
}
