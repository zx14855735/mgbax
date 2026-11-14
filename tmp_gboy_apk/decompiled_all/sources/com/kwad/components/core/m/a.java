package com.kwad.components.core.m;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.m.a.a> SP = new ArrayList();
    private final b<?> SQ;
    public final Context mContext;
    public final View mRootView;

    public a(b<?> bVar) {
        this.SQ = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Deprecated
    public final Activity getActivity() {
        return this.SQ.getActivity();
    }

    public final void iA() {
        this.SQ.finish();
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.SP.clear();
    }
}
