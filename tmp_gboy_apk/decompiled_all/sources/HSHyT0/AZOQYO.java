package HSHyT0;

import I3HV03.BPw6Q8;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AZOQYO {
    public static int A2egSU(HZUvgL.AaHO0E aaHO0E, InputStream inputStream, ArrayList arrayList) {
        if (inputStream != null) {
            if (!inputStream.markSupported()) {
                inputStream = new BPw6Q8(inputStream, aaHO0E);
            }
            inputStream.mark(AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                try {
                    int A2egSU2 = ((ADYaiT) arrayList.get(i)).A2egSU(inputStream, aaHO0E);
                    if (A2egSU2 != -1) {
                        return A2egSU2;
                    }
                } finally {
                    inputStream.reset();
                }
            }
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType A4TApA(List list, AYUAbz aYUAbz) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser$ImageType type = aYUAbz.getType((ADYaiT) list.get(i));
            if (type != ImageHeaderParser$ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static ImageHeaderParser$ImageType getType(List<ADYaiT> list, InputStream inputStream, HZUvgL.A4TApA a4TApA) {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new BPw6Q8(inputStream, a4TApA);
        }
        inputStream.mark(AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE);
        return A4TApA(list, new AMqCpz(inputStream));
    }

    public static ImageHeaderParser$ImageType getType(List<ADYaiT> list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        return A4TApA(list, new ARc23Z(byteBuffer));
    }

    public static ImageHeaderParser$ImageType getType(List<ADYaiT> list, com.bumptech.glide.load.data.AzWtSf azWtSf, HZUvgL.A4TApA a4TApA) {
        return A4TApA(list, new ASJ6gh(azWtSf, a4TApA));
    }
}
