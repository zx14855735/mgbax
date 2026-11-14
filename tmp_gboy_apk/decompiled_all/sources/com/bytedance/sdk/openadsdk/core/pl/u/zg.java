package com.bytedance.sdk.openadsdk.core.pl.u;

import ADYaiT.BpkvW3;
import IzHBwY.AYUAbz;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pl.u.w;
import com.bytedance.sdk.openadsdk.core.pz;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.views.r;
import com.ss.android.download.api.config.DownloadMarketInterceptor;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.u;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class zg extends com.bytedance.sdk.openadsdk.core.wo.u {
    private static volatile zg xj;
    private Function<SparseArray<Object>, Object> d;
    private final Context hf;
    private Map<Integer, AdDownloadModel.Builder> w = new ConcurrentHashMap();
    private Map<Integer, AdDownloadModel> u = new ConcurrentHashMap();
    private Map<Integer, AdDownloadController.Builder> kd = new ConcurrentHashMap();
    private Map<Integer, AdDownloadController> y = new ConcurrentHashMap();
    private Map<Integer, AdDownloadEventConfig.Builder> c = new ConcurrentHashMap();
    private Map<Integer, AdDownloadEventConfig> f = new ConcurrentHashMap();

    private zg(Context context) {
        this.hf = context;
    }

    private DownloadMarketInterceptor c(Object obj) {
        if (obj instanceof DownloadMarketInterceptor) {
            return (DownloadMarketInterceptor) obj;
        }
        return null;
    }

    private IDownloadButtonClickListener d(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        return null;
    }

    private OnItemClickListener f(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private Function<SparseArray<Object>, Object> hf() {
        Function<SparseArray<Object>, Object> function = this.d;
        if (function != null) {
            return function;
        }
        if (!com.bytedance.sdk.openadsdk.zg.w.u.hf(ai.w)) {
            return null;
        }
        this.d = com.bytedance.sdk.openadsdk.core.f.zg().y(3);
        HashMap hashMap = new HashMap();
        hashMap.put("n", com.bytedance.sdk.openadsdk.core.f.zg().r());
        this.d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(159).xj(Map.class).xj(0, hashMap).hf());
        return this.d;
    }

    private AdDownloadModel i(int i) {
        return this.u.get(Integer.valueOf(i));
    }

    private DownloadController kd(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private void le(int i) {
        this.w.remove(Integer.valueOf(i));
        this.u.remove(Integer.valueOf(i));
        this.kd.remove(Integer.valueOf(i));
        this.y.remove(Integer.valueOf(i));
        this.c.remove(Integer.valueOf(i));
        this.f.remove(Integer.valueOf(i));
    }

    private int lm(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return 0;
        }
        return ua.getDownloadMode();
    }

    private int my(int i) {
        return i + 1;
    }

    private AdDownloadModel.Builder oa(int i) {
        return this.w.get(Integer.valueOf(i));
    }

    private AdDownloadEventConfig si(int i) {
        return this.f.get(Integer.valueOf(i));
    }

    private DownloadEventConfig u(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private AdDownloadController ua(int i) {
        return this.y.get(Integer.valueOf(i));
    }

    private static boolean w() {
        Field declaredField;
        try {
            try {
                declaredField = com.ss.android.downloadlib.u.class.getDeclaredField("hf");
                declaredField.setAccessible(true);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            Field declaredField2 = com.ss.android.downloadlib.u.class.getDeclaredField("xj");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(null);
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                return intValue > 107000925 || (intValue <= 4061200 && intValue > 3000000);
            }
        }
        return declaredField.get(null) instanceof Integer;
    }

    public static zg xj(Context context) {
        if (xj == null) {
            synchronized (zg.class) {
                try {
                    if (xj == null) {
                        xj = new zg(context);
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private com.bytedance.sdk.openadsdk.zg.w.xj.xj y(Object obj) {
        if (BpkvW3.BmvVmW(obj)) {
            return new com.bytedance.sdk.openadsdk.zg.w.xj.xj(obj);
        }
        return null;
    }

    public long a(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return 0L;
        }
        return i2.getExtraValue();
    }

    public boolean ai(int i) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return true;
        }
        return si.isEnableClickEvent();
    }

    public boolean am(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return false;
        }
        return ua.enableAH();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return i == -99999986 ? (T) xj().sparseArray() : (T) call(i, pluginValueSet, cls);
    }

    public String aq(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getFileName();
    }

    public String b(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getNotificationJumpUrl();
    }

    public boolean bl(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return false;
        }
        return i2.needIndependentProcess();
    }

    public <T> T call(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i != 20) {
            return (T) xj(cls, i, (pluginValueSet == null || pluginValueSet.objectValue(0, Map.class) == null) ? new HashMap<>() : (Map) pluginValueSet.objectValue(0, Map.class));
        }
        xj((Bundle) pluginValueSet.objectValue(0, Bundle.class));
        return null;
    }

    public JSONObject cy(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.getExtra();
    }

    public boolean da(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return false;
        }
        return i2.distinctDir();
    }

    public boolean dc(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return false;
        }
        return i2.isInExternalPublicDir();
    }

    public String dk(int i) {
        AdDownloadEventConfig si = si(i);
        return si == null ? "" : si.getClickInstallLabel();
    }

    public void dq(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.forceHideToast();
    }

    public String e(int i) {
        AdDownloadEventConfig si = si(i);
        return si == null ? "" : si.getRefer();
    }

    public long en(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return 0L;
        }
        return i2.getId();
    }

    public String et(int i) {
        AdDownloadEventConfig si = si(i);
        return si == null ? "" : si.getStorageDenyLabel();
    }

    public String eu(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getMimeType();
    }

    public long ff(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return 0L;
        }
        return i2.getExpectFileLength();
    }

    public int ft(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return 1;
        }
        return i2.getFunnelType();
    }

    public boolean g(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return false;
        }
        return ua.enableNewActivity();
    }

    public boolean gh(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return true;
        }
        return i2.isAd();
    }

    public List<String> gj(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.getClickTrackUrl();
    }

    public String gy(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getPackageName();
    }

    public boolean h(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return false;
        }
        return i2.autoInstallWithoutNotification();
    }

    public boolean hl(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return false;
        }
        return i2.isNeedWifi();
    }

    public String ht(int i) {
        AdDownloadEventConfig si = si(i);
        return si == null ? "" : si.getClickPauseLabel();
    }

    public Object io(int i) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return null;
        }
        return si.getExtraEventObject();
    }

    public JSONObject j(int i) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return null;
        }
        return si.getParamsJson();
    }

    public String jk(int i) {
        AdDownloadEventConfig si = si(i);
        return si == null ? "" : si.getClickLabel();
    }

    public boolean k(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return true;
        }
        return i2.isAutoInstall();
    }

    public String l(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getMd5();
    }

    public int lw(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return 0;
        }
        return i2.getVersionCode();
    }

    public boolean n(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return true;
        }
        return i2.isShowToast();
    }

    public String nb(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getAppIcon();
    }

    public boolean ne(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? com.ss.android.download.api.w.hf.xj(com.ss.android.socialbase.downloader.f.xj.xj(s(i)), eu(i)) : i2.shouldDownloadWithPatchApply();
    }

    public String op(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getLogExtra();
    }

    public boolean p(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return false;
        }
        return ua.enableShowComplianceDialog();
    }

    public boolean pl(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return false;
        }
        return ua.isAutoDownloadOnCardShow();
    }

    public String pz(int i) {
        AdDownloadEventConfig si = si(i);
        return si == null ? "" : si.getClickStartLabel();
    }

    public boolean q(int i) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return false;
        }
        return si.isEnableV3Event();
    }

    public void qd(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.forceHideNotification();
    }

    public boolean qt(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return false;
        }
        return ua.enableAM();
    }

    public List<String> r(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.getBackupUrls();
    }

    public String ra(int i) {
        AdDownloadEventConfig si = si(i);
        return si == null ? "" : si.getClickPauseLabel();
    }

    public String rg(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getStartToast();
    }

    public JSONObject s(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.getDownloadSettings();
    }

    public int se(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return 2;
        }
        return i2.getExecutorGroup();
    }

    public DeepLink ss(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.getDeepLink();
    }

    public String t(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getStartToast();
    }

    public Object tf(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return null;
        }
        return ua.getExtraObject();
    }

    public Map<String, String> tj(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.getHeaders();
    }

    public void tu(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.forceWifi();
    }

    public String v(int i) {
        AdDownloadEventConfig si = si(i);
        return si == null ? "" : si.getClickItemTag();
    }

    public com.ss.android.download.api.model.u vl(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.getQuickAppModel();
    }

    public boolean vm(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return false;
        }
        return i2.isInExternalPublicDir();
    }

    public String wa(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getVersionName();
    }

    public String wn(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getFilePath();
    }

    public String wo(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getDownloadUrl();
    }

    public String ws(int i) {
        AdDownloadModel i2 = i(i);
        return i2 == null ? "" : i2.getName();
    }

    public int x(int i) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return 0;
        }
        return si.getDownloadScene();
    }

    public int xv(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return 0;
        }
        return i2.getModelType();
    }

    public String yo(int i) {
        AdDownloadEventConfig si = si(i);
        return si == null ? "" : si.getClickButtonTag();
    }

    public boolean yy(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return true;
        }
        return i2.isShowNotification();
    }

    public JSONObject z(int i) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return null;
        }
        return si.getExtraJson();
    }

    public boolean zb(int i) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return true;
        }
        return i2.enablePause();
    }

    public boolean zg(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return false;
        }
        return ua.enableOppoAutoDownload();
    }

    private void kd(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickLabel");
        int intValue = ((Integer) map.get("downloadScene")).intValue();
        String str4 = (String) map.get("refer");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("paramsJson");
        String str5 = (String) map.get("clickStartLabel");
        String str6 = (String) map.get("clickContinueLabel");
        String str7 = (String) map.get("clickPauseLabel");
        String str8 = (String) map.get("storageDenyLabel");
        String str9 = (String) map.get("clickInstallLabel");
        boolean booleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject3 = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickLabel(str3).setClickStartLabel(str5).setClickContinueLabel(str6).setClickPauseLabel(str7).setStorageDenyLabel(str8).setClickInstallLabel(str9).setIsEnableClickEvent(booleanValue).setDownloadScene(intValue).setIsEnableV3Event(booleanValue2).setRefer(str4).setExtraJson(jSONObject).setParamsJson(jSONObject2);
        this.c.put(Integer.valueOf(i), paramsJson);
        if (jSONObject3 != null) {
            paramsJson.setExtraEventObject(jSONObject3);
        }
        this.f.put(Integer.valueOf(i), paramsJson.build());
    }

    private void u(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickStartLabel");
        String str4 = (String) map.get("clickContinueLabel");
        String str5 = (String) map.get("clickPauseLabel");
        String str6 = (String) map.get("storageDenyLabel");
        String str7 = (String) map.get("clickInstallLabel");
        boolean booleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickStartLabel(str3).setClickContinueLabel(str4).setClickPauseLabel(str5).setStorageDenyLabel(str6).setClickInstallLabel(str7).setIsEnableClickEvent(booleanValue).setIsEnableV3Event(booleanValue2);
        this.c.put(Integer.valueOf(i), isEnableV3Event);
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.f.put(Integer.valueOf(i), isEnableV3Event.build());
    }

    private void y(int i, int i2) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return;
        }
        ua.setDownloadMode(i2);
    }

    public AdDownloadModel am(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setMimeType(str);
    }

    public boolean c(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return false;
        }
        return ua.shouldUseNewWebView();
    }

    public JSONObject d(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return null;
        }
        return ua.getExtraJson();
    }

    public int f(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return 0;
        }
        return ua.getInterceptFlag();
    }

    public AdDownloadModel g(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setNotificationJumpUrl(str);
    }

    public AdDownloadModel p(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setAppIcon(str);
    }

    public AdDownloadModel pl(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setDownloadUrl(str);
    }

    public AdDownloadModel qt(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setFilePath(str);
    }

    public AdDownloadModel tf(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setPackageName(str);
    }

    public AdDownloadModel zg(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setFileName(str);
    }

    public AdDownloadModel e(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setVersionName(str);
    }

    public void c(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.setStartToast(str);
    }

    public AdDownloadModel d(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setLogExtra(str);
    }

    public void f(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.setSdkMonitorScene(str);
    }

    public int y(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return 1;
        }
        return ua.getDowloadChunkCount();
    }

    private void y(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long longValue = ((Long) map.get("expectFileLength")).longValue();
        String str = (String) map.get(TKDownloadReason.KSAD_TK_MD5);
        long longValue2 = ((Long) map.get("extraValue")).longValue();
        boolean booleanValue = ((Boolean) map.get("isAd")).booleanValue();
        int intValue = ((Integer) map.get("modelType")).intValue();
        List<String> list = (List) map.get("clickTrackUrl");
        List<String> list2 = (List) map.get("backupUrls");
        String str2 = (String) map.get("notificationJumpUrl");
        String str3 = (String) map.get("mimeType");
        Map<String, String> map2 = (Map) map.get("headers");
        boolean booleanValue2 = ((Boolean) map.get("isShowToast")).booleanValue();
        boolean booleanValue3 = ((Boolean) map.get("needWifi")).booleanValue();
        String str4 = (String) map.get("fileName");
        int intValue2 = ((Integer) map.get("versionCode")).intValue();
        String str5 = (String) map.get("versionName");
        String str6 = (String) map.get("quickAppModelOpenUrl");
        com.ss.android.download.api.model.u xj2 = new u.xj().xj(str6).hf((String) map.get("quickAppModelExtraData")).xj();
        int intValue3 = ((Integer) map.get("executorGroup")).intValue();
        String str7 = (String) map.get("startToast");
        String str8 = (String) map.get("sdkMonitorScene");
        boolean booleanValue4 = ((Boolean) map.get("autoInstall")).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get("distinctDir")).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get("enablePause")).booleanValue();
        long longValue3 = ((Long) map.get(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a)).longValue();
        String str9 = (String) map.get("appIcon");
        boolean booleanValue7 = ((Boolean) map.get("isShowNotification")).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue();
        String str10 = (String) map.get("logExtra");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("downloadSettings");
        String str11 = (String) map.get("filePath");
        String str12 = (String) map.get("downloadUrl");
        String str13 = (String) map.get("appName");
        String str14 = (String) map.get("packageName");
        boolean booleanValue9 = ((Boolean) map.get("isNeedIndependentProcess")).booleanValue();
        String str15 = (String) map.get("openUrl");
        String str16 = (String) map.get("webTitle");
        String str17 = (String) map.get("webUrl");
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(longValue).setMd5(str).setId(longValue3).setExtraValue(longValue2).setIsAd(booleanValue).setModelType(intValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(booleanValue2).setIsShowNotification(booleanValue7).setNeedWifi(booleanValue3).setFileName(str4).setVersionCode(intValue2).setVersionName(str5).setQuickAppModel(xj2).setAutoInstallWithoutNotification(booleanValue8).setExecutorGroup(intValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(booleanValue4).setDistinctDir(booleanValue5).setEnablePause(booleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.zg.2
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str18, String str19) {
                return zg.this.xj(str18, str19);
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str11)) {
            fileUriProvider.setFilePath(str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            fileUriProvider.setDownloadUrl(str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            fileUriProvider.setAppName(str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            fileUriProvider.setPackageName(str14);
        }
        fileUriProvider.setNeedIndependentProcess(booleanValue9);
        fileUriProvider.setDeepLink(xj(longValue3, str15, str16, str17));
        this.w.put(Integer.valueOf(i), fileUriProvider);
        this.u.put(Integer.valueOf(i), fileUriProvider.build());
    }

    public AdDownloadModel c(int i, boolean z) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setIsShowNotification(z);
    }

    public AdDownloadModel d(int i, boolean z) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setAutoInstallWithoutNotification(z);
    }

    public AdDownloadModel f(int i, boolean z) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setNeedIndependentProcess(z);
    }

    public <T> T xj(Class<T> cls, int i, Map<String, Object> map) {
        Object obj = map.get("hashCode");
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        AdDownloadModel i2 = i(intValue);
        switch (i) {
            case 3:
                qt.xj(((Integer) map.get("hid")).intValue());
                break;
            case 4:
                qt.hf().xj(i2 == null ? (String) map.get("downloadUrl") : i2.getDownloadUrl(), intValue);
                le(intValue);
                break;
            case 5:
                qt.hf().xj(this.hf, intValue, hf(map.get("downloadStatusChangeListener")), i2 == null ? w(map.get("downloadModel")) : i2);
                break;
            case 6:
                break;
            case 7:
                qt.w();
                break;
            case 8:
                qt.hf().xj(i2 == null ? (String) map.get("downloadUrl") : i2.getDownloadUrl(), ((Boolean) map.get("force")).booleanValue());
                break;
            case 9:
                qt.xj(((Integer) map.get("hid")).intValue(), (w.xj) map.get("onEventLogHandler"));
                break;
            case 10:
                qt.xj((String) map.get("downloadPath"));
                break;
            case 12:
                Uri uri = (Uri) map.get(ContentProviderManager.PROVIDER_URI);
                AdDownloadModel w = i2 == null ? w(map.get("downloadModel")) : i2;
                DownloadEventConfig si = si(intValue);
                if (si == null) {
                    si = u(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig = si;
                DownloadController ua = ua(intValue);
                if (ua == null) {
                    ua = kd(map.get("downloadController"));
                }
                DownloadController downloadController = ua;
                IDownloadButtonClickListener d = d(map.get("downloadButtonClickListener"));
                if (!xj(d)) {
                    break;
                } else {
                    break;
                }
            case 13:
                boolean booleanValue = ((Boolean) map.get("isDisableDialog")).booleanValue();
                String str = (String) map.get("userAgent");
                DownloadModel w2 = i2 == null ? w(map.get("downloadModel")) : i2;
                DownloadEventConfig si2 = si(intValue);
                if (si2 == null) {
                    si2 = u(map.get("downloadEventConfig"));
                }
                DownloadController ua2 = ua(intValue);
                if (ua2 == null) {
                    ua2 = kd(map.get("downloadController"));
                }
                DownloadController downloadController2 = ua2;
                DownloadStatusChangeListener hf = hf(map.get("downloadStatusChangeListener"));
                IDownloadButtonClickListener d2 = d(map.get("downloadButtonClickListener"));
                if (xj(d2)) {
                    qt.hf().kd().xj(this.hf, str, booleanValue, w2, si2, downloadController2, hf, intValue, d2);
                    break;
                } else {
                    qt.hf().kd().xj(this.hf, str, booleanValue, w2, si2, downloadController2, hf, intValue);
                    break;
                }
            case 14:
                break;
            case 16:
                String downloadUrl = i2 == null ? (String) map.get("downloadUrl") : i2.getDownloadUrl();
                long longValue = i2 == null ? ((Long) map.get(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a)).longValue() : i2.getId();
                int intValue2 = ((Integer) map.get("action_type_button")).intValue();
                DownloadEventConfig si3 = si(intValue);
                if (si3 == null) {
                    si3 = u(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig2 = si3;
                DownloadController ua3 = ua(intValue);
                if (ua3 == null) {
                    ua3 = kd(map.get("downloadController"));
                }
                qt.hf().xj(downloadUrl, longValue, intValue2, downloadEventConfig2, ua3);
                break;
            case 17:
                String downloadUrl2 = i2 == null ? (String) map.get("downloadUrl") : i2.getDownloadUrl();
                long longValue2 = ((Long) map.get(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a)).longValue();
                int intValue3 = ((Integer) map.get("action_type_button")).intValue();
                DownloadEventConfig si4 = si(intValue);
                if (si4 == null) {
                    si4 = u(map.get("downloadEventConfig"));
                }
                DownloadEventConfig downloadEventConfig3 = si4;
                DownloadController ua4 = ua(intValue);
                if (ua4 == null) {
                    ua4 = kd(map.get("downloadController"));
                }
                qt.hf().xj(downloadUrl2, longValue2, intValue3, downloadEventConfig3, ua4, f(map.get("itemClickListener")), d(map.get("downloadButtonClickListener")));
                break;
            case 18:
                T t = (T) Boolean.valueOf(qt.hf().kd().xj(i2 == null ? ((Long) map.get(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a)).longValue() : i2.getId(), intValue));
                le(intValue);
                break;
            case 19:
                break;
            case 23:
                if (((Boolean) map.get("mateIsEmpty")).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.w.put(Integer.valueOf(intValue), builder);
                    this.u.put(Integer.valueOf(intValue), builder.build());
                    break;
                } else {
                    hf(intValue, map);
                    break;
                }
            case 24:
                xj(intValue, (String) map.get("appIcon"), (String) map.get("appName"), (String) map.get("packageName"));
                break;
            case 25:
                xj(intValue, ((Integer) map.get("autoOpen")).intValue(), ((Integer) map.get("downloadMode")).intValue(), ((Boolean) map.get("isHaveDownloadSdkConfig")).booleanValue(), ((Boolean) map.get("isEnableAH")).booleanValue(), ((Boolean) map.get("isEnableAM")).booleanValue());
                break;
            case 26:
                y(intValue, ((Integer) map.get("downloadMode")).intValue());
                break;
            case 28:
                xj(intValue, ((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue(), c(map.get("downloadMarketInterceptor")));
                break;
            case 29:
                u(intValue, map);
                break;
            case 30:
                hf(intValue, ((Integer) map.get("downloadScene")).intValue());
                break;
            case 31:
                kd(intValue, ((Boolean) map.get("isShowToast")).booleanValue());
                break;
            case 32:
                w(intValue, map);
                break;
            case 44:
                xj(intValue, ((Integer) map.get("linkMode")).intValue());
                break;
            case 46:
                xj(intValue, ((Boolean) map.get("enableShowComplianceDialog")).booleanValue());
                break;
            case 49:
                hf(intValue, ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue());
                break;
            case 50:
                w(intValue, ((Boolean) map.get("enableNewActivity")).booleanValue());
                break;
            case 53:
                xj(intValue, map.get("extraObject"));
                break;
            case 54:
                xj(intValue, (JSONObject) map.get("extraJson"));
                break;
            case 56:
                kd(intValue, map);
                break;
            case 72:
                hf(intValue, map.get("extraEventObject"));
                break;
            case 73:
                xj(intValue, (String) map.get("clickButtonTag"));
                break;
            case 74:
                hf(intValue, (JSONObject) map.get("eventConfigExtraJson"));
                break;
            case 75:
                w(intValue, (JSONObject) map.get("paramsJson"));
                break;
            case 76:
                hf(intValue, (String) map.get("clickItemTag"));
                break;
            case 78:
                w(intValue, (String) map.get("refer"));
                break;
            case 79:
                u(intValue, (String) map.get("quickAppEventTag"));
                break;
            case 80:
                y(intValue, map);
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_RESET_SYSTEM_VOLUME /* 98 */:
                tu(intValue);
                break;
            case 100:
                dq(intValue);
                break;
            case 101:
                qd(intValue);
                break;
            case 123:
                kd(intValue, (String) map.get(TKDownloadReason.KSAD_TK_MD5));
                break;
            case 124:
                xj(intValue, ((Long) map.get("expectFileLength")).longValue());
                break;
            case 125:
                u(intValue, ((Boolean) map.get("needWifi")).booleanValue());
                break;
            case 127:
                hf(intValue, ((Long) map.get("extraValue")).longValue());
                break;
            case r.b.d /* 128 */:
                y(intValue, (String) map.get("appName"));
                break;
            case 129:
                u(intValue, (JSONObject) map.get("extraJson"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE /* 130 */:
                c(intValue, (String) map.get("startToast"));
                break;
            case 131:
                f(intValue, (String) map.get("sdkMonitorScene"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA /* 132 */:
                w(intValue, ((Long) map.get(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a)).longValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START /* 133 */:
                y(intValue, ((Boolean) map.get("isAd")).booleanValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS /* 134 */:
                w(intValue, ((Integer) map.get("modelType")).intValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET /* 135 */:
                d(intValue, (String) map.get("logExtra"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                tf(intValue, (String) map.get("packageName"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME /* 137 */:
                p(intValue, (String) map.get("appIcon"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE /* 139 */:
                xj(intValue, (List<String>) map.get("clickTrackUrl"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID /* 140 */:
                pl(intValue, (String) map.get("downloadUrl"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID /* 141 */:
                hf(intValue, (List<String>) map.get("backupUrls"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO /* 142 */:
                g(intValue, (String) map.get("notificationJumpUrl"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE /* 143 */:
                am(intValue, (String) map.get("mimeType"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SPADE /* 144 */:
                xj(intValue, (Map<String, String>) map.get("headers"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES /* 145 */:
                c(intValue, ((Boolean) map.get("isShowNotification")).booleanValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK /* 146 */:
                qt(intValue, (String) map.get("filePath"));
                break;
            case 147:
                zg(intValue, (String) map.get("fileName"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK /* 148 */:
                f(intValue, ((Boolean) map.get("isNeedIndependentProcess")).booleanValue());
                break;
            case 149:
                u(intValue, ((Integer) map.get("versionCode")).intValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS /* 150 */:
                e(intValue, (String) map.get("versionName"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS /* 151 */:
                xj(intValue, new u.xj().xj((String) map.get("quickAppModelOpenUrl")).hf((String) map.get("quickAppModelExtraData")).xj());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF /* 152 */:
                d(intValue, ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT /* 153 */:
                kd(intValue, ((Integer) map.get("funnelType")).intValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET /* 154 */:
                xj(intValue, c(map.get("downloadMarketInterceptor")));
                break;
            case 157:
                Object obj2 = map.get("s");
                if (obj2 instanceof Service) {
                    com.ss.android.socialbase.downloader.downloader.w.xj((Context) obj2);
                    break;
                }
                break;
            case 158:
                Object obj3 = map.get("i");
                map.get("c");
                if (obj3 instanceof Intent) {
                    Intent intent = (Intent) obj3;
                    if (TextUtils.equals(intent.getAction(), "com.csj.install")) {
                        xj(intent);
                        break;
                    } else {
                        intent.setComponent(new ComponentName(com.ss.android.socialbase.downloader.downloader.w.tj(), (Class<?>) DownloadHandlerService.class));
                        com.ss.android.socialbase.downloader.downloader.w.tj().startService(intent);
                        break;
                    }
                }
                break;
            case 160:
                xj(map);
                break;
            case 162:
                Object obj4 = map.get("listener");
                if (obj4 instanceof TTAdInteractionListener) {
                    qt.xj((TTAdInteractionListener) obj4);
                    break;
                }
                break;
        }
        return null;
    }

    private DownloadModel w(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private DownloadStatusChangeListener hf(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        return null;
    }

    private void w(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((Integer) map.get("linkMode")).intValue();
        int intValue2 = ((Integer) map.get("downloadMode")).intValue();
        boolean booleanValue = ((Boolean) map.get("isEnableBackDialog")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isAddToDownloadManage")).booleanValue();
        map.get("extraOperation");
        boolean booleanValue3 = ((Boolean) map.get("shouldUseNewWebView")).booleanValue();
        int intValue3 = ((Integer) map.get("interceptFlag")).intValue();
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        Object obj = map.get("extraObject");
        boolean booleanValue4 = ((Boolean) map.get("enableShowComplianceDialog")).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get("enableNewActivity")).booleanValue();
        boolean booleanValue7 = ((Boolean) map.get("isEnableAH")).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get("isEnableAM")).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(intValue).setDownloadMode(intValue2).setIsEnableBackDialog(booleanValue).setIsAddToDownloadManage(booleanValue2).setShouldUseNewWebView(booleanValue3).setInterceptFlag(intValue3).setExtraJson(jSONObject).setExtraObject(obj).setEnableShowComplianceDialog(booleanValue4).setIsAutoDownloadOnCardShow(booleanValue5).setEnableNewActivity(booleanValue6).setEnableAH(booleanValue7).setEnableAM(booleanValue8).setEnableOppoAutoDownload(((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue());
        this.kd.put(Integer.valueOf(i), enableOppoAutoDownload);
        this.y.put(Integer.valueOf(i), enableOppoAutoDownload.build());
    }

    private void hf(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder xj2 = xj(((Long) map.get(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a)).longValue(), (String) map.get("appIcon"), ((Boolean) map.get("isShowNotification")).booleanValue(), ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue(), (String) map.get("logExtra"), (JSONObject) map.get("extraJson"), (JSONObject) map.get("downloadSettings"), (String) map.get("filePath"), (String) map.get("downloadUrl"), (String) map.get("appName"), (String) map.get("packageName"), ((Boolean) map.get("isNeedIndependentProcess")).booleanValue(), (String) map.get("openUrl"), (String) map.get("webTitle"), (String) map.get("webUrl"));
        this.w.put(Integer.valueOf(i), xj2);
        this.u.put(Integer.valueOf(i), xj2.build());
    }

    public Object u(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return null;
        }
        return ua.getExtraClickOperation();
    }

    public void u(int i, String str) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return;
        }
        si.setQuickAppEventTag(str);
    }

    public void u(int i, boolean z) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.setNeedWifi(z);
    }

    public boolean hf(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return false;
        }
        return ua.isEnableBackDialog();
    }

    public void u(int i, JSONObject jSONObject) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.setExtra(jSONObject);
    }

    public void hf(int i, boolean z) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return;
        }
        ua.setIsAutoDownloadOnCardShow(z);
    }

    public AdDownloadModel u(int i, int i2) {
        AdDownloadModel i3 = i(i);
        if (i3 == null) {
            return null;
        }
        return i3.setVersionCode(i2);
    }

    public void hf(int i, Object obj) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return;
        }
        si.setExtraEventObject(obj);
    }

    public boolean kd(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return false;
        }
        return ua.isEnableMultipleDownload();
    }

    public void hf(int i, JSONObject jSONObject) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return;
        }
        si.setExtraJson(jSONObject);
    }

    public void kd(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.setMd5(str);
    }

    public void hf(int i, String str) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return;
        }
        si.setClickItemTag(str);
    }

    public void kd(int i, boolean z) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.setIsShowToast(z);
    }

    public void hf(int i, int i2) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return;
        }
        si.setDownloadScene(i2);
    }

    public AdDownloadModel kd(int i, int i2) {
        AdDownloadModel i3 = i(i);
        if (i3 == null) {
            return null;
        }
        return i3.setFunnelType(i2);
    }

    public void hf(int i, long j) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.setExtraValue(j);
    }

    public boolean w(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return false;
        }
        return ua.isAddToDownloadManage();
    }

    public AdDownloadModel hf(int i, List<String> list) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setBackupUrls(list);
    }

    public void w(int i, boolean z) {
        AdDownloadController ua = ua(i);
        if (this.y == null) {
            return;
        }
        ua.setEnableNewActivity(z);
    }

    public void w(int i, JSONObject jSONObject) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return;
        }
        si.setParamsJson(jSONObject);
    }

    public void w(int i, String str) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return;
        }
        si.setRefer(str);
    }

    public AdDownloadModel w(int i, long j) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setId(j);
    }

    public AdDownloadModel w(int i, int i2) {
        AdDownloadModel i3 = i(i);
        if (i3 == null) {
            return null;
        }
        return i3.setModelType(i2);
    }

    public void y(int i, String str) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.setAppName(str);
    }

    public AdDownloadModel y(int i, boolean z) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setIsAd(z);
    }

    private void xj(Intent intent) {
        intent.getAction();
        int intExtra = intent.getIntExtra("extra_click_download_ids", -1);
        intent.getIntExtra("extra_click_download_type", -1);
        intent.getStringExtra("extra_tag");
        String stringExtra = intent.getStringExtra("extra_value");
        String stringExtra2 = intent.getStringExtra("extra_log_extra");
        String stringExtra3 = intent.getStringExtra("extra_package_name");
        boolean w = wo.w(this.hf, stringExtra3);
        NotificationManager notificationManager = (NotificationManager) this.hf.getSystemService("notification");
        com.bytedance.sdk.openadsdk.core.pl.kd.xj("notification", stringExtra, stringExtra2, w ? "open" : "install", stringExtra3, "click_other", (String) null, (String) null);
        if (w) {
            com.ss.android.downloadlib.c.d.xj(stringExtra3);
            notificationManager.cancel(my(intExtra));
        } else {
            com.ss.android.socialbase.appdownloader.u.xj(this.hf, intExtra);
            notificationManager.cancel(my(intExtra));
        }
    }

    private void xj(int i, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return;
        }
        ua.setDownloadMarketInterceptor(downloadMarketInterceptor);
    }

    private static boolean xj(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            return false;
        }
        if (TextUtils.equals("main", "internal")) {
            return w();
        }
        return true;
    }

    public void xj(Bundle bundle) {
        qt.xj(this.hf);
        hf();
    }

    private AdDownloadModel.Builder xj(long j, String str, boolean z, boolean z2, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j).setAppIcon(str).setIsShowNotification(z).setAutoInstallWithoutNotification(z2).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.zg.1
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str11) {
                return zg.this.xj(str10, str11);
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setFilePath(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setDownloadUrl(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            fileUriProvider.setAppName(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            fileUriProvider.setPackageName(str6);
        }
        fileUriProvider.setNeedIndependentProcess(z3);
        fileUriProvider.setDeepLink(xj(j, str7, str8, str9));
        return fileUriProvider;
    }

    private void xj(Map<String, Object> map) {
        Object apply;
        Function<SparseArray<Object>, Object> hf = hf();
        if (hf != null) {
            apply = hf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(161).xj(Map.class).xj(0, map).hf());
            Map map2 = (Map) apply;
            if (map2 != null) {
                Notification notification = (Notification) map2.get("notification");
                NotificationManager notificationManager = (NotificationManager) pz.getContext().getSystemService("notification");
                Object obj = map.get("install_download_id");
                notificationManager.notify(my(obj != null ? ((Integer) obj).intValue() : 0), notification);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.utils.pl.u("xgc_dl", "false");
    }

    public Map<String, Object> xj(Object obj) {
        Object apply;
        HashMap hashMap = new HashMap();
        hashMap.put("params", obj);
        Function<SparseArray<Object>, Object> hf = hf();
        if (hf == null) {
            return null;
        }
        apply = hf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(156).xj(Map.class).xj(0, hashMap).hf());
        return (Map) apply;
    }

    public Uri xj(String str, String str2) {
        Object apply;
        HashMap hashMap = new HashMap();
        hashMap.put("custom_authority", str);
        hashMap.put("custom_file_path", str2);
        Function<SparseArray<Object>, Object> hf = hf();
        if (hf == null) {
            return null;
        }
        apply = hf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(155).xj(Uri.class).xj(0, hashMap).hf());
        return (Uri) apply;
    }

    private DeepLink xj(long j, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void xj(int i, String str, String str2, String str3) {
        AdDownloadModel.Builder oa = oa(i);
        if (oa == null) {
            return;
        }
        this.u.put(Integer.valueOf(i), oa.setAppIcon(str).setAppName(str2).setPackageName(str3).build());
    }

    private void xj(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i2).setDownloadMode(i3).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.kd.put(Integer.valueOf(i), isAddToDownloadManage);
        if (z) {
            isAddToDownloadManage.setEnableAH(z2);
            isAddToDownloadManage.setEnableAM(z3);
        }
        this.y.put(Integer.valueOf(i), isAddToDownloadManage.build());
    }

    public int xj(int i) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return 0;
        }
        return ua.getLinkMode();
    }

    public void xj(int i, int i2) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return;
        }
        ua.setLinkMode(i2);
    }

    public void xj(int i, boolean z) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return;
        }
        ua.setEnableShowComplianceDialog(z);
    }

    public void xj(int i, Object obj) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return;
        }
        ua.setExtraObject(obj);
    }

    public void xj(int i, JSONObject jSONObject) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return;
        }
        ua.setExtraJson(jSONObject);
    }

    private void xj(int i, boolean z, DownloadMarketInterceptor downloadMarketInterceptor) {
        AdDownloadController ua = ua(i);
        if (ua == null) {
            return;
        }
        try {
            ua.setDownloadMarketInterceptor(downloadMarketInterceptor);
            ua.setEnableOppoAutoDownload(z);
        } catch (Throwable unused) {
        }
    }

    public void xj(int i, String str) {
        AdDownloadEventConfig si = si(i);
        if (si == null) {
            return;
        }
        si.setClickButtonTag(str);
    }

    public void xj(int i, long j) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return;
        }
        i2.setExpectFileLength(j);
    }

    public AdDownloadModel xj(int i, List<String> list) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setClickTrackUrl(list);
    }

    public AdDownloadModel xj(int i, Map<String, String> map) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setHeaders(map);
    }

    public AdDownloadModel xj(int i, com.ss.android.download.api.model.u uVar) {
        AdDownloadModel i2 = i(i);
        if (i2 == null) {
            return null;
        }
        return i2.setQuickAppModel(uVar);
    }

    public PluginValueSet xj() {
        AYUAbz A4TApA2 = AYUAbz.A4TApA();
        A4TApA2.f4119A2egSU.put(0, qt.xj);
        A4TApA2.f4119A2egSU.put(1, Boolean.valueOf(qt.hf));
        A4TApA2.AMqCpz(10000, 3);
        return A4TApA2.A2egSU();
    }
}
