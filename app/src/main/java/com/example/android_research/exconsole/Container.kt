package com.example.android_research.exconsole

// Ob cung cap module
object Container {
    fun provideDriver() = Driver()
    fun provideEngine() = Engine()
}