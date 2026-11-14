package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.br;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestUtil;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.i;
import com.sigmob.windad.WindAdError;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13199a = "e";

    public interface a {
        void a(int i, String str, String str2, LoadAdRequest loadAdRequest);

        void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest);
    }

    public static void a(LoadAdRequest loadAdRequest, a aVar) {
        i.a(3, f13199a, "load", loadAdRequest, (Map<String, Object>) null);
        if (Networking.getSigRequestQueue() == null) {
            a(aVar, WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), "request queue is null.", null, loadAdRequest);
            return;
        }
        try {
            String R = loadAdRequest.getAdType() == 5 ? o.a().R() : o.a().t();
            try {
                if (!TextUtils.isEmpty(loadAdRequest.getBidToken())) {
                    R = o.a().u();
                }
            } catch (Throwable th) {
                i.f(f13199a, "loadAd: placementId = " + loadAdRequest.getPlacementId() + ", error = " + th.getMessage(), new Object[0]);
            }
            if (TextUtils.isEmpty(R)) {
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_BAD_REQUEST;
                a(aVar, windAdError.getErrorCode(), windAdError.getMessage(), null, loadAdRequest);
            } else if (SigmobRequestUtil.isConnection(new URL(R).getHost())) {
                Networking.getSigRequestQueue().add(new com.sigmob.sdk.base.network.a(R, loadAdRequest, aVar));
            } else {
                a(aVar, WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), "network is disconnection.", null, loadAdRequest);
            }
        } catch (Throwable th2) {
            a(aVar, WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), th2.getMessage(), null, loadAdRequest);
        }
    }

    public static void a(a aVar, int i, String str, String str2, LoadAdRequest loadAdRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
        hashMap.put(br.c, str);
        i.a(6, f13199a, "load(failure)", loadAdRequest, hashMap);
        if (aVar == null) {
            return;
        }
        aVar.a(i, str, str2, loadAdRequest);
        com.sigmob.sdk.manager.d.a().a(loadAdRequest);
    }

    public static void a(a aVar, List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
        if (com.sigmob.sdk.base.utils.e.b(list)) {
            Iterator<BaseAdUnit> it = list.iterator();
            while (it.hasNext()) {
                i.a(3, f13199a, "load(success)", it.next(), (Map<String, Object>) null);
            }
        }
        if (aVar == null) {
            return;
        }
        aVar.a(list, loadAdRequest);
        com.sigmob.sdk.manager.d.a().a(loadAdRequest);
    }
}
