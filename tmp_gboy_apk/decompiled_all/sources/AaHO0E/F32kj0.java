package AaHO0E;

import android.database.DataSetObserver;
import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class F32kj0 extends DataSetObserver {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f813A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f814A4TApA;

    public /* synthetic */ F32kj0(int i, Object obj) {
        this.f813A2egSU = i;
        this.f814A4TApA = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f813A2egSU) {
            case 0:
                FM663C fm663c = (FM663C) this.f814A4TApA;
                if (fm663c.f845COJEAR.isShowing()) {
                    fm663c.show();
                    break;
                }
                break;
            default:
                ((TabLayout) this.f814A4TApA).AaHO0E();
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f813A2egSU) {
            case 0:
                ((FM663C) this.f814A4TApA).dismiss();
                break;
            default:
                ((TabLayout) this.f814A4TApA).AaHO0E();
                break;
        }
    }
}
