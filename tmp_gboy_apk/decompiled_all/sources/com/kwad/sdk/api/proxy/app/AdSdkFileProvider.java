package com.kwad.sdk.api.proxy.app;

import A5SV6n.A2egSU;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.loader.b;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdSdkFileProvider extends FileProvider {
    private static final String SP_INSTALLER_CHECK_PKG_AB_SWITCH = "installerCheckPkgAbSwitch";
    private static final String SP_INSTALLER_EXTRA_PKGS_KEY = "installerCheckExtraPkgs";
    private static final String SP_OPEN_FILE_RECORD = "SP_OPEN_FILE_RECORD";
    private static final String TAG = "AdSdkFileProvider";
    public static long sLaunchTime;
    private static Set<String> sSystemInstallers;

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        sSystemInstallers = copyOnWriteArraySet;
        copyOnWriteArraySet.add("com.android.packageinstaller");
        sSystemInstallers.add("com.google.android.packageinstaller");
        zVHvdQ();
    }

    private void checkLocalConfig() {
        try {
            String readString = ApiConfigUtils.readString(getContext(), SP_INSTALLER_EXTRA_PKGS_KEY, "");
            if (TextUtils.isEmpty(readString)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(getDecodeString(readString));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    sSystemInstallers.add(string);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static String getDecodeString(String str) {
        return (TextUtils.isEmpty(str) || !ApiBase64.isEncodeKsSdk(str)) ? str : ApiBase64.decodeKsSdk(str);
    }

    private boolean isInstallerPkgCheckOpen() {
        return ApiConfigUtils.readInt(getContext(), SP_INSTALLER_CHECK_PKG_AB_SWITCH, 0) == 1;
    }

    private static /* synthetic */ void zVHvdQ() {
        char[] charArray = "[WU\u0016_YU]\u0016ZWA\u0016KP]TT\u0016rVQzJQ\\_]".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '8');
        }
        String str = new String(charArray);
        char[] charArray2 = "[TQVQL".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '8');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        sLaunchTime = System.currentTimeMillis();
        try {
            KSLifecycleObserver.getInstance().init(getContext().getApplicationContext());
        } catch (Throwable unused) {
        }
        return super.onCreate();
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        boolean z;
        String jSONArray;
        Objects.toString(uri);
        if (isInstallerPkgCheckOpen()) {
            checkLocalConfig();
            String callingPackage = getCallingPackage();
            z = sSystemInstallers.contains(callingPackage);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callingPkg", callingPackage);
                jSONObject.put("checkResult", String.valueOf(z));
                jSONObject.put(ContentProviderManager.PROVIDER_URI, uri.toString());
                String b = b.b(getContext(), SP_OPEN_FILE_RECORD, "");
                if (TextUtils.isEmpty(b)) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(jSONObject);
                    jSONArray = jSONArray2.toString();
                } else {
                    JSONArray jSONArray3 = new JSONArray(b);
                    jSONArray3.put(jSONObject);
                    jSONArray = jSONArray3.toString();
                }
                b.c(getContext(), SP_OPEN_FILE_RECORD, jSONArray);
            } catch (Throwable unused) {
            }
        } else {
            z = true;
        }
        if (z) {
            return super.openFile(uri, str);
        }
        return null;
    }
}
