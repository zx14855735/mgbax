package com.baidu.mobads.sdk.internal;

import android.app.Fragment;
import com.baidu.mobads.sdk.api.CPUComponent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class da extends com.baidu.mobads.sdk.internal.a.e implements CPUComponent {

    /* renamed from: a, reason: collision with root package name */
    private final db f9812a;
    private Fragment b;
    private androidx.fragment.app.Fragment c;

    public da(db dbVar) {
        this.f9812a = dbVar;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void destroy() {
        db dbVar = this.f9812a;
        if (dbVar != null) {
            dbVar.e();
        }
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public Fragment getFragment() {
        Fragment fragment = this.b;
        if (fragment != null) {
            if (fragment instanceof FragmentDelegate) {
                ((FragmentDelegate) fragment).setProxy(this);
            }
            return this.b;
        }
        db dbVar = this.f9812a;
        if (dbVar == null) {
            return null;
        }
        Fragment a2 = dbVar.a((com.baidu.mobads.sdk.internal.a.e) this);
        this.b = a2;
        return a2;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public androidx.fragment.app.Fragment getSupportFragment() {
        androidx.fragment.app.Fragment fragment = this.c;
        if (fragment != null) {
            if (fragment instanceof FragmentV4Delegate) {
                ((FragmentV4Delegate) fragment).setProxy(this);
            }
            return this.c;
        }
        db dbVar = this.f9812a;
        if (dbVar == null) {
            return null;
        }
        androidx.fragment.app.Fragment b = dbVar.b((com.baidu.mobads.sdk.internal.a.e) this);
        this.c = b;
        return b;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void refresh() {
        db dbVar = this.f9812a;
        if (dbVar != null) {
            dbVar.f();
        }
    }
}
