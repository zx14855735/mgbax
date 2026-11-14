package com.game.boy.activity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.button.MaterialButton;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.downloader.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PermissionsActivity extends A5SV6n {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final String[] f11076BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final String[] f11077BIYEnU;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final SparseArray f11078B25kr6 = new SparseArray();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public BluetoothAdapter f11079B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ViewPager2 f11080B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public LinearLayout f11081B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public MaterialButton f11082B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public MaterialButton f11083B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public LLiCI0.CASmeH f11084BChYOn;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            f11076BI9f7h = new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"};
        } else if (i >= 30) {
            f11076BI9f7h = new String[]{g.i, g.j, "android.permission.MANAGE_EXTERNAL_STORAGE"};
        } else {
            f11076BI9f7h = new String[]{g.i, g.j};
        }
        if (i >= 31) {
            f11077BIYEnU = new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", g.g};
        } else if (i >= 23) {
            f11077BIYEnU = new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", g.g};
        } else {
            f11077BIYEnU = new String[0];
        }
        SRrk();
    }

    public static void AYUAbz(PermissionsActivity permissionsActivity) {
        permissionsActivity.getClass();
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + permissionsActivity.getPackageName()));
            permissionsActivity.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(permissionsActivity, "无法打开设置页面", 0).show();
        }
    }

    private static /* synthetic */ void SRrk() {
        char[] charArray = "\u008d\u0081\u0083À\u0089\u008f\u0083\u008bÀ\u008c\u0081\u0097À\u009d\u0086\u008b\u0082\u0082À¤\u0080\u0087¬\u009c\u0087\u008a\u0089\u008b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 238);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008d\u0082\u0087\u0080\u0087\u009a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 238);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean AZOQYO(String[] strArr) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null && !str.isEmpty() && AZkASS(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            checkSelfPermission = checkSelfPermission((String) it.next());
            if (checkSelfPermission != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean AZkASS(String str) {
        try {
            String[] strArr = getPackageManager().getPackageInfo(getPackageName(), f.a.c).requestedPermissions;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
    
        if (r7 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0073, code lost:
    
        if (r7 == 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean AaHO0E(int r7) {
        /*
            r6 = this;
            r0 = 23
            r1 = 0
            r2 = 1
            java.lang.String[] r3 = com.game.boy.activity.PermissionsActivity.f11076BI9f7h
            android.util.SparseArray r4 = r6.f11078B25kr6
            java.lang.Object r7 = r4.get(r7)
            com.game.boy.activity.CcAIMM r7 = (com.game.boy.activity.CcAIMM) r7
            if (r7 == 0) goto L7a
            int r4 = r7.f10950A2egSU
            switch(r4) {
                case 0: goto L66;
                case 1: goto L3a;
                case 2: goto L1e;
                default: goto L15;
            }
        L15:
            java.lang.String[] r0 = com.game.boy.activity.PermissionsActivity.f11077BIYEnU
            com.game.boy.activity.PermissionsActivity r7 = r7.f10951A4TApA
            boolean r7 = r7.AZOQYO(r0)
            goto L76
        L1e:
            int r3 = android.os.Build.VERSION.SDK_INT
            com.game.boy.activity.PermissionsActivity r7 = r7.f10951A4TApA
            if (r3 >= r0) goto L25
            goto L2f
        L25:
            java.lang.String r0 = "power"
            java.lang.Object r0 = r7.getSystemService(r0)
            android.os.PowerManager r0 = (android.os.PowerManager) r0
            if (r0 != 0) goto L31
        L2f:
            r7 = 1
            goto L76
        L31:
            java.lang.String r7 = r7.getPackageName()
            boolean r7 = com.game.boy.activity.CQhlFr.AcNBzu(r0, r7)
            goto L76
        L3a:
            com.game.boy.activity.PermissionsActivity r7 = r7.f10951A4TApA
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 30
            if (r4 >= r0) goto L44
            r7 = 1
            goto L52
        L44:
            if (r4 < r5) goto L4e
            boolean r7 = COJEAR.FZu94u.BI9f7h()     // Catch: java.lang.Exception -> L4b
            goto L52
        L4b:
            r7 = 0
            goto L52
        L4e:
            boolean r7 = r7.AZOQYO(r3)
        L52:
            if (r7 == 0) goto L64
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r5) goto L60
            boolean r7 = COJEAR.FZu94u.BI9f7h()     // Catch: java.lang.Exception -> L5d
            goto L61
        L5d:
            r7 = 0
            goto L61
        L60:
            r7 = 1
        L61:
            if (r7 == 0) goto L64
            goto L2f
        L64:
            r7 = 0
            goto L76
        L66:
            com.game.boy.activity.PermissionsActivity r7 = r7.f10951A4TApA
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 33
            if (r0 >= r3) goto L6f
            goto L75
        L6f:
            int r7 = com.bytedance.pangle.wrapper.AMqCpz.ASJ6gh(r7)
            if (r7 != 0) goto L64
        L75:
            goto L2f
        L76:
            if (r7 == 0) goto L79
            goto L7a
        L79:
            return r1
        L7a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.PermissionsActivity.AaHO0E(int):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.io.Serializable, java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    public final void AcNBzu(int i, String str, String str2, String[] strArr) {
        ?? r12;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            Toast.makeText(this, str.concat("已自动授予"), 0).show();
            AzWtSf();
            return;
        }
        if (i2 < 23) {
            r12 = new String[0];
        } else {
            ArrayList arrayList = new ArrayList();
            for (String str3 : strArr) {
                if (AZkASS(str3)) {
                    arrayList.add(str3);
                }
            }
            r12 = (String[]) arrayList.toArray(new String[0]);
        }
        if (r12.length == 0) {
            Toast.makeText(this, str.concat("已自动授予"), 0).show();
            AzWtSf();
            return;
        }
        if (AZOQYO(r12)) {
            Toast.makeText(this, str.concat("已授权"), 0).show();
            AzWtSf();
            return;
        }
        if (str.equals("存储权限") && Build.VERSION.SDK_INT >= 30) {
            AlLFFp();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            for (String str4 : r12) {
                if (androidx.core.app.AYUAbz.ARc23Z(this, str4)) {
                    OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
                    String concat = "需要".concat(str);
                    ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
                    azoqyo.AMqCpz = concat;
                    azoqyo.f28ASJ6gh = str2;
                    a4TApA.AzWtSf("授权", new MOpbMP.BI9f7h(this, r12, i, 2));
                    a4TApA.AcNBzu("取消", new CTkVKb(this, 0));
                    azoqyo.f36AzWtSf = new CSDoyG(this, 0);
                    a4TApA.AMqCpz();
                    return;
                }
            }
        }
        androidx.core.app.AYUAbz.requestPermissions(this, r12, i);
    }

    public final void AlLFFp() {
        String str = Build.VERSION.SDK_INT >= 30 ? "Android 11+需要「所有文件访问」权限才能访问游戏文件\n请前往系统设置开启此权限" : "需要存储权限以保存游戏进度和截图";
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
        ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
        azoqyo.AMqCpz = "存储权限说明";
        azoqyo.f28ASJ6gh = str;
        a4TApA.AzWtSf("去设置", new CTkVKb(this, 1));
        a4TApA.AcNBzu("取消", null);
        azoqyo.f36AzWtSf = new CSDoyG(this, 1);
        a4TApA.AMqCpz();
    }

    public final void AmA8tU() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    public final void AzWtSf() {
        runOnUiThread(new ASJ6gh(5, this));
    }

    public final void B25kr6(int i) {
        int size = this.f11084BChYOn.f4772AcNBzu.size();
        LLiCI0.C2rE4F c2rE4F = (LLiCI0.C2rE4F) this.f11084BChYOn.f4772AcNBzu.get(i);
        boolean z = true;
        boolean z2 = i == size - 1;
        int i2 = c2rE4F.f4767ADYaiT;
        boolean z3 = i2 == 0 || AaHO0E(i2);
        String str = "开始使用";
        if (!c2rE4F.AMqCpz) {
            this.f11082B7CMnp.setVisibility(0);
            this.f11082B7CMnp.setEnabled(true);
            this.f11082B7CMnp.setAlpha(1.0f);
            if (z3) {
                this.f11082B7CMnp.setText("Back");
            } else if (z2) {
                this.f11082B7CMnp.setText("开始使用");
            } else {
                this.f11082B7CMnp.setText("跳过");
            }
        } else if (i == 0) {
            this.f11082B7CMnp.setVisibility(4);
        } else {
            this.f11082B7CMnp.setVisibility(0);
            this.f11082B7CMnp.setText("Back");
            this.f11082B7CMnp.setEnabled(true);
            this.f11082B7CMnp.setAlpha(1.0f);
        }
        MaterialButton materialButton = this.f11083B9tovu;
        if (!z3) {
            str = "授权";
        } else if (!z2) {
            str = "下一步";
        }
        materialButton.setText(str);
        this.f11083B9tovu.setEnabled(true);
        if (c2rE4F.AMqCpz && !AaHO0E(c2rE4F.f4767ADYaiT)) {
            z = false;
        }
        this.f11080B3GDIM.setUserInputEnabled(z);
    }

    public final void B2KMhB(int i) {
        float f = getResources().getDisplayMetrics().density;
        int i2 = 0;
        while (i2 < this.f11081B4ZgIw.getChildCount()) {
            View childAt = this.f11081B4ZgIw.getChildAt(i2);
            boolean z = i2 == i;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.width = (int) ((z ? 28 : 10) * f);
            layoutParams.height = (int) (10.0f * f);
            childAt.setLayoutParams(layoutParams);
            ((GradientDrawable) childAt.getBackground()).setColor(z ? -10794082 : -1515784);
            i2++;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 101 || i == 1 || i == 103) {
            AzWtSf();
        } else if (i == 102) {
            if (i2 == -1) {
                AcNBzu(4, "蓝牙权限", "需要蓝牙权限以连接外部设备", f11077BIYEnU);
            } else {
                AzWtSf();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
    
        if (r7 == 0) goto L21;
     */
    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.PermissionsActivity.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z;
        super.onRequestPermissionsResult(i, strArr, iArr);
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else {
                if (iArr[i2] != 0) {
                    z = false;
                    break;
                }
                i2++;
            }
        }
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "权限" : "蓝牙权限" : "位置权限" : "存储权限" : "通知权限";
        if (z) {
            Toast.makeText(this, str.concat("授权成功"), 0).show();
            AzWtSf();
            return;
        }
        int length2 = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length2) {
                OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
                String concat = str.concat("被永久禁用");
                ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
                azoqyo.AMqCpz = concat;
                azoqyo.f28ASJ6gh = "如需使用功能，请在系统设置中手动开启权限";
                a4TApA.AzWtSf("去设置", new CTkVKb(this, 2));
                a4TApA.AcNBzu("取消", null);
                a4TApA.AMqCpz();
                break;
            }
            if (androidx.core.app.AYUAbz.ARc23Z(this, strArr[i3])) {
                Toast.makeText(this, str.concat("被拒绝"), 0).show();
                break;
            }
            i3++;
        }
        AzWtSf();
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f11084BChYOn != null) {
            AzWtSf();
        }
    }
}
