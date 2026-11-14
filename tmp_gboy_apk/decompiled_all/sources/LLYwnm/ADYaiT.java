package LLYwnm;

import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4615AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Map f4616AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f4617AmA8tU;

    public /* synthetic */ ADYaiT(AYUAbz aYUAbz, Map map, int i) {
        this.f4615AcNBzu = i;
        this.f4617AmA8tU = aYUAbz;
        this.f4616AlLFFp = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4615AcNBzu) {
            case 0:
                Iterator it = this.f4617AmA8tU.f4630ARc23Z.iterator();
                while (it.hasNext()) {
                    ((AzWtSf) it.next()).ADYaiT(this.f4616AlLFFp);
                }
                break;
            case 1:
                Iterator it2 = this.f4617AmA8tU.f4630ARc23Z.iterator();
                while (it2.hasNext()) {
                    ((AzWtSf) it2.next()).AMqCpz(this.f4616AlLFFp);
                }
                break;
            case 2:
                Iterator it3 = this.f4617AmA8tU.f4630ARc23Z.iterator();
                while (it3.hasNext()) {
                    ((AzWtSf) it3.next()).A4TApA(this.f4616AlLFFp);
                }
                break;
            case 3:
                Iterator it4 = this.f4617AmA8tU.f4631ASJ6gh.iterator();
                while (it4.hasNext()) {
                    ((AmA8tU) it4.next()).ADYaiT(this.f4616AlLFFp);
                }
                break;
            case 4:
                Iterator it5 = this.f4617AmA8tU.f4631ASJ6gh.iterator();
                while (it5.hasNext()) {
                    ((AmA8tU) it5.next()).A5SV6n(this.f4616AlLFFp);
                }
                break;
            case 5:
                Iterator it6 = this.f4617AmA8tU.f4631ASJ6gh.iterator();
                while (it6.hasNext()) {
                    ((AmA8tU) it6.next()).A2egSU(this.f4616AlLFFp);
                }
                break;
            case 6:
                Iterator it7 = this.f4617AmA8tU.f4631ASJ6gh.iterator();
                while (it7.hasNext()) {
                    ((AmA8tU) it7.next()).AMqCpz(this.f4616AlLFFp);
                }
                break;
            default:
                Iterator it8 = this.f4617AmA8tU.f4631ASJ6gh.iterator();
                while (it8.hasNext()) {
                    ((AmA8tU) it8.next()).A4TApA(this.f4616AlLFFp);
                }
                break;
        }
    }
}
