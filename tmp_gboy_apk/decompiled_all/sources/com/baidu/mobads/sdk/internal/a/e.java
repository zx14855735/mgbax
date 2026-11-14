package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e implements a {

    /* renamed from: a, reason: collision with root package name */
    private c f9724a;

    public void a(IAdInterListener iAdInterListener) {
        if (iAdInterListener != null) {
            this.f9724a = c.a(iAdInterListener, this);
        }
    }

    public void b(Bundle bundle) {
        this.f9724a.a("onActivityCreated", bundle);
    }

    public void c() {
        this.f9724a.a("onPause");
    }

    public void d() {
        this.f9724a.a("onStop");
    }

    public void e() {
        this.f9724a.a("onDestroyView");
    }

    public void f() {
        this.f9724a.a("onDestroy");
    }

    public void g() {
        this.f9724a.a("onDetach");
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f9724a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f9724a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public IAdInterListener getDelegator() {
        return this.f9724a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f9724a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f9724a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f9724a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f9724a.setTarget(obj);
    }

    public void a(Context context) {
        this.f9724a.a("onAttach", context);
    }

    public void b() {
        this.f9724a.a("onResume");
    }

    public void a(Bundle bundle) {
        this.f9724a.a("onCreate", bundle);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Object a2 = this.f9724a.a("onCreateView", layoutInflater, viewGroup, bundle);
        if (a2 instanceof View) {
            return (View) a2;
        }
        return null;
    }

    public void a() {
        this.f9724a.a("onStart");
    }
}
