package com.czhj.devicehelper.cnoaid.impl;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class l implements com.czhj.devicehelper.cnoaid.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10513a;

    public l(Context context) {
        this.f10513a = context;
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public void a(com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.f10513a == null || cVar == null) {
            return;
        }
        if (!a()) {
            com.czhj.devicehelper.cnoaid.g.a("Only supports Android 10.0 and above for Nubia");
            cVar.a(new com.czhj.devicehelper.cnoaid.f("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f10513a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
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
                throw new com.czhj.devicehelper.cnoaid.f("OAID query failed: bundle is null");
            }
            String string = call.getInt(PluginConstants.KEY_ERROR_CODE, -1) == 0 ? call.getString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a) : null;
            if (string == null || string.length() == 0) {
                throw new com.czhj.devicehelper.cnoaid.f("OAID query failed: " + call.getString("message"));
            }
            com.czhj.devicehelper.cnoaid.g.a("OAID query success: ".concat(string));
            cVar.a(string);
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
            cVar.a(e);
        }
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
