package COJEAR;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final View.AccessibilityDelegate f1614A5SV6n = new View.AccessibilityDelegate();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final View.AccessibilityDelegate f1615A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final A2egSU f1616A4TApA;

    static {
        hxvRiY();
    }

    public A4TApA() {
        this(f1614A5SV6n);
    }

    private static /* synthetic */ void hxvRiY() {
        char[] charArray = "JFD\u0007NHDL\u0007KFP\u0007ZALEE\u0007cG@k[@MNL".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ')');
        }
        String str = new String(charArray);
        char[] charArray2 = "JE@G@]".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ')');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean A2egSU(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1615A2egSU.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public CQhlFr.AaHO0E A4TApA(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f1615A2egSU.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new CQhlFr.AaHO0E(accessibilityNodeProvider);
        }
        return null;
    }

    public void A5SV6n(View view, AccessibilityEvent accessibilityEvent) {
        this.f1615A2egSU.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void ADYaiT(View view, CQhlFr.AYUAbz aYUAbz) {
        this.f1615A2egSU.onInitializeAccessibilityNodeInfo(view, aYUAbz.f1773A2egSU);
    }

    public void AMqCpz(View view, AccessibilityEvent accessibilityEvent) {
        this.f1615A2egSU.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean ARc23Z(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1615A2egSU.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean ASJ6gh(View view, int i, Bundle bundle) {
        boolean z;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(2131298056);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                break;
            }
            CQhlFr.A5SV6n a5SV6n = (CQhlFr.A5SV6n) list.get(i2);
            if (a5SV6n.A2egSU() == i) {
                CQhlFr.B7CMnp b7CMnp = a5SV6n.f1770ADYaiT;
                if (b7CMnp != null) {
                    Class cls = a5SV6n.f1769A5SV6n;
                    if (cls != null) {
                        try {
                            ((CQhlFr.AcNBzu) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).getClass();
                        } catch (Exception unused) {
                        }
                    }
                    z = b7CMnp.ADYaiT(view);
                }
            } else {
                i2++;
            }
        }
        z = false;
        if (!z) {
            z = this.f1615A2egSU.performAccessibilityAction(view, i, bundle);
        }
        if (z || i != 2131296282 || bundle == null) {
            return z;
        }
        int i3 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(2131298057);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i3)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            int i4 = 0;
            while (true) {
                if (clickableSpanArr == null || i4 >= clickableSpanArr.length) {
                    break;
                }
                if (clickableSpan.equals(clickableSpanArr[i4])) {
                    clickableSpan.onClick(view);
                    z2 = true;
                    break;
                }
                i4++;
            }
        }
        return z2;
    }

    public void AYUAbz(View view, int i) {
        this.f1615A2egSU.sendAccessibilityEvent(view, i);
    }

    public void AZOQYO(View view, AccessibilityEvent accessibilityEvent) {
        this.f1615A2egSU.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public A4TApA(View.AccessibilityDelegate accessibilityDelegate) {
        this.f1615A2egSU = accessibilityDelegate;
        this.f1616A4TApA = new A2egSU(this);
    }
}
