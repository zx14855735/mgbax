package MF4Id8;

import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import com.game.boy.activity.ASJ6gh;
import com.game.boy.activity.BI9f7h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements NfcAdapter.CreateNdefMessageCallback, NfcAdapter.OnNdefPushCompleteCallback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BI9f7h f4977A2egSU;

    public A2egSU(BI9f7h bI9f7h) {
        this.f4977A2egSU = bI9f7h;
    }

    @Override // android.nfc.NfcAdapter.CreateNdefMessageCallback
    public final NdefMessage createNdefMessage(NfcEvent nfcEvent) {
        this.f4977A2egSU.f10917AcNBzu.BniPrB();
        return null;
    }

    @Override // android.nfc.NfcAdapter.OnNdefPushCompleteCallback
    public final void onNdefPushComplete(NfcEvent nfcEvent) {
        BI9f7h bI9f7h = this.f4977A2egSU;
        bI9f7h.f10917AcNBzu.f11008BniPrB.post(new ASJ6gh(3, bI9f7h));
    }
}
