package com.czhj.wire.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class ImmutableList<T> extends AbstractList<T> implements Serializable, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<T> f10675a;

    public ImmutableList(List<T> list) {
        this.f10675a = new ArrayList<>(list);
    }

    private Object writeReplace() {
        return Collections.unmodifiableList(this.f10675a);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f10675a.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10675a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.f10675a.toArray();
    }
}
