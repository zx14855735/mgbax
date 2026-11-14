package com.bytedance.sdk.openadsdk.y.hf;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.component.utils.f;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Handler.Callback {
    private Handler xj;

    public static class xj {
        public static final w xj = new w();

        static {
            lAyF();
        }

        private static /* synthetic */ void lAyF() {
            char[] charArray = "\t\u0005\u0007D\r\u000b\u0007\u000fD\b\u0005\u0013D\u0019\u0002\u000f\u0006\u0006D \u0004\u0003(\u0018\u0003\u000e\r\u000f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'j');
            }
            String str = new String(charArray);
            char[] charArray2 = "\t\u0006\u0003\u0004\u0003\u001e".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'j');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static w xj() {
        return xj.xj;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ((Runnable) message.obj).run();
        return false;
    }

    private w() {
        this.xj = new Handler(f.xj().getLooper(), this);
    }

    public void xj(Runnable runnable) {
        Message obtain = Message.obtain();
        obtain.obj = runnable;
        this.xj.sendMessage(obtain);
    }

    public void xj(Runnable runnable, long j) {
        this.xj.postDelayed(runnable, j);
    }
}
