package com.mpdeimos.funjional;

public abstract class Fun
{
	public static <O> _<O,O> ID(O o)
	{
		return new _<O,O>()
		{
			@Override
			public O $(O o) {
				return o;
			}
		};
	}
	
	public static <N extends Number> __<N,N> ADD(Class<N> type)
	{
		return new __<N, N>()
		{
			@SuppressWarnings("unchecked")
			@Override
			public N $(N acc, N o) {
				if (o instanceof Double)
				{
					Double r = (Double)acc+(Double)o;
					return (N) r;
				}
				if (o instanceof Integer)
				{
					Integer r = (Integer)acc+(Integer)o;
					return (N) r;
				}
				if (o instanceof Float)
				{
					Float r = (Float)acc+(Float)o;
					return (N) r;
				}
				return null;
			}
		};
	}
}
