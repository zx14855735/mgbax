/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import android.view.Surface;

import androidx.annotation.Nullable;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Renders the emulator frame through a screen filter with OpenGL ES 2.0.
 *
 * <p>All GL work happens on the thread that calls {@link #present} (the UI
 * thread, like the software path it replaces). A frame is uploaded as a
 * texture, the filter program draws it into the scaled destination rect and
 * the result is swapped to the window surface. The GL side owns the window
 * surface from the first presented frame on — even without a filter —
 * because a hardware Canvas that touched the surface in between makes every
 * later eglCreateWindowSurface fail with EGL_BAD_ALLOC, which used to kill
 * all filters silently. The Canvas path in the caller only runs when this
 * class reports the GL environment as dead (no EGL / no window surface at
 * all), in which case GL never comes back.</p>
 */
final class ShaderRenderer {
    private static final String TAG = "mGBA-Shader";

    /** Extra textures holding previous frames for the LCD ghosting filter. */
    private static final int HISTORY_SLOTS = 8;
    private static final int MAX_HISTORY = 7;

    private EGLDisplay display = EGL14.EGL_NO_DISPLAY;
    private EGLContext context = EGL14.EGL_NO_CONTEXT;
    private EGLConfig config;
    private EGLSurface surface = EGL14.EGL_NO_SURFACE;
    private int surfaceW;
    private int surfaceH;

    private int filterId = Shaders.FILTER_NONE;
    private final Set<Integer> broken = new HashSet<>();
    /** Source version the 外部渲染器 was last marked broken for. */
    private int externalBrokenVersion;
    private final Map<Integer, Program> programs = new HashMap<>();
    /** Plain blit used when no filter is active or the filter program failed. */
    private Program passthrough;
    /** The GL environment is unusable on this device; Canvas owns the surface. */
    private boolean envDead;
    /** Consecutive window-surface creation failures before giving up on GL. */
    private int surfaceFails;
    private boolean loggedOk;

    private int frameTex = 0;
    private int frameW;
    private int frameH;
    private final int[] historyTex = new int[HISTORY_SLOTS];
    private boolean historyAlloc;
    /** Past frames accumulated in the ring; capped reads at {@link #MAX_HISTORY}. */
    private int historyCount;
    private int historyIndex;

    private final FloatBuffer quad = ByteBuffer
            .allocateDirect(4 * 4 * 4)
            .order(ByteOrder.nativeOrder())
            .asFloatBuffer();
    {
        // x, y, u, v — a full-screen strip; v=0 is the bitmap's top row.
        quad.put(new float[]{
                -1f, 1f, 0f, 0f,
                1f, 1f, 1f, 0f,
                -1f, -1f, 0f, 1f,
                1f, -1f, 1f, 1f,
        });
        quad.position(0);
    }

    void setFilter(int id) {
        if (id == filterId) {
            return;
        }
        filterId = id;
        historyCount = 0;
    }

    /**
     * True while GL may still come up or is already up. The caller must not
     * draw with a Canvas on the same surface while this returns true, even
     * before the first GL frame — once GL is alive, a Canvas takeover would
     * break every later eglCreateWindowSurface.
     */
    boolean envAlive() {
        return !envDead;
    }

    void release() {
        releaseSurface();
        if (context != EGL14.EGL_NO_CONTEXT) {
            EGL14.eglDestroyContext(display, context);
            context = EGL14.EGL_NO_CONTEXT;
        }
        if (display != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglTerminate(display);
            display = EGL14.EGL_NO_DISPLAY;
        }
        programs.clear();
        passthrough = null;
        frameTex = 0;
        historyAlloc = false;
        historyCount = 0;
        envDead = false;
        surfaceFails = 0;
    }

