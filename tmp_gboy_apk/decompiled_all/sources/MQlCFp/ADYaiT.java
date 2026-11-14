package MQlCFp;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5145AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f5146AlLFFp;

    public /* synthetic */ ADYaiT(AYUAbz aYUAbz, int i) {
        this.f5145AcNBzu = i;
        this.f5146AlLFFp = aYUAbz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5145AcNBzu) {
            case 0:
                AYUAbz aYUAbz = this.f5146AlLFFp;
                boolean z = aYUAbz.f5154AmA8tU;
                aYUAbz.f5154AmA8tU = !z;
                aYUAbz.f5156B25kr6.setMaxLines(!z ? Integer.MAX_VALUE : 3);
                aYUAbz.f5158B3GDIM.setText(aYUAbz.f5154AmA8tU ? "收起" : "展开");
                break;
            default:
                AYUAbz aYUAbz2 = this.f5146AlLFFp;
                boolean z2 = aYUAbz2.f5155AzWtSf;
                aYUAbz2.f5155AzWtSf = !z2;
                aYUAbz2.f5157B2KMhB.setMaxLines(!z2 ? Integer.MAX_VALUE : 1);
                aYUAbz2.f5159B4ZgIw.setText(aYUAbz2.f5155AzWtSf ? "收起" : "展开");
                break;
        }
    }
}
