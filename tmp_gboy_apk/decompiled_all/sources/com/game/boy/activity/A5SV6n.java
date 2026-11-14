package com.game.boy.activity;

import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A5SV6n extends ADYaiT.B2KMhB {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static boolean f10887AlLFFp = false;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static long f10888AmA8tU = 0;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static boolean f10889AzWtSf = true;

    public final void ARc23Z(boolean z, int i, boolean z2, boolean z3, A5SV6n a5SV6n) {
        OLy1FW.B25kr6 b25kr6 = new OLy1FW.B25kr6();
        if (!z && !z3) {
            if (z2) {
                a5SV6n.ASJ6gh();
            }
        } else {
            if (!z && z3) {
                b25kr6.f6376A4TApA = Integer.valueOf(i);
            }
            if (z2) {
                b25kr6.f6375A2egSU = new A2egSU(a5SV6n);
            }
            OLy1FW.AmA8tU.A2egSU(this, new OLy1FW.B2KMhB(b25kr6));
        }
    }

    public final void ASJ6gh() {
        if ((this instanceof SplashActivity) && (this instanceof PermissionsActivity)) {
            return;
        }
        Iterator it = A4TApA.f10886A2egSU.iterator();
        while (it.hasNext()) {
            ((A5SV6n) it.next()).recreate();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public void onCreate(Bundle bundle) {
        char c;
        I3HV03.A4TApA a4TApA = new I3HV03.A4TApA(this);
        Window window = getWindow();
        Oay4Bh.C4FrIb.A2egSU(window, a4TApA.B2KMhB(), null);
        View decorView = window.getDecorView();
        Hdahpu.AZOQYO azoqyo = a4TApA.B2KMhB() ? (Hdahpu.AZOQYO) a4TApA.f3809AmA8tU : null;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        CmUvjW.B9tovu(decorView, azoqyo);
        if (!a4TApA.B2KMhB()) {
            getSharedPreferences("window_preferences", 0).edit().putBoolean("edge_to_edge_enabled", !a4TApA.B2KMhB()).commit();
            recreate();
        }
        SharedPreferences sharedPreferences = getSharedPreferences(DRlcZ9.BNL6CD.A2egSU(this), 0);
        String string = sharedPreferences.getString("theme_mode", "system");
        string.getClass();
        switch (string.hashCode()) {
            case 3005871:
                if (string.equals(LiveConfigKey.AUTO)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3075958:
                if (string.equals("dark")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 102970646:
                if (string.equals("light")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                ADYaiT.BJ7GGh.AaHO0E(0);
                break;
            case 1:
                ADYaiT.BJ7GGh.AaHO0E(2);
                break;
            case 2:
                ADYaiT.BJ7GGh.AaHO0E(1);
                break;
            default:
                ADYaiT.BJ7GGh.AaHO0E(-1);
                break;
        }
        ARc23Z(sharedPreferences.getBoolean("dynamic_color", true), sharedPreferences.getInt("theme_COLOR", -15108398), false, sharedPreferences.getBoolean("themeSwitch", false), null);
        super.onCreate(bundle);
        if ((this instanceof SplashActivity) || (this instanceof PermissionsActivity)) {
            return;
        }
        A4TApA.f10886A2egSU.add(this);
        if (f10889AzWtSf) {
            f10887AlLFFp = true;
        }
    }

    @Override // ADYaiT.B2KMhB, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if ((this instanceof SplashActivity) && (this instanceof PermissionsActivity)) {
            return;
        }
        A4TApA.f10886A2egSU.remove(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f10888AmA8tU = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c3, code lost:
    
        if (r0.after(r3) != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            r7 = this;
            super.onResume()
            boolean r0 = r7 instanceof com.game.boy.activity.SplashActivity
            if (r0 != 0) goto Led
            boolean r0 = r7 instanceof com.game.boy.activity.PermissionsActivity
            if (r0 == 0) goto Lc
            return
        Lc:
            boolean r0 = com.game.boy.activity.A5SV6n.f10887AlLFFp
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L16
            com.game.boy.activity.A5SV6n.f10887AlLFFp = r1
        L14:
            r0 = 1
            goto L2e
        L16:
            long r3 = com.game.boy.activity.A5SV6n.f10888AmA8tU
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L2d
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r5 = com.game.boy.activity.A5SV6n.f10888AmA8tU
            long r3 = r3 - r5
            r5 = 300000(0x493e0, double:1.482197E-318)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L2d
            goto L14
        L2d:
            r0 = 0
        L2e:
            java.lang.String r3 = "privacy_prefs"
            android.content.SharedPreferences r3 = r7.getSharedPreferences(r3, r1)
            java.lang.String r4 = "has_agreed_all"
            boolean r3 = r3.getBoolean(r4, r1)
            if (r3 == 0) goto Led
            if (r0 == 0) goto Lcb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r7.getPackageName()
            r0.append(r3)
            java.lang.String r3 = "_preferences"
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.content.SharedPreferences r0 = r7.getSharedPreferences(r0, r1)
            android.content.SharedPreferences$Editor r4 = r0.edit()
            r4.apply()
            java.lang.String r4 = "user_group"
            r5 = 0
            java.lang.String r0 = r0.getString(r4, r5)
            if (r0 == 0) goto L7e
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L7e
            java.lang.String r6 = "管理员"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto Lcb
            java.lang.String r6 = "永久会员"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L7e
            goto Lcb
        L7e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc6
            r0.<init>()     // Catch: java.lang.Exception -> Lc6
            java.lang.String r6 = r7.getPackageName()     // Catch: java.lang.Exception -> Lc6
            r0.append(r6)     // Catch: java.lang.Exception -> Lc6
            r0.append(r3)     // Catch: java.lang.Exception -> Lc6
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lc6
            android.content.SharedPreferences r0 = r7.getSharedPreferences(r0, r1)     // Catch: java.lang.Exception -> Lc6
            android.content.SharedPreferences$Editor r3 = r0.edit()     // Catch: java.lang.Exception -> Lc6
            r3.apply()     // Catch: java.lang.Exception -> Lc6
            java.lang.String r0 = r0.getString(r4, r5)     // Catch: java.lang.Exception -> Lc6
            if (r0 == 0) goto Lcf
            boolean r3 = r0.isEmpty()     // Catch: java.lang.Exception -> Lc6
            if (r3 == 0) goto La9
            goto Lcf
        La9:
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch: java.lang.Exception -> Lc6
            java.lang.String r4 = "yyyy-MM-dd HH:mm:ss"
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch: java.lang.Exception -> Lc6
            r3.<init>(r4, r5)     // Catch: java.lang.Exception -> Lc6
            java.util.Date r0 = r3.parse(r0)     // Catch: java.lang.Exception -> Lc6
            java.util.Date r3 = new java.util.Date     // Catch: java.lang.Exception -> Lc6
            r3.<init>()     // Catch: java.lang.Exception -> Lc6
            if (r0 == 0) goto Lcf
            boolean r0 = r0.after(r3)     // Catch: java.lang.Exception -> Lc6
            if (r0 == 0) goto Lcf
            goto Lcb
        Lc6:
            r0 = move-exception
            r0.printStackTrace()
            goto Lcf
        Lcb:
            boolean r0 = com.game.boy.activity.A5SV6n.f10889AzWtSf
            if (r0 == 0) goto Led
        Lcf:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.game.boy.activity.SplashActivity> r3 = com.game.boy.activity.SplashActivity.class
            r0.<init>(r7, r3)
            java.lang.String r3 = "show_ad"
            r0.putExtra(r3, r2)
            r2 = 335544320(0x14000000, float:6.4623485E-27)
            r0.addFlags(r2)
            r7.startActivity(r0)
            r0 = 17432576(0x10a0000, float:2.5346597E-38)
            r2 = 17432577(0x10a0001, float:2.53466E-38)
            r7.overridePendingTransition(r0, r2)
            com.game.boy.activity.A5SV6n.f10889AzWtSf = r1
        Led:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.A5SV6n.onResume():void");
    }

    @Override // ADYaiT.B2KMhB
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
