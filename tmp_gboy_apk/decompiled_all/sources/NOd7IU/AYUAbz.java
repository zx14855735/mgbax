package NOd7IU;

import NGepWW.B4ZgIw;
import NUY5pn.BpkvW3;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int f5868A2egSU;

    static {
        int i = AMqCpz.AMqCpz;
        f5868A2egSU = 10084000;
        cMOxg();
    }

    private static /* synthetic */ void cMOxg() {
        char[] charArray = "\u0004\b\nI\u0000\u0006\n\u0002I\u0005\b\u001eI\u0014\u000f\u0002\u000b\u000bI-\t\u000e%\u0015\u000e\u0003\u0000\u0002".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'g');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0004\u000b\u000e\t\u000e\u0013".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'g');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:0|1|2|3|4|(5:8|2c|14|15|(2:17|(2:19|20))(2:22|23))|38|(4:40|(1:42)|43|(11:45|(2:84|85)(1:47)|48|49|50|(6:52|(1:54)|79|59|(1:61)(1:(1:66))|(1:63)(1:64))(1:80)|56|(1:58)(4:67|(2:73|74)|69|(1:71)(1:72))|59|(0)(0)|(0)(0)))|88|(0)(0)|48|49|50|(0)(0)|56|(0)(0)|59|(0)(0)|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ec, code lost:
    
        if (NOd7IU.AmA8tU.A5SV6n(r5, r3) == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f8, code lost:
    
        if (NOd7IU.AmA8tU.A5SV6n(r5, r3) == null) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0134 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int A2egSU(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: NOd7IU.AYUAbz.A2egSU(android.content.Context):int");
    }

    public boolean A4TApA(int i) {
        int i2 = AMqCpz.AMqCpz;
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    public abstract Intent A5SV6n(int i);

    public Intent ADYaiT(Context context, int i, String str) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            int i2 = BpkvW3.f6032A2egSU;
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(fromParts);
            return intent;
        }
        if (context != null && AlLFFp.B2KMhB(context)) {
            int i3 = BpkvW3.f6032A2egSU;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder("gcore_");
        sb.append(f5868A2egSU);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                EsrwYR.A4TApA A2egSU2 = B4ZgIw.A2egSU(context);
                sb.append(A2egSU2.f2550AlLFFp.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String sb2 = sb.toString();
        int i4 = BpkvW3.f6032A2egSU;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(f.f13353a, "com.google.android.gms");
        if (!TextUtils.isEmpty(sb2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
        }
        intent3.setData(appendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }
}
