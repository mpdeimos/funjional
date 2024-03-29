package com.mpdeimos.funjional;

import com.mpdeimos.funjional.compliance.Function;

/**
 * Lambda function class. Shorthand notation with underscores for class name and
 * function call.
 * 
 * @author mpdeimos
 * 
 * @param <R>
 *            The return type
 * @param <O>
 *            The function argument type
 */
public abstract class $<O, R>
{
	/**
	 * The lambda function implementation.
	 * 
	 * @param o
	 *            the function argument of type O
	 * @return an object of type R
	 */
	public abstract R $(O o);

	/**
	 * Function composition.
	 * 
	 * (g o f)(x) = g(f(x))
	 * 
	 * Composes a new function out of this function and another function f, with
	 * f being applied first.
	 * 
	 * @param <N>
	 * @param f
	 * @return
	 */
	public <N> Function<N, R> o(final $<N, O> f)
	{
		return new Function<N, R>()
		{
			@Override
			public R call(N o)
			{
				return $.this.$(f.$(o));
			}
		};
	}

	/**
	 * Function append.
	 * 
	 * (g a f)(x) = f(g(x))
	 * 
	 * Composes a new function out of this function and another function f, with
	 * this function being applied first than f. Note that f takes the full
	 * return type of this function - this
	 * 
	 * @param <N>
	 * @param f
	 * @return
	 */
	public <N> Function<O, N> a(final $<R, N> f)
	{
		return new Function<O, N>()
		{
			@Override
			public N call(O o)
			{
				return f.$($.this.$(o));
			}
		};
	}

	/**
	 * Function interception.
	 * 
	 * (g x f)(a) = f(g(a))
	 * 
	 * Composes a new function out of this function and another function f, with
	 * this function being applied first than f. Note that f takes the full
	 * return type of this function - this
	 * 
	 * @param <N>
	 * @param f
	 * @return
	 */
	public <N> Function<O, N> x(final $<R, N> f)
	{
		return new Function<O, N>()
		{
			@Override
			public N call(O o)
			{
				return f.$($.this.$(o));
			}
		};
	}

	/**
	 * @return The Class of return type R.
	 */
	@SuppressWarnings("unchecked")
	public Class<R> getReturnType()
	{
		return (Class<R>) Utils.getGenericType(this, $.class, 0);
	}

	/**
	 * @return The Class of argument type O.
	 */
	@SuppressWarnings("unchecked")
	public Class<O> getArgumentType()
	{
		return (Class<O>) Utils.getGenericType(this, $.class, 1);
	}

}