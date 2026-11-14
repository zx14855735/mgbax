package AaHO0E;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class FmyuN2 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f852A2egSU;

    public /* synthetic */ FmyuN2(int i) {
        this.f852A2egSU = i;
    }

    public final Drawable A2egSU(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        switch (this.f852A2egSU) {
            case 0:
                String classAttribute = attributeSet.getClassAttribute();
                if (classAttribute != null) {
                    try {
                        Drawable drawable = (Drawable) FmyuN2.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        ASJ6gh.A2egSU.A5SV6n(drawable, context.getResources(), xmlResourceParser, attributeSet, theme);
                        return drawable;
                    } catch (Exception unused) {
                    }
                }
                return null;
            case 1:
                try {
                    return ARc23Z.AMqCpz.ASJ6gh(context, context.getResources(), xmlResourceParser, attributeSet, theme);
                } catch (Exception unused2) {
                    return null;
                }
            case 2:
                try {
                    Resources resources = context.getResources();
                    DcUJf1.ARc23Z aRc23Z = new DcUJf1.ARc23Z(context);
                    aRc23Z.inflate(resources, xmlResourceParser, attributeSet, theme);
                    return aRc23Z;
                } catch (Exception unused3) {
                    return null;
                }
            default:
                try {
                    Resources resources2 = context.getResources();
                    DcUJf1.B3GDIM b3gdim = new DcUJf1.B3GDIM();
                    b3gdim.inflate(resources2, xmlResourceParser, attributeSet, theme);
                    return b3gdim;
                } catch (Exception unused4) {
                    return null;
                }
        }
    }
}
