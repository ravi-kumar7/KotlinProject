package org.example.project

expect class ContextFactory {
    fun getContext(): Any
    fun getApplication(): Any
    fun getActivity(): Any
}