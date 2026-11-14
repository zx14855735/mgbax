package BJ7GGh;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f1336A2egSU = false;

    /* renamed from: A4TApA, reason: collision with root package name */
    public A2egSU f1337A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f1338A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public float f1339ADYaiT;
    public String AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f1340ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f1341ASJ6gh;

    public A4TApA(A4TApA a4TApA, Object obj) {
        a4TApA.getClass();
        this.f1337A4TApA = a4TApA.f1337A4TApA;
        A4TApA(obj);
    }

    public static void A2egSU(Context context, XmlResourceParser xmlResourceParser, HashMap hashMap) {
        A2egSU a2egSU;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.f8419ADYaiT);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        A2egSU a2egSU2 = null;
        boolean z = false;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == 10) {
                str = obtainStyledAttributes.getString(index);
                z = true;
            } else if (index == 1) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                a2egSU2 = A2egSU.f1332B2KMhB;
            } else {
                if (index == 3) {
                    a2egSU = A2egSU.f1329AmA8tU;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == 2) {
                    a2egSU = A2egSU.f1330AzWtSf;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else {
                    A2egSU a2egSU3 = A2egSU.f1333B3GDIM;
                    if (index == 7) {
                        obj = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                    } else if (index == 4) {
                        obj = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                    } else if (index == 5) {
                        a2egSU = A2egSU.f1328AlLFFp;
                        valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                    } else if (index == 6) {
                        a2egSU = A2egSU.f1327AcNBzu;
                        valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                    } else if (index == 9) {
                        a2egSU = A2egSU.f1331B25kr6;
                        valueOf = obtainStyledAttributes.getString(index);
                    } else if (index == 8) {
                        a2egSU = A2egSU.f1334B4ZgIw;
                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        valueOf = Integer.valueOf(resourceId);
                    }
                    a2egSU2 = a2egSU3;
                }
                Object obj2 = valueOf;
                a2egSU2 = a2egSU;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            A4TApA a4TApA = new A4TApA();
            a4TApA.f1337A4TApA = a2egSU2;
            a4TApA.f1336A2egSU = z;
            a4TApA.A4TApA(obj);
            hashMap.put(str, a4TApA);
        }
        obtainStyledAttributes.recycle();
    }

    public final void A4TApA(Object obj) {
        switch (this.f1337A4TApA.ordinal()) {
            case 0:
            case 7:
                this.f1338A5SV6n = ((Integer) obj).intValue();
                break;
            case 1:
                this.f1339ADYaiT = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.f1341ASJ6gh = ((Integer) obj).intValue();
                break;
            case 4:
                this.AMqCpz = (String) obj;
                break;
            case 5:
                this.f1340ARc23Z = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.f1339ADYaiT = ((Float) obj).floatValue();
                break;
        }
    }

    public A2egSU getType() {
        return this.f1337A4TApA;
    }
}
