package LLYwnm;

import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4604AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ String f4605AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f4606AmA8tU;

    public /* synthetic */ A2egSU(AYUAbz aYUAbz, String str, int i) {
        this.f4604AcNBzu = i;
        this.f4606AmA8tU = aYUAbz;
        this.f4605AlLFFp = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4604AcNBzu) {
            case 0:
                Iterator it = this.f4606AmA8tU.f4629ADYaiT.iterator();
                while (it.hasNext()) {
                    ((com.game.boy.activity.AzWtSf) it.next()).A2egSU(this.f4605AlLFFp);
                }
                break;
            case 1:
                Iterator it2 = this.f4606AmA8tU.f4629ADYaiT.iterator();
                while (it2.hasNext()) {
                    ((com.game.boy.activity.AzWtSf) it2.next()).A2egSU(this.f4605AlLFFp);
                }
                break;
            default:
                Iterator it3 = this.f4606AmA8tU.f4630ARc23Z.iterator();
                while (it3.hasNext()) {
                    ((AzWtSf) it3.next()).A2egSU(this.f4605AlLFFp);
                }
                break;
        }
    }
}
