package P8ccfD;

import COJEAR.BNL6CD;
import COJEAR.FG7pZc;
import Oay4Bh.C4FrIb;
import Oay4Bh.COJEAR;
import Oay4Bh.CQhlFr;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.search.SearchView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class AYUAbz implements COJEAR, BNL6CD {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ SearchView f6972AcNBzu;

    public /* synthetic */ AYUAbz(SearchView searchView) {
        this.f6972AcNBzu = searchView;
    }

    @Override // Oay4Bh.COJEAR
    public FG7pZc AZOQYO(View view, FG7pZc fG7pZc, CQhlFr cQhlFr) {
        MaterialToolbar materialToolbar = this.f6972AcNBzu.f11765B3GDIM;
        boolean AlLFFp2 = C4FrIb.AlLFFp(materialToolbar);
        int i = AlLFFp2 ? cQhlFr.f6614A5SV6n : cQhlFr.f6612A2egSU;
        int i2 = AlLFFp2 ? cQhlFr.f6612A2egSU : cQhlFr.f6614A5SV6n;
        BV3sI0.A5SV6n ARc23Z2 = fG7pZc.f1747A2egSU.ARc23Z(MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET);
        materialToolbar.setPadding(i + ARc23Z2.f1482A2egSU, cQhlFr.f6613A4TApA, i2 + ARc23Z2.f1484A5SV6n, cQhlFr.f6615ADYaiT);
        return fG7pZc;
    }

    @Override // COJEAR.BNL6CD
    public FG7pZc B3GDIM(View view, FG7pZc fG7pZc) {
        SearchView.AMqCpz(this.f6972AcNBzu, fG7pZc);
        return fG7pZc;
    }
}
