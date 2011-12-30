package com.mpdeimos.funjional;

import com.mpdeimos.funjional.compliance.Function;
import com.mpdeimos.funjional.compliance.Function2;
import com.mpdeimos.funjional.compliance.Function3;

/**
 * Curried lambda function with four arguments.
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
 * @param <D>
 *            The fourth function argument type
 */
public abstract class $4<A, B, C, D, R> extends $<A, $<B, $<C, $<D, R>>>>
{
	@Override
	public final Function3<B, C, D, R> $(final A a)
	{
		return new Function3<B, C, D, R>()
		{
			@Override
			public R call(B b, C c, D d)
			{
				return $4.this.$(a, b, c, d);
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
	public Function2<C, D, R> $(A a, B b)
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
	public Function<D, R> $(A a, B b, C c)
	{
		return this.$(a, b).$(c);
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
	 * @param d
	 *            the function argument of type D
	 * @return an object of type R
	 */
	public abstract R $(A a, B b, C c, D d);
}