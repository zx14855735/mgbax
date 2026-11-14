package KCxDWD;

import ADYaiT.D8MqeW;
import K7mCWO.AMqCpz;
import K7mCWO.AZOQYO;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A4TApA f4233AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public volatile boolean f4234AlLFFp = false;

    public A2egSU(A4TApA a4TApA) {
        D8MqeW d8MqeW = new D8MqeW(20, this);
        this.f4233AcNBzu = a4TApA;
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            file.lastModified();
        }
        AZOQYO.A2egSU(2L);
        AMqCpz.A2egSU().A4TApA(4500L, d8MqeW, 1, 0L);
        AMqCpz.A2egSU().A4TApA(PushUIConfig.dismissTime, this, 40, PushUIConfig.dismissTime);
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02e0, code lost:
    
        r0.put("mainStackFromTrace", r5);
        r0.put("thread_number", 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02eb, code lost:
    
        com.bumptech.glide.AMqCpz.D9tr6l(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0386 A[Catch: all -> 0x03b9, TryCatch #4 {all -> 0x03b9, blocks: (B:38:0x0317, B:40:0x0386, B:41:0x03a5, B:43:0x03ab, B:45:0x03b1, B:46:0x03b8), top: B:37:0x0317 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03b1 A[Catch: all -> 0x03b9, TryCatch #4 {all -> 0x03b9, blocks: (B:38:0x0317, B:40:0x0386, B:41:0x03a5, B:43:0x03ab, B:45:0x03b1, B:46:0x03b8), top: B:37:0x0317 }] */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 960
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: KCxDWD.A2egSU.run():void");
    }
}
