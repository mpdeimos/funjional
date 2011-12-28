package com.mpdeimos.funjional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.mpdeimos.funjional.Zip.Zip2;

public abstract class _<R, O>
{
	public abstract R $(O o);
	
	@SuppressWarnings("unchecked")
	public Class<R> getReturnType()
	{
		return (Class<R>) Utils.getGenericType(this, _.class, 0);
	}

	@SuppressWarnings("unchecked")
	public Class<O> getArgumentType()
	{
		return (Class<O>) Utils.getGenericType(this, _.class, 1);
	}
	
	/// FOLD LEFT ///
	
	public static <R, O> R foldLeft(_<R, Zip.Zip2<R, O>> _, R acc, Iterable<O> os)
	{
		for (O o : os)
		{
			acc = _.$(Zip.zip(acc, o));
		}
		
		return acc;
	}
	
	public static <R, O> R foldLeft(_<R, Zip.Zip2<R, O>> _, R acc, O... os)
	{
		return foldLeft(_, acc, Arrays.asList(os));
	}
	
	/// FOLD RIGHT ///
	
	public static <R, O> R foldRight(_<R, Zip.Zip2<R, O>> _, R acc, List<O> os)
	{
		for (int i = os.size()-1; i >= 0; --i)
		{
			acc = _.$(Zip.zip(acc, os.get(i)));
		}
		
		return acc;
	}
	
	public static <R, O> R foldRight(_<R, Zip.Zip2<R, O>> _, R acc, O... os)
	{
		return foldRight(_, acc, Arrays.asList(os));
	}
	
	/// MAP ///
	
	public static <R, O, C extends Collection<R>> C map(final _<R, O> _, C buffer, Iterable<O> os)
	{
		return foldLeft(new __<C, O>()
		{
			@Override
			public C $(C acc, O o)
			{
				acc.add(_.$(o));
				return acc;
			}
			
		}, buffer, os);
	}
	
	public static <R, O, L extends List<R>> L map(final _<R, O> _, L buffer, Iterable<O> os)
	{
		return foldLeft(new __<Zip2<L, Integer>, O>()
		{
			@Override
			public Zip2<L, Integer> $(Zip2<L, Integer> acc, O o)
			{
				if (acc.a.size() > acc.b)
				{
					acc.a.set(acc.b, _.$(o));
				}
				else
				{
					acc.a.add(_.$(o));
				}
				
				acc.b++;
				
				return acc;
			}
			
		}, Zip.zip(buffer, 0), os).a;
	}
	
	public static <R, O> List<R> map(final _<R, O> _, List<O> os)
	{
		return map(_, new ArrayList<R>(os.size()), os);
	}
	
	public static <O> List<O> mapSelf(final _<O, O> _, List<O> os)
	{
		return map(_, os, os);
	}
	
	public static <R, O> R[] map(final _<R, O> _, R[] buffer, O... os)
	{
		map(_, Arrays.asList(buffer), Arrays.asList(os));
		return buffer;
	}
	
	public static <R, O> R[] map(final _<R, O> _, O... os)
	{
		@SuppressWarnings("unchecked")
		R[] buffer = (R[]) Array.newInstance(_.getReturnType(), os.length);
		return map(_, buffer, os);
	}
	
	public static <O> O[] mapSelf(final _<O, O> _, O... os)
	{
		return map(_, os, os);
	}
}