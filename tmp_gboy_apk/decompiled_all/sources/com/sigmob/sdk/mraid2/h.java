package com.sigmob.sdk.mraid2;

import android.view.View;
import com.sigmob.sdk.base.common.am;
import com.sigmob.sdk.base.models.SensorEntity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h extends com.sigmob.sdk.mraid.o {
    public h(String str, String str2) {
        super(str);
        a(com.sigmob.sdk.b.e(), str2);
    }

    @Override // com.sigmob.sdk.mraid.n
    public View a() {
        return null;
    }

    @Override // com.sigmob.sdk.mraid.n
    public void b() {
        this.d = null;
        am.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        aVar.c();
    }

    @Override // com.sigmob.sdk.mraid.o
    public void a(float f) {
    }

    @Override // com.sigmob.sdk.mraid.o
    public void b(float f) {
    }

    public void a(SensorEntity sensorEntity) {
        am.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        aVar.a(sensorEntity);
    }
}
