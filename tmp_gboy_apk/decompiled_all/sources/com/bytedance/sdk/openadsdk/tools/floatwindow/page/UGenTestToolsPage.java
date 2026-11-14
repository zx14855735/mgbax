package com.bytedance.sdk.openadsdk.tools.floatwindow.page;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class UGenTestToolsPage extends BaseToolPage {
    private boolean xj;

    @Override // com.bytedance.sdk.openadsdk.tools.floatwindow.page.BaseToolPage
    public String getPageTitle() {
        return "UGen调试";
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.xj = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.xj = false;
    }
}
