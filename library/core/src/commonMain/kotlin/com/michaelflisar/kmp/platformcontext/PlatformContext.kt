package com.michaelflisar.kmp.platformcontext

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

expect abstract class PlatformContext

internal expect fun getDefaultPlatformContext(): PlatformContext?

expect val Dispatchers.PlatformIO: CoroutineDispatcher