package com.ss.android.socialbase.downloader.network;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class u {
    private final int hf;
    private int u;
    private double w = -1.0d;
    private final double xj;

    public u(double d) {
        this.xj = d;
        this.hf = d == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void xj(double d) {
        double d2 = 1.0d - this.xj;
        int i = this.u;
        if (i > this.hf) {
            this.w = Math.exp((Math.log(d) * this.xj) + (Math.log(this.w) * d2));
        } else if (i > 0) {
            double d3 = (d2 * i) / (i + 1.0d);
            this.w = Math.exp((Math.log(d) * (1.0d - d3)) + (Math.log(this.w) * d3));
        } else {
            this.w = d;
        }
        this.u++;
    }

    public double xj() {
        return this.w;
    }
}
