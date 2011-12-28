package com.mpdeimos.funjional;

/**
 * Tuple class.
 * 
 * @author mpdeimos
 * 
 */
public abstract class $
{
	/** @return a $1. */
	public static <A> $1<A> $(A a)
	{
		return new $1<A>(a);
	}

	/** @return a $2. */
	public static <A, B> $2<A, B> $(A a, B b)
	{
		return new $2<A, B>(a, b);
	}

	/** @return a $3. */
	public static <A, B, C> $3<A, B, C> $(A a, B b, C c)
	{
		return new $3<A, B, C>(a, b, c);
	}

	/** @return a $4. */
	public static <A, B, C, D> $4<A, B, C, D> $(A a, B b, C c, D d)
	{
		return new $4<A, B, C, D>(a, b, c, d);
	}

	/** Tuple with one element. */
	public static class $1<A> extends $
	{
		/** The first element. */
		public A a;

		/** private Constructor. */
		protected $1(A a)
		{
			this.a = a;
		}
	}

	/** Tuple with two elements. */
	public static class $2<A, B> extends $1<A>
	{
		/** The second element. */
		public B b;

		/** private Constructor. */
		protected $2(A a, B b)
		{
			super(a);
			this.b = b;
		}
	}

	/** Tuple with three elements. */
	public static class $3<A, B, C> extends $2<A, B>
	{
		/** The third element. */
		public C c;

		/** private Constructor. */
		protected $3(A a, B b, C c)
		{
			super(a, b);
			this.c = c;
		}
	}

	/** Tuple with four elements. */
	public static class $4<A, B, C, D> extends $3<A, B, C>
	{
		/** The fourth element. */
		public D d;

		/** private Constructor. */
		protected $4(A a, B b, C c, D d)
		{
			super(a, b, c);
			this.d = d;
		}
	}
}
