License
=======

   Copyright 2011 Martin Pöhlmann

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

Notice
======

This project is in an early development phase and should not be used in production environments; a stable API is still to be finalized.
Moreover, I develop this project in my spare time, so do not expect regular updates.

Usage
=====

The general idea of *funjional* is bringing typesafe functional features to Java.

### Ok, so whats that all about?

Since Java is a strictly object-oriented programming language lambda functions need to be classes and typed by generics.
Creating a new function is done by creating a new anonymous class that extends `_<R, O>` whereas `R` is the return type and `O` is the type of the function argument. As a class does not do any stuff per-se we also need to implement a function; `_` contains an abstract function `public abstract R $(O o);`taking an object of type `O` and returning and object of type `R` -- this function needs to be implemented by you.

### The collection library

The goal of *funjional* is not only to provide a concept for defining lambda expressions but also delivering built-in function for processing Java Collections and Arrays. Those functions are accessed statically from the `_` class as seen in the examples below.

### Multiple argument functions

I got that, but for now functions do only accept one argument -- how can I pass more than one argument?
Well, the simple answer is *you cannot*!
The long answer: *Zip your arguments!*
*funjional* provides a concept for zipping objects into `Zip` containers. The simplest container is `Zip1` which can be created by `Zip1 z = Zip.zip(someObject)`. The object can be accessed by `z.a`. A `Zip1` is pretty useless, so the more interesting ones are `Zip2`, `Zip3` and so on. Creation is similar -- `Zip2 z2 = Zip.zip(someObject, someOtherObject)`. Of course Zip containers are typesafe, so `Zip.zip(1, "foo")` will yield a `Zip2<Integer,String>` with its members being accessible via `z2.a` and `z2.b`.

### Example

	// yields a fresh array [2,3,4,5]
	Integer[] ints = _.map(new _<Integer, Integer>() 
	{
		@Override
		public Integer $(Integer o) 
		{
			return o+1;
		}
	}, new Integer[]{1,2,3,4});


### The mighty fold

`fold` uses a special version of the `_` class with generic signature `_<R, Zip.Zip2<R, O>>` to provide an accumulator. For more convenient writing *funjional* delivers a subclass `__<R, O>` (note the double underscore) with an abstract method `public abstract R $(R acc, O o);` to be implemented by you.

	// yields 10
	int sum = _.foldRight(new __<Integer, Integer>()
	{
		@Override
		public Integer $(Integer acc, Integer o)
		{
			return acc+o;
		}
	}, 0, new Integer[]{1,2,3,4});

### The function library

*funjional* also includes a function library being accessible via static methods of the class `Fun`.

Help Developing
===============

With *funjional* being an open-source project, I encourage anyone to take part in development. Just fork this repository and add deliver back pull requests.
