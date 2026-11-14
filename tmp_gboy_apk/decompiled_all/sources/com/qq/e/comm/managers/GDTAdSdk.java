package com.qq.e.comm.managers;

import android.content.Context;
import com.qq.e.comm.managers.a.RunnableC0446a;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class GDTAdSdk {

    public interface OnStartListener {
        void onStartFailed(Exception exc);

        void onStartSuccess();
    }

    public static IGDTAdManager getGDTAdManger() {
        return a.b();
    }

    @Deprecated
    public static void init(Context context, String str) {
        GDTLogger.w("该方法已被废弃，请尽快切换初始化接口为GDTAdSdk#initWithoutStart、GDTAdSdk#start，详见接入文档或咨询技术支持。");
        a.b().A2egSU(context, str, true);
    }

    public static void initWithoutStart(Context context, String str) {
        a.b().A2egSU(context, str, false);
    }

    public static void start(OnStartListener onStartListener) {
        a b = a.b();
        synchronized (b) {
            if (b.f12921A2egSU) {
                a.g.submit(b.new RunnableC0446a(onStartListener));
                return;
            }
            GDTLogger.e("在调用start方法前请先调用initWithoutStart方法");
            if (onStartListener != null) {
                onStartListener.onStartFailed(new Exception("在调用start方法前请先调用initWithoutStart方法"));
            }
        }
    }
}
