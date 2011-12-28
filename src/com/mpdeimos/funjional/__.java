package com.mpdeimos.funjional;

import com.mpdeimos.funjional.$.$2;

/**
 * Accumulator Function class.
 * 
 * @author mpdeimos
 * 
 * @param <R>
 *            The accumulator type.
 * @param <O>
 *            The object type.
 */
public abstract class __<R, O> extends _<R, $.$2<R, O>>
{
	@Override
	public final R _($2<R, O> o)
	{
		return $(o.a, o.b);
	}

	/**
	 * The accumulator function.
	 * 
	 * @param acc
	 *            The accumulator.
	 * @param o
	 *            The current object.
	 * @return the new accumulator.
	 */
	public abstract R $(R acc, O o);
}
