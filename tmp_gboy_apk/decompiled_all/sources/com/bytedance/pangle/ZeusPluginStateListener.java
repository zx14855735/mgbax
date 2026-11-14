package com.bytedance.pangle;

import A5SV6n.A2egSU;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ZeusPluginStateListener {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_DEX_START = 11;
    public static final int EVENT_INSTALL_DEX_SUCCESS = 12;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_DEX_START = 13;
    public static final int EVENT_LOAD_DEX_SUCCESS = 14;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FINISH = 0;
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    static {
        KiKY();
    }

    private static /* synthetic */ void KiKY() {
        char[] charArray = "\u0017\u001b\u0019Z\u0013\u0015\u0019\u0011Z\u0016\u001b\rZ\u0007\u001c\u0011\u0018\u0018Z>\u001a\u001d6\u0006\u001d\u0010\u0013\u0011".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 't');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0017\u0018\u001d\u001a\u001d\u0000".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 't');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void postStateChange(final String str, final int i, final Object... objArr) {
        mHandler.post(new Runnable() { // from class: com.bytedance.pangle.ZeusPluginStateListener.1
            @Override // java.lang.Runnable
            public void run() {
                List<ZeusPluginStateListener> w = tf.xj().w();
                if (w == null || w.size() <= 0) {
                    return;
                }
                Iterator<ZeusPluginStateListener> it = w.iterator();
                while (it.hasNext()) {
                    it.next().onPluginStateChange(TextUtils.isEmpty(str) ? "UNKNOWN" : str, i, objArr);
                }
            }
        });
        List<ZeusPluginStateListener> w = tf.xj().w();
        if (w == null || w.size() <= 0) {
            return;
        }
        Iterator<ZeusPluginStateListener> it = w.iterator();
        while (it.hasNext()) {
            it.next().onStateChangeOnCurThread(TextUtils.isEmpty(str) ? "UNKNOWN" : str, i, objArr);
        }
    }

    @Deprecated
    public void onPluginStateChange(String str, int i, Object... objArr) {
    }

    public void onStateChangeOnCurThread(String str, int i, Object... objArr) {
    }
}
