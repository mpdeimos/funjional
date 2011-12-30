package com.mpdeimos.funjional.lib;

import static org.junit.Assert.assertEquals;

import com.mpdeimos.funjional.$;

import org.junit.Before;
import org.junit.Test;

/** Tests for Libz library. */
public class MathzTest
{
	/** ints array */
	Integer[] ints;

	/** doubles array */
	Double[] doubles;

	/** called for each method. */
	@Before
	public void setUp()
	{
		this.ints = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		this.doubles = new Double[] { 0., 1., 2., 3., 4., 5., 6., 7., 8., 9. };
	}

	/** tests addition. */
	@Test
	public void testAdd()
	{
		$<Integer, Integer> plus1 = Mathz.<Integer> add().$(1);
		assertEquals(3, (int) plus1.$(2));
		assertEquals(-1, (int) plus1.$(-2));

		assertEquals(45, (int) Arrayz.<Integer, Integer> foldLeft().$(
				Mathz.<Integer> add(),
				0,
				this.ints));
	}

	/** tests subtraction. */
	@Test
	public void testSub()
	{
		$<Integer, Integer> _1minusX = Mathz.<Integer> sub().$(1);
		assertEquals(-1, (int) _1minusX.$(2));
		assertEquals(3, (int) _1minusX.$(-2));

		$<Integer, Integer> minus1 = Funz.swap(Mathz.<Integer> sub()).$(1);
		assertEquals(1, (int) minus1.$(2));
		assertEquals(-3, (int) minus1.$(-2));

		assertEquals(-45, (int) Arrayz.<Integer, Integer> foldLeft().$(
				Mathz.<Integer> sub(),
				0,
				this.ints));
	}

	/** tests multiplication. */
	@Test
	public void testMul()
	{
		$<Integer, Integer> times2 = Mathz.<Integer> mul().$(2);
		assertEquals(4, (int) times2.$(2));
		assertEquals(-4, (int) times2.$(-2));

		assertEquals(
				362880,
				(int) Arrayz.foldLeft(
						Mathz.<Integer> mul(),
						1,
						Arrayz.tail(this.ints)));
	}

	/** tests divison. */
	@Test
	public void testDiv()
	{
		$<Float, Float> _9divX = Mathz.<Float> div().$(9f);
		assertEquals(4.5, _9divX.$(2f), 0.01);
		assertEquals(-3, _9divX.$(-3f), 0.01);

		$<Float, Float> div2 = Funz.swap(Mathz.<Float> div()).$(2f);
		assertEquals(3, div2.$(6f), 0.11);
		assertEquals(5.5, div2.$(11f), 0.01);

		$<Integer, Integer> div2i = Funz.swap(Mathz.<Integer> div()).$(2);
		assertEquals(3, div2i.$(6), 0.01);
		assertEquals(5, div2i.$(11), 0.01);
	}
}
