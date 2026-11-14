package com.bumptech.glide;

import ADYaiT.CtFAbx;
import COJEAR.DuwtYk;
import D8MqeW.B4ZgIw;
import D8MqeW.B7CMnp;
import DaOi9o.BniPrB;
import android.animation.TimeInterpolator;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.EdgeEffect;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.alliance.ssp.ad.utils.DeviceUtil;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.hf;
import com.google.gson.Gson;
import com.kuaishou.weapon.p0.t;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A5SV6n implements AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static Method f9883A2egSU = null;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static boolean f9884A4TApA = false;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static Method f9885A5SV6n = null;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static boolean f9886ADYaiT = false;
    public static boolean AMqCpz = true;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static String f9887ARc23Z = "";

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static String f9888ASJ6gh = "";

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static String f9889AYUAbz = "";

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static String f9890AZOQYO = "";

    /* renamed from: AZkASS, reason: collision with root package name */
    public static String f9891AZkASS = "";

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static Handler f9892AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final byte[] f9893AcNBzu = new byte[0];

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static boolean f9894AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static String f9895AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static Class f9896AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static Field f9897B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static Field f9898B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static boolean f9899B3GDIM;

    static {
        kinNy();
    }

    public static int A2egSU(Context context, float f) {
        if (context == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
        } else {
            f = (f * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return (int) f;
    }

    public static String A4TApA() {
        String str = f9888ASJ6gh;
        if (str != null && !str.isEmpty()) {
            return f9888ASJ6gh;
        }
        try {
            f9888ASJ6gh = String.valueOf(TimeZone.getDefault().getRawOffset() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f9888ASJ6gh;
    }

    public static String A5SV6n(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                StringBuilder sb = new StringBuilder(32);
                sb.append("unknown status code: ");
                sb.append(i);
                return sb.toString();
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return cb.l;
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
        }
    }

    public static String ADYaiT(Context context) {
        String str = f9890AZOQYO;
        if (str != null && !str.isEmpty()) {
            return f9890AZOQYO;
        }
        if (context == null) {
            return "";
        }
        try {
            f9890AZOQYO = context.getResources().getConfiguration().locale.getCountry();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f9890AZOQYO;
    }

    public static String AMqCpz(String str, String str2) {
        byte[] bArr;
        try {
            if (JrXYwF.A4TApA.B25kr6(str) && JrXYwF.A4TApA.B25kr6(str2)) {
                String str3 = "7600B4C005A5D4A09318E9AFFE02FE0B5487DC951E892ED1";
                String str4 = "D3579468AA6A2371";
                String decode = URLDecoder.decode(str, "utf-8");
                byte[] bArr2 = GIl1rw.A4TApA.f3028A2egSU;
                try {
                    bArr = GIl1rw.A4TApA.A5SV6n(decode.getBytes("UTF-8"), GIl1rw.A2egSU.ADYaiT(""));
                } catch (Exception e) {
                    e.printStackTrace();
                    bArr = null;
                }
                String str5 = bArr == null ? "" : new String(bArr);
                if (!JrXYwF.A4TApA.AlLFFp(str5)) {
                    String[] split = str5.split(",");
                    str3 = split[0];
                    str4 = split[1];
                }
                return new K1Z3yj.A2egSU(str3, 22, str4).AZkASS(URLDecoder.decode(str2, "utf-8"));
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public static void ARc23Z() {
        if (f9894AlLFFp) {
            System.currentTimeMillis();
        }
    }

    public static void ASJ6gh(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4) {
        linearLayout.addView(linearLayout2);
        linearLayout.addView(linearLayout3);
        linearLayout.addView(linearLayout4);
    }

    public static void AYUAbz(String str) {
        if (f9894AlLFFp) {
            if (str != null) {
                System.currentTimeMillis();
                DeviceUtil.AYUAbz();
            } else {
                System.currentTimeMillis();
                DeviceUtil.AYUAbz();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.alliance.ssp.ad.deviceinfolib.DeviceInfoManager$ApplicationPO, java.lang.Object] */
    public static String AZOQYO(Context context) {
        ArrayList arrayList = new ArrayList();
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            if ((packageInfo.applicationInfo.flags & 1) == 0) {
                ?? r4 = new Object() { // from class: com.alliance.ssp.ad.deviceinfolib.DeviceInfoManager$ApplicationPO
                    private String app_name;
                    private String package_name;
                    private String timestamp;
                    private String version;

                    public String getApp_name() {
                        return this.app_name;
                    }

                    public String getPackage_name() {
                        return this.package_name;
                    }

                    public String getTimestamp() {
                        return this.timestamp;
                    }

                    public String getVersion() {
                        return this.version;
                    }

                    public void setApp_name(String str) {
                        this.app_name = str;
                    }

                    public void setPackage_name(String str) {
                        this.package_name = str;
                    }

                    public void setTimestamp(String str) {
                        this.timestamp = str;
                    }

                    public void setVersion(String str) {
                        this.version = str;
                    }
                };
                r4.setApp_name(packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString());
                r4.setPackage_name(packageInfo.packageName);
                r4.setVersion(packageInfo.versionName);
                r4.setTimestamp(packageInfo.firstInstallTime + "");
                arrayList.add(r4);
            }
        }
        return new Gson().toJson(arrayList);
    }

    public static String[] AZkASS(String str) {
        String str2;
        String str3;
        String str4 = "";
        if (JrXYwF.A4TApA.B25kr6(str)) {
            try {
                str2 = URLEncoder.encode(GIl1rw.A4TApA.A2egSU(), "UTF-8");
                try {
                    str4 = URLEncoder.encode(new K1Z3yj.A2egSU("7600B4C005A5D4A09318E9AFFE02FE0B5487DC951E892ED1", 22, "D3579468AA6A2371").AcNBzu(str), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e = e;
                    e.printStackTrace();
                    str3 = str4;
                    str4 = str2;
                    return new String[]{str4, str3};
                }
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                str2 = "";
            }
            str3 = str4;
            str4 = str2;
        } else {
            str3 = "";
        }
        return new String[]{str4, str3};
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if (r9.bottom <= r11.top) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        if (r8 == 17) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        if (r8 != 66) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        r10 = CkXcdM(r8, r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if (r8 == 17) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        if (r8 == 33) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r8 == 66) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r8 != 130) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        r8 = r11.bottom;
        r9 = r9.bottom;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
    
        if (r10 >= java.lang.Math.max(1, r8 - r9)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        throw new java.lang.IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        r8 = r11.right;
        r9 = r9.right;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        r8 = r9.top;
        r9 = r11.top;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        r8 = r9.left;
        r9 = r11.left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0032, code lost:
    
        if (r9.right <= r11.left) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0039, code lost:
    
        if (r9.top >= r11.bottom) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0040, code lost:
    
        if (r9.left >= r11.right) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean AaHO0E(int r8, android.graphics.Rect r9, android.graphics.Rect r10, android.graphics.Rect r11) {
        /*
            boolean r0 = AcNBzu(r8, r9, r10)
            boolean r1 = AcNBzu(r8, r9, r11)
            if (r1 != 0) goto L75
            if (r0 != 0) goto Le
            goto L75
        Le:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r2 = 33
            r3 = 66
            r4 = 17
            r5 = 1
            if (r8 == r4) goto L3c
            if (r8 == r2) goto L35
            if (r8 == r3) goto L2e
            if (r8 != r1) goto L28
            int r6 = r9.bottom
            int r7 = r11.top
            if (r6 > r7) goto L74
            goto L42
        L28:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L2e:
            int r6 = r9.right
            int r7 = r11.left
            if (r6 > r7) goto L74
            goto L42
        L35:
            int r6 = r9.top
            int r7 = r11.bottom
            if (r6 < r7) goto L74
            goto L42
        L3c:
            int r6 = r9.left
            int r7 = r11.right
            if (r6 < r7) goto L74
        L42:
            if (r8 == r4) goto L74
            if (r8 != r3) goto L47
            goto L74
        L47:
            int r10 = CkXcdM(r8, r9, r10)
            if (r8 == r4) goto L69
            if (r8 == r2) goto L64
            if (r8 == r3) goto L5f
            if (r8 != r1) goto L59
            int r8 = r11.bottom
            int r9 = r9.bottom
        L57:
            int r8 = r8 - r9
            goto L6e
        L59:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L5f:
            int r8 = r11.right
            int r9 = r9.right
            goto L57
        L64:
            int r8 = r9.top
            int r9 = r11.top
            goto L57
        L69:
            int r8 = r9.left
            int r9 = r11.left
            goto L57
        L6e:
            int r8 = java.lang.Math.max(r5, r8)
            if (r10 >= r8) goto L75
        L74:
            return r5
        L75:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.A5SV6n.AaHO0E(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean AcNBzu(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static Class AlLFFp(Context context) {
        if (f9896AzWtSf == null && !f9899B3GDIM) {
            try {
                f9896AzWtSf = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            f9899B3GDIM = true;
        }
        return f9896AzWtSf;
    }

    public static String AmA8tU(Context context) {
        String str = f9891AZkASS;
        if (str != null && !str.isEmpty()) {
            return f9891AZkASS;
        }
        if (context == null) {
            return "";
        }
        try {
            f9891AZkASS = context.getResources().getConfiguration().locale.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f9891AZkASS;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0084 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int B3GDIM(android.content.Context r9, java.lang.String r10) {
        /*
            int r0 = android.os.Process.myPid()
            int r1 = android.os.Process.myUid()
            java.lang.String r2 = r9.getPackageName()
            int r0 = r9.checkPermission(r10, r0, r1)
            r3 = -1
            if (r0 != r3) goto L14
            goto L37
        L14:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r0 < r4) goto L1f
            java.lang.String r10 = androidx.core.app.AcNBzu.ADYaiT(r10)
            goto L20
        L1f:
            r10 = 0
        L20:
            r5 = 0
            if (r10 != 0) goto L24
            goto L83
        L24:
            if (r2 != 0) goto L38
            android.content.pm.PackageManager r2 = r9.getPackageManager()
            java.lang.String[] r2 = r2.getPackagesForUid(r1)
            if (r2 == 0) goto L37
            int r6 = r2.length
            if (r6 > 0) goto L34
            goto L37
        L34:
            r2 = r2[r5]
            goto L38
        L37:
            return r3
        L38:
            int r3 = android.os.Process.myUid()
            java.lang.String r6 = r9.getPackageName()
            r7 = 1
            java.lang.Class<android.app.AppOpsManager> r8 = android.app.AppOpsManager.class
            if (r3 != r1) goto L74
            boolean r3 = java.util.Objects.equals(r6, r2)
            if (r3 == 0) goto L74
            r3 = 29
            if (r0 < r3) goto L67
            android.app.AppOpsManager r0 = androidx.core.app.AlLFFp.A5SV6n(r9)
            int r3 = android.os.Binder.getCallingUid()
            int r2 = androidx.core.app.AlLFFp.A2egSU(r0, r10, r3, r2)
            if (r2 == 0) goto L5e
            goto L81
        L5e:
            java.lang.String r9 = androidx.core.app.AlLFFp.A4TApA(r9)
            int r2 = androidx.core.app.AlLFFp.A2egSU(r0, r10, r1, r9)
            goto L81
        L67:
            if (r0 < r4) goto L80
            java.lang.Object r9 = androidx.core.app.AcNBzu.A2egSU(r9, r8)
            android.app.AppOpsManager r9 = (android.app.AppOpsManager) r9
            int r7 = androidx.core.app.AcNBzu.A5SV6n(r9, r10, r2)
            goto L80
        L74:
            if (r0 < r4) goto L80
            java.lang.Object r9 = androidx.core.app.AcNBzu.A2egSU(r9, r8)
            android.app.AppOpsManager r9 = (android.app.AppOpsManager) r9
            int r7 = androidx.core.app.AcNBzu.A5SV6n(r9, r10, r2)
        L80:
            r2 = r7
        L81:
            if (r2 != 0) goto L84
        L83:
            return r5
        L84:
            r9 = -2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.A5SV6n.B3GDIM(android.content.Context, java.lang.String):int");
    }

    public static B4ZgIw B4ZgIw(int i) {
        int i2 = (i & 1) != 0 ? 8 : 10;
        if (i2 >= 3) {
            return NOd7IU.AlLFFp.A4TApA(i2, 1.0f / ((float) Math.cos(B7CMnp.f2045A4TApA / i2)), new D8MqeW.A2egSU(2), null);
        }
        throw new IllegalArgumentException("Circle must have at least three vertices");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void B7CMnp(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            B7CMnp(((InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof BmvVmW.AZkASS) {
            B7CMnp(((BmvVmW.AaHO0E) ((BmvVmW.AZkASS) drawable)).f1526B2KMhB);
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Drawable child = drawableContainerState.getChild(i);
            if (child != null) {
                B7CMnp(child);
            }
        }
    }

    public static float BChYOn(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return CikNvS.AMqCpz.A4TApA(edgeEffect);
        }
        return 0.0f;
    }

    public static Set BI9f7h() {
        try {
            Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", new Class[0]).invoke(null, new Object[0]);
            if (invoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) invoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class BNL6CD(RiEDdo.A4TApA a4TApA) {
        RXb0Sz.ARc23Z.AMqCpz(a4TApA, "<this>");
        Class A2egSU2 = ((RXb0Sz.A5SV6n) a4TApA).A2egSU();
        if (A2egSU2.isPrimitive()) {
            String name = A2egSU2.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return A2egSU2;
    }

    public static int BPw6Q8(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return BmvVmW.A4TApA.A2egSU(drawable);
        }
        if (!f9886ADYaiT) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f9885A5SV6n = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f9886ADYaiT = true;
        }
        Method method = f9885A5SV6n;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception unused2) {
                f9885A5SV6n = null;
            }
        }
        return 0;
    }

    public static float BTvldC(String[] strArr, int i) {
        float parseFloat = Float.parseFloat(strArr[i]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static void COJEAR(JSONObject jSONObject, ActivityManager activityManager) {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", memoryInfo.totalMem);
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    public static boolean CQhlFr(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            int i2 = rect.right;
            int i3 = rect2.right;
            return (i2 > i3 || rect.left >= i3) && rect.left > rect2.left;
        }
        if (i == 33) {
            int i4 = rect.bottom;
            int i5 = rect2.bottom;
            return (i4 > i5 || rect.top >= i5) && rect.top > rect2.top;
        }
        if (i == 66) {
            int i6 = rect.left;
            int i7 = rect2.left;
            return (i6 < i7 || rect.right <= i7) && rect.right < rect2.right;
        }
        if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        return (i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom;
    }

    public static boolean CTkVKb(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float CikNvS(B25kr6.AaHO0E r6, B25kr6.AaHO0E r7, float r8) {
        /*
            java.lang.String r0 = "xValues"
            RXb0Sz.ARc23Z.AMqCpz(r6, r0)
            java.lang.String r0 = "yValues"
            RXb0Sz.ARc23Z.AMqCpz(r7, r0)
            r0 = 0
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 > 0) goto L95
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 > 0) goto L95
            int r0 = r6.f1000A4TApA
            RfS3U2.A5SV6n r0 = RfS3U2.AMqCpz.A2egSU(r0)
            java.util.Iterator r0 = r0.iterator()
        L1f:
            r1 = r0
            RfS3U2.A4TApA r1 = (RfS3U2.A4TApA) r1
            boolean r1 = r1.f7901AmA8tU
            if (r1 == 0) goto L8d
            r1 = r0
            RD2OKB.BIYEnU r1 = (RD2OKB.BIYEnU) r1
            int r1 = r1.A2egSU()
            float r2 = r6.A4TApA(r1)
            int r3 = r1 + 1
            int r4 = r6.f1000A4TApA
            int r4 = r3 % r4
            float r4 = r6.A4TApA(r4)
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 < 0) goto L48
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 > 0) goto L1f
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 > 0) goto L1f
            goto L50
        L48:
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 >= 0) goto L50
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 > 0) goto L1f
        L50:
            int r0 = r6.f1000A4TApA
            int r3 = r3 % r0
            float r0 = r6.A4TApA(r3)
            float r2 = r6.A4TApA(r1)
            float r0 = r0 - r2
            float r0 = D8MqeW.B7CMnp.A5SV6n(r0)
            float r2 = r7.A4TApA(r3)
            float r3 = r7.A4TApA(r1)
            float r2 = r2 - r3
            float r2 = D8MqeW.B7CMnp.A5SV6n(r2)
            r3 = 981668463(0x3a83126f, float:0.001)
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L77
            r6 = 1056964608(0x3f000000, float:0.5)
            goto L81
        L77:
            float r6 = r6.A4TApA(r1)
            float r8 = r8 - r6
            float r6 = D8MqeW.B7CMnp.A5SV6n(r8)
            float r6 = r6 / r0
        L81:
            float r7 = r7.A4TApA(r1)
            float r2 = r2 * r6
            float r2 = r2 + r7
            float r6 = D8MqeW.B7CMnp.A5SV6n(r2)
            return r6
        L8d:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.String r7 = "Collection contains no element matching the predicate."
            r6.<init>(r7)
            throw r6
        L95:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Invalid progress: "
            r6.<init>(r7)
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.A5SV6n.CikNvS(B25kr6.AaHO0E, B25kr6.AaHO0E, float):float");
    }

    public static int CkXcdM(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i2 = rect2.top;
            i3 = rect.bottom;
        }
        return Math.max(0, i2 - i3);
    }

    public static int CmUvjW(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static float CqNSpT(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return CikNvS.AMqCpz.A5SV6n(edgeEffect, f, f2);
        }
        CikNvS.ADYaiT.A2egSU(edgeEffect, f, f2);
        return f;
    }

    public static void CrfGsy(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (IllegalAccessException e) {
                DaOi9o(cls, e);
                throw null;
            } catch (InstantiationException e2) {
                DaOi9o(cls, e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                DaOi9o(cls, e3);
                throw null;
            } catch (InvocationTargetException e4) {
                DaOi9o(cls, e4);
                throw null;
            }
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    public static final float CtFAbx(float f, float f2) {
        float abs = Math.abs(f - f2);
        return Math.min(abs, 1.0f - abs);
    }

    public static final B4ZgIw CtxOCS(float f, D8MqeW.A2egSU a2egSU, List list) {
        RXb0Sz.ARc23Z.AMqCpz(a2egSU, "rounding");
        float f2 = 2;
        float f3 = f / f2;
        float f4 = 0.0f - f3;
        float f5 = 1.0f / f2;
        float f6 = 0.0f - f5;
        float f7 = f3 + 0.0f;
        float f8 = f5 + 0.0f;
        return NOd7IU.AlLFFp.A5SV6n(new float[]{f7, f8, f4, f8, f4, f6, f7, f6}, a2egSU, list, 0.0f, 0.0f);
    }

    public static int D07BeM(Context context, int i, int i2) {
        TypedValue A2egSU2 = P3rngT.A4TApA.A2egSU(context, i);
        return (A2egSU2 == null || A2egSU2.type != 16) ? i2 : A2egSU2.data;
    }

    public static TimeInterpolator D6DOie(Context context, int i, Interpolator interpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return interpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String valueOf = String.valueOf(typedValue.string);
        if (!CTkVKb(valueOf, "cubic-bezier") && !CTkVKb(valueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (!CTkVKb(valueOf, "cubic-bezier")) {
            if (CTkVKb(valueOf, "path")) {
                return new PathInterpolator(AMqCpz.BChYOn(CtFAbx.AMqCpz(1, 5, valueOf)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(valueOf));
        }
        String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
        if (split.length == 4) {
            return new PathInterpolator(BTvldC(split, 0), BTvldC(split, 1), BTvldC(split, 2), BTvldC(split, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
    }

    public static void D8MqeW(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            DuwtYk.A2egSU(window, z);
            return;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
    }

    public static boolean D8cQ8b(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return BmvVmW.A4TApA.A4TApA(drawable, i);
        }
        if (!f9884A4TApA) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f9883A2egSU = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f9884A4TApA = true;
        }
        Method method = f9883A2egSU;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i));
                return true;
            } catch (Exception unused2) {
                f9883A2egSU = null;
            }
        }
        return false;
    }

    public static void D9tr6l(Drawable drawable, int i) {
        BmvVmW.A2egSU.ASJ6gh(drawable, i);
    }

    public static void DAk1zC(Drawable drawable, ColorStateList colorStateList) {
        BmvVmW.A2egSU.AYUAbz(drawable, colorStateList);
    }

    public static void DG07BK(Drawable drawable, PorterDuff.Mode mode) {
        BmvVmW.A2egSU.AZOQYO(drawable, mode);
    }

    public static final B4ZgIw DUi7mC(int i, float f, D8MqeW.A2egSU a2egSU) {
        RXb0Sz.ARc23Z.AMqCpz(a2egSU, "rounding");
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Star radii must both be greater than 0");
        }
        if (f >= 1.0f) {
            throw new IllegalArgumentException("innerRadius must be less than radius");
        }
        float[] fArr = new float[i * 4];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f2 = B7CMnp.f2045A4TApA / i;
            long ADYaiT2 = B7CMnp.ADYaiT(1.0f, 2 * f2 * i3);
            fArr[i2] = JrXYwF.A4TApA.COJEAR(ADYaiT2) + 0.0f;
            fArr[i2 + 1] = JrXYwF.A4TApA.CQhlFr(ADYaiT2) + 0.0f;
            long ADYaiT3 = B7CMnp.ADYaiT(f, f2 * ((i3 * 2) + 1));
            int i4 = i2 + 3;
            fArr[i2 + 2] = JrXYwF.A4TApA.COJEAR(ADYaiT3) + 0.0f;
            i2 += 4;
            fArr[i4] = JrXYwF.A4TApA.CQhlFr(ADYaiT3) + 0.0f;
        }
        return NOd7IU.AlLFFp.A5SV6n(fArr, a2egSU, null, 0.0f, 0.0f);
    }

    public static void DXuj49(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            BniPrB.A4TApA(viewGroup, z);
        } else if (AMqCpz) {
            try {
                BniPrB.A4TApA(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                AMqCpz = false;
            }
        }
    }

    public static void DaOi9o(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }

    public static String DcUJf1() {
        String str = f9895AmA8tU;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            f9895AmA8tU = NOd7IU.AlLFFp.D6yqiO();
        } catch (Throwable unused) {
        }
        String str2 = f9895AmA8tU;
        return str2 == null ? "" : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Drawable DdagTj(Drawable drawable) {
        return drawable instanceof BmvVmW.AZkASS ? ((BmvVmW.AaHO0E) ((BmvVmW.AZkASS) drawable)).f1526B2KMhB : drawable;
    }

    public static final void DjONCG(B25kr6.AaHO0E aaHO0E) {
        RXb0Sz.ARc23Z.AMqCpz(aaHO0E, t.b);
        int i = aaHO0E.f1000A4TApA;
        if (i == 0) {
            throw new NoSuchElementException("FloatList is empty.");
        }
        float f = aaHO0E.f999A2egSU[i - 1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            float A4TApA2 = aaHO0E.A4TApA(i2);
            if (A4TApA2 < 0.0f || A4TApA2 >= 1.0f) {
                throw new IllegalArgumentException("FloatMapping - Progress outside of range: ".concat(B25kr6.AaHO0E.A5SV6n(aaHO0E, 31)).toString());
            }
            if (CtFAbx(A4TApA2, f) <= 1.0E-4f) {
                throw new IllegalArgumentException("FloatMapping - Progress repeats a value: ".concat(B25kr6.AaHO0E.A5SV6n(aaHO0E, 31)).toString());
            }
            if (A4TApA2 < f && (i3 = i3 + 1) > 1) {
                throw new IllegalArgumentException("FloatMapping - Progress wraps more than once: ".concat(B25kr6.AaHO0E.A5SV6n(aaHO0E, 31)).toString());
            }
            i2++;
            f = A4TApA2;
        }
    }

    public static long Dphsd2(File file) {
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            j = (file2.isDirectory() ? Dphsd2(file2) : file2.length()) + j;
        }
        return j;
    }

    public static String DuwtYk(Context context) {
        String path;
        try {
            if (hf.xj(context) != null) {
                path = hf.xj(context).getPath();
            } else {
                File xj = hf.xj(context, "/data/data/" + context.getPackageName() + "/files/", 0);
                path = xj != null ? xj.getPath() : null;
            }
            return path != null ? path : "/sdcard/";
        } catch (Exception e) {
            pl.xj(e);
            return "/sdcard/";
        }
    }

    public static Drawable DvK7DB(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 || (drawable instanceof BmvVmW.AZOQYO)) {
            return drawable;
        }
        BmvVmW.AaHO0E aaHO0E = new BmvVmW.AaHO0E();
        aaHO0E.f1524AzWtSf = aaHO0E.A4TApA();
        aaHO0E.ASJ6gh(drawable);
        if (BmvVmW.AaHO0E.f1520B4ZgIw == null) {
            try {
                BmvVmW.AaHO0E.f1520B4ZgIw = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception unused) {
            }
        }
        return aaHO0E;
    }

    public static long DyaChj(int i) {
        if (i < 0) {
            return 0L;
        }
        return i * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
    }

    public static void ECyGFg(JSONObject jSONObject) {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", DyaChj(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", DyaChj(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", DyaChj(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", DyaChj(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", DyaChj(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", DyaChj(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", DyaChj(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", DyaChj(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", memoryInfo.getTotalPrivateClean());
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", DyaChj(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", memoryInfo.getTotalSharedClean());
        jSONObject2.put("totalSharedDirty", DyaChj(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", DyaChj(memoryInfo.getTotalSwappablePss()));
        jSONObject.put("memory_info", jSONObject2);
    }

    public static void EGM26s(JSONObject jSONObject, ActivityManager activityManager) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        jSONObject2.put("max_memory", runtime.maxMemory());
        jSONObject2.put("free_memory", runtime.freeMemory());
        jSONObject2.put("total_memory", runtime.totalMemory());
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    private static /* synthetic */ void kinNy() {
        char[] charArray = "`ln-dbnf-alz-pkfoo-ImjAqjgdf".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 3);
        }
        String str = new String(charArray);
        char[] charArray2 = "`ojmjw".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 3);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public abstract int AzWtSf(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float B25kr6(int i);

    public boolean B2KMhB() {
        return false;
    }

    public abstract int B9tovu(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int BIYEnU();

    public abstract int BJ7GGh();

    public abstract int BV3sI0();

    public abstract int BmvVmW();

    public abstract int BniPrB(View view);

    public abstract int BpkvW3(CoordinatorLayout coordinatorLayout);

    public abstract int C2rE4F();

    public abstract int C4FrIb(View view, ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int CASmeH();

    public abstract ViewPropertyAnimator CNPG0E(int i, View view);

    public abstract boolean CSDoyG(float f);

    public abstract boolean CcAIMM(View view);

    public abstract boolean Cd8JRx(float f, float f2);

    public void D6yqiO() {
    }

    public abstract boolean DRlcZ9(View view, float f);

    public abstract void DV2E8K();

    public abstract void DXnQ0V();

    public abstract void Ddcejp(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

    public abstract void De4eam(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2);
}
