package LLYwnm;

import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4607AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ String f4608AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ int f4609AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f4610AzWtSf;

    public /* synthetic */ A4TApA(AYUAbz aYUAbz, String str, int i, int i2) {
        this.f4607AcNBzu = i2;
        this.f4610AzWtSf = aYUAbz;
        this.f4608AlLFFp = str;
        this.f4609AmA8tU = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4607AcNBzu) {
            case 0:
                Iterator it = this.f4610AzWtSf.AMqCpz.iterator();
                while (it.hasNext()) {
                    ((AlLFFp) it.next()).A4TApA(this.f4609AmA8tU, this.f4608AlLFFp);
                }
                break;
            default:
                Iterator it2 = this.f4610AzWtSf.AMqCpz.iterator();
                while (it2.hasNext()) {
                    ((AlLFFp) it2.next()).A5SV6n(this.f4609AmA8tU, this.f4608AlLFFp);
                }
                break;
        }
    }
}
