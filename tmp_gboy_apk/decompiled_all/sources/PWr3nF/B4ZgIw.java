package PWr3nF;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B4ZgIw extends ArrayAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public ColorStateList f7385A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ColorStateList f7386A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ MaterialAutoCompleteTextView f7387A5SV6n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B4ZgIw(MaterialAutoCompleteTextView materialAutoCompleteTextView, Context context, int i, String[] strArr) {
        super(context, i, strArr);
        this.f7387A5SV6n = materialAutoCompleteTextView;
        A2egSU();
    }

    public final void A2egSU() {
        ColorStateList colorStateList;
        MaterialAutoCompleteTextView materialAutoCompleteTextView = this.f7387A5SV6n;
        ColorStateList colorStateList2 = materialAutoCompleteTextView.f11903BI9f7h;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f7386A4TApA = colorStateList;
        if (materialAutoCompleteTextView.f11902BChYOn != 0 && materialAutoCompleteTextView.f11903BI9f7h != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{BV3sI0.A2egSU.A5SV6n(materialAutoCompleteTextView.f11903BI9f7h.getColorForState(iArr3, 0), materialAutoCompleteTextView.f11902BChYOn), BV3sI0.A2egSU.A5SV6n(materialAutoCompleteTextView.f11903BI9f7h.getColorForState(iArr2, 0), materialAutoCompleteTextView.f11902BChYOn), materialAutoCompleteTextView.f11902BChYOn});
        }
        this.f7385A2egSU = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            MaterialAutoCompleteTextView materialAutoCompleteTextView = this.f7387A5SV6n;
            Drawable drawable = null;
            if (materialAutoCompleteTextView.getText().toString().contentEquals(textView.getText()) && materialAutoCompleteTextView.f11902BChYOn != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(materialAutoCompleteTextView.f11902BChYOn);
                if (this.f7386A4TApA != null) {
                    colorDrawable.setTintList(this.f7385A2egSU);
                    drawable = new RippleDrawable(this.f7386A4TApA, colorDrawable, null);
                } else {
                    drawable = colorDrawable;
                }
            }
            textView.setBackground(drawable);
        }
        return view2;
    }
}
