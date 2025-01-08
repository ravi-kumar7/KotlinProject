package org.example.project

interface RazorPayHelper {
    fun launchRazorPay(context: Any)
}

expect fun getRazorPayHelper(): RazorPayHelper