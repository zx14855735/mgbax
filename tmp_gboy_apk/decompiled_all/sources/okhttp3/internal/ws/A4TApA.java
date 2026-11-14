package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.AYUAbz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class A4TApA implements Callback {
    final /* synthetic */ A2egSU this$0;
    final /* synthetic */ Request val$request;

    public A4TApA(A2egSU a2egSU, Request request) {
        this.this$0 = a2egSU;
        this.val$request = request;
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call call, IOException iOException) {
        this.this$0.A5SV6n(iOException, null);
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) {
        try {
            this.this$0.A2egSU(response);
            AYUAbz streamAllocation = okhttp3.internal.A2egSU.instance.streamAllocation(call);
            streamAllocation.AZkASS();
            okhttp3.internal.connection.A5SV6n AcNBzu2 = streamAllocation.ADYaiT().AcNBzu(streamAllocation);
            try {
                A2egSU a2egSU = this.this$0;
                a2egSU.listener.onOpen(a2egSU, response);
                this.this$0.ADYaiT("OkHttp WebSocket " + this.val$request.url().redact(), AcNBzu2);
                streamAllocation.ADYaiT().socket().setSoTimeout(0);
                this.this$0.AMqCpz();
            } catch (Exception e) {
                this.this$0.A5SV6n(e, null);
            }
        } catch (ProtocolException e2) {
            this.this$0.A5SV6n(e2, response);
            okhttp3.internal.A5SV6n.ARc23Z(response);
        }
    }
}
