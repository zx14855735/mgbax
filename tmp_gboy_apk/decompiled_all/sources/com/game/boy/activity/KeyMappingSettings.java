package com.game.boy.activity;

import ADYaiT.CtFAbx;
import android.R;
import android.app.Dialog;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.CtxOCS;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.game.boy.view.KeyMappingPreference;
import com.google.android.material.appbar.MaterialToolbar;
import com.kuaishou.weapon.p0.t;
import com.qq.e.comm.adevent.AdEventType;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KeyMappingSettings extends A5SV6n implements DRlcZ9.AlLFFp {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static boolean f11040B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final int[] f11041B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final int[] f11042B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final int[] f11043BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final int[] f11044BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final int[] f11045BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public static final String[] f11046BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public static final int[] f11047BNL6CD;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f11048B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public File f11049B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final KeyMappingPreference[] f11050B3GDIM = new KeyMappingPreference[31];

    static {
        int[] iArr = {32, 16, 64, r.b.d, 4, 8, 1, 2, 512, 256, f.a.c, ProxyCacheUtils.DEFAULT_BUFFER_SIZE, f.a.d, 32768, 96, 80, 160, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 3, 768, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_ID, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE, 257, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 1024, 65536, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 262144, 772, 524288, 1048576};
        f11041B7CMnp = iArr;
        String[] strArr = {"left", "right", "up", "down", "select", "start", t.f, t.l, "tl", "tr", "turbo_a", "turbo_b", "turbo_tl", "turbo_tr", "up+left", "up+right", "down+left", "down+right", "a+b", "tl+tr", "tl+a", "tl+b", "tr+a", "tr+b", "gs", "load", "save", "ff", "rewind", "ss", "menu"};
        f11046BJ7GGh = strArr;
        int[] iArr2 = {21, 22, 19, 20, AdEventType.AD_RENDER_SUCCESS, 108, 96, 97, 102, 103, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 82};
        f11044BI9f7h = iArr2;
        int[] iArr3 = {21, 22, 19, 20, AdEventType.AD_RENDER_SUCCESS, 108, 4, 23, 102, 103, 100, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 82};
        f11045BIYEnU = iArr3;
        int[] iArr4 = {2131886406, 2131886411, 2131886419, 2131886403, 2131886412, 2131886413, 2131886392, 2131886394, 2131886396, 2131886400, 2131886414, 2131886415, 2131886416, 2131886417, 2131886420, 2131886421, 2131886404, 2131886405, 2131886393, 2131886399, 2131886397, 2131886398, 2131886401, 2131886402, 2131886395, 2131886694, 2131886695, 2131886307, 2131886722, 2131886739, 2131886409};
        f11047BNL6CD = iArr4;
        f11043BChYOn = new int[]{2131887023, 2131886188, 2131886174, 2131886779};
        f11042B9tovu = new int[]{10, 14, 24, 25, iArr.length};
        int length = iArr.length;
        if (iArr2.length != length || iArr3.length != length || strArr.length != length || iArr4.length != length) {
            throw new AssertionError("Key configurations are not consistent");
        }
    }

    public static File AYUAbz(String str) {
        return new File(KpHwm4.AYUAbz.A2egSU("config/keymap"), Uri.encode(str) + ".xml");
    }

    public static int[] AZkASS(File file) {
        int[] iArr = null;
        try {
            int[] AaHO0E2 = AaHO0E();
            int length = AaHO0E2.length;
            int[] iArr2 = new int[length];
            try {
                System.arraycopy(AaHO0E2, 0, iArr2, 0, length);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(bufferedInputStream, "UTF-8");
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    if (eventType == 2 && "key".equals(newPullParser.getName())) {
                        String attributeValue = newPullParser.getAttributeValue(null, "name");
                        int i = 0;
                        while (true) {
                            if (i >= 31) {
                                i = -1;
                                break;
                            }
                            if (f11046BJ7GGh[i].equals(attributeValue)) {
                                break;
                            }
                            i++;
                        }
                        if (i >= 0) {
                            try {
                                iArr2[i] = Integer.parseInt(newPullParser.nextText());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
                bufferedInputStream.close();
                return iArr2;
            } catch (Exception e) {
                e = e;
                iArr = iArr2;
                e.printStackTrace();
                return iArr;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static int[] AaHO0E() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(" - ");
        sb.append(Build.DEVICE);
        return sb.toString().startsWith("Sony Ericsson - R800") ? f11045BIYEnU : f11044BI9f7h;
    }

    @Override // DRlcZ9.AlLFFp
    public final boolean A2egSU(Preference preference, Serializable serializable) {
        this.f11048B25kr6 = true;
        f11040B4ZgIw = true;
        return true;
    }

    public final void AZOQYO(PreferenceGroup preferenceGroup, int i, int i2) {
        while (i < i2) {
            KeyMappingPreference keyMappingPreference = new KeyMappingPreference(this, null);
            this.f11050B3GDIM[i] = keyMappingPreference;
            keyMappingPreference.BPw6Q8(f11047BNL6CD[i]);
            keyMappingPreference.f9081B25kr6 = this;
            String ARc23Z2 = CtFAbx.ARc23Z(i, "preference_key_");
            keyMappingPreference.f9088BI9f7h = ARc23Z2;
            if (keyMappingPreference.f9094BV3sI0 && TextUtils.isEmpty(ARc23Z2)) {
                if (TextUtils.isEmpty(keyMappingPreference.f9088BI9f7h)) {
                    throw new IllegalStateException("Preference does not have a key assigned.");
                }
                keyMappingPreference.f9094BV3sI0 = true;
            }
            preferenceGroup.BmvVmW(keyMappingPreference);
            i++;
        }
    }

    public void menu_reset(View view) {
        showDialog(1);
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492898);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        String stringExtra = getIntent().getStringExtra("profile-name");
        this.f11049B2KMhB = AYUAbz(stringExtra);
        materialToolbar.setTitle(stringExtra);
        setSupportActionBar(materialToolbar);
        getSupportActionBar().AmA8tU();
        getSupportActionBar().AlLFFp(true);
        materialToolbar.setNavigationIcon(2131230963);
        materialToolbar.setNavigationOnClickListener(new ADYaiT.A5SV6n(21, this));
        CtxOCS supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(supportFragmentManager);
        a2egSU.AlLFFp(2131296695, new MOpbMP.C2rE4F(), null);
        a2egSU.B2KMhB(false);
    }

    @Override // android.app.Activity
    public final Dialog onCreateDialog(int i) {
        if (i != 1) {
            return super.onCreateDialog(i);
        }
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
        a4TApA.B2KMhB(2131886711);
        a4TApA.AZOQYO(2131886712);
        a4TApA.AmA8tU(R.string.yes, new DRlcZ9.ASJ6gh(13, this));
        a4TApA.AaHO0E(R.string.no, null);
        return a4TApA.A2egSU();
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(2131623940, menu);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131297625) {
            return super.onOptionsItemSelected(menuItem);
        }
        showDialog(1);
        return true;
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (this.f11048B25kr6) {
            KeyMappingPreference[] keyMappingPreferenceArr = this.f11050B3GDIM;
            int[] iArr = new int[keyMappingPreferenceArr.length];
            for (int i = 0; i < keyMappingPreferenceArr.length; i++) {
                iArr[i] = keyMappingPreferenceArr[i].f11128DUi7mC;
            }
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f11049B2KMhB));
                try {
                    XmlSerializer newSerializer = Xml.newSerializer();
                    try {
                        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                    } catch (IllegalStateException unused) {
                    }
                    newSerializer.setOutput(bufferedOutputStream, "UTF-8");
                    newSerializer.startDocument(null, null);
                    newSerializer.startTag(null, "keys");
                    int i2 = 0;
                    while (true) {
                        String[] strArr = f11046BJ7GGh;
                        if (i2 >= 31) {
                            break;
                        }
                        newSerializer.startTag(null, "key");
                        newSerializer.attribute(null, "name", strArr[i2]);
                        newSerializer.text(Integer.toString(iArr[i2]));
                        newSerializer.endTag(null, "key");
                        i2++;
                    }
                    newSerializer.endTag(null, "keys");
                    newSerializer.endDocument();
                    bufferedOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    bufferedOutputStream.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f11048B25kr6 = false;
        }
    }
}
