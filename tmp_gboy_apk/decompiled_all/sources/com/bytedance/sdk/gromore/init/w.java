package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bytedance.msdk.api.u.f;
import com.bytedance.msdk.api.u.pl;
import com.bytedance.msdk.api.u.xj;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static volatile AtomicBoolean hf = new AtomicBoolean(false);
    private static volatile boolean u;
    private static volatile SparseArray<Object> w;
    private static volatile boolean xj;
    private long c;
    private com.bytedance.sdk.openadsdk.core.wo.w kd;
    private com.bytedance.sdk.openadsdk.core.w y;

    static {
        kXspf();
    }

    private static /* synthetic */ void kXspf() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.kd != null) {
            u = true;
            kd.kd = SystemClock.elapsedRealtime();
            if (this.c != 0) {
                kd.c = SystemClock.elapsedRealtime() - this.c;
            }
            com.bytedance.msdk.xj.kd.w.hf("TMe", "sdk init call callback success");
            com.bytedance.sdk.openadsdk.zg.kd xj2 = com.bytedance.sdk.openadsdk.zg.kd.xj().xj(true);
            if (this.y != null) {
                com.bytedance.sdk.openadsdk.zg.u xj3 = com.bytedance.sdk.openadsdk.zg.u.xj();
                xj3.xj(23, this.y.w());
                xj2.xj(xj3.hf());
            }
            w = xj2.hf();
            this.kd.xj(0, w);
            com.bytedance.msdk.y.u.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf() {
        if (hf.get()) {
            com.bytedance.msdk.xj.kd.w.hf("TMe", "通知成功或失败了不在通知");
            return;
        }
        hf.set(true);
        com.bytedance.msdk.xj.kd.w.hf("TMe", "通知成功=----notifySdkSuccess");
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.sdk.gromore.init.w.2
            @Override // java.lang.Runnable
            public void run() {
                w.this.w();
            }
        });
    }

    public void xj(Context context, com.bytedance.sdk.gromore.xj.hf.xj xjVar, com.bytedance.sdk.openadsdk.core.wo.w wVar, long j, com.bytedance.sdk.openadsdk.core.w wVar2) {
        this.kd = wVar;
        this.c = j;
        this.y = wVar2;
        if (xjVar == null) {
            com.bytedance.msdk.xj.kd.w.hf("TMe", "init csjm configValueSet is null");
            return;
        }
        com.bytedance.msdk.core.xj.p().w(xjVar.kd());
        if (com.bytedance.msdk.core.xj.p().jk()) {
            com.bytedance.msdk.f.u.kd.xj(xjVar);
        }
        com.bytedance.msdk.xj.kd.w.hf("TMe", "init csjm " + xj);
        if (xj) {
            com.bytedance.msdk.xj.kd.w.hf("TMe", "init csjm already");
            if (wVar == null || w == null) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "sdk正在初始化....");
                return;
            } else {
                wVar.xj(0, w);
                return;
            }
        }
        com.bytedance.msdk.xj.kd.w.hf("TMe", "init csjm ");
        xj = true;
        hf.set(false);
        com.bytedance.msdk.core.p.xj.xj().hf();
        com.bytedance.msdk.core.p.xj.xj().xj(new com.bytedance.msdk.core.p.hf() { // from class: com.bytedance.sdk.gromore.init.w.1
            @Override // com.bytedance.msdk.core.p.hf
            public void xj() {
                com.bytedance.msdk.core.p.xj.xj().xj((com.bytedance.msdk.core.p.hf) null);
                w.this.hf();
            }

            @Override // com.bytedance.msdk.core.p.hf
            public void xj(int i, String str) {
                com.bytedance.msdk.core.p.xj.xj().xj((com.bytedance.msdk.core.p.hf) null);
                w.this.xj(i, str);
            }
        });
        com.bytedance.msdk.api.u.tf.xj(context, xj(xjVar));
        com.bytedance.msdk.api.u.tf.u();
    }

    private void hf(int i, String str) {
        if (i == 40004) {
            com.bytedance.msdk.xj.kd.w.hf("TMe", "sdk init call code is 40004 callback success");
            w();
        } else if (this.kd != null) {
            kd.kd = SystemClock.elapsedRealtime();
            com.bytedance.msdk.xj.kd.w.hf("TMe", "sdk init call callback fail");
            w = com.bytedance.sdk.openadsdk.zg.kd.xj().xj(false).xj(i).xj(str).hf();
            this.kd.xj(0, w);
            com.bytedance.msdk.y.u.w();
        }
    }

    public boolean xj() {
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, String str) {
        if (!hf.get()) {
            hf.set(true);
            hf(i, str);
        } else {
            com.bytedance.msdk.xj.kd.w.hf("TMe", "通知成功或失败了不在通知");
        }
    }

    private com.bytedance.msdk.api.u.xj xj(com.bytedance.sdk.gromore.xj.hf.xj xjVar) {
        return new xj.C0051xj().xj(xjVar.kd()).hf(xjVar.y()).xj(xjVar.u()).w(xjVar.qt()).hf(xjVar.zg()).xj(hf.xj(xjVar.e())).xj(xjVar.yo()).xj(xjVar.am()).w(xjVar.v()).xj(xjVar.jk()).u(xjVar.pl()).xj(new pl.xj().xj(xjVar.c()).hf(xjVar.f()).xj(xjVar.d()).xj(xjVar.tf()).hf(xjVar.p()).xj(xjVar.g()).xj(hf.xj(xjVar.yo())).xj()).xj(new f.xj().xj(xjVar.ht()).xj(xjVar.pz()).hf(xjVar.ra()).w(xjVar.dk()).xj()).xj(xjVar.hf()).xj();
    }
}
