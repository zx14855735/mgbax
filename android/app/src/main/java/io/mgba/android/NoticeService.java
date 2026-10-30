/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;

/**
 * 「游戏运行中」前台通知，移植自悠GBA模拟器的 EmulatorNoticeService：游戏
 * 加载后挂一个持续通知，把进程从后台清理里保下来。长跑（孵化、刷闪、挂机）
 * 的玩家切到桌面几分钟后游戏不再被杀。
 */
public final class NoticeService extends Service {

    private static final String ACTION_START = "io.mgba.android.action.NOTICE_START";
    private static final String EXTRA_TITLE = "notice_title";
    private static final String CHANNEL_ID = "game_running";
    private static final int NOTIFICATION_ID = 0x4D48;

    static void start(Context context, String title) {
        Intent intent = new Intent(context, NoticeService.class)
                .setAction(ACTION_START)
                .putExtra(EXTRA_TITLE, title == null ? "" : title);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    static void stop(Context context) {
        context.stopService(new Intent(context, NoticeService.class));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null || !ACTION_START.equals(intent.getAction())) {
            stopSelf();
            return START_NOT_STICKY;
        }
        String title = intent.getStringExtra(EXTRA_TITLE);
        notifyForeground(getString(R.string.notice_running,
                title == null || title.isEmpty() ? getString(R.string.app_name) : title));
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            stopForeground(STOP_FOREGROUND_REMOVE);
        } else {
            stopForeground(true);
        }
        super.onDestroy();
    }

    private void notifyForeground(String text) {
        Notification notification = build(text);
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(NOTIFICATION_ID, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC);
            } else {
                startForeground(NOTIFICATION_ID, notification);
            }
        } catch (RuntimeException e) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            if (manager != null) {
                try {
                    manager.notify(NOTIFICATION_ID, notification);
                } catch (RuntimeException ignored) {
                }
            }
        }
    }

    private Notification build(String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            if (manager != null && manager.getNotificationChannel(CHANNEL_ID) == null) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "游戏运行中",
                        NotificationManager.IMPORTANCE_LOW);
                channel.setDescription("游戏运行时保持进程不被后台清理");
                manager.createNotificationChannel(channel);
            }
        }
        Notification.Builder builder = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                ? new Notification.Builder(this, CHANNEL_ID)
                : new Notification.Builder(this);
        int flags = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? PendingIntent.FLAG_IMMUTABLE : 0;
        PendingIntent pending = PendingIntent.getActivity(this, 1,
                new Intent(this, EmulatorActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK), flags);
        builder.setContentTitle(getString(R.string.notice_title))
                .setContentText(text)
                .setSmallIcon(R.drawable.ic_launcher)
                .setOngoing(true)
                .setContentIntent(pending);
        return builder.build();
    }
}
