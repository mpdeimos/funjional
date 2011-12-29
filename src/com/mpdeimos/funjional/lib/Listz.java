package com.mpdeimos.funjional.lib;

import com.mpdeimos.funjional.$;
import com.mpdeimos.funjional.$$;
import com.mpdeimos.funjional.$2;
import com.mpdeimos.funjional.$3;
import com.mpdeimos.funjional._;
import com.mpdeimos.funjional._._2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * List function library.
 * 
 * @author mpdeimos
 * 
 */
public class Listz
{
	// / FOLD / //

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

	public static <O, R> $3<$<R, $<O, R>>, R, Iterable<O>, R> foldLeft()
	{
		return new $3<$<R, $<O, R>>, R, Iterable<O>, R>()
		{
			@Override
			public R $($<R, $<O, R>> f, R acc, Iterable<O> os)
			{
				return foldLeft(f, acc, os);
			}
		};
	}

	@Deprecated
	public static <O, R> $3<$<R, $<O, R>>, R, Iterable<O>, R> foldLeft(
			Class<R> hintR,
			Class<O> hintO)
	{
		return Listz.<O, R> foldLeft();
	}

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

	public static <O, R> $3<$<R, $<O, R>>, R, List<O>, R> foldRight()
	{
		return new $3<$<R, $<O, R>>, R, List<O>, R>()
		{
			@Override
			public R $($<R, $<O, R>> f, R acc, List<O> os)
			{
				return foldRight(f, acc, os);
			}
		};
	}

	@Deprecated
	public static <O, R> $3<$<R, $<O, R>>, R, List<O>, R> foldRight(
			Class<R> hintR,
			Class<O> hintO)
	{
		return Listz.<O, R> foldRight();
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
	public static <R, O, C extends Collection<R>> C mapInto(
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
	public static <O, R> List<R> mapInto(
			final $<O, R> $,
			List<R> buffer,
			Iterable<O> os)
	{
		return foldLeft(new $$<_2<List<R>, Integer>, O>()
		{
			@Override
			public _2<List<R>, Integer> $(_2<List<R>, Integer> acc, O o)
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

	public static <O, R> $3<$<O, R>, List<R>, Iterable<O>, List<R>> mapInto()
	{
		return new $3<$<O, R>, List<R>, Iterable<O>, List<R>>()
		{
			@Override
			public List<R> $($<O, R> $, List<R> buffer, Iterable<O> os)
			{
				return mapInto($, buffer, os);
			}
		};
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
		return mapInto($, new ArrayList<R>(os.size()), os);
	}

	public static <O, R> $2<$<O, R>, List<O>, List<R>> map()
	{
		return new $2<$<O, R>, List<O>, List<R>>()
		{
			@Override
			public List<R> $($<O, R> $, List<O> os)
			{
				return map($, os);
			}
		};
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
		return mapInto($, os, os);
	}

	public static <O> $2<$<O, O>, List<O>, List<O>> mapSelf()
	{
		return new $2<$<O, O>, List<O>, List<O>>()
		{
			@Override
			public List<O> $($<O, O> $, List<O> os)
			{
				return mapSelf($, os);
			}
		};
	}
}
