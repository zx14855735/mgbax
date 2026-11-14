package com.alliance.ssp.ad.manager.applist.bean;

import A5SV6n.A2egSU;
import java.util.List;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class InitConfigBean {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f9706a;
    private Integer b;
    private List<String> dpLimit;

    public InitConfigBean(List<String> list, Integer num, List<String> list2) {
        this.f9706a = list;
        this.b = num;
        this.dpLimit = list2;
    }

    public List<String> getA() {
        return this.f9706a;
    }

    public Integer getB() {
        return this.b;
    }

    public List<String> getDpLimit() {
        return this.dpLimit;
    }

    public void setA(List<String> list) {
        this.f9706a = list;
    }

    public void setB(Integer num) {
        this.b = num;
    }

    public void setDpLimit(List<String> list) {
        this.dpLimit = list;
    }
}
