package De4eam;

import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp extends RecyclerView {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f2415AcNBzu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlLFFp(ViewPager2 viewPager2, Context context) {
        super(context, null);
        this.f2415AcNBzu = viewPager2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        this.f2415AcNBzu.f9604BniPrB.getClass();
        return super.getAccessibilityClassName();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        ViewPager2 viewPager2 = this.f2415AcNBzu;
        accessibilityEvent.setFromIndex(viewPager2.f9588AzWtSf);
        accessibilityEvent.setToIndex(viewPager2.f9588AzWtSf);
        accessibilityEvent.setSource(viewPager2.f9604BniPrB.f2413ADYaiT);
        accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2415AcNBzu.f9602BV3sI0 && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f2415AcNBzu.f9602BV3sI0 && super.onTouchEvent(motionEvent);
    }
}
