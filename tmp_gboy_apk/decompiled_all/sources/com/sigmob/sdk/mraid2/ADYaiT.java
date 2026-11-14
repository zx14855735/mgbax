package com.sigmob.sdk.mraid2;

import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13510AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13511AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f13512AmA8tU;

    public /* synthetic */ ADYaiT(Object obj, int i, Object obj2) {
        this.f13510AcNBzu = i;
        this.f13511AlLFFp = obj;
        this.f13512AmA8tU = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13510AcNBzu) {
            case 0:
                ((d) this.f13511AlLFFp).b((JSONObject) this.f13512AmA8tU);
                break;
            case 1:
                ((a) this.f13511AlLFFp).c((String) this.f13512AmA8tU);
                break;
            default:
                ((d) this.f13511AlLFFp).b((List) this.f13512AmA8tU);
                break;
        }
    }
}
