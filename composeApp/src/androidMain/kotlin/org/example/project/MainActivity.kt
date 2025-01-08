package org.example.project

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.razorpay.Checkout
import com.razorpay.ExternalWalletListener
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener

class MainActivity : ComponentActivity(), PaymentResultWithDataListener, ExternalWalletListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Checkout.preload(applicationContext)
        setContent {
            App(ContextFactory(this))
        }
    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {

    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        Log.d("Razorpay", "Payment failed: code $p0, message $p1, data $p2")
    }

    override fun onExternalWalletSelected(p0: String?, p1: PaymentData?) {

    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(ContextFactory(null))
}