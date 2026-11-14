package Qo94AZ;

import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum AcNBzu {
    /* JADX INFO: Fake field, exist only in values array */
    TOO_MANY_REQUESTS(101, "Switching Protocols"),
    OK(200, cb.k),
    /* JADX INFO: Fake field, exist only in values array */
    CREATED(201, "Created"),
    /* JADX INFO: Fake field, exist only in values array */
    ACCEPTED(202, "Accepted"),
    /* JADX INFO: Fake field, exist only in values array */
    NO_CONTENT(204, "No Content"),
    /* JADX INFO: Fake field, exist only in values array */
    PARTIAL_CONTENT(206, "Partial Content"),
    /* JADX INFO: Fake field, exist only in values array */
    MULTI_STATUS(207, "Multi-Status"),
    REDIRECT(301, "Moved Permanently"),
    /* JADX INFO: Fake field, exist only in values array */
    FOUND(302, "Found"),
    /* JADX INFO: Fake field, exist only in values array */
    REDIRECT_SEE_OTHER(303, "See Other"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_MODIFIED(304, "Not Modified"),
    /* JADX INFO: Fake field, exist only in values array */
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    BAD_REQUEST(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, "Bad Request"),
    /* JADX INFO: Fake field, exist only in values array */
    TOO_MANY_REQUESTS(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(405, "Method Not Allowed"),
    /* JADX INFO: Fake field, exist only in values array */
    TOO_MANY_REQUESTS(406, "Not Acceptable"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(TTAdConstant.INTERACTION_TYPE_CODE, "Request Timeout"),
    CONFLICT(TTAdConstant.IMAGE_LIST_CODE, "Conflict"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(TTAdConstant.IMAGE_LIST_SIZE_CODE, "Gone"),
    /* JADX INFO: Fake field, exist only in values array */
    TOO_MANY_REQUESTS(TTAdConstant.IMAGE_CODE, "Length Required"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(TTAdConstant.IMAGE_URL_CODE, "Precondition Failed"),
    /* JADX INFO: Fake field, exist only in values array */
    TOO_MANY_REQUESTS(TTAdConstant.VIDEO_INFO_CODE, "Payload Too Large"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(TTAdConstant.VIDEO_COVER_URL_CODE, "Unsupported Media Type"),
    /* JADX INFO: Fake field, exist only in values array */
    TOO_MANY_REQUESTS(416, "Requested Range Not Satisfiable"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(TTAdConstant.LIVE_FEED_URL_CODE, "Expectation Failed"),
    /* JADX INFO: Fake field, exist only in values array */
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    INTERNAL_ERROR(500, "Internal Server Error"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_IMPLEMENTED(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE, "Not Implemented"),
    /* JADX INFO: Fake field, exist only in values array */
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    /* JADX INFO: Fake field, exist only in values array */
    UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");


    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f7802AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final String f7803AlLFFp;

    static {
        mjwFbr();
    }

    AcNBzu(int i, String str) {
        this.f7802AcNBzu = i;
        this.f7803AlLFFp = str;
    }

    private static /* synthetic */ void mjwFbr() {
        char[] charArray = "\u0083\u008f\u008dÎ\u0087\u0081\u008d\u0085Î\u0082\u008f\u0099Î\u0093\u0088\u0085\u008c\u008cÎª\u008e\u0089¢\u0092\u0089\u0084\u0087\u0085".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 224);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0083\u008c\u0089\u008e\u0089\u0094".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 224);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
