package LLiCI0;

import androidx.recyclerview.widget.Dphsd2;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz extends Dphsd2 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ViewPager2 f4678AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f4679AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public A4TApA f4680AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AzWtSf f4681AzWtSf;

    public final void A2egSU(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty() || this.f4679AlLFFp) {
            return;
        }
        this.f4679AlLFFp = true;
        AzWtSf azWtSf = new AzWtSf(arrayList);
        this.f4681AzWtSf = azWtSf;
        ViewPager2 viewPager2 = this.f4678AcNBzu;
        viewPager2.setAdapter(azWtSf);
        viewPager2.setOffscreenPageLimit(Math.min(3, Math.max(1, arrayList.size())));
        int itemCount = this.f4681AzWtSf.getItemCount();
        viewPager2.A4TApA(itemCount > 1 ? itemCount / 2 : 0, false);
        boolean z = arrayList.size() > 1;
        if (z) {
            int i = (int) (viewPager2.getResources().getDisplayMetrics().density * 24.0f);
            viewPager2.setClipToPadding(false);
            viewPager2.setClipChildren(false);
            viewPager2.setPadding(i, 0, i, 0);
        } else {
            viewPager2.setClipToPadding(true);
            viewPager2.setClipChildren(true);
            viewPager2.setPadding(0, 0, 0, 0);
        }
        De4eam.A4TApA a4TApA = new De4eam.A4TApA();
        if (z) {
            De4eam.A5SV6n a5SV6n = new De4eam.A5SV6n((int) (viewPager2.getResources().getDisplayMetrics().density * 8.0f));
            ArrayList arrayList2 = a4TApA.f2402A2egSU;
            arrayList2.add(a5SV6n);
            arrayList2.add(new A5SV6n());
        }
        viewPager2.setPageTransformer(a4TApA);
        this.f4680AmA8tU = new A4TApA(viewPager2);
        viewPager2.f9587AmA8tU.f9569A2egSU.add(new ADYaiT(this));
        this.f4680AmA8tU.A2egSU();
    }
}
