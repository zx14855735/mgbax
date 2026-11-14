package Qo94AZ;

import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AZkASS extends HashMap {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AlLFFp f7793AcNBzu;

    public AZkASS(AlLFFp alLFFp) {
        this.f7793AcNBzu = alLFFp;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        this.f7793AcNBzu.f7809B2KMhB.put(str == null ? str : str.toLowerCase(), str2);
        return (String) super.put(str, str2);
    }
}
