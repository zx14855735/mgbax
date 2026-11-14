package Mm8v1u;

import android.text.Editable;
import android.text.Html;
import com.game.boy.viewUi.HTMLTextView;
import com.kuaishou.weapon.p0.t;
import org.xml.sax.XMLReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu implements Html.TagHandler {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ HTMLTextView f5499A2egSU;

    public AcNBzu(HTMLTextView hTMLTextView) {
        this.f5499A2egSU = hTMLTextView;
    }

    @Override // android.text.Html.TagHandler
    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        boolean equalsIgnoreCase = str.equalsIgnoreCase(t.f);
        HTMLTextView hTMLTextView = this.f5499A2egSU;
        if (equalsIgnoreCase && z) {
            int length = editable.length();
            editable.setSpan(new AlLFFp(hTMLTextView, ""), length, length, 17);
            return;
        }
        if (!str.equalsIgnoreCase(t.f) || z) {
            return;
        }
        int length2 = editable.length();
        Object[] spans = editable.getSpans(0, editable.length(), AlLFFp.class);
        Object obj = spans.length == 0 ? null : spans[spans.length - 1];
        int spanStart = editable.getSpanStart(obj);
        editable.removeSpan(obj);
        if (spanStart != length2) {
            editable.setSpan(new AlLFFp(hTMLTextView, editable.subSequence(spanStart, length2).toString()), spanStart, length2, 33);
        }
    }
}
