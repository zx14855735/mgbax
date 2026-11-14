package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
abstract class qt<K, V> {
    qt<K, V>.hf hf;

    public final class hf implements Set<K> {
        public hf() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            qt.this.w();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return qt.this.xj(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return qt.xj(qt.this.hf(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return qt.xj(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int xj = qt.this.xj() - 1; xj >= 0; xj--) {
                Object xj2 = qt.this.xj(xj, 0);
                i += xj2 == null ? 0 : xj2.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return qt.this.xj() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new xj(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int xj = qt.this.xj(obj);
            if (xj < 0) {
                return false;
            }
            qt.this.xj(xj);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return qt.hf(qt.this.hf(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return qt.w(qt.this.hf(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return qt.this.xj();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return qt.this.hf(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) qt.this.xj(tArr, 0);
        }
    }

    public final class xj<T> implements Iterator<T> {
        int hf;
        boolean u = false;
        int w;
        final int xj;

        public xj(int i) {
            this.xj = i;
            this.hf = qt.this.xj();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.w < this.hf;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) qt.this.xj(this.w, this.xj);
            this.w++;
            this.u = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.u) {
                throw new IllegalStateException();
            }
            int i = this.w - 1;
            this.w = i;
            this.hf--;
            this.u = false;
            qt.this.xj(i);
        }
    }

    public static <K, V> boolean hf(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean w(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public static <K, V> boolean xj(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract Map<K, V> hf();

    public Set<K> u() {
        if (this.hf == null) {
            this.hf = new hf();
        }
        return this.hf;
    }

    public abstract void w();

    public abstract int xj();

    public abstract int xj(Object obj);

    public abstract Object xj(int i, int i2);

    public abstract void xj(int i);

    public <T> T[] xj(T[] tArr, int i) {
        int xj2 = xj();
        if (tArr.length < xj2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), xj2));
        }
        for (int i2 = 0; i2 < xj2; i2++) {
            tArr[i2] = xj(i2, i);
        }
        if (tArr.length > xj2) {
            tArr[xj2] = null;
        }
        return tArr;
    }

    public Object[] hf(int i) {
        int xj2 = xj();
        Object[] objArr = new Object[xj2];
        for (int i2 = 0; i2 < xj2; i2++) {
            objArr[i2] = xj(i2, i);
        }
        return objArr;
    }

    public static <T> boolean xj(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
