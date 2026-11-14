package com.bytedance.sdk.component.tf.xj;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj<T> implements BlockingQueue<T> {
    private final BlockingQueue<T> xj;

    public xj(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            this.xj = new SynchronousQueue();
        } else {
            this.xj = blockingQueue;
        }
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(T t) {
        return this.xj.add(t);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.xj.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.xj.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object obj) {
        return this.xj.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.xj.containsAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return this.xj.drainTo(collection);
    }

    @Override // java.util.Queue
    public T element() {
        return this.xj.element();
    }

    public final BlockingQueue hf() {
        return this.xj;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.xj.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.xj.iterator();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(T t) {
        return this.xj.offer(t);
    }

    @Override // java.util.Queue
    public T peek() {
        return this.xj.peek();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T poll(long j, TimeUnit timeUnit) {
        try {
            return this.xj.poll(j, timeUnit);
        } catch (IllegalMonitorStateException unused) {
            return null;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(T t) {
        this.xj.put(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.xj.remainingCapacity();
    }

    @Override // java.util.Queue
    public T remove() {
        return this.xj.remove();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.xj.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.xj.retainAll(collection);
    }

    @Override // java.util.Collection
    public final int size() {
        return w();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T take() {
        return this.xj.take();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    public int w() {
        return this.xj.size();
    }

    public final String xj() {
        return this.xj.getClass().getName();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
        return this.xj.drainTo(collection, i);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(T t, long j, TimeUnit timeUnit) {
        return this.xj.offer(t, j, timeUnit);
    }

    @Override // java.util.Queue
    public T poll() {
        return this.xj.poll();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object obj) {
        return this.xj.remove(obj);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
