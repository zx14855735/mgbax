package PWIgQJ;

import OLy1FW.AzWtSf;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends AzWtSf {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f7280AlLFFp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A2egSU(int i) {
        super(6, (byte) 0);
        this.f7280AlLFFp = i;
    }

    @Override // OLy1FW.AzWtSf
    public final void ARc23Z(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float sin;
        float cos;
        switch (this.f7280AlLFFp) {
            case 0:
                RectF A5SV6n2 = AzWtSf.A5SV6n(tabLayout, view);
                RectF A5SV6n3 = AzWtSf.A5SV6n(tabLayout, view2);
                if (A5SV6n2.left < A5SV6n3.left) {
                    double d = (f * 3.141592653589793d) / 2.0d;
                    sin = (float) (1.0d - Math.cos(d));
                    cos = (float) Math.sin(d);
                } else {
                    double d2 = (f * 3.141592653589793d) / 2.0d;
                    sin = (float) Math.sin(d2);
                    cos = (float) (1.0d - Math.cos(d2));
                }
                drawable.setBounds(NdEzCJ.A2egSU.A5SV6n(sin, (int) A5SV6n2.left, (int) A5SV6n3.left), drawable.getBounds().top, NdEzCJ.A2egSU.A5SV6n(cos, (int) A5SV6n2.right, (int) A5SV6n3.right), drawable.getBounds().bottom);
                break;
            default:
                if (f >= 0.5f) {
                    view = view2;
                }
                RectF A5SV6n4 = AzWtSf.A5SV6n(tabLayout, view);
                float A4TApA2 = f < 0.5f ? NdEzCJ.A2egSU.A4TApA(1.0f, 0.0f, 0.0f, 0.5f, f) : NdEzCJ.A2egSU.A4TApA(0.0f, 1.0f, 0.5f, 1.0f, f);
                drawable.setBounds((int) A5SV6n4.left, drawable.getBounds().top, (int) A5SV6n4.right, drawable.getBounds().bottom);
                drawable.setAlpha((int) (A4TApA2 * 255.0f));
                break;
        }
    }
}
