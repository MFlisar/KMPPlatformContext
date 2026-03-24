package com.michaelflisar.kmp.platformcontext

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

actual val Dispatchers.PlatformIO: CoroutineDispatcher
    get() = Dispatchers.IO