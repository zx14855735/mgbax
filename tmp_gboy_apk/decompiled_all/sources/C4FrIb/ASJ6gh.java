package C4FrIb;

import ADYaiT.CtFAbx;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.base.cache.DatabaseHelper;
import com.sigmob.sdk.base.n;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final A5SV6n f1553A2egSU = new A5SV6n(0);

    static {
        euTsXab();
    }

    public static AmA8tU A2egSU(Context context, AYUAbz aYUAbz) {
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = aYUAbz.f1554A2egSU;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(CtFAbx.BChYOn("No package found for authority: ", str));
        }
        String str2 = resolveContentProvider.packageName;
        String str3 = aYUAbz.f1555A4TApA;
        if (!str2.equals(str3)) {
            throw new PackageManager.NameNotFoundException(CtFAbx.AmA8tU("Found content provider ", str, ", but package was not ", str3));
        }
        Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        A5SV6n a5SV6n = f1553A2egSU;
        Collections.sort(arrayList, a5SV6n);
        List list = aYUAbz.f1557ADYaiT;
        if (list == null) {
            list = BTvldC.AZkASS.A4TApA(resources, 0);
        }
        int i = 0;
        loop1: while (true) {
            if (i >= list.size()) {
                resolveContentProvider = null;
                break;
            }
            ArrayList arrayList2 = new ArrayList((Collection) list.get(i));
            Collections.sort(arrayList2, a5SV6n);
            if (arrayList.size() == arrayList2.size()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                        break;
                    }
                }
                break loop1;
            }
            i++;
        }
        return resolveContentProvider == null ? new AmA8tU(1, (AzWtSf[]) null) : new AmA8tU(0, query(context, aYUAbz, resolveContentProvider.authority, null));
    }

    private static /* synthetic */ void euTsXab() {
        char[] charArray = "ÐÜÞ\u009dÔÒÞÖ\u009dÑÜÊ\u009dÀÛÖßß\u009dùÝÚñÁÚ×ÔÖ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 179);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÐßÚÝÚÇ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 179);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static AzWtSf[] query(Context context, AYUAbz aYUAbz, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme(IAdInterListener.AdProdType.PRODUCT_CONTENT).authority(str).build();
        Uri build2 = new Uri.Builder().scheme(IAdInterListener.AdProdType.PRODUCT_CONTENT).authority(str).appendPath(n.z).build();
        ADYaiT aMqCpz = Build.VERSION.SDK_INT < 24 ? new AMqCpz(context, build) : new ARc23Z(context, build);
        Cursor cursor = null;
        try {
            cursor = aMqCpz.query(build, new String[]{DatabaseHelper.COLUMN_ID, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aYUAbz.f1556A5SV6n}, null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    arrayList2.add(new AzWtSf(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            if (cursor != null) {
                cursor.close();
            }
            aMqCpz.close();
            return (AzWtSf[]) arrayList.toArray(new AzWtSf[0]);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            aMqCpz.close();
            throw th;
        }
    }
}
