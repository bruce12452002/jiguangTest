package com.abc.com;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import cn.jpush.android.api.JPushInterface;

public class StartService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true); // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this); // 初始化 JPush
        JPushInterface.setLatestNotificationNumber(getApplicationContext(), 10);// 保留多少条通知数
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
