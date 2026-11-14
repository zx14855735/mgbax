package Mm8v1u;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BChYOn extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ViewPager2 f5512AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public TextView f5513AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ImageView f5514AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public LinearLayout f5515AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public List f5516B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f5517B2KMhB;

    public static void A2egSU(BChYOn bChYOn) {
        if (bChYOn.f5515AzWtSf.getVisibility() == 0) {
            bChYOn.f5515AzWtSf.animate().alpha(0.0f).setDuration(200L).withEndAction(new B2KMhB(bChYOn, 1)).start();
            return;
        }
        bChYOn.f5515AzWtSf.setAlpha(0.0f);
        bChYOn.f5515AzWtSf.setVisibility(0);
        bChYOn.f5515AzWtSf.animate().alpha(1.0f).setDuration(200L).start();
    }

    public final void A4TApA() {
        List list = this.f5516B25kr6;
        if (list == null || list.size() <= 1) {
            this.f5513AlLFFp.setVisibility(8);
            return;
        }
        TextView textView = this.f5513AlLFFp;
        Locale locale = Locale.ROOT;
        textView.setText((this.f5517B2KMhB + 1) + "/" + this.f5516B25kr6.size());
        this.f5513AlLFFp.setVisibility(0);
    }
}
