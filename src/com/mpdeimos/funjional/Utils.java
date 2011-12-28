package com.mpdeimos.funjional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.LinkedList;

public class Utils
{
	public static Class<?> getGenericType(Object o, Class<?> declaringClass, int idx)
	{
		Class<?> clazz = o.getClass();
		LinkedList<Class<?>> clazzStack = new LinkedList<Class<?>>();
		while(!clazz.getSuperclass().equals(declaringClass))
		{
			clazzStack.push(clazz);
			clazz = clazz.getSuperclass();
		}
		
		while(clazz != null)
		{
			ParameterizedType ptype = (ParameterizedType) clazz.getGenericSuperclass();
			
			Type type = ptype.getActualTypeArguments()[idx];
			
			if (type instanceof Class<?>)
			{
				return (Class<?>) type;
			}
			
			TypeVariable<?> tvi = (TypeVariable<?>) type;
			TypeVariable<?>[] typeParameters = clazz.getTypeParameters();
			for (idx = 0; idx < typeParameters.length; idx++)
			{
				TypeVariable<?> ctv = typeParameters[idx];
				if (ctv.getName().equals(tvi.getName()))
				{
					break;
				}
			}
			clazz = clazzStack.pop();
		}
		
		return null;
	}
}
