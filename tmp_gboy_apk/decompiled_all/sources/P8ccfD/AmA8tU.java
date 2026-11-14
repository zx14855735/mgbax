package P8ccfD;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.EditText;
import androidx.recyclerview.widget.BJ7GGh;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.search.SearchBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6986A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f6987A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ Object f6988A5SV6n;

    public AmA8tU(AzWtSf azWtSf, boolean z) {
        this.f6986A2egSU = 0;
        this.f6988A5SV6n = azWtSf;
        this.f6987A4TApA = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f6986A2egSU) {
            case 1:
                this.f6987A4TApA = true;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Object obj = this.f6988A5SV6n;
        switch (this.f6986A2egSU) {
            case 0:
                boolean z = this.f6987A4TApA;
                AzWtSf azWtSf = (AzWtSf) obj;
                AzWtSf.A2egSU(azWtSf, z ? 1.0f : 0.0f);
                EditText editText = azWtSf.f6997AZkASS;
                editText.setAlpha(1.0f);
                SearchBar searchBar = azWtSf.f7003B25kr6;
                if (searchBar != null) {
                    searchBar.getTextView().setAlpha(1.0f);
                }
                editText.setClipBounds(null);
                ClippableRoundedCornerLayout clippableRoundedCornerLayout = azWtSf.f6991A5SV6n;
                clippableRoundedCornerLayout.f11691AcNBzu = null;
                clippableRoundedCornerLayout.f11692AlLFFp = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                clippableRoundedCornerLayout.invalidate();
                if (!z) {
                    azWtSf.f7001AmA8tU.f6652AcNBzu = null;
                    break;
                }
                break;
            default:
                if (!this.f6987A4TApA) {
                    BJ7GGh bJ7GGh = (BJ7GGh) obj;
                    if (((Float) bJ7GGh.f9274BNL6CD.getAnimatedValue()).floatValue() != 0.0f) {
                        bJ7GGh.f9275BPw6Q8 = 2;
                        bJ7GGh.f9267B4ZgIw.invalidate();
                        break;
                    } else {
                        bJ7GGh.f9275BPw6Q8 = 0;
                        bJ7GGh.ADYaiT(0);
                        break;
                    }
                } else {
                    this.f6987A4TApA = false;
                    break;
                }
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f6986A2egSU) {
            case 0:
                AzWtSf.A2egSU((AzWtSf) this.f6988A5SV6n, this.f6987A4TApA ? 0.0f : 1.0f);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public AmA8tU(BJ7GGh bJ7GGh) {
        this.f6986A2egSU = 1;
        this.f6988A5SV6n = bJ7GGh;
        this.f6987A4TApA = false;
    }
}
