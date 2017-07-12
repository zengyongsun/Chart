package com.zy.chart.x5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.zy.chart.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewFileActivity extends AppCompatActivity {

    @BindView(R.id.top_imageView) ImageView topImageView;
    @BindView(R.id.top_textView) TextView topTextView;
    @BindView(R.id.show_document) WebView showDocument;

    private String baseUrl = "http://ow365.cn/?i=12932&furl=";//http://ow365.cn/?i=您的网站ID&furl=要预览的Office文件下载地址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_file);
        ButterKnife.bind(this);
    }

    private void initData(String uuid) {

        showDocument.loadUrl(baseUrl + uuid);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {

        showDocument.getSettings().setLoadWithOverviewMode(true);
        // 需要允许加载js
        showDocument.getSettings().setJavaScriptEnabled(true);
        // 不使用默认浏览器打开
        showDocument.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    /**
     * 返回键的处理
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
