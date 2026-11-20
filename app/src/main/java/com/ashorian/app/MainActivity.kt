package com.ashorian.app

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.graphics.Color
import android.widget.ImageView
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : Activity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splash = ImageView(this).apply {
            setBackgroundColor(Color.BLACK)
            setImageResource(R.drawable.ashorian_splash_logo)
            scaleType = ImageView.ScaleType.FIT_CENTER
        }

        setContentView(splash)

        Handler(Looper.getMainLooper()).postDelayed({
            openAshorian()
        }, 2000)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun openAshorian() {
        webView = WebView(this)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        setContentView(webView)

        webView.loadUrl("http://127.0.0.1:3000/")
    }

    @Deprecated("Deprecated in Android")
    override fun onBackPressed() {
        if (::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
