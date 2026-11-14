package Oay4Bh;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BV3sI0 {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final int f6583AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static boolean f6584AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static Constructor f6585B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static TextDirectionHeuristic f6586B2KMhB;

    /* renamed from: A2egSU, reason: collision with root package name */
    public CharSequence f6587A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final TextPaint f6588A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f6589A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f6590ADYaiT;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public boolean f6596AaHO0E;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Cd8JRx.ADYaiT f6598AlLFFp;
    public Layout.Alignment AMqCpz = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f6591ARc23Z = Integer.MAX_VALUE;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f6592ASJ6gh = 0.0f;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f6593AYUAbz = 1.0f;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f6594AZOQYO = f6583AmA8tU;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f6595AZkASS = true;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public TextUtils.TruncateAt f6597AcNBzu = null;

    static {
        f6583AmA8tU = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
        VUtkXe();
    }

    public BV3sI0(CharSequence charSequence, TextPaint textPaint, int i) {
        this.f6587A2egSU = charSequence;
        this.f6588A4TApA = textPaint;
        this.f6589A5SV6n = i;
        this.f6590ADYaiT = charSequence.length();
    }

    private static /* synthetic */ void VUtkXe() {
        char[] charArray = "=13p9?3;p<1'p-6;22p\u001407\u001c,7:9;".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '^');
        }
        String str = new String(charArray);
        char[] charArray2 = "=2707*".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '^');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final StaticLayout A2egSU() {
        char c;
        StaticLayout.Builder obtain;
        StaticLayout build;
        int breakStrategy;
        if (this.f6587A2egSU == null) {
            this.f6587A2egSU = "";
        }
        int max = Math.max(0, this.f6589A5SV6n);
        CharSequence charSequence = this.f6587A2egSU;
        int i = this.f6591ARc23Z;
        TextPaint textPaint = this.f6588A4TApA;
        if (i == 1) {
            c = '\t';
            charSequence = TextUtils.ellipsize(charSequence, textPaint, max, this.f6597AcNBzu);
        } else {
            c = '\t';
        }
        int min = Math.min(charSequence.length(), this.f6590ADYaiT);
        this.f6590ADYaiT = min;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            if (this.f6596AaHO0E && this.f6591ARc23Z == 1) {
                this.AMqCpz = Layout.Alignment.ALIGN_OPPOSITE;
            }
            obtain = StaticLayout.Builder.obtain(charSequence, 0, min, textPaint, max);
            obtain.setAlignment(this.AMqCpz);
            obtain.setIncludePad(this.f6595AZkASS);
            obtain.setTextDirection(this.f6596AaHO0E ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f6597AcNBzu;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f6591ARc23Z);
            float f = this.f6592ASJ6gh;
            if (f != 0.0f || this.f6593AYUAbz != 1.0f) {
                obtain.setLineSpacing(f, this.f6593AYUAbz);
            }
            if (this.f6591ARc23Z > 1) {
                obtain.setHyphenationFrequency(this.f6594AZOQYO);
            }
            Cd8JRx.ADYaiT aDYaiT = this.f6598AlLFFp;
            if (aDYaiT != null) {
                TextInputLayout textInputLayout = (TextInputLayout) aDYaiT.f1779AlLFFp;
                if (i2 >= 23) {
                    breakStrategy = textInputLayout.BpkvW3.getBreakStrategy();
                    obtain.setBreakStrategy(breakStrategy);
                } else {
                    int[][] iArr = TextInputLayout.f11906F32kj0;
                }
            }
            build = obtain.build();
            return build;
        }
        if (!f6584AzWtSf) {
            try {
                f6586B2KMhB = this.f6596AaHO0E && i2 >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class[] clsArr = new Class[13];
                clsArr[0] = CharSequence.class;
                Class cls = Integer.TYPE;
                clsArr[1] = cls;
                clsArr[2] = cls;
                clsArr[3] = TextPaint.class;
                clsArr[4] = cls;
                clsArr[5] = Layout.Alignment.class;
                clsArr[6] = TextDirectionHeuristic.class;
                Class cls2 = Float.TYPE;
                clsArr[7] = cls2;
                clsArr[8] = cls2;
                clsArr[c] = Boolean.TYPE;
                clsArr[10] = TextUtils.TruncateAt.class;
                clsArr[11] = cls;
                clsArr[12] = cls;
                Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(clsArr);
                f6585B25kr6 = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f6584AzWtSf = true;
            } catch (Exception e) {
                throw new BTvldC(e);
            }
        }
        try {
            Constructor constructor = f6585B25kr6;
            constructor.getClass();
            Integer valueOf = Integer.valueOf(this.f6590ADYaiT);
            Integer valueOf2 = Integer.valueOf(max);
            Layout.Alignment alignment = this.AMqCpz;
            TextDirectionHeuristic textDirectionHeuristic = f6586B2KMhB;
            textDirectionHeuristic.getClass();
            Float valueOf3 = Float.valueOf(1.0f);
            Float valueOf4 = Float.valueOf(0.0f);
            Boolean valueOf5 = Boolean.valueOf(this.f6595AZkASS);
            Integer valueOf6 = Integer.valueOf(max);
            Integer valueOf7 = Integer.valueOf(this.f6591ARc23Z);
            Object[] objArr = new Object[13];
            objArr[0] = charSequence;
            objArr[1] = 0;
            objArr[2] = valueOf;
            objArr[3] = textPaint;
            objArr[4] = valueOf2;
            objArr[5] = alignment;
            objArr[6] = textDirectionHeuristic;
            objArr[7] = valueOf3;
            objArr[8] = valueOf4;
            objArr[c] = valueOf5;
            objArr[10] = null;
            objArr[11] = valueOf6;
            objArr[12] = valueOf7;
            return (StaticLayout) constructor.newInstance(objArr);
        } catch (Exception e2) {
            throw new BTvldC(e2);
        }
    }
}
