package C4FrIb;

import java.util.concurrent.ThreadFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM implements ThreadFactory {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f1581A2egSU;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f1581A2egSU) {
            case 0:
                return new B2KMhB(runnable);
            default:
                return new Thread(new HXc4pW.A2egSU(0, runnable), "glide-active-resources");
        }
    }
}
