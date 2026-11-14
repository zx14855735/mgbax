package AaHO0E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class FpcJKS {

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static FpcJKS f854AZOQYO;

    /* renamed from: A2egSU, reason: collision with root package name */
    public WeakHashMap f856A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public B25kr6.AzWtSf f857A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public B25kr6.B25kr6 f858A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final WeakHashMap f859ADYaiT = new WeakHashMap(0);
    public TypedValue AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f860ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public BJ7GGh f861ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final PorterDuff.Mode f853AYUAbz = PorterDuff.Mode.SRC_IN;

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final Fmmv0E f855AZkASS = new Fmmv0E(6);

    static {
        GeSKjJr();
    }

    public static synchronized FpcJKS ADYaiT() {
        FpcJKS fpcJKS;
        synchronized (FpcJKS.class) {
            try {
                if (f854AZOQYO == null) {
                    FpcJKS fpcJKS2 = new FpcJKS();
                    f854AZOQYO = fpcJKS2;
                    AZkASS(fpcJKS2);
                }
                fpcJKS = f854AZOQYO;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fpcJKS;
    }

    public static synchronized PorterDuffColorFilter AYUAbz(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (FpcJKS.class) {
            Fmmv0E fmmv0E = f855AZkASS;
            fmmv0E.getClass();
            int i2 = (31 + i) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) fmmv0E.A2egSU(Integer.valueOf(mode.hashCode() + i2));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
            }
        }
        return porterDuffColorFilter;
    }

    public static void AZkASS(FpcJKS fpcJKS) {
        if (Build.VERSION.SDK_INT < 24) {
            fpcJKS.A2egSU("vector", new FmyuN2(3));
            fpcJKS.A2egSU("animated-vector", new FmyuN2(2));
            fpcJKS.A2egSU("animated-selector", new FmyuN2(1));
            fpcJKS.A2egSU("drawable", new FmyuN2(0));
        }
    }

    private static /* synthetic */ void GeSKjJr() {
        char[] charArray = "·»¹ú³µ¹±ú¶»\u00adú§¼±¸¸ú\u009eº½\u0096¦½°³±".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 212);
        }
        String str = new String(charArray);
        char[] charArray2 = "·¸½º½ ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 212);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(String str, FmyuN2 fmyuN2) {
        if (this.f857A4TApA == null) {
            this.f857A4TApA = new B25kr6.AzWtSf();
        }
        this.f857A4TApA.put(str, fmyuN2);
    }

    public final synchronized void A4TApA(Context context, long j, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                B25kr6.AYUAbz aYUAbz = (B25kr6.AYUAbz) this.f859ADYaiT.get(context);
                if (aYUAbz == null) {
                    aYUAbz = new B25kr6.AYUAbz();
                    this.f859ADYaiT.put(context, aYUAbz);
                }
                aYUAbz.AYUAbz(j, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable A5SV6n(Context context, int i) {
        if (this.AMqCpz == null) {
            this.AMqCpz = new TypedValue();
        }
        TypedValue typedValue = this.AMqCpz;
        context.getResources().getValue(i, typedValue, true);
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable AMqCpz = AMqCpz(context, j);
        if (AMqCpz != null) {
            return AMqCpz;
        }
        LayerDrawable layerDrawable = null;
        if (this.f861ASJ6gh != null) {
            if (i == 2131230780) {
                layerDrawable = new LayerDrawable(new Drawable[]{ARc23Z(context, 2131230779), ARc23Z(context, 2131230781)});
            } else if (i == 2131230815) {
                layerDrawable = BJ7GGh.A5SV6n(this, context, 2131165243);
            } else if (i == 2131230814) {
                layerDrawable = BJ7GGh.A5SV6n(this, context, 2131165244);
            } else if (i == 2131230816) {
                layerDrawable = BJ7GGh.A5SV6n(this, context, 2131165245);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            A4TApA(context, j, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable AMqCpz(Context context, long j) {
        B25kr6.AYUAbz aYUAbz = (B25kr6.AYUAbz) this.f859ADYaiT.get(context);
        if (aYUAbz == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) aYUAbz.ADYaiT(j);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            aYUAbz.AZOQYO(j);
        }
        return null;
    }

    public final synchronized Drawable ARc23Z(Context context, int i) {
        return ASJ6gh(context, i, false);
    }

    public final synchronized Drawable ASJ6gh(Context context, int i, boolean z) {
        Drawable AaHO0E2;
        try {
            if (!this.f860ARc23Z) {
                this.f860ARc23Z = true;
                Drawable ARc23Z2 = ARc23Z(context, 2131230842);
                if (ARc23Z2 == null || (!(ARc23Z2 instanceof DcUJf1.B3GDIM) && !"android.graphics.drawable.VectorDrawable".equals(ARc23Z2.getClass().getName()))) {
                    this.f860ARc23Z = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            AaHO0E2 = AaHO0E(context, i);
            if (AaHO0E2 == null) {
                AaHO0E2 = A5SV6n(context, i);
            }
            if (AaHO0E2 == null) {
                AaHO0E2 = BPw6Q8.A2egSU.A4TApA(context, i);
            }
            if (AaHO0E2 != null) {
                AaHO0E2 = AmA8tU(context, i, z, AaHO0E2);
            }
            if (AaHO0E2 != null) {
                EGM26s.A2egSU(AaHO0E2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return AaHO0E2;
    }

    public final synchronized ColorStateList AZOQYO(Context context, int i) {
        ColorStateList colorStateList;
        B25kr6.B25kr6 b25kr6;
        WeakHashMap weakHashMap = this.f856A2egSU;
        ColorStateList colorStateList2 = null;
        colorStateList = (weakHashMap == null || (b25kr6 = (B25kr6.B25kr6) weakHashMap.get(context)) == null) ? null : (ColorStateList) b25kr6.A5SV6n(i);
        if (colorStateList == null) {
            BJ7GGh bJ7GGh = this.f861ASJ6gh;
            if (bJ7GGh != null) {
                colorStateList2 = bJ7GGh.ADYaiT(context, i);
            }
            if (colorStateList2 != null) {
                if (this.f856A2egSU == null) {
                    this.f856A2egSU = new WeakHashMap();
                }
                B25kr6.B25kr6 b25kr62 = (B25kr6.B25kr6) this.f856A2egSU.get(context);
                if (b25kr62 == null) {
                    b25kr62 = new B25kr6.B25kr6();
                    this.f856A2egSU.put(context, b25kr62);
                }
                b25kr62.A2egSU(i, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    public final Drawable AaHO0E(Context context, int i) {
        int next;
        B25kr6.AzWtSf azWtSf = this.f857A4TApA;
        if (azWtSf == null || azWtSf.isEmpty()) {
            return null;
        }
        B25kr6.B25kr6 b25kr6 = this.f858A5SV6n;
        if (b25kr6 != null) {
            String str = (String) b25kr6.A5SV6n(i);
            if ("appcompat_skip_skip".equals(str)) {
                return null;
            }
            if (str != null && this.f857A4TApA.get(str) == null) {
                return null;
            }
        } else {
            this.f858A5SV6n = new B25kr6.B25kr6();
        }
        if (this.AMqCpz == null) {
            this.AMqCpz = new TypedValue();
        }
        TypedValue typedValue = this.AMqCpz;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable AMqCpz = AMqCpz(context, j);
        if (AMqCpz != null) {
            return AMqCpz;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f858A5SV6n.A2egSU(i, name);
                FmyuN2 fmyuN2 = (FmyuN2) this.f857A4TApA.get(name);
                if (fmyuN2 != null) {
                    AMqCpz = fmyuN2.A2egSU(context, xml, asAttributeSet, context.getTheme());
                }
                if (AMqCpz != null) {
                    AMqCpz.setChangingConfigurations(typedValue.changingConfigurations);
                    A4TApA(context, j, AMqCpz);
                }
            } catch (Exception unused) {
            }
        }
        if (AMqCpz == null) {
            this.f858A5SV6n.A2egSU(i, "appcompat_skip_skip");
        }
        return AMqCpz;
    }

    public final synchronized void AcNBzu(Context context) {
        B25kr6.AYUAbz aYUAbz = (B25kr6.AYUAbz) this.f859ADYaiT.get(context);
        if (aYUAbz != null) {
            aYUAbz.A4TApA();
        }
    }

    public final synchronized void AlLFFp(BJ7GGh bJ7GGh) {
        this.f861ASJ6gh = bJ7GGh;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable AmA8tU(android.content.Context r8, int r9, boolean r10, android.graphics.drawable.Drawable r11) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: AaHO0E.FpcJKS.AmA8tU(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
