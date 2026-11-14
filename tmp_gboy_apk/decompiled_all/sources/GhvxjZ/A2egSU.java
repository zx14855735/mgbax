package GhvxjZ;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3074AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ A4TApA f3075AlLFFp;

    public /* synthetic */ A2egSU(A4TApA a4TApA, int i) {
        this.f3074AcNBzu = i;
        this.f3075AlLFFp = a4TApA;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3074AcNBzu) {
            case 0:
                A4TApA a4TApA = this.f3075AlLFFp;
                View.OnClickListener onClickListener = a4TApA.f3082B3GDIM;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                a4TApA.dismiss();
                break;
            default:
                A4TApA a4TApA2 = this.f3075AlLFFp;
                View.OnClickListener onClickListener2 = a4TApA2.f3081B2KMhB;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
                a4TApA2.dismiss();
                break;
        }
    }
}
