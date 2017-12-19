package com.verbes.drmas.verbesfranais;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CursorAdapter;
import android.widget.GridView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class webhtml2 extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_webhtml2 );

        webView = findViewById(R.id.webview1);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls( true );
        webSettings.setJavaScriptEnabled( true );

        webView.setWebViewClient( new WebViewClient() );
        webView.loadUrl("file:///android_asset/enu.html");

    } //end main

    private class WebViewClient extends android.webkit.WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            return super.shouldOverrideUrlLoading( view, url );
        }
    }


} // the end
