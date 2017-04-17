package com.bugsee.shared.listenscrollchanges.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.bugsee.shared.listenscrollchanges.ListenScrollChangesHelper;
import com.bugsee.shared.listenscrollchanges.OnScrollChangeListenerCompat;
import com.bugsee.shared.listenscrollchanges.R;

import java.text.MessageFormat;

/**
 * Created by denis.druzhinin, Bugsee Inc, <a href="https://www.bugsee.com">https://www.bugsee.com</a>
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private WebView mWebView;
    private Button mListenButton;
    private Button mStopListeningButton;
    private final ListenScrollChangesHelper mScrollChangesHelper = new ListenScrollChangesHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListenButton = (Button)findViewById(R.id.listenButton);
        mListenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenScrollEvents(true);
            }
        });
        mStopListeningButton = (Button)findViewById(R.id.stopListeningButton);
        mStopListeningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenScrollEvents(false);
            }
        });

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("https://www.google.com");
    }

    private void listenScrollEvents(boolean listen) {
        if (listen) {
            mScrollChangesHelper.addViewToListen(mWebView, mScrollChangeListener);
        } else {
            mScrollChangesHelper.removeViewToListen(mWebView);
        }
    }

    private final OnScrollChangeListenerCompat mScrollChangeListener = new OnScrollChangeListenerCompat() {
        @Override
        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            Log.i(TAG, MessageFormat.format("Scroll event. X: {0}; Y: {1}; Old X: {2}; Old Y: {3}", scrollX, scrollY, oldScrollX, oldScrollY));
        }
    };
}
