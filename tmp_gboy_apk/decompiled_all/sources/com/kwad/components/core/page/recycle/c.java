package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.Dphsd2;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c extends Dphsd2 {
    public final e UH;
    public final Presenter mPresenter;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.UH = eVar;
        this.mPresenter = presenter;
        presenter.M(view);
    }
}
