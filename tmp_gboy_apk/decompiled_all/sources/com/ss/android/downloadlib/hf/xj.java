package com.ss.android.downloadlib.hf;

import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    private static final String xj = "xj";

    public static void hf(com.ss.android.downloadad.api.xj.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        String y = com.ss.android.socialbase.downloader.f.xj.w().hf("app_link_opt") == 1 ? hfVar.y() : null;
        JSONObject xj2 = com.ss.android.downloadlib.c.y.xj(new JSONObject(), hfVar);
        g.xj(xj2, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.u.xj.xj().hf("applink_click", xj2, hfVar);
        com.ss.android.downloadlib.addownload.hf.c xj3 = com.ss.android.downloadlib.c.d.xj(y, hfVar);
        if (xj3.getType() == 2) {
            if (!TextUtils.isEmpty(y)) {
                hf("dialog_by_url", xj3, xj2, hfVar);
            }
            xj3 = com.ss.android.downloadlib.c.d.xj(pl.getContext(), hfVar.kd(), hfVar);
        }
        int type = xj3.getType();
        if (type == 1) {
            hf("dialog_by_url", xj2, hfVar);
            return;
        }
        if (type == 3) {
            xj("dialog_by_package", xj2, hfVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.kd.w.xj().hf("AppLinkClickDialog default");
        } else {
            xj("dialog_by_package", xj3, xj2, hfVar);
        }
    }

    public static boolean xj(com.ss.android.downloadlib.addownload.hf.kd kdVar) {
        boolean z;
        DeepLink deepLink = kdVar.hf.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject xj2 = com.ss.android.downloadlib.c.y.xj(new JSONObject(), kdVar);
        g.xj(xj2, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.u.xj.xj().hf("applink_click", xj2, kdVar);
        com.ss.android.downloadlib.addownload.hf.c xj3 = com.ss.android.downloadlib.c.d.xj(openUrl, kdVar);
        if (xj3.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                hf("by_url", xj3, xj2, kdVar);
            }
            xj3 = com.ss.android.downloadlib.c.d.xj(pl.getContext(), kdVar.hf.getPackageName(), kdVar);
        }
        boolean z2 = false;
        if (xj(kdVar.xj) && pl.d().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = kdVar.hf;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.u.xj.xj().xj(kdVar.xj, 0);
            z = true;
        } else {
            z = false;
        }
        int type = xj3.getType();
        if (type == 1) {
            hf("by_url", xj2, kdVar);
        } else {
            if (type != 3) {
                if (type != 4) {
                    com.ss.android.downloadlib.kd.w.xj().hf("AppLinkClick default");
                } else {
                    xj("by_package", xj3, xj2, kdVar);
                }
                if (z2 && !z && ((com.ss.android.downloadlib.u.w.xj().hf() && !com.ss.android.downloadlib.u.w.xj().hf(kdVar.xj, kdVar.hf.getLogExtra())) || com.ss.android.downloadlib.u.w.xj().w())) {
                    com.ss.android.downloadlib.u.xj.xj().xj(kdVar.xj, 2);
                }
                return z2;
            }
            xj("by_package", xj2, kdVar);
        }
        z2 = true;
        if (z2) {
            com.ss.android.downloadlib.u.xj.xj().xj(kdVar.xj, 2);
        }
        return z2;
    }

    public static void hf(String str, final JSONObject jSONObject, final com.ss.android.downloadad.api.xj.xj xjVar) {
        g.xj(jSONObject, "applink_source", str);
        g.xj(jSONObject, "download_scene", Integer.valueOf(xjVar.jk()));
        com.ss.android.downloadlib.u.xj.xj().hf("deeplink_url_open", jSONObject, xjVar);
        str.getClass();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((pl.d().optInt("check_applink_mode") & 1) != 0) {
                    g.xj(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    kd.xj().xj(new u() { // from class: com.ss.android.downloadlib.hf.xj.2
                        @Override // com.ss.android.downloadlib.hf.u
                        public void xj(boolean z) {
                            com.ss.android.downloadlib.u.xj.xj().hf(z ? "deeplink_success" : "deeplink_failed", jSONObject, xjVar);
                            if (z) {
                                pl.pz();
                                pl.getContext();
                                xjVar.pz();
                                xjVar.ra();
                                xjVar.ht();
                                xjVar.kd();
                            }
                        }
                    });
                    break;
                } else {
                    pl.hf();
                    pl.getContext();
                    xjVar.pz();
                    xjVar.ra();
                    xjVar.ht();
                    xjVar.kd();
                    break;
                }
        }
    }

    public static void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        String y = hfVar.y();
        JSONObject xj2 = com.ss.android.downloadlib.c.y.xj(new JSONObject(), hfVar);
        g.xj(xj2, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.u.xj.xj().hf("applink_click", xj2, hfVar);
        com.ss.android.downloadlib.addownload.hf.c xj3 = com.ss.android.downloadlib.c.d.xj(y, hfVar);
        if (xj3.getType() == 2) {
            if (!TextUtils.isEmpty(y)) {
                hf("notify_by_url", xj3, xj2, hfVar);
            }
            xj3 = com.ss.android.downloadlib.c.d.xj(pl.getContext(), hfVar.kd(), hfVar);
        }
        int type = xj3.getType();
        if (type == 1) {
            hf("notify_by_url", xj2, hfVar);
            return;
        }
        if (type == 3) {
            xj("notify_by_package", xj2, hfVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.kd.w.xj().hf("AppLinkClickNotification default");
        } else {
            xj("notify_by_package", xj3, xj2, hfVar);
        }
    }

    public static void hf(String str, com.ss.android.downloadlib.addownload.hf.c cVar, JSONObject jSONObject, com.ss.android.downloadad.api.xj.xj xjVar) {
        g.xj(jSONObject, "applink_source", str);
        g.xj(jSONObject, "error_code", Integer.valueOf(cVar.xj()));
        g.xj(jSONObject, "download_scene", Integer.valueOf(xjVar.jk()));
        com.ss.android.downloadlib.u.xj.xj().hf("deeplink_url_open_fail", jSONObject, xjVar);
    }

    public static boolean xj(String str, com.ss.android.downloadad.api.xj.hf hfVar) {
        if (!com.ss.android.downloadlib.addownload.d.hf(hfVar.tj())) {
            return false;
        }
        if (TextUtils.isEmpty(hfVar.y()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.ss.android.socialbase.downloader.notification.hf.xj().y(hfVar.v());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.c.y.xj(jSONObject, hfVar);
        g.xj(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.u.xj.xj().hf("applink_click", hfVar);
        com.ss.android.downloadlib.addownload.hf.c xj2 = com.ss.android.downloadlib.c.d.xj(hfVar, hfVar.y(), hfVar.kd());
        int type = xj2.getType();
        if (type == 1) {
            hf("auto_by_url", jSONObject, hfVar);
            return true;
        }
        if (type == 2) {
            hf("auto_by_url", xj2, jSONObject, hfVar);
            return false;
        }
        if (type == 3) {
            xj("auto_by_package", jSONObject, hfVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        xj("auto_by_package", xj2, jSONObject, hfVar);
        return false;
    }

    public static void xj(String str, final JSONObject jSONObject, final com.ss.android.downloadad.api.xj.xj xjVar) {
        g.xj(jSONObject, "applink_source", str);
        g.xj(jSONObject, "download_scene", Integer.valueOf(xjVar.jk()));
        com.ss.android.downloadlib.u.xj.xj().hf("deeplink_app_open", jSONObject, xjVar);
        str.getClass();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((pl.d().optInt("check_applink_mode") & 1) != 0) {
                    g.xj(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    kd.xj().xj(new u() { // from class: com.ss.android.downloadlib.hf.xj.1
                        @Override // com.ss.android.downloadlib.hf.u
                        public void xj(boolean z) {
                            com.ss.android.downloadlib.u.xj.xj().hf(z ? "deeplink_success" : "deeplink_failed", jSONObject, xjVar);
                            if (z) {
                                pl.pz();
                                pl.getContext();
                                xjVar.pz();
                                xjVar.ra();
                                xjVar.ht();
                                xjVar.kd();
                            }
                        }
                    });
                    break;
                } else {
                    pl.hf();
                    pl.getContext();
                    xjVar.pz();
                    xjVar.ra();
                    xjVar.ht();
                    xjVar.kd();
                    break;
                }
        }
    }

    public static void xj(String str, com.ss.android.downloadlib.addownload.hf.c cVar, JSONObject jSONObject, com.ss.android.downloadad.api.xj.xj xjVar) {
        g.xj(jSONObject, "applink_source", str);
        g.xj(jSONObject, "error_code", Integer.valueOf(cVar.xj()));
        g.xj(jSONObject, "download_scene", Integer.valueOf(xjVar.jk()));
        com.ss.android.downloadlib.u.xj.xj().hf("deeplink_app_open_fail", jSONObject, xjVar);
    }

    public static boolean xj(com.ss.android.downloadlib.addownload.hf.kd kdVar, int i) {
        JSONObject jSONObject = new JSONObject();
        g.xj(jSONObject, "download_scene", Integer.valueOf(kdVar.jk()));
        com.ss.android.downloadlib.u.xj.xj().hf("market_click_open", jSONObject, kdVar);
        com.ss.android.downloadlib.addownload.hf.c xj2 = com.ss.android.downloadlib.c.d.xj(pl.getContext(), kdVar, kdVar.hf.getPackageName());
        String xj3 = g.xj(xj2.hf(), PointCategory.OPEN_MARKET);
        int type = xj2.getType();
        if (type == 5) {
            xj(xj3, jSONObject, kdVar, true);
        } else {
            if (type == 6) {
                g.xj(jSONObject, "error_code", Integer.valueOf(xj2.xj()));
                g.xj(jSONObject, "download_scene", Integer.valueOf(kdVar.jk()));
                com.ss.android.downloadlib.u.xj.xj().hf("market_open_failed", jSONObject, kdVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.ss.android.downloadlib.u.xj.xj().xj(kdVar.xj, i);
        return true;
    }

    public static void xj(final String str, final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.hf.kd kdVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                com.ss.android.downloadlib.kd.w.xj().xj(e, "onMarketSuccess");
                return;
            }
        }
        g.xj(jSONObject, "applink_source", str);
        g.xj(jSONObject, "download_scene", Integer.valueOf(kdVar.jk()));
        if (z) {
            com.ss.android.downloadlib.u.xj.xj().hf("market_open_success", jSONObject, kdVar);
        }
        if ((pl.d().optInt("check_applink_mode") & 4) != 0) {
            kd.xj().hf(new u() { // from class: com.ss.android.downloadlib.hf.xj.3
                @Override // com.ss.android.downloadlib.hf.u
                public void xj(boolean z2) {
                    if (!z2 && !PointCategory.OPEN_MARKET.equals(str)) {
                        xj.xj(com.ss.android.downloadlib.c.d.xj(pl.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + kdVar.kd())), kdVar, false);
                    }
                    com.ss.android.downloadlib.u.xj.xj().xj(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, kdVar);
                    if (z2) {
                        pl.pz();
                        pl.getContext();
                        kdVar.hf.getPackageName();
                    }
                }
            });
        } else {
            pl.hf();
            pl.getContext();
            kdVar.hf.getPackageName();
        }
        com.ss.android.downloadad.api.xj.hf xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(kdVar.hf.getPackageName());
        if (xj2 != null) {
            com.ss.android.downloadlib.c.pl.xj().xj(xj, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
        } else {
            com.ss.android.downloadlib.c.pl.xj().xj(xj, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
            xj2 = new com.ss.android.downloadad.api.xj.hf(kdVar.hf, kdVar.w, kdVar.u);
        }
        xj2.kd(2);
        xj2.y(System.currentTimeMillis());
        xj2.f(4);
        xj2.d(2);
        com.ss.android.downloadlib.addownload.hf.y.xj().xj(xj2);
        com.ss.android.downloadlib.c.pl.xj().xj(xj, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
        com.ss.android.downloadlib.d.xj().xj(kdVar, xj2);
    }

    public static void xj(com.ss.android.downloadlib.addownload.hf.c cVar, com.ss.android.downloadlib.addownload.hf.kd kdVar, boolean z) {
        String xj2 = g.xj(cVar.hf(), PointCategory.OPEN_MARKET);
        JSONObject jSONObject = new JSONObject();
        g.xj(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
        int type = cVar.getType();
        if (type == 5) {
            xj(xj2, jSONObject, kdVar, z);
        } else {
            if (type != 6) {
                return;
            }
            g.xj(jSONObject, "error_code", Integer.valueOf(cVar.xj()));
            g.xj(jSONObject, "download_scene", Integer.valueOf(kdVar.jk()));
            com.ss.android.downloadlib.u.xj.xj().hf("market_open_failed", jSONObject, kdVar);
        }
    }

    public static boolean xj(long j) {
        return com.ss.android.downloadlib.addownload.hf.y.xj().u(j) == null;
    }
}
