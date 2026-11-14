package MS6BTZ;

import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import com.game.boy.view.BiosFilePreference;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AZOQYO extends AlLFFp implements DRlcZ9.AlLFFp {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public androidx.activity.result.A5SV6n f5171B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public BiosFilePreference f5172B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public BiosFilePreference f5173BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public BiosFilePreference f5174BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public BiosFilePreference f5175BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final String[] f5176BJ7GGh = {".png", ".jpg", ".jpeg", ".gif", ".webp"};

    @Override // DRlcZ9.AlLFFp
    public final boolean A2egSU(Preference preference, Serializable serializable) {
        return false;
    }

    @Override // MS6BTZ.AlLFFp
    public final int B25kr6() {
        return 2132082711;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        BiosFilePreference biosFilePreference = this.f5173BChYOn;
        if (biosFilePreference != null) {
            biosFilePreference.BpkvW3();
        }
        BiosFilePreference biosFilePreference2 = this.f5172B9tovu;
        if (biosFilePreference2 != null) {
            biosFilePreference2.BpkvW3();
        }
    }

    @Override // DRlcZ9.B4ZgIw, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5171B7CMnp = registerForActivityResult(new A4TApA.ADYaiT(), new AMqCpz(this, 2));
        BiosFilePreference biosFilePreference = (BiosFilePreference) AZkASS("landscape_background_image");
        this.f5172B9tovu = biosFilePreference;
        String[] strArr = this.f5176BJ7GGh;
        biosFilePreference.f11126D8MqeW = strArr;
        biosFilePreference.f9082B2KMhB = new AMqCpz(this, 0);
        BiosFilePreference biosFilePreference2 = (BiosFilePreference) AZkASS("portrait_background_image");
        this.f5173BChYOn = biosFilePreference2;
        biosFilePreference2.f11126D8MqeW = strArr;
        biosFilePreference2.f9082B2KMhB = new ARc23Z(this, 0);
        BiosFilePreference biosFilePreference3 = (BiosFilePreference) AZkASS("icon_pack_path");
        this.f5175BIYEnU = biosFilePreference3;
        biosFilePreference3.f11126D8MqeW = new String[]{".zip"};
        biosFilePreference3.f9082B2KMhB = new AMqCpz(this, 1);
        AZkASS("backColor").f9082B2KMhB = new ARc23Z(this, 1);
    }
}
