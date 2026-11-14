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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {

    public static class hf {
        public final List<Integer> hf;
        public final List<X509Certificate> xj;

        public hf(List<X509Certificate> list, List<Integer> list2) {
            this.xj = list;
            this.hf = list2;
        }
    }

    /* renamed from: com.bytedance.pangle.f.w$w, reason: collision with other inner class name */
    public static class C0088w {
        public final hf hf;
        public byte[] w;
        public final X509Certificate[] xj;

        public C0088w(X509Certificate[] x509CertificateArr, hf hfVar) {
            this.xj = x509CertificateArr;
            this.hf = hfVar;
        }
    }

    public static class xj extends Exception {
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

    public static C0088w xj(RandomAccessFile randomAccessFile, String str) {
        g gVar = y.xj.get(str).get(-262969152);
        if (gVar != null) {
            return xj(randomAccessFile, gVar, true);
        }
        throw new am("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
    }

    private static C0088w xj(RandomAccessFile randomAccessFile, g gVar, boolean z) {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer xj2 = y.xj(gVar.xj);
                int i = 0;
                C0088w c0088w = null;
                while (xj2.hasRemaining()) {
                    try {
                        c0088w = xj(y.xj(xj2), arrayMap, certificateFactory);
                        i++;
                    } catch (xj unused) {
                    } catch (IOException e) {
                        e = e;
                        throw new SecurityException(CtFAbx.ASJ6gh(i, "Failed to parse/verify signer #", " block"), e);
                    } catch (SecurityException e2) {
                        e = e2;
                        throw new SecurityException(CtFAbx.ASJ6gh(i, "Failed to parse/verify signer #", " block"), e);
                    } catch (BufferUnderflowException e3) {
                        e = e3;
                        throw new SecurityException(CtFAbx.ASJ6gh(i, "Failed to parse/verify signer #", " block"), e);
                    }
                }
                if (i <= 0 || c0088w == null) {
                    throw new SecurityException("No signers found");
                }
                if (i == 1) {
                    if (!arrayMap.isEmpty()) {
                        if (z) {
                            y.xj(arrayMap, randomAccessFile, gVar);
                        }
                        if (arrayMap.containsKey(3)) {
                            c0088w.w = y.xj((byte[]) arrayMap.get(3), randomAccessFile.length(), gVar);
                        }
                        return c0088w;
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    private static C0088w xj(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        ByteBuffer xj2 = y.xj(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer xj3 = y.xj(byteBuffer);
        byte[] hf2 = y.hf(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i3 = -1;
        int i4 = 0;
        while (xj3.hasRemaining()) {
            i4++;
            try {
                ByteBuffer xj4 = y.xj(xj3);
                if (xj4.remaining() >= 8) {
                    int i5 = xj4.getInt();
                    arrayList.add(Integer.valueOf(i5));
                    if (xj(i5)) {
                        if (i3 != -1 && y.xj(i5, i3) <= 0) {
                        }
                        bArr2 = y.hf(xj4);
                        i3 = i5;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException e) {
                e = e;
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i4)), e);
            } catch (BufferUnderflowException e2) {
                e = e2;
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i4)), e);
            }
        }
        if (i3 == -1) {
            if (i4 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String w = y.w(i3);
        Pair<String, ? extends AlgorithmParameterSpec> u = y.u(i3);
        String str = (String) u.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) u.second;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(w).generatePublic(new X509EncodedKeySpec(hf2));
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
                int i6 = 0;
                while (xj5.hasRemaining()) {
                    i6++;
                    try {
                        ByteBuffer xj6 = y.xj(xj5);
                        if (xj6.remaining() >= 8) {
                            int i7 = xj6.getInt();
                            arrayList2.add(Integer.valueOf(i7));
                            if (i7 == i3) {
                                bArr = y.hf(xj6);
                            }
                        } else {
                            throw new IOException("Record too short");
                        }
                    } catch (IOException e3) {
                        e = e3;
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e);
                    } catch (BufferUnderflowException e4) {
                        e = e4;
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    int xj7 = y.xj(i3);
                    byte[] put = map.put(Integer.valueOf(xj7), bArr);
                    if (put != null && !MessageDigest.isEqual(put, bArr)) {
                        throw new SecurityException(CtFAbx.B25kr6(new StringBuilder(), y.hf(xj7), " contents digest does not match the digest specified by a preceding signer"));
                    }
                    ByteBuffer xj8 = y.xj(xj2);
                    ArrayList arrayList3 = new ArrayList();
                    int i8 = 0;
                    while (xj8.hasRemaining()) {
                        i8++;
                        byte[] hf3 = y.hf(xj8);
                        try {
                            arrayList3.add(new zg((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(hf3)), hf3));
                        } catch (CertificateException e5) {
                            throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e5);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (Arrays.equals(hf2, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            if (xj2.getInt() == i) {
                                if (xj2.getInt() == i2) {
                                    return xj(y.xj(xj2), arrayList3, certificateFactory);
                                }
                                throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                            }
                            throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
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

    private static C0088w xj(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        hf hfVar = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer xj2 = y.xj(byteBuffer);
            if (xj2.remaining() >= 4) {
                if (xj2.getInt() == 1000370060) {
                    if (hfVar == null) {
                        hfVar = xj(xj2, certificateFactory);
                        try {
                            if (hfVar.xj.size() > 0) {
                                if (!Arrays.equals(hfVar.xj.get(r1.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + xj2.remaining());
            }
        }
        return new C0088w(x509CertificateArr, hfVar);
    }

    private static hf xj(ByteBuffer byteBuffer, CertificateFactory certificateFactory) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            zg zgVar = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer xj2 = y.xj(byteBuffer);
                ByteBuffer xj3 = y.xj(xj2);
                int i3 = xj2.getInt();
                int i4 = xj2.getInt();
                byte[] hf2 = y.hf(xj2);
                if (zgVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> u = y.u(i2);
                    PublicKey publicKey = zgVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) u.first);
                    signature.initVerify(publicKey);
                    Object obj = u.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(xj3);
                    if (!signature.verify(hf2)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) u.first) + " when verifying Proof-of-rotation record");
                    }
                }
                xj3.rewind();
                byte[] hf3 = y.hf(xj3);
                int i5 = xj3.getInt();
                if (zgVar != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                zgVar = new zg((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(hf3)), hf3);
                if (!hashSet.contains(zgVar)) {
                    hashSet.add(zgVar);
                    arrayList.add(zgVar);
                    arrayList2.add(Integer.valueOf(i3));
                    i2 = i4;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
            }
            return new hf(arrayList, arrayList2);
        } catch (IOException | BufferUnderflowException e) {
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e2) {
            e = e2;
            throw new SecurityException(CtFAbx.ASJ6gh(0, "Failed to verify signature over signed data for certificate #", " when verifying Proof-of-rotation record"), e);
        } catch (InvalidKeyException e3) {
            e = e3;
            throw new SecurityException(CtFAbx.ASJ6gh(0, "Failed to verify signature over signed data for certificate #", " when verifying Proof-of-rotation record"), e);
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            throw new SecurityException(CtFAbx.ASJ6gh(0, "Failed to verify signature over signed data for certificate #", " when verifying Proof-of-rotation record"), e);
        } catch (SignatureException e5) {
            e = e5;
            throw new SecurityException(CtFAbx.ASJ6gh(0, "Failed to verify signature over signed data for certificate #", " when verifying Proof-of-rotation record"), e);
        } catch (CertificateException e6) {
            throw new SecurityException(CtFAbx.ASJ6gh(0, "Failed to decode certificate #", " when verifying Proof-of-rotation record"), e6);
        }
    }
}
