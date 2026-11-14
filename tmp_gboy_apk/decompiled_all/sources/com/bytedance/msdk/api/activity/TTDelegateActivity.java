package com.bytedance.msdk.api.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.msdk.core.hf;
import com.bytedance.msdk.core.pl.kd;
import com.bytedance.msdk.xj.kd.w;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class TTDelegateActivity extends Activity {
    private Intent xj;

    public static class xj implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    private void hf() {
        try {
            int intExtra = this.xj.getIntExtra(PointParamKey.TYPE, 0);
            if (intExtra == 1) {
                xj(intExtra, this.xj.getIntArrayExtra("permissions"));
                return;
            }
            if (intExtra == 2) {
                xj(this.xj.getStringExtra("permission_id_key"), this.xj.getStringArrayExtra("permission_content_key"));
            } else if (intExtra != 3) {
                finish();
            } else {
                xj(intExtra, (int[]) null);
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private void xj() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xj();
        this.xj = getIntent();
        if (hf.getContext() == null) {
            hf.xj(this);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (hf.getContext() == null) {
            hf.xj(this);
        }
        try {
            setIntent(intent);
            this.xj = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        kd.xj().xj(this, strArr, iArr);
        y.u(new xj());
        finish();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            hf();
        }
    }

    private void xj(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    kd.xj().xj(this, strArr, new com.bytedance.msdk.core.pl.y() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.1
                        @Override // com.bytedance.msdk.core.pl.y
                        public void xj() {
                            com.bytedance.msdk.core.pl.xj.xj(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.msdk.core.pl.y
                        public void xj(String str2) {
                            com.bytedance.msdk.core.pl.xj.xj(str, str2);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            } else {
                w.xj(MediationConstant.TAG, "已经有权限");
                finish();
                return;
            }
        }
        finish();
    }

    private void xj(int i, int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ArrayList arrayList = new ArrayList();
                if (i != 1) {
                    if (i == 3) {
                        arrayList.add(g.h);
                        arrayList.add(g.g);
                        arrayList.add(g.c);
                        arrayList.add(g.j);
                    }
                } else if (iArr != null && iArr.length > 0) {
                    for (int i2 : iArr) {
                        if (i2 == 1) {
                            arrayList.add(g.h);
                            arrayList.add(g.g);
                        } else if (i2 == 2) {
                            arrayList.add(g.c);
                        } else if (i2 == 3) {
                            arrayList.add(g.j);
                        }
                    }
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                kd.xj().xj(this, strArr, new com.bytedance.msdk.core.pl.y() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.2
                    @Override // com.bytedance.msdk.core.pl.y
                    public void xj() {
                        w.xj("TMe", "-------=----- onGranted");
                        y.u(new xj());
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.msdk.core.pl.y
                    public void xj(String str) {
                        w.xj("TMe", "-------=----- onDenied: ".concat(String.valueOf(str)));
                        g.c.equals(str);
                        y.u(new xj());
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
                finish();
                return;
            }
        }
        w.xj(MediationConstant.TAG, "已经有Read phone state权限");
        finish();
    }
}
