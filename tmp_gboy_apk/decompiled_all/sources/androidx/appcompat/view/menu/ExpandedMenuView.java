package androidx.appcompat.view.menu;

import AZkASS.AlLFFp;
import AZkASS.AmA8tU;
import AZkASS.B25kr6;
import AZkASS.BTvldC;
import AaHO0E.GYpKKt;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ExpandedMenuView extends ListView implements AlLFFp, BTvldC, AdapterView.OnItemClickListener {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final int[] f8058AlLFFp = {R.attr.background, R.attr.divider};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AmA8tU f8059AcNBzu;

    static {
        vnGKPc();
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        GYpKKt ARc23Z2 = GYpKKt.ARc23Z(context, attributeSet, f8058AlLFFp, R.attr.listViewStyle);
        TypedArray typedArray = ARc23Z2.f884A4TApA;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(ARc23Z2.A4TApA(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(ARc23Z2.A4TApA(1));
        }
        ARc23Z2.ASJ6gh();
    }

    private static /* synthetic */ void vnGKPc() {
        char[] charArray = "KGE\u0006OIEM\u0006JGQ\u0006[@MDD\u0006bFAjZALOM".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '(');
        }
        String str = new String(charArray);
        char[] charArray2 = "KDAFA\\".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '(');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // AZkASS.AlLFFp
    public final boolean A4TApA(B25kr6 b25kr6) {
        return this.f8059AcNBzu.B2KMhB(b25kr6, null, 0);
    }

    @Override // AZkASS.BTvldC
    public final void A5SV6n(AmA8tU amA8tU) {
        this.f8059AcNBzu = amA8tU;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        A4TApA((B25kr6) getAdapter().getItem(i));
    }
}
