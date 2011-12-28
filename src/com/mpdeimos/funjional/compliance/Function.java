package com.mpdeimos.funjional.compliance;

import com.mpdeimos.funjional._;

/**
 * Lambda function class. Verbose notation (Java-naming standards complaint)
 * with 'Function' as class name and 'call' as function name.
 * 
 * @author mpdeimos
 * 
 * @param <R>
 *            The return type
 * @param <O>
 *            The function argument type
 */
public abstract class Function<R, O> extends _<R, O>
{
	@Override
	public final R _(O o)
	{
		return call(o);
	}

	/**
	 * The lambda function implementation.
	 * 
	 * @param o
	 *            the function argument of type O
	 * @return an object of type R
	 */
	public abstract R call(O o);
}
