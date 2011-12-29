package com.mpdeimos.funjional.lib;

import com.mpdeimos.funjional.$;
import com.mpdeimos.funjional.$2;
import com.mpdeimos.funjional.$3;
import com.mpdeimos.funjional.compliance.Function2;
import com.mpdeimos.funjional.type.Option.Nil;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Array function library.
 * 
 * @author mpdeimos
 * 
 */
public class Arrayz
{
	// / FOLD / //

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
		return Listz.foldLeft($, acc, Arrays.asList(os));
	}

	public static <O, R> $3<$<R, $<O, R>>, R, O[], R> foldLeft()
	{
		return new $3<$<R, $<O, R>>, R, O[], R>()
		{
			@Override
			public R $($<R, $<O, R>> f, R acc, O[] os)
			{
				return foldLeft(f, acc, os);
			}
		};
	}

	@Deprecated
	public static <O, R> $3<$<R, $<O, R>>, R, O[], R> foldLeft(
			Class<R> typeR,
			Class<O> typeO)
	{
		return Arrayz.<O, R> foldLeft();
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
		return Listz.foldRight($, acc, Arrays.asList(os));
	}

	public static <O, R> $3<$<R, $<O, R>>, R, O[], R> foldRight()
	{
		return new $3<$<R, $<O, R>>, R, O[], R>()
		{
			@Override
			public R $($<R, $<O, R>> f, R acc, O[] os)
			{
				return foldRight(f, acc, os);
			}
		};
	}

	// / EACH / //

	public static <O> Function2<$<O, O>, O[], O[]> each()
	{
		Funz.<$<Nil, $<O, Nil>>, Nil, $<O[], Nil>> swap().$(
				Arrayz.<O, Nil> foldLeft().$());
		// return new Function2<$<O, O>, O[], O[]>()
		// {
		// @Override
		// public O[] call($<O, O> f, O[] os)
		// {
		// Arrayz.<O, O> foldLeft().$(
		// Funz.<O, O, O> intercept().$(Funz.<O, O> second(), f),
		// null,
		// os);
		// return os;
		// }
		// };
	}

	// / MAP ///

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
	public static <R, O> R[] mapInto(final $<O, R> $, R[] buffer, O... os)
	{
		Listz.mapInto($, Arrays.asList(buffer), Arrays.asList(os));
		return buffer;
	}

	public static <O, R> $3<$<O, R>, R[], O[], R[]> mapInto()
	{
		return new $3<$<O, R>, R[], O[], R[]>()
		{
			@Override
			public R[] $($<O, R> $, R[] buffer, O[] os)
			{
				return mapInto($, buffer, os);
			}
		};
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
		return mapInto($, buffer, os);
	}

	public static <O, R> $2<$<O, R>, O[], R[]> map()
	{
		return new $2<$<O, R>, O[], R[]>()
		{
			@Override
			public R[] $($<O, R> $, O[] os)
			{
				return map($, os);
			}
		};
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
		return mapInto($, os, os);
	}

	public static <O> $2<$<O, O>, O[], O[]> mapSelf()
	{
		return new $2<$<O, O>, O[], O[]>()
		{
			@Override
			public O[] $($<O, O> $, O[] os)
			{
				return mapSelf($, os);
			}
		};
	}

}
