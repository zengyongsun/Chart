package com.zy.chart.voice;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.orhanobut.logger.Logger;
import com.zy.chart.R;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class XunFeiActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = XunFeiActivity.class.getSimpleName();

    //语音听写对象
    private SpeechRecognizer mDictationObject;

    //语音听写UI
    private RecognizerDialog mDictationDialog;

    //用HashMap存储听写结果
    private HashMap<String, String> mDictationResults = new LinkedHashMap<>();

    // 引擎类型
    private String mEngineType = SpeechConstant.TYPE_CLOUD;

    private Context mContext;

    int ret = 0;//函数调用返回值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //界面无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_xun_fei);
        mContext = this;
        initLayout();
    }

    private void initLayout() {
        findViewById(R.id.iat_recognize).setOnClickListener(this);
        findViewById(R.id.iat_stop).setOnClickListener(this);
        findViewById(R.id.iat_cancel).setOnClickListener(this);

        findViewById(R.id.iat_upload_contacts).setOnClickListener(this);
        findViewById(R.id.iat_upload_userwords).setOnClickListener(this);

        // 初始化识别无UI识别对象
        // 使用SpeechRecognizer对象，可根据回调消息自定义界面；
        mDictationObject = SpeechRecognizer.createRecognizer(mContext, mInitListener);

        // 初始化听写Dialog，如果只使用有UI听写功能，无需创建SpeechRecognizer
        // 使用UI听写功能，请根据sdk文件目录下的notice.txt,放置布局文件和图片资源
        mDictationDialog = new RecognizerDialog(mContext, mInitListener);
    }

    @Override
    public void onClick(View v) {
        if (null == mDictationObject) {
            // 创建单例失败，与 21001 错误为同样原因，参考 http://bbs.xfyun.cn/forum.php?mod=viewthread&tid=9688
            Toast.makeText(mContext, "创建对象失败，请确认 libmsc.so 放置正确，且有调用 createUtility 进行初始化", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    /**
     * 初始化监听器。
     */
    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            Log.d(TAG, "SpeechRecognizer init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                Logger.d("初始化失败，错误码：" + code);
            }
        }
    };
}
