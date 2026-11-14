package com.bytedance.pangle.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;

@SuppressLint({"NewApi"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements Application.ActivityLifecycleCallbacks {
    Fragment xj;

    public w(Fragment fragment) {
        this.xj = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        r0 = (java.lang.Object[]) java.lang.reflect.Array.newInstance(java.lang.Class.forName("android.app.FragmentState"), r10.length - 1);
        r2 = new int[r10.length - 1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (r3 >= r10.length) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        r6 = r10[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        if (r6 == r5) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
    
        r0[r4] = r6;
        r2[r4] = r3;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
    
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mActive", r0);
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mAdded", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        return;
     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityPostSaveInstanceState(android.app.Activity r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle"
            java.lang.String r1 = "mActive"
            android.app.Fragment r2 = r8.xj
            android.app.Activity r2 = r2.getActivity()
            if (r2 == r9) goto Le
            goto L82
        Le:
            java.lang.String r9 = "android:fragments"
            android.os.Parcelable r9 = r10.getParcelable(r9)     // Catch: java.lang.Throwable -> L4d
            if (r9 != 0) goto L18
            goto L82
        L18:
            java.lang.Object r10 = com.bytedance.pangle.util.FieldUtils.readField(r9, r1)     // Catch: java.lang.Throwable -> L4d
            java.lang.Object[] r10 = (java.lang.Object[]) r10     // Catch: java.lang.Throwable -> L4d
            if (r10 != 0) goto L21
            goto L82
        L21:
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4d
            r3 = 0
            r4 = 0
        L24:
            if (r4 >= r2) goto L52
            r5 = r10[r4]     // Catch: java.lang.Throwable -> L4d
            java.lang.String r6 = "mTag"
            java.lang.Object r6 = com.bytedance.pangle.util.FieldUtils.readField(r5, r6)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r7 = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin"
            boolean r7 = r7.equals(r6)     // Catch: java.lang.Throwable -> L4d
            if (r7 == 0) goto L37
            goto L53
        L37:
            boolean r7 = r6 instanceof java.lang.String     // Catch: java.lang.Throwable -> L4d
            if (r7 == 0) goto L4f
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L4d
            boolean r7 = r7.contains(r0)     // Catch: java.lang.Throwable -> L4d
            if (r7 != 0) goto L53
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L4d
            boolean r6 = r6.contains(r0)     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L4f
            goto L53
        L4d:
            r9 = move-exception
            goto L83
        L4f:
            int r4 = r4 + 1
            goto L24
        L52:
            r5 = 0
        L53:
            if (r5 == 0) goto L82
            java.lang.String r0 = "android.app.FragmentState"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L4d
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4d
            int r2 = r2 + (-1)
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r2)     // Catch: java.lang.Throwable -> L4d
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch: java.lang.Throwable -> L4d
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4d
            int r2 = r2 + (-1)
            int[] r2 = new int[r2]     // Catch: java.lang.Throwable -> L4d
            r4 = 0
        L6a:
            int r6 = r10.length     // Catch: java.lang.Throwable -> L4d
            if (r3 >= r6) goto L7a
            r6 = r10[r3]     // Catch: java.lang.Throwable -> L4d
            if (r6 == r5) goto L77
            r0[r4] = r6     // Catch: java.lang.Throwable -> L4d
            r2[r4] = r3     // Catch: java.lang.Throwable -> L4d
            int r4 = r4 + 1
        L77:
            int r3 = r3 + 1
            goto L6a
        L7a:
            com.bytedance.pangle.util.FieldUtils.writeField(r9, r1, r0)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r10 = "mAdded"
            com.bytedance.pangle.util.FieldUtils.writeField(r9, r10, r2)     // Catch: java.lang.Throwable -> L4d
        L82:
            return
        L83:
            com.bytedance.sdk.openadsdk.api.y.xj(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.fragment.w.onActivityPostSaveInstanceState(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        r0 = (java.lang.Object[]) java.lang.reflect.Array.newInstance(java.lang.Class.forName("android.app.FragmentState"), r10.length - 1);
        r2 = new int[r10.length - 1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (r3 >= r10.length) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        r6 = r10[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        if (r6 == r5) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
    
        r0[r4] = r6;
        r2[r4] = r3;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
    
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mActive", r0);
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mAdded", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        return;
     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivitySaveInstanceState(android.app.Activity r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle"
            java.lang.String r1 = "mActive"
            android.app.Fragment r2 = r8.xj
            android.app.Activity r2 = r2.getActivity()
            if (r2 == r9) goto Le
            goto L82
        Le:
            java.lang.String r9 = "android:fragments"
            android.os.Parcelable r9 = r10.getParcelable(r9)     // Catch: java.lang.Throwable -> L4d
            if (r9 != 0) goto L18
            goto L82
        L18:
            java.lang.Object r10 = com.bytedance.pangle.util.FieldUtils.readField(r9, r1)     // Catch: java.lang.Throwable -> L4d
            java.lang.Object[] r10 = (java.lang.Object[]) r10     // Catch: java.lang.Throwable -> L4d
            if (r10 != 0) goto L21
            goto L82
        L21:
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4d
            r3 = 0
            r4 = 0
        L24:
            if (r4 >= r2) goto L52
            r5 = r10[r4]     // Catch: java.lang.Throwable -> L4d
            java.lang.String r6 = "mTag"
            java.lang.Object r6 = com.bytedance.pangle.util.FieldUtils.readField(r5, r6)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r7 = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin"
            boolean r7 = r7.equals(r6)     // Catch: java.lang.Throwable -> L4d
            if (r7 == 0) goto L37
            goto L53
        L37:
            boolean r7 = r6 instanceof java.lang.String     // Catch: java.lang.Throwable -> L4d
            if (r7 == 0) goto L4f
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L4d
            boolean r7 = r7.contains(r0)     // Catch: java.lang.Throwable -> L4d
            if (r7 != 0) goto L53
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L4d
            boolean r6 = r6.contains(r0)     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L4f
            goto L53
        L4d:
            r9 = move-exception
            goto L83
        L4f:
            int r4 = r4 + 1
            goto L24
        L52:
            r5 = 0
        L53:
            if (r5 == 0) goto L82
            java.lang.String r0 = "android.app.FragmentState"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L4d
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4d
            int r2 = r2 + (-1)
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r2)     // Catch: java.lang.Throwable -> L4d
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch: java.lang.Throwable -> L4d
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4d
            int r2 = r2 + (-1)
            int[] r2 = new int[r2]     // Catch: java.lang.Throwable -> L4d
            r4 = 0
        L6a:
            int r6 = r10.length     // Catch: java.lang.Throwable -> L4d
            if (r3 >= r6) goto L7a
            r6 = r10[r3]     // Catch: java.lang.Throwable -> L4d
            if (r6 == r5) goto L77
            r0[r4] = r6     // Catch: java.lang.Throwable -> L4d
            r2[r4] = r3     // Catch: java.lang.Throwable -> L4d
            int r4 = r4 + 1
        L77:
            int r3 = r3 + 1
            goto L6a
        L7a:
            com.bytedance.pangle.util.FieldUtils.writeField(r9, r1, r0)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r10 = "mAdded"
            com.bytedance.pangle.util.FieldUtils.writeField(r9, r10, r2)     // Catch: java.lang.Throwable -> L4d
        L82:
            return
        L83:
            com.bytedance.sdk.openadsdk.api.y.xj(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.fragment.w.onActivitySaveInstanceState(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
