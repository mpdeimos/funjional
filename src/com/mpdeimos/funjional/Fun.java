package com.mpdeimos.funjional;

import com.mpdeimos.funjional.compliance.Accumulation;
import com.mpdeimos.funjional.compliance.Function;

/**
 * Function library.
 * 
 * @author mpdeimos
 * 
 */
public abstract class Fun
{
	/**
	 * Identity function.
	 * 
	 * @param <O>
	 *            The object type.
	 * @param o
	 *            The object.
	 * @return The object.
	 */
	public static <O> Function<O, O> ID(O o)
	{
		return new Function<O, O>()
		{
			@Override
			public O call(O o)
			{
				return o;
			}
		};
	}

	/**
	 * Accumulation
	 * 
	 * @param <N>
	 *            a number type
	 * @param type
	 * @return
	 */
	public static <N extends Number> Accumulation<N, N> ADD(Class<N> type)
	{
		return new Accumulation<N, N>()
		{
			@SuppressWarnings("unchecked")
			@Override
			public N call(N acc, N o)
			{
				if (o instanceof Double)
				{
					Double r = (Double) acc + (Double) o;
					return (N) r;
				}
				if (o instanceof Integer)
				{
					Integer r = (Integer) acc + (Integer) o;
					return (N) r;
				}
				if (o instanceof Float)
				{
					Float r = (Float) acc + (Float) o;
					return (N) r;
				}
				return null;
			}
		};
	}
}
