package FOAO9d;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS implements GJee0v.ASJ6gh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2593AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ HashMap f2594AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f2595AmA8tU;

    public /* synthetic */ AZkASS(HashMap hashMap, String str, int i) {
        this.f2593AcNBzu = i;
        this.f2594AlLFFp = hashMap;
        this.f2595AmA8tU = str;
    }

    @Override // GJee0v.ASJ6gh
    public final void a(File file) {
        String str = this.f2595AmA8tU;
        HashMap hashMap = this.f2594AlLFFp;
        switch (this.f2593AcNBzu) {
            case 0:
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                if (hashMap != null) {
                    hashMap.put(2, "finish");
                    hashMap.put(3, file.getAbsolutePath() + "/" + str + ".gif");
                    break;
                }
                break;
            default:
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                if (hashMap != null) {
                    hashMap.put(2, "finish");
                    hashMap.put(3, file.getAbsolutePath() + "/" + str + ".gif");
                    break;
                }
                break;
        }
    }

    @Override // GJee0v.ASJ6gh
    public final void a(Exception exc) {
        switch (this.f2593AcNBzu) {
            case 0:
                Objects.toString(exc);
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                break;
            default:
                Objects.toString(exc);
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                break;
        }
    }
}
