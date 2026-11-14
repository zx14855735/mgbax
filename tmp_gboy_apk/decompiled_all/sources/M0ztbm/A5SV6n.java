package M0ztbm;

import AZkASS.ARc23Z;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends ClickableSpan {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4971AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ com.game.boy.activity.A5SV6n f4972AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f4973AmA8tU;

    public /* synthetic */ A5SV6n(ARc23Z aRc23Z, com.game.boy.activity.A5SV6n a5SV6n, int i) {
        this.f4971AcNBzu = i;
        this.f4973AmA8tU = aRc23Z;
        this.f4972AlLFFp = a5SV6n;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        switch (this.f4971AcNBzu) {
            case 0:
                ARc23Z.BIYEnU(this.f4973AmA8tU, this.f4972AlLFFp, "https://gboy.top/agreement.html", "用户协议");
                break;
            case 1:
                ARc23Z.BIYEnU(this.f4973AmA8tU, this.f4972AlLFFp, "https://gboy.top/privacy.html", "隐私政策");
                break;
            default:
                ARc23Z.BIYEnU(this.f4973AmA8tU, this.f4972AlLFFp, "https://gboy.top/disclaimer.html", "免责声明");
                break;
        }
    }
}
