package com.mpdeimos.funjional.compliance;

import com.mpdeimos.funjional.$3;

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
 * @param <C>
 *            The third function argument type
 */
public abstract class Function3<A, B, C, R> extends $3<A, B, C, R>
{
	@Override
	public final R $(A a, B b, C c)
	{
		return call(a, b, c);
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
	public abstract R call(A a, B b, C c);

	/**
	 * The lambda function implementation.
	 * 
	 * @param A
	 *            the function argument of type O
	 * @return an object of type R
	 */
	public Function<C, R> call(A a, B b)
	{
		return this.$(a, b);
	}

	/**
	 * The lambda function implementation.
	 * 
	 * @param A
	 *            the function argument of type O
	 * @return an object of type R
	 */
	public Function2<B, C, R> call(A a)
	{
		return this.$(a);
	}
}
