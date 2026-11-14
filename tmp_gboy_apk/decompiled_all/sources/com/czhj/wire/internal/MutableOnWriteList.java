package com.czhj.wire.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class MutableOnWriteList<T> extends AbstractList<T> implements Serializable, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    List<T> f10676a;
    private final List<T> b;

    public MutableOnWriteList(List<T> list) {
        this.b = list;
        this.f10676a = list;
    }

    private Object writeReplace() {
        return new ArrayList(this.f10676a);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        if (this.f10676a == this.b) {
            this.f10676a = new ArrayList(this.b);
        }
        this.f10676a.add(i, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f10676a.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i) {
        if (this.f10676a == this.b) {
            this.f10676a = new ArrayList(this.b);
        }
        return this.f10676a.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        if (this.f10676a == this.b) {
            this.f10676a = new ArrayList(this.b);
        }
        return this.f10676a.set(i, t);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10676a.size();
    }
}
