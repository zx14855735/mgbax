package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ViewStatusListener f12862AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ViewStatus f12863AlLFFp;

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: A2egSU, reason: collision with root package name */
        public static final /* synthetic */ int[] f12864A2egSU;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            f12864A2egSU = iArr;
            try {
                iArr[ViewStatus.ATTACHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12864A2egSU[ViewStatus.DETACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ViewStatus {
        public static final ViewStatus ATTACHED;

        /* renamed from: AcNBzu, reason: collision with root package name */
        public static final /* synthetic */ ViewStatus[] f12865AcNBzu;
        public static final ViewStatus DETACHED;
        public static final ViewStatus INIT;

        static {
            ViewStatus viewStatus = new ViewStatus("INIT", 0);
            INIT = viewStatus;
            ViewStatus viewStatus2 = new ViewStatus("ATTACHED", 1);
            ATTACHED = viewStatus2;
            ViewStatus viewStatus3 = new ViewStatus("DETACHED", 2);
            DETACHED = viewStatus3;
            f12865AcNBzu = new ViewStatus[]{viewStatus, viewStatus2, viewStatus3};
            PnZeiO();
        }

        private static /* synthetic */ void PnZeiO() {
            char[] charArray = "48:y06:2y58.y$?2;;y\u001d9>\u0015%>302".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'W');
            }
            String str = new String(charArray);
            char[] charArray2 = "4;>9>#".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'W');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static ViewStatus valueOf(String str) {
            return (ViewStatus) Enum.valueOf(ViewStatus.class, str);
        }

        public static ViewStatus[] values() {
            return (ViewStatus[]) f12865AcNBzu.clone();
        }
    }

    public NativeAdContainer(Context context) {
        super(context);
        this.f12863AlLFFp = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.f12862AcNBzu;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12863AlLFFp = ViewStatus.ATTACHED;
        ViewStatusListener viewStatusListener = this.f12862AcNBzu;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f12863AlLFFp = ViewStatus.DETACHED;
        ViewStatusListener viewStatusListener = this.f12862AcNBzu;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ViewStatusListener viewStatusListener = this.f12862AcNBzu;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        ViewStatusListener viewStatusListener = this.f12862AcNBzu;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f12862AcNBzu = viewStatusListener;
        if (viewStatusListener != null) {
            int i = AnonymousClass1.f12864A2egSU[this.f12863AlLFFp.ordinal()];
            if (i == 1) {
                this.f12862AcNBzu.onAttachToWindow();
            } else {
                if (i != 2) {
                    return;
                }
                this.f12862AcNBzu.onDetachFromWindow();
            }
        }
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12863AlLFFp = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12863AlLFFp = ViewStatus.INIT;
    }
}
