package org.example.project

import cocoapods.RazorpayCheckout.RazorpayCheckout

class RazorPayHelperIOS : RazorPayHelper {
    override fun launchRazorPay(context: Any) {

    }
}

actual fun getRazorPayHelper(): RazorPayHelper {
    return RazorPayHelperIOS()
}