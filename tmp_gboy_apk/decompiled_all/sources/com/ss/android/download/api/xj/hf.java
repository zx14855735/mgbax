package com.ss.android.download.api.xj;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.ss.android.download.api.config.d;
import com.ss.android.download.api.config.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements d {
    private pz xj;

    @Override // com.ss.android.download.api.config.d
    public void xj(Activity activity, String[] strArr, pz pzVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.xj = pzVar;
            activity.requestPermissions(strArr, 1);
        } else if (pzVar != null) {
            pzVar.xj();
        }
    }

    @Override // com.ss.android.download.api.config.d
    public boolean xj(Context context, String str) {
        return (context == null || str == null || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }

    @Override // com.ss.android.download.api.config.d
    public void xj(Activity activity, int i, String[] strArr, int[] iArr) {
        pz pzVar;
        if (iArr.length <= 0 || (pzVar = this.xj) == null) {
            return;
        }
        int i2 = iArr[0];
        if (i2 == -1) {
            pzVar.xj(strArr[0]);
        } else if (i2 == 0) {
            pzVar.xj();
        }
    }
}
