package CQhlFr;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {
    public static final A5SV6n AMqCpz = new A5SV6n(1, (String) null);

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final A5SV6n f1757ARc23Z = new A5SV6n(2, (String) null);

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final A5SV6n f1758ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final A5SV6n f1759AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final A5SV6n f1760AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final A5SV6n f1761AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final A5SV6n f1762AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A5SV6n f1763AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final A5SV6n f1764AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final A5SV6n f1765AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final A5SV6n f1766AzWtSf;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f1767A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f1768A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Class f1769A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final B7CMnp f1770ADYaiT;

    static {
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction22;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction23;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction24;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction25;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction26;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction27;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction28;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction29;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction30;
        new A5SV6n(4, (String) null);
        new A5SV6n(8, (String) null);
        f1758ASJ6gh = new A5SV6n(16, (String) null);
        new A5SV6n(32, (String) null);
        new A5SV6n(64, (String) null);
        new A5SV6n(r.b.d, (String) null);
        new A5SV6n(256, AlLFFp.class);
        new A5SV6n(512, AlLFFp.class);
        new A5SV6n(1024, AmA8tU.class);
        new A5SV6n(2048, AmA8tU.class);
        f1759AYUAbz = new A5SV6n(f.a.c, (String) null);
        f1760AZOQYO = new A5SV6n(ProxyCacheUtils.DEFAULT_BUFFER_SIZE, (String) null);
        new A5SV6n(f.a.d, (String) null);
        new A5SV6n(32768, (String) null);
        new A5SV6n(65536, (String) null);
        new A5SV6n(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, B3GDIM.class);
        f1761AZkASS = new A5SV6n(262144, (String) null);
        f1762AaHO0E = new A5SV6n(524288, (String) null);
        f1763AcNBzu = new A5SV6n(1048576, (String) null);
        new A5SV6n(2097152, B4ZgIw.class);
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            accessibilityAction30 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
            accessibilityAction = accessibilityAction30;
        } else {
            accessibilityAction = null;
        }
        new A5SV6n(accessibilityAction, R.id.accessibilityActionShowOnScreen, null, null, null);
        if (i >= 23) {
            accessibilityAction29 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
            accessibilityAction2 = accessibilityAction29;
        } else {
            accessibilityAction2 = null;
        }
        new A5SV6n(accessibilityAction2, R.id.accessibilityActionScrollToPosition, null, null, B25kr6.class);
        f1764AlLFFp = new A5SV6n(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
        if (i >= 23) {
            accessibilityAction28 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
            accessibilityAction3 = accessibilityAction28;
        } else {
            accessibilityAction3 = null;
        }
        new A5SV6n(accessibilityAction3, R.id.accessibilityActionScrollLeft, null, null, null);
        if (i >= 23) {
            accessibilityAction27 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
            accessibilityAction4 = accessibilityAction27;
        } else {
            accessibilityAction4 = null;
        }
        f1765AmA8tU = new A5SV6n(accessibilityAction4, R.id.accessibilityActionScrollDown, null, null, null);
        new A5SV6n(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
        if (i >= 29) {
            accessibilityAction26 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            accessibilityAction5 = accessibilityAction26;
        } else {
            accessibilityAction5 = null;
        }
        new A5SV6n(accessibilityAction5, R.id.accessibilityActionPageUp, null, null, null);
        if (i >= 29) {
            accessibilityAction25 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            accessibilityAction6 = accessibilityAction25;
        } else {
            accessibilityAction6 = null;
        }
        new A5SV6n(accessibilityAction6, R.id.accessibilityActionPageDown, null, null, null);
        new A5SV6n(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        if (i >= 29) {
            accessibilityAction24 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            accessibilityAction7 = accessibilityAction24;
        } else {
            accessibilityAction7 = null;
        }
        new A5SV6n(accessibilityAction7, R.id.accessibilityActionPageRight, null, null, null);
        if (i >= 23) {
            accessibilityAction23 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
            accessibilityAction8 = accessibilityAction23;
        } else {
            accessibilityAction8 = null;
        }
        new A5SV6n(accessibilityAction8, R.id.accessibilityActionContextClick, null, null, null);
        if (i >= 24) {
            accessibilityAction22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            accessibilityAction9 = accessibilityAction22;
        } else {
            accessibilityAction9 = null;
        }
        f1766AzWtSf = new A5SV6n(accessibilityAction9, R.id.accessibilityActionSetProgress, null, null, B2KMhB.class);
        new A5SV6n(i >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, AzWtSf.class);
        if (i >= 28) {
            accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            accessibilityAction10 = accessibilityAction21;
        } else {
            accessibilityAction10 = null;
        }
        new A5SV6n(accessibilityAction10, R.id.accessibilityActionShowTooltip, null, null, null);
        if (i >= 28) {
            accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            accessibilityAction11 = accessibilityAction20;
        } else {
            accessibilityAction11 = null;
        }
        new A5SV6n(accessibilityAction11, R.id.accessibilityActionHideTooltip, null, null, null);
        new A5SV6n(i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        if (i >= 30) {
            accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            accessibilityAction12 = accessibilityAction19;
        } else {
            accessibilityAction12 = null;
        }
        new A5SV6n(accessibilityAction12, R.id.accessibilityActionImeEnter, null, null, null);
        new A5SV6n(i >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        if (i >= 32) {
            accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            accessibilityAction13 = accessibilityAction18;
        } else {
            accessibilityAction13 = null;
        }
        new A5SV6n(accessibilityAction13, R.id.accessibilityActionDragDrop, null, null, null);
        if (i >= 32) {
            accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            accessibilityAction14 = accessibilityAction17;
        } else {
            accessibilityAction14 = null;
        }
        new A5SV6n(accessibilityAction14, R.id.accessibilityActionDragCancel, null, null, null);
        if (i >= 33) {
            accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            accessibilityAction15 = accessibilityAction16;
        } else {
            accessibilityAction15 = null;
        }
        new A5SV6n(accessibilityAction15, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        new A5SV6n(i >= 34 ? ARc23Z.A2egSU() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        Mxkhp();
    }

    public A5SV6n(int i, String str) {
        this(null, i, str, null, null);
    }

    private static /* synthetic */ void Mxkhp() {
        char[] charArray = "°¼¾ý´²¾¶ý±¼ªý »¶¿¿ý\u0099½º\u0091¡º·´¶".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 211);
        }
        String str = new String(charArray);
        char[] charArray2 = "°¿º½º§".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 211);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final int A2egSU() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f1767A2egSU).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof A5SV6n)) {
            return false;
        }
        Object obj2 = ((A5SV6n) obj).f1767A2egSU;
        Object obj3 = this.f1767A2egSU;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f1767A2egSU;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String ADYaiT2 = AYUAbz.ADYaiT(this.f1768A4TApA);
        if (ADYaiT2.equals("ACTION_UNKNOWN")) {
            Object obj = this.f1767A2egSU;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                ADYaiT2 = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(ADYaiT2);
        return sb.toString();
    }

    public A5SV6n(int i, Class cls) {
        this(null, i, null, null, cls);
    }

    public A5SV6n(Object obj, int i, String str, B7CMnp b7CMnp, Class cls) {
        this.f1768A4TApA = i;
        this.f1770ADYaiT = b7CMnp;
        if (obj == null) {
            this.f1767A2egSU = new AccessibilityNodeInfo.AccessibilityAction(i, str);
        } else {
            this.f1767A2egSU = obj;
        }
        this.f1769A5SV6n = cls;
    }
}
