package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.kd.hf.xj;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.adsdk.ugeno.w.jk;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.sdk.component.adexpress.hf.c;
import com.bytedance.sdk.component.adexpress.hf.f;
import com.bytedance.sdk.openadsdk.core.a.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.tf;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.ss;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.models.ClickCommon;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends u implements xj {
    private tf jk;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.xj.hf pz;

    public y(Context context, ws wsVar, hf hfVar, ViewGroup viewGroup) {
        super(context, wsVar, hfVar, viewGroup);
    }

    private void am() {
        am amVar = new am();
        HashMap hashMap = new HashMap();
        hashMap.put("shake_value", Integer.valueOf(this.c.yo()));
        hashMap.put("calculation_method", Integer.valueOf(this.c.dk()));
        hashMap.put("rotation_angle", Integer.valueOf(this.c.jk()));
        hashMap.put("calculation_method_twist", Integer.valueOf(this.c.et()));
        hashMap.put("twist_config", this.c.pz());
        hashMap.put("image_info", this.c.am());
        hashMap.put("cache_dir", this.c.e());
        hashMap.put("shake_interact_conf", this.c.ht());
        hashMap.put("twist_interact_conf", this.c.ra());
        amVar.xj(hashMap);
        amVar.xj(this.hf);
        amVar.xj(this.u);
        amVar.hf(this.kd);
        this.xj.xj(ClickCommon.CLICK_SCENE_AD, amVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.u
    public void hf(c cVar) {
        am();
        this.xj.xj((yo) this);
        this.xj.xj((jk) this);
        ss c = hl.c(this.y);
        try {
            if (c != null) {
                this.w = this.xj.xj(this.u, this.kd, c.kd());
            } else {
                this.w = this.xj.xj(this.u, this.kd, (JSONObject) null);
            }
            if (this.xj.xj()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("component_not_exist", new JSONArray((Collection) this.xj.hf()));
                this.c.l().xj(jSONObject);
                cVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, "ugen unknown component");
                return;
            }
            if (this.w != null) {
                if (this.v == null) {
                    this.v = new com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(this.c.kd());
                }
                this.v.xj(this.xj, this.w);
            }
            this.c.l().hf();
            this.c.l().w();
        } catch (NoClassDefFoundError unused) {
            if (cVar != null) {
                cVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, "ugen no class def found error");
            }
        } catch (UnsatisfiedLinkError unused2) {
            if (cVar != null) {
                cVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, "ugen yoga so load fail");
            }
        } catch (Throwable unused3) {
            if (cVar != null) {
                cVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, "ugen other fail");
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.u
    public com.bytedance.adsdk.ugeno.hf.w kd() {
        com.bytedance.adsdk.ugeno.hf.w<View> wVar = this.w;
        if (wVar == null) {
            return null;
        }
        return wVar.kd("VideoV3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.u
    public JSONObject tf() {
        return this.c.kd();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.u, com.bytedance.sdk.component.adexpress.dynamic.u
    public void xj(CharSequence charSequence, int i, int i2, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.u
    public JSONObject xj() {
        return this.c.kd().optJSONObject("xTemplate");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.u, com.bytedance.adsdk.ugeno.w.yo
    public void xj(final com.bytedance.adsdk.ugeno.hf.w wVar, final String str, final y.xj xjVar) {
        if (xjVar == null) {
            return;
        }
        if (!TextUtils.equals(str, "shake") && !TextUtils.equals(str, "twist")) {
            hf(wVar, str, xjVar);
            return;
        }
        WeakReference<ViewGroup> weakReference = this.g;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        l.xj(this.g, new com.bytedance.sdk.openadsdk.core.hf.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.y.1
            @Override // com.bytedance.sdk.openadsdk.core.hf.w
            public void xj() {
                WeakReference<ViewGroup> weakReference2 = y.this.g;
                if (weakReference2 == null || weakReference2.get() == null || !l.xj(y.this.g.get())) {
                    return;
                }
                y.this.hf(wVar, str, xjVar);
            }
        });
    }

    public void xj(String str, Map<String, String> map) {
        if (this.w == null) {
            return;
        }
        y.xj xjVar = new y.xj();
        xjVar.xj(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
        xjVar.hf("emit");
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("name", str);
        xjVar.xj(hashMap);
        xj.C0027xj.xj(this.w, "jsb", xjVar).xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.xj
    public void xj(tf tfVar) {
        this.jk = tfVar;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.express.xj.hf hfVar) {
        this.pz = hfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
        int i;
        CharSequence text;
        Object orDefault;
        Object orDefault2;
        String hf = xjVar.hf();
        if (com.bytedance.sdk.openadsdk.core.ugeno.express.xj.xj.xj.contains(hf)) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.xj.xj.xj(this.jk, this.pz, this.y, this.hf, hf, xjVar, this.zg, wVar);
            return;
        }
        hf.getClass();
        switch (hf) {
            case "openAppPermission":
                i = 10;
                break;
            case "openCommonUrl":
                i = 13;
                break;
            case "openPrivacy":
                i = 7;
                break;
            case "resumeVideo":
                tf tfVar = this.jk;
                if (tfVar != null) {
                    tfVar.xj(3);
                    return;
                }
                return;
            case "pauseVideo":
                tf tfVar2 = this.jk;
                if (tfVar2 != null) {
                    tfVar2.xj(2);
                    return;
                }
                return;
            case "skip":
                i = 6;
                break;
            case "close":
                i = 8;
                break;
            case "openAppFunction":
                i = 12;
                break;
            case "videoControl":
                i = 4;
                break;
            case "convert":
                i = 2;
                break;
            case "muteVideo":
                i = 5;
                break;
            case "openAppPolicy":
                i = 9;
                break;
            case "dislike":
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        ra.xj xj = new ra.xj().u(this.f10435pl.am()).w(this.f10435pl.qt()).hf(this.f10435pl.zg()).xj(this.f10435pl.e()).xj(wVar.j()).hf(this.f10435pl.pl()).xj(this.f10435pl.g());
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, "twist")) {
            try {
                jSONObject.put("convertActionType", 1);
            } catch (Throwable unused) {
            }
        }
        try {
            orDefault = xjVar.w().getOrDefault("webUrl", "");
            String xj2 = com.bytedance.adsdk.ugeno.u.hf.xj((String) orDefault, tf());
            orDefault2 = xjVar.w().getOrDefault("webTitle", "");
            String xj3 = com.bytedance.adsdk.ugeno.u.hf.xj((String) orDefault2, tf());
            jSONObject.put("openCommonWebUrl", xj2);
            jSONObject.put("openCommonWebTitle", xj3);
        } catch (JSONException unused2) {
        }
        View d = wVar.d();
        try {
            if ((d instanceof TextView) && (text = ((TextView) d).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused3) {
        }
        xj.xj(jSONObject);
        ra xj4 = xj.xj();
        f fVar = this.d;
        if (fVar != null) {
            fVar.xj(d, i, xj4);
        }
    }
}
