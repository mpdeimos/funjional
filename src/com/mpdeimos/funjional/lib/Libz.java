package com.mpdeimos.funjional.lib;

import com.mpdeimos.funjional.compliance.Function;
import com.mpdeimos.funjional.compliance.Function2;

import java.io.PrintStream;

/**
 * Standard function library.
 * 
 * @author mpdeimos
 * 
 */
public class Libz
{
	/**
	 * Identity function.
	 * 
	 * Object -> Object
	 * 
	 * @return The object.
	 */
	public static <O> Function<O, O> id()
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
	 * Object -> String
	 * 
	 * @return the toString representation of a object.
	 */
	public static Function<Object, String> string()
	{
		return new Function<Object, String>()
		{
			@Override
			public String call(Object o)
			{
				return o.toString();
			}
		};
	}

	/**
	 * Object -> String
	 * 
	 * @return the toString representation of a object.
	 */
	public static Function<Object, String> asString()
	{
		return string();
	}

	/**
	 * Number -> Long
	 * 
	 * @return the long representation of a number.
	 */
	public static Function<Number, Long> asLong()
	{
		return new Function<Number, Long>()
		{
			@Override
			public Long call(Number o)
			{
				if (o instanceof Integer)
				{
					return (long) (Integer) o;
				}
				if (o instanceof Short)
				{
					return (long) (Short) o;
				}
				if (o instanceof Byte)
				{
					return (long) (Byte) o;
				}
				if (o instanceof Float)
				{
					return (long) (float) (Float) o;
				}
				if (o instanceof Float)
				{
					return (long) (double) (Float) o;
				}
				return (Long) o;
			}

		};
	}

	/**
	 * Number -> Integer
	 * 
	 * @return the int representation of a number.
	 */
	public static Function<Number, Integer> asInt()
	{
		return new Function<Number, Integer>()
		{
			@Override
			public Integer call(Number o)
			{
				if (o instanceof Long)
				{
					return (int) (long) (Long) o;
				}
				if (o instanceof Short)
				{
					return (int) (Short) o;
				}
				if (o instanceof Byte)
				{
					return (int) (Byte) o;
				}
				if (o instanceof Float)
				{
					return (int) (float) (Float) o;
				}
				if (o instanceof Float)
				{
					return (int) (double) (Float) o;
				}
				return (Integer) o;
			}
		};
	}

	/**
	 * Number -> Short
	 * 
	 * @return the short representation of a number.
	 */
	public static Function<Number, Short> asShort()
	{
		return new Function<Number, Short>()
		{
			@Override
			public Short call(Number o)
			{
				if (o instanceof Long)
				{
					return (short) (long) (Long) o;
				}
				if (o instanceof Integer)
				{
					return (short) (int) (Integer) o;
				}
				if (o instanceof Byte)
				{
					return (short) (Byte) o;
				}
				if (o instanceof Float)
				{
					return (short) (float) (Float) o;
				}
				if (o instanceof Float)
				{
					return (short) (double) (Float) o;
				}
				return (Short) o;
			}
		};
	}

	/**
	 * Number -> Byte
	 * 
	 * @return the byte representation of a number.
	 */
	public static Function<Number, Byte> asByte()
	{
		return new Function<Number, Byte>()
		{
			@Override
			public Byte call(Number o)
			{
				if (o instanceof Long)
				{
					return (byte) (long) (Long) o;
				}
				if (o instanceof Integer)
				{
					return (byte) (int) (Integer) o;
				}
				if (o instanceof Short)
				{
					return (byte) (short) (Short) o;
				}
				if (o instanceof Float)
				{
					return (byte) (float) (Float) o;
				}
				if (o instanceof Float)
				{
					return (byte) (double) (Float) o;
				}
				return (Byte) o;
			}
		};
	}

	/**
	 * Number -> Double
	 * 
	 * @return the double representation of a number.
	 */
	public static Function<Number, Double> asDouble()
	{
		return new Function<Number, Double>()
		{
			@Override
			public Double call(Number o)
			{
				if (o instanceof Integer)
				{
					return (double) (Integer) o;
				}
				if (o instanceof Short)
				{
					return (double) (Short) o;
				}
				if (o instanceof Byte)
				{
					return (double) (Byte) o;
				}
				if (o instanceof Float)
				{
					return (double) (Float) o;
				}
				if (o instanceof Long)
				{
					return (double) (Long) o;
				}
				return (Double) o;
			}
		};
	}

	/**
	 * Number -> Double
	 * 
	 * @return the double representation of a number.
	 */
	public static Function<Number, Float> asFloat()
	{
		return new Function<Number, Float>()
		{
			@Override
			public Float call(Number o)
			{
				if (o instanceof Integer)
				{
					return (float) (Integer) o;
				}
				if (o instanceof Short)
				{
					return (float) (Short) o;
				}
				if (o instanceof Byte)
				{
					return (float) (Byte) o;
				}
				if (o instanceof Double)
				{
					return (float) (double) (Double) o;
				}
				if (o instanceof Long)
				{
					return (float) (Long) o;
				}
				return (Float) o;
			}
		};
	}

	/**
	 * PrintStream -> Object -> Object
	 * 
	 * @return prints the toString representation of an object to a PrintStream.
	 */
	public static Function2<PrintStream, Object, Object> print()
	{
		return new Function2<PrintStream, Object, Object>()
		{
			@Override
			public Object call(PrintStream stream, Object o)
			{
				stream.println(o);
				return o;
			}
		};
	}

	/**
	 * Object -> Object
	 * 
	 * @return prints the toString representation of an object to sysout.
	 */
	public static Function<Object, Object> sysout()
	{
		return print().$(System.out);
	}

	/**
	 * Object -> Object
	 * 
	 * @return prints the toString representation of an object to syserr.
	 */
	public static Function<Object, Object> syserr()
	{
		return print().$(System.err);
	}

	// /**
	// * A -> B -> _(A, B)
	// *
	// * @return takes the second argument of a function
	// */
	// public static <A, B> $<A, $<B, _2(A, B)>> zip()
	// {
	// return new Function2<A, B, _2(A, B)>()
	// {
	// @Override
	// public _2(A, B) call(A a, B b)
	// {
	// return _._(a, b);
	// }
	// };
	// }
}
