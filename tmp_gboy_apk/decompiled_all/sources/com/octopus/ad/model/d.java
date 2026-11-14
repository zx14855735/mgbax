package com.octopus.ad.model;

import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f12640a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;

    public d(int i) {
        this.f12640a = i;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.r = String.valueOf(i);
        this.s = String.valueOf(i2);
        this.t = String.valueOf(i3);
        this.u = String.valueOf(i4);
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.k;
    }

    public String l() {
        return this.l;
    }

    public String m() {
        return this.m;
    }

    public String n() {
        return this.n;
    }

    public String o() {
        return this.o;
    }

    public String p() {
        return this.p;
    }

    public String q() {
        return this.q;
    }

    public String r() {
        return this.r;
    }

    public String s() {
        return this.s;
    }

    public String t() {
        return this.t;
    }

    public String u() {
        return this.u;
    }

    public void b(float f) {
        this.c = a(f);
    }

    public void c(float f) {
        this.e = a(f);
    }

    public void d(float f) {
        this.f = a(f);
    }

    public d(int i, int i2, int i3, float f, float f2, float f3, double d, int i4, int i5) {
        this.f12640a = i == 0 ? 2 : 5;
        this.j = String.valueOf(i2);
        this.k = String.valueOf(i3);
        this.l = a(f);
        this.m = a(f2);
        this.n = a(f3);
        this.o = a(d);
        this.p = String.valueOf(i4);
        this.q = String.valueOf(i5);
        this.i = String.valueOf(System.currentTimeMillis());
        this.h = String.valueOf(System.currentTimeMillis() / 1000);
    }

    public void b(String str) {
        this.g = str;
    }

    public void c(String str) {
        this.h = str;
    }

    public void d(String str) {
        this.i = str;
    }

    public void b(int i) {
        this.k = String.valueOf(i);
    }

    public String a(double d) {
        return String.format(Locale.US, "%.2f", Double.valueOf(d));
    }

    public int a() {
        return this.f12640a;
    }

    public void a(float f) {
        this.b = a(f);
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(int i) {
        this.j = String.valueOf(i);
    }
}
