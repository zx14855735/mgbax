package io.dcloud.openapi.core.module;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.util.TidUtil;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class DCBaseAOL {
    private final Activity aaaaaaa0;
    private final DCloudAOLSlot aaaaaaaa;
    protected int aaaaaaae;
    private String aaaaaaav;
    private String aaaaaaea;
    private String aaaaaaeo;
    private int aaaaaeaa;
    private String aaaaeaaa;
    protected String aaaaoaaa;
    private String aaaeaaaa;
    private int aaaoaaaa;
    protected AOLLoader.FeedAOLInteractionListener aacaaaaa;
    private JSONObject aaoaaaaa;
    protected AOLLoader.VAOLInteractionListener acaaaaaa;
    private int aeaaaaaa;
    private boolean aoaaaaaa;
    private String eaaaaaaa;
    private int aaaaaaao = -1;
    protected int aaaaaaac = -1;
    protected int aaaaaaau = -1;
    private boolean aaaaaaan = false;
    private int aaaaaoaa = 1;
    private boolean aaaaaaoa = true;

    public DCBaseAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        this.aaaaaaaa = dCloudAOLSlot;
        this.aaaaaaa0 = activity;
    }

    public final void aaaaaaa0(String str) {
        this.aaaaaaeo = str;
    }

    public final void aaaaaaaa(AOLLoader.VAOLInteractionListener vAOLInteractionListener) {
        this.acaaaaaa = vAOLInteractionListener;
    }

    public void aaaaaaac(String str) {
        this.aaaaeaaa = str;
    }

    public final void aaaaaaae(String str) {
        this.aaaaaaav = str;
    }

    public void aaaaaaan(String str) {
        this.eaaaaaaa = str;
    }

    public void aaaaaaao(String str) {
        this.aaaeaaaa = str;
    }

    public void aaaaaaau(String str) {
        this.aaaaaaea = str;
    }

    public String aaaaaaea() {
        return this.aaaaaaeo;
    }

    public boolean aaaaoaaa() {
        return false;
    }

    public int aaaoaaaa() {
        return this.aaaaaaac;
    }

    public String aaoaaaaa() {
        return this.aaaaeaaa;
    }

    public int aeaaaaaa() {
        return this.aaaaaaao;
    }

    public String aoaaaaaa() {
        return this.aaaaaaaa.getEI();
    }

    public void biddingFail(int i, int i2, int i3) {
        aaaaaaau.aaaaaaa0("uniAd", "bidding fail:" + getType() + ",Win:" + i + ",second:" + i2 + ",slot:" + getSlotId());
    }

    public void biddingSuccess(int i, int i2) {
        aaaaaaau.aaaaaaa0("uniAd", "bidding success:" + getType() + ",Win:" + i + ",second:" + i2 + ",slot:" + getSlotId());
    }

    public abstract void destroy();

    public String eaaaaaaa() {
        return this.aaaeaaaa;
    }

    public int getAcpt() {
        return this.aaaoaaaa;
    }

    public Activity getActivity() {
        return this.aaaaaaa0;
    }

    public int getAdStatus() {
        return -1;
    }

    public int getAdType() {
        return this.aaaaaaae;
    }

    public String getDCloudId() {
        return this.aaaaaaaa.getAdpid();
    }

    public View getExpressAdView(Activity activity) {
        return null;
    }

    public AOLLoader.FeedAOLInteractionListener getFeedAdCallback() {
        return this.aacaaaaa;
    }

    public int getFeedType() {
        return this.aaaaaeaa;
    }

    public int getIntersType() {
        return this.aaaaaoaa;
    }

    public String getMiniRequestType() {
        return this.aaaaaaea;
    }

    public int getMiniType() {
        return this.aeaaaaaa;
    }

    public SparseArray<Object> getNativeAdInfo() {
        return null;
    }

    public JSONObject getParams() {
        return this.aaoaaaaa;
    }

    public String getPath() {
        return this.eaaaaaaa;
    }

    public DCloudAOLSlot getSlot() {
        return this.aaaaaaaa;
    }

    public String getSlotId() {
        return this.aaaaaaav;
    }

    public String getTid() {
        return TidUtil.getTid(getType(), getAdType());
    }

    public String getType() {
        return this.aaaaoaaa;
    }

    public AOLLoader.VAOLInteractionListener getVideoAdCallback() {
        return this.acaaaaaa;
    }

    public boolean isEnd() {
        return this.aoaaaaaa;
    }

    public boolean isExpressAd() {
        return this.aaaaaaoa;
    }

    public boolean isSlotSupportBidding() {
        return this.aaaaaaan;
    }

    public abstract boolean isValid();

    public void render() {
    }

    public final void setBiddingECPM(int i) {
        if (i > 0) {
            aaaaaaau.aaaaaaao(getType() + " current cpm:" + i);
            this.aaaaaaao = i;
        }
    }

    public void setExpressAd(boolean z) {
        this.aaaaaaoa = z;
    }

    public void setFeedType(int i) {
        this.aaaaaeaa = i;
    }

    public void startLoadTime() {
    }

    public void aaaaaaa0(boolean z) {
        this.aaaaaaan = z;
    }

    public final void aaaaaaaa(AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener) {
        this.aacaaaaa = feedAOLInteractionListener;
    }

    public void aaaaaaao(int i) {
        this.aeaaaaaa = i;
    }

    public void aaaaaaa0(int i) {
        this.aaaaaoaa = i;
    }

    public void aaaaaaaa(boolean z) {
        this.aoaaaaaa = z;
    }

    public void aaaaaaaa(JSONObject jSONObject) {
        this.aaoaaaaa = jSONObject;
    }

    public void aaaaaaaa(int i) {
        this.aaaoaaaa = i;
    }
}
