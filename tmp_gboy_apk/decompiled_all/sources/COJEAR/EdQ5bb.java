package COJEAR;

import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EdQ5bb {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final EmJGcg f1721A2egSU;

    public EdQ5bb() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.f1721A2egSU = new EicXu4();
        } else if (i >= 29) {
            this.f1721A2egSU = new EiK8oA();
        } else {
            this.f1721A2egSU = new EdhSi6();
        }
    }

    public EdQ5bb(FG7pZc fG7pZc) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.f1721A2egSU = new EicXu4(fG7pZc);
        } else if (i >= 29) {
            this.f1721A2egSU = new EiK8oA(fG7pZc);
        } else {
            this.f1721A2egSU = new EdhSi6(fG7pZc);
        }
    }
}
