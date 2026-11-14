package OLvDpK;

import android.R;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends CqNSpT.A4TApA {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final /* synthetic */ Chip f6276B2KMhB;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ADYaiT(Chip chip, Chip chip2) {
        super(chip2);
        this.f6276B2KMhB = chip;
    }

    @Override // CqNSpT.A4TApA
    public final int AmA8tU(float f, float f2) {
        RectF closeIconTouchBounds;
        Rect rect = Chip.f11546CASmeH;
        Chip chip = this.f6276B2KMhB;
        if (!chip.ADYaiT()) {
            return 0;
        }
        closeIconTouchBounds = chip.getCloseIconTouchBounds();
        return closeIconTouchBounds.contains(f, f2) ? 1 : 0;
    }

    @Override // CqNSpT.A4TApA
    public final void AzWtSf(ArrayList arrayList) {
        ARc23Z aRc23Z;
        arrayList.add(0);
        Rect rect = Chip.f11546CASmeH;
        Chip chip = this.f6276B2KMhB;
        if (!chip.ADYaiT() || (aRc23Z = chip.f11549B25kr6) == null || !aRc23Z.f6292DRlcZ9 || chip.f11552B4ZgIw == null) {
            return;
        }
        arrayList.add(1);
    }

    @Override // CqNSpT.A4TApA
    public final boolean B4ZgIw(int i, int i2, Bundle bundle) {
        boolean z = false;
        if (i2 == 16) {
            Chip chip = this.f6276B2KMhB;
            if (i == 0) {
                return chip.performClick();
            }
            if (i == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.f11552B4ZgIw;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z = true;
                }
                if (chip.f11564BniPrB) {
                    chip.f11563BmvVmW.BIYEnU(1, 1);
                }
            }
        }
        return z;
    }

    @Override // CqNSpT.A4TApA
    public final void B7CMnp(CQhlFr.AYUAbz aYUAbz) {
        Chip chip = this.f6276B2KMhB;
        ARc23Z aRc23Z = chip.f11549B25kr6;
        boolean z = aRc23Z != null && aRc23Z.f6297DcUJf1;
        AccessibilityNodeInfo accessibilityNodeInfo = aYUAbz.f1773A2egSU;
        accessibilityNodeInfo.setCheckable(z);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        aYUAbz.AZkASS(chip.getAccessibilityClassName());
        CharSequence text = chip.getText();
        if (Build.VERSION.SDK_INT >= 23) {
            aYUAbz.AmA8tU(text);
        } else {
            aYUAbz.AcNBzu(text);
        }
    }

    @Override // CqNSpT.A4TApA
    public final void B9tovu(int i, CQhlFr.AYUAbz aYUAbz) {
        Rect closeIconTouchBoundsInt;
        AccessibilityNodeInfo accessibilityNodeInfo = aYUAbz.f1773A2egSU;
        if (i != 1) {
            aYUAbz.AcNBzu("");
            accessibilityNodeInfo.setBoundsInParent(Chip.f11546CASmeH);
            return;
        }
        Chip chip = this.f6276B2KMhB;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            aYUAbz.AcNBzu(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            aYUAbz.AcNBzu(chip.getContext().getString(2131886563, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        closeIconTouchBoundsInt = chip.getCloseIconTouchBoundsInt();
        accessibilityNodeInfo.setBoundsInParent(closeIconTouchBoundsInt);
        aYUAbz.A4TApA(CQhlFr.A5SV6n.f1758ASJ6gh);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
        aYUAbz.AZkASS(Button.class.getName());
    }

    @Override // CqNSpT.A4TApA
    public final void BChYOn(int i, boolean z) {
        Chip chip = this.f6276B2KMhB;
        if (i == 1) {
            chip.f11558BJ7GGh = z;
        }
        ARc23Z aRc23Z = chip.f11549B25kr6;
        boolean z2 = chip.f11558BJ7GGh;
        boolean z3 = false;
        if (aRc23Z.f6293DUi7mC != null) {
            z3 = aRc23Z.D8cQ8b(z2 ? new int[]{R.attr.state_pressed, R.attr.state_enabled} : ARc23Z.f6277G58fqA);
        }
        if (z3) {
            chip.refreshDrawableState();
        }
    }
}
