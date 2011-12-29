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
