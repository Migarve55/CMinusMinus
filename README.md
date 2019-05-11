# CMinusMinus

## Description

Java compiler using ANLTR of a mini language called CMinusMinus.
The goal is to understang how compilers work. This is only a educational language/compiler.

## Features

  - Basic control structures, plus "break" and "continue" keywords
  - Basic and composite types (arrays and structs)
  - Pointers manipulation

## Goals

  - Implement more operators ("++", "--")
  - Implement assigment operators ("+=", "-=", ...etc)
  
## Disclaimer

  This project is based in a project from DLP (Programming Languages Design (The acronym is in Spanish)).
  A student from this subject could use this project to cheat. First of all, it is great if you use my project as a way to 
  know how to do something. But please consider doing this by yourself. Copying this will not help you pass the subject, 
  and you can even get into trouble. If you copy, think first.
  
# Language description

## Control structures

Same as in any C code

 - If/Else
 - While
 - For: like the old versions of C, you can not declare the variables inside, only initialize them.

## Basic types

  - char:   1 byte
  - int:    2 bytes
  - double: 4 bytes
  - pointer: 2 bytes
  
  There are no booleans, instead you should use the integer. 
  One is used as 'true' and zero as 'false'.

## Composite types

Same as in any C code, except there are no strings.

  - array
  - struct
  
  Warning: there is not way to declare a pointer to a struct to this day. 
  Due to langauge constrains, I am looking for a way to fix this, but it is not easy.

## Operators

This is important: there is no type promotion in this language, so be careful with casting.

## Functions

Functions are a bit tricky, specially when it comes to returning types.
In this point, you can only return at the end of the funcition, and the compiler does not check that you always 
return a value. This can cause the VM to break, so be careful.
I am planning to make this better in the future.

## I/O Operations

For inputing:
	
	- read expr;
	
For outputing:

	- write expr;
	- write expr, expr, ... , expr; 

## Target language and Enviroment

The target code runs on a Stack based machine called MAPL. Of course, currently this machine is not available to the public.
I am planning on translating on another intermidiate machine code, but this is a long term goal.

# Examples

In the folder "examples" you will see:

  - helloWorld: obligatory example
  - pointers: shows you how to use pointers
  - passByReference: passing arguments to a function example
  - primesGenerator: as the name indicates, it generates primes until a max number inputed by the user.
  - loops: basic loop manipulation

