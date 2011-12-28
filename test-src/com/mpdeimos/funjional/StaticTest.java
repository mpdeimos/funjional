package com.mpdeimos.funjional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.mpdeimos.funjional.Fun;
import com.mpdeimos.funjional._;
import com.mpdeimos.funjional.__;

public class StaticTest
{
	@Test
	public void testFoldRight()
	{
		List<Integer> ints = new ArrayList<Integer>(10);
		Integer[] intArray = new Integer[]{0,1,2,3,4,5,6,7,8,9};
		for (int i = 0; i < 10; i++)
		{
			ints.add(i);
		}
		
		assertEquals(45, _.foldRight(new __<Double, Integer>() {
			@Override
			public Double $(Double acc, Integer o) {
				return acc+o;
			}
		}, 0.0, ints), 0.1);
		
		assertEquals(45, (int)_.foldRight(Fun.ADD(Integer.class), 0, ints));
		assertEquals(45, (int)_.foldRight(Fun.ADD(Integer.class), 0, intArray));
		assertEquals(10, (int)_.foldRight(Fun.ADD(Integer.class), 0, 1,2,3,4));
	}
	
	@Test
	public void testMap()
	{
		List<Integer> ints = new ArrayList<Integer>(10);
		for (int i = 0; i < 10; i++)
		{
			ints.add(i);
		}
		
		List<Double> intsPlus1dot5 = _.map(new _<Double, Integer>()
		{
			@Override
			public Double $(Integer o) {
				return o+1.5;
			}
		}, new ArrayList<Double>(10), ints);
		
		assertEquals(10, intsPlus1dot5.size());
		for (int i = 0; i < 10; i++)
		{
			assertEquals(ints.get(i) +1.5, intsPlus1dot5.get(i), 0.1);
		}
	}
}
