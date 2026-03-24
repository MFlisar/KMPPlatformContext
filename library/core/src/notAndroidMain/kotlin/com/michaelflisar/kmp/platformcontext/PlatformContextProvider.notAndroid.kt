package com.michaelflisar.kmp.platformcontext

actual typealias PlatformContext = PlatformContextEmpty

abstract class PlatformContextEmpty

object PlatformContextEmptyImpl : PlatformContextEmpty()

actual fun PlatformContextProvider.getDefaultPlatformContext(): PlatformContext? = PlatformContextEmptyImpl