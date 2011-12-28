package com.mpdeimos.funjional;

import com.mpdeimos.funjional.$.$2;

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
public abstract class _<R, O>
{
	/**
	 * The lambda function implementation.
	 * 
	 * @param o
	 *            the function argument of type O
	 * @return an object of type R
	 */
	public abstract R _(O o);

	/**
	 * @return The Class of return type R.
	 */
	@SuppressWarnings("unchecked")
	public Class<R> getReturnType()
	{
		return (Class<R>) Utils.getGenericType(this, _.class, 0);
	}

	/**
	 * @return The Class of argument type O.
	 */
	@SuppressWarnings("unchecked")
	public Class<O> getArgumentType()
	{
		return (Class<O>) Utils.getGenericType(this, _.class, 1);
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
	 * @param _
	 *            The lambda function $(R, O) -> R
	 * @param acc
	 *            The accumulator (initial value)
	 * @param os
	 *            The Iterable of type O
	 * @return and element of type R.
	 */
	public static <R, O> R foldLeft(
			_<R, $.$2<R, O>> _,
			R acc,
			Iterable<O> os)
	{
		for (O o : os)
		{
			acc = _._($.$(acc, o));
		}

		return acc;
	}

	/**
	 * Folds over an Array of type O from the left (natural order, index 0 to
	 * index n).
	 * 
	 * @param <R>
	 *            The lambda function return type.
	 * @param <O>
	 *            The lambda function argument type.
	 * @param _
	 *            The lambda function $(R, O) -> R
	 * @param acc
	 *            The accumulator (initial value)
	 * @param os
	 *            The Array of type O
	 * @return and element of type R.
	 */
	public static <R, O> R foldLeft(_<R, $.$2<R, O>> _, R acc, O... os)
	{
		return foldLeft(_, acc, Arrays.asList(os));
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
	 * @param _
	 *            The lambda function $(R, O) -> R
	 * @param acc
	 *            The accumulator (initial value)
	 * @param os
	 *            The Iterable of type O
	 * @return and element of type R.
	 */
	public static <R, O> R foldRight(_<R, $.$2<R, O>> _, R acc, List<O> os)
	{
		for (int i = os.size() - 1; i >= 0; --i)
		{
			acc = _._($.$(acc, os.get(i)));
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
	 * @param _
	 *            The lambda function $(R, O) -> R
	 * @param acc
	 *            The accumulator (initial value)
	 * @param os
	 *            The Array of type O
	 * @return and element of type R.
	 */
	public static <R, O> R foldRight(_<R, $.$2<R, O>> _, R acc, O... os)
	{
		return foldRight(_, acc, Arrays.asList(os));
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
	 * @param _
	 *            The mapping function O -> R
	 * @param buffer
	 *            The buffer to map into.
	 * @param os
	 *            The Iterable to map.
	 * @return A collection of type C with elements mapped from os.
	 */
	public static <R, O, C extends Collection<R>> C map(
			final _<R, O> _,
			C buffer,
			Iterable<O> os)
	{
		return foldLeft(new __<C, O>()
		{
			@Override
			public C $(C acc, O o)
			{
				acc.add(_._(o));
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
	 * @param _
	 *            The mapping function O -> R
	 * @param buffer
	 *            The buffer to map into.
	 * @param os
	 *            The List to map.
	 * @return A List of type C with elements mapped from os.
	 */
	public static <R, O, L extends List<R>> L map(
			final _<R, O> _,
			L buffer,
			Iterable<O> os)
	{
		return foldLeft(new __<$2<L, Integer>, O>()
		{
			@Override
			public $2<L, Integer> $($2<L, Integer> acc, O o)
			{
				if (acc.a.size() > acc.b)
				{
					acc.a.set(acc.b, _._(o));
				}
				else
				{
					acc.a.add(_._(o));
				}

				acc.b++;

				return acc;
			}

		}, $.$(buffer, 0), os).a;
	}

	/**
	 * Maps the elements of a List into a new List which is dynamically
	 * allocated and returned.
	 * 
	 * @param <R>
	 *            The mapping type.
	 * @param <O>
	 *            The List type.
	 * @param _
	 *            The mapping function O -> R
	 * @param os
	 *            The List to map.
	 * @return A List of type R with elements mapped from os.
	 */
	public static <R, O> List<R> map(final _<R, O> _, List<O> os)
	{
		return map(_, new ArrayList<R>(os.size()), os);
	}

	/**
	 * Maps the elements of a List into the same List.
	 * 
	 * @param <O>
	 *            The List type.
	 * @param _
	 *            The mapping function O -> O
	 * @param os
	 *            The List to map.
	 * @return The list os.
	 */
	public static <O> List<O> mapSelf(final _<O, O> _, List<O> os)
	{
		return map(_, os, os);
	}

	/**
	 * Maps the elements of an array into a buffer array and returns it.
	 * 
	 * @param <R>
	 *            The mapping type.
	 * @param <O>
	 *            The array type.
	 * @param _
	 *            The mapping function O -> R
	 * @param buffer
	 *            the buffer array to map into.
	 * @param os
	 *            The array to map.
	 * @return The buffer.
	 */
	public static <R, O> R[] map(final _<R, O> _, R[] buffer, O... os)
	{
		map(_, Arrays.asList(buffer), Arrays.asList(os));
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
	 * @param _
	 *            The mapping function O -> R
	 * @param os
	 *            The array to map.
	 * @return The newly allocated array with the mapped elements.
	 */
	public static <R, O> R[] map(final _<R, O> _, O... os)
	{
		@SuppressWarnings("unchecked")
		R[] buffer = (R[]) Array.newInstance(_.getReturnType(), os.length);
		return map(_, buffer, os);
	}

	/**
	 * Maps the elements of an array into itself and returns it.
	 * 
	 * @param <R>
	 *            The mapping type.
	 * @param <O>
	 *            The array type.
	 * @param _
	 *            The mapping function O -> O
	 * @param os
	 *            The array to map.
	 * @return os.
	 */
	public static <O> O[] mapSelf(final _<O, O> _, O... os)
	{
		return map(_, os, os);
	}
}