package com.fl.saas.base.inner.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.fl.saas.base.inner.YdAdTempHelper;
import com.fl.saas.config.utils.DeepLinkJumpUtil;
import com.fl.saas.config.utils.DeviceUtil;
import com.sigmob.sdk.downloader.core.breakpoint.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdInterstitialActivity extends Activity {
    private String id;

    public static void startMe(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) YdInterstitialActivity.class);
        intent.putExtra(f.f13353a, str);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        DeepLinkJumpUtil.getInstance().reportActivityResult(i, i2, this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (Build.VERSION.SDK_INT != 26) {
                if (DeviceUtil.getOrientation(this) == 2) {
                    setRequestedOrientation(6);
                } else {
                    setRequestedOrientation(7);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.id = getIntent().getStringExtra(f.f13353a);
        YdAdTempHelper.getInstance().notify(this.id, this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        YdAdTempHelper.getInstance().removeListener(this.id);
    }
}
