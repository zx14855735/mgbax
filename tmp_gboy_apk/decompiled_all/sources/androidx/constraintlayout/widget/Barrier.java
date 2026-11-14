package androidx.constraintlayout.widget;

import BChYOn.ARc23Z;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Barrier extends A2egSU {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f8395B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f8396B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public BChYOn.A2egSU f8397B9tovu;

    public Barrier(Context context) {
        super(context);
        this.f8277AcNBzu = new int[32];
        this.f8283B3GDIM = new HashMap();
        this.f8279AmA8tU = context;
        ASJ6gh(null);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.A2egSU
    public final void ASJ6gh(AttributeSet attributeSet) {
        super.ASJ6gh(attributeSet);
        this.f8397B9tovu = new BChYOn.A2egSU();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f8417A4TApA);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 26) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 25) {
                    this.f8397B9tovu.f1095ECyGFg = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 27) {
                    this.f8397B9tovu.f1096EGM26s = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f8280AzWtSf = this.f8397B9tovu;
        AZOQYO();
    }

    @Override // androidx.constraintlayout.widget.A2egSU
    public final void AYUAbz(ARc23Z aRc23Z, boolean z) {
        int i = this.f8395B4ZgIw;
        this.f8396B7CMnp = i;
        if (z) {
            if (i == 5) {
                this.f8396B7CMnp = 1;
            } else if (i == 6) {
                this.f8396B7CMnp = 0;
            }
        } else if (i == 5) {
            this.f8396B7CMnp = 0;
        } else if (i == 6) {
            this.f8396B7CMnp = 1;
        }
        if (aRc23Z instanceof BChYOn.A2egSU) {
            ((BChYOn.A2egSU) aRc23Z).f1094DyaChj = this.f8396B7CMnp;
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.f8397B9tovu.f1095ECyGFg;
    }

    public int getMargin() {
        return this.f8397B9tovu.f1096EGM26s;
    }

    public int getType() {
        return this.f8395B4ZgIw;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f8397B9tovu.f1095ECyGFg = z;
    }

    public void setDpMargin(int i) {
        this.f8397B9tovu.f1096EGM26s = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.f8397B9tovu.f1096EGM26s = i;
    }

    public void setType(int i) {
        this.f8395B4ZgIw = i;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
