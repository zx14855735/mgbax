package BJ7GGh;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f1417A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float f1418A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final float f1419A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final float f1420ADYaiT;
    public final int AMqCpz;

    public ASJ6gh(Context context, XmlResourceParser xmlResourceParser) {
        this.f1417A2egSU = Float.NaN;
        this.f1418A4TApA = Float.NaN;
        this.f1419A5SV6n = Float.NaN;
        this.f1420ADYaiT = Float.NaN;
        this.AMqCpz = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.f8424AZkASS);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.AMqCpz);
                this.AMqCpz = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new androidx.constraintlayout.widget.A5SV6n().A4TApA((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.f1420ADYaiT = obtainStyledAttributes.getDimension(index, this.f1420ADYaiT);
            } else if (index == 2) {
                this.f1418A4TApA = obtainStyledAttributes.getDimension(index, this.f1418A4TApA);
            } else if (index == 3) {
                this.f1419A5SV6n = obtainStyledAttributes.getDimension(index, this.f1419A5SV6n);
            } else if (index == 4) {
                this.f1417A2egSU = obtainStyledAttributes.getDimension(index, this.f1417A2egSU);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
