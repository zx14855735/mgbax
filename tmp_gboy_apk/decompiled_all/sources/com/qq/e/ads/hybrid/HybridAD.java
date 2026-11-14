package com.qq.e.ads.hybrid;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final /* synthetic */ int f12784B9tovu = 0;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final HybridADListener f12785B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final CountDownLatch f12786B4ZgIw = new CountDownLatch(1);

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final HybridADSetting f12787B7CMnp;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f12787B7CMnp = hybridADSetting;
        this.f12785B3GDIM = hybridADListener;
        a(context, "NO_POS_ID");
    }

    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getHybridAD(this.f12787B7CMnp, this.f12785B3GDIM);
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        if (a()) {
            if (!b()) {
                new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HybridAD hybridAD = HybridAD.this;
                        try {
                            hybridAD.f12786B4ZgIw.await(30L, TimeUnit.SECONDS);
                            if (hybridAD.b() && ((AbstractAD) hybridAD).f12733a != null) {
                                ((HADI) ((AbstractAD) hybridAD).f12733a).loadUrl(str);
                            } else {
                                GDTLogger.e("初始化错误：广告实例未被初始化");
                                hybridAD.a(2001);
                            }
                        } catch (InterruptedException unused) {
                            GDTLogger.e("初始化错误：广告实例未被初始化");
                            int i = HybridAD.f12784B9tovu;
                            hybridAD.a(2001);
                        }
                    }
                }).start();
                return;
            }
            T t = this.f12733a;
            if (t != 0) {
                ((HADI) t).loadUrl(str);
            } else {
                a("loadUrl");
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(HADI hadi) {
        this.f12786B4ZgIw.countDown();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        HybridADListener hybridADListener = this.f12785B3GDIM;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i));
        }
        this.f12786B4ZgIw.countDown();
    }
}
