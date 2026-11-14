package com.czhj.volley.toolbox;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.ImageLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NetworkImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private String f10656a;
    private int b;
    private int c;
    private ImageLoader d;
    private ImageLoader.ImageContainer e;

    /* renamed from: com.czhj.volley.toolbox.NetworkImageView$1, reason: invalid class name */
    public class AnonymousClass1 implements ImageLoader.ImageListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f10657a;

        public AnonymousClass1(boolean z) {
            this.f10657a = z;
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (NetworkImageView.this.c != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.c);
            }
        }

        @Override // com.czhj.volley.toolbox.ImageLoader.ImageListener
        public void onResponse(final ImageLoader.ImageContainer imageContainer, boolean z) {
            if (z && this.f10657a) {
                NetworkImageView.this.post(new Runnable() { // from class: com.czhj.volley.toolbox.NetworkImageView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.onResponse(imageContainer, false);
                    }
                });
                return;
            }
            if (imageContainer.getBitmap() != null) {
                NetworkImageView.this.setImageBitmap(imageContainer.getBitmap());
            } else if (NetworkImageView.this.b != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.b);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        ImageLoader.ImageContainer imageContainer = this.e;
        if (imageContainer != null) {
            imageContainer.cancelRequest();
            setImageBitmap(null);
            this.e = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(true);
    }

    public void setDefaultImageResId(int i) {
        this.b = i;
    }

    public void setErrorImageResId(int i) {
        this.c = i;
    }

    public void setImageUrl(String str, ImageLoader imageLoader) {
        Threads.a();
        this.f10656a = str;
        this.d = imageLoader;
        a(false);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        int i = this.b;
        if (i != 0) {
            setImageResource(i);
        } else {
            setImageBitmap(null);
        }
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r9) {
        /*
            r8 = this;
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            android.widget.ImageView$ScaleType r7 = r8.getScaleType()
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2a
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            int r2 = r2.width
            r5 = -2
            if (r2 != r5) goto L1f
            r2 = 1
            goto L20
        L1f:
            r2 = 0
        L20:
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            int r6 = r6.height
            if (r6 != r5) goto L2b
            r5 = 1
            goto L2c
        L2a:
            r2 = 0
        L2b:
            r5 = 0
        L2c:
            if (r2 == 0) goto L31
            if (r5 == 0) goto L31
            goto L32
        L31:
            r3 = 0
        L32:
            if (r0 != 0) goto L39
            if (r1 != 0) goto L39
            if (r3 != 0) goto L39
            goto L67
        L39:
            java.lang.String r3 = r8.f10656a
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L4f
            com.czhj.volley.toolbox.ImageLoader$ImageContainer r9 = r8.e
            if (r9 == 0) goto L4b
            r9.cancelRequest()
            r9 = 0
            r8.e = r9
        L4b:
            r8.a()
            return
        L4f:
            com.czhj.volley.toolbox.ImageLoader$ImageContainer r3 = r8.e
            if (r3 == 0) goto L70
            java.lang.String r3 = r3.getRequestUrl()
            if (r3 == 0) goto L70
            com.czhj.volley.toolbox.ImageLoader$ImageContainer r3 = r8.e
            java.lang.String r3 = r3.getRequestUrl()
            java.lang.String r6 = r8.f10656a
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L68
        L67:
            return
        L68:
            com.czhj.volley.toolbox.ImageLoader$ImageContainer r3 = r8.e
            r3.cancelRequest()
            r8.a()
        L70:
            if (r2 == 0) goto L73
            r0 = 0
        L73:
            if (r5 == 0) goto L77
            r6 = 0
            goto L78
        L77:
            r6 = r1
        L78:
            com.czhj.volley.toolbox.ImageLoader r2 = r8.d
            java.lang.String r3 = r8.f10656a
            com.czhj.volley.toolbox.NetworkImageView$1 r4 = new com.czhj.volley.toolbox.NetworkImageView$1
            r4.<init>(r9)
            r5 = r0
            com.czhj.volley.toolbox.ImageLoader$ImageContainer r9 = r2.get(r3, r4, r5, r6, r7)
            r8.e = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.volley.toolbox.NetworkImageView.a(boolean):void");
    }
}
