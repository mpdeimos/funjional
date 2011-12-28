package com.mpdeimos.funjional;

import com.mpdeimos.funjional.compliance.Function;
import com.mpdeimos.funjional.compliance.Function2;

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
 * @param <C>
 *            The third function argument type
 */
public abstract class $3<A, B, C, R> extends $<A, $2<B, C, R>>
{
	@Override
	public final Function2<B, C, R> $(final A a)
	{
		return new Function2<B, C, R>()
		{
			@Override
			public R call(B b, C c)
			{
				return $3.this.$(a, b, c);
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
	public Function<C, R> $(A a, B b)
	{
		return this.$(a).$(b);
	}

	/**
	 * The lambda function implementation.
	 * 
	 * @param a
	 *            the function argument of type A
	 * @param b
	 *            the function argument of type B
	 * @param c
	 *            the function argument of type C
	 * @return an object of type R
	 */
	public abstract R $(A a, B b, C c);
}