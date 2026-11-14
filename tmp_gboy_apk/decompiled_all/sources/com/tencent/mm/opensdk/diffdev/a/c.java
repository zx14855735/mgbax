package com.tencent.mm.opensdk.diffdev.a;

import ADYaiT.CtFAbx;
import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class c extends AsyncTask<Void, Void, a> {

    /* renamed from: a, reason: collision with root package name */
    private String f13869a;
    private String b;
    private OAuthListener c;
    private int d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public OAuthErrCode f13870a;
        public String b;
        public int c;
    }

    public c(String str, OAuthListener oAuthListener) {
        this.f13869a = str;
        this.c = oAuthListener;
        this.b = CtFAbx.BChYOn("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0167 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.tencent.mm.opensdk.diffdev.a.c.a doInBackground(java.lang.Void[] r15) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.c.onAuthFinish(aVar2.f13870a, aVar2.b);
    }
}
