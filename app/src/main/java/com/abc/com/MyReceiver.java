package com.abc.com;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.service.JPushMessageReceiver;

public class MyReceiver extends JPushMessageReceiver {

    @Override
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        //super.onTagOperatorResult(context, jPushMessage);
        System.out.println("abc2=" + jPushMessage.getSequence());
        System.out.println("def2=" + jPushMessage.getTags());
        System.out.println("ghi2=" + jPushMessage.getErrorCode());
    }

    @Override
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        //super.onAliasOperatorResult(context, jPushMessage);
        System.out.println("abc3=" + jPushMessage.getSequence());
        System.out.println("def3=" + jPushMessage.getAlias());
        System.out.println("ghi3=" + jPushMessage.getErrorCode());

        List<Integer> list = Arrays.asList(6002, 6014);//6002 （超时）, 6014(服务繁忙)
        if(list.contains(jPushMessage.getErrorCode())){

        }
    }
}
