package com.ss.android.socialbase.downloader.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class kd implements Handler.Callback {
    private volatile Handler xj = new Handler(xj.xj, this);

    public interface hf {
        long xj();
    }

    public static class xj {
        private static final Looper xj;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            xj = handlerThread.getLooper();
            nwycGU();
        }

        private static /* synthetic */ void nwycGU() {
            char[] charArray = "#/-n'!-%n\"/9n3(%,,n\n.)\u00022)$'%".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '@');
            }
            String str = new String(charArray);
            char[] charArray2 = "#,).)4".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '@');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static Looper xj() {
        return xj.xj;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            hf hfVar = (hf) message.obj;
            long xj2 = hfVar.xj();
            if (xj2 <= 0) {
                return true;
            }
            xj(hfVar, xj2);
            return true;
        } catch (Throwable th) {
            pl.xj(th);
            return true;
        }
    }

    public void hf() {
        Handler handler = this.xj;
        if (handler == null) {
            return;
        }
        this.xj = null;
        handler.removeCallbacksAndMessages(null);
    }

    public void xj(hf hfVar, long j) {
        Handler handler = this.xj;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = hfVar;
        handler.sendMessageDelayed(obtain, j);
    }
}
