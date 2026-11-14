package com.czhj.volley;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 0.0f;
    public static final int DEFAULT_CONNECT_TIMEOUT_MS = 5000;
    public static final int DEFAULT_MAX_RETRIES = 2;
    public static final int DEFAULT_TIMEOUT_MS = 5000;

    /* renamed from: a, reason: collision with root package name */
    private final int f10622a;
    private final float b;
    private final int c;
    private int d;
    private int e;

    public DefaultRetryPolicy() {
        this(5000, 2, 0.0f);
    }

    public float getBackoffMultiplier() {
        return this.b;
    }

    @Override // com.czhj.volley.RetryPolicy
    public int getCurrentConnectTimeoutMs() {
        return this.c;
    }

    @Override // com.czhj.volley.RetryPolicy
    public int getCurrentRetryCount() {
        return this.e;
    }

    @Override // com.czhj.volley.RetryPolicy
    public int getCurrentTimeout() {
        return this.d;
    }

    public boolean hasAttemptRemaining() {
        return this.e <= this.f10622a;
    }

    @Override // com.czhj.volley.RetryPolicy
    public void retry(VolleyError volleyError) {
        this.e++;
        int i = this.d;
        this.d = i + ((int) (i * this.b));
        if (!hasAttemptRemaining()) {
            throw volleyError;
        }
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.c = i;
        this.d = i;
        this.f10622a = i2;
        this.b = f;
    }

    public DefaultRetryPolicy(int i, int i2, int i3, float f) {
        this.c = i;
        this.d = i2;
        this.f10622a = i3;
        this.b = f;
    }
}
