package Mm8v1u;

import android.content.Intent;
import android.net.Uri;
import android.text.style.URLSpan;
import android.view.View;
import com.game.boy.viewUi.HTMLTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp extends URLSpan {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ HTMLTextView f5500AcNBzu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlLFFp(HTMLTextView hTMLTextView, String str) {
        super(str);
        this.f5500AcNBzu = hTMLTextView;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public final void onClick(View view) {
        String url = getURL();
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            this.f5500AcNBzu.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
