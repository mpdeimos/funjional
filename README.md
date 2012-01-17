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

### Features

* Functions with strict typing
* Tupling
* Currying
* Uses standard Java Objects (Lists, Arrays, Collections, Iterators)

### Ok, so whats that all about?

Since Java is a strictly object-oriented programming language lambda functions need to be classes and typed by generics.
Creating a new function is done by creating a new anonymous class that extends `$<O, R>` whereas `R` is the return type and `O` is the type of the function argument. As a class does not do any stuff per-se we also need to implement a function; `$` contains an abstract function `public abstract R $(O o);`taking an object of type `O` and returning and object of type `R` -- this function needs to be implemented by you.

### The collection library

The goal of *funjional* is not only to provide a concept for defining lambda expressions but also delivering built-in function for processing Java Collections and Arrays. Those functions are accessed statically from the `$` class as seen in the examples below.

### Multiple argument functions

I got that, but for now functions do only accept one argument -- how can I pass more than one argument?
Well, the simple answer is *you cannot*!
As in Haskell every function just takes one argument.

The long answer #1: *Tuple your arguments!*
*funjional* provides a concept for tupling objects into `_` containers. The simplest container is `_1` which can be created by `_1 z = _._(someObject)`. The object can be accessed by `z.a`. A `_1` is pretty useless, so the more interesting ones are `_2`, `_3` and so on. Creation is similar -- `_2 z2 = _._(someObject, someOtherObject)`. Of course Tuples are typesafe, so `_._(1, "foo")` will yield a `_2<Integer,String>` with its members being accessible via `z2.a` and `z2.b`.

The long answer #2: *Use higher order functions!*
*funjional* also supports nesting of functions that can be evaluated using currying or at once with special syntax. An example of an higher order function would be `$<A, $<B, C>> f = ...`. This means you have a function `f` that takes one argument of type `A`. Calling `f.$(a)` will produce another function `$<B, C>` taking an argument of type `b`. In order to call f with both arguments use `f.$(a).$(b)` which yields an object of type `C`.
Since this notation - both the function declaration and the evaluation - is quite verbose *funjional* offers a shorthand class `$2<A, B, R>` with an additional evaluation call `f.$(a, b)`.

### Example

	// yields a fresh array [2,3,4,5]
	Integer[] ints = $.map(new $<Integer, Integer>() 
	{
		@Override
		public Integer $(Integer o) 
		{
			return o+1;
		}
	}, new Integer[]{1,2,3,4});


### The mighty fold

`fold` uses a special version of the `$` class with generic signature `$<R, $<R, O>>` to provide an accumulator. For more convenient writing *funjional* delivers a subclass `$$<R, O>` with an abstract method `public abstract R $$(R acc, O o);` to be implemented by you.

	// yields 10
	int sum = $.foldRight(new $$<Integer, Integer>()
	{
		@Override
		public Integer $(Integer acc, Integer o)
		{
			return acc+o;
		}
	}, 0, new Integer[]{1,2,3,4});

### The function library

*funjional* also includes a function library being accessible via static methods of the class `Fun`.

### Compliance mode

*funjional* uses non-standard Java notation of classnames (`_`, `$`) or using functions with the same name as a constructor (`_._()`, `$.$()`).
So there exists a compliance API with the following mapping:

* `$` -- `Function`
* `$.$()` -- `Function.call()`
* `$$` -- `Accumulation`
* `$$.$$()` -- `Accumulation.call()`
* `_` -- `Tuple`
* `_._()` -- `Tuple.create()`
* `_1` -- `Tuple1`
* `_2` -- `Tuple2`
* `_3` -- `Tuple3`
* `_4` -- `Tuple4`

### Gimmicks

#### Variable arguments

Most Array functions can also be used with variable arguments. So `$.foldLeft(Fun.ADD(Integer.class), 0, new Integer[]{1,2,3});` is identical to the less verbose `$.foldLeft(Fun.ADD(Integer.class), 0, 1,2,3);`.

#### Function composition

Functions can be composed by the `o` operator like this: `Fun.MUL(2).o(Fun.ADD(1))` yielding a function that takes an Integer i and calculates `(i + 1) * 2`.

#### Currying

Help Developing
===============

With *funjional* being an open-source project, I encourage anyone to take part in development. Just fork this repository and deliver back pull requests.
