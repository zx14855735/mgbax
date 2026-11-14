package MS6BTZ;

import DRlcZ9.BChYOn;
import DRlcZ9.BV3sI0;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu extends BChYOn {
    public static void ARc23Z(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.leftMargin == i && marginLayoutParams.rightMargin == i && marginLayoutParams.bottomMargin == i2) {
                return;
            }
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.rightMargin = i;
            marginLayoutParams.bottomMargin = i2;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static RippleDrawable ASJ6gh(int i, Context context, boolean z, boolean z2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(new ColorStateList(new int[][]{new int[]{R.attr.state_focused}, new int[0]}, new int[]{AYUAbz(context, -1646359, "colorSurfaceContainerHighest"), AYUAbz(context, -1118482, "colorSurfaceContainerLow")}));
        float f = i;
        float f2 = z ? f : 0.0f;
        float f3 = z ? f : 0.0f;
        float f4 = z ? f : 0.0f;
        float f5 = z ? f : 0.0f;
        float f6 = z2 ? f : 0.0f;
        float f7 = z2 ? f : 0.0f;
        float f8 = z2 ? f : 0.0f;
        if (!z2) {
            f = 0.0f;
        }
        gradientDrawable.setCornerRadii(new float[]{f2, f3, f4, f5, f6, f7, f8, f});
        gradientDrawable.setStroke((int) (context.getResources().getDisplayMetrics().density * 2.0f), new ColorStateList(new int[][]{new int[]{R.attr.state_focused}, new int[0]}, new int[]{AYUAbz(context, -10006364, "colorPrimary"), 0}));
        return new RippleDrawable(ColorStateList.valueOf((AYUAbz(context, -10006364, "colorPrimary") & 16777215) | 520093696), gradientDrawable, null);
    }

    public static int AYUAbz(Context context, int i, String str) {
        try {
            int identifier = context.getResources().getIdentifier(str, "attr", context.getPackageName());
            if (identifier == 0) {
                identifier = context.getResources().getIdentifier(str, "attr", "com.google.android.material");
            }
            if (identifier != 0) {
                TypedValue typedValue = new TypedValue();
                if (context.getTheme().resolveAttribute(identifier, typedValue, true)) {
                    return typedValue.type == 1 ? context.getResources().getColor(typedValue.resourceId) : typedValue.data;
                }
            }
        } catch (Exception unused) {
        }
        return i;
    }

    @Override // DRlcZ9.BChYOn, androidx.recyclerview.widget.RecyclerView.A2egSU
    /* renamed from: ADYaiT */
    public final void onBindViewHolder(BV3sI0 bV3sI0, int i) {
        super.onBindViewHolder(bV3sI0, i);
        Preference A5SV6n2 = A5SV6n(i);
        if (A5SV6n2 == null) {
            return;
        }
        View view = bV3sI0.itemView;
        Context context = view.getContext();
        float f = context.getResources().getDisplayMetrics().density;
        int i2 = (int) (16.0f * f);
        int i3 = (int) (1.0f * f);
        int i4 = (int) (f * 24.0f);
        if (A5SV6n2 instanceof PreferenceCategory) {
            view.setBackground(null);
            view.setFocusable(false);
            view.setClickable(false);
            ARc23Z(view, i2, 0);
            return;
        }
        view.setFocusable(true);
        view.setFocusableInTouchMode(false);
        PreferenceGroup preferenceGroup = A5SV6n2.f9111CrfGsy;
        if (!(preferenceGroup instanceof PreferenceCategory)) {
            view.setBackground(ASJ6gh(i4, context, true, true));
            ARc23Z(view, i2, i3);
            return;
        }
        int size = preferenceGroup.f9117D8MqeW.size();
        int i5 = 0;
        while (true) {
            if (i5 >= preferenceGroup.f9117D8MqeW.size()) {
                i5 = -1;
                break;
            } else if (preferenceGroup.BpkvW3(i5) == A5SV6n2) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 < 0) {
            return;
        }
        boolean z = i5 == 0;
        boolean z2 = i5 == size - 1;
        view.setBackground(ASJ6gh(i4, context, z, z2));
        if (z2) {
            i3 = 0;
        }
        ARc23Z(view, i2, i3);
    }
}
