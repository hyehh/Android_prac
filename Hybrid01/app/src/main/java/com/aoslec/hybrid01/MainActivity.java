package com.aoslec.hybrid01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button reload, page1, page2, page3;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reload = findViewById(R.id.reload);
        page1 = findViewById(R.id.page1);
        page2 = findViewById(R.id.page2);
        page3 = findViewById(R.id.page3);
        webView = findViewById(R.id.webView);

        reload.setOnClickListener(onClickListener);
        page1.setOnClickListener(onClickListener);
        page2.setOnClickListener(onClickListener);
        page3.setOnClickListener(onClickListener);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                reload.setText("로딩중...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                reload.setText(webView.getTitle());
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.page1:
                    webView.loadUrl("http://192.168.0.3:8080/test/Arithmetic.jsp");
                    //webView.loadUrl("https://www.naver.com");
                    break;
                case R.id.page2:
                    webView.loadUrl("https://www.google.com");
                    break;
                case R.id.page3:
                    webView.loadUrl("https://www.daum.net");
                    break;
            }
        }
    };
}