package PMC23c;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends com.bumptech.glide.A5SV6n {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final /* synthetic */ int f7163B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final SideSheetBehavior f7164B7CMnp;

    public /* synthetic */ A2egSU(SideSheetBehavior sideSheetBehavior, int i) {
        this.f7163B4ZgIw = i;
        this.f7164B7CMnp = sideSheetBehavior;
    }

    @Override // com.bumptech.glide.A5SV6n
    public final int AzWtSf(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f7163B4ZgIw) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final float B25kr6(int i) {
        switch (this.f7163B4ZgIw) {
            case 0:
                float BJ7GGh2 = BJ7GGh();
                return (i - BJ7GGh2) / (BIYEnU() - BJ7GGh2);
            default:
                float f = this.f7164B7CMnp.f11800BIYEnU;
                return (f - i) / (f - BIYEnU());
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final int B9tovu(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f7163B4ZgIw) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final int BIYEnU() {
        switch (this.f7163B4ZgIw) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f7164B7CMnp;
                return Math.max(0, sideSheetBehavior.f11801BJ7GGh + sideSheetBehavior.f11802BNL6CD);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.f7164B7CMnp;
                return Math.max(0, (sideSheetBehavior2.f11800BIYEnU - sideSheetBehavior2.f11799BI9f7h) - sideSheetBehavior2.f11802BNL6CD);
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final int BJ7GGh() {
        switch (this.f7163B4ZgIw) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f7164B7CMnp;
                return (-sideSheetBehavior.f11799BI9f7h) - sideSheetBehavior.f11802BNL6CD;
            default:
                return this.f7164B7CMnp.f11800BIYEnU;
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final int BV3sI0() {
        switch (this.f7163B4ZgIw) {
            case 0:
                return this.f7164B7CMnp.f11802BNL6CD;
            default:
                return this.f7164B7CMnp.f11800BIYEnU;
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final int BmvVmW() {
        switch (this.f7163B4ZgIw) {
            case 0:
                return -this.f7164B7CMnp.f11799BI9f7h;
            default:
                return BIYEnU();
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final int BniPrB(View view) {
        switch (this.f7163B4ZgIw) {
            case 0:
                return view.getRight() + this.f7164B7CMnp.f11802BNL6CD;
            default:
                return view.getLeft() - this.f7164B7CMnp.f11802BNL6CD;
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final int BpkvW3(CoordinatorLayout coordinatorLayout) {
        switch (this.f7163B4ZgIw) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final int C2rE4F() {
        switch (this.f7163B4ZgIw) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final boolean CSDoyG(float f) {
        switch (this.f7163B4ZgIw) {
            case 0:
                if (f > 0.0f) {
                }
                break;
            default:
                if (f < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // com.bumptech.glide.A5SV6n
    public final boolean CcAIMM(View view) {
        switch (this.f7163B4ZgIw) {
            case 0:
                if (view.getRight() < (BIYEnU() - BJ7GGh()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (BIYEnU() + this.f7164B7CMnp.f11800BIYEnU) / 2) {
                }
                break;
        }
        return false;
    }

    @Override // com.bumptech.glide.A5SV6n
    public final boolean Cd8JRx(float f, float f2) {
        switch (this.f7163B4ZgIw) {
            case 0:
                if (Math.abs(f) > Math.abs(f2)) {
                    float abs = Math.abs(f);
                    this.f7164B7CMnp.getClass();
                    if (abs > 500) {
                    }
                }
                break;
            default:
                if (Math.abs(f) > Math.abs(f2)) {
                    float abs2 = Math.abs(f);
                    this.f7164B7CMnp.getClass();
                    if (abs2 > 500) {
                    }
                }
                break;
        }
        return false;
    }

    @Override // com.bumptech.glide.A5SV6n
    public final boolean DRlcZ9(View view, float f) {
        switch (this.f7163B4ZgIw) {
            case 0:
                float left = view.getLeft();
                SideSheetBehavior sideSheetBehavior = this.f7164B7CMnp;
                float abs = Math.abs((f * sideSheetBehavior.f11798BChYOn) + left);
                sideSheetBehavior.getClass();
                if (abs > 0.5f) {
                }
                break;
            default:
                float right = view.getRight();
                SideSheetBehavior sideSheetBehavior2 = this.f7164B7CMnp;
                float abs2 = Math.abs((f * sideSheetBehavior2.f11798BChYOn) + right);
                sideSheetBehavior2.getClass();
                if (abs2 > 0.5f) {
                }
                break;
        }
        return false;
    }

    @Override // com.bumptech.glide.A5SV6n
    public final void Ddcejp(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        switch (this.f7163B4ZgIw) {
            case 0:
                marginLayoutParams.leftMargin = i;
                break;
            default:
                marginLayoutParams.rightMargin = i;
                break;
        }
    }

    @Override // com.bumptech.glide.A5SV6n
    public final void De4eam(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        switch (this.f7163B4ZgIw) {
            case 0:
                if (i <= this.f7164B7CMnp.f11800BIYEnU) {
                    marginLayoutParams.leftMargin = i2;
                    break;
                }
                break;
            default:
                int i3 = this.f7164B7CMnp.f11800BIYEnU;
                if (i <= i3) {
                    marginLayoutParams.rightMargin = i3 - i;
                    break;
                }
                break;
        }
    }
}
