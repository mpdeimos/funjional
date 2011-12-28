package com.mpdeimos.funjional;

public abstract class Zip
{
	public static <A> Zip1<A> zip(A a)
	{
		return new Zip1<A>(a);
	}
	
	public static <A, B> Zip2<A, B> zip(A a, B b)
	{
		return new Zip2<A, B>(a, b);
	}
	
	public static <A, B, C> Zip3<A, B, C> zip(A a, B b, C c)
	{
		return new Zip3<A, B, C>(a, b, c);
	}
	
	public static <A, B, C, D> Zip4<A, B, C, D> zip(A a, B b, C c, D d)
	{
		return new Zip4<A, B, C, D>(a, b, c, d);
	}
	
	public static class Zip1<A>  extends Zip
	{
		public A a;
		
		private Zip1(A a)
		{
			this.a = a;
		}
	}
	
	public static class Zip2<A, B>  extends Zip1<A>
	{
		public B b;
		
		private Zip2(A a, B b)
		{
			super(a);
			this.b = b;
		}
	}
	
	public static class Zip3<A, B, C>  extends Zip2<A, B>
	{
		public C c;
		
		private Zip3(A a, B b, C c)
		{
			super(a, b);
			this.c = c;
		}
	}
	
	public static class Zip4<A, B, C, D>  extends Zip3<A, B, C>
	{
		public D d;
		
		private Zip4(A a, B b, C c, D d)
		{
			super(a, b, c);
			this.d = d;
		}
	}
}
