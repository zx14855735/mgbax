package com.kwad.sdk.core.imageloader.cache.memory;

import J3FDQU.A2egSU;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class BaseMemoryCache implements MemoryCache {
    private final Map<String, Reference<DecodedResult>> softMap = A2egSU.BIYEnU();

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.softMap.clear();
    }

    public abstract Reference<DecodedResult> createReference(DecodedResult decodedResult);

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult get(String str) {
        Reference<DecodedResult> reference = this.softMap.get(str);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this.softMap) {
            hashSet = new HashSet(this.softMap.keySet());
        }
        return hashSet;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        this.softMap.put(str, createReference(decodedResult));
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        Reference<DecodedResult> remove = this.softMap.remove(str);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }
}
