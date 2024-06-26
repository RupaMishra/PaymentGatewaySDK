package com.ideaneuron.paymentgateway;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaymentGateway extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment_gateway);

        Intent intent = getIntent();
        if (intent != null) {
            String arg1 = intent.getStringExtra("username");
            String arg2 = intent.getStringExtra("password");

            webView = findViewById(R.id.webview);
            webView.setWebViewClient(new WebViewClient()); // Ensures links open within the WebView
            webView.loadUrl("https://pg.eazype.co/crm/jsp/index");

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}