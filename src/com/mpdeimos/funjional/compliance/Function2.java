package com.mpdeimos.funjional.compliance;

import com.mpdeimos.funjional.$2;

/**
 * Curried lambda function with two arguments. Verbose notation (Java-naming
 * standards complaint) with 'Function' as class name and 'call' as function
 * name.
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
public abstract class Function2<A, B, R> extends $2<A, B, R>
{
	@Override
	public final R $(A a, B b)
	{
		return call(a, b);
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
	public abstract R call(A a, B b);

	/**
	 * The lambda function implementation.
	 * 
	 * @param A
	 *            the function argument of type O
	 * @return an object of type R
	 */
	public Function<B, R> call(A a)
	{
		return this.$(a);
	}
}
