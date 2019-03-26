# CMinusMinus

## Description

Java compiler using ANLTR of a mini language called CMinusMinus.
The goal is to understang how compilers work. This is only a educational language/compiler.

## Features

  - Basic control structures
  - Basic and composite types (arrays and structs)
  - Pointers manipulation

## Goals

  - lambdas
  - automatic type promotion
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
 - For: like the old versions of C, you can not

## Basic types

  - char:   1 byte
  - int:    2 bytes
  - double: 4 bytes
  - pointer: 2 bytes

## Composite types

Same as in any C code

  - array
  - struct

## Operators

This is important: there is no type promotion in this language, so be careful with casting.
This will be fixed in the near future.

## Functions

They work as intended

## Target language and Enviroment

The target code runs on a Stack based machine called MAPL. Of course, currently this machine is not available to the public.
I am planning on translating on another intermidiate machine code, but this is a long term goal.

# Examples

In the folder "examples" you will see:

  - helloWorld: obligatory example.
  - pointers: shows you how to use pointers.
  - passByReference: passing arguments to a function example.
  - primesGenerator: as the name indicates, it generates primes until a max number inputed by the user.
  - loops: shows you loops and basic control flow keywords.


