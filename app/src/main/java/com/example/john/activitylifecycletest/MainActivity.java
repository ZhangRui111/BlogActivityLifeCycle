package com.example.john.activitylifecycletest;

import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button startNormalAty,startDialogAty;
    private Button finishAllBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate");
        setContentView(R.layout.activity_main);

        /**
         * Bundle savedInstanceState 用于保存了可能存在的临时数据
         */
        if(savedInstanceState != null){
            String tempdata = savedInstanceState.getString("data_key");
            Log.i(TAG,tempdata);
        }

        startNormalAty = (Button) findViewById(R.id.start_normalAty_button);
        startDialogAty = (Button) findViewById(R.id.start_dialogAty_button);
        finishAllBtn = (Button) findViewById(R.id.button_finish_all_activity);
        startNormalAty.setOnClickListener(this);
        startDialogAty.setOnClickListener(this);
        finishAllBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_normalAty_button:
                NormalActivity.actionStart(MainActivity.this);
                break;
            case R.id.start_dialogAty_button:
                DialogActivity.actionStart(MainActivity.this);
                break;
            case R.id.button_finish_all_activity:
                ActivityCollector.finishAll();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    /**
     * onSaveInstanceState处理活动被回收的临时数据保存
     * @param outState
     * @param outPersistentState
     */
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        String tempData = "Something maybe useful!";
        outState.putString("data_key",tempData);
    }
}
