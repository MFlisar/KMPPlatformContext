package com.michaelflisar.kmp.platformcontext

actual typealias PlatformContext = PlatformContextEmpty

abstract class PlatformContextEmpty

object PlatformContextEmptyImpl : PlatformContextEmpty()

internal actual fun PlatformContextProvider.getDefaultPlatformContext(): PlatformContext? = PlatformContextEmptyImpl