    /** The window surface went away; everything on it must be rebuilt. */
    void releaseSurface() {
        if (surface != EGL14.EGL_NO_SURFACE) {
            EGL14.eglMakeCurrent(display, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(display, surface);
            surface = EGL14.EGL_NO_SURFACE;
        }
    }

    private boolean ensureDisplay() {
        if (display != EGL14.EGL_NO_DISPLAY) {
            return true;
        }
        display = EGL14.eglGetDisplay(EGL14.EGL_DEFAULT_DISPLAY);
        if (display == EGL14.EGL_NO_DISPLAY) {
            return false;
        }
        int[] major = new int[1];
        int[] minor = new int[1];
        if (!EGL14.eglInitialize(display, major, 0, minor, 0)) {
            display = EGL14.EGL_NO_DISPLAY;
            return false;
        }
        int[] attribs = {
                EGL14.EGL_SURFACE_TYPE, EGL14.EGL_WINDOW_BIT,
                EGL14.EGL_RENDERABLE_TYPE, EGL14.EGL_OPENGL_ES2_BIT,
                EGL14.EGL_RED_SIZE, 5,
                EGL14.EGL_GREEN_SIZE, 6,
                EGL14.EGL_BLUE_SIZE, 5,
                EGL14.EGL_NONE
        };
        EGLConfig[] configs = new EGLConfig[1];
        int[] count = new int[1];
        if (!EGL14.eglChooseConfig(display, attribs, 0, configs, 0, 1, count, 0) || count[0] == 0) {
            return false;
        }
        config = configs[0];
        int[] ctxAttribs = {EGL14.EGL_CONTEXT_CLIENT_VERSION, 2, EGL14.EGL_NONE};
        context = EGL14.eglCreateContext(display, config, EGL14.EGL_NO_CONTEXT, ctxAttribs, 0);
        return context != EGL14.EGL_NO_CONTEXT;
    }

    private boolean ensureSurface(Surface window, int w, int h) {
        if (surface != EGL14.EGL_NO_SURFACE && surfaceW == w && surfaceH == h) {
            return true;
        }
        releaseSurface();
        int[] attribs = {EGL14.EGL_NONE};
        surface = EGL14.eglCreateWindowSurface(display, config, window, attribs, 0);
        if (surface == EGL14.EGL_NO_SURFACE) {
            return false;
        }
        surfaceW = w;
        surfaceH = h;
        return true;
    }

    /**
     * Draws one frame with the selected filter — or a plain blit when no
     * filter is active. Returns false only when the GL environment is dead
     * (the caller may then use its Canvas path). Once true has been returned,
     * GL owns the window surface and the caller must never Canvas it again.
     *
     * @param dst destination rect of the picture inside the view, top-left origin
     */
    boolean present(Surface window, Bitmap bitmap, Rect dst, int viewW, int viewH,
                    int filter, float brightness, float contrast, boolean linear, boolean scanlines) {
        if (envDead) {
            return false;
        }
        if (!ensureDisplay()) {
            Log.e(TAG, "EGL display/config/context init failed, egl error "
                    + Integer.toHexString(EGL14.eglGetError()));
            envDead = true;
            return false;
        }
        if (!ensureSurface(window, viewW, viewH)) {
            surfaceFails++;
            Log.e(TAG, "eglCreateWindowSurface failed (" + viewW + "x" + viewH + "), egl error "
                    + Integer.toHexString(EGL14.eglGetError())
                    + (surfaceFails > 60 ? " — giving up, Canvas takes over" : " — retrying"));
            if (surfaceFails > 60) {
                envDead = true;
                return false;
            }
            return true;
        }
        surfaceFails = 0;
        if (!EGL14.eglMakeCurrent(display, surface, surface, context)) {
            Log.e(TAG, "eglMakeCurrent failed, egl error "
                    + Integer.toHexString(EGL14.eglGetError()));
            releaseSurface();
            return true;
        }
        boolean filtered = filter != Shaders.FILTER_NONE && !broken.contains(filter);
        Program program = filtered ? ensureProgram(filter) : passthrough();
        if (program == null) {
            // A filter that cannot compile still shows the plain frame
            // through GL: falling back to Canvas here would break the
            // window surface for every other filter.
            program = passthrough();
            filtered = false;
            if (program == null) {
                envDead = true;
                return false;
            }
        }
        if (bitmap != null && !dst.isEmpty()
                && !upload(bitmap, filtered ? filter : Shaders.FILTER_NONE, linear)) {
            Log.e(TAG, "texture upload failed, gl error "
                    + Integer.toHexString(GLES20.glGetError()));
            return true;
        }

        GLES20.glClearColor(0f, 0f, 0f, 1f);
        if (bitmap == null || dst.isEmpty()) {
            // Nothing to show this frame; keep the surface black and GL-owned.
            GLES20.glViewport(0, 0, viewW, viewH);
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        } else {
            GLES20.glViewport(0, 0, viewW, viewH);
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
            GLES20.glViewport(dst.left, Math.max(0, viewH - dst.bottom), dst.width(), dst.height());

            GLES20.glUseProgram(program.id);
            quad.position(0);
            GLES20.glVertexAttribPointer(program.aPos, 2, GLES20.GL_FLOAT, false, 16, quad);
            quad.position(2);
            GLES20.glVertexAttribPointer(program.aTexCoord, 2, GLES20.GL_FLOAT, false, 16, quad);
            GLES20.glEnableVertexAttribArray(program.aPos);
            GLES20.glEnableVertexAttribArray(program.aTexCoord);
            GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, frameTex);
            GLES20.glUniform1i(program.uTex, 0);
            GLES20.glUniform2f(program.uTexSize, (float) bitmap.getWidth(), (float) bitmap.getHeight());
            GLES20.glUniform2f(program.uOutSize, (float) dst.width(), (float) dst.height());
            GLES20.glUniform1f(program.uBrightness, brightness);
            if (program.uContrast >= 0) {
                GLES20.glUniform1f(program.uContrast, contrast);
            }
            if (program.uScanlines >= 0) {
                GLES20.glUniform1f(program.uScanlines, scanlines ? 1f : 0f);
            }
            if (filtered && program.uHistory[0] >= 0) {
                // history[0] is the newest previous frame. Slots beyond what has
                // accumulated bind the current frame, whose EMA terms cancel out,
                // so the smear warms up cleanly on the first frames.
                int available = Math.min(historyCount, MAX_HISTORY);
                for (int i = 0; i < MAX_HISTORY; i++) {
                    int slot = (historyIndex + HISTORY_SLOTS - 2 - i) % HISTORY_SLOTS;
                    GLES20.glActiveTexture(GLES20.GL_TEXTURE1 + i);
                    GLES20.glBindTexture(GLES20.GL_TEXTURE_2D,
                            i < available ? historyTex[slot] : frameTex);
                    GLES20.glUniform1i(program.uHistory[i], i + 1);
                }
                GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
            }
            GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
            GLES20.glDisableVertexAttribArray(program.aPos);
            GLES20.glDisableVertexAttribArray(program.aTexCoord);
        }

        if (!EGL14.eglSwapBuffers(display, surface)) {
            Log.e(TAG, "eglSwapBuffers failed, egl error " + Integer.toHexString(EGL14.eglGetError()));
            releaseSurface();
            return true;
        }
        if (!loggedOk) {
            loggedOk = true;
            Log.i(TAG, "GL present ok (" + dst.width() + "x" + dst.height()
                    + ", filter " + filter + ")");
        }
        return true;
    }

