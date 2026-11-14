package LLiCI0;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ViewPager2 f4672A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Handler f4673A4TApA = new Handler(Looper.getMainLooper());

    /* renamed from: A5SV6n, reason: collision with root package name */
    public long f4674A5SV6n = 3000;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f4675ADYaiT = false;
    public final Rect AMqCpz = new Rect();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final LLYwnm.AMqCpz f4676ARc23Z = new LLYwnm.AMqCpz(4, this);

    public A4TApA(ViewPager2 viewPager2) {
        this.f4672A2egSU = viewPager2;
    }

    public final void A2egSU() {
        this.f4674A5SV6n = PushUIConfig.dismissTime;
        this.f4675ADYaiT = true;
        Handler handler = this.f4673A4TApA;
        LLYwnm.AMqCpz aMqCpz = this.f4676ARc23Z;
        handler.removeCallbacks(aMqCpz);
        handler.postDelayed(aMqCpz, PushUIConfig.dismissTime);
    }
}
