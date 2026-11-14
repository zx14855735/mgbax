package com.fl.saas.base.inner.spread;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.fl.saas.base.inner.YdAdTempHelper;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;
import com.sigmob.sdk.downloader.core.breakpoint.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdSpreadActivity extends Activity {
    private String id;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.yd_activity_spread);
        this.id = getIntent().getStringExtra(f.f13353a);
        YdAdTempHelper.getInstance().addSpreadListener(this.id, new YdAdTempHelper.SpreadActivityListener() { // from class: com.fl.saas.base.inner.spread.ADYaiT
            @Override // com.fl.saas.base.inner.YdAdTempHelper.SpreadActivityListener
            public final void closeActivity() {
                YdSpreadActivity.this.finish();
            }
        });
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
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_root);
        SpreadLoadListener.SpreadAd spreadAd = YdAdTempHelper.getInstance().getSpreadAd();
        if (spreadAd != null) {
            spreadAd.show(frameLayout);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        YdAdTempHelper.getInstance().removeSpreadListener(this.id);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
