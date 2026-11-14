package com.kwad.components.core.offline.b.a;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class m extends IOfflineCompoWrapper {
    public m(String str) {
        super(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context unwrapContextIfNeed(Context context) {
        return com.kwad.library.b.c.c.unwrapContextIfNeed(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Application wrapApp(Application application) {
        return com.kwad.library.b.c.c.a(application, this.mOfflinePackageName);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context wrapContextIfNeed(Context context) {
        return com.kwad.library.b.c.c.l(context, this.mOfflinePackageName);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Application wrapGetApplication(Context context) {
        return com.kwad.sdk.o.m.US();
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        return com.kwad.library.b.c.c.a(layoutInflater, this.mOfflinePackageName);
    }
}
