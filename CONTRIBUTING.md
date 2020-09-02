# Contributing to Kotlin React Bootstrap

__Every help is welcome!__


This file is WIP so bare with me.


## Why are you not using Dukat to generate Kotlin out of React Bootstrap?
This has multiple reasons:
1. __Union types__  
Javascript offers union types. A feature that Kotlin does not have. Dukat overcomes this by using the hacky keyword `dynamic`. Which basically tells Kotlin to
accept everything.
Since this is designed to be a library, I want to be as type safe as possible. Therefore I rather rebuild components in Kotlin. 

1. __I want to make the most out of using Kotlin__  
Converting an existing library to Kotlin might be a good starting point - don't get me wrong there. But I think: Designing the usage of the components in Kotlin
from the beginning, frees me from being influenced by the converted and suboptimal usage.

## General speaking
This library is supposed to be easy to use. When building a component I start with designing the usage first. How would I like to use this component? And then from 
there I build up the actual component.

## React and its features
So far I am learning React through building this library. If you see something, which could be solved better using some advanced React features: A PR is always welcome!
