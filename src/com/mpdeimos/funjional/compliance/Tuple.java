package com.mpdeimos.funjional.compliance;

import com.mpdeimos.funjional.$;

/**
 * Tuple class.
 * 
 * Java naming-standards complaint version of $.
 * 
 * @author mpdeimos
 * 
 */
public abstract class Tuple
{
	/** @return a Tuple1. */
	public static <A> Tuple1<A> create(A a)
	{
		return new Tuple1<A>(a);
	}

	/** @return a Tuple2. */
	public static <A, B> Tuple2<A, B> create(A a, B b)
	{
		return new Tuple2<A, B>(a, b);
	}

	/** @return a Tuple3. */
	public static <A, B, C> Tuple3<A, B, C> create(A a, B b, C c)
	{
		return new Tuple3<A, B, C>(a, b, c);
	}

	/** @return a Tuple4. */
	public static <A, B, C, D> Tuple4<A, B, C, D> create(A a, B b, C c, D d)
	{
		return new Tuple4<A, B, C, D>(a, b, c, d);
	}

	/** Tuple with one element. */
	public static class Tuple1<A> extends $.$1<A>
	{
		/** private Constructor. */
		private Tuple1(A a)
		{
			super(a);
		}
	}

	/** Tuple with two elements. */
	public static class Tuple2<A, B> extends $.$2<A, B>
	{
		/** private Constructor. */
		private Tuple2(A a, B b)
		{
			super(a, b);
		}
	}

	/** Tuple with three elements. */
	public static class Tuple3<A, B, C> extends $.$3<A, B, C>
	{
		/** private Constructor. */
		private Tuple3(A a, B b, C c)
		{
			super(a, b, c);
		}
	}

	/** Tuple with four elements. */
	public static class Tuple4<A, B, C, D> extends $.$4<A, B, C, D>
	{
		/** private Constructor. */
		private Tuple4(A a, B b, C c, D d)
		{
			super(a, b, c, d);
		}
	}
}
