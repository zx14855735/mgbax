package com.kwad.components.core.proxy;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.kwad.components.core.exception.KSAdPreCreateException;
import com.kwad.components.core.s.s;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class f extends IActivityProxy implements com.kwad.components.core.proxy.a.c {
    private static final String FRAGMENTS_TAG = "android:fragments";
    public static final String KEY_START_TIME = "key_start_time";
    public Context mContext;
    private boolean mHasCallFinish;
    public View mRootView;
    private final com.kwad.components.core.proxy.a.a mPageMonitor = new com.kwad.components.core.proxy.a.a(this);
    private final com.kwad.sdk.m.a.a mBackPressDelete = new com.kwad.sdk.m.a.a();

    private void disableFragmentRestore(Bundle bundle) {
        if (bundle == null || !com.kwad.sdk.l.DP().CT()) {
            return;
        }
        bundle.remove(FRAGMENTS_TAG);
    }

    public void addBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    public boolean checkIntentData(Intent intent) {
        return true;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public <T extends View> T findViewById(int i) {
        T t = (T) this.mRootView.findViewById(i);
        return t != null ? t : (T) super.findViewById(i);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        if (this.mHasCallFinish) {
            return;
        }
        this.mHasCallFinish = true;
        super.finish();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        Intent intent = super.getIntent();
        s.c(intent);
        return intent;
    }

    public abstract int getLayoutId();

    public abstract String getPageName();

    public abstract void initData();

    public abstract void initView();

    public boolean needAdaptionScreen() {
        return false;
    }

    public void onActivityCreate() {
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.mBackPressDelete.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
        } catch (Throwable th) {
            onCreateCaughtException(th);
            this.mPageMonitor.a(PageCreateStage.ERROR_CAUGHT_EXCEPTION);
            if (!com.kwad.sdk.l.DP().CT()) {
                throw th;
            }
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
            finish();
        }
        if (!com.kwad.sdk.l.DP().CW()) {
            this.mPageMonitor.a(PageCreateStage.ERROR_SDK_NOT_INIT);
            finish();
            return;
        }
        this.mPageMonitor.a(PageCreateStage.START_ON_CREATE);
        super.onCreate(bundle);
        int onSetActivityTheme = onSetActivityTheme();
        if (onSetActivityTheme > 0) {
            getActivity().setTheme(onSetActivityTheme);
        }
        this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(getActivity());
        Intent intent = getIntent();
        this.mPageMonitor.a(PageCreateStage.START_CHECK_INTENT);
        if (!checkIntentData(intent)) {
            this.mPageMonitor.a(PageCreateStage.ERROR_CHECK_INTENT);
            finish();
            return;
        }
        getWindow().setFlags(16777216, 16777216);
        long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
        this.mPageMonitor.aO(getPageName());
        this.mPageMonitor.L(longExtra);
        int layoutId = getLayoutId();
        this.mPageMonitor.a(PageCreateStage.START_SET_CONTENT_VIEW);
        if (layoutId != 0) {
            setContentView(layoutId);
        }
        this.mPageMonitor.a(PageCreateStage.START_INIT_DATA);
        initData();
        this.mPageMonitor.a(PageCreateStage.START_INIT_VIEW);
        initView();
        this.mPageMonitor.a(PageCreateStage.END_INIT_VIEW);
        l.tq().a(this, bundle);
        onActivityCreate();
        this.mPageMonitor.a(PageCreateStage.END_ON_CREATE);
    }

    public void onCreateCaughtException(Throwable th) {
    }

    public void onCreateStageChange(PageCreateStage pageCreateStage) {
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            l.tq().g(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        try {
            super.onPause();
            l.tq().f(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(Bundle bundle) {
        try {
            this.mPageMonitor.a(PageCreateStage.START_ON_PRE_CREATE);
            super.onPreCreate(bundle);
            try {
                if (!com.kwad.sdk.l.DP().CT() && needAdaptionScreen() && Build.VERSION.SDK_INT <= 27) {
                    com.kwad.components.core.s.d.a(getActivity(), 0, true, false);
                }
            } catch (Throwable th) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
            }
            disableFragmentRestore(bundle);
            this.mPageMonitor.a(PageCreateStage.END_ON_PRE_CREATE);
        } catch (Throwable th2) {
            this.mPageMonitor.a(PageCreateStage.ERROR_START_ACTIVITY);
            ServiceProvider.reportSdkCaughtException(new KSAdPreCreateException("ksad_pre_create_exception", th2));
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.core.proxy.a.a aVar = this.mPageMonitor;
            getActivity();
            aVar.ty();
            l.tq().e(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        disableFragmentRestore(bundle);
    }

    public int onSetActivityTheme() {
        return R.style.Theme.Light.NoTitleBar.Fullscreen;
    }

    public void removeBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i) {
        try {
            View inflate = com.kwad.sdk.o.m.inflate(this.mContext, i, null);
            this.mRootView = inflate;
            super.setContentView(inflate);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public void addBackPressable(com.kwad.sdk.m.a.b bVar, int i) {
        this.mBackPressDelete.addBackPressable(bVar, i);
    }
}
