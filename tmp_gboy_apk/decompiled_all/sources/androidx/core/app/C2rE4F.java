package androidx.core.app;

import android.os.Build;
import android.widget.RemoteViews;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class C2rE4F extends C4FrIb {
    @Override // androidx.core.app.C4FrIb
    public final void A4TApA(CikNvS cikNvS) {
        if (Build.VERSION.SDK_INT >= 24) {
            cikNvS.f8556A4TApA.setStyle(BpkvW3.A2egSU());
        }
    }

    @Override // androidx.core.app.C4FrIb
    public final String AMqCpz() {
        return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
    }

    @Override // androidx.core.app.C4FrIb
    public final RemoteViews ARc23Z() {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        BV3sI0 bV3sI0 = this.f8553A2egSU;
        RemoteViews remoteViews = bV3sI0.f8542C4FrIb;
        if (remoteViews == null) {
            remoteViews = bV3sI0.f8541C2rE4F;
        }
        if (remoteViews == null) {
            return null;
        }
        return AZOQYO(remoteViews, true);
    }

    @Override // androidx.core.app.C4FrIb
    public final RemoteViews ASJ6gh() {
        RemoteViews remoteViews;
        if (Build.VERSION.SDK_INT < 24 && (remoteViews = this.f8553A2egSU.f8541C2rE4F) != null) {
            return AZOQYO(remoteViews, false);
        }
        return null;
    }

    @Override // androidx.core.app.C4FrIb
    public final RemoteViews AYUAbz() {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        BV3sI0 bV3sI0 = this.f8553A2egSU;
        RemoteViews remoteViews = bV3sI0.f8543CASmeH;
        RemoteViews remoteViews2 = remoteViews != null ? remoteViews : bV3sI0.f8541C2rE4F;
        if (remoteViews == null) {
            return null;
        }
        return AZOQYO(remoteViews2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.widget.RemoteViews AZOQYO(android.widget.RemoteViews r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.C2rE4F.AZOQYO(android.widget.RemoteViews, boolean):android.widget.RemoteViews");
    }
}
