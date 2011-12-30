package com.mpdeimos.funjional.type;

public class Option<E>
{
	public static <E> Option<E> some(E e)
	{
		return new Some<E>(e);
	}

	public static <E> Option<E> none()
	{
		return new None<E>();
	}

	public static Nil nil()
	{
		return new Nil();
	}

	public static class Some<E> extends Option<E>
	{
		E some;

		private Some(E e)
		{
			some = e;
		}
	}

	public static class None<E> extends Option<E>
	{
		private None()
		{

		}
	}

	public static class Nil extends None<Object>
	{
		private Nil()
		{

		}
	}
}
