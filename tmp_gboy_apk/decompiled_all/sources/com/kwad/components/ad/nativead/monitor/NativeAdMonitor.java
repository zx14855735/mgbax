package com.kwad.components.ad.nativead.monitor;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.c.a;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class NativeAdMonitor {

    @KsJson
    public static class NativeReportMsg extends a implements Serializable {
        public static final long serialVersionUID = 478072683065430299L;
        public String containerName;
        public String containerType;
        public int state;

        public static NativeReportMsg obtain() {
            return new NativeReportMsg();
        }

        public NativeReportMsg setContainerName(String str) {
            this.containerName = str;
            return this;
        }

        public NativeReportMsg setContainerType(String str) {
            this.containerType = str;
            return this;
        }

        public NativeReportMsg setState(int i) {
            this.state = i;
            return this;
        }
    }

    public static void a(ViewGroup viewGroup, int i) {
        String str = "";
        if (viewGroup != null) {
            try {
                str = viewGroup.getClass().getName();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        if (viewGroup instanceof FrameLayout) {
            a("frameLayout", str, i);
            return;
        }
        if (viewGroup instanceof LinearLayout) {
            a("linearLayout", str, i);
        } else if (viewGroup instanceof RelativeLayout) {
            a("relativeLayout", str, i);
        } else {
            a(MediationConfigUserInfoForSegment.GENDER_UNKNOWN, str, i);
        }
    }

    private static void c(a aVar) {
        try {
            c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_native_container_monitor", "state").b(BusinessType.AD_NATIVE).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("reportNativeContainerLog", e.toString());
        }
    }

    public static void fx() {
        c(NativeReportMsg.obtain().setState(6));
    }

    public static void fy() {
        c(NativeReportMsg.obtain().setState(7));
    }

    private static void a(String str, String str2, int i) {
        c(NativeReportMsg.obtain().setContainerType(str).setContainerName(str2).setState(i));
    }
}
