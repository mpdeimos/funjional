package com.mpdeimos.funjional;

/**
 * Tuple class.
 * 
 * @author mpdeimos
 * 
 */
public abstract class _
{
	/** @return a $1. */
	public static <A> _1<A> _(A a)
	{
		return new _1<A>(a);
	}

	/** @return a $2. */
	public static <A, B> _2<A, B> _(A a, B b)
	{
		return new _2<A, B>(a, b);
	}

	/** @return a $3. */
	public static <A, B, C> _3<A, B, C> _(A a, B b, C c)
	{
		return new _3<A, B, C>(a, b, c);
	}

	/** @return a $4. */
	public static <A, B, C, D> _4<A, B, C, D> _(A a, B b, C c, D d)
	{
		return new _4<A, B, C, D>(a, b, c, d);
	}

	/** Tuple with one element. */
	public static class _1<A> extends _
	{
		/** The first element. */
		public A a;

		/** private Constructor. */
		protected _1(A a)
		{
			this.a = a;
		}
	}

	/** Tuple with two elements. */
	public static class _2<A, B> extends _1<A>
	{
		/** The second element. */
		public B b;

		/** private Constructor. */
		protected _2(A a, B b)
		{
			super(a);
			this.b = b;
		}
	}

	/** Tuple with three elements. */
	public static class _3<A, B, C> extends _2<A, B>
	{
		/** The third element. */
		public C c;

		/** private Constructor. */
		protected _3(A a, B b, C c)
		{
			super(a, b);
			this.c = c;
		}
	}

	/** Tuple with four elements. */
	public static class _4<A, B, C, D> extends _3<A, B, C>
	{
		/** The fourth element. */
		public D d;

		/** private Constructor. */
		protected _4(A a, B b, C c, D d)
		{
			super(a, b, c);
			this.d = d;
		}
	}
}
