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
Creating a new function is done by creating a new anonymous class that extends `_<R, O>` whereas `R` is the return type and `O` is the type of the function argument. As a class does not do any stuff per-se we also need to implement a function; `_` contains an abstract function `public abstract R _(O o);`taking an object of type `O` and returning and object of type `R` -- this function needs to be implemented by you.

### The collection library

The goal of *funjional* is not only to provide a concept for defining lambda expressions but also delivering built-in function for processing Java Collections and Arrays. Those functions are accessed statically from the `_` class as seen in the examples below.

### Multiple argument functions

I got that, but for now functions do only accept one argument -- how can I pass more than one argument?
Well, the simple answer is *you cannot*!
The long answer: *Tuple your arguments!*
*funjional* provides a concept for tuppling objects into `$` containers. The simplest container is `$1` which can be created by `$1 z = $.$(someObject)`. The object can be accessed by `z.a`. A `$1` is pretty useless, so the more interesting ones are `$2`, `$3` and so on. Creation is similar -- `$2 z2 = $.$(someObject, someOtherObject)`. Of course Zip containers are typesafe, so `$.$(1, "foo")` will yield a `$2<Integer,String>` with its members being accessible via `z2.a` and `z2.b`.

### Example

	// yields a fresh array [2,3,4,5]
	Integer[] ints = _.map(new _<Integer, Integer>() 
	{
		@Override
		public Integer _(Integer o) 
		{
			return o+1;
		}
	}, new Integer[]{1,2,3,4});


### The mighty fold

`fold` uses a special version of the `_` class with generic signature `_<R, $.$2<R, O>>` to provide an accumulator. For more convenient writing *funjional* delivers a subclass `__<R, O>` (note the double underscore) with an abstract method `public abstract R __(R acc, O o);` to be implemented by you.

	// yields 10
	int sum = _.foldRight(new __<Integer, Integer>()
	{
		@Override
		public Integer __(Integer acc, Integer o)
		{
			return acc+o;
		}
	}, 0, new Integer[]{1,2,3,4});

### The function library

*funjional* also includes a function library being accessible via static methods of the class `Fun`.

### Compliance mode

*funjional* uses non-standard Java notation of classnames (`_`, `$`) or using functions with the same name as a constructor (`_._()`, `$.$()`).
So there exists a compliance API with the following mapping:

 * `_` -- `Function`
 * `_._()` -- `Function.call()`
 * `__` -- `Accumulation`
 * `__.__()` -- `Accumulation.call()`
 * `$` -- `Tuple`
 * `$.$()` -- `Tuple.create()`
 * `$1` -- `Tuple1`
 * `$2` -- `Tuple2`
 * `$3` -- `Tuple3`
 * `$4` -- `Tuple4`

### Gimmicks

#### Variable arguments

Most Array functions can also be used with variable arguments. So `_.foldLeft(Fun.ADD(Integer.class), 0, new Integer[]{1,2,3});` is identical to the less verbose `_.foldLeft(Fun.ADD(Integer.class), 0, 1,2,3);`.

Help Developing
===============

With *funjional* being an open-source project, I encourage anyone to take part in development. Just fork this repository and add deliver back pull requests.
