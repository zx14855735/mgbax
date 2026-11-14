package PCV8se;

import PCV8se.B2KMhB;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.google.android.material.R$styleable;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class C2rE4F {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f7150A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B2KMhB f7151A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int[][] f7152A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final B2KMhB[] f7153ADYaiT;
    public final BpkvW3 AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final BpkvW3 f7154ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final BpkvW3 f7155ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final BpkvW3 f7156AYUAbz;

    public C2rE4F(HFjH17.ARc23Z aRc23Z) {
        this.f7150A2egSU = aRc23Z.f3319A2egSU;
        this.f7151A4TApA = (B2KMhB) aRc23Z.f3320A4TApA;
        this.f7152A5SV6n = (int[][]) aRc23Z.f3321A5SV6n;
        this.f7153ADYaiT = (B2KMhB[]) aRc23Z.f3322ADYaiT;
        this.AMqCpz = (BpkvW3) aRc23Z.AMqCpz;
        this.f7154ARc23Z = (BpkvW3) aRc23Z.f3323ARc23Z;
        this.f7155ASJ6gh = (BpkvW3) aRc23Z.f3324ASJ6gh;
        this.f7156AYUAbz = (BpkvW3) aRc23Z.f3325AYUAbz;
    }

    public static void A2egSU(HFjH17.ARc23Z aRc23Z, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlResourceParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                Resources resources = context.getResources();
                int[] iArr = R$styleable.f11241BniPrB;
                TypedArray obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                B2KMhB A2egSU2 = B2KMhB.A2egSU(context, obtainAttributes.getResourceId(0, 0), obtainAttributes.getResourceId(1, 0)).A2egSU();
                obtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i = 0;
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                    if (attributeNameResource != 2130969839 && attributeNameResource != 2130969850) {
                        int i3 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i] = attributeNameResource;
                        i = i3;
                    }
                }
                aRc23Z.ASJ6gh(StateSet.trimStateSet(iArr2, i), A2egSU2);
            }
        }
    }

    public static C2rE4F A4TApA(Context context, TypedArray typedArray, int i) {
        XmlResourceParser xml;
        int next;
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        HFjH17.ARc23Z aRc23Z = new HFjH17.ARc23Z();
        aRc23Z.AYUAbz();
        try {
            xml = context.getResources().getXml(resourceId);
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            aRc23Z.AYUAbz();
        }
        try {
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
            if (xml.getName().equals("selector")) {
                A2egSU(aRc23Z, context, xml, asAttributeSet, context.getTheme());
            }
            xml.close();
            if (aRc23Z.f3319A2egSU == 0) {
                return null;
            }
            return new C2rE4F(aRc23Z);
        } catch (Throwable th) {
            if (xml != null) {
                try {
                    xml.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final B2KMhB A5SV6n() {
        B2KMhB b2KMhB = this.f7151A4TApA;
        BpkvW3 bpkvW3 = this.f7156AYUAbz;
        BpkvW3 bpkvW32 = this.f7155ASJ6gh;
        BpkvW3 bpkvW33 = this.f7154ARc23Z;
        BpkvW3 bpkvW34 = this.AMqCpz;
        if (bpkvW34 == null && bpkvW33 == null && bpkvW32 == null && bpkvW3 == null) {
            return b2KMhB;
        }
        B2KMhB.A2egSU ASJ6gh2 = b2KMhB.ASJ6gh();
        if (bpkvW34 != null) {
            ASJ6gh2.AMqCpz = bpkvW34.f7147A4TApA;
        }
        if (bpkvW33 != null) {
            ASJ6gh2.f7098ARc23Z = bpkvW33.f7147A4TApA;
        }
        if (bpkvW32 != null) {
            ASJ6gh2.f7100AYUAbz = bpkvW32.f7147A4TApA;
        }
        if (bpkvW3 != null) {
            ASJ6gh2.f7099ASJ6gh = bpkvW3.f7147A4TApA;
        }
        return ASJ6gh2.A2egSU();
    }

    public final boolean ADYaiT() {
        BpkvW3 bpkvW3;
        BpkvW3 bpkvW32;
        BpkvW3 bpkvW33;
        BpkvW3 bpkvW34;
        return this.f7150A2egSU > 1 || ((bpkvW3 = this.AMqCpz) != null && bpkvW3.f7146A2egSU > 1) || (((bpkvW32 = this.f7154ARc23Z) != null && bpkvW32.f7146A2egSU > 1) || (((bpkvW33 = this.f7155ASJ6gh) != null && bpkvW33.f7146A2egSU > 1) || ((bpkvW34 = this.f7156AYUAbz) != null && bpkvW34.f7146A2egSU > 1)));
    }
}
