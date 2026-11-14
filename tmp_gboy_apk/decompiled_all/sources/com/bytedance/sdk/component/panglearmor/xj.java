package com.bytedance.sdk.component.panglearmor;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends View.AccessibilityDelegate {
    public static Field hf;
    public View c;
    public View.AccessibilityDelegate y;
    public static xj xj = new xj(null, null);
    public static int w = 0;
    public static String u = "";
    public static Set<Integer> kd = new HashSet();

    static {
        hf = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                hf = declaredField;
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }

    public xj(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.y = accessibilityDelegate;
        this.c = view;
        SoftDecTool.h = true;
    }

    public static void xj(View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (kd.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                Field field = hf;
                if (field != null) {
                    accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
            accessibilityDelegate = null;
            z = false;
        }
        if (!(accessibilityDelegate instanceof xj) && z) {
            view.setAccessibilityDelegate(new xj(accessibilityDelegate, view));
            kd.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        w = hashCode();
        u = String.valueOf(this.y);
        view.setAccessibilityDelegate(this.y);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.AccessibilityDelegate accessibilityDelegate = this.y;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                } else {
                    super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        w = hashCode();
        u = String.valueOf(this.y);
        view.setAccessibilityDelegate(this.y);
        view.setAccessibilityDelegate(this.y);
        View.AccessibilityDelegate accessibilityDelegate = this.y;
        boolean dispatchPopulateAccessibilityEvent = accessibilityDelegate != null ? accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        view.setAccessibilityDelegate(this);
        return dispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        w = hashCode();
        u = String.valueOf(this.y);
        view.setAccessibilityDelegate(this.y);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.y;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f = true;
        w = hashCode();
        u = String.valueOf(this.y);
        view.setAccessibilityDelegate(this.y);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.y;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        w = hashCode();
        u = String.valueOf(this.y);
        if (xj()) {
            return;
        }
        view.setAccessibilityDelegate(this.y);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.y;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        w = hashCode();
        u = String.valueOf(this.y);
        viewGroup.setAccessibilityDelegate(this.y);
        View.AccessibilityDelegate accessibilityDelegate = this.y;
        boolean onRequestSendAccessibilityEvent = accessibilityDelegate != null ? accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        viewGroup.setAccessibilityDelegate(this);
        return onRequestSendAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        w = hashCode();
        u = String.valueOf(this.y);
        SoftDecTool.f10211a = true;
        view.setAccessibilityDelegate(this.y);
        View.AccessibilityDelegate accessibilityDelegate = this.y;
        boolean performAccessibilityAction = accessibilityDelegate != null ? accessibilityDelegate.performAccessibilityAction(view, i, bundle) : super.performAccessibilityAction(view, i, bundle);
        view.setAccessibilityDelegate(this);
        return performAccessibilityAction;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        w = hashCode();
        u = String.valueOf(this.y);
        view.setAccessibilityDelegate(this.y);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.y;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        w = hashCode();
        u = String.valueOf(this.y);
        view.setAccessibilityDelegate(this.y);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.y;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        view.setAccessibilityDelegate(this);
    }

    public boolean xj() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4 || (stackTraceElement = stackTrace[3]) == null) {
            return false;
        }
        for (int i = 4; i < stackTrace.length; i++) {
            if (stackTrace[i] != null && stackTraceElement.getMethodName().equals(stackTrace[i].getMethodName()) && stackTraceElement.getClassName().equals(stackTrace[i].getClassName())) {
                return true;
            }
        }
        return false;
    }
}
