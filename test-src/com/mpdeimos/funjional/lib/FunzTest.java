package com.mpdeimos.funjional.lib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** Tests for Funz library. */
public class FunzTest
{
	/** tests first and second. */
	@Test
	public void testFirstAndSecond()
	{
		assertEquals(1, Funz.first().$(1).$("b"));
		assertEquals("b", Funz.second().$(1).$("b"));
	}
}
