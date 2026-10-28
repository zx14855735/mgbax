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
 * 把中继服务器挂成前台服务，让它在切到后台、锁屏之后继续跑。
 *
 * 之所以要前台服务：中继设备往往就是一台闲置手机，屏幕会灭。普通后台进程
 * 随时可能被系统回收，一收就把两位玩家的房间一起断掉。
 */
public final class RelayService extends Service {

    static final String ACTION_START = "io.mgba.android.action.RELAY_START";
    static final String EXTRA_PORT = "relay_port";

    private static final String CHANNEL_ID = "relay";
    private static final int NOTIFICATION_ID = 0x4D47;

    /** 界面直接读这里拿运行状态，不需要 bindService。 */
    private static volatile RelayServer shared;

    static RelayServer server() {
        return shared;
    }

    static void start(Context context, int port) {
        Intent intent = new Intent(context, RelayService.class)
                .setAction(ACTION_START)
                .putExtra(EXTRA_PORT, port);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    static void stop(Context context) {
        context.stopService(new Intent(context, RelayService.class));
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
        int port = intent.getIntExtra(EXTRA_PORT, RemoteLink.RELAY_PORT);
        // 必须几秒内进入前台，否则系统直接抛 ANR/RemoteServiceException
        notifyForeground("正在启动中继…");
        RelayServer server = shared;
        if (server == null || !server.isRunning()) {
            server = new RelayServer();
            shared = server;
        }
        if (!server.start(port, this::notifyForeground)) {
            shared = null;
            stopSelf();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        RelayServer server = shared;
        shared = null;
        if (server != null) {
            server.stop();
        }
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
            // 少数 ROM 不允许升级前台类型时退化成普通通知，至少别崩
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
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "联机中继",
                        NotificationManager.IMPORTANCE_LOW);
                channel.setDescription("本机充当联机中继服务器时保持运行");
                manager.createNotificationChannel(channel);
            }
        }
        Notification.Builder builder = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                ? new Notification.Builder(this, CHANNEL_ID)
                : new Notification.Builder(this);
        int flags = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? PendingIntent.FLAG_IMMUTABLE : 0;
        PendingIntent pending = PendingIntent.getActivity(this, 0,
                new Intent(this, EmulatorActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK), flags);
        builder.setContentTitle("联机中继运行中")
                .setContentText(text)
                .setSmallIcon(R.drawable.ic_launcher)
                .setOngoing(true)
                .setContentIntent(pending);
        return builder.build();
    }
}
