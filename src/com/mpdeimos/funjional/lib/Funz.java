package com.mpdeimos.funjional.lib;

import com.mpdeimos.funjional.$;
import com.mpdeimos.funjional.compliance.Function;
import com.mpdeimos.funjional.compliance.Function2;

/** Function library for functions. */
public class Funz
{
	/**
	 * O -> X -> O
	 * 
	 * @return takes the first argument of a function
	 */
	public static <O, X> Function2<O, X, O> first()
	{
		return new Function2<O, X, O>()
		{
			@Override
			public O call(O a, X b)
			{
				return a;
			}
		};
	}

	/**
	 * X -> O -> O
	 * 
	 * @return takes the second argument of a function
	 */
	public static <X, O> Function2<X, O, O> second()
	{
		return new Function2<X, O, O>()
		{
			@Override
			public O call(X a, O b)
			{
				return b;
			}
		};
	}

	/**
	 * (X -> (A -> B)) -> (A -> A) -> (X -> (A -> B))
	 * 
	 * @return intercepts a higher order function call.
	 */
	public static <X, A, B> Function2<$<X, $<A, B>>, $<A, A>, $<X, $<A, B>>> intercept()
	{
		return new Function2<$<X, $<A, B>>, $<A, A>, $<X, $<A, B>>>()
		{
			@Override
			public $<X, $<A, B>> call($<X, $<A, B>> a, $<A, A> b)
			{
				return a.x(Funz.<A, B> prepend().$(b));
			}
		};
	}

	/**
	 * (A -> B) -> (A -> A) -> (A -> B)
	 * 
	 * @return prepends an function call
	 */
	public static <A, B> Function2<$<A, A>, $<A, B>, $<A, B>> prepend()
	{
		return new Function2<$<A, A>, $<A, B>, $<A, B>>()
		{
			@Override
			public $<A, B> call($<A, A> a, $<A, B> b)
			{
				return a.x(b);
			}
		};
	}

	/**
	 * (A -> B -> C) -> (B -> A -> C)
	 * 
	 * @return swaps the arguments of a function
	 */
	public static <A, B, C> Function<$<A, $<B, C>>, $<B, $<A, C>>> swap()
	{
		return new Function<$<A, $<B, C>>, $<B, $<A, C>>>()
		{
			@Override
			public $<B, $<A, C>> call(final $<A, $<B, C>> o)
			{
				return new Function2<B, A, C>()
				{
					@Override
					public C call(B b, A a)
					{
						return o.$(a).$(b);
					}
				};
			}
		};
	}

	/**
	 * (A -> B -> C) -> (B -> A -> C)
	 * 
	 * @return swaps the arguments of a function
	 */
	public static <A, B, C> $<B, $<A, C>> swap(final $<A, $<B, C>> $)
	{
		return Funz.<A, B, C> swap().$($);
	}
}
