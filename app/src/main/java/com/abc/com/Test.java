package com.abc.com;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;

public class Test {
    public static void main(String[] args) {
        final String masterKey = "575cc8d3884d71e96f56be4a";
        final String appKey = "0c103747d047a52fa0f0e803";
        JPushClient client = new JPushClient(masterKey, appKey);

        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                //.setNotification(Notification.alert("title"))
                .setNotification(Notification.newBuilder().addPlatformNotification(AndroidNotification.newBuilder().addExtra("news_id", "abcdefg").setAlert("title").build()).build())
                .setMessage(Message.content("content"))
                .build();
    }
}
