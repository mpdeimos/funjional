package com.mpdeimos.funjional;

import com.mpdeimos.funjional.Zip.Zip2;

public abstract class __<R, O> extends _<R, Zip.Zip2<R, O>>
{
	@Override
	public final R $(Zip2<R, O> o) {
		return $(o.a, o.b);
	}

	public abstract R $(R acc, O o);
}
