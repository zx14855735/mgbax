package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    public Drawable c;
    public View d;
    public InterfaceC0464hf f;
    public String hf;
    public String kd;
    public int tf;
    public String u;
    public String w;
    public Context xj;
    public boolean y;

    /* renamed from: com.ss.android.download.api.model.hf$hf, reason: collision with other inner class name */
    public interface InterfaceC0464hf {
        void hf(DialogInterface dialogInterface);

        void w(DialogInterface dialogInterface);

        void xj(DialogInterface dialogInterface);
    }

    public static final class xj {
        private String c;
        private Drawable d;
        private boolean f;
        public int hf;
        private String kd;
        private InterfaceC0464hf tf;
        private String u;
        private Context w;
        public View xj;
        private String y;

        public xj(Context context) {
            this.w = context;
        }

        public xj hf(String str) {
            this.kd = str;
            return this;
        }

        public xj u(String str) {
            this.c = str;
            return this;
        }

        public xj w(String str) {
            this.y = str;
            return this;
        }

        public xj xj(String str) {
            this.u = str;
            return this;
        }

        public xj xj(boolean z) {
            this.f = z;
            return this;
        }

        public xj xj(Drawable drawable) {
            this.d = drawable;
            return this;
        }

        public xj xj(InterfaceC0464hf interfaceC0464hf) {
            this.tf = interfaceC0464hf;
            return this;
        }

        public xj xj(int i) {
            this.hf = i;
            return this;
        }

        public hf xj() {
            return new hf(this);
        }
    }

    private hf(xj xjVar) {
        this.y = true;
        this.xj = xjVar.w;
        this.hf = xjVar.u;
        this.w = xjVar.kd;
        this.u = xjVar.y;
        this.kd = xjVar.c;
        this.y = xjVar.f;
        this.c = xjVar.d;
        this.f = xjVar.tf;
        this.d = xjVar.xj;
        this.tf = xjVar.hf;
    }
}
