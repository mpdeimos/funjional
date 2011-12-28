package com.mpdeimos.funjional.compliance;

import com.mpdeimos.funjional.$;

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
public abstract class Function<O, R> extends $<O, R>
{
	@Override
	public final R $(O o)
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
