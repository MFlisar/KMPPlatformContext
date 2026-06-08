package com.michaelflisar.kmp.platformcontext

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

expect abstract class PlatformContext

internal expect val Dispatchers.PlatformIO: CoroutineDispatcher

val platformContext: PlatformContext
    get() = PlatformContextProvider.get()

val platformIO: CoroutineDispatcher
    get() = Dispatchers.PlatformIO