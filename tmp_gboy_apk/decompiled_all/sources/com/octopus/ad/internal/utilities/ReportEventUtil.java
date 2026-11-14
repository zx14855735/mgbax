package com.octopus.ad.internal.utilities;

import android.text.TextUtils;
import com.octopus.ad.internal.i;
import com.octopus.ad.utils.b.f;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ReportEventUtil {
    private static final String TAG = "ReportEventUtil";

    public static void report(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            f.a(TAG, "ReportEventUtil:" + str);
            if (!TextUtils.isEmpty(str)) {
                new i(str).execute();
            }
        }
    }
}
