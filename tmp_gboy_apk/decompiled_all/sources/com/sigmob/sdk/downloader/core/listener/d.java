package com.sigmob.sdk.downloader.core.listener;

import com.sigmob.sdk.downloader.core.listener.assist.b;
import com.sigmob.sdk.downloader.core.listener.assist.e;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class d implements com.sigmob.sdk.downloader.c, b.InterfaceC0456b, com.sigmob.sdk.downloader.core.listener.assist.d {

    /* renamed from: a, reason: collision with root package name */
    final com.sigmob.sdk.downloader.core.listener.assist.b f13417a;

    public static class a implements e.b<b.c> {
        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b.c b(int i) {
            return new b.c(i);
        }
    }

    public d() {
        this(new com.sigmob.sdk.downloader.core.listener.assist.b(new a()));
    }

    public void a(b.a aVar) {
        this.f13417a.a(aVar);
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void b(com.sigmob.sdk.downloader.f fVar, int i, long j) {
        this.f13417a.a(fVar, i, j);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void c(com.sigmob.sdk.downloader.f fVar, int i, long j) {
        this.f13417a.a(fVar, i);
    }

    public d(com.sigmob.sdk.downloader.core.listener.assist.b bVar) {
        this.f13417a = bVar;
        bVar.a(this);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i, long j) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z) {
        this.f13417a.b(z);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i, Map<String, List<String>> map) {
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.f13417a.a(fVar, cVar, true);
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
        this.f13417a.a(fVar, cVar, false);
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        this.f13417a.a(fVar, aVar, exc);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, Map<String, List<String>> map) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z) {
        this.f13417a.a(z);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.f13417a.a();
    }
}
