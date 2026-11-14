package com.bytedance.embedapplog;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.m;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class jw implements m {
    @Override // com.bytedance.embedapplog.m
    public m.xj hf(Context context) {
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
            if (acquireContentProviderClient == null) {
                return null;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i >= 24) {
                acquireContentProviderClient.release();
            } else {
                acquireContentProviderClient.release();
            }
            if (call == null) {
                return null;
            }
            if (call.getInt(PluginConstants.KEY_ERROR_CODE, -1) == 0) {
                m.xj xjVar = new m.xj();
                xjVar.hf = call.getString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
                return xjVar;
            }
            String string = call.getString("message");
            if (!TextUtils.isEmpty(string)) {
                cu.hf(string);
            }
            return null;
        } catch (Exception e) {
            cu.xj(e);
            return null;
        }
    }

    @Override // com.bytedance.embedapplog.m
    public boolean xj(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }
}
