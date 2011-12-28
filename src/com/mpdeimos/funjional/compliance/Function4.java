package com.mpdeimos.funjional.compliance;

import com.mpdeimos.funjional.$4;

/**
 * Curried lambda function with four arguments. Verbose notation (Java-naming
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
 * @param <D>
 *            The fourth function argument type
 */
public abstract class Function4<A, B, C, D, R> extends $4<A, B, C, D, R>
{
	@Override
	public final R $(A a, B b, C c, D d)
	{
		return call(a, b, c, d);
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
	public abstract R call(A a, B b, C c, D d);

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
	public Function<D, R> call(A a, B b, C c)
	{
		return this.$(a, b, c);
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
	public Function2<C, D, R> call(A a, B b)
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
	public Function3<B, C, D, R> call(A a)
	{
		return this.$(a);
	}
}
