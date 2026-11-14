package RujA7D;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.qq.e.comm.adevent.AdEventType;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum A2egSU {
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(0, "No error"),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(101, "Failed to open given input"),
    /* JADX INFO: Fake field, exist only in values array */
    READ_FAILED(102, "Failed to read from given input"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_GIF_FILE(103, "Data is not in GIF format"),
    /* JADX INFO: Fake field, exist only in values array */
    NO_SCRN_DSCR(104, "No screen descriptor detected"),
    /* JADX INFO: Fake field, exist only in values array */
    NO_IMAG_DSCR(105, "No image descriptor detected"),
    /* JADX INFO: Fake field, exist only in values array */
    NO_COLOR_MAP(106, "Neither global nor local color map found"),
    /* JADX INFO: Fake field, exist only in values array */
    WRONG_RECORD(107, "Wrong record type detected"),
    /* JADX INFO: Fake field, exist only in values array */
    DATA_TOO_BIG(108, "Number of pixels bigger than width * height"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_ENOUGH_MEM(AdEventType.AD_RENDER_SUCCESS, "Failed to allocate required memory"),
    /* JADX INFO: Fake field, exist only in values array */
    CLOSE_FAILED(110, "Failed to close given input"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_READABLE(111, "Given file was not opened for read"),
    /* JADX INFO: Fake field, exist only in values array */
    IMAGE_DEFECT(AdEventType.AD_TICK, "Image is defective, decoding aborted"),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(AdEventType.AD_ZOOM_OUT, "Image EOF detected before image complete"),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(1000, "No frames found, at least one frame required"),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(1001, "Invalid screen size, dimensions must be positive"),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(1002, "Invalid image size, dimensions must be positive"),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(1003, "Image size exceeds screen size"),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(PluginConstants.ERROR_PLUGIN_DOWNLOAD, "Input source rewind failed, animation stopped"),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(1005, "Invalid and/or indirect byte buffer specified"),
    UNKNOWN(-1, "Unknown error");


    /* renamed from: AcNBzu, reason: collision with root package name */
    public final String f7913AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f7914AlLFFp;

    static {
        fCLAu();
    }

    A2egSU(int i, String str) {
        this.f7914AlLFFp = i;
        this.f7913AcNBzu = str;
    }

    private static /* synthetic */ void fCLAu() {
        char[] charArray = "ÐÜÞ\u009dÔÒÞÖ\u009dÑÜÊ\u009dÀÛÖßß\u009dùÝÚñÁÚ×ÔÖ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 179);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÐßÚÝÚÇ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 179);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
