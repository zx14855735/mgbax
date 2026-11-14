package com.alliance.ssp.ad.manager;

import ADYaiT.CtFAbx;
import android.content.Context;
import com.alliance.ssp.ad.utils.TimeInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ClickCacheManager {

    public class A2egSU extends TypeToken {
    }

    @A5SV6n.A2egSU
    public static List<Long> getClickCacheTimes(Context context, String str) {
        Set<String> stringSet = context.getSharedPreferences("click_cache_pref", 0).getStringSet(CtFAbx.BChYOn("click_cache_times", str), new HashSet());
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(Long.parseLong(it.next())));
        }
        return arrayList;
    }

    @A5SV6n.A2egSU
    public static List<TimeInfo> parseJsonList(String str) {
        return (List) new Gson().fromJson(str, new A2egSU().getType());
    }
}
