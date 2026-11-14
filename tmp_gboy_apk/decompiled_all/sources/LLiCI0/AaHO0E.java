package LLiCI0;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.C;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ String f4694AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Context f4695AlLFFp;

    public AaHO0E(String str, Context context) {
        this.f4694AcNBzu = str;
        this.f4695AlLFFp = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        String str = this.f4694AcNBzu;
        boolean isEmpty = str.isEmpty();
        Context context = this.f4695AlLFFp;
        if (isEmpty) {
            Toast.makeText(context, "无链接", 0).show();
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.encode(str, ":/?=&#%+")));
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(context, "没有可用浏览器", 0).show();
        }
    }
}
