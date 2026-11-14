package com.bytedance.sdk.openadsdk.core.ra;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.hf.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf {
    private View am;
    private String e;
    private View g;
    private String ht;
    private boolean qt;
    private int ra;
    private String v;
    private float xj = -1.0f;
    private float hf = -1.0f;
    private float w = -1.0f;
    private float u = -1.0f;
    private long kd = -1;
    private long y = -1;
    private int c = -1;
    private int f = -1;
    private int d = -1024;
    private boolean tf = true;
    private int p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private int f10414pl = 0;
    private boolean zg = false;
    private int yo = -1;
    private SparseArray<u.xj> jk = new SparseArray<>();
    private List<Integer> pz = new ArrayList();

    public float am() {
        return this.xj;
    }

    public View c() {
        return this.am;
    }

    public int d() {
        return this.f10414pl;
    }

    public float e() {
        return this.u;
    }

    public int f() {
        return this.p;
    }

    public long g() {
        return this.y;
    }

    public int hf() {
        return this.c;
    }

    public String jk() {
        return this.v;
    }

    public boolean kd() {
        return this.tf;
    }

    public List<Integer> p() {
        return this.pz;
    }

    public long pl() {
        return this.kd;
    }

    public String pz() {
        return this.ht;
    }

    public float qt() {
        return this.hf;
    }

    public SparseArray<u.xj> tf() {
        return this.jk;
    }

    public int u() {
        return this.d;
    }

    public int v() {
        return this.yo;
    }

    public int w() {
        return this.f;
    }

    public boolean xj() {
        return this.ra == 2;
    }

    public View y() {
        return this.g;
    }

    public String yo() {
        return this.e;
    }

    public float zg() {
        return this.w;
    }

    public void c(int i) {
        this.yo = i;
    }

    public void hf(int i) {
        this.c = i;
    }

    public void kd(int i) {
        this.p = i;
    }

    public void u(int i) {
        this.d = i;
    }

    public void w(int i) {
        this.f = i;
    }

    public void xj(int i) {
        this.ra = i;
    }

    public void y(int i) {
        this.f10414pl = i;
    }

    public void hf(View view) {
        this.am = (View) new WeakReference(view).get();
    }

    public void u(float f) {
        this.u = f;
    }

    public void w(float f) {
        this.w = f;
    }

    public void xj(boolean z) {
        this.tf = z;
    }

    public void hf(long j) {
        this.y = j;
    }

    public void w(boolean z) {
        this.zg = z;
    }

    public void xj(View view) {
        this.g = (View) new WeakReference(view).get();
    }

    public void hf(float f) {
        this.hf = f;
    }

    public void w(String str) {
        this.ht = str;
    }

    public void xj(SparseArray<u.xj> sparseArray) {
        this.jk = sparseArray;
    }

    public void hf(boolean z) {
        this.qt = z;
    }

    public void xj(long j) {
        this.kd = j;
    }

    public void hf(String str) {
        this.v = str;
    }

    public void xj(float f) {
        this.xj = f;
    }

    public void xj(String str) {
        this.e = str;
    }
}
