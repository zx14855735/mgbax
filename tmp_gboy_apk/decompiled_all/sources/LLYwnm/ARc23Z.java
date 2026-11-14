package LLYwnm;

import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4620AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f4621AlLFFp;

    public /* synthetic */ ARc23Z(AYUAbz aYUAbz, Object obj, int i) {
        this.f4620AcNBzu = i;
        this.f4621AlLFFp = aYUAbz;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        switch (this.f4620AcNBzu) {
            case 0:
                Iterator it = this.f4621AlLFFp.f4631ASJ6gh.iterator();
                while (it.hasNext()) {
                    ((AmA8tU) it.next()).getClass();
                }
                break;
            case 1:
                Iterator it2 = this.f4621AlLFFp.f4629ADYaiT.iterator();
                while (it2.hasNext()) {
                    com.game.boy.activity.AzWtSf azWtSf = (com.game.boy.activity.AzWtSf) it2.next();
                    String B25kr62 = azWtSf.f10907A2egSU.f10999BChYOn.B25kr6("user_token");
                    if (B25kr62 != null) {
                        if (azWtSf.f10907A2egSU.f11015CSDoyG == null) {
                            str = new String(azWtSf.f10907A2egSU.f11004BPw6Q8.f11100A2egSU.getRomCode()) + "," + azWtSf.f10907A2egSU.f11004BPw6Q8.f11100A2egSU.getRomHash();
                        } else {
                            str = Mi9UWv.ASJ6gh.f5401BmvVmW;
                        }
                        azWtSf.f10907A2egSU.f11000BI9f7h = new String(azWtSf.f10907A2egSU.f11004BPw6Q8.f11100A2egSU.getRomCode()) + "," + azWtSf.f10907A2egSU.f11004BPw6Q8.f11100A2egSU.getRomHash();
                        Mi9UWv.ASJ6gh.f5401BmvVmW = str;
                        azWtSf.f10907A2egSU.f10998B9tovu.f4627A4TApA = B25kr62;
                        azWtSf.f10907A2egSU.f10998B9tovu.f4628A5SV6n = str;
                        azWtSf.f10907A2egSU.f10998B9tovu.ADYaiT("", null, null);
                    }
                }
                break;
            default:
                Iterator it3 = this.f4621AlLFFp.f4629ADYaiT.iterator();
                while (it3.hasNext()) {
                    ((com.game.boy.activity.AzWtSf) it3.next()).getClass();
                }
                break;
        }
    }

    public ARc23Z(AYUAbz aYUAbz) {
        this.f4620AcNBzu = 1;
        this.f4621AlLFFp = aYUAbz;
    }
}
