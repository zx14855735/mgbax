package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static hf hf;
    private final Map<String, xj> w = new ConcurrentHashMap();
    private final Map<PluginBroadcastReceiver, BroadcastReceiver> u = new ConcurrentHashMap();
    public final Set<Integer> xj = new CopyOnWriteArraySet();

    public static class xj {
        public final Set<PluginBroadcastReceiver> hf = new CopyOnWriteArraySet();
        public String xj;

        public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.hf.add(pluginBroadcastReceiver);
            }
        }

        public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                try {
                    if (this.hf.size() > 0) {
                        this.hf.remove(pluginBroadcastReceiver);
                    }
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-plugin-receiver->action:" + this.xj + "[exception]:", th);
                }
            }
        }

        public void xj(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set = this.hf;
            if (set == null || set.size() <= 0) {
                return;
            }
            for (PluginBroadcastReceiver pluginBroadcastReceiver : this.hf) {
                if (pluginBroadcastReceiver != null) {
                    try {
                        pluginBroadcastReceiver.onReceive(context, intent);
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + (intent != null ? intent.getAction() : "") + "[exception]:", th);
                    }
                }
            }
        }
    }

    private hf() {
    }

    public static hf xj() {
        if (hf == null) {
            synchronized (com.bytedance.pangle.service.xj.xj.class) {
                try {
                    if (hf == null) {
                        hf = new hf();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        Intent registerReceiver;
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
                return context.registerReceiver(null, intentFilter);
            }
            registerReceiver = context.registerReceiver(null, intentFilter, 2);
            return registerReceiver;
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        Intent registerReceiver2 = (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) ? context.registerReceiver(broadcastReceiverProxy, intentFilter) : context.registerReceiver(broadcastReceiverProxy, intentFilter, 2);
        this.u.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        xj(intentFilter, pluginBroadcastReceiver);
        return registerReceiver2;
    }

    public void unregisterReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver) {
        Iterator<Map.Entry<String, xj>> it = this.w.entrySet().iterator();
        while (it.hasNext()) {
            xj value = it.next().getValue();
            if (value != null) {
                value.unregisterReceiver(pluginBroadcastReceiver);
            }
            BroadcastReceiver broadcastReceiver = this.u.get(pluginBroadcastReceiver);
            if (broadcastReceiver != null) {
                try {
                    this.xj.remove(Integer.valueOf(broadcastReceiver.hashCode()));
                    this.u.remove(pluginBroadcastReceiver);
                    context.unregisterReceiver(broadcastReceiver);
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th);
                }
            }
        }
    }

    public boolean xj(int i) {
        return this.xj.contains(Integer.valueOf(i));
    }

    private void xj(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        Iterator<String> actionsIterator = intentFilter.actionsIterator();
        while (actionsIterator.hasNext()) {
            String next = actionsIterator.next();
            if (next != null) {
                xj xjVar = this.w.get(next);
                if (xjVar != null) {
                    xjVar.registerReceiver(pluginBroadcastReceiver);
                } else {
                    xj xjVar2 = new xj();
                    xjVar2.xj = next;
                    xjVar2.registerReceiver(pluginBroadcastReceiver);
                    this.w.put(next, xjVar2);
                }
            }
        }
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        Intent registerReceiver;
        Intent registerReceiver2;
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                registerReceiver2 = context.registerReceiver(null, intentFilter, 2);
                return registerReceiver2;
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            registerReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler, 2);
        } else {
            registerReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler);
        }
        this.u.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.xj.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        xj(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public void xj(Context context, Intent intent) {
        xj value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, xj> map = this.w;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, xj> entry : this.w.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                value.xj(context, intent);
            }
        }
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i) {
        int i2;
        Intent registerReceiver;
        Intent registerReceiver2;
        if (intentFilter == null || intentFilter.actionsIterator() == null || (i2 = Build.VERSION.SDK_INT) < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (i2 >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                registerReceiver2 = context.registerReceiver(null, intentFilter, 2);
                return registerReceiver2;
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        registerReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, i);
        this.u.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        xj(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        int i2;
        Intent registerReceiver;
        Intent registerReceiver2;
        if (intentFilter == null || intentFilter.actionsIterator() == null || (i2 = Build.VERSION.SDK_INT) < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (i2 >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                registerReceiver2 = context.registerReceiver(null, intentFilter, 2);
                return registerReceiver2;
            }
            return context.registerReceiver(null, intentFilter);
        }
        BroadcastReceiverProxy broadcastReceiverProxy = new BroadcastReceiverProxy();
        registerReceiver = context.registerReceiver(broadcastReceiverProxy, intentFilter, str, handler, i);
        this.u.put(pluginBroadcastReceiver, broadcastReceiverProxy);
        if (handler != null) {
            this.xj.add(Integer.valueOf(broadcastReceiverProxy.hashCode()));
        }
        xj(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }
}
