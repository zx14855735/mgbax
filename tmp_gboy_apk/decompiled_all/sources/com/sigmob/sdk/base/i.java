package com.sigmob.sdk.base;

import android.content.Context;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobPrivacy;
import com.sigmob.sdk.base.mta.PointType;
import com.sigmob.sdk.base.utils.s;
import com.sigmob.windad.consent.WindAdConsentInformation;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i {
    private static i e;
    private int b;
    private int d;
    private boolean f;
    private int g;
    private Boolean h;

    /* renamed from: a, reason: collision with root package name */
    private boolean f13175a = true;
    private boolean c = true;

    private i() {
        Context e2 = com.sigmob.sdk.b.e();
        this.b = s.a(e2, (String) null, Constants.AGE_RESTRICTED_STATUS, 0);
        this.d = s.a(e2, (String) null, Constants.USER_AGE, 0);
        this.g = s.a(e2, (String) null, Constants.GDPR_CONSENT_STATUS, 0);
        this.f = s.a(e2, (String) null, Constants.EXT_GDPR_REGION, false);
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            try {
                if (e == null) {
                    synchronized (i.class) {
                        e = new i();
                    }
                }
                iVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    private void j() {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setUser_consent(String.valueOf(g()));
        boolean h = h();
        String str = Constants.FAIL;
        pointEntitySigmobPrivacy.setGdpr_region(h ? "1" : Constants.FAIL);
        try {
            if (WindAdConsentInformation.getInstance(com.sigmob.sdk.b.e()).isRequestLocationInEeaOrUnknown()) {
                str = "1";
            }
            pointEntitySigmobPrivacy.setGdpr_dialog_region(str);
        } catch (Throwable unused) {
        }
        pointEntitySigmobPrivacy.setSub_category(PointCategory.CONSENT);
        pointEntitySigmobPrivacy.setCategory("gdpr");
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.commit();
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.f13175a;
    }

    public boolean e() {
        return this.c;
    }

    public boolean f() {
        Boolean bool = this.h;
        return bool == null || bool.booleanValue() != this.c;
    }

    public int g() {
        return this.g;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return g() == 1 || !h();
    }

    private void a(int i) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAge(String.valueOf(i));
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category("coppa");
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.commit();
    }

    private void b(int i) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAge_restricted(String.valueOf(i));
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category("coppa");
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.commit();
    }

    public void c(int i, boolean z) {
        this.g = i;
        s.b(com.sigmob.sdk.b.e(), (String) null, Constants.GDPR_CONSENT_STATUS, i);
        if (z) {
            j();
        }
    }

    public void a(int i, boolean z) {
        this.d = i;
        s.b(com.sigmob.sdk.b.e(), (String) null, Constants.USER_AGE, this.d);
        if (z) {
            a(i);
        }
    }

    public void b(int i, boolean z) {
        this.b = i;
        s.b(com.sigmob.sdk.b.e(), (String) null, Constants.AGE_RESTRICTED_STATUS, this.b);
        if (z) {
            b(i);
        }
    }

    private void b(boolean z) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category(PointCategory.PERSONALIZED);
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.setIs_unpersonalized(z ? Constants.FAIL : "1");
        pointEntitySigmobPrivacy.commit();
    }

    public void a(Boolean bool) {
        if (bool != null) {
            s.b(com.sigmob.sdk.b.e(), (String) null, Constants.EXT_GDPR_REGION, bool.booleanValue());
            this.f = bool.booleanValue();
        }
        if (i()) {
            j();
            b(this.c);
            a(this.f13175a);
            b(this.b);
            a(this.d);
        }
    }

    private void a(boolean z) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category(PointCategory.ADULT);
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.setIs_minor(z ? Constants.FAIL : "1");
        pointEntitySigmobPrivacy.commit();
    }

    public void b(boolean z, boolean z2) {
        if (this.h == null) {
            this.h = Boolean.valueOf(z);
        }
        SigmobLog.i("PrivacyManager -> setPersonalized " + z);
        this.c = z;
        if (z2) {
            b(z);
        }
    }

    public void a(boolean z, boolean z2) {
        SigmobLog.i("PrivacyManager -> setAdult " + z);
        this.f13175a = z;
        if (z2) {
            a(z);
        }
    }
}
