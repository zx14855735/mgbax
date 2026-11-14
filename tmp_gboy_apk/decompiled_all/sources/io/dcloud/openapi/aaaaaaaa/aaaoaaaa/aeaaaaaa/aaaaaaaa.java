package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaaa {
    private Context aaaaaaa0;
    protected aaaaaaao aaaaaaaa;
    protected io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaac;
    protected String aaaaaaao;

    public class aaaaaaa0 implements Runnable {
        public aaaaaaa0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            aaaaaaaa.this.aaaaaaaa.onSplashAdLoad();
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class RunnableC0541aaaaaaaa implements Runnable {
        final /* synthetic */ String aaaaaaa0;
        final /* synthetic */ int aaaaaaaa;

        public RunnableC0541aaaaaaaa(int i, String str) {
            this.aaaaaaaa = i;
            this.aaaaaaa0 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            aaaaaaaa.this.aaaaaaaa.onError(this.aaaaaaaa, this.aaaaaaa0);
        }
    }

    public interface aaaaaaao {
        void aaaaaaaa(int i, String str);

        void aaaaaaae();

        void aaaaeaaa();

        void onAdClicked();

        void onAdShow();

        void onError(int i, String str);

        void onSplashAdLoad();
    }

    public aaaaaaaa(aaaaaaao aaaaaaaoVar, Context context, String str) {
        this.aaaaaaaa = aaaaaaaoVar;
        this.aaaaaaa0 = context;
        this.aaaaaaao = str;
    }

    public Context aaaaaaa0() {
        return this.aaaaaaa0;
    }

    public void aaaaaaaa(ViewGroup viewGroup) {
        if (viewGroup == null) {
            aaaaaaaa(60010, "广告容器不可见");
        } else if (this.aaaaaaac == null) {
            aaaaaaaa(60005, "数据解析失败");
        } else {
            new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaoa.aaaaaaa0(viewGroup.getContext(), this.aaaaaaaa, this.aaaaaaac).aaaaaaaa(viewGroup);
        }
    }

    public void aaaaaaaa(int i, String str) {
        if (this.aaaaaaaa != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0541aaaaaaaa(i, str));
        }
    }

    public void aaaaaaaa() {
        if (this.aaaaaaaa != null) {
            new Handler(Looper.getMainLooper()).post(new aaaaaaa0());
        }
    }
}
