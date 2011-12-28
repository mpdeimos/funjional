package com.mpdeimos.funjional.compliance;

import com.mpdeimos.funjional.__;

/**
 * Accumulator function class. Verbose notation (Java-naming standards
 * complaint) with 'AccumulatorFunction' as class name and 'call' as function
 * name.
 * 
 * @author mpdeimos
 * 
 * @param <R>
 *            The return type
 * @param <O>
 *            The function argument type
 */
public abstract class Accumulation<R, O> extends __<R, O>
{
	/**
	 * The accumulator function.
	 * 
	 * @param acc
	 *            The accumulator.
	 * @param o
	 *            The current object.
	 * @return the new accumulator.
	 */
	public abstract R call(R acc, O o);

	@Override
	public R __(R acc, O o)
	{
		return call(acc, o);
	}
}
