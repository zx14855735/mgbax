package com.bytedance.pangle.f;

import ADYaiT.CtFAbx;
import android.util.ArrayMap;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {

    public static class xj {
        public final byte[] hf;
        public final X509Certificate[][] xj;

        public xj(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.xj = x509CertificateArr;
            this.hf = bArr;
        }
    }

    private static boolean xj(int i) {
        if (i == 513 || i == 514 || i == 769 || i == 1057 || i == 1059 || i == 1061) {
            return true;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return true;
            default:
                return false;
        }
    }

    public static X509Certificate[][] xj(RandomAccessFile randomAccessFile, String str) {
        g gVar = y.xj.get(str).get(1896449818);
        if (gVar != null) {
            return xj(randomAccessFile, gVar, true).xj;
        }
        throw new am("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
    }

    private static xj xj(RandomAccessFile randomAccessFile, g gVar, boolean z) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer xj2 = y.xj(gVar.xj);
                int i = 0;
                while (xj2.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(xj(y.xj(xj2), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException(CtFAbx.ASJ6gh(i, "Failed to parse/verify signer #", " block"), e);
                    }
                }
                if (i > 0) {
                    if (!arrayMap.isEmpty()) {
                        if (z) {
                            y.xj(arrayMap, randomAccessFile, gVar);
                        }
                        return new xj((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? y.xj((byte[]) arrayMap.get(3), randomAccessFile.length(), gVar) : null);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static X509Certificate[] xj(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        ByteBuffer xj2 = y.xj(byteBuffer);
        ByteBuffer xj3 = y.xj(byteBuffer);
        byte[] hf = y.hf(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i = -1;
        int i2 = 0;
        while (xj3.hasRemaining()) {
            i2++;
            try {
                ByteBuffer xj4 = y.xj(xj3);
                if (xj4.remaining() >= 8) {
                    int i3 = xj4.getInt();
                    arrayList.add(Integer.valueOf(i3));
                    if (xj(i3)) {
                        if (i != -1 && y.xj(i3, i) <= 0) {
                        }
                        bArr2 = y.hf(xj4);
                        i = i3;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException e) {
                e = e;
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i2)), e);
            } catch (BufferUnderflowException e2) {
                e = e2;
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i2)), e);
            }
        }
        if (i == -1) {
            if (i2 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String w = y.w(i);
        Pair<String, ? extends AlgorithmParameterSpec> u = y.u(i);
        String str = (String) u.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) u.second;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(w).generatePublic(new X509EncodedKeySpec(hf));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(generatePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(xj2);
            if (signature.verify(bArr2)) {
                xj2.clear();
                ByteBuffer xj5 = y.xj(xj2);
                ArrayList arrayList2 = new ArrayList();
                int i4 = 0;
                while (xj5.hasRemaining()) {
                    i4++;
                    try {
                        ByteBuffer xj6 = y.xj(xj5);
                        if (xj6.remaining() >= 8) {
                            int i5 = xj6.getInt();
                            arrayList2.add(Integer.valueOf(i5));
                            if (i5 == i) {
                                bArr = y.hf(xj6);
                            }
                        } else {
                            throw new IOException("Record too short");
                        }
                    } catch (IOException e3) {
                        e = e3;
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e);
                    } catch (BufferUnderflowException e4) {
                        e = e4;
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    int xj7 = y.xj(i);
                    byte[] put = map.put(Integer.valueOf(xj7), bArr);
                    if (put != null && !MessageDigest.isEqual(put, bArr)) {
                        throw new SecurityException(CtFAbx.B25kr6(new StringBuilder(), y.hf(xj7), " contents digest does not match the digest specified by a preceding signer"));
                    }
                    ByteBuffer xj8 = y.xj(xj2);
                    ArrayList arrayList3 = new ArrayList();
                    int i6 = 0;
                    while (xj8.hasRemaining()) {
                        i6++;
                        byte[] hf2 = y.hf(xj8);
                        try {
                            arrayList3.add(new zg((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(hf2)), hf2));
                        } catch (CertificateException e5) {
                            throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e5);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (Arrays.equals(hf, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            xj(y.xj(xj2));
                            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                        }
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                    }
                    throw new SecurityException("No certificates listed");
                }
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            throw new SecurityException(CtFAbx.AcNBzu(str, " signature did not verify"));
        } catch (InvalidAlgorithmParameterException e6) {
            e = e6;
            throw new SecurityException(CtFAbx.BI9f7h("Failed to verify ", str, " signature"), e);
        } catch (InvalidKeyException e7) {
            e = e7;
            throw new SecurityException(CtFAbx.BI9f7h("Failed to verify ", str, " signature"), e);
        } catch (NoSuchAlgorithmException e8) {
            e = e8;
            throw new SecurityException(CtFAbx.BI9f7h("Failed to verify ", str, " signature"), e);
        } catch (SignatureException e9) {
            e = e9;
            throw new SecurityException(CtFAbx.BI9f7h("Failed to verify ", str, " signature"), e);
        } catch (InvalidKeySpecException e10) {
            e = e10;
            throw new SecurityException(CtFAbx.BI9f7h("Failed to verify ", str, " signature"), e);
        }
    }

    private static void xj(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer xj2 = y.xj(byteBuffer);
            if (xj2.remaining() >= 4) {
                if (xj2.getInt() == -1091571699) {
                    if (xj2.remaining() >= 4) {
                        if (xj2.getInt() == 3) {
                            throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                        }
                    } else {
                        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + xj2.remaining());
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + xj2.remaining());
            }
        }
    }
}