    private boolean upload(Bitmap bitmap, int filter, boolean linear) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        boolean historyNeeded = filter != Shaders.FILTER_NONE && Shaders.historyFrames(filter) > 0;
        if (frameTex == 0) {
            int[] tex = new int[1];
            GLES20.glGenTextures(1, tex, 0);
            frameTex = tex[0];
            frameW = 0;
            frameH = 0;
        }
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, frameTex);
        int param = linear ? GLES20.GL_LINEAR : GLES20.GL_NEAREST;
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, param);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, param);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE);
        if (w != frameW || h != frameH) {
            GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);
            frameW = w;
            frameH = h;
            historyCount = 0;
        } else {
            GLUtils.texSubImage2D(GLES20.GL_TEXTURE_2D, 0, 0, 0, bitmap);
        }

        if (historyNeeded && !historyAlloc) {
            GLES20.glGenTextures(HISTORY_SLOTS, historyTex, 0);
            historyAlloc = true;
            historyCount = 0;
        }
        if (historyNeeded && historyAlloc) {
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, historyTex[historyIndex]);
            GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_NEAREST);
            GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_NEAREST);
            GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE);
            GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE);
            if (historyCount > 0 && w == frameW && h == frameH) {
                GLUtils.texSubImage2D(GLES20.GL_TEXTURE_2D, 0, 0, 0, bitmap);
            } else {
                GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);
            }
            historyIndex = (historyIndex + 1) % HISTORY_SLOTS;
            historyCount = Math.min(historyCount + 1, MAX_HISTORY);
        }
        return GLES20.glGetError() == GLES20.GL_NO_ERROR;
    }

    private Program ensureProgram(int filter) {
        Program program = programs.get(filter);
        if (filter == Shaders.FILTER_EXTERNAL) {
            // Reinstalled shaders share the filter id; rebuild when the
            // source version moved on.
            int version = Shaders.externalVersion();
            if (program != null && program.builtVersion == version) {
                return program;
            }
            programs.remove(filter);
            program = null;
            if (externalBrokenVersion != version) {
                broken.remove(filter);
                externalBrokenVersion = version;
            }
        }
        if (program != null) {
            return program;
        }
        String fragment = Shaders.fragment(filter);
        if (fragment == null) {
            return null;
        }
        program = buildProgram(fragment);
        if (program == null) {
            broken.add(filter);
            return null;
        }
        if (filter == Shaders.FILTER_EXTERNAL) {
            program.builtVersion = Shaders.externalVersion();
        }
        programs.put(filter, program);
        return program;
    }

    /** The plain blit program for frames without (or with a broken) filter. */
    private Program passthrough() {
        if (passthrough == null) {
            passthrough = buildProgram(Shaders.PASSTHROUGH);
        }
        return passthrough;
    }

    @Nullable
    private Program buildProgram(String fragment) {
        int vs = compile(GLES20.GL_VERTEX_SHADER, Shaders.VERTEX);
        int fs = compile(GLES20.GL_FRAGMENT_SHADER, fragment);
        if (vs == 0 || fs == 0) {
            return null;
        }
        int id = GLES20.glCreateProgram();
        GLES20.glAttachShader(id, vs);
        GLES20.glAttachShader(id, fs);
        GLES20.glLinkProgram(id);
        int[] status = new int[1];
        GLES20.glGetProgramiv(id, GLES20.GL_LINK_STATUS, status, 0);
        GLES20.glDeleteShader(vs);
        GLES20.glDeleteShader(fs);
        if (status[0] == 0) {
            Log.e(TAG, "program link failed: " + GLES20.glGetProgramInfoLog(id));
            GLES20.glDeleteProgram(id);
            return null;
        }
        Program program = new Program();
        program.id = id;
        program.aPos = GLES20.glGetAttribLocation(id, "aPos");
        program.aTexCoord = GLES20.glGetAttribLocation(id, "aTexCoord");
        program.uTex = GLES20.glGetUniformLocation(id, "uTex");
        program.uTexSize = GLES20.glGetUniformLocation(id, "uTexSize");
        program.uOutSize = GLES20.glGetUniformLocation(id, "uOutSize");
        program.uBrightness = GLES20.glGetUniformLocation(id, "uBrightness");
        program.uContrast = GLES20.glGetUniformLocation(id, "uContrast");
        program.uScanlines = GLES20.glGetUniformLocation(id, "uScanlines");
        for (int i = 0; i < MAX_HISTORY; i++) {
            program.uHistory[i] = GLES20.glGetUniformLocation(id, "uHistory" + i);
        }
        return program;
    }

    private int compile(int type, String source) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, source);
        GLES20.glCompileShader(shader);
        int[] status = new int[1];
        GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, status, 0);
        if (status[0] == 0) {
            Log.e(TAG, "shader compile failed: " + GLES20.glGetShaderInfoLog(shader));
            GLES20.glDeleteShader(shader);
            return 0;
        }
        return shader;
    }

    private static final class Program {
        int id;
        int aPos;
        int aTexCoord;
        int uTex;
        int uTexSize;
        int uOutSize;
        int uBrightness;
        int uContrast;
        /** 外部渲染器 source version this program was built from. */
        int builtVersion;
        /** Passthrough-only: the Canvas scanline overlay flag, -1 elsewhere. */
        int uScanlines = -1;
        final int[] uHistory = new int[MAX_HISTORY];
    }
}
