package PCV8se;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import com.google.android.material.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BpkvW3 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f7146A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ADYaiT f7147A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int[][] f7148A5SV6n = new int[10][];

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ADYaiT[] f7149ADYaiT = new ADYaiT[10];

    public static BpkvW3 A4TApA(ADYaiT aDYaiT) {
        BpkvW3 bpkvW3 = new BpkvW3();
        bpkvW3.A2egSU(StateSet.WILD_CARD, aDYaiT);
        return bpkvW3;
    }

    public final void A2egSU(int[] iArr, ADYaiT aDYaiT) {
        int i = this.f7146A2egSU;
        if (i == 0 || iArr.length == 0) {
            this.f7147A4TApA = aDYaiT;
        }
        int[][] iArr2 = this.f7148A5SV6n;
        if (i >= iArr2.length) {
            int i2 = i + 10;
            int[][] iArr3 = new int[i2][];
            System.arraycopy(iArr2, 0, iArr3, 0, i);
            this.f7148A5SV6n = iArr3;
            ADYaiT[] aDYaiTArr = new ADYaiT[i2];
            System.arraycopy(this.f7149ADYaiT, 0, aDYaiTArr, 0, i);
            this.f7149ADYaiT = aDYaiTArr;
        }
        int[][] iArr4 = this.f7148A5SV6n;
        int i3 = this.f7146A2egSU;
        iArr4[i3] = iArr;
        this.f7149ADYaiT[i3] = aDYaiT;
        this.f7146A2egSU = i3 + 1;
    }

    public final ADYaiT A5SV6n(int[] iArr) {
        int i;
        int[][] iArr2 = this.f7148A5SV6n;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = -1;
            if (i3 >= this.f7146A2egSU) {
                i3 = -1;
                break;
            }
            if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                break;
            }
            i3++;
        }
        if (i3 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int[][] iArr4 = this.f7148A5SV6n;
            while (true) {
                if (i2 >= this.f7146A2egSU) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr4[i2], iArr3)) {
                    i = i2;
                    break;
                }
                i2++;
            }
            i3 = i;
        }
        return i3 < 0 ? this.f7147A4TApA : this.f7149ADYaiT[i3];
    }

    public final void ADYaiT(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
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
                int[] iArr = R$styleable.f11255CqNSpT;
                TypedArray obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                ADYaiT ADYaiT2 = B2KMhB.ADYaiT(obtainAttributes, 5, new A2egSU(0.0f));
                obtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i = 0;
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                    if (attributeNameResource != 2130968963) {
                        int i3 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i] = attributeNameResource;
                        i = i3;
                    }
                }
                A2egSU(StateSet.trimStateSet(iArr2, i), ADYaiT2);
            }
        }
    }
}
