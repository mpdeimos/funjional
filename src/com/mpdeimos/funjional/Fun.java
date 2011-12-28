package com.mpdeimos.funjional;

import com.mpdeimos.funjional.compliance.Accumulation;
import com.mpdeimos.funjional.compliance.Function;
import com.mpdeimos.funjional.compliance.Function2;

/**
 * Function library. This library makes use of the java standard-complaint
 * classes.
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
	 * Accumulated addition
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
			@Override
			public N call(N acc, N o)
			{
				return ADD(acc).call(o);
			}
		};
	}

	/**
	 * Accumulated addition
	 * 
	 * @param <N>
	 *            a number type
	 * @param type
	 * @return
	 */
	public static <N extends Number> Accumulation<N, N> add()
	{
		return new Accumulation<N, N>()
		{
			@Override
			public N call(N acc, N o)
			{
				return ADD(acc).call(o);
			}
		};
	}

	/**
	 * Addition
	 * 
	 * @param <N>
	 *            a number type
	 * @param type
	 * @return
	 */
	public static <N extends Number> Function<N, N> ADD(final N number)
	{
		return new Function<N, N>()
		{
			@SuppressWarnings("unchecked")
			@Override
			public N call(N o)
			{
				if (o instanceof Double)
				{
					Double r = (Double) number + (Double) o;
					return (N) r;
				}
				if (o instanceof Integer)
				{
					Integer r = (Integer) number + (Integer) o;
					return (N) r;
				}
				if (o instanceof Float)
				{
					Float r = (Float) number + (Float) o;
					return (N) r;
				}
				return null;
			}
		};
	}

	// /**
	// * Accumulated multiplication
	// *
	// * @param <N>
	// * a number type
	// * @param type
	// * @return
	// */
	// public static <N extends Number> Accumulation<N, N> MUL(Class<N> type)
	// {
	// return new Accumulation<N, N>()
	// {
	// @Override
	// public N call(N acc, N o)
	// {
	// return MUL(acc).call(o);
	// }
	// };
	// }

	/**
	 * Multiplication
	 * 
	 * @param <N>
	 *            a number type
	 * @param type
	 * @return
	 */
	public static <N extends Number> Function<N, N> MUL(final N number)
	{
		return new Function<N, N>()
		{
			@SuppressWarnings("unchecked")
			@Override
			public N call(N o)
			{
				if (o instanceof Double)
				{
					Double r = (Double) number * (Double) o;
					return (N) r;
				}
				if (o instanceof Integer)
				{
					Integer r = (Integer) number * (Integer) o;
					return (N) r;
				}
				if (o instanceof Float)
				{
					Float r = (Float) number * (Float) o;
					return (N) r;
				}
				return null;
			}
		};
	}

	/**
	 * Multiplication
	 * 
	 * @param <N>
	 *            a number type
	 * @param type
	 * @return
	 */
	public static <N extends Number> Function2<N, N, N> mul(
			Class<N> type)
	{
		return Fun.<N> mul();
	}

	/** TODO */
	public static <N extends Number> Function2<N, N, N> mul()
	{
		return new Function2<N, N, N>()
		{
			@SuppressWarnings("unchecked")
			@Override
			public N call(N a, N b)
			{
				if (b instanceof Double)
				{
					Double r = (Double) a * (Double) b;
					return (N) r;
				}
				if (b instanceof Integer)
				{
					Integer r = (Integer) a * (Integer) b;
					return (N) r;
				}
				if (b instanceof Float)
				{
					Float r = (Float) a * (Float) b;
					return (N) r;
				}
				return null;
			}
		};
	}

	public static $<Integer[], Integer> sum()
	{
		return $.<Integer, Integer> foldLeft2().$(Fun.<Integer> add(), 0);
	}
}
