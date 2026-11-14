package com.sigmob.sdk.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.C;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.LandscapeAdActivity;
import com.sigmob.sdk.base.common.LandscapeTransparentAdActivity;
import com.sigmob.sdk.base.common.PortraitAdActivity;
import com.sigmob.sdk.base.common.PortraitTransparentAdActivity;
import com.sigmob.sdk.base.common.TransparentAdActivity;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class BaseAdActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13037a = "LandPage";
    public static final String b = "reward";
    public static final String c = "mraid";
    public static final String d = "mraid_two";
    public static final String e = "LandNative";
    public static final String f = "DisLike";
    protected static final String g = "ad_view_class_name";
    protected static final String h = "adUnit_requestId_key";
    public static final String i = "land_page_url";
    public static final String j = "new_interstitial";

    private static Intent a(Context context, Class<? extends BaseAdActivity> cls, String str, String str2) {
        Intent putExtra = new Intent(context, cls).setFlags(C.ENCODING_PCM_MU_LAW).putExtra(g, str2).putExtra(h, str);
        int requestedOrientation = context instanceof Activity ? ((Activity) context).getRequestedOrientation() : 3;
        if (requestedOrientation != 7 && requestedOrientation != 6) {
            requestedOrientation = context.getResources().getDisplayMetrics().widthPixels > context.getResources().getDisplayMetrics().heightPixels ? 6 : 7;
        }
        putExtra.putExtra(n.x, requestedOrientation);
        putExtra.putExtra(Constants.BROADCAST_IDENTIFIER_KEY, str);
        return putExtra;
    }

    public static void b(Context context, Class<? extends BaseAdActivity> cls, String str) {
        try {
            Intent putExtra = new Intent(context, cls).setFlags(C.ENCODING_PCM_MU_LAW).putExtra(g, f).putExtra(h, str);
            putExtra.putExtra(Constants.BROADCAST_IDENTIFIER_KEY, "dislike_broadcastIdentifier");
            context.startActivity(putExtra);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, BaseAdUnit baseAdUnit) {
        try {
            context.startActivity(a(context, cls, baseAdUnit.getUuid(), f13037a));
        } catch (Throwable th) {
            new HashMap().put("error", th.getMessage());
        }
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, String str) {
        a(context, cls, str, null, f13037a);
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, String str, Bundle bundle, String str2) {
        try {
            int display_orientation = com.sigmob.sdk.base.common.h.c(str).getDisplay_orientation();
            if (display_orientation == 0) {
                display_orientation = ClientMetadata.getInstance().getOrientationInt().intValue();
            }
            Class cls2 = TransparentAdActivity.class;
            if (cls != cls2) {
                cls2 = display_orientation != 1 ? display_orientation != 2 ? AdActivity.class : LandscapeAdActivity.class : PortraitAdActivity.class;
            } else if (display_orientation == 1) {
                cls2 = PortraitTransparentAdActivity.class;
            } else if (display_orientation == 2) {
                cls2 = LandscapeTransparentAdActivity.class;
            }
            Intent a2 = a(context, cls2, str, str2);
            if (bundle != null) {
                a2.putExtras(bundle);
            }
            context.startActivity(a2);
        } catch (Throwable th) {
            HashMap hashMap = new HashMap();
            hashMap.put("error", th.getMessage());
            BaseBroadcastReceiver.a(context, str, hashMap, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
        }
    }
}
