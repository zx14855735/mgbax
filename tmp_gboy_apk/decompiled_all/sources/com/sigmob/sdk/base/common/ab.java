package com.sigmob.sdk.base.common;

import android.os.Handler;
import android.os.HandlerThread;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ab {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13099a = "NativeLoadReadyRecordManager";
    private static final ab f = new ab();
    private boolean b = false;
    private int c = AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT;
    private HandlerThread d;
    private Handler e;

    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ab.this.b) {
                ab.this.d();
                try {
                    HashMap<String, aa> a2 = aa.a();
                    if (com.sigmob.sdk.base.utils.e.b(a2)) {
                        Iterator it = new ArrayList(a2.values()).iterator();
                        while (it.hasNext()) {
                            aa aaVar = (aa) it.next();
                            if (aaVar != null) {
                                ae.a(aaVar);
                                aaVar.b();
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
                if (com.sigmob.sdk.base.utils.q.b(ab.this.e)) {
                    ab.this.e.postDelayed(this, ab.this.c * 1000);
                }
            }
        }
    }

    static {
        cXhtQ();
    }

    private ab() {
    }

    public static ab a() {
        return f;
    }

    private static /* synthetic */ void cXhtQ() {
        char[] charArray = "ÔØÚ\u0099ÐÖÚÒ\u0099ÕØÎ\u0099ÄßÒÛÛ\u0099ýÙÞõÅÞÓÐÒ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 183);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÔÛÞÙÞÃ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 183);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public synchronized void b() {
        try {
            if (this.b) {
                return;
            }
            this.b = true;
            aa.c();
            if (this.d == null) {
                HandlerThread handlerThread = new HandlerThread(f13099a);
                this.d = handlerThread;
                handlerThread.start();
            }
            if (this.e == null) {
                this.e = new Handler(this.d.getLooper());
            }
            this.e.removeCallbacksAndMessages(null);
            this.e.postDelayed(new a(), this.c * 1000);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Handler handler = this.e;
        if (handler == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public void a(int i) {
        if (i <= 0) {
            c();
            return;
        }
        int max = Math.max(i, 10);
        if (this.c == max) {
            return;
        }
        this.c = max;
        if (!this.b) {
            b();
        } else if (com.sigmob.sdk.base.utils.q.b(this.e)) {
            this.e.removeCallbacksAndMessages(null);
            this.e.postDelayed(new a(), i * 1000);
        }
    }

    public void c() {
        this.b = false;
        d();
    }
}
