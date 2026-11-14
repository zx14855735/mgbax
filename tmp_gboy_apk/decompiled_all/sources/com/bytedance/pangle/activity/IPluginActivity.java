package com.bytedance.pangle.activity;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.pangle.plugin.Plugin;

@A5SV6n.A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IPluginActivity {
    void _requestPermissions(String[] strArr, int i);

    void attachBaseContext(Context context);

    String getPluginPkgName();

    void onCreate(Bundle bundle);

    void setPluginProxyActivity(hf hfVar, Plugin plugin);

    void setProxyTheme2Plugin(int i);
}
