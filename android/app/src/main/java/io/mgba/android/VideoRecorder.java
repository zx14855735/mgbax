/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * MP4 recorder: MediaCodec (H.264 + AAC) into MediaMuxer, the Android
 * counterpart of PC's FFmpeg VideoView. Frames come straight from the core's
 * RGB bitmap, audio from the same PCM the AudioTrack is fed, so no extra
 * capture path or root/permission is involved.
 *
 * <p>Everything runs on the emulation thread (the caller's thread); methods are
 * synchronized so a stop from the UI thread cannot interleave with a queue.</p>
 */
final class VideoRecorder {
    private static final String TAG = "mGBAxRec";
    private static final String MIME_VIDEO = "video/avc";
    private static final String MIME_AUDIO = "audio/mp4a-latm";
    private static final int IFRAME_SECONDS = 1;
    private static final long DEQUEUE_TIMEOUT_US = 0L;

    private final Context context;
    private final int width;
    private final int height;
    private final int fps;
    private final int audioRate;
    private final File output;

    private MediaCodec videoEncoder;
    private MediaCodec audioEncoder;
    private MediaMuxer muxer;
    private int videoTrack = -1;
    private int audioTrack = -1;
    private MediaFormat videoFormat;
    private MediaFormat audioFormat;
    private boolean muxerStarted;
    private boolean audioEnabled;
    private boolean failed;
    private boolean stopped;
    private String failure;
    private long videoFrames;
    private long audioSamples;
    private int[] argb;
    private final MediaCodec.BufferInfo videoInfo = new MediaCodec.BufferInfo();
    private final MediaCodec.BufferInfo audioInfo = new MediaCodec.BufferInfo();

    private VideoRecorder(Context context, int width, int height, int fps, int audioRate, File output) {
        this.context = context;
        this.width = width;
        this.height = height;
        this.fps = fps;
        this.audioRate = audioRate;
        this.output = output;
    }

    /** Null when the encoder could not be created; {@link #failure()} then says why. */
    static VideoRecorder start(Context context, int width, int height, int fps,
                               int audioRate, File output) {
        VideoRecorder recorder = new VideoRecorder(context, width, height, fps, audioRate, output);
        return recorder.init() ? recorder : null;
    }

    private boolean init() {
        try {
            videoEncoder = MediaCodec.createEncoderByType(MIME_VIDEO);
            MediaFormat format = MediaFormat.createVideoFormat(MIME_VIDEO, width, height);
            format.setInteger(MediaFormat.KEY_COLOR_FORMAT,
                    MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Flexible);
            // ~1.5 bit per pixel per second is plenty for 240x160 pixels and
            // keeps the file small enough to share.
            format.setInteger(MediaFormat.KEY_BIT_RATE, Math.max(600_000, width * height * 12));
            format.setInteger(MediaFormat.KEY_FRAME_RATE, fps);
            format.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, IFRAME_SECONDS);
            videoEncoder.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
            videoEncoder.start();
        } catch (Exception e) {
            Log.w(TAG, "video encoder unavailable: " + e);
            failure = e.toString();
            release();
            return false;
        }
        try {
            audioEncoder = MediaCodec.createEncoderByType(MIME_AUDIO);
            MediaFormat format = MediaFormat.createAudioFormat(MIME_AUDIO, audioRate, 2);
            format.setInteger(MediaFormat.KEY_AAC_PROFILE,
                    MediaCodecInfo.CodecProfileLevel.AACObjectLC);
            format.setInteger(MediaFormat.KEY_BIT_RATE, 128_000);
            format.setInteger(MediaFormat.KEY_MAX_INPUT_SIZE, 16384);
            audioEncoder.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
            audioEncoder.start();
            audioEnabled = true;
        } catch (Exception e) {
            // Video-only recording is still useful.
            Log.w(TAG, "audio encoder unavailable, recording video only: " + e);
            audioEncoder = null;
            audioEnabled = false;
        }
        try {
            muxer = new MediaMuxer(output.getAbsolutePath(),
                    MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4);
        } catch (Exception e) {
            Log.w(TAG, "muxer unavailable: " + e);
            failure = e.toString();
            release();
            return false;
        }
        return true;
    }

    /** Why recording failed, or "" when it is healthy. */
    String failure() {
        return failure == null ? "" : failure;
    }

    File output() {
        return output;
    }

    synchronized void pushVideoFrame(Bitmap frame) {
        if (stopped || failed || videoEncoder == null || frame == null) {
            return;
        }
        try {
            int inIndex = videoEncoder.dequeueInputBuffer(DEQUEUE_TIMEOUT_US);
            if (inIndex < 0) {
                return;      // encoder still busy: drop this frame
            }
            Image image = videoEncoder.getInputImage(inIndex);
            ByteBuffer input = videoEncoder.getInputBuffer(inIndex);
            if (image == null || input == null) {
                videoEncoder.queueInputBuffer(inIndex, 0, 0, 0, 0);
                fail(new IllegalStateException("encoder has no input image"));
                return;
            }
            int size = input.capacity();
            fillYuv(image, frame);
            long pts = videoFrames * 1_000_000L / fps;
            videoFrames++;
            videoEncoder.queueInputBuffer(inIndex, 0, size, pts, 0);
            drainVideo();
        } catch (Exception e) {
            fail(e);
        }
    }

    /** Interleaved stereo PCM at {@link #audioRate}; ignored when audio is off. */
    synchronized void pushAudio(short[] pcm, int frames) {
        if (stopped || failed || !audioEnabled || audioEncoder == null || frames <= 0) {
            return;
        }
        try {
            int inIndex = audioEncoder.dequeueInputBuffer(DEQUEUE_TIMEOUT_US);
            if (inIndex < 0) {
                return;
            }
            ByteBuffer input = audioEncoder.getInputBuffer(inIndex);
            if (input == null) {
                return;
            }
            input.clear();
            int samples = Math.min(frames, input.capacity() / 4);
            if (samples <= 0) {
                audioEncoder.queueInputBuffer(inIndex, 0, 0, 0, 0);
                return;
            }
            input.order(ByteOrder.nativeOrder());
            input.asShortBuffer().put(pcm, 0, samples * 2);
            long pts = audioSamples * 1_000_000L / audioRate;
            audioSamples += samples;
            audioEncoder.queueInputBuffer(inIndex, 0, samples * 4, pts, 0);
            drainAudio();
        } catch (Exception e) {
            fail(e);
        }
    }

    /** Flushes both encoders and closes the file. Safe to call twice. */
    synchronized void stop() {
        if (stopped) {
            return;
        }
        stopped = true;
        try {
            if (videoEncoder != null && !failed) {
                queueEos(videoEncoder, videoInfo, videoFrames * 1_000_000L / fps);
                drainVideoUntilEos();
            }
        } catch (Exception e) {
            Log.w(TAG, "video flush failed: " + e);
        }
        try {
            if (audioEncoder != null && audioEnabled && !failed) {
                queueEos(audioEncoder, audioInfo, audioSamples * 1_000_000L / audioRate);
                drainAudioUntilEos();
            }
        } catch (Exception e) {
            Log.w(TAG, "audio flush failed: " + e);
        }
        release();
    }

    private static void queueEos(MediaCodec codec, MediaCodec.BufferInfo info, long pts) {
        int inIndex = codec.dequeueInputBuffer(100_000L);
        if (inIndex >= 0) {
            codec.queueInputBuffer(inIndex, 0, 0, pts, MediaCodec.BUFFER_FLAG_END_OF_STREAM);
        }
    }

    private void release() {
        if (muxerStarted) {
            try {
                muxer.stop();
            } catch (Exception e) {
                Log.w(TAG, "muxer stop failed: " + e);
            }
        }
        if (muxer != null) {
            try {
                muxer.release();
            } catch (Exception ignored) {
            }
            muxer = null;
        }
        muxerStarted = false;
        releaseCodec(videoEncoder);
        releaseCodec(audioEncoder);
        videoEncoder = null;
        audioEncoder = null;
    }

    private static void releaseCodec(MediaCodec codec) {
        if (codec == null) {
            return;
        }
        try {
            codec.stop();
        } catch (Exception ignored) {
        }
        try {
            codec.release();
        } catch (Exception ignored) {
        }
    }

    private void fail(Exception e) {
        if (!failed) {
            Log.w(TAG, "recording failed: " + e);
            failure = e.toString();
        }
        failed = true;
    }

    // == Muxer plumbing ====================================================

    private void maybeStartMuxer() {
        if (muxerStarted || muxer == null) {
            return;
        }
        boolean videoReady = videoFormat != null;
        boolean audioReady = !audioEnabled || audioFormat != null;
        if (!videoReady || !audioReady) {
            return;
        }
        try {
            videoTrack = muxer.addTrack(videoFormat);
            if (audioEnabled && audioFormat != null) {
                audioTrack = muxer.addTrack(audioFormat);
            }
            muxer.start();
            muxerStarted = true;
        } catch (Exception e) {
            fail(e);
        }
    }

    private void drainVideo() {
        drainVideoUntilEos();
    }

    private void drainAudio() {
        drainAudioUntilEos();
    }

    private void drainVideoUntilEos() {
        if (videoEncoder == null) {
            return;
        }
        while (true) {
            int outIndex = videoEncoder.dequeueOutputBuffer(videoInfo, DEQUEUE_TIMEOUT_US);
            if (outIndex == MediaCodec.INFO_TRY_AGAIN_LATER) {
                return;
            }
            if (outIndex == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED) {
                videoFormat = videoEncoder.getOutputFormat();
                maybeStartMuxer();
                continue;
            }
            if (outIndex < 0) {
                continue;
            }
            ByteBuffer buffer = videoEncoder.getOutputBuffer(outIndex);
            boolean config = (videoInfo.flags & MediaCodec.BUFFER_FLAG_CODEC_CONFIG) != 0;
            if (buffer != null && videoInfo.size > 0 && !config && muxerStarted) {
                buffer.position(videoInfo.offset);
                buffer.limit(videoInfo.offset + videoInfo.size);
                try {
                    muxer.writeSampleData(videoTrack, buffer, videoInfo);
                } catch (Exception e) {
                    fail(e);
                }
            }
            videoEncoder.releaseOutputBuffer(outIndex, false);
            if ((videoInfo.flags & MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0) {
                return;
            }
        }
    }

    private void drainAudioUntilEos() {
        if (audioEncoder == null) {
            return;
        }
        while (true) {
            int outIndex = audioEncoder.dequeueOutputBuffer(audioInfo, DEQUEUE_TIMEOUT_US);
            if (outIndex == MediaCodec.INFO_TRY_AGAIN_LATER) {
                return;
            }
            if (outIndex == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED) {
                audioFormat = audioEncoder.getOutputFormat();
                maybeStartMuxer();
                continue;
            }
            if (outIndex < 0) {
                continue;
            }
            ByteBuffer buffer = audioEncoder.getOutputBuffer(outIndex);
            boolean config = (audioInfo.flags & MediaCodec.BUFFER_FLAG_CODEC_CONFIG) != 0;
            if (buffer != null && audioInfo.size > 0 && !config && muxerStarted) {
                buffer.position(audioInfo.offset);
                buffer.limit(audioInfo.offset + audioInfo.size);
                try {
                    muxer.writeSampleData(audioTrack, buffer, audioInfo);
                } catch (Exception e) {
                    fail(e);
                }
            }
            audioEncoder.releaseOutputBuffer(outIndex, false);
            if ((audioInfo.flags & MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0) {
                return;
            }
        }
    }

    // == RGB -> YUV ========================================================

    private void fillYuv(Image image, Bitmap frame) {
        if (frame.getWidth() < width || frame.getHeight() < height) {
            return;
        }
        if (argb == null) {
            argb = new int[width * height];
        }
        frame.getPixels(argb, 0, width, 0, 0, width, height);
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer yPlane = planes[0].getBuffer();
        ByteBuffer uPlane = planes[1].getBuffer();
        ByteBuffer vPlane = planes[2].getBuffer();
        int yRow = planes[0].getRowStride();
        int yPix = planes[0].getPixelStride();
        int uRow = planes[1].getRowStride();
        int uPix = planes[1].getPixelStride();
        int vRow = planes[2].getRowStride();
        int vPix = planes[2].getPixelStride();
        for (int y = 0; y < height; y++) {
            int rowBase = y * width;
            int yBase = y * yRow;
            for (int x = 0; x < width; x++) {
                int color = argb[rowBase + x];
                int r = (color >> 16) & 0xFF;
                int g = (color >> 8) & 0xFF;
                int b = color & 0xFF;
                int luma = ((66 * r + 129 * g + 25 * b + 128) >> 8) + 16;
                yPlane.put(yBase + x * yPix, clamp(luma));
            }
        }
        for (int y = 0; y < height; y += 2) {
            for (int x = 0; x < width; x += 2) {
                int r = 0;
                int g = 0;
                int b = 0;
                int count = 0;
                for (int dy = 0; dy < 2 && y + dy < height; dy++) {
                    for (int dx = 0; dx < 2 && x + dx < width; dx++) {
                        int color = argb[(y + dy) * width + x + dx];
                        r += (color >> 16) & 0xFF;
                        g += (color >> 8) & 0xFF;
                        b += color & 0xFF;
                        count++;
                    }
                }
                if (count == 0) {
                    continue;
                }
                r /= count;
                g /= count;
                b /= count;
                int u = ((-38 * r - 74 * g + 112 * b + 128) >> 8) + 128;
                int v = ((112 * r - 94 * g - 18 * b + 128) >> 8) + 128;
                int cx = x / 2;
                int cy = y / 2;
                uPlane.put(cy * uRow + cx * uPix, clamp(u));
                vPlane.put(cy * vRow + cx * vPix, clamp(v));
            }
        }
    }

    private static byte clamp(int value) {
        if (value < 0) {
            return 0;
        }
        if (value > 255) {
            return (byte) 255;
        }
        return (byte) value;
    }

    // == Publishing ========================================================

    /** Copies the finished file into the gallery (Movies/mGBAx) and returns its name. */
    static String publish(Context context, File file) {
        if (file == null || !file.isFile() || file.length() <= 0) {
            return null;
        }
        String name = file.getName();
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Video.Media.DISPLAY_NAME, name);
                values.put(MediaStore.Video.Media.MIME_TYPE, "video/mp4");
                values.put(MediaStore.Video.Media.RELATIVE_PATH,
                        Environment.DIRECTORY_MOVIES + "/mGBAx");
                Uri uri = context.getContentResolver()
                        .insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values);
                if (uri != null) {
                    try (InputStream in = new FileInputStream(file);
                         OutputStream out = context.getContentResolver().openOutputStream(uri)) {
                        if (out != null) {
                            byte[] buffer = new byte[65536];
                            int n;
                            while ((n = in.read(buffer)) > 0) {
                                out.write(buffer, 0, n);
                            }
                        }
                    }
                    return name;
                }
            } else {
                File dir = new File(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_MOVIES), "mGBAx");
                if (!dir.isDirectory() && !dir.mkdirs()) {
                    return null;
                }
                File dest = new File(dir, name);
                try (InputStream in = new FileInputStream(file);
                     OutputStream out = new FileOutputStream(dest)) {
                    byte[] buffer = new byte[65536];
                    int n;
                    while ((n = in.read(buffer)) > 0) {
                        out.write(buffer, 0, n);
                    }
                }
                return name;
            }
        } catch (Exception e) {
            Log.w(TAG, "publish failed: " + e);
        }
        return null;
    }
}
