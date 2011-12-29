package com.mpdeimos.funjional.lib;

import static org.junit.Assert.assertEquals;

import com.mpdeimos.funjional.$;
import com.mpdeimos.funjional.$$;
import com.mpdeimos.funjional.Fun;
import com.mpdeimos.funjional._;
import com.mpdeimos.funjional._._2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/** Tests for the Array Library. */
public class ArrayzTest
{
	/** test array */
	Integer[] ints;

	/** called for each method. */
	@Before
	public void setUp()
	{
		this.ints = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	}

	/** Tests the folding direction of fold left. */
	@Test
	public void testFoldLeftDirection()
	{
		Arrayz.foldLeft(new $$<_2<Integer[], Integer>, Integer>()
		{
			@Override
			public _2<Integer[], Integer> $(_2<Integer[], Integer> acc,
					Integer o)
			{
				acc.a[o] = acc.b;
				acc.b++;
				return acc;
			}

		}, _._(this.ints, 0), this.ints);

		for (int i = 0; i < this.ints.length; i++)
		{
			assertEquals(i, (int) this.ints[i]);
		}
	}

	/** Tests the folding direction of fold right. */
	@Test
	public void testFoldRightDirection()
	{
		Arrayz.foldRight(new $$<_2<Integer[], Integer>, Integer>()
		{
			@Override
			public _2<Integer[], Integer> $(_2<Integer[], Integer> acc,
					Integer o)
			{
				acc.a[o] = acc.b;
				acc.b++;
				return acc;
			}

		}, _._(this.ints, 0), this.ints);

		for (int i = 0; i < this.ints.length; i++)
		{
			assertEquals(this.ints.length - i - 1, (int) this.ints[i]);
		}
	}

	/** Tests fold right behavior. */
	@Test
	public void testFoldRight()
	{
		assertEquals(45, Arrayz.foldRight(new $$<Double, Integer>()
		{
			@Override
			public Double $(Double acc, Integer o)
			{
				return acc + o;
			}
		}, 0.0, ints), 0.1);

		assertEquals(45, (int) $.foldRight(Fun.ADD(Integer.class), 0, ints));
		assertEquals(45, (int) $.foldRight(Fun.ADD(Integer.class), 0, intArray));
		assertEquals(
				10,
				(int) $.foldRight(Fun.ADD(Integer.class), 0, 1, 2, 3, 4));
	}

	/** Tests mapping behavior. */
	@Test
	public void testMap()
	{
		List<Integer> ints = new ArrayList<Integer>(10);
		for (int i = 0; i < 10; i++)
		{
			ints.add(i);
		}

		List<Double> intsPlus1dot5 = $.map(new $<Integer, Double>()
		{
			@Override
			public Double $(Integer o)
			{
				return o + 1.5;
			}
		}, new ArrayList<Double>(5), ints);
		// also tests array list expansion

		assertEquals(10, intsPlus1dot5.size());
		for (int i = 0; i < 10; i++)
		{
			assertEquals(ints.get(i) + 1.5, intsPlus1dot5.get(i), 0.1);
		}
	}

	/** Tests self-mapping behavior. */
	@Test
	public void testMapSelf()
	{
		// also tests buffer writing

		Integer[] ints = $.mapSelf(new $<Integer, Integer>()
		{
			@Override
			public Integer $(Integer o)
			{
				return o + 1;
			}
		}, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		for (int i = 0; i < ints.length; i++)
		{
			assertEquals(i + 1, (int) ints[i]);
		}
	}
}
