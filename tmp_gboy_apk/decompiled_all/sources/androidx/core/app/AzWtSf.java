package androidx.core.app;

import android.os.AsyncTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf extends AsyncTask {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ BIYEnU f8485A2egSU;

    public AzWtSf(BIYEnU bIYEnU) {
        this.f8485A2egSU = bIYEnU;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        while (true) {
            BIYEnU bIYEnU = this.f8485A2egSU;
            B4ZgIw dequeueWork = bIYEnU.dequeueWork();
            if (dequeueWork == null) {
                return null;
            }
            bIYEnU.onHandleWork(dequeueWork.getIntent());
            dequeueWork.complete();
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled(Object obj) {
        this.f8485A2egSU.processorFinished();
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        this.f8485A2egSU.processorFinished();
    }
}
