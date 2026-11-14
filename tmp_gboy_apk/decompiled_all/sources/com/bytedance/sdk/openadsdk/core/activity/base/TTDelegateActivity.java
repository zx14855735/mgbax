package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.hf;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.dislike.ui.xj;
import com.bytedance.sdk.openadsdk.core.pl.u.g;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.c.c;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.core.widget.f;
import com.bytedance.sdk.openadsdk.core.widget.hf;
import com.bytedance.sdk.openadsdk.core.widget.kd;
import com.bytedance.sdk.openadsdk.core.widget.p;
import com.bytedance.sdk.openadsdk.core.widget.tf;
import com.bytedance.sdk.openadsdk.core.widget.u;
import com.bytedance.sdk.openadsdk.core.widget.w;
import com.bytedance.sdk.openadsdk.core.widget.zg;
import com.bytedance.sdk.openadsdk.core.yo;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTDelegateActivity extends Activity {
    private static String e;
    public static ws xj;
    private static String yo;
    private static c zg;
    private d am;
    private kd c;
    private f d;
    private Dialog f;
    private p g;
    private Intent hf;
    private tf kd;
    private w p;

    /* renamed from: pl, reason: collision with root package name */
    private hf f10279pl;
    private zg qt;
    private Activity tf;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.xj u;
    private AlertDialog w;
    private u y;

    public static class xj extends com.bytedance.sdk.component.tf.d {
        public xj(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.pl.u.u u = g.u();
            if (u != null) {
                Function<SparseArray<Object>, Object> r = com.bytedance.sdk.openadsdk.core.f.zg().r();
                if (r != null) {
                    u.xj(com.bytedance.sdk.openadsdk.zg.w.hf(r).booleanValue(1));
                }
                yo.tf();
            }
        }
    }

    private void kd() {
        try {
            Intent intent = this.hf;
            if (intent != null) {
                int intExtra = intent.getIntExtra(PointParamKey.TYPE, 0);
                String stringExtra = this.hf.getStringExtra("app_download_url");
                this.hf.getStringExtra("app_name");
                try {
                    try {
                        switch (intExtra) {
                            case 1:
                                break;
                            case 2:
                                y();
                                break;
                            case 3:
                                w(stringExtra, this.hf.getStringExtra("dialog_title"), this.hf.getStringExtra("dialog_content_key"));
                                break;
                            case 4:
                                hf(this.hf.getStringExtra("permission_id_key"), this.hf.getStringArrayExtra("permission_content_key"));
                                break;
                            case 5:
                                hf(stringExtra, this.hf.getStringExtra("dialog_title"), this.hf.getStringExtra("dialog_content_key"), this.hf.getStringExtra("dialog_btn_yes_key"), this.hf.getStringExtra("dialog_btn_no_key"));
                                break;
                            case 6:
                                y(this.hf.getStringExtra("materialmeta"));
                                break;
                            case 7:
                                w(stringExtra);
                                break;
                            case 8:
                                xj(this.hf.getStringExtra("dialog_app_manage_model"), stringExtra);
                                break;
                            case 9:
                                w(this.hf.getStringExtra("dialog_app_privacy_url"), stringExtra);
                                break;
                            case 10:
                                hf(this.hf.getStringExtra("dialog_content_key"));
                                break;
                            case 11:
                                kd(this.hf.getStringExtra("dialog_app_ad_info"));
                                break;
                            case 12:
                                hf(this.hf.getStringExtra("web_url"), this.hf.getStringExtra("web_title"));
                                break;
                            case 13:
                                hf();
                                break;
                            case 14:
                                xj(this.hf.getStringExtra("dialog_app_desc_url"), stringExtra, 1, true, (Dialog) null);
                                break;
                            case 15:
                                xj(this.hf.getStringExtra("web_url"));
                                break;
                            case 16:
                                xj(this.hf.getStringExtra("dialog_app_registration_url"), stringExtra, 3, true, (Dialog) null);
                                break;
                            default:
                                finish();
                                break;
                        }
                    } catch (Exception unused) {
                        finish();
                    }
                } catch (Exception unused2) {
                    finish();
                }
            }
        } catch (Exception unused3) {
        }
    }

    private void y(String str) {
        if (r.d(this.tf)) {
            if (str != null && this.u == null) {
                try {
                    ws xj2 = com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(str));
                    if (xj2 != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.xj(this.tf, xj2.xl(), false);
                        this.u = xjVar;
                        com.bytedance.sdk.openadsdk.core.dislike.w.xj(this.tf, xj2, xjVar);
                        this.u.xj(new xj.InterfaceC0158xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.6
                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
                            public void hf() {
                                TTDelegateActivity.this.finish();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
                            public void xj() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
                            public void xj(int i, String str2, boolean z) {
                                TTDelegateActivity.this.finish();
                            }
                        });
                    }
                } catch (JSONException e2) {
                    pl.xj(e2);
                }
            }
            com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar2 = this.u;
            if (xjVar2 != null) {
                xjVar2.xj();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w wVar = this.p;
        if (wVar == null || wVar.isShowing()) {
            return;
        }
        this.p.xj();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tf = this;
        u();
        this.hf = getIntent();
        if (pz.getContext() == null) {
            pz.xj(this.tf);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            xj = null;
            AlertDialog alertDialog = this.w;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.w.dismiss();
            }
            f fVar = this.d;
            if (fVar == null || !fVar.isShowing()) {
                y.xj(e);
            } else {
                y.xj(this.d.xj());
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
            u uVar = this.y;
            if (uVar != null && uVar.isShowing()) {
                this.y.dismiss();
            }
            w wVar = this.p;
            if (wVar != null) {
                if (wVar.isShowing()) {
                    this.p.dismiss();
                }
                y.xj(this.p.u());
            } else {
                y.xj(yo);
            }
            hf hfVar = this.f10279pl;
            if (hfVar != null && hfVar.isShowing()) {
                this.f10279pl.dismiss();
            }
            kd kdVar = this.c;
            if (kdVar != null && kdVar.isShowing()) {
                this.c.dismiss();
            }
            p pVar = this.g;
            if (pVar != null && pVar.isShowing()) {
                this.g.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null && dialog.isShowing()) {
                this.f.dismiss();
            }
            e = null;
            yo = null;
        } catch (Throwable th) {
            pl.w("dialog", "onDestroy", th);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (pz.getContext() == null) {
            pz.xj(this.tf);
        }
        try {
            setIntent(intent);
            this.hf = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        f fVar = this.d;
        if (fVar != null) {
            e = fVar.xj();
        }
        w wVar = this.p;
        if (wVar != null) {
            yo = wVar.u();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(this.tf, strArr, iArr);
        com.bytedance.sdk.component.tf.c.xj(new xj("onRequestPermissionsResult"), 1);
        finish();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            kd();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        w();
    }

    public static void hf(Context context, String str, String str2) {
        if (context == null) {
            context = pz.getContext();
        }
        com.bytedance.sdk.openadsdk.core.ra.y u = u(str2);
        if (u == null) {
            return;
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 9);
        xj2.putExtra("dialog_app_privacy_url", u.f());
        xj2.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    public static void u(Context context, String str, String str2) {
        if (context == null) {
            context = pz.getContext();
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 12);
        xj2.putExtra("web_url", str);
        xj2.putExtra("web_title", str2);
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    public static void w(Context context, String str, String str2) {
        if (context == null) {
            context = pz.getContext();
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 14);
        xj2.putExtra("dialog_app_desc_url", str2);
        xj2.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    public static void xj(String str, String[] strArr) {
        Intent intent = new Intent(pz.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(PointParamKey.TYPE, 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (pz.getContext() != null) {
            com.bytedance.sdk.component.utils.hf.xj(pz.getContext(), intent, new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.1
                @Override // com.bytedance.sdk.component.utils.hf.xj
                public void xj() {
                }

                @Override // com.bytedance.sdk.component.utils.hf.xj
                public void xj(Throwable th) {
                    pl.w("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    private void u() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void w() {
        if (com.bytedance.sdk.openadsdk.core.f.zg().tu()) {
            if (this.p == null && this.d == null && this.g == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.f.zg().f(false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(str, "click_other", str3, str2, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.12
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("refer", "reg");
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    private void y() {
        ApplicationInfo applicationInfo;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            try {
                com.bytedance.sdk.openadsdk.zg.w.w.u v = com.bytedance.sdk.openadsdk.core.f.zg().v();
                boolean w = v.w();
                boolean kd = v.kd();
                ArrayList arrayList = new ArrayList();
                com.bytedance.sdk.openadsdk.qt.hf.xj(v, arrayList);
                if (w) {
                    arrayList.add(com.kuaishou.weapon.p0.g.c);
                }
                if (kd) {
                    arrayList.add(com.kuaishou.weapon.p0.g.j);
                }
                Context context = pz.getContext();
                if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && i >= 33) {
                    arrayList.add("android.permission.POST_NOTIFICATIONS");
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(this.tf, strArr, new com.bytedance.sdk.openadsdk.core.io.y() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.14
                    @Override // com.bytedance.sdk.openadsdk.core.io.y
                    public void xj() {
                        com.bytedance.sdk.component.tf.c.xj(new xj("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.io.y
                    public void xj(String str) {
                        com.kuaishou.weapon.p0.g.c.equals(str);
                        com.bytedance.sdk.component.tf.c.xj(new xj("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
            }
        }
        finish();
    }

    public static void hf(Context context, String str) {
        if (context == null) {
            context = pz.getContext();
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 11);
        xj2.putExtra("dialog_app_ad_info", str);
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    private static com.bytedance.sdk.openadsdk.core.ra.y u(String str) {
        try {
            return com.bytedance.sdk.openadsdk.core.xj.kd(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    private void w(final String str) {
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        float f;
        boolean z;
        String str7;
        String str8;
        String str9;
        String str10;
        float f2;
        boolean z2;
        Intent intent = this.hf;
        if (intent == null) {
            return;
        }
        final String stringExtra = intent.getStringExtra("event_extInfo");
        final String stringExtra2 = this.hf.getStringExtra("event_adId");
        final String stringExtra3 = this.hf.getStringExtra("event_TAG");
        String stringExtra4 = this.hf.getStringExtra("dialog_app_manage_model");
        String stringExtra5 = this.hf.getStringExtra("dialog_title");
        final String stringExtra6 = this.hf.getStringExtra("dialog_icon_url");
        final String stringExtra7 = this.hf.getStringExtra("dialog_app_description");
        boolean booleanExtra = this.hf.getBooleanExtra("is_easy_dl_dialog_pop_up_style", false);
        try {
            JSONArray jSONArray2 = null;
            String str11 = "";
            if (TextUtils.isEmpty(stringExtra4)) {
                jSONArray = null;
                str2 = null;
                str3 = "";
                str4 = str3;
                str5 = str4;
                str6 = str5;
                f = 0.0f;
                z = false;
            } else {
                JSONObject jSONObject = new JSONObject(stringExtra4);
                com.bytedance.sdk.openadsdk.core.ra.y kd = com.bytedance.sdk.openadsdk.core.xj.kd(jSONObject);
                if (kd != null) {
                    String kd2 = kd.kd();
                    String c = kd.c();
                    String tf = kd.tf();
                    String am = kd.am();
                    if (!TextUtils.isEmpty(am)) {
                        stringExtra5 = am;
                    }
                    JSONArray u = kd.u();
                    f2 = kd.w();
                    str7 = kd.p();
                    str11 = stringExtra5;
                    str8 = kd2;
                    str9 = c;
                    jSONArray2 = u;
                    str10 = tf;
                } else {
                    str7 = null;
                    str8 = "";
                    str9 = str8;
                    str10 = str9;
                    f2 = 0.0f;
                }
                String optString = jSONObject.optString("ugen_url");
                String optString2 = jSONObject.optString("ugen_md5");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    z2 = false;
                } else {
                    jSONObject.put("app_name", str11);
                    jSONObject.put("icon_url", stringExtra6);
                    jSONObject.put("description", stringExtra7);
                    stringExtra4 = jSONObject.toString();
                    z2 = true;
                }
                String optString3 = jSONObject.optString("hand_icon_url");
                float f3 = f2;
                str6 = optString3;
                f = f3;
                z = z2;
                jSONArray = jSONArray2;
                str3 = str11;
                str11 = str9;
                str2 = str7;
                str5 = str10;
                str4 = str8;
            }
            final String str12 = stringExtra4;
            if (booleanExtra) {
                xj(str, str12, stringExtra6, stringExtra7, str4, str11, str3, jSONArray, f, str5, str2, stringExtra, stringExtra3, stringExtra2);
                return;
            }
            final String str13 = str4;
            final JSONArray jSONArray3 = jSONArray;
            final String str14 = str11;
            final String str15 = str5;
            final String str16 = str2;
            final float f4 = f;
            if (z) {
                final String str17 = str3;
                final String str18 = str6;
                xj(str, str12, new c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.18
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
                    public void xj(int i, String str19) {
                        TTDelegateActivity.this.xj(str, str12, stringExtra6, f4, stringExtra7, str18, jSONArray3, str13, str14, str17, str15, str16, stringExtra2, stringExtra3, stringExtra);
                        if (TTDelegateActivity.this.d != null) {
                            TTDelegateActivity.this.d.xj((c) null);
                        }
                        if (TTDelegateActivity.zg != null) {
                            TTDelegateActivity.zg.xj(i, str19);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
                    public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
                        if (TTDelegateActivity.zg != null) {
                            TTDelegateActivity.zg.xj(null);
                        }
                    }
                }, stringExtra2, stringExtra3, stringExtra);
            } else {
                xj(str, str12, stringExtra6, f4, stringExtra7, str6, jSONArray3, str13, str14, str3, str15, str16, stringExtra2, stringExtra3, stringExtra);
            }
        } catch (Throwable unused) {
        }
    }

    public static void xj(Context context, String str, String str2, String str3) {
        if (context == null) {
            context = pz.getContext();
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 3);
        xj2.putExtra("app_download_url", str);
        xj2.putExtra("dialog_title", str2);
        xj2.putExtra("dialog_content_key", str3);
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    private void hf() {
        try {
            if (this.am == null) {
                this.am = new d(this.tf, getIntent());
            }
            if (this.am.isShowing()) {
                this.am.dismiss();
            }
            this.am.xj(new d.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.15
                @Override // com.bytedance.sdk.openadsdk.core.widget.d.xj
                public void xj(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.am.show();
        } catch (Throwable unused) {
        }
    }

    private static Intent xj(Context context) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        return intent;
    }

    private void hf(String str) {
        try {
            if (r.d(this.tf)) {
                Dialog dialog = this.f;
                if (dialog == null || !dialog.isShowing()) {
                    com.bytedance.sdk.openadsdk.core.widget.xj xjVar = new com.bytedance.sdk.openadsdk.core.widget.xj(this.tf, str);
                    this.f = xjVar;
                    xjVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.17
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TTDelegateActivity.this.finish();
                        }
                    });
                    this.f.show();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void xj(c cVar) {
        zg = cVar;
    }

    public static void xj(Context context, String str, String str2, String str3, c cVar, ws wsVar) {
        try {
            xj = wsVar;
            zg = cVar;
            if (context == null) {
                context = pz.getContext();
            }
            Intent xj2 = xj(context);
            JSONObject jSONObject = new JSONObject(str3);
            xj2.putExtra(PointParamKey.TYPE, 7);
            xj2.putExtra("app_download_url", str);
            xj2.putExtra("dialog_app_manage_model", str2);
            if (wsVar != null) {
                xj2.putExtra("event_adId", wsVar.ho());
                xj2.putExtra("event_extInfo", wsVar.jf());
                xj2.putExtra("event_TAG", wo.hf(wsVar));
            }
            xj2.putExtra("dialog_title", jSONObject.optString("dialog_title"));
            xj2.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
            xj2.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
            xj2.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
            com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
        } catch (Exception e2) {
            pl.xj(e2);
        }
    }

    private void hf(String str, String str2) {
        try {
            if (r.d(this.tf)) {
                u uVar = this.y;
                if (uVar != null) {
                    uVar.dismiss();
                }
                u uVar2 = new u(this.tf, str, str2);
                this.y = uVar2;
                uVar2.xj(new u.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.2
                    @Override // com.bytedance.sdk.openadsdk.core.widget.u.xj
                    public void xj(Dialog dialog) {
                        if (TTDelegateActivity.this.y != null) {
                            TTDelegateActivity.this.y.dismiss();
                            TTDelegateActivity.this.finish();
                        }
                    }
                });
                this.y.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void hf(final String str, String str2, String str3, String str4, String str5) {
        if (r.d(this.tf)) {
            AlertDialog alertDialog = this.w;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.kd == null) {
                this.kd = new tf(this.tf).xj(str2).hf(str3).w(str4).u(str5).xj(new tf.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.8
                    @Override // com.bytedance.sdk.openadsdk.core.widget.tf.xj
                    public void onClickNo(Dialog dialog) {
                        y.w(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.tf.xj
                    public void onClickYes(Dialog dialog) {
                        y.hf(str);
                        TTDelegateActivity.this.finish();
                    }
                }).xj(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        y.u(str);
                        TTDelegateActivity.this.finish();
                    }
                });
            }
            if (!this.kd.isShowing()) {
                this.kd.show();
            }
            this.w = this.kd;
        }
    }

    private void kd(String str) {
        try {
            if (r.d(this.tf)) {
                p pVar = this.g;
                if (pVar != null) {
                    pVar.dismiss();
                }
                p pVar2 = new p(this.tf, str);
                this.g = pVar2;
                pVar2.xj(new p.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.p.xj
                    public void xj(Dialog dialog) {
                        TTDelegateActivity.this.finish();
                    }
                });
                this.g.show();
            }
        } catch (Throwable unused) {
        }
    }

    public static void xj(Context context, String str, String str2, String str3, ws wsVar) {
        if (context == null) {
            try {
                context = pz.getContext();
            } catch (Exception e2) {
                pl.xj(e2);
                return;
            }
        }
        Intent xj2 = xj(context);
        JSONObject jSONObject = new JSONObject(str3);
        xj2.putExtra(PointParamKey.TYPE, 7);
        xj2.putExtra("app_download_url", str);
        xj2.putExtra("dialog_app_manage_model", str2);
        if (wsVar != null) {
            xj2.putExtra("event_adId", wsVar.ho());
            xj2.putExtra("event_extInfo", wsVar.jf());
            xj2.putExtra("event_TAG", wo.hf(wsVar));
        }
        xj2.putExtra("dialog_title", jSONObject.optString("dialog_title"));
        xj2.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
        xj2.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
        xj2.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    private void w(String str, String str2) {
        if (this.hf == null) {
            return;
        }
        xj(str, str2, 2, true, (Dialog) null);
    }

    private void w(final String str, String str2, String str3) {
        if (r.d(this.tf)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = jk.xj(this.tf, "tt_tip");
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            xj(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    y.hf(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    y.w(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    y.u(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
    }

    private void hf(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(this.tf, strArr, new com.bytedance.sdk.openadsdk.core.io.y() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.9
                        @Override // com.bytedance.sdk.openadsdk.core.io.y
                        public void xj() {
                            com.bytedance.sdk.openadsdk.core.a.c.xj(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.io.y
                        public void xj(String str2) {
                            com.bytedance.sdk.openadsdk.core.a.c.xj(str, str2);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                }
            }
            finish();
            return;
        }
        finish();
    }

    public static void xj(Context context, String str, String str2) {
        if (context == null) {
            context = pz.getContext();
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 8);
        xj2.putExtra("app_download_url", str);
        xj2.putExtra("dialog_app_manage_model", str2);
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    public static void xj(Context context, String str) {
        if (context == null) {
            context = pz.getContext();
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 10);
        xj2.putExtra("dialog_content_key", str);
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    public static void xj(Context context, String str, String str2, ws wsVar) {
        if (context == null) {
            context = pz.getContext();
        }
        com.bytedance.sdk.openadsdk.core.ra.y u = u(str2);
        if (u == null) {
            return;
        }
        if (wsVar != null) {
            hf(wo.hf(wsVar), wsVar.jf(), wsVar.ho());
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 16);
        xj2.putExtra("dialog_app_registration_url", u.p());
        xj2.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    public static void xj(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            context = pz.getContext();
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 5);
        xj2.putExtra("app_download_url", str);
        xj2.putExtra("dialog_title", str2);
        xj2.putExtra("dialog_content_key", str3);
        xj2.putExtra("dialog_btn_yes_key", str4);
        xj2.putExtra("dialog_btn_no_key", str5);
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    public static void xj(Context context, ws wsVar) {
        JSONObject ac;
        if (context == null) {
            context = pz.getContext();
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 6);
        if (wsVar != null && (ac = wsVar.ac()) != null) {
            xj2.putExtra("materialmeta", ac.toString());
        }
        if (context != null) {
            try {
                context.startActivity(xj2);
            } catch (Throwable unused) {
            }
        }
    }

    public void xj(String str) {
        if (this.qt == null) {
            this.qt = new zg(this.tf, str);
        }
        if (this.qt.isShowing()) {
            this.qt.dismiss();
        }
        this.qt.xj(new zg.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.widget.zg.xj
            public void hf(String str2) {
                y.u(str2);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.zg.xj
            public void xj(String str2) {
                y.hf(str2);
                TTDelegateActivity.this.finish();
            }
        });
        this.qt.show();
    }

    public static void xj(Context context, String str, boolean z) {
        if (context == null) {
            context = pz.getContext();
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 15);
        if (!z) {
            xj2.putExtra("web_url", str);
        }
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    public static void xj(Context context, String str, ws wsVar) {
        if (context == null) {
            context = pz.getContext();
        }
        Intent xj2 = xj(context);
        xj2.putExtra(PointParamKey.TYPE, 13);
        xj = wsVar;
        xj2.putExtra("event_tag", str);
        com.bytedance.sdk.component.utils.hf.xj(context, xj2, null);
    }

    private void xj(String str, String str2, c cVar, String str3, String str4, String str5) {
        if (r.d(this.tf)) {
            if (TextUtils.isEmpty(str2)) {
                cVar.xj(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                w wVar = this.p;
                if (wVar == null || !wVar.isShowing()) {
                    w d = new com.bytedance.sdk.openadsdk.core.widget.g(this.tf, jSONObject, cVar).d(str);
                    this.p = d;
                    try {
                        ((com.bytedance.sdk.openadsdk.core.widget.g) d).hf(xj(str, str2, str3, str4, str5));
                        this.p.show();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    private void xj(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONArray jSONArray, final float f, final String str8, final String str9, final String str10, final String str11, final String str12) {
        xj(str, str2, str7, f, new c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.19
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(int i, String str13) {
                TTDelegateActivity.this.xj(str, str2, str3, f, str4, "", jSONArray, str5, str6, str7, str8, str9, str12, str11, str10);
                if (TTDelegateActivity.this.d != null) {
                    TTDelegateActivity.this.d.xj((c) null);
                }
                if (TTDelegateActivity.zg != null) {
                    TTDelegateActivity.zg.xj(i, str13);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
                if (TTDelegateActivity.zg != null) {
                    TTDelegateActivity.zg.xj(null);
                }
            }
        }, str10, str11, str12);
    }

    private void xj(final String str, final String str2, String str3, float f, c cVar, final String str4, final String str5, final String str6) {
        if (r.d(this.tf)) {
            if (TextUtils.isEmpty(str2)) {
                cVar.xj(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("app_name", str3);
                }
                jSONObject.put("score", f);
                JSONObject xj2 = com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(jSONObject.getString("ugen_dialog_url"), jSONObject.getString("ugen_dialog_md5"), (com.bytedance.sdk.openadsdk.core.ugeno.w) null);
                if (xj2 == null) {
                    cVar.xj(8, "uegnTemplate is empty");
                    return;
                }
                f fVar = this.d;
                if (fVar == null || !fVar.isShowing()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("easy_dl_dialog", jSONObject);
                    f fVar2 = new f(str, this.tf, xj2, jSONObject2, cVar, xj);
                    this.d = fVar2;
                    fVar2.xj(new c.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.20
                        @Override // com.bytedance.sdk.openadsdk.core.widget.c.xj
                        public void hf(Dialog dialog) {
                            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                            tTDelegateActivity.xj(str2, str, false, (Dialog) tTDelegateActivity.d);
                            if (TTDelegateActivity.this.d != null) {
                                TTDelegateActivity.this.d.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.c.xj
                        public void u(Dialog dialog) {
                            try {
                                com.bytedance.sdk.openadsdk.core.ra.y kd = com.bytedance.sdk.openadsdk.core.xj.kd(new JSONObject(str2));
                                if (kd != null) {
                                    TTDelegateActivity.this.xj(kd.f(), str, 2, false, (Dialog) TTDelegateActivity.this.d);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.d != null) {
                                TTDelegateActivity.this.d.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.c.xj
                        public void w(Dialog dialog) {
                            y.u(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.c.xj
                        public void xj(Dialog dialog) {
                            y.hf(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.c.xj
                        public void xj() {
                            try {
                                com.bytedance.sdk.openadsdk.core.ra.y kd = com.bytedance.sdk.openadsdk.core.xj.kd(new JSONObject(str2));
                                if (kd != null) {
                                    TTDelegateActivity.this.xj(kd.d(), str, 1, false, (Dialog) TTDelegateActivity.this.d);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.d != null) {
                                TTDelegateActivity.this.d.hide();
                            }
                        }
                    });
                    this.d.show();
                }
            } catch (Exception e2) {
                pl.xj(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, String str2, String str3, float f, String str4, String str5, JSONArray jSONArray, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        if (r.d(this.tf)) {
            w wVar = this.p;
            if (wVar == null || !wVar.isShowing()) {
                w xj2 = new w(this.tf).xj(str8).kd(str6).y(str9).hf(str3).f(str7).d(str).w(str5).xj(f).xj(jSONArray).c(str10).u(str4).xj(xj(str, str2, str11, str12, str13));
                this.p = xj2;
                xj2.show();
            }
        }
    }

    private w.xj xj(final String str, final String str2, final String str3, final String str4, final String str5) {
        return new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.21
            @Override // com.bytedance.sdk.openadsdk.core.widget.w.xj
            public void hf(Dialog dialog) {
                TTDelegateActivity.this.xj(str2, str, false, (Dialog) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.w.xj
            public void kd(Dialog dialog) {
                try {
                    com.bytedance.sdk.openadsdk.core.ra.y kd = com.bytedance.sdk.openadsdk.core.xj.kd(new JSONObject(str2));
                    if (kd == null) {
                        return;
                    }
                    TTDelegateActivity.this.xj(kd.d(), str, 1, false, (Dialog) null);
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.w.xj
            public void u(Dialog dialog) {
                try {
                    com.bytedance.sdk.openadsdk.core.ra.y kd = com.bytedance.sdk.openadsdk.core.xj.kd(new JSONObject(str2));
                    if (kd != null) {
                        TTDelegateActivity.this.xj(kd.f(), str, 2, false, (Dialog) null);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.w.xj
            public void w(Dialog dialog) {
                y.u(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.w.xj
            public void xj(Dialog dialog) {
                y.hf(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.w.xj
            public void y(Dialog dialog) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    TTDelegateActivity.hf(str4, str5, str3);
                    com.bytedance.sdk.openadsdk.core.ra.y kd = com.bytedance.sdk.openadsdk.core.xj.kd(jSONObject);
                    if (kd == null) {
                        return;
                    }
                    TTDelegateActivity.this.xj(kd.p(), str, 3, false, (Dialog) null);
                } catch (Exception unused) {
                }
            }
        };
    }

    private void xj(String str, String str2) {
        if (this.hf == null) {
            return;
        }
        xj(str, str2, true, (Dialog) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, final String str2, int i, final boolean z, final Dialog dialog) {
        String str3;
        String str4;
        try {
            if (r.d(this.tf)) {
                kd kdVar = this.c;
                if (kdVar != null) {
                    kdVar.dismiss();
                }
                if (i == 1) {
                    str3 = "https://apps.bytesfield.com/app_package_ce/appIntro";
                    str4 = "应用简介";
                } else if (i == 2) {
                    str3 = "https://sf1-amtos-cdn.bytesmanager.com/obj/ad-app-package/personal-privacy-page.html";
                    str4 = "隐私政策";
                } else if (i == 3) {
                    str4 = "备案信息";
                    str3 = null;
                } else {
                    str3 = null;
                    str4 = null;
                }
                kd kdVar2 = new kd(this.tf, str, str3, str4);
                this.c = kdVar2;
                kdVar2.xj(new kd.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.3
                    @Override // com.bytedance.sdk.openadsdk.core.widget.kd.xj
                    public void hf(Dialog dialog2) {
                        y.u(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.kd.xj
                    public void w(Dialog dialog2) {
                        if (TTDelegateActivity.this.c != null) {
                            if (z) {
                                y.u(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.c.dismiss();
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.kd.xj
                    public void xj(Dialog dialog2) {
                        y.hf(str2);
                        TTDelegateActivity.this.finish();
                    }
                });
                this.c.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, final String str2, final boolean z, final Dialog dialog) {
        try {
            if (r.d(this.tf)) {
                com.bytedance.sdk.openadsdk.core.widget.hf hfVar = this.f10279pl;
                if (hfVar != null) {
                    hfVar.dismiss();
                }
                com.bytedance.sdk.openadsdk.core.widget.hf hfVar2 = new com.bytedance.sdk.openadsdk.core.widget.hf(this.tf, str);
                this.f10279pl = hfVar2;
                hfVar2.xj(new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.5
                    @Override // com.bytedance.sdk.openadsdk.core.widget.hf.xj
                    public void hf(Dialog dialog2) {
                        y.u(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.hf.xj
                    public void w(Dialog dialog2) {
                        if (TTDelegateActivity.this.f10279pl != null) {
                            if (z) {
                                y.u(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.f10279pl.dismiss();
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.hf.xj
                    public void xj(Dialog dialog2) {
                        y.hf(str2);
                        TTDelegateActivity.this.finish();
                    }
                });
                this.f10279pl.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void xj(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.w == null) {
                this.w = new AlertDialog.Builder(this.tf, jk.f(this.tf, "Theme.Dialog.TTDownload")).create();
            }
            this.w.setTitle(String.valueOf(str));
            this.w.setMessage(String.valueOf(str2));
            this.w.setButton(-1, jk.xj(this.tf, "tt_label_ok"), onClickListener);
            this.w.setButton(-2, jk.xj(this.tf, "tt_label_cancel"), onClickListener2);
            this.w.setOnCancelListener(onCancelListener);
            if (this.w.isShowing()) {
                return;
            }
            this.w.show();
        } catch (Exception e2) {
            pl.xj(e2);
        }
    }
}
