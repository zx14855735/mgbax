package com.game.boy.activity;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.CtxOCS;
import androidx.preference.ListPreference;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.game.boy.viewUi.MaterialEditTextPreference;
import com.game.boy.viewUi.MaterialListPreference;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class EditCheatActivity extends A5SV6n {

    /* renamed from: B25kr6, reason: collision with root package name */
    public MaterialListPreference f10980B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public MaterialEditTextPreference f10981B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public MaterialEditTextPreference f10982B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f10983B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f10984B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public String f10985B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public String f10986BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public String f10987BI9f7h;

    public static class A2egSU extends DRlcZ9.B4ZgIw {
        @Override // DRlcZ9.B4ZgIw
        public final void AlLFFp(String str) {
            AzWtSf(2132082702, str);
            EditCheatActivity editCheatActivity = (EditCheatActivity) getActivity();
            editCheatActivity.f10980B25kr6 = (MaterialListPreference) AZkASS("cheatType");
            editCheatActivity.f10981B2KMhB = (MaterialEditTextPreference) AZkASS("cheatName");
            editCheatActivity.f10982B3GDIM = (MaterialEditTextPreference) AZkASS("cheatCode");
            MaterialListPreference materialListPreference = editCheatActivity.f10980B25kr6;
            if (materialListPreference != null) {
                String str2 = editCheatActivity.f10985B9tovu;
                materialListPreference.BpkvW3 = str2;
                materialListPreference.BpkvW3(str2);
                B25kr6(editCheatActivity.f10980B25kr6, editCheatActivity.f10985B9tovu);
                editCheatActivity.f10980B25kr6.f9081B25kr6 = new AYUAbz(this, editCheatActivity);
            }
            MaterialEditTextPreference materialEditTextPreference = editCheatActivity.f10981B2KMhB;
            if (materialEditTextPreference != null) {
                materialEditTextPreference.BmvVmW(editCheatActivity.f10986BChYOn);
                MaterialEditTextPreference materialEditTextPreference2 = editCheatActivity.f10981B2KMhB;
                String str3 = editCheatActivity.f10986BChYOn;
                materialEditTextPreference2.BNL6CD((str3 == null || str3.isEmpty()) ? getString(2131886314) : editCheatActivity.f10986BChYOn);
                editCheatActivity.f10981B2KMhB.f9081B25kr6 = new AZOQYO(this, editCheatActivity);
            }
            MaterialEditTextPreference materialEditTextPreference3 = editCheatActivity.f10982B3GDIM;
            if (materialEditTextPreference3 != null) {
                materialEditTextPreference3.BmvVmW(editCheatActivity.f10987BI9f7h);
                MaterialEditTextPreference materialEditTextPreference4 = editCheatActivity.f10982B3GDIM;
                String str4 = editCheatActivity.f10987BI9f7h;
                materialEditTextPreference4.BNL6CD((str4 == null || str4.isEmpty()) ? getString(2131886314) : editCheatActivity.f10987BI9f7h);
                editCheatActivity.f10982B3GDIM.f9081B25kr6 = new AZkASS(this, editCheatActivity);
            }
        }

        public final void B25kr6(ListPreference listPreference, String str) {
            String[] stringArray = getResources().getStringArray(2130903043);
            int indexOf = Arrays.asList(getResources().getStringArray(2130903044)).indexOf(str);
            if (indexOf != -1) {
                listPreference.BNL6CD(stringArray[indexOf]);
            } else {
                listPreference.BNL6CD("自动检测");
            }
        }
    }

    public static boolean AYUAbz(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && (charAt < 'A' || charAt > 'F')) {
                return false;
            }
        }
        return true;
    }

    public static String[] AZOQYO(int i, String str) {
        String nextToken;
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken2 = stringTokenizer.nextToken();
            if (nextToken2.length() == 8 + i) {
                nextToken = nextToken2.substring(8);
                nextToken2 = nextToken2.substring(0, 8);
            } else {
                if (nextToken2.length() != 8 || !stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                nextToken = stringTokenizer.nextToken();
                if (nextToken.length() != i) {
                    return null;
                }
            }
            Locale locale = Locale.ROOT;
            String upperCase = nextToken2.toUpperCase(locale);
            String upperCase2 = nextToken.toUpperCase(locale);
            if (!AYUAbz(upperCase) || !AYUAbz(upperCase2)) {
                return null;
            }
            arrayList.add(upperCase + " " + upperCase2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static String[] AZkASS(String str) {
        String nextToken;
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken2 = stringTokenizer.nextToken();
            switch (nextToken2.length()) {
                case 8:
                    if (!stringTokenizer.hasMoreTokens()) {
                        return null;
                    }
                    nextToken = stringTokenizer.nextToken();
                    if (nextToken.length() != 2 && nextToken.length() != 4 && nextToken.length() != 8) {
                        return null;
                    }
                    break;
                case 9:
                case 14:
                case 15:
                default:
                    return null;
                case 10:
                case 12:
                case 16:
                    nextToken = nextToken2.substring(8);
                    nextToken2 = nextToken2.substring(0, 8);
                    break;
                case 11:
                case 13:
                case 17:
                    if (nextToken2.charAt(8) == ':') {
                        nextToken = nextToken2.substring(9);
                        nextToken2 = nextToken2.substring(0, 8);
                        break;
                    } else {
                        return null;
                    }
            }
            if (nextToken == null) {
                return null;
            }
            Locale locale = Locale.ROOT;
            String upperCase = nextToken2.toUpperCase(locale);
            String upperCase2 = nextToken.toUpperCase(locale);
            if (!AYUAbz(upperCase) || !AYUAbz(upperCase2)) {
                return null;
            }
            arrayList.add(upperCase + " " + upperCase2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e A[Catch: Exception -> 0x0063, TRY_LEAVE, TryCatch #0 {Exception -> 0x0063, blocks: (B:2:0x0000, B:16:0x004c, B:19:0x0051, B:21:0x0057, B:23:0x005e, B:25:0x001b, B:28:0x0025, B:31:0x002f, B:34:0x0039), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] AcNBzu(java.lang.String r5, java.lang.String r6) {
        /*
            int r0 = r6.hashCode()     // Catch: java.lang.Exception -> L63
            r1 = 3167(0xc5f, float:4.438E-42)
            r2 = 3
            r3 = 1
            r4 = 2
            if (r0 == r1) goto L39
            r1 = 102597(0x190c5, float:1.43769E-40)
            if (r0 == r1) goto L2f
            r1 = 102599(0x190c7, float:1.43772E-40)
            if (r0 == r1) goto L25
            r1 = 112680(0x1b828, float:1.57898E-40)
            if (r0 == r1) goto L1b
            goto L43
        L1b:
            java.lang.String r0 = "raw"
            boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L63
            if (r6 == 0) goto L43
            r6 = 0
            goto L44
        L25:
            java.lang.String r0 = "gs3"
            boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L63
            if (r6 == 0) goto L43
            r6 = 2
            goto L44
        L2f:
            java.lang.String r0 = "gs1"
            boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L63
            if (r6 == 0) goto L43
            r6 = 1
            goto L44
        L39:
            java.lang.String r0 = "cb"
            boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L63
            if (r6 == 0) goto L43
            r6 = 3
            goto L44
        L43:
            r6 = -1
        L44:
            if (r6 == 0) goto L5e
            if (r6 == r3) goto L57
            if (r6 == r4) goto L57
            if (r6 == r2) goto L51
            java.lang.String[] r5 = AZkASS(r5)     // Catch: java.lang.Exception -> L63
            return r5
        L51:
            r6 = 4
            java.lang.String[] r5 = AZOQYO(r6, r5)     // Catch: java.lang.Exception -> L63
            return r5
        L57:
            r6 = 8
            java.lang.String[] r5 = AZOQYO(r6, r5)     // Catch: java.lang.Exception -> L63
            return r5
        L5e:
            java.lang.String[] r5 = AZkASS(r5)     // Catch: java.lang.Exception -> L63
            return r5
        L63:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.EditCheatActivity.AcNBzu(java.lang.String, java.lang.String):java.lang.String[]");
    }

    public final void AaHO0E() {
        String[] AcNBzu2;
        String str = this.f10981B2KMhB.f9069DRlcZ9;
        String str2 = this.f10982B3GDIM.f9069DRlcZ9;
        String str3 = this.f10980B25kr6.f9072DV2E8K;
        if (str2 == null || str2.isEmpty()) {
            finish();
            return;
        }
        String[] strArr = {"raw", "gs1", "gs3", "cb"};
        if (str3.equals(LiveConfigKey.AUTO)) {
            int i = 0;
            AcNBzu2 = null;
            while (true) {
                if (i < 4) {
                    String str4 = strArr[i];
                    String[] AcNBzu3 = AcNBzu(str2, str4);
                    if (AcNBzu3 != null && AcNBzu3.length > 0) {
                        str3 = str4;
                        AcNBzu2 = AcNBzu3;
                        break;
                    } else {
                        i++;
                        AcNBzu2 = AcNBzu3;
                    }
                } else {
                    break;
                }
            }
            if (AcNBzu2 == null || AcNBzu2.length == 0) {
                AcNBzu2 = AZkASS(str2);
                str3 = "raw";
            }
        } else {
            AcNBzu2 = AcNBzu(str2, str3);
        }
        if (AcNBzu2 == null || AcNBzu2.length == 0) {
            OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
            a4TApA.B2KMhB(2131886295);
            a4TApA.AZOQYO(2131886173);
            a4TApA.AmA8tU(R.string.ok, null);
            a4TApA.AcNBzu("退出", new DRlcZ9.ASJ6gh(11, this));
            a4TApA.AMqCpz();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("cheatIndex", this.f10983B4ZgIw);
        intent.putExtra("cheatType", str3);
        intent.putExtra("cheatName", str);
        intent.putExtra("cheatCode", AcNBzu2);
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        AaHO0E();
        super.onBackPressed();
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(2131492896);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        int intExtra = getIntent().getIntExtra("cheatIndex", -1);
        this.f10983B4ZgIw = intExtra;
        materialToolbar.setTitle(intExtra >= 0 ? 2131886281 : 2131886622);
        setSupportActionBar(materialToolbar);
        getSupportActionBar().AmA8tU();
        getSupportActionBar().AlLFFp(true);
        materialToolbar.setNavigationIcon(2131230963);
        materialToolbar.setNavigationOnClickListener(new ADYaiT.A5SV6n(18, this));
        if (bundle != null) {
            this.f10984B7CMnp = bundle.getBoolean("cheatModified");
            this.f10985B9tovu = bundle.getString("cheatType");
            this.f10986BChYOn = bundle.getString("cheatName");
            this.f10987BI9f7h = bundle.getString("cheatCode");
        } else if (this.f10983B4ZgIw >= 0) {
            this.f10985B9tovu = getIntent().getStringExtra("cheatType");
            this.f10986BChYOn = getIntent().getStringExtra("cheatName");
            String[] stringArrayExtra = getIntent().getStringArrayExtra("cheatCode");
            if (stringArrayExtra == null || stringArrayExtra.length == 0) {
                str = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(stringArrayExtra[0]);
                for (int i = 1; i < stringArrayExtra.length; i++) {
                    sb.append("\n");
                    sb.append(stringArrayExtra[i]);
                }
                str = sb.toString();
            }
            this.f10987BI9f7h = str;
            this.f10984B7CMnp = false;
        } else {
            this.f10984B7CMnp = true;
            this.f10985B9tovu = LiveConfigKey.AUTO;
        }
        CtxOCS supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(supportFragmentManager);
        a2egSU.AlLFFp(2131297767, new A2egSU(), null);
        a2egSU.B2KMhB(false);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131623948, menu);
        return true;
    }

    @Override // ADYaiT.B2KMhB, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        AaHO0E();
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131297626) {
            AaHO0E();
            return true;
        }
        if (itemId != 2131297591) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("cheatModified", this.f10984B7CMnp);
        bundle.putString("cheatType", this.f10985B9tovu);
        bundle.putString("cheatName", this.f10986BChYOn);
        bundle.putString("cheatCode", this.f10987BI9f7h);
    }
}
