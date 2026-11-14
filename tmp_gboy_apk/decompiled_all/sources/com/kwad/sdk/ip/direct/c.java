package com.kwad.sdk.ip.direct;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c implements Comparable<c> {
    private String ip;
    private boolean success;
    private int weight;
    private float aWV = -1.0f;
    private int aXb = 20;
    private int aXa = 3;
    private StringBuffer aXc = new StringBuffer();

    public c(String str) {
        this.ip = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return (int) (this.aWV - cVar.aWV);
    }

    public final int OF() {
        return this.aXa;
    }

    public final float OG() {
        return this.aWV;
    }

    public final void bN(boolean z) {
        this.success = z;
    }

    public final void er(int i) {
        this.weight = i;
    }

    public final String getIp() {
        return this.ip;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final void o(float f) {
        this.aWV = f;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.ip + "', pingCount=" + this.aXa + ", pingWaitTime=" + this.aXb + ", pingTime='" + this.aWV + " ms', success=" + this.success + '}';
    }
}
