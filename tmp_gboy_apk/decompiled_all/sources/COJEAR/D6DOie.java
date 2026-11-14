package COJEAR;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.contentcapture.ContentCaptureSession;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class D6DOie {
    public static View.AccessibilityDelegate A2egSU(View view) {
        return view.getAccessibilityDelegate();
    }

    public static ContentCaptureSession A4TApA(View view) {
        return view.getContentCaptureSession();
    }

    public static List<Rect> A5SV6n(View view) {
        return view.getSystemGestureExclusionRects();
    }

    public static void ADYaiT(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
    }

    public static void AMqCpz(View view, CcAIMM.A2egSU a2egSU) {
        view.setContentCaptureSession(null);
    }

    public static void ARc23Z(View view, List<Rect> list) {
        view.setSystemGestureExclusionRects(list);
    }
}
