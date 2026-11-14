package com.ss.android.downloadlib.hf;

import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.socialbase.downloader.xj.xj;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd implements xj.InterfaceC0510xj {
    private long xj;

    public static class xj {
        private static kd xj = new kd();

        static {
            xRVwuA();
        }

        private static /* synthetic */ void xRVwuA() {
            char[] charArray = "\u001c\u0010\u0012Q\u0018\u001e\u0012\u001aQ\u001d\u0010\u0006Q\f\u0017\u001a\u0013\u0013Q5\u0011\u0016=\r\u0016\u001b\u0018\u001a".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 127);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u001c\u0013\u0016\u0011\u0016\u000b".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 127);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
    public void hf() {
        this.xj = System.currentTimeMillis();
    }

    @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
    public void w() {
    }

    private kd() {
        this.xj = 0L;
        com.ss.android.socialbase.downloader.xj.xj.xj().xj(this);
    }

    public static kd xj() {
        return xj.xj;
    }

    public void hf(u uVar) {
        if (uVar == null) {
            return;
        }
        xj(uVar, pl.d().optInt("check_an_result_delay", 1200) > 0 ? r0 : 1200);
    }

    public void xj(final u uVar, final long j) {
        if (uVar == null) {
            return;
        }
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.hf.kd.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.ss.android.socialbase.downloader.xj.xj.xj().w() || System.currentTimeMillis() - kd.this.xj <= j) {
                    uVar.xj(true);
                } else {
                    uVar.xj(false);
                }
            }
        }, j);
    }

    public void xj(u uVar) {
        xj(uVar, PushUIConfig.dismissTime);
    }
}
