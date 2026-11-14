package com.fl.saas.common.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.fl.saas.common.util.feature.Consumer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ViewHelper {
    public static int AT_MOST_SPEC = View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE);

    static {
        oiiq();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends View> T findChildView(View view, AmA8tU.A2egSU a2egSU) {
        T t;
        if (a2egSU.apply(view) == Boolean.TRUE) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            T t2 = (T) viewGroup.getChildAt(i);
            if (a2egSU.apply(t2) == Boolean.TRUE) {
                return t2;
            }
            if ((t2 instanceof ViewGroup) && (t = (T) findChildView(t2, a2egSU)) != null) {
                return t;
            }
        }
        return null;
    }

    public static <T extends View> T findChildViewOfType(View view, Class<T> cls) {
        return (T) findChildView(view, new ASJ6gh(2, cls));
    }

    public static ViewGroup.LayoutParams getMatchParent() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    public static ViewGroup getParent(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    public static View getTopView() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null) {
                Field declaredField = cls.getDeclaredField("mViews");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                if (obj != null && (obj instanceof ArrayList)) {
                    return (View) ((ArrayList) obj).get(((ArrayList) obj).size() - 1);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static Rect getViewRectOnScreen(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        rect.left = i;
        rect.top = iArr[1];
        rect.right = view.getWidth() + i;
        rect.bottom = view.getHeight() + rect.top;
        return rect;
    }

    public static ViewGroup.LayoutParams getWrapParent() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public static <T extends View> boolean hasChildViewOfType(View view, Class<T> cls) {
        return findChildViewOfType(view, cls) != null;
    }

    public static <T extends View> T inflate(Context context, int i) {
        return (T) LayoutInflater.from(context).inflate(i, (ViewGroup) null);
    }

    public static boolean isPointInsideView(View view, float f, float f2) {
        return getViewRectOnScreen(view).contains(Math.round(f), Math.round(f2));
    }

    public static boolean isViewInParent(ViewGroup viewGroup, View view) {
        if (view != null && viewGroup != null) {
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                if (parent == viewGroup) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$findChildViewOfType$0(Class cls, View view) {
        return Boolean.valueOf(view != null && cls.isAssignableFrom(view.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onSingleClickListener$1(long[] jArr, int i, View.OnClickListener onClickListener, View view) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - jArr[0] <= i || onClickListener == null) {
            return;
        }
        onClickListener.onClick(view);
        jArr[0] = elapsedRealtime;
    }

    private static /* synthetic */ void oiiq() {
        char[] charArray = "\n\u0006\u0004G\u000e\b\u0004\fG\u000b\u0006\u0010G\u001a\u0001\f\u0005\u0005G#\u0007\u0000+\u001b\u0000\r\u000e\f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'i');
        }
        String str = new String(charArray);
        char[] charArray2 = "\n\u0005\u0000\u0007\u0000\u001d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'i');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void onSingleClickListener(View view, final int i, final View.OnClickListener onClickListener) {
        final long[] jArr = {0};
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.common.util.AYUAbz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewHelper.lambda$onSingleClickListener$1(jArr, i, onClickListener, view2);
            }
        });
    }

    public static void removeParent(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static int[] selfMeasure(View view) {
        if (view == null) {
            return new int[]{0, 0};
        }
        int i = AT_MOST_SPEC;
        view.measure(i, i);
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static TextView setTextView(TextView textView, String str) {
        return setTextView(textView, str, null);
    }

    public static void onSingleClickListener(View view, View.OnClickListener onClickListener) {
        onSingleClickListener(view, 1000, onClickListener);
    }

    public static TextView setTextView(TextView textView, String str, Consumer<? super TextView> consumer) {
        if (TextUtils.isEmpty(str)) {
            if (consumer != null) {
                consumer.accept(textView);
            }
        } else if (textView != null) {
            textView.setText(str);
            textView.setVisibility(0);
            return textView;
        }
        return textView;
    }
}
