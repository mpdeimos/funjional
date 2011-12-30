package com.mpdeimos.funjional;

import static org.junit.Assert.assertEquals;

import com.mpdeimos.funjional.lib.Arrayz;

import org.junit.Test;

/** Tests for composing functions. */
public class FunctionCompositionTest
{
	/** Tests composition */
	@Test
	public void testAdd1Mul2()
	{
		Integer[] ints = Arrayz.mapSelf(
				Fun.MUL(2).o(Fun.ADD(1)),
				0,
				1,
				2,
				3,
				4,
				5,
				6,
				7,
				8,
				9);

		for (int i = 0; i < ints.length; i++)
		{
			assertEquals(2 * (i + 1), (int) ints[i]);
		}
	}

	/** Tests composition */
	@Test
	public void testMul2Add1()
	{
		Integer[] ints = Arrayz.mapSelf(
				Fun.ADD(1).o(Fun.MUL(2)),
				0,
				1,
				2,
				3,
				4,
				5,
				6,
				7,
				8,
				9);

		for (int i = 0; i < ints.length; i++)
		{
			assertEquals((2 * i) + 1, (int) ints[i]);
		}
	}
}
