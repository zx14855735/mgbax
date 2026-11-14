package MOpbMP;

import AaHO0E.H0R8Px;
import android.content.Intent;
import android.view.MenuItem;
import com.game.boy.activity.DownLoadActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B7CMnp implements LLiCI0.COJEAR, H0R8Px {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ BpkvW3 f5039AcNBzu;

    public /* synthetic */ B7CMnp(BpkvW3 bpkvW3) {
        this.f5039AcNBzu = bpkvW3;
    }

    @Override // LLiCI0.COJEAR
    public void A4TApA(MTKlkd.ARc23Z aRc23Z) {
        B2KMhB AzWtSf2 = B2KMhB.AzWtSf(aRc23Z);
        AzWtSf2.show(this.f5039AcNBzu.requireActivity().getSupportFragmentManager(), AzWtSf2.getTag());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b2, code lost:
    
        if (r3 != 6) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d9 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:23:0x00d3, B:25:0x00d9, B:28:0x00e1), top: B:22:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e1 A[Catch: Exception -> 0x00e8, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e8, blocks: (B:23:0x00d3, B:25:0x00d9, B:28:0x00e1), top: B:22:0x00d3 }] */
    @Override // LLiCI0.COJEAR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A5SV6n(MTKlkd.ARc23Z r8) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: MOpbMP.B7CMnp.A5SV6n(MTKlkd.ARc23Z):void");
    }

    @Override // AaHO0E.H0R8Px
    public boolean onMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        BpkvW3 bpkvW3 = this.f5039AcNBzu;
        if (itemId == 2131296318) {
            bpkvW3.getClass();
            bpkvW3.startActivityForResult(new Intent("android.intent.action.GET_CONTENT").setType("*/*").addCategory("android.intent.category.OPENABLE"), 1003);
            return true;
        }
        if (menuItem.getItemId() != 2131297610) {
            if (menuItem.getItemId() != 2131297592) {
                return false;
            }
            bpkvW3.requireActivity().startActivity(new Intent(bpkvW3.requireActivity(), (Class<?>) DownLoadActivity.class));
            return true;
        }
        boolean AzWtSf2 = bpkvW3.BpkvW3.AzWtSf("list_grid");
        bpkvW3.B2KMhB(!AzWtSf2);
        bpkvW3.BpkvW3.BI9f7h("list_grid", !AzWtSf2);
        bpkvW3.f5066AzWtSf.notifyDataSetChanged();
        return true;
    }
}
