package Dphsd2;

import PWr3nF.B7CMnp;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.alliance.ssp.ad.activity.AppInfoViewActivity;
import com.fl.saas.base.inner.banner.BannerViewHelper;
import com.fl.saas.s2s.sdk.ad.S2STemplateViewHelper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A2egSU implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2427AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f2428AlLFFp;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f2427AcNBzu = i;
        this.f2428AlLFFp = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object obj = this.f2428AlLFFp;
        switch (this.f2427AcNBzu) {
            case 0:
                H0qugq.AZOQYO azoqyo = AppInfoViewActivity.f9605B2KMhB;
                ((A5SV6n) obj).A2egSU();
                return;
            case 1:
                H0qugq.AZOQYO azoqyo2 = AppInfoViewActivity.f9605B2KMhB;
                ((A5SV6n) obj).A2egSU();
                return;
            case 2:
                FSFw2u.AZkASS aZkASS = (FSFw2u.AZkASS) obj;
                aZkASS.getClass();
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                if (aZkASS.f2731HHLj6Q != 1 || aZkASS.f2724GnQT2j == 1) {
                    aZkASS.EH1KK8("user", 0, false);
                    return;
                }
                return;
            case 3:
                HFjH17.ARc23Z aRc23Z = (HFjH17.ARc23Z) obj;
                aRc23Z.getClass();
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                if (aRc23Z.f3319A2egSU == 1) {
                    aRc23Z.A5SV6n(0);
                    return;
                } else {
                    aRc23Z.A5SV6n(1);
                    return;
                }
            case 4:
                ((S2STemplateViewHelper) obj).lambda$addCloseView$1(view);
                return;
            case 5:
                PWr3nF.ADYaiT aDYaiT = (PWr3nF.ADYaiT) obj;
                EditText editText = aDYaiT.f7299AZOQYO;
                if (editText == null) {
                    return;
                }
                Editable text = editText.getText();
                if (text != null) {
                    text.clear();
                }
                aDYaiT.B2KMhB();
                return;
            case 6:
                ((PWr3nF.AZkASS) obj).B9tovu();
                return;
            case 7:
                B7CMnp b7CMnp = (B7CMnp) obj;
                EditText editText2 = b7CMnp.f7388ARc23Z;
                if (editText2 == null) {
                    return;
                }
                int selectionEnd = editText2.getSelectionEnd();
                EditText editText3 = b7CMnp.f7388ARc23Z;
                if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                    b7CMnp.f7388ARc23Z.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    b7CMnp.f7388ARc23Z.setTransformationMethod(null);
                }
                if (selectionEnd >= 0) {
                    b7CMnp.f7388ARc23Z.setSelection(selectionEnd);
                }
                b7CMnp.B2KMhB();
                return;
            case 8:
                ((BannerViewHelper) obj).lambda$new$0(view);
                return;
            default:
                ((com.google.android.material.datepicker.AmA8tU) obj).AcNBzu();
                throw null;
        }
    }
}
