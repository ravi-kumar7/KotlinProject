package org.example.project

import android.app.Activity
import com.razorpay.Checkout
import com.razorpay.PayloadHelper
import org.json.JSONObject

class RazorPayHelperAndroid: RazorPayHelper {
    override fun launchRazorPay(context: Any) {
        require(context is Activity) {
            "Expected android.content.Context, found ${context::class}"
        }
        val payloadHelper = PayloadHelper("INR", 100, "order_XXXXXXXXX")
        payloadHelper.description = "Description"
        payloadHelper.sendSmsHash = true
        payloadHelper.retryMaxCount = 4
        payloadHelper.retryEnabled = true
        payloadHelper.color = "#000000"
        payloadHelper.allowRotation = true
        payloadHelper.rememberCustomer = true
        payloadHelper.timeout = 10
        payloadHelper.redirect = true
        payloadHelper.customerId = "cust_123456"
        payloadHelper.modalConfirmClose = true
        payloadHelper.backDropColor = "#ffffff"
        payloadHelper.hideTopBar = true
        payloadHelper.notes = JSONObject("{\"remarks\":\"Discount to cusomter\"}")
        startPayment(context)
    }
}

private fun startPayment(context: Activity) {
    /*
    *  You need to pass the current activity to let Razorpay create CheckoutActivity
    * */
    val co = Checkout()
    co.setKeyID("rzp_test_1DP5mmOlF5G5ag")
    try {
        val options = JSONObject()
        options.put("name","Razorpay Corp")
        options.put("description","Demoing Charges")
        //You can omit the image option to fetch the image from the dashboard
        options.put("image","http://example.com/image/rzp.jpg")
        options.put("theme.color", "#3399cc");
        options.put("currency","INR");
        options.put("order_id", "order_DBJOWzybf0sJbb");
        options.put("amount","50000")//pass amount in currency subunits

        val retryObj = JSONObject();
        retryObj.put("enabled", true);
        retryObj.put("max_count", 4);
        options.put("retry", retryObj);

        val prefill = JSONObject()
        prefill.put("email","gaurav.kumar@example.com")
        prefill.put("contact","9876543210")

        options.put("prefill",prefill)
        co.open(context,options)
    }catch (e: Exception){
        e.printStackTrace()
    }
}

actual fun getRazorPayHelper(): RazorPayHelper {
    return RazorPayHelperAndroid()
}