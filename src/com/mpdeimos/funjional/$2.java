package com.mpdeimos.funjional;

import com.mpdeimos.funjional.compliance.Function;

/**
 * Curried lambda function with two arguments.
 * 
 * @author mpdeimos
 * 
 * @param <R>
 *            The return type
 * @param <A>
 *            The first function argument type
 * @param <B>
 *            The second function argument type
 */
public abstract class $2<A, B, R> extends $<A, $<B, R>>
{
	@Override
	public final Function<B, R> $(final A a)
	{
		return new Function<B, R>()
		{
			@Override
			public R call(B b)
			{
				return $2.this.$(a, b);
			}
		};
	}

	/**
	 * The lambda function implementation.
	 * 
	 * @param a
	 *            the function argument of type A
	 * @param b
	 *            the function argument of type B
	 * @return an object of type R
	 */
	public abstract R $(A a, B b);
}