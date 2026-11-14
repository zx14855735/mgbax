package CrfGsy;

import COJEAR.DG07BK;
import CQhlFr.AYUAbz;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Rect f1860ADYaiT = new Rect();
    public final /* synthetic */ DrawerLayout AMqCpz;

    public A4TApA(DrawerLayout drawerLayout) {
        this.AMqCpz = drawerLayout;
    }

    @Override // COJEAR.A4TApA
    public final boolean A2egSU(View view, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return this.f1615A2egSU.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        accessibilityEvent.getText();
        DrawerLayout drawerLayout = this.AMqCpz;
        View ASJ6gh2 = drawerLayout.ASJ6gh();
        if (ASJ6gh2 == null) {
            return true;
        }
        int AZOQYO2 = drawerLayout.AZOQYO(ASJ6gh2);
        drawerLayout.getClass();
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        Gravity.getAbsoluteGravity(AZOQYO2, drawerLayout.getLayoutDirection());
        return true;
    }

    @Override // COJEAR.A4TApA
    public final void A5SV6n(View view, AccessibilityEvent accessibilityEvent) {
        super.A5SV6n(view, accessibilityEvent);
        accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
    }

    @Override // COJEAR.A4TApA
    public final void ADYaiT(View view, AYUAbz aYUAbz) {
        boolean z = DrawerLayout.f8616CikNvS;
        View.AccessibilityDelegate accessibilityDelegate = this.f1615A2egSU;
        AccessibilityNodeInfo accessibilityNodeInfo = aYUAbz.f1773A2egSU;
        if (z) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        } else {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, obtain);
            aYUAbz.f1774A4TApA = -1;
            accessibilityNodeInfo.setSource(view);
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            Object parentForAccessibility = view.getParentForAccessibility();
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfo.setParent((View) parentForAccessibility);
            }
            Rect rect = this.f1860ADYaiT;
            obtain.getBoundsInScreen(rect);
            accessibilityNodeInfo.setBoundsInScreen(rect);
            accessibilityNodeInfo.setVisibleToUser(obtain.isVisibleToUser());
            accessibilityNodeInfo.setPackageName(obtain.getPackageName());
            aYUAbz.AZkASS(obtain.getClassName());
            aYUAbz.AcNBzu(obtain.getContentDescription());
            accessibilityNodeInfo.setEnabled(obtain.isEnabled());
            accessibilityNodeInfo.setFocused(obtain.isFocused());
            accessibilityNodeInfo.setAccessibilityFocused(obtain.isAccessibilityFocused());
            accessibilityNodeInfo.setSelected(obtain.isSelected());
            aYUAbz.A2egSU(obtain.getActions());
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.AZkASS(childAt)) {
                    accessibilityNodeInfo.addChild(childAt);
                }
            }
        }
        aYUAbz.AZkASS("androidx.drawerlayout.widget.DrawerLayout");
        accessibilityNodeInfo.setFocusable(false);
        accessibilityNodeInfo.setFocused(false);
        aYUAbz.AYUAbz(CQhlFr.A5SV6n.AMqCpz);
        aYUAbz.AYUAbz(CQhlFr.A5SV6n.f1757ARc23Z);
    }

    @Override // COJEAR.A4TApA
    public final boolean ARc23Z(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (DrawerLayout.f8616CikNvS || DrawerLayout.AZkASS(view)) {
            return this.f1615A2egSU.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        return false;
    }
}
