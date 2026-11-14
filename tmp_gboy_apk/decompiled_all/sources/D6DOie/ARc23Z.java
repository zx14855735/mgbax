package D6DOie;

import ADYaiT.CtFAbx;
import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.archives.tar.e;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final boolean f1958AlLFFp = Log.isLoggable("ExifInterface", 3);

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final int[] f1959AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final int[] f1960AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final byte[] f1961B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final byte[] f1962B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final byte[] f1963B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final byte[] f1964B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final byte[] f1965B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final byte[] f1966B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final byte[] f1967BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final byte[] f1968BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final byte[] f1969BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public static final byte[] f1970BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public static final byte[] f1971BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public static final byte[] f1972BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public static final byte[] f1973BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public static final String[] f1974BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public static final int[] f1975BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public static final byte[] f1976BniPrB;
    public static final ADYaiT BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public static final ADYaiT[][] f1977C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public static final ADYaiT[] f1978C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public static final HashMap[] f1979CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public static final HashMap[] f1980CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public static final HashSet f1981COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public static final HashMap f1982CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public static final Charset f1983CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public static final byte[] f1984CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public static final byte[] f1985CcAIMM;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final FileDescriptor f1986A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AssetManager.AssetInputStream f1987A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f1988A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final HashMap[] f1989ADYaiT;
    public final HashSet AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public ByteOrder f1990ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f1991ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f1992AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f1993AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f1994AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f1995AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f1996AcNBzu;

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        f1959AmA8tU = new int[]{8, 8, 8};
        f1960AzWtSf = new int[]{8};
        f1961B25kr6 = new byte[]{-1, -40, -1};
        f1962B2KMhB = new byte[]{102, 116, 121, 112};
        f1963B3GDIM = new byte[]{109, 105, 102, e.I};
        f1964B4ZgIw = new byte[]{104, 101, 105, 99};
        f1965B7CMnp = new byte[]{79, e.P, 89, 77, 80, 0};
        f1966B9tovu = new byte[]{79, e.P, 89, 77, 80, 85, e.Q, 0, 73, 73};
        f1967BChYOn = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        f1968BI9f7h = new byte[]{101, e.S, 73, 102};
        f1969BIYEnU = new byte[]{73, 72, 68, 82};
        f1970BJ7GGh = new byte[]{73, 69, 78, 68};
        f1971BNL6CD = new byte[]{82, 73, 70, 70};
        f1972BPw6Q8 = new byte[]{87, 69, 66, 80};
        f1973BTvldC = new byte[]{69, e.S, 73, 70};
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        "XMP ".getBytes(Charset.defaultCharset());
        f1974BV3sI0 = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        f1975BmvVmW = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        f1976BniPrB = new byte[]{65, e.Q, 67, 73, 73, 0, 0, 0};
        ADYaiT[] aDYaiTArr = {new ADYaiT("NewSubfileType", MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 4), new ADYaiT("SubfileType", 255, 4), new ADYaiT("ImageWidth", 256), new ADYaiT("ImageLength", 257), new ADYaiT("BitsPerSample", MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 3), new ADYaiT("Compression", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 3), new ADYaiT("PhotometricInterpretation", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, 3), new ADYaiT("ImageDescription", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 2), new ADYaiT("Make", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new ADYaiT("Model", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 2), new ADYaiT("StripOffsets", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME), new ADYaiT("Orientation", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, 3), new ADYaiT("SamplesPerPixel", MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, 3), new ADYaiT("RowsPerStrip", MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC), new ADYaiT("StripByteCounts", MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS), new ADYaiT("XResolution", MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new ADYaiT("YResolution", MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new ADYaiT("PlanarConfiguration", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 3), new ADYaiT("ResolutionUnit", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 3), new ADYaiT("TransferFunction", 301, 3), new ADYaiT("Software", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 2), new ADYaiT("DateTime", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY, 2), new ADYaiT("Artist", MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, 2), new ADYaiT("WhitePoint", MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, 5), new ADYaiT("PrimaryChromaticities", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 5), new ADYaiT("SubIFDPointer", MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, 4), new ADYaiT("JPEGInterchangeFormat", MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_ID, 4), new ADYaiT("JPEGInterchangeFormatLength", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE, 4), new ADYaiT("YCbCrCoefficients", 529, 5), new ADYaiT("YCbCrSubSampling", MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, 3), new ADYaiT("YCbCrPositioning", MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE, 3), new ADYaiT("ReferenceBlackWhite", MediaPlayer.MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN, 5), new ADYaiT("Copyright", 33432, 2), new ADYaiT("ExifIFDPointer", 34665, 4), new ADYaiT("GPSInfoIFDPointer", 34853, 4), new ADYaiT("SensorTopBorder", 4, 4), new ADYaiT("SensorLeftBorder", 5, 4), new ADYaiT("SensorBottomBorder", 6, 4), new ADYaiT("SensorRightBorder", 7, 4), new ADYaiT("ISO", 23, 3), new ADYaiT("JpgFromRaw", 46, 7), new ADYaiT("Xmp", 700, 1)};
        ADYaiT[] aDYaiTArr2 = {new ADYaiT("ExposureTime", 33434, 5), new ADYaiT("FNumber", 33437, 5), new ADYaiT("ExposureProgram", 34850, 3), new ADYaiT("SpectralSensitivity", 34852, 2), new ADYaiT("PhotographicSensitivity", 34855, 3), new ADYaiT("OECF", 34856, 7), new ADYaiT("SensitivityType", 34864, 3), new ADYaiT("StandardOutputSensitivity", 34865, 4), new ADYaiT("RecommendedExposureIndex", 34866, 4), new ADYaiT("ISOSpeed", 34867, 4), new ADYaiT("ISOSpeedLatitudeyyy", 34868, 4), new ADYaiT("ISOSpeedLatitudezzz", 34869, 4), new ADYaiT("ExifVersion", 36864, 2), new ADYaiT("DateTimeOriginal", 36867, 2), new ADYaiT("DateTimeDigitized", 36868, 2), new ADYaiT("OffsetTime", 36880, 2), new ADYaiT("OffsetTimeOriginal", 36881, 2), new ADYaiT("OffsetTimeDigitized", 36882, 2), new ADYaiT("ComponentsConfiguration", 37121, 7), new ADYaiT("CompressedBitsPerPixel", 37122, 5), new ADYaiT("ShutterSpeedValue", 37377, 10), new ADYaiT("ApertureValue", 37378, 5), new ADYaiT("BrightnessValue", 37379, 10), new ADYaiT("ExposureBiasValue", 37380, 10), new ADYaiT("MaxApertureValue", 37381, 5), new ADYaiT("SubjectDistance", 37382, 5), new ADYaiT("MeteringMode", 37383, 3), new ADYaiT("LightSource", 37384, 3), new ADYaiT("Flash", 37385, 3), new ADYaiT("FocalLength", 37386, 5), new ADYaiT("SubjectArea", 37396, 3), new ADYaiT("MakerNote", 37500, 7), new ADYaiT("UserComment", 37510, 7), new ADYaiT("SubSecTime", 37520, 2), new ADYaiT("SubSecTimeOriginal", 37521, 2), new ADYaiT("SubSecTimeDigitized", 37522, 2), new ADYaiT("FlashpixVersion", 40960, 7), new ADYaiT("ColorSpace", 40961, 3), new ADYaiT("PixelXDimension", 40962), new ADYaiT("PixelYDimension", 40963), new ADYaiT("RelatedSoundFile", 40964, 2), new ADYaiT("InteroperabilityIFDPointer", 40965, 4), new ADYaiT("FlashEnergy", 41483, 5), new ADYaiT("SpatialFrequencyResponse", 41484, 7), new ADYaiT("FocalPlaneXResolution", 41486, 5), new ADYaiT("FocalPlaneYResolution", 41487, 5), new ADYaiT("FocalPlaneResolutionUnit", 41488, 3), new ADYaiT("SubjectLocation", 41492, 3), new ADYaiT("ExposureIndex", 41493, 5), new ADYaiT("SensingMethod", 41495, 3), new ADYaiT("FileSource", 41728, 7), new ADYaiT("SceneType", 41729, 7), new ADYaiT("CFAPattern", 41730, 7), new ADYaiT("CustomRendered", 41985, 3), new ADYaiT("ExposureMode", 41986, 3), new ADYaiT("WhiteBalance", 41987, 3), new ADYaiT("DigitalZoomRatio", 41988, 5), new ADYaiT("FocalLengthIn35mmFilm", 41989, 3), new ADYaiT("SceneCaptureType", 41990, 3), new ADYaiT("GainControl", 41991, 3), new ADYaiT("Contrast", 41992, 3), new ADYaiT("Saturation", 41993, 3), new ADYaiT("Sharpness", 41994, 3), new ADYaiT("DeviceSettingDescription", 41995, 7), new ADYaiT("SubjectDistanceRange", 41996, 3), new ADYaiT("ImageUniqueID", 42016, 2), new ADYaiT("CameraOwnerName", 42032, 2), new ADYaiT("BodySerialNumber", 42033, 2), new ADYaiT("LensSpecification", 42034, 5), new ADYaiT("LensMake", 42035, 2), new ADYaiT("LensModel", 42036, 2), new ADYaiT("Gamma", 42240, 5), new ADYaiT("DNGVersion", 50706, 1), new ADYaiT("DefaultCropSize", 50720)};
        ADYaiT[] aDYaiTArr3 = {new ADYaiT("GPSVersionID", 0, 1), new ADYaiT("GPSLatitudeRef", 1, 2), new ADYaiT("GPSLatitude", 2, 5), new ADYaiT("GPSLongitudeRef", 3, 2), new ADYaiT("GPSLongitude", 4, 5), new ADYaiT("GPSAltitudeRef", 5, 1), new ADYaiT("GPSAltitude", 6, 5), new ADYaiT("GPSTimeStamp", 7, 5), new ADYaiT("GPSSatellites", 8, 2), new ADYaiT("GPSStatus", 9, 2), new ADYaiT("GPSMeasureMode", 10, 2), new ADYaiT("GPSDOP", 11, 5), new ADYaiT("GPSSpeedRef", 12, 2), new ADYaiT("GPSSpeed", 13, 5), new ADYaiT("GPSTrackRef", 14, 2), new ADYaiT("GPSTrack", 15, 5), new ADYaiT("GPSImgDirectionRef", 16, 2), new ADYaiT("GPSImgDirection", 17, 5), new ADYaiT("GPSMapDatum", 18, 2), new ADYaiT("GPSDestLatitudeRef", 19, 2), new ADYaiT("GPSDestLatitude", 20, 5), new ADYaiT("GPSDestLongitudeRef", 21, 2), new ADYaiT("GPSDestLongitude", 22, 5), new ADYaiT("GPSDestBearingRef", 23, 2), new ADYaiT("GPSDestBearing", 24, 5), new ADYaiT("GPSDestDistanceRef", 25, 2), new ADYaiT("GPSDestDistance", 26, 5), new ADYaiT("GPSProcessingMethod", 27, 7), new ADYaiT("GPSAreaInformation", 28, 7), new ADYaiT("GPSDateStamp", 29, 2), new ADYaiT("GPSDifferential", 30, 3), new ADYaiT("GPSHPositioningError", 31, 5)};
        ADYaiT[] aDYaiTArr4 = {new ADYaiT("InteroperabilityIndex", 1, 2)};
        ADYaiT[] aDYaiTArr5 = {new ADYaiT("NewSubfileType", MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 4), new ADYaiT("SubfileType", 255, 4), new ADYaiT("ThumbnailImageWidth", 256), new ADYaiT("ThumbnailImageLength", 257), new ADYaiT("BitsPerSample", MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 3), new ADYaiT("Compression", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 3), new ADYaiT("PhotometricInterpretation", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, 3), new ADYaiT("ImageDescription", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 2), new ADYaiT("Make", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new ADYaiT("Model", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 2), new ADYaiT("StripOffsets", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME), new ADYaiT("ThumbnailOrientation", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, 3), new ADYaiT("SamplesPerPixel", MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, 3), new ADYaiT("RowsPerStrip", MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC), new ADYaiT("StripByteCounts", MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS), new ADYaiT("XResolution", MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new ADYaiT("YResolution", MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new ADYaiT("PlanarConfiguration", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 3), new ADYaiT("ResolutionUnit", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 3), new ADYaiT("TransferFunction", 301, 3), new ADYaiT("Software", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 2), new ADYaiT("DateTime", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY, 2), new ADYaiT("Artist", MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, 2), new ADYaiT("WhitePoint", MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, 5), new ADYaiT("PrimaryChromaticities", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 5), new ADYaiT("SubIFDPointer", MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, 4), new ADYaiT("JPEGInterchangeFormat", MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_ID, 4), new ADYaiT("JPEGInterchangeFormatLength", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE, 4), new ADYaiT("YCbCrCoefficients", 529, 5), new ADYaiT("YCbCrSubSampling", MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, 3), new ADYaiT("YCbCrPositioning", MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE, 3), new ADYaiT("ReferenceBlackWhite", MediaPlayer.MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN, 5), new ADYaiT("Copyright", 33432, 2), new ADYaiT("ExifIFDPointer", 34665, 4), new ADYaiT("GPSInfoIFDPointer", 34853, 4), new ADYaiT("DNGVersion", 50706, 1), new ADYaiT("DefaultCropSize", 50720)};
        BpkvW3 = new ADYaiT("StripOffsets", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME, 3);
        f1977C2rE4F = new ADYaiT[][]{aDYaiTArr, aDYaiTArr2, aDYaiTArr3, aDYaiTArr4, aDYaiTArr5, aDYaiTArr, new ADYaiT[]{new ADYaiT("ThumbnailImage", 256, 7), new ADYaiT("CameraSettingsIFDPointer", 8224, 4), new ADYaiT("ImageProcessingIFDPointer", 8256, 4)}, new ADYaiT[]{new ADYaiT("PreviewImageStart", 257, 4), new ADYaiT("PreviewImageLength", MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 4)}, new ADYaiT[]{new ADYaiT("AspectFrame", 4371, 3)}, new ADYaiT[]{new ADYaiT("ColorSpace", 55, 3)}};
        f1978C4FrIb = new ADYaiT[]{new ADYaiT("SubIFDPointer", MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, 4), new ADYaiT("ExifIFDPointer", 34665, 4), new ADYaiT("GPSInfoIFDPointer", 34853, 4), new ADYaiT("InteroperabilityIFDPointer", 40965, 4), new ADYaiT("CameraSettingsIFDPointer", 8224, 1), new ADYaiT("ImageProcessingIFDPointer", 8256, 1)};
        f1979CASmeH = new HashMap[10];
        f1980CNPG0E = new HashMap[10];
        f1981COJEAR = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f1982CQhlFr = new HashMap();
        Charset forName = Charset.forName(CharEncoding.US_ASCII);
        f1983CSDoyG = forName;
        f1984CTkVKb = "Exif\u0000\u0000".getBytes(forName);
        f1985CcAIMM = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            ADYaiT[][] aDYaiTArr6 = f1977C2rE4F;
            if (i >= aDYaiTArr6.length) {
                HashMap hashMap = f1982CQhlFr;
                ADYaiT[] aDYaiTArr7 = f1978C4FrIb;
                hashMap.put(Integer.valueOf(aDYaiTArr7[0].f1952A2egSU), 5);
                hashMap.put(Integer.valueOf(aDYaiTArr7[1].f1952A2egSU), 1);
                hashMap.put(Integer.valueOf(aDYaiTArr7[2].f1952A2egSU), 2);
                hashMap.put(Integer.valueOf(aDYaiTArr7[3].f1952A2egSU), 3);
                hashMap.put(Integer.valueOf(aDYaiTArr7[4].f1952A2egSU), 7);
                hashMap.put(Integer.valueOf(aDYaiTArr7[5].f1952A2egSU), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            f1979CASmeH[i] = new HashMap();
            f1980CNPG0E[i] = new HashMap();
            for (ADYaiT aDYaiT : aDYaiTArr6[i]) {
                f1979CASmeH[i].put(Integer.valueOf(aDYaiT.f1952A2egSU), aDYaiT);
                f1980CNPG0E[i].put(aDYaiT.f1953A4TApA, aDYaiT);
            }
            i++;
        }
    }

    public ARc23Z(InputStream inputStream) {
        ADYaiT[][] aDYaiTArr = f1977C2rE4F;
        this.f1989ADYaiT = new HashMap[aDYaiTArr.length];
        this.AMqCpz = new HashSet(aDYaiTArr.length);
        this.f1990ARc23Z = ByteOrder.BIG_ENDIAN;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f1987A4TApA = (AssetManager.AssetInputStream) inputStream;
            this.f1986A2egSU = null;
        } else {
            if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                try {
                    Os.lseek(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                    this.f1987A4TApA = null;
                    this.f1986A2egSU = fileInputStream.getFD();
                } catch (Exception unused) {
                }
            }
            this.f1987A4TApA = null;
            this.f1986A2egSU = null;
        }
        boolean z = f1958AlLFFp;
        for (int i = 0; i < aDYaiTArr.length; i++) {
            try {
                this.f1989ADYaiT[i] = new HashMap();
            } catch (IOException unused2) {
                A2egSU();
                if (!z) {
                    return;
                }
            } catch (Throwable th) {
                A2egSU();
                if (z) {
                    B3GDIM();
                }
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.f1988A5SV6n = AYUAbz(bufferedInputStream);
        A4TApA a4TApA = new A4TApA(bufferedInputStream);
        switch (this.f1988A5SV6n) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                AcNBzu(a4TApA);
                break;
            case 4:
                ASJ6gh(a4TApA, 0, 0);
                break;
            case 7:
                AZOQYO(a4TApA);
                break;
            case 9:
                AaHO0E(a4TApA);
                break;
            case 10:
                AlLFFp(a4TApA);
                break;
            case 12:
                ARc23Z(a4TApA);
                break;
            case 13:
                AZkASS(a4TApA);
                break;
            case 14:
                AmA8tU(a4TApA);
                break;
        }
        BChYOn(a4TApA);
        A2egSU();
        if (!z) {
            return;
        }
        B3GDIM();
    }

    public static String A4TApA(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] A5SV6n(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    public static ByteOrder B4ZgIw(A4TApA a4TApA) {
        short readShort = a4TApA.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException(CtFAbx.AzWtSf(new StringBuilder("Invalid byte order: "), readShort));
    }

    public final void A2egSU() {
        String ADYaiT2 = ADYaiT("DateTimeOriginal");
        HashMap[] hashMapArr = this.f1989ADYaiT;
        if (ADYaiT2 != null && ADYaiT("DateTime") == null) {
            HashMap hashMap = hashMapArr[0];
            byte[] bytes = ADYaiT2.concat("\u0000").getBytes(f1983CSDoyG);
            hashMap.put("DateTime", new A5SV6n(2, bytes.length, bytes, 0));
        }
        if (ADYaiT("ImageWidth") == null) {
            hashMapArr[0].put("ImageWidth", A5SV6n.A2egSU(0L, this.f1990ARc23Z));
        }
        if (ADYaiT("ImageLength") == null) {
            hashMapArr[0].put("ImageLength", A5SV6n.A2egSU(0L, this.f1990ARc23Z));
        }
        if (ADYaiT("Orientation") == null) {
            hashMapArr[0].put("Orientation", A5SV6n.A2egSU(0L, this.f1990ARc23Z));
        }
        if (ADYaiT("LightSource") == null) {
            hashMapArr[1].put("LightSource", A5SV6n.A2egSU(0L, this.f1990ARc23Z));
        }
    }

    public final String ADYaiT(String str) {
        A5SV6n AMqCpz = AMqCpz(str);
        if (AMqCpz != null) {
            if (!f1981COJEAR.contains(str)) {
                return AMqCpz.ARc23Z(this.f1990ARc23Z);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = AMqCpz.f1949A2egSU;
                if (i == 5 || i == 10) {
                    AMqCpz[] aMqCpzArr = (AMqCpz[]) AMqCpz.ASJ6gh(this.f1990ARc23Z);
                    if (aMqCpzArr == null || aMqCpzArr.length != 3) {
                        Arrays.toString(aMqCpzArr);
                        return null;
                    }
                    AMqCpz aMqCpz = aMqCpzArr[0];
                    Integer valueOf = Integer.valueOf((int) (aMqCpz.f1956A2egSU / aMqCpz.f1957A4TApA));
                    AMqCpz aMqCpz2 = aMqCpzArr[1];
                    Integer valueOf2 = Integer.valueOf((int) (aMqCpz2.f1956A2egSU / aMqCpz2.f1957A4TApA));
                    AMqCpz aMqCpz3 = aMqCpzArr[2];
                    return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (aMqCpz3.f1956A2egSU / aMqCpz3.f1957A4TApA)));
                }
            } else {
                try {
                    return Double.toString(AMqCpz.ADYaiT(this.f1990ARc23Z));
                } catch (NumberFormatException unused) {
                }
            }
        }
        return null;
    }

    public final A5SV6n AMqCpz(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < f1977C2rE4F.length; i++) {
            A5SV6n a5SV6n = (A5SV6n) this.f1989ADYaiT[i].get(str);
            if (a5SV6n != null) {
                return a5SV6n;
            }
        }
        return null;
    }

    public final void ARc23Z(A4TApA a4TApA) {
        String str;
        String str2;
        String str3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                mediaMetadataRetriever.setDataSource(new A2egSU(a4TApA));
            } else {
                FileDescriptor fileDescriptor = this.f1986A2egSU;
                if (fileDescriptor == null) {
                    mediaMetadataRetriever.release();
                    return;
                }
                mediaMetadataRetriever.setDataSource(fileDescriptor);
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            if ("yes".equals(extractMetadata3)) {
                str = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str3 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str3 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            HashMap[] hashMapArr = this.f1989ADYaiT;
            if (str != null) {
                hashMapArr[0].put("ImageWidth", A5SV6n.A5SV6n(Integer.parseInt(str), this.f1990ARc23Z));
            }
            if (str2 != null) {
                hashMapArr[0].put("ImageLength", A5SV6n.A5SV6n(Integer.parseInt(str2), this.f1990ARc23Z));
            }
            if (str3 != null) {
                int parseInt = Integer.parseInt(str3);
                hashMapArr[0].put("Orientation", A5SV6n.A5SV6n(parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? 1 : 8 : 3 : 6, this.f1990ARc23Z));
            }
            if (extractMetadata != null && extractMetadata2 != null) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 <= 6) {
                    throw new IOException("Invalid exif length");
                }
                a4TApA.seek(parseInt2);
                byte[] bArr = new byte[6];
                if (a4TApA.read(bArr) != 6) {
                    throw new IOException("Can't read identifier");
                }
                int i = parseInt2 + 6;
                int i2 = parseInt3 - 6;
                if (!Arrays.equals(bArr, f1984CTkVKb)) {
                    throw new IOException("Invalid identifier");
                }
                byte[] bArr2 = new byte[i2];
                if (a4TApA.read(bArr2) != i2) {
                    throw new IOException("Can't read exif");
                }
                this.f1992AYUAbz = i;
                B7CMnp(bArr2, 0);
            }
            mediaMetadataRetriever.release();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x015c, code lost:
    
        r17.f1946AlLFFp = r16.f1990ARc23Z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0160, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ASJ6gh(D6DOie.A4TApA r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D6DOie.ARc23Z.ASJ6gh(D6DOie.A4TApA, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x00b9, code lost:
    
        if (r6 == null) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0154, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int AYUAbz(java.io.BufferedInputStream r19) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D6DOie.ARc23Z.AYUAbz(java.io.BufferedInputStream):int");
    }

    public final void AZOQYO(A4TApA a4TApA) {
        int i;
        int i2;
        AcNBzu(a4TApA);
        HashMap[] hashMapArr = this.f1989ADYaiT;
        A5SV6n a5SV6n = (A5SV6n) hashMapArr[1].get("MakerNote");
        if (a5SV6n != null) {
            A4TApA a4TApA2 = new A4TApA(a5SV6n.f1951A5SV6n);
            a4TApA2.f1946AlLFFp = this.f1990ARc23Z;
            byte[] bArr = f1965B7CMnp;
            byte[] bArr2 = new byte[bArr.length];
            a4TApA2.readFully(bArr2);
            a4TApA2.seek(0L);
            byte[] bArr3 = f1966B9tovu;
            byte[] bArr4 = new byte[bArr3.length];
            a4TApA2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                a4TApA2.seek(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                a4TApA2.seek(12L);
            }
            B9tovu(a4TApA2, 6);
            A5SV6n a5SV6n2 = (A5SV6n) hashMapArr[7].get("PreviewImageStart");
            A5SV6n a5SV6n3 = (A5SV6n) hashMapArr[7].get("PreviewImageLength");
            if (a5SV6n2 != null && a5SV6n3 != null) {
                hashMapArr[5].put("JPEGInterchangeFormat", a5SV6n2);
                hashMapArr[5].put("JPEGInterchangeFormatLength", a5SV6n3);
            }
            A5SV6n a5SV6n4 = (A5SV6n) hashMapArr[8].get("AspectFrame");
            if (a5SV6n4 != null) {
                int[] iArr = (int[]) a5SV6n4.ASJ6gh(this.f1990ARc23Z);
                if (iArr == null || iArr.length != 4) {
                    Arrays.toString(iArr);
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                A5SV6n A5SV6n2 = A5SV6n.A5SV6n(i5, this.f1990ARc23Z);
                A5SV6n A5SV6n3 = A5SV6n.A5SV6n(i6, this.f1990ARc23Z);
                hashMapArr[0].put("ImageWidth", A5SV6n2);
                hashMapArr[0].put("ImageLength", A5SV6n3);
            }
        }
    }

    public final void AZkASS(A4TApA a4TApA) {
        if (f1958AlLFFp) {
            Objects.toString(a4TApA);
        }
        a4TApA.f1946AlLFFp = ByteOrder.BIG_ENDIAN;
        byte[] bArr = f1967BChYOn;
        a4TApA.skipBytes(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = a4TApA.readInt();
                byte[] bArr2 = new byte[4];
                if (a4TApA.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i = length + 8;
                if (i == 16 && !Arrays.equals(bArr2, f1969BIYEnU)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f1970BJ7GGh)) {
                    return;
                }
                if (Arrays.equals(bArr2, f1968BI9f7h)) {
                    byte[] bArr3 = new byte[readInt];
                    if (a4TApA.read(bArr3) != readInt) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + A4TApA(bArr2));
                    }
                    int readInt2 = a4TApA.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.f1992AYUAbz = i;
                        B7CMnp(bArr3, 0);
                        BJ7GGh();
                        return;
                    } else {
                        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                    }
                }
                int i2 = readInt + 4;
                a4TApA.skipBytes(i2);
                length = i + i2;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void AaHO0E(A4TApA a4TApA) {
        a4TApA.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        a4TApA.read(bArr);
        a4TApA.skipBytes(4);
        a4TApA.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        ASJ6gh(a4TApA, i, 5);
        a4TApA.seek(i2);
        a4TApA.f1946AlLFFp = ByteOrder.BIG_ENDIAN;
        int readInt = a4TApA.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = a4TApA.readUnsignedShort();
            int readUnsignedShort2 = a4TApA.readUnsignedShort();
            if (readUnsignedShort == BpkvW3.f1952A2egSU) {
                short readShort = a4TApA.readShort();
                short readShort2 = a4TApA.readShort();
                A5SV6n A5SV6n2 = A5SV6n.A5SV6n(readShort, this.f1990ARc23Z);
                A5SV6n A5SV6n3 = A5SV6n.A5SV6n(readShort2, this.f1990ARc23Z);
                HashMap[] hashMapArr = this.f1989ADYaiT;
                hashMapArr[0].put("ImageLength", A5SV6n2);
                hashMapArr[0].put("ImageWidth", A5SV6n3);
                return;
            }
            a4TApA.skipBytes(readUnsignedShort2);
        }
    }

    public final void AcNBzu(A4TApA a4TApA) {
        B2KMhB(a4TApA, a4TApA.f1945AcNBzu.available());
        B9tovu(a4TApA, 0);
        BIYEnU(a4TApA, 0);
        BIYEnU(a4TApA, 5);
        BIYEnU(a4TApA, 4);
        BJ7GGh();
        if (this.f1988A5SV6n == 8) {
            HashMap[] hashMapArr = this.f1989ADYaiT;
            A5SV6n a5SV6n = (A5SV6n) hashMapArr[1].get("MakerNote");
            if (a5SV6n != null) {
                A4TApA a4TApA2 = new A4TApA(a5SV6n.f1951A5SV6n);
                a4TApA2.f1946AlLFFp = this.f1990ARc23Z;
                a4TApA2.seek(6L);
                B9tovu(a4TApA2, 9);
                A5SV6n a5SV6n2 = (A5SV6n) hashMapArr[9].get("ColorSpace");
                if (a5SV6n2 != null) {
                    hashMapArr[1].put("ColorSpace", a5SV6n2);
                }
            }
        }
    }

    public final void AlLFFp(A4TApA a4TApA) {
        AcNBzu(a4TApA);
        HashMap[] hashMapArr = this.f1989ADYaiT;
        if (((A5SV6n) hashMapArr[0].get("JpgFromRaw")) != null) {
            ASJ6gh(a4TApA, this.f1996AcNBzu, 5);
        }
        A5SV6n a5SV6n = (A5SV6n) hashMapArr[0].get("ISO");
        A5SV6n a5SV6n2 = (A5SV6n) hashMapArr[1].get("PhotographicSensitivity");
        if (a5SV6n == null || a5SV6n2 != null) {
            return;
        }
        hashMapArr[1].put("PhotographicSensitivity", a5SV6n);
    }

    public final void AmA8tU(A4TApA a4TApA) {
        if (f1958AlLFFp) {
            Objects.toString(a4TApA);
        }
        a4TApA.f1946AlLFFp = ByteOrder.LITTLE_ENDIAN;
        a4TApA.skipBytes(f1971BNL6CD.length);
        int readInt = a4TApA.readInt() + 8;
        int skipBytes = a4TApA.skipBytes(f1972BPw6Q8.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (a4TApA.read(bArr) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = a4TApA.readInt();
                int i = skipBytes + 8;
                if (Arrays.equals(f1973BTvldC, bArr)) {
                    byte[] bArr2 = new byte[readInt2];
                    if (a4TApA.read(bArr2) == readInt2) {
                        this.f1992AYUAbz = i;
                        B7CMnp(bArr2, 0);
                        this.f1992AYUAbz = i;
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + A4TApA(bArr));
                    }
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                int i2 = i + readInt2;
                if (i2 == readInt) {
                    return;
                }
                if (i2 > readInt) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                int skipBytes2 = a4TApA.skipBytes(readInt2);
                if (skipBytes2 != readInt2) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                skipBytes = i + skipBytes2;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void AzWtSf(A4TApA a4TApA, HashMap hashMap) {
        A5SV6n a5SV6n = (A5SV6n) hashMap.get("JPEGInterchangeFormat");
        A5SV6n a5SV6n2 = (A5SV6n) hashMap.get("JPEGInterchangeFormatLength");
        if (a5SV6n == null || a5SV6n2 == null) {
            return;
        }
        int AMqCpz = a5SV6n.AMqCpz(this.f1990ARc23Z);
        int AMqCpz2 = a5SV6n2.AMqCpz(this.f1990ARc23Z);
        if (this.f1988A5SV6n == 7) {
            AMqCpz += this.f1993AZOQYO;
        }
        int min = Math.min(AMqCpz2, a4TApA.f1947AmA8tU - AMqCpz);
        if (AMqCpz <= 0 || min <= 0) {
            return;
        }
        int i = AMqCpz + this.f1992AYUAbz;
        if (this.f1987A4TApA == null && this.f1986A2egSU == null) {
            a4TApA.seek(i);
            a4TApA.readFully(new byte[min]);
        }
    }

    public final boolean B25kr6(HashMap hashMap) {
        A5SV6n a5SV6n = (A5SV6n) hashMap.get("ImageLength");
        A5SV6n a5SV6n2 = (A5SV6n) hashMap.get("ImageWidth");
        if (a5SV6n == null || a5SV6n2 == null) {
            return false;
        }
        return a5SV6n.AMqCpz(this.f1990ARc23Z) <= 512 && a5SV6n2.AMqCpz(this.f1990ARc23Z) <= 512;
    }

    public final void B2KMhB(A4TApA a4TApA, int i) {
        ByteOrder B4ZgIw2 = B4ZgIw(a4TApA);
        this.f1990ARc23Z = B4ZgIw2;
        a4TApA.f1946AlLFFp = B4ZgIw2;
        int readUnsignedShort = a4TApA.readUnsignedShort();
        int i2 = this.f1988A5SV6n;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            throw new IOException(CtFAbx.AzWtSf(new StringBuilder("Invalid start code: "), readUnsignedShort));
        }
        int readInt = a4TApA.readInt();
        if (readInt < 8 || readInt >= i) {
            throw new IOException(CtFAbx.ARc23Z(readInt, "Invalid first Ifd offset: "));
        }
        int i3 = readInt - 8;
        if (i3 > 0 && a4TApA.skipBytes(i3) != i3) {
            throw new IOException(CtFAbx.ARc23Z(i3, "Couldn't jump to first Ifd: "));
        }
    }

    public final void B3GDIM() {
        int i = 0;
        while (true) {
            HashMap[] hashMapArr = this.f1989ADYaiT;
            if (i >= hashMapArr.length) {
                return;
            }
            hashMapArr[i].size();
            for (Map.Entry entry : hashMapArr[i].entrySet()) {
                A5SV6n a5SV6n = (A5SV6n) entry.getValue();
                a5SV6n.toString();
                a5SV6n.ARc23Z(this.f1990ARc23Z);
            }
            i++;
        }
    }

    public final void B7CMnp(byte[] bArr, int i) {
        A4TApA a4TApA = new A4TApA(bArr);
        B2KMhB(a4TApA, bArr.length);
        B9tovu(a4TApA, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B9tovu(D6DOie.A4TApA r36, int r37) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D6DOie.ARc23Z.B9tovu(D6DOie.A4TApA, int):void");
    }

    public final void BChYOn(A4TApA a4TApA) {
        A5SV6n a5SV6n;
        HashMap hashMap = this.f1989ADYaiT[4];
        A5SV6n a5SV6n2 = (A5SV6n) hashMap.get("Compression");
        if (a5SV6n2 == null) {
            AzWtSf(a4TApA, hashMap);
            return;
        }
        int AMqCpz = a5SV6n2.AMqCpz(this.f1990ARc23Z);
        if (AMqCpz != 1) {
            if (AMqCpz == 6) {
                AzWtSf(a4TApA, hashMap);
                return;
            } else if (AMqCpz != 7) {
                return;
            }
        }
        A5SV6n a5SV6n3 = (A5SV6n) hashMap.get("BitsPerSample");
        if (a5SV6n3 != null) {
            int[] iArr = (int[]) a5SV6n3.ASJ6gh(this.f1990ARc23Z);
            int[] iArr2 = f1959AmA8tU;
            if (!Arrays.equals(iArr2, iArr)) {
                if (this.f1988A5SV6n != 3 || (a5SV6n = (A5SV6n) hashMap.get("PhotometricInterpretation")) == null) {
                    return;
                }
                int AMqCpz2 = a5SV6n.AMqCpz(this.f1990ARc23Z);
                if ((AMqCpz2 != 1 || !Arrays.equals(iArr, f1960AzWtSf)) && (AMqCpz2 != 6 || !Arrays.equals(iArr, iArr2))) {
                    return;
                }
            }
            A5SV6n a5SV6n4 = (A5SV6n) hashMap.get("StripOffsets");
            A5SV6n a5SV6n5 = (A5SV6n) hashMap.get("StripByteCounts");
            if (a5SV6n4 == null || a5SV6n5 == null) {
                return;
            }
            long[] A5SV6n2 = A5SV6n(a5SV6n4.ASJ6gh(this.f1990ARc23Z));
            long[] A5SV6n3 = A5SV6n(a5SV6n5.ASJ6gh(this.f1990ARc23Z));
            if (A5SV6n2 == null || A5SV6n2.length == 0 || A5SV6n3 == null || A5SV6n3.length == 0 || A5SV6n2.length != A5SV6n3.length) {
                return;
            }
            long j = 0;
            for (long j2 : A5SV6n3) {
                j += j2;
            }
            byte[] bArr = new byte[(int) j];
            this.f1991ASJ6gh = true;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < A5SV6n2.length; i3++) {
                int i4 = (int) A5SV6n2[i3];
                int i5 = (int) A5SV6n3[i3];
                if (i3 < A5SV6n2.length - 1 && i4 + i5 != A5SV6n2[i3 + 1]) {
                    this.f1991ASJ6gh = false;
                }
                int i6 = i4 - i;
                a4TApA.seek(i6);
                int i7 = i + i6;
                byte[] bArr2 = new byte[i5];
                a4TApA.read(bArr2);
                i = i7 + i5;
                System.arraycopy(bArr2, 0, bArr, i2, i5);
                i2 += i5;
            }
            if (this.f1991ASJ6gh) {
                long j3 = A5SV6n2[0];
            }
        }
    }

    public final void BI9f7h(int i, int i2) {
        HashMap[] hashMapArr = this.f1989ADYaiT;
        if (hashMapArr[i].isEmpty() || hashMapArr[i2].isEmpty()) {
            return;
        }
        A5SV6n a5SV6n = (A5SV6n) hashMapArr[i].get("ImageLength");
        A5SV6n a5SV6n2 = (A5SV6n) hashMapArr[i].get("ImageWidth");
        A5SV6n a5SV6n3 = (A5SV6n) hashMapArr[i2].get("ImageLength");
        A5SV6n a5SV6n4 = (A5SV6n) hashMapArr[i2].get("ImageWidth");
        if (a5SV6n == null || a5SV6n2 == null || a5SV6n3 == null || a5SV6n4 == null) {
            return;
        }
        int AMqCpz = a5SV6n.AMqCpz(this.f1990ARc23Z);
        int AMqCpz2 = a5SV6n2.AMqCpz(this.f1990ARc23Z);
        int AMqCpz3 = a5SV6n3.AMqCpz(this.f1990ARc23Z);
        int AMqCpz4 = a5SV6n4.AMqCpz(this.f1990ARc23Z);
        if (AMqCpz >= AMqCpz3 || AMqCpz2 >= AMqCpz4) {
            return;
        }
        HashMap hashMap = hashMapArr[i];
        hashMapArr[i] = hashMapArr[i2];
        hashMapArr[i2] = hashMap;
    }

    public final void BIYEnU(A4TApA a4TApA, int i) {
        A5SV6n a5SV6n;
        A5SV6n A5SV6n2;
        A5SV6n A5SV6n3;
        HashMap[] hashMapArr = this.f1989ADYaiT;
        A5SV6n a5SV6n2 = (A5SV6n) hashMapArr[i].get("DefaultCropSize");
        A5SV6n a5SV6n3 = (A5SV6n) hashMapArr[i].get("SensorTopBorder");
        A5SV6n a5SV6n4 = (A5SV6n) hashMapArr[i].get("SensorLeftBorder");
        A5SV6n a5SV6n5 = (A5SV6n) hashMapArr[i].get("SensorBottomBorder");
        A5SV6n a5SV6n6 = (A5SV6n) hashMapArr[i].get("SensorRightBorder");
        if (a5SV6n2 != null) {
            if (a5SV6n2.f1949A2egSU == 5) {
                AMqCpz[] aMqCpzArr = (AMqCpz[]) a5SV6n2.ASJ6gh(this.f1990ARc23Z);
                if (aMqCpzArr == null || aMqCpzArr.length != 2) {
                    Arrays.toString(aMqCpzArr);
                    return;
                } else {
                    A5SV6n2 = A5SV6n.A4TApA(aMqCpzArr[0], this.f1990ARc23Z);
                    A5SV6n3 = A5SV6n.A4TApA(aMqCpzArr[1], this.f1990ARc23Z);
                }
            } else {
                int[] iArr = (int[]) a5SV6n2.ASJ6gh(this.f1990ARc23Z);
                if (iArr == null || iArr.length != 2) {
                    Arrays.toString(iArr);
                    return;
                } else {
                    A5SV6n2 = A5SV6n.A5SV6n(iArr[0], this.f1990ARc23Z);
                    A5SV6n3 = A5SV6n.A5SV6n(iArr[1], this.f1990ARc23Z);
                }
            }
            hashMapArr[i].put("ImageWidth", A5SV6n2);
            hashMapArr[i].put("ImageLength", A5SV6n3);
            return;
        }
        if (a5SV6n3 == null || a5SV6n4 == null || a5SV6n5 == null || a5SV6n6 == null) {
            A5SV6n a5SV6n7 = (A5SV6n) hashMapArr[i].get("ImageLength");
            A5SV6n a5SV6n8 = (A5SV6n) hashMapArr[i].get("ImageWidth");
            if ((a5SV6n7 == null || a5SV6n8 == null) && (a5SV6n = (A5SV6n) hashMapArr[i].get("JPEGInterchangeFormat")) != null) {
                ASJ6gh(a4TApA, a5SV6n.AMqCpz(this.f1990ARc23Z), i);
                return;
            }
            return;
        }
        int AMqCpz = a5SV6n3.AMqCpz(this.f1990ARc23Z);
        int AMqCpz2 = a5SV6n5.AMqCpz(this.f1990ARc23Z);
        int AMqCpz3 = a5SV6n6.AMqCpz(this.f1990ARc23Z);
        int AMqCpz4 = a5SV6n4.AMqCpz(this.f1990ARc23Z);
        if (AMqCpz2 <= AMqCpz || AMqCpz3 <= AMqCpz4) {
            return;
        }
        A5SV6n A5SV6n4 = A5SV6n.A5SV6n(AMqCpz2 - AMqCpz, this.f1990ARc23Z);
        A5SV6n A5SV6n5 = A5SV6n.A5SV6n(AMqCpz3 - AMqCpz4, this.f1990ARc23Z);
        hashMapArr[i].put("ImageLength", A5SV6n4);
        hashMapArr[i].put("ImageWidth", A5SV6n5);
    }

    public final void BJ7GGh() {
        BI9f7h(0, 5);
        BI9f7h(0, 4);
        BI9f7h(5, 4);
        HashMap[] hashMapArr = this.f1989ADYaiT;
        A5SV6n a5SV6n = (A5SV6n) hashMapArr[1].get("PixelXDimension");
        A5SV6n a5SV6n2 = (A5SV6n) hashMapArr[1].get("PixelYDimension");
        if (a5SV6n != null && a5SV6n2 != null) {
            hashMapArr[0].put("ImageWidth", a5SV6n);
            hashMapArr[0].put("ImageLength", a5SV6n2);
        }
        if (hashMapArr[4].isEmpty() && B25kr6(hashMapArr[5])) {
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        B25kr6(hashMapArr[4]);
    }
}
