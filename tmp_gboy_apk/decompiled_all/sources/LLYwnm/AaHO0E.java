package LLYwnm;

import com.baidu.mobads.sdk.internal.cb;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ScheduledFuture;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E extends WebSocketListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f4635A2egSU;

    public AaHO0E(AcNBzu acNBzu) {
        this.f4635A2egSU = acNBzu;
    }

    @Override // okhttp3.WebSocketListener
    public final void onClosed(WebSocket webSocket, int i, String str) {
        this.f4635A2egSU.f4639ADYaiT = false;
        this.f4635A2egSU.f4645AaHO0E = false;
        AYUAbz aYUAbz = this.f4635A2egSU.f4638A5SV6n;
        if (str == null) {
            str = "连接关闭";
        }
        aYUAbz.getClass();
        aYUAbz.A5SV6n(new ARc23Z(aYUAbz, str, 2));
        this.f4635A2egSU.AMqCpz();
    }

    @Override // okhttp3.WebSocketListener
    public final void onClosing(WebSocket webSocket, int i, String str) {
        this.f4635A2egSU.f4639ADYaiT = false;
        this.f4635A2egSU.f4645AaHO0E = false;
        AYUAbz aYUAbz = this.f4635A2egSU.f4638A5SV6n;
        if (str == null) {
            str = "连接关闭";
        }
        aYUAbz.getClass();
        aYUAbz.A5SV6n(new ARc23Z(aYUAbz, str, 2));
        this.f4635A2egSU.AMqCpz();
    }

    @Override // okhttp3.WebSocketListener
    public final void onFailure(WebSocket webSocket, Throwable th, Response response) {
        this.f4635A2egSU.f4639ADYaiT = false;
        this.f4635A2egSU.f4645AaHO0E = false;
        this.f4635A2egSU.AMqCpz();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // okhttp3.WebSocketListener
    public final void onMessage(WebSocket webSocket, String str) {
        char c;
        int parseInt;
        ASJ6gh aSJ6gh;
        int i = 0;
        if (str != null) {
            AYUAbz aYUAbz = this.f4635A2egSU.f4638A5SV6n;
            aYUAbz.getClass();
            try {
                Map map = (Map) AYUAbz.f4624AaHO0E.fromJson(str, AYUAbz.f4625AcNBzu);
                if (map == null) {
                    return;
                }
                String A4TApA2 = AYUAbz.A4TApA(map.get(PointParamKey.TYPE));
                if (A4TApA2 == null) {
                    String A4TApA3 = AYUAbz.A4TApA(map.get("error"));
                    if (A4TApA3 != null) {
                        aYUAbz.A5SV6n(new A2egSU(aYUAbz, A4TApA3, 1));
                    }
                    return;
                }
                Queue queue = (Queue) aYUAbz.f4632AYUAbz.get(A4TApA2);
                if (queue != null && (aSJ6gh = (ASJ6gh) queue.poll()) != null) {
                    ScheduledFuture scheduledFuture = aSJ6gh.f4623A4TApA;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    aYUAbz.A5SV6n(new C4FrIb.A2egSU(map, 20, aSJ6gh.f4622A2egSU));
                }
                switch (A4TApA2.hashCode()) {
                    case -2027676457:
                        if (A4TApA2.equals("invite_player")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1976350189:
                        if (A4TApA2.equals("invite_result")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1840725117:
                        if (A4TApA2.equals("room_settings_updated")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1752704409:
                        if (A4TApA2.equals("player_joined")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1717682656:
                        if (A4TApA2.equals("accept_invite")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1369913769:
                        if (A4TApA2.equals("invite_received")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -684367601:
                        if (A4TApA2.equals("invite_canceled")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -624136624:
                        if (A4TApA2.equals("send_message")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case -29981341:
                        if (A4TApA2.equals("leave_room")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 3107:
                        if (A4TApA2.equals(ClickCommon.CLICK_SCENE_AD)) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case 3441010:
                        if (A4TApA2.equals("ping")) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case 175912873:
                        if (A4TApA2.equals("reject_invite")) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case 339235102:
                        if (A4TApA2.equals("user_join")) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    case 970405333:
                        if (A4TApA2.equals("game_start")) {
                            c = '\r';
                            break;
                        }
                        c = 65535;
                        break;
                    case 1927895363:
                        if (A4TApA2.equals("user_leave")) {
                            c = 14;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        aYUAbz.A5SV6n(new ADYaiT(aYUAbz, map, 4));
                        break;
                    case 1:
                        aYUAbz.A5SV6n(new ADYaiT(aYUAbz, map, 6));
                        break;
                    case 2:
                        if (AYUAbz.A2egSU(map.get(cb.o))) {
                            Object obj = map.get("settings");
                            aYUAbz.A5SV6n(new ADYaiT(aYUAbz, obj instanceof Map ? (Map) obj : new HashMap(), 1));
                            break;
                        }
                        break;
                    case 3:
                        aYUAbz.A5SV6n(new ADYaiT(aYUAbz, map, 0));
                        break;
                    case 4:
                        aYUAbz.A5SV6n(new ADYaiT(aYUAbz, map, 5));
                        break;
                    case 5:
                        aYUAbz.A5SV6n(new ADYaiT(aYUAbz, map, 3));
                        break;
                    case 6:
                        aYUAbz.A5SV6n(new ADYaiT(aYUAbz, map, 7));
                        break;
                    case 7:
                        aYUAbz.A5SV6n(new A5SV6n(aYUAbz, AYUAbz.A2egSU(map.get(cb.o)), map));
                        break;
                    case '\b':
                        aYUAbz.A5SV6n(new A5SV6n(aYUAbz, map, AYUAbz.A2egSU(map.get(cb.o))));
                        break;
                    case '\t':
                        aYUAbz.A5SV6n(new A2egSU(aYUAbz, AYUAbz.A4TApA(map.get("message")), 2));
                        break;
                    case '\n':
                        aYUAbz.f4626A2egSU.ARc23Z(J3FDQU.A2egSU.BI9f7h("action", "pong"), null);
                        break;
                    case 11:
                        aYUAbz.A5SV6n(new ARc23Z(aYUAbz, map, i));
                        break;
                    case '\f':
                        String A4TApA4 = AYUAbz.A4TApA(map.get("uuid"));
                        Object obj2 = map.get("players");
                        if (obj2 != null) {
                            if (obj2 instanceof Number) {
                                parseInt = ((Number) obj2).intValue();
                            } else {
                                try {
                                    parseInt = Integer.parseInt(String.valueOf(obj2));
                                } catch (Exception unused) {
                                }
                            }
                            aYUAbz.A5SV6n(new A4TApA(aYUAbz, A4TApA4, parseInt, 0));
                            break;
                        }
                        parseInt = 0;
                        aYUAbz.A5SV6n(new A4TApA(aYUAbz, A4TApA4, parseInt, 0));
                    case '\r':
                        aYUAbz.A5SV6n(new ADYaiT(aYUAbz, map, 2));
                        break;
                    case 14:
                        String A4TApA5 = AYUAbz.A4TApA(map.get("uuid"));
                        Object obj3 = map.get("players");
                        if (obj3 != null) {
                            if (obj3 instanceof Number) {
                                i = ((Number) obj3).intValue();
                            } else {
                                try {
                                    i = Integer.parseInt(String.valueOf(obj3));
                                } catch (Exception unused2) {
                                }
                            }
                        }
                        aYUAbz.A5SV6n(new A4TApA(aYUAbz, A4TApA5, i, 1));
                        break;
                }
            } catch (Exception unused3) {
            }
        }
    }

    @Override // okhttp3.WebSocketListener
    public final void onOpen(WebSocket webSocket, Response response) {
        this.f4635A2egSU.f4645AaHO0E = false;
        this.f4635A2egSU.f4639ADYaiT = true;
        this.f4635A2egSU.f4642AYUAbz.set(0L);
        AYUAbz aYUAbz = this.f4635A2egSU.f4638A5SV6n;
        aYUAbz.getClass();
        aYUAbz.A5SV6n(new ARc23Z(aYUAbz));
    }

    @Override // okhttp3.WebSocketListener
    public final void onMessage(WebSocket webSocket, ByteString byteString) {
        if (byteString != null) {
            AYUAbz aYUAbz = this.f4635A2egSU.f4638A5SV6n;
            byteString.toByteArray();
            aYUAbz.getClass();
        }
    }
}
