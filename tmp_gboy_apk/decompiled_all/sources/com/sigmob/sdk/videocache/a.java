package com.sigmob.sdk.videocache;

import ADYaiT.CtFAbx;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private volatile byte[] f13717a;
    private volatile boolean b;

    public a() {
        this(new byte[0]);
    }

    @Override // com.sigmob.sdk.videocache.c
    public int a(byte[] bArr, long j, int i) {
        if (j >= this.f13717a.length) {
            return -1;
        }
        if (j <= 2147483647L) {
            return new ByteArrayInputStream(this.f13717a).read(bArr, (int) j, i);
        }
        throw new IllegalArgumentException(CtFAbx.AaHO0E("Too long offset for memory cache ", j));
    }

    @Override // com.sigmob.sdk.videocache.c
    public void b() {
    }

    @Override // com.sigmob.sdk.videocache.c
    public void c() {
        this.b = true;
    }

    @Override // com.sigmob.sdk.videocache.c
    public boolean d() {
        return this.b;
    }

    public a(byte[] bArr) {
        this.f13717a = (byte[]) o.a(bArr);
    }

    @Override // com.sigmob.sdk.videocache.c
    public long a() {
        return this.f13717a.length;
    }

    @Override // com.sigmob.sdk.videocache.c
    public void a(byte[] bArr, int i) {
        o.a(this.f13717a);
        o.a(i >= 0 && i <= bArr.length);
        byte[] copyOf = Arrays.copyOf(this.f13717a, this.f13717a.length + i);
        System.arraycopy(bArr, 0, copyOf, this.f13717a.length, i);
        this.f13717a = copyOf;
    }
}
