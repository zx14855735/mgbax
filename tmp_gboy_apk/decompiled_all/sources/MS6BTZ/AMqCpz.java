package MS6BTZ;

import android.content.Intent;
import android.net.Uri;
import androidx.preference.Preference;
import com.game.boy.view.BiosFilePreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements DRlcZ9.AmA8tU, androidx.activity.result.A4TApA {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5164AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f5165AlLFFp;

    public /* synthetic */ AMqCpz(AZOQYO azoqyo, int i) {
        this.f5164AcNBzu = i;
        this.f5165AlLFFp = azoqyo;
    }

    @Override // androidx.activity.result.A4TApA
    public void A5SV6n(Object obj) {
        Intent intent;
        Uri data;
        androidx.activity.result.A2egSU a2egSU = (androidx.activity.result.A2egSU) obj;
        int i = a2egSU.f7990AcNBzu;
        AZOQYO azoqyo = this.f5165AlLFFp;
        if (i == -1 && (intent = a2egSU.f7991AlLFFp) != null && (data = intent.getData()) != null) {
            try {
                azoqyo.getActivity().getContentResolver().takePersistableUriPermission(data, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            BiosFilePreference biosFilePreference = azoqyo.f5174BI9f7h;
            if (biosFilePreference != null) {
                biosFilePreference.BniPrB(data);
                azoqyo.f5174BI9f7h.BpkvW3();
            }
        }
        azoqyo.f5174BI9f7h = null;
    }

    @Override // DRlcZ9.AmA8tU
    public boolean AaHO0E(Preference preference) {
        switch (this.f5164AcNBzu) {
            case 0:
                AZOQYO azoqyo = this.f5165AlLFFp;
                azoqyo.f5174BI9f7h = azoqyo.f5172B9tovu;
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("image/*");
                azoqyo.f5171B7CMnp.A2egSU(intent);
                break;
            default:
                AZOQYO azoqyo2 = this.f5165AlLFFp;
                azoqyo2.f5174BI9f7h = azoqyo2.f5175BIYEnU;
                Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent2.addCategory("android.intent.category.OPENABLE");
                intent2.setType("application/zip");
                azoqyo2.f5171B7CMnp.A2egSU(intent2);
                break;
        }
        return true;
    }
}
