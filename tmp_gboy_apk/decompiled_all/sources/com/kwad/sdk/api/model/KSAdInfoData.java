package com.kwad.sdk.api.model;

import A5SV6n.A2egSU;
import ADYaiT.CtFAbx;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.io.Serializable;
import java.util.List;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KSAdInfoData implements Serializable {
    private static final long serialVersionUID = 689744866207726843L;
    private String adDescription;
    private String adSource;
    private String appIconUrl;
    private String appName;
    private int convertType;
    private long creativeId;
    private List<String> imageUrlArray;
    private int interactionType;
    private String llsid;
    private int materialType;
    private String productName;
    private String videoCoverImageUrl;
    private String videoUrl;

    private KSAdInfoData() {
    }

    public static KSAdInfoData obtain() {
        return new KSAdInfoData();
    }

    public String getAdDescription() {
        return this.adDescription;
    }

    public String getAdSource() {
        return this.adSource;
    }

    public String getAppIconUrl() {
        return this.appIconUrl;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getConvertType() {
        return this.convertType;
    }

    public long getCreativeId() {
        return this.creativeId;
    }

    public List<String> getImageUrlArray() {
        return this.imageUrlArray;
    }

    public int getInteractionType() {
        return this.interactionType;
    }

    public String getLlsid() {
        return this.llsid;
    }

    public int getMaterialType() {
        return this.materialType;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getVideoCoverImageUrl() {
        return this.videoCoverImageUrl;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public KSAdInfoData setAdDescription(String str) {
        this.adDescription = str;
        return this;
    }

    public KSAdInfoData setAdSource(String str) {
        this.adSource = str;
        return this;
    }

    public KSAdInfoData setAppIconUrl(String str) {
        this.appIconUrl = str;
        return this;
    }

    public KSAdInfoData setAppName(String str) {
        this.appName = str;
        return this;
    }

    public KSAdInfoData setConvertType(int i) {
        this.convertType = i;
        return this;
    }

    public KSAdInfoData setCreativeId(long j) {
        this.creativeId = j;
        return this;
    }

    public KSAdInfoData setImageList(List<String> list) {
        this.imageUrlArray = list;
        return this;
    }

    public KSAdInfoData setInteractionType(int i) {
        this.interactionType = i;
        return this;
    }

    public KSAdInfoData setLlisd(String str) {
        this.llsid = str;
        return this;
    }

    public KSAdInfoData setMaterialType(int i) {
        this.materialType = i;
        return this;
    }

    public KSAdInfoData setProductName(String str) {
        this.productName = str;
        return this;
    }

    public KSAdInfoData setVideoCoverImageUrl(String str) {
        this.videoCoverImageUrl = str;
        return this;
    }

    public KSAdInfoData setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KSAdInfoData{adDescription='");
        sb.append(this.adDescription);
        sb.append("', productName='");
        sb.append(this.productName);
        sb.append("', adSource='");
        sb.append(this.adSource);
        sb.append("', imageUrlArray=");
        sb.append(this.imageUrlArray);
        sb.append(", videoUrl='");
        sb.append(this.videoUrl);
        sb.append("', videoCoverImageUrl='");
        sb.append(this.videoCoverImageUrl);
        sb.append("', materialType=");
        sb.append(this.materialType);
        sb.append(", appIconUrl='");
        sb.append(this.appIconUrl);
        sb.append("', appName='");
        sb.append(this.appName);
        sb.append("', interactionType=");
        sb.append(this.interactionType);
        sb.append(", creativeId=");
        sb.append(this.creativeId);
        sb.append(", convertType=");
        sb.append(this.convertType);
        sb.append(", llsid='");
        return CtFAbx.B25kr6(sb, this.llsid, "'}");
    }
}
