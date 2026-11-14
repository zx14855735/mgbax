package Mi9UWv;

import AaHO0E.D8MqeW;
import android.app.Activity;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5391AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ArrayList f5392AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ ASJ6gh f5393AmA8tU;

    public /* synthetic */ A5SV6n(ASJ6gh aSJ6gh, ArrayList arrayList, int i) {
        this.f5391AcNBzu = i;
        this.f5393AmA8tU = aSJ6gh;
        this.f5392AlLFFp = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5391AcNBzu) {
            case 0:
                HashMap hashMap = new HashMap();
                int i = 0;
                while (i < this.f5392AlLFFp.size()) {
                    MTKlkd.AMqCpz aMqCpz = (MTKlkd.AMqCpz) this.f5392AlLFFp.get(i);
                    String A2egSU2 = aMqCpz.A2egSU();
                    try {
                        String str = (String) hashMap.get(A2egSU2);
                        if (str == null) {
                            this.f5393AmA8tU.getClass();
                            int B4ZgIw2 = ASJ6gh.B4ZgIw(A2egSU2);
                            if (B4ZgIw2 >= 0) {
                                str = B4ZgIw2 + "ms";
                            } else {
                                str = "超时";
                            }
                            hashMap.put(A2egSU2, str);
                        }
                        aMqCpz.f5225ASJ6gh = str;
                    } catch (Exception unused) {
                        aMqCpz.f5225ASJ6gh = "超时";
                        hashMap.put(A2egSU2, "超时");
                    }
                    int i2 = i + 1;
                    if (i2 % 3 == 0 || i2 == this.f5392AlLFFp.size()) {
                        ArrayList arrayList = new ArrayList(this.f5392AlLFFp);
                        Activity activity = this.f5393AmA8tU.f5409B9tovu;
                        if (activity != null && !activity.isFinishing() && !this.f5393AmA8tU.f5414BNL6CD) {
                            this.f5393AmA8tU.f5409B9tovu.runOnUiThread(new D8MqeW(this, arrayList, i2, 2, false));
                        }
                    }
                    i = i2;
                }
                break;
            default:
                ASJ6gh aSJ6gh = this.f5393AmA8tU;
                aSJ6gh.f5404B25kr6.clear();
                ArrayList arrayList2 = aSJ6gh.f5404B25kr6;
                ArrayList arrayList3 = this.f5392AlLFFp;
                arrayList2.addAll(arrayList3);
                A4TApA a4TApA = aSJ6gh.f5413BJ7GGh;
                if (a4TApA != null) {
                    a4TApA.f5388AcNBzu = aSJ6gh.f5404B25kr6;
                    a4TApA.notifyDataSetChanged();
                }
                arrayList3.isEmpty();
                break;
        }
    }
}
