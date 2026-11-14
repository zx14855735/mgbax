package com.sigmob.sdk.videocache;

import java.io.ByteArrayInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements u {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f13718a;
    private ByteArrayInputStream b;

    public b(byte[] bArr) {
        this.f13718a = bArr;
    }

    @Override // com.sigmob.sdk.videocache.u
    public int a(byte[] bArr) {
        return this.b.read(bArr, 0, bArr.length);
    }

    @Override // com.sigmob.sdk.videocache.u
    public void b() {
    }

    @Override // com.sigmob.sdk.videocache.u
    public String c() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v d() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String g() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public long a() {
        return this.f13718a.length;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long j) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f13718a);
        this.b = byteArrayInputStream;
        byteArrayInputStream.skip(j);
    }
}
