package CqNSpT;

import ADYaiT.BmvVmW;
import COJEAR.DG07BK;
import CQhlFr.AYUAbz;
import CQhlFr.AaHO0E;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA extends COJEAR.A4TApA {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final Rect f1819AmA8tU = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final BmvVmW f1820AzWtSf = new BmvVmW(5);

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final BmvVmW f1821B25kr6 = new BmvVmW(6);

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final AccessibilityManager f1825AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final View f1826AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public A2egSU f1827AZkASS;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Rect f1822ADYaiT = new Rect();
    public final Rect AMqCpz = new Rect();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final Rect f1823ARc23Z = new Rect();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final int[] f1824ASJ6gh = new int[2];

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f1828AaHO0E = Integer.MIN_VALUE;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f1829AcNBzu = Integer.MIN_VALUE;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f1830AlLFFp = Integer.MIN_VALUE;

    static {
        AWmOccT();
    }

    public A4TApA(View view) {
        this.f1826AZOQYO = view;
        this.f1825AYUAbz = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    private static /* synthetic */ void AWmOccT() {
        char[] charArray = "ÕÙÛ\u0098Ñ×ÛÓ\u0098ÔÙÏ\u0098ÅÞÓÚÚ\u0098üØßôÄßÒÑÓ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 182);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÕÚßØßÂ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 182);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // COJEAR.A4TApA
    public final AaHO0E A4TApA(View view) {
        if (this.f1827AZkASS == null) {
            this.f1827AZkASS = new A2egSU(this);
        }
        return this.f1827AZkASS;
    }

    @Override // COJEAR.A4TApA
    public final void ADYaiT(View view, AYUAbz aYUAbz) {
        this.f1615A2egSU.onInitializeAccessibilityNodeInfo(view, aYUAbz.f1773A2egSU);
        B7CMnp(aYUAbz);
    }

    public final boolean AZkASS(int i) {
        if (this.f1829AcNBzu != i) {
            return false;
        }
        this.f1829AcNBzu = Integer.MIN_VALUE;
        BChYOn(i, false);
        BIYEnU(i, 8);
        return true;
    }

    public final AccessibilityEvent AaHO0E(int i, int i2) {
        View view = this.f1826AZOQYO;
        if (i == -1) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
            view.onInitializeAccessibilityEvent(obtain);
            return obtain;
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain(i2);
        AYUAbz B3GDIM2 = B3GDIM(i);
        obtain2.getText().add(B3GDIM2.ASJ6gh());
        AccessibilityNodeInfo accessibilityNodeInfo = B3GDIM2.f1773A2egSU;
        obtain2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        obtain2.setScrollable(accessibilityNodeInfo.isScrollable());
        obtain2.setPassword(accessibilityNodeInfo.isPassword());
        obtain2.setEnabled(accessibilityNodeInfo.isEnabled());
        obtain2.setChecked(accessibilityNodeInfo.isChecked());
        if (obtain2.getText().isEmpty() && obtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain2.setClassName(accessibilityNodeInfo.getClassName());
        obtain2.setSource(view, i);
        obtain2.setPackageName(view.getContext().getPackageName());
        return obtain2;
    }

    public final AYUAbz AcNBzu(int i) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        AYUAbz aYUAbz = new AYUAbz(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        aYUAbz.AZkASS("android.view.View");
        Rect rect = f1819AmA8tU;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        View view = this.f1826AZOQYO;
        obtain.setParent(view);
        B9tovu(i, aYUAbz);
        if (aYUAbz.ASJ6gh() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.AMqCpz;
        aYUAbz.ARc23Z(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & r.b.d) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        obtain.setPackageName(view.getContext().getPackageName());
        aYUAbz.f1774A4TApA = i;
        obtain.setSource(view, i);
        if (this.f1828AaHO0E == i) {
            obtain.setAccessibilityFocused(true);
            aYUAbz.A2egSU(r.b.d);
        } else {
            obtain.setAccessibilityFocused(false);
            aYUAbz.A2egSU(64);
        }
        boolean z = this.f1829AcNBzu == i;
        if (z) {
            aYUAbz.A2egSU(2);
        } else if (obtain.isFocusable()) {
            aYUAbz.A2egSU(1);
        }
        obtain.setFocused(z);
        int[] iArr = this.f1824ASJ6gh;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.f1822ADYaiT;
        obtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            aYUAbz.ARc23Z(rect3);
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.f1823ARc23Z;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                obtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view2 = (View) parent;
                            if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                break;
                            }
                            parent = view2.getParent();
                        } else if (parent != null) {
                            aYUAbz.f1773A2egSU.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return aYUAbz;
    }

    public final boolean AlLFFp(MotionEvent motionEvent) {
        int i;
        AccessibilityManager accessibilityManager = this.f1825AYUAbz;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int AmA8tU2 = AmA8tU(motionEvent.getX(), motionEvent.getY());
            int i2 = this.f1830AlLFFp;
            if (i2 != AmA8tU2) {
                this.f1830AlLFFp = AmA8tU2;
                BIYEnU(AmA8tU2, r.b.d);
                BIYEnU(i2, 256);
            }
            if (AmA8tU2 == Integer.MIN_VALUE) {
                return false;
            }
        } else {
            if (action != 10 || (i = this.f1830AlLFFp) == Integer.MIN_VALUE) {
                return false;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1830AlLFFp = Integer.MIN_VALUE;
                BIYEnU(i, 256);
                return true;
            }
        }
        return true;
    }

    public abstract int AmA8tU(float f, float f2);

    public abstract void AzWtSf(ArrayList arrayList);

    public final void B25kr6(int i) {
        View view;
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.f1825AYUAbz.isEnabled() || (parent = (view = this.f1826AZOQYO).getParent()) == null) {
            return;
        }
        AccessibilityEvent AaHO0E2 = AaHO0E(i, 2048);
        AaHO0E2.setContentChangeTypes(0);
        parent.requestSendAccessibilityEvent(view, AaHO0E2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B2KMhB(int r21, android.graphics.Rect r22) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: CqNSpT.A4TApA.B2KMhB(int, android.graphics.Rect):boolean");
    }

    public final AYUAbz B3GDIM(int i) {
        if (i != -1) {
            return AcNBzu(i);
        }
        View view = this.f1826AZOQYO;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(view);
        AYUAbz aYUAbz = new AYUAbz(obtain);
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        view.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        AzWtSf(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            aYUAbz.f1773A2egSU.addChild(view, ((Integer) arrayList.get(i2)).intValue());
        }
        return aYUAbz;
    }

    public abstract boolean B4ZgIw(int i, int i2, Bundle bundle);

    public void B7CMnp(AYUAbz aYUAbz) {
    }

    public abstract void B9tovu(int i, AYUAbz aYUAbz);

    public void BChYOn(int i, boolean z) {
    }

    public final boolean BI9f7h(int i) {
        int i2;
        View view = this.f1826AZOQYO;
        if ((!view.isFocused() && !view.requestFocus()) || (i2 = this.f1829AcNBzu) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            AZkASS(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.f1829AcNBzu = i;
        BChYOn(i, true);
        BIYEnU(i, 8);
        return true;
    }

    public final void BIYEnU(int i, int i2) {
        View view;
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.f1825AYUAbz.isEnabled() || (parent = (view = this.f1826AZOQYO).getParent()) == null) {
            return;
        }
        parent.requestSendAccessibilityEvent(view, AaHO0E(i, i2));
    }
}
