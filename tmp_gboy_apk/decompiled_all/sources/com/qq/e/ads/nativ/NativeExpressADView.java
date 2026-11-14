package com.qq.e.ads.nativ;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.LADI;
import com.qq.e.comm.pi.NFBI;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class NativeExpressADView extends FrameLayout implements DownloadConfirmListener, LADI, NFBI {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f12834AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public double f12835AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public double f12836AmA8tU;

    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(Context context) {
        super(context);
        this.f12834AcNBzu = -1;
        this.f12835AlLFFp = -1.0d;
        this.f12836AmA8tU = -1.0d;
    }

    public abstract void destroy();

    public abstract AdData getBoundData();

    public abstract void negativeFeedback();

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int min;
        int min2;
        if (this.f12834AcNBzu <= 0 || this.f12835AlLFFp <= 0.0d || this.f12836AmA8tU <= 0.0d) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            if (size2 < this.f12834AcNBzu || size < this.f12835AlLFFp * size2) {
                double d = this.f12836AmA8tU;
                double d2 = size2 * d;
                double d3 = size;
                if (d2 < d3) {
                    min2 = (int) (d2 + 0.5d);
                    i = View.MeasureSpec.makeMeasureSpec(min2, 1073741824);
                } else {
                    min = (int) ((d3 / d) + 0.5d);
                    i2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
                }
            }
        } else if (mode2 == 1073741824) {
            min2 = Math.min((int) ((size2 * this.f12836AmA8tU) + 0.5d), size);
            i = View.MeasureSpec.makeMeasureSpec(min2, 1073741824);
        } else {
            min = Math.min((int) ((size / this.f12836AmA8tU) + 0.5d), size2);
            i2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        }
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        super.onMeasure(i, i2);
        if (mode != Integer.MIN_VALUE || size == getMeasuredWidth()) {
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((getMeasuredWidth() / this.f12836AmA8tU) + 0.5d), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Integer.MIN_VALUE);
        View.MeasureSpec.getSize(makeMeasureSpec2);
        View.MeasureSpec.getSize(makeMeasureSpec);
        super.onMeasure(makeMeasureSpec2, makeMeasureSpec);
    }

    public abstract void preloadVideo();

    public abstract void render();

    @Deprecated
    public abstract void setAdSize(ADSize aDSize);

    public abstract void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener);

    public void setSizeRules(int i, double d, double d2) {
        this.f12834AcNBzu = i;
        this.f12835AlLFFp = d;
        this.f12836AmA8tU = d2;
    }

    public abstract void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener);
}
