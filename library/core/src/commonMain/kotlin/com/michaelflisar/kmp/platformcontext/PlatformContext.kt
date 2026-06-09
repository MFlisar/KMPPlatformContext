package com.michaelflisar.kmp.platformcontext

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

expect abstract class PlatformContext

expect val Dispatchers.PlatformIO: CoroutineDispatcher

val PlatformApplicationContext: PlatformContext
    get() = PlatformContextProvider.get()

@Deprecated("Use ApplicationContext instead", ReplaceWith("ApplicationContext"))
val platformContext: PlatformContext
    get() = PlatformContextProvider.get()

@Deprecated("Use Dispatchers.PlatformIO instead", ReplaceWith("Dispatchers.PlatformIO"))
val platformIO: CoroutineDispatcher
    get() = Dispatchers.PlatformIO