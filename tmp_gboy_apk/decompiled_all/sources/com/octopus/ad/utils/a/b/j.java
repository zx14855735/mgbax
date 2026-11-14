package com.octopus.ad.utils.a.b;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class j implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12689a;

    public j(Context context) {
        this.f12689a = context;
    }

    @Override // com.octopus.ad.utils.a.d
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12689a == null || cVar == null) {
            return;
        }
        if (!a()) {
            com.octopus.ad.utils.a.f.a("Only supports Android 10.0 and above for Nubia");
            cVar.a(new com.octopus.ad.utils.a.e("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f12689a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                acquireContentProviderClient.release();
            } else {
                acquireContentProviderClient.release();
            }
            if (call == null) {
                throw new com.octopus.ad.utils.a.e("OAID query failed: bundle is null");
            }
            String string = call.getInt(PluginConstants.KEY_ERROR_CODE, -1) == 0 ? call.getString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a) : null;
            if (string == null || string.length() == 0) {
                throw new com.octopus.ad.utils.a.e("OAID query failed: " + call.getString("message"));
            }
            com.octopus.ad.utils.a.f.a("OAID query success: ".concat(string));
            cVar.a(string);
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            cVar.a(e);
        }
    }
}
