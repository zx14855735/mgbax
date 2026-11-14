package com.octopus.ad.internal.utilities;

import android.content.Context;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.octopus.ad.internal.i;
import com.octopus.ad.model.c;
import com.octopus.ad.model.d;
import com.octopus.ad.model.e;
import com.octopus.ad.model.h;
import com.octopus.ad.utils.b.f;
import com.sigmob.sdk.base.models.SigMacroCommon;
import java.net.InetAddress;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class UrlUtil {
    public static String DEVICE_ID = "${DEVICE_ID}";
    public static String LOSS_REASON = "${LOSS_REASON}";
    public static String REQ_ID = "${REQ_ID}";
    public static String SDK_VERSION = "${SDK_VERSION}";
    public static String SECOND_PRICE = "${SECOND_PRICE}";
    public static String SLOT_ID = "${SLOT_ID}";
    public static String WIN_BIDDER = "${WIN_BIDDER}";
    public static String WIN_PRICE = "${WIN_PRICE}";

    public static class DNSResolver implements Runnable {
        private String domain;
        private InetAddress inetAddr;

        public DNSResolver(String str) {
            this.domain = str;
        }

        public synchronized InetAddress get() {
            return this.inetAddr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                set(InetAddress.getByName(this.domain));
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
        }

        public synchronized void set(InetAddress inetAddress) {
            this.inetAddr = inetAddress;
        }
    }

    private static String getMaxAccMultiple(String str, int i) {
        if (i > 1) {
            try {
                return String.valueOf((int) (Double.parseDouble(str) * i));
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
        }
        return str;
    }

    public static String px2dip(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && !str.equals(SigMacroCommon.DEFAULT_XY) && !str.equals(Constants.FAIL)) {
                return String.valueOf((int) ((((long) Double.parseDouble(str)) / context.getResources().getDisplayMetrics().density) + 0.5f));
            }
            return str;
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
            return str;
        }
    }

    public static String replaceClickEventUrl(String str, d dVar, e eVar) {
        if (dVar == null || eVar == null) {
            return str;
        }
        if (eVar.t() != null) {
            str = str.replace("__oct_click_type__", dVar.a() == 2 ? eVar.t().b() : dVar.a() == 3 ? eVar.t().c() : eVar.t().a());
        }
        String replace = !TextUtils.isEmpty(dVar.b()) ? str.replace("__oct_down_x__", dVar.b()) : str.replace("__oct_down_x__", eVar.d());
        String replace2 = !TextUtils.isEmpty(dVar.c()) ? replace.replace("__oct_down_y__", dVar.c()) : replace.replace("__oct_down_y__", eVar.e());
        String replace3 = !TextUtils.isEmpty(dVar.d()) ? replace2.replace("__oct_down_time__", dVar.d()) : replace2.replace("__oct_down_time__", eVar.f());
        String replace4 = !TextUtils.isEmpty(dVar.e()) ? replace3.replace("__oct_up_x__", dVar.e()) : replace3.replace("__oct_up_x__", eVar.a());
        String replace5 = !TextUtils.isEmpty(dVar.f()) ? replace4.replace("__oct_up_y__", dVar.f()) : replace4.replace("__oct_up_y__", eVar.b());
        String replace6 = !TextUtils.isEmpty(dVar.g()) ? replace5.replace("__oct_up_time__", dVar.g()) : replace5.replace("__oct_up_time__", eVar.c());
        String replace7 = !TextUtils.isEmpty(dVar.l()) ? replace6.replace("__oct_x_max_acc__", getMaxAccMultiple(dVar.l(), eVar.s())) : replace6.replace("__oct_x_max_acc__", eVar.g());
        String replace8 = !TextUtils.isEmpty(dVar.m()) ? replace7.replace("__oct_y_max_acc__", getMaxAccMultiple(dVar.m(), eVar.s())) : replace7.replace("__oct_y_max_acc__", eVar.h());
        String replace9 = !TextUtils.isEmpty(dVar.n()) ? replace8.replace("__oct_z_max_acc__", getMaxAccMultiple(dVar.n(), eVar.s())) : replace8.replace("__oct_z_max_acc__", eVar.i());
        String replace10 = !TextUtils.isEmpty(dVar.o()) ? replace9.replace("__oct_shake_acc__", dVar.o()) : replace9.replace("__oct_shake_acc__", eVar.k());
        String replace11 = !TextUtils.isEmpty(dVar.p()) ? replace10.replace("__oct_shake_ang__", dVar.p()) : replace10.replace("__oct_shake_ang__", eVar.l());
        String replace12 = !TextUtils.isEmpty(dVar.q()) ? replace11.replace("__oct_shake_cnt__", dVar.q()) : replace11.replace("__oct_shake_cnt__", eVar.j());
        String replace13 = !TextUtils.isEmpty(dVar.r()) ? replace12.replace("__oct_turn_x__", dVar.r()) : replace12.replace("__oct_turn_x__", eVar.m());
        String replace14 = !TextUtils.isEmpty(dVar.s()) ? replace13.replace("__oct_turn_y__", dVar.s()) : replace13.replace("__oct_turn_y__", eVar.n());
        String replace15 = !TextUtils.isEmpty(dVar.t()) ? replace14.replace("__oct_turn_z__", dVar.t()) : replace14.replace("__oct_turn_z__", eVar.o());
        String replace16 = !TextUtils.isEmpty(dVar.u()) ? replace15.replace("__oct_turn_time__", dVar.u()) : replace15.replace("__oct_turn_time__", eVar.p());
        String replace17 = !TextUtils.isEmpty(dVar.i()) ? replace16.replace("__oct_ms_time__", dVar.i()) : replace16.replace("__oct_ms_time__", eVar.r());
        String replace18 = !TextUtils.isEmpty(dVar.h()) ? replace17.replace("__oct_s_time__", dVar.h()) : replace17.replace("__oct_s_time__", eVar.q());
        if (!TextUtils.isEmpty(dVar.j())) {
            replace18 = replace18.replace("__oct_container_w__", dVar.j());
        }
        if (!TextUtils.isEmpty(dVar.k())) {
            replace18 = replace18.replace("__oct_container_h__", dVar.k());
        }
        return !TextUtils.isEmpty(DeviceInfo.densityDpi) ? replace18.replace("__oct_screen_ppi__", DeviceInfo.densityDpi) : replace18;
    }

    public static String replaceCloseUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str.replace(SLOT_ID, str2);
        }
        return !TextUtils.isEmpty(str3) ? str.replace(REQ_ID, str3) : str;
    }

    public static String replaceFeedBackUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str.replace(SLOT_ID, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            str = str.replace(DEVICE_ID, str3);
        }
        return str.replace(SDK_VERSION, "2.5.10.5");
    }

    public static String replaceLossUrl(String str, int i, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String replace = str.replace(WIN_PRICE, String.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            replace = replace.replace(LOSS_REASON, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            replace = replace.replace(WIN_BIDDER, str3);
        }
        return !TextUtils.isEmpty(str4) ? replace.replace(SLOT_ID, str4) : replace;
    }

    public static String replaceVideoTrackerUrl(String str, h hVar, long j, long j2) {
        if (hVar == null) {
            return str;
        }
        if (j != 0) {
            str = str.replace("__oct_video_start_ts__", String.valueOf(j));
        } else if (!TextUtils.isEmpty(hVar.a())) {
            str = str.replace("__oct_video_start_ts__", hVar.a());
        }
        return j2 == 0 ? !TextUtils.isEmpty(hVar.b()) ? str.replace("__oct_video_end_ts__", hVar.b()) : str : str.replace("__oct_video_end_ts__", String.valueOf(j2));
    }

    public static String replaceWinUrl(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String replace = str.replace(SECOND_PRICE, String.valueOf(i));
        return !TextUtils.isEmpty(str2) ? replace.replace(SLOT_ID, str2) : replace;
    }

    public static void sendClickInfoToServerWithReplace(c.i iVar, String str, String str2, String str3, String str4) {
        String b = iVar.b();
        if (TextUtils.isEmpty(b)) {
            return;
        }
        new i(b).execute();
    }

    public static void sendViewShowInfoToServer(c.i iVar) {
        String a2 = iVar.a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        new i(a2).execute();
    }

    public static boolean testDNS(String str) {
        try {
            DNSResolver dNSResolver = new DNSResolver("sdk.zhangyuyidong.cn");
            Thread thread = new Thread(dNSResolver);
            thread.start();
            thread.join(1500L);
            return dNSResolver.get() != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
