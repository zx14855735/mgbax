package com.qq.e.ads;

import com.qq.e.comm.pi.IBiddingLoss;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class NativeAbstractAD<T extends IBiddingLoss> extends AbstractAD<T> implements IBiddingLoss {

    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(T t) {
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        ((IBiddingLoss) this.f12733a).sendLossNotification(map);
    }
}
