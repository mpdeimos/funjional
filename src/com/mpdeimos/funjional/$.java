package com.mpdeimos.funjional;

import com.mpdeimos.funjional._._2;
import com.mpdeimos.funjional.compliance.Function;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

	// / FOLD LEFT / //

	/**
	 * Folds over an Iterable of type O from the left (natural order, index 0 to
	 * index n).
	 * 
	 * @param <R>
	 *            The lambda function return type.
	 * @param <O>
	 *            The lambda function argument type.
	 * @param $
	 *            The lambda function R -> O -> R
	 * @param acc
	 *            The accumulator (initial value)
	 * @param os
	 *            The Iterable of type O
	 * @return and element of type R.
	 */
	public static <O, R> R foldLeft(
			$<R, $<O, R>> $,
			R acc,
			Iterable<O> os)
	{
		for (O o : os)
		{
			acc = $.$(acc).$(o);
		}

		return acc;
	}

	/**
	 * TODO
	 * 
	 * @param <O>
	 * @param <R>
	 * @return
	 */
	public static <O, R> $3<$$<R, O>, R, Iterable<O>, R> foldLeft()
	{
		return new $3<$$<R, O>, R, Iterable<O>, R>()
		{
			@Override
			public R $($$<R, O> f, R acc, Iterable<O> os)
			{
				return foldLeft(f, acc, os);
			}
		};
	}

	/**
	 * Folds over an Array of type O from the left (natural order, index 0 to
	 * index n).
	 * 
	 * @param <R>
	 *            The lambda function return type.
	 * @param <O>
	 *            The lambda function argument type.
	 * @param $
	 *            The lambda function R -> O -> R
	 * @param acc
	 *            The accumulator (initial value)
	 * @param os
	 *            The Array of type O
	 * @return and element of type R.
	 */
	public static <O, R> R foldLeft($<R, $<O, R>> $, R acc, O... os)
	{
		return foldLeft($, acc, Arrays.asList(os));
	}

	/** TODO */
	public static <O, R> $3<$$<R, O>, R, O[], R> foldLeft2()
	{
		return new $3<$$<R, O>, R, O[], R>()
		{
			@Override
			public R $($$<R, O> f, R acc, O[] os)
			{
				return foldLeft(f, acc, os);
			}
		};
	}

	// / FOLD RIGHT ///

	/**
	 * Folds over an Iterable of type O from the right (reverse order, index n
	 * to index 1).
	 * 
	 * @param <R>
	 *            The lambda function return type.
	 * @param <O>
	 *            The lambda function argument type.
	 * @param $
	 *            The lambda function R -> O -> R
	 * @param acc
	 *            The accumulator (initial value)
	 * @param os
	 *            The Iterable of type O
	 * @return and element of type R.
	 */
	public static <O, R> R foldRight($<R, $<O, R>> $, R acc, List<O> os)
	{
		for (int i = os.size() - 1; i >= 0; --i)
		{
			acc = $.$(acc).$(os.get(i));
		}

		return acc;
	}

	/**
	 * Folds over an Array of type O from the right (reverse order, index n to
	 * index 0).
	 * 
	 * @param <R>
	 *            The lambda function return type.
	 * @param <O>
	 *            The lambda function argument type.
	 * @param $
	 *            The lambda function R -> O -> R
	 * @param acc
	 *            The accumulator (initial value)
	 * @param os
	 *            The Array of type O
	 * @return and element of type R.
	 */
	public static <O, R> R foldRight($<R, $<O, R>> $, R acc, O... os)
	{
		return foldRight($, acc, Arrays.asList(os));
	}

	// / MAP ///

	/**
	 * Maps the elements of an Iterable into a new Collection.
	 * 
	 * @param <R>
	 *            The mapping type.
	 * @param <O>
	 *            The Iterable type.
	 * @param <C>
	 *            The buffer collection type.
	 * @param $
	 *            The mapping function O -> R
	 * @param buffer
	 *            The buffer to map into.
	 * @param os
	 *            The Iterable to map.
	 * @return A collection of type C with elements mapped from os.
	 */
	public static <R, O, C extends Collection<R>> C map(
			final $<O, R> $,
			C buffer,
			Iterable<O> os)
	{
		return foldLeft(new $$<C, O>()
		{
			@Override
			public C $(C acc, O o)
			{
				acc.add($.$(o));
				return acc;
			}
		}, buffer, os);
	}

	/**
	 * Maps the elements of a List into a new List.
	 * 
	 * @param <R>
	 *            The mapping type.
	 * @param <O>
	 *            The List type.
	 * @param <C>
	 *            The buffer List type.
	 * @param $
	 *            The mapping function O -> R
	 * @param buffer
	 *            The buffer to map into.
	 * @param os
	 *            The List to map.
	 * @return A List of type C with elements mapped from os.
	 */
	public static <R, O, L extends List<R>> L map(
			final $<O, R> $,
			L buffer,
			Iterable<O> os)
	{
		return foldLeft(new $$<_2<L, Integer>, O>()
		{
			@Override
			public _2<L, Integer> $(_2<L, Integer> acc, O o)
			{
				if (acc.a.size() > acc.b)
				{
					acc.a.set(acc.b, $.$(o));
				}
				else
				{
					acc.a.add($.$(o));
				}

				acc.b++;

				return acc;
			}

		}, _._(buffer, 0), os).a;
	}

	/**
	 * Maps the elements of a List into a new List which is dynamically
	 * allocated and returned.
	 * 
	 * @param <R>
	 *            The mapping type.
	 * @param <O>
	 *            The List type.
	 * @param $
	 *            The mapping function O -> R
	 * @param os
	 *            The List to map.
	 * @return A List of type R with elements mapped from os.
	 */
	public static <O, R> List<R> map(final $<O, R> $, List<O> os)
	{
		return map($, new ArrayList<R>(os.size()), os);
	}

	/**
	 * Maps the elements of a List into the same List.
	 * 
	 * @param <O>
	 *            The List type.
	 * @param $
	 *            The mapping function O -> O
	 * @param os
	 *            The List to map.
	 * @return The list os.
	 */
	public static <O> List<O> mapSelf(final $<O, O> $, List<O> os)
	{
		return map($, os, os);
	}

	/**
	 * Maps the elements of an array into a buffer array and returns it.
	 * 
	 * @param <R>
	 *            The mapping type.
	 * @param <O>
	 *            The array type.
	 * @param $
	 *            The mapping function O -> R
	 * @param buffer
	 *            the buffer array to map into.
	 * @param os
	 *            The array to map.
	 * @return The buffer.
	 */
	public static <R, O> R[] map(final $<O, R> $, R[] buffer, O... os)
	{
		map($, Arrays.asList(buffer), Arrays.asList(os));
		return buffer;
	}

	/**
	 * Maps the elements of an array into a fresh allocated buffer array and
	 * returns it.
	 * 
	 * @param <R>
	 *            The mapping type.
	 * @param <O>
	 *            The array type.
	 * @param $
	 *            The mapping function O -> R
	 * @param os
	 *            The array to map.
	 * @return The newly allocated array with the mapped elements.
	 */
	public static <R, O> R[] map(final $<O, R> $, O... os)
	{
		@SuppressWarnings("unchecked")
		R[] buffer = (R[]) Array.newInstance($.getReturnType(), os.length);
		return map($, buffer, os);
	}

	/**
	 * Maps the elements of an array into itself and returns it.
	 * 
	 * @param <R>
	 *            The mapping type.
	 * @param <O>
	 *            The array type.
	 * @param $
	 *            The mapping function O -> O
	 * @param os
	 *            The array to map.
	 * @return os.
	 */
	public static <O> O[] mapSelf(final $<O, O> $, O... os)
	{
		return map($, os, os);
	}
}