package androidx.constraintlayout.helper.widget;

import BChYOn.ARc23Z;
import BChYOn.AZOQYO;
import BChYOn.AlLFFp;
import BJ7GGh.AaHO0E;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Flow extends AaHO0E {

    /* renamed from: B9tovu, reason: collision with root package name */
    public AZOQYO f8276B9tovu;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // BJ7GGh.AaHO0E, androidx.constraintlayout.widget.A2egSU
    public final void ASJ6gh(AttributeSet attributeSet) {
        super.ASJ6gh(attributeSet);
        this.f8276B9tovu = new AZOQYO();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f8417A4TApA);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.f8276B9tovu.f1251FpcJKS = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    AZOQYO azoqyo = this.f8276B9tovu;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    azoqyo.f1265DyaChj = dimensionPixelSize;
                    azoqyo.f1266ECyGFg = dimensionPixelSize;
                    azoqyo.f1267EGM26s = dimensionPixelSize;
                    azoqyo.f1268EH1KK8 = dimensionPixelSize;
                } else if (index == 18) {
                    AZOQYO azoqyo2 = this.f8276B9tovu;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    azoqyo2.f1267EGM26s = dimensionPixelSize2;
                    azoqyo2.f1269EPdU4G = dimensionPixelSize2;
                    azoqyo2.f1270EQurEW = dimensionPixelSize2;
                } else if (index == 19) {
                    this.f8276B9tovu.f1268EH1KK8 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f8276B9tovu.f1269EPdU4G = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f8276B9tovu.f1265DyaChj = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f8276B9tovu.f1270EQurEW = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f8276B9tovu.f1266ECyGFg = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.f8276B9tovu.f1249Fmmv0E = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.f8276B9tovu.f1233EicXu4 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.f8276B9tovu.f1234EmJGcg = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.f8276B9tovu.f1235ErKPGd = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.f8276B9tovu.f1237EwN40Z = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.f8276B9tovu.f1236EsrwYR = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.f8276B9tovu.f1238ExjC7D = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.f8276B9tovu.f1239F1loUV = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.f8276B9tovu.f1241F508T2 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.f8276B9tovu.f1243FM663C = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.f8276B9tovu.f1242FG7pZc = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.f8276B9tovu.f1244FOAO9d = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.f8276B9tovu.f1240F32kj0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.f8276B9tovu.f1247FdMWEC = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.f8276B9tovu.f1248Ff5QvW = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.f8276B9tovu.f1245FSFw2u = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.f8276B9tovu.f1246FZu94u = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.f8276B9tovu.f1250FmyuN2 = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f8280AzWtSf = this.f8276B9tovu;
        AZOQYO();
    }

    @Override // androidx.constraintlayout.widget.A2egSU
    public final void AYUAbz(ARc23Z aRc23Z, boolean z) {
        AZOQYO azoqyo = this.f8276B9tovu;
        int i = azoqyo.f1267EGM26s;
        if (i > 0 || azoqyo.f1268EH1KK8 > 0) {
            if (z) {
                azoqyo.f1269EPdU4G = azoqyo.f1268EH1KK8;
                azoqyo.f1270EQurEW = i;
            } else {
                azoqyo.f1269EPdU4G = i;
                azoqyo.f1270EQurEW = azoqyo.f1268EH1KK8;
            }
        }
    }

    @Override // BJ7GGh.AaHO0E
    public final void AZkASS(AlLFFp alLFFp, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (alLFFp == null) {
            setMeasuredDimension(0, 0);
        } else {
            alLFFp.CqNSpT(mode, size, mode2, size2);
            setMeasuredDimension(alLFFp.f1272EY4UKY, alLFFp.EdQ5bb);
        }
    }

    @Override // androidx.constraintlayout.widget.A2egSU, android.view.View
    public final void onMeasure(int i, int i2) {
        AZkASS(this.f8276B9tovu, i, i2);
    }

    public void setFirstHorizontalBias(float f) {
        this.f8276B9tovu.f1241F508T2 = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.f8276B9tovu.f1235ErKPGd = i;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.f8276B9tovu.f1242FG7pZc = f;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.f8276B9tovu.f1236EsrwYR = i;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.f8276B9tovu.f1247FdMWEC = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.f8276B9tovu.f1239F1loUV = f;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.f8276B9tovu.f1245FSFw2u = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.f8276B9tovu.f1233EicXu4 = i;
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.f8276B9tovu.f1243FM663C = f;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.f8276B9tovu.f1237EwN40Z = i;
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.f8276B9tovu.f1244FOAO9d = f;
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.f8276B9tovu.f1238ExjC7D = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.f8276B9tovu.f1250FmyuN2 = i;
        requestLayout();
    }

    public void setOrientation(int i) {
        this.f8276B9tovu.f1251FpcJKS = i;
        requestLayout();
    }

    public void setPadding(int i) {
        AZOQYO azoqyo = this.f8276B9tovu;
        azoqyo.f1265DyaChj = i;
        azoqyo.f1266ECyGFg = i;
        azoqyo.f1267EGM26s = i;
        azoqyo.f1268EH1KK8 = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.f8276B9tovu.f1266ECyGFg = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.f8276B9tovu.f1269EPdU4G = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.f8276B9tovu.f1270EQurEW = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.f8276B9tovu.f1265DyaChj = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.f8276B9tovu.f1248Ff5QvW = i;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.f8276B9tovu.f1240F32kj0 = f;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.f8276B9tovu.f1246FZu94u = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.f8276B9tovu.f1234EmJGcg = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.f8276B9tovu.f1249Fmmv0E = i;
        requestLayout();
    }
}
