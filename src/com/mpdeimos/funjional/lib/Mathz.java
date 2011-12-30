package com.mpdeimos.funjional.lib;

import com.mpdeimos.funjional.compliance.Function;
import com.mpdeimos.funjional.compliance.Function2;

/**
 * Math function library.
 * 
 * @author mpdeimos
 * 
 */
public class Mathz
{
	/** @return the assimilated type of N to A */
	public static <A extends Number, N extends Number> Function2<A, N, A> assimilate()
	{
		return new Function2<A, N, A>()
		{
			@SuppressWarnings("unchecked")
			@Override
			public A call(A a, N b)
			{
				if (a instanceof Long)
				{
					return (A) Libz.asLong().$(b);
				}
				if (a instanceof Integer)
				{
					return (A) Libz.asInt().$(b);
				}
				if (a instanceof Short)
				{
					return (A) Libz.asShort().$(b);
				}
				if (a instanceof Byte)
				{
					return (A) Libz.asByte().$(b);
				}
				if (a instanceof Float)
				{
					return (A) Libz.asFloat().$(b);
				}
				if (a instanceof Double)
				{
					return (A) Libz.asDouble().$(b);
				}
				return (A) b;
			}
		};
	}

	/** @return the assimilated type of N to A */
	public static <A extends Number, B extends Number> Function<A, B> assimilate(
			final Class<B> hint)
	{
		return new Function<A, B>()
		{
			@SuppressWarnings("unchecked")
			@Override
			public B call(A a)
			{
				if (hint.getClass().equals(Long.class))
				{
					return (B) Libz.asLong().$(a);
				}
				if (hint.getClass().equals(Integer.class))
				{
					return (B) Libz.asInt().$(a);
				}
				if (hint.getClass().equals(Short.class))
				{
					return (B) Libz.asShort().$(a);
				}
				if (hint.getClass().equals(Byte.class))
				{
					return (B) Libz.asByte().$(a);
				}
				if (hint.getClass().equals(Float.class))
				{
					return (B) Libz.asFloat().$(a);
				}
				if (hint.getClass().equals(Double.class))
				{
					return (B) Libz.asDouble().$(a);
				}
				return (B) a;
			}
		};
	}

	/** $2<N, N, N> a, b = a + b */
	public static <N extends Number> Function2<N, N, N> add()
	{
		return new Function2<N, N, N>()
		{
			@Override
			public N call(N a, N b)
			{
				if (b instanceof Long || b instanceof Integer
						|| b instanceof Short || b instanceof Byte)
				{
					Long r = Libz.asLong().$(a) + Libz.asLong().$(b);
					return Mathz.<N, Long> assimilate().$(a, r);
				}
				if (b instanceof Double || b instanceof Float)
				{
					Double r = Libz.asDouble().$(a) + Libz.asDouble().$(b);
					return Mathz.<N, Double> assimilate().$(a, r);
				}
				throw new IllegalArgumentException();
			}
		};
	}

	/** $2<N, N, N> a, b = a - b */
	public static <N extends Number> Function2<N, N, N> sub()
	{
		return new Function2<N, N, N>()
		{
			@Override
			public N call(N a, N b)
			{
				if (b instanceof Long || b instanceof Integer
						|| b instanceof Short || b instanceof Byte)
				{
					Long r = Libz.asLong().$(a) - Libz.asLong().$(b);
					return Mathz.<N, Long> assimilate().$(a, r);
				}
				if (b instanceof Double || b instanceof Float)
				{
					Double r = Libz.asDouble().$(a) - Libz.asDouble().$(b);
					return Mathz.<N, Double> assimilate().$(a, r);
				}
				throw new IllegalArgumentException();
			}
		};
	}

	/** $2<N, N, N> a, b = a * b */
	public static <N extends Number> Function2<N, N, N> mul()
	{
		return new Function2<N, N, N>()
		{
			@Override
			public N call(N a, N b)
			{
				if (b instanceof Long || b instanceof Integer
						|| b instanceof Short || b instanceof Byte)
				{
					Long r = Libz.asLong().$(a) * Libz.asLong().$(b);
					return Mathz.<N, Long> assimilate().$(a, r);
				}
				if (b instanceof Double || b instanceof Float)
				{
					Double r = Libz.asDouble().$(a) * Libz.asDouble().$(b);
					return Mathz.<N, Double> assimilate().$(a, r);
				}
				throw new IllegalArgumentException();
			}
		};
	}

	/** $2<N, N, N> a, b = a / b */
	public static <N extends Number> Function2<N, N, N> div()
	{
		return new Function2<N, N, N>()
		{
			@Override
			public N call(N a, N b)
			{
				if (b instanceof Long || b instanceof Integer
						|| b instanceof Short || b instanceof Byte)
				{
					Long r = Libz.asLong().$(a) / Libz.asLong().$(b);
					return Mathz.<N, Long> assimilate().$(a, r);
				}
				if (b instanceof Double || b instanceof Float)
				{
					Double r = Libz.asDouble().$(a) / Libz.asDouble().$(b);
					return Mathz.<N, Double> assimilate().$(a, r);
				}
				throw new IllegalArgumentException();
			}
		};
	}

	//
	// /** The sum over an list */
	// public static $<Iterable<Number>, Number> sum()
	// {
	// return Arrayz.<Number, Number> foldLeft().$(Fun.<Number> add(), 0);
	// }
}
