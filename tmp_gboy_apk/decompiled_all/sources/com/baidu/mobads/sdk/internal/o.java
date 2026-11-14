package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOAdEvent f9844a;
    final /* synthetic */ n b;

    public o(n nVar, IOAdEvent iOAdEvent) {
        this.b = nVar;
        this.f9844a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        IOAdEvent iOAdEvent = this.f9844a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f9844a.getType();
        if (x.aq.equals(type)) {
            List<CpuChannelResponse> a2 = l.a((JSONArray) this.f9844a.getData().get("cpuChannelList"));
            cpuChannelListListener3 = this.b.f9843a.q;
            if (cpuChannelListListener3 != null) {
                cpuChannelListListener4 = this.b.f9843a.q;
                cpuChannelListListener4.onChannelListLoaded(a2);
                return;
            }
            return;
        }
        if (x.ar.equals(type)) {
            Map<String, Object> data = this.f9844a.getData();
            int i = 0;
            if (data != null) {
                str = (String) data.get("error_message");
                Object obj = data.get("error_code");
                if (obj == null) {
                    obj = 0;
                }
                i = ((Integer) obj).intValue();
            } else {
                str = "";
            }
            cpuChannelListListener = this.b.f9843a.q;
            if (cpuChannelListListener != null) {
                cpuChannelListListener2 = this.b.f9843a.q;
                cpuChannelListListener2.onChannelListError(str, i);
            }
        }
    }
}
