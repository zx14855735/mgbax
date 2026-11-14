package androidx.lifecycle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BNL6CD {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final BV3sI0 f8995AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f8996AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f8997AmA8tU = -1;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ LiveData f8998AzWtSf;

    public BNL6CD(LiveData liveData, BV3sI0 bV3sI0) {
        this.f8998AzWtSf = liveData;
        this.f8995AcNBzu = bV3sI0;
    }

    public final void A2egSU(boolean z) {
        if (z == this.f8996AlLFFp) {
            return;
        }
        this.f8996AlLFFp = z;
        int i = z ? 1 : -1;
        LiveData liveData = this.f8998AzWtSf;
        int i2 = liveData.f9047A5SV6n;
        liveData.f9047A5SV6n = i + i2;
        if (!liveData.f9048ADYaiT) {
            liveData.f9048ADYaiT = true;
            while (true) {
                try {
                    int i3 = liveData.f9047A5SV6n;
                    if (i2 == i3) {
                        break;
                    } else {
                        i2 = i3;
                    }
                } finally {
                    liveData.f9048ADYaiT = false;
                }
            }
        }
        if (this.f8996AlLFFp) {
            liveData.A5SV6n(this);
        }
    }

    public void A4TApA() {
    }

    public abstract boolean A5SV6n();
}
