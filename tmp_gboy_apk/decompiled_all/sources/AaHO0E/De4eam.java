package AaHO0E;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class De4eam {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final RectF f742AcNBzu = new RectF();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final ConcurrentHashMap f743AlLFFp = new ConcurrentHashMap();

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f744A2egSU = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f745A4TApA = false;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public float f746A5SV6n = -1.0f;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public float f747ADYaiT = -1.0f;
    public float AMqCpz = -1.0f;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int[] f748ARc23Z = new int[0];

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f749ASJ6gh = false;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public TextPaint f750AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final TextView f751AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final Context f752AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final Ddcejp f753AaHO0E;

    static {
        czen();
    }

    public De4eam(TextView textView) {
        this.f751AZOQYO = textView;
        this.f752AZkASS = textView.getContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            this.f753AaHO0E = new DdagTj();
        } else if (i >= 23) {
            this.f753AaHO0E = new DaOi9o();
        } else {
            this.f753AaHO0E = new Ddcejp();
        }
    }

    public static int[] A4TApA(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i : iArr) {
                if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public static Method ADYaiT(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f743AlLFFp;
            Method method = (Method) concurrentHashMap.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                concurrentHashMap.put(str, method);
            }
            return method;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object AMqCpz(Object obj, String str, Object obj2) {
        try {
            return ADYaiT(str).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return obj2;
        }
    }

    private static /* synthetic */ void czen() {
        char[] charArray = "ÕÙÛ\u0098Ñ×ÛÓ\u0098ÔÙÏ\u0098ÅÞÓÚÚ\u0098üØßôÄßÒÑÓ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 182);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÕÚßØßÂ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 182);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU() {
        if (ARc23Z()) {
            if (this.f745A4TApA) {
                if (this.f751AZOQYO.getMeasuredHeight() <= 0 || this.f751AZOQYO.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f753AaHO0E.A4TApA(this.f751AZOQYO) ? 1048576 : (this.f751AZOQYO.getMeasuredWidth() - this.f751AZOQYO.getTotalPaddingLeft()) - this.f751AZOQYO.getTotalPaddingRight();
                int height = (this.f751AZOQYO.getHeight() - this.f751AZOQYO.getCompoundPaddingBottom()) - this.f751AZOQYO.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f742AcNBzu;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float A5SV6n2 = A5SV6n(rectF);
                        if (A5SV6n2 != this.f751AZOQYO.getTextSize()) {
                            ASJ6gh(A5SV6n2, 0);
                        }
                    } finally {
                    }
                }
            }
            this.f745A4TApA = true;
        }
    }

    public final int A5SV6n(RectF rectF) {
        int i;
        CharSequence charSequence;
        StaticLayout staticLayout;
        CharSequence transformation;
        int length = this.f748ARc23Z.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = length - 1;
        int i3 = 1;
        int i4 = 0;
        while (i3 <= i2) {
            int i5 = (i3 + i2) / 2;
            int i6 = this.f748ARc23Z[i5];
            TextView textView = this.f751AZOQYO;
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            CharSequence charSequence2 = (transformationMethod == null || (transformation = transformationMethod.getTransformation(text, textView)) == null) ? text : transformation;
            int maxLines = textView.getMaxLines();
            TextPaint textPaint = this.f750AYUAbz;
            if (textPaint == null) {
                this.f750AYUAbz = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.f750AYUAbz.set(textView.getPaint());
            this.f750AYUAbz.setTextSize(i6);
            Layout.Alignment alignment = (Layout.Alignment) AMqCpz(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
            int round = Math.round(rectF.right);
            if (Build.VERSION.SDK_INT >= 23) {
                staticLayout = DXuj49.A2egSU(charSequence2, alignment, round, maxLines, this.f751AZOQYO, this.f750AYUAbz, this.f753AaHO0E);
                i = maxLines;
                charSequence = charSequence2;
            } else {
                i = maxLines;
                charSequence = charSequence2;
                staticLayout = new StaticLayout(charSequence, this.f750AYUAbz, round, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
            }
            if ((i == -1 || (staticLayout.getLineCount() <= i && staticLayout.getLineEnd(staticLayout.getLineCount() - 1) == charSequence.length())) && staticLayout.getHeight() <= rectF.bottom) {
                int i7 = i5 + 1;
                i4 = i3;
                i3 = i7;
            } else {
                i4 = i5 - 1;
                i2 = i4;
            }
        }
        return this.f748ARc23Z[i4];
    }

    public final boolean ARc23Z() {
        return AZkASS() && this.f744A2egSU != 0;
    }

    public final void ASJ6gh(float f, int i) {
        Context context = this.f752AZkASS;
        float applyDimension = TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.f751AZOQYO;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean isInLayout = textView.isInLayout();
            if (textView.getLayout() != null) {
                this.f745A4TApA = false;
                try {
                    Method ADYaiT2 = ADYaiT("nullLayouts");
                    if (ADYaiT2 != null) {
                        ADYaiT2.invoke(textView, new Object[0]);
                    }
                } catch (Exception unused) {
                }
                if (isInLayout) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean AYUAbz() {
        if (AZkASS() && this.f744A2egSU == 1) {
            if (!this.f749ASJ6gh || this.f748ARc23Z.length == 0) {
                int floor = ((int) Math.floor((this.AMqCpz - this.f747ADYaiT) / this.f746A5SV6n)) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round((i * this.f746A5SV6n) + this.f747ADYaiT);
                }
                this.f748ARc23Z = A4TApA(iArr);
            }
            this.f745A4TApA = true;
        } else {
            this.f745A4TApA = false;
        }
        return this.f745A4TApA;
    }

    public final boolean AZOQYO() {
        boolean z = this.f748ARc23Z.length > 0;
        this.f749ASJ6gh = z;
        if (z) {
            this.f744A2egSU = 1;
            this.f747ADYaiT = r0[0];
            this.AMqCpz = r0[r1 - 1];
            this.f746A5SV6n = -1.0f;
        }
        return z;
    }

    public final boolean AZkASS() {
        return !(this.f751AZOQYO instanceof AppCompatEditText);
    }

    public final void AaHO0E(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.f744A2egSU = 1;
        this.f747ADYaiT = f;
        this.AMqCpz = f2;
        this.f746A5SV6n = f3;
        this.f749ASJ6gh = false;
    }
}
