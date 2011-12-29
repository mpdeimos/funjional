package com.mpdeimos.funjional.lib;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/** Tests for Libz library. */
public class LibzTest
{
	/** ints array */
	Integer[] ints;

	/** strings array */
	private String[] strings;

	/** called for each method. */
	@SuppressWarnings("nls")
	@Before
	public void setUp()
	{
		this.ints = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		this.strings = new String[] { "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9" };
	}

	/** tests to string conversion. */
	@Test
	public void testString()
	{
		Arrayz.each().$(Libz.sysout(), ints);
	}

	/** tests first. */
	@Test
	public void testFirstAndSecond()
	{
		assertEquals(1, Libz.first().$(1).$("b"));
		assertEquals("b", Libz.second().$(1).$("b"));
	}
}
