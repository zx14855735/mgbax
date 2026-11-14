package com.fl.saas.common.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class VisibilityLayout extends FrameLayout {
    private Runnable checkAreaRatioRunnable;
    private Runnable checkValidAreaRunnable;
    private Consumer<Boolean> mVisibilityChanged;
    private Consumer<Integer> mVisibilityRatioChanged;
    private int maxRatio;
    private OnViewWindowChangedListener onViewWindowChangedListener;

    public interface OnViewWindowChangedListener {
        void onDetachedFromWindow();

        void onViewWindowVisibility(boolean z);
    }

    public VisibilityLayout(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAreaRatio() {
        if (this.mVisibilityRatioChanged == null) {
            return;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        int areaEffectiveRatio = getAreaEffectiveRatio(rect);
        if (areaEffectiveRatio > this.maxRatio) {
            this.maxRatio = areaEffectiveRatio;
            Consumer<Integer> consumer = this.mVisibilityRatioChanged;
            if (consumer != null) {
                consumer.accept(Integer.valueOf(areaEffectiveRatio));
            }
        }
        if (this.checkAreaRatioRunnable == null) {
            this.checkAreaRatioRunnable = new A4TApA(this, 0);
        }
        DeviceUtil.postUIDelayed(200L, this.checkAreaRatioRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkValidArea() {
        if (this.mVisibilityChanged == null) {
            checkAreaRatio();
            return;
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = getGlobalVisibleRect(rect);
        int areaEffectiveRatio = getAreaEffectiveRatio(rect);
        if (areaEffectiveRatio > this.maxRatio) {
            this.maxRatio = areaEffectiveRatio;
            Consumer<Integer> consumer = this.mVisibilityRatioChanged;
            if (consumer != null) {
                consumer.accept(Integer.valueOf(areaEffectiveRatio));
            }
        }
        Consumer<Boolean> consumer2 = this.mVisibilityChanged;
        if (consumer2 != null) {
            consumer2.accept(Boolean.valueOf(globalVisibleRect && areaEffectiveRatio > 70));
        }
        if (this.checkValidAreaRunnable == null) {
            this.checkValidAreaRunnable = new A4TApA(this, 1);
        }
        DeviceUtil.postUIDelayed(100L, this.checkValidAreaRunnable);
    }

    private int getAreaEffectiveRatio(Rect rect) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return 0;
        }
        return ((rect.height() * rect.width()) * 100) / (width * height);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnViewWindowChangedListener onViewWindowChangedListener = this.onViewWindowChangedListener;
        if (onViewWindowChangedListener != null) {
            onViewWindowChangedListener.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            DeviceUtil.removePostUI(this.checkValidAreaRunnable);
        }
        checkValidArea();
        OnViewWindowChangedListener onViewWindowChangedListener = this.onViewWindowChangedListener;
        if (onViewWindowChangedListener != null) {
            onViewWindowChangedListener.onViewWindowVisibility(i == 0);
        }
    }

    public void setOnViewWindowChangedListener(OnViewWindowChangedListener onViewWindowChangedListener) {
        this.onViewWindowChangedListener = onViewWindowChangedListener;
    }

    public void setOnVisibilityChanged(Consumer<Boolean> consumer) {
        this.mVisibilityChanged = consumer;
        checkValidArea();
    }

    public void setVisibilityRatioChanged(Consumer<Integer> consumer) {
        this.mVisibilityRatioChanged = consumer;
    }

    public void unOnVisibilityChanged() {
        this.mVisibilityChanged = null;
    }

    public void unOnVisibilityRatioChanged() {
        this.mVisibilityRatioChanged = null;
    }

    public VisibilityLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VisibilityLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
