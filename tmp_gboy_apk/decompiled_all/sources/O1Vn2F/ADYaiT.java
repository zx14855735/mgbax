package O1Vn2F;

import CQhlFr.ASJ6gh;
import CQhlFr.AYUAbz;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.datepicker.AlLFFp;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ int f6157ADYaiT;
    public final /* synthetic */ Object AMqCpz;

    public /* synthetic */ ADYaiT(int i, Object obj) {
        this.f6157ADYaiT = i;
        this.AMqCpz = obj;
    }

    @Override // COJEAR.A4TApA
    public void A5SV6n(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f6157ADYaiT) {
            case 3:
                super.A5SV6n(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.AMqCpz).f11688AzWtSf);
                break;
            default:
                super.A5SV6n(view, accessibilityEvent);
                break;
        }
    }

    @Override // COJEAR.A4TApA
    public void ADYaiT(View view, AYUAbz aYUAbz) {
        int i;
        Object obj = this.AMqCpz;
        View.AccessibilityDelegate accessibilityDelegate = this.f1615A2egSU;
        switch (this.f6157ADYaiT) {
            case 0:
                AccessibilityNodeInfo accessibilityNodeInfo = aYUAbz.f1773A2egSU;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                if (((com.google.android.material.bottomsheet.ADYaiT) obj).f11381B9tovu) {
                    aYUAbz.A2egSU(1048576);
                    accessibilityNodeInfo.setDismissable(true);
                    break;
                } else {
                    accessibilityNodeInfo.setDismissable(false);
                    break;
                }
            case 1:
            default:
                super.ADYaiT(view, aYUAbz);
                break;
            case 2:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, aYUAbz.f1773A2egSU);
                int i2 = MaterialButtonToggleGroup.f11487BTvldC;
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                if (view instanceof MaterialButton) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < materialButtonToggleGroup.getChildCount(); i4++) {
                        if (materialButtonToggleGroup.getChildAt(i4) == view) {
                            i = i3;
                            aYUAbz.AaHO0E(ASJ6gh.A2egSU(0, 1, i, 1, false, ((MaterialButton) view).f11471BNL6CD));
                            break;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i4) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i4).getVisibility() != 8) {
                                i3++;
                            }
                        }
                    }
                }
                i = -1;
                aYUAbz.AaHO0E(ASJ6gh.A2egSU(0, 1, i, 1, false, ((MaterialButton) view).f11471BNL6CD));
                break;
            case 3:
                AccessibilityNodeInfo accessibilityNodeInfo2 = aYUAbz.f1773A2egSU;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo2.setCheckable(checkableImageButton.f11689B25kr6);
                accessibilityNodeInfo2.setChecked(checkableImageButton.f11688AzWtSf);
                break;
            case 4:
                AccessibilityNodeInfo accessibilityNodeInfo3 = aYUAbz.f1773A2egSU;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                accessibilityNodeInfo3.setCheckable(((NavigationMenuItemView) obj).f11696CASmeH);
                break;
            case 5:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, aYUAbz.f1773A2egSU);
                AlLFFp alLFFp = (AlLFFp) obj;
                aYUAbz.A4TApA(new CQhlFr.A5SV6n(16, alLFFp.f11609BIYEnU.getVisibility() == 0 ? alLFFp.getString(2131886602) : alLFFp.getString(2131886600)));
                break;
        }
    }

    @Override // COJEAR.A4TApA
    public void AMqCpz(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f6157ADYaiT) {
            case 1:
                super.AMqCpz(view, accessibilityEvent);
                if (accessibilityEvent.getEventType() == 1) {
                    int i = BottomSheetDragHandleView.f11447B9tovu;
                    ((BottomSheetDragHandleView) this.AMqCpz).A2egSU();
                    break;
                }
                break;
            default:
                super.AMqCpz(view, accessibilityEvent);
                break;
        }
    }

    @Override // COJEAR.A4TApA
    public boolean ASJ6gh(View view, int i, Bundle bundle) {
        switch (this.f6157ADYaiT) {
            case 0:
                if (i == 1048576) {
                    com.google.android.material.bottomsheet.ADYaiT aDYaiT = (com.google.android.material.bottomsheet.ADYaiT) this.AMqCpz;
                    if (aDYaiT.f11381B9tovu) {
                        aDYaiT.cancel();
                        break;
                    }
                }
                break;
        }
        return super.ASJ6gh(view, i, bundle);
    }
}
