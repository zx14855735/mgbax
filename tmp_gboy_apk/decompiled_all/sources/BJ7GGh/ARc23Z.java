package BJ7GGh;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f1414A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f1415A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f1416A5SV6n;

    public ARc23Z(Context context, XmlResourceParser xmlResourceParser) {
        this.f1416A5SV6n = new ArrayList();
        this.f1415A4TApA = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.f8422AYUAbz);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.f1414A2egSU = obtainStyledAttributes.getResourceId(index, this.f1414A2egSU);
            } else if (index == 1) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f1415A4TApA);
                this.f1415A4TApA = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new androidx.constraintlayout.widget.A5SV6n().A4TApA((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    public ARc23Z(byte[] bArr, int i, int i2) {
        this.f1416A5SV6n = bArr;
        this.f1414A2egSU = i;
        this.f1415A4TApA = i2;
    }
}
