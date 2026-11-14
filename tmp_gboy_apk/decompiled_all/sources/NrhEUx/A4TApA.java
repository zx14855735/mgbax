package NrhEUx;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends com.bumptech.glide.A5SV6n {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final /* synthetic */ int f6129B4ZgIw;

    @Override // com.bumptech.glide.A5SV6n
    public final int C4FrIb(View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f6129B4ZgIw) {
            case 0:
                return view.getMeasuredHeight() + marginLayoutParams.bottomMargin;
            case 1:
                return view.getMeasuredWidth() + marginLayoutParams.leftMargin;
            default:
                return view.getMeasuredWidth() + marginLayoutParams.rightMargin;
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final int CASmeH() {
        switch (this.f6129B4ZgIw) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                return 0;
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final ViewPropertyAnimator CNPG0E(int i, View view) {
        switch (this.f6129B4ZgIw) {
            case 0:
                return view.animate().translationY(i);
            case 1:
                return view.animate().translationX(-i);
            default:
                return view.animate().translationX(i);
        }
    }
}
