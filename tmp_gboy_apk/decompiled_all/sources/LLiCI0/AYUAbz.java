package LLiCI0;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz extends Dphsd2 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final TextView f4687AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final TextView f4688AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f4689AmA8tU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AYUAbz(AZOQYO azoqyo, View view) {
        super(view);
        this.f4689AmA8tU = azoqyo;
        this.f4687AcNBzu = (TextView) view.findViewById(2131296585);
        this.f4688AlLFFp = (TextView) view.findViewById(2131296583);
        view.setOnClickListener(new ADYaiT.A5SV6n(7, this));
    }
}
