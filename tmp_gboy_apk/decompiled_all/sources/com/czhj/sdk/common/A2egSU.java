package com.czhj.sdk.common;

import com.czhj.sdk.common.utils.RomUtils;
import com.fl.saas.base.adapter.AdapterManager;
import com.fl.saas.config.utils.DeviceUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10535AcNBzu;

    public /* synthetic */ A2egSU(int i) {
        this.f10535AcNBzu = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10535AcNBzu) {
            case 0:
                RomUtils.getRomInfo();
                break;
            case 1:
                DeviceUtil.lambda$loadUserAgent$3();
                break;
            case 2:
                DeviceUtil.loadUserAgent();
                break;
            default:
                AdapterManager.preInitAdapter();
                break;
        }
    }
}
