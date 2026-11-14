package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BpkvW3 extends ASJ6gh {
    final /* synthetic */ C2rE4F this$0;

    public static final class A2egSU extends ASJ6gh {
        final /* synthetic */ C2rE4F this$0;

        public A2egSU(C2rE4F c2rE4F) {
            this.this$0 = c2rE4F;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
            this.this$0.A2egSU();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
            C2rE4F c2rE4F = this.this$0;
            int i = c2rE4F.f9000AcNBzu + 1;
            c2rE4F.f9000AcNBzu = i;
            if (i == 1 && c2rE4F.f9003AzWtSf) {
                c2rE4F.f9005B2KMhB.ARc23Z(AlLFFp.ON_START);
                c2rE4F.f9003AzWtSf = false;
            }
        }
    }

    public BpkvW3(C2rE4F c2rE4F) {
        this.this$0 = c2rE4F;
    }

    @Override // androidx.lifecycle.ASJ6gh, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        if (Build.VERSION.SDK_INT < 29) {
            int i = CNPG0E.f9008AlLFFp;
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            RXb0Sz.ARc23Z.A5SV6n(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((CNPG0E) findFragmentByTag).f9009AcNBzu = this.this$0.f9007B4ZgIw;
        }
    }

    @Override // androidx.lifecycle.ASJ6gh, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        C2rE4F c2rE4F = this.this$0;
        int i = c2rE4F.f9001AlLFFp - 1;
        c2rE4F.f9001AlLFFp = i;
        if (i == 0) {
            Handler handler = c2rE4F.f9004B25kr6;
            RXb0Sz.ARc23Z.A4TApA(handler);
            handler.postDelayed(c2rE4F.f9006B3GDIM, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        BniPrB.A2egSU(activity, new A2egSU(this.this$0));
    }

    @Override // androidx.lifecycle.ASJ6gh, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        C2rE4F c2rE4F = this.this$0;
        int i = c2rE4F.f9000AcNBzu - 1;
        c2rE4F.f9000AcNBzu = i;
        if (i == 0 && c2rE4F.f9002AmA8tU) {
            c2rE4F.f9005B2KMhB.ARc23Z(AlLFFp.ON_STOP);
            c2rE4F.f9003AzWtSf = true;
        }
    }
}
