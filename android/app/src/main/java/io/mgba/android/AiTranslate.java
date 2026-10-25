/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * AI screen translation, in the spirit of Pizza Boy's 翻译: the current frame
 * goes to a Gemini model, which locates the text blocks and returns them
 * translated. The overlay draws each block on top of the game, choosing black
 * or white text by the background's brightness.
 */
public final class AiTranslate {
    private static final String ENDPOINT =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=";

    public static class Block {
        public float x;
        public float y;
        public float w;
        public float h;
        public String text;
    }

    public interface Callback {
        void onResult(List<Block> blocks, @androidx.annotation.Nullable String error);
    }

    private AiTranslate() {
    }

    /** Sends the frame for translation on the caller's thread. */
    public static void translate(Bitmap frame, String apiKey, String targetLang, Callback callback) {
        new Thread(() -> {
            try {
                List<Block> blocks = doTranslate(frame, apiKey, targetLang);
                callback.onResult(blocks, null);
            } catch (Exception e) {
                String message = e.getMessage() == null ? e.toString() : e.getMessage();
                callback.onResult(null, message);
            }
        }, "ai-translate").start();
    }

    private static List<Block> doTranslate(Bitmap frame, String apiKey, String targetLang) throws Exception {
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("no key");
        }
        // Cap the upload: the model only needs to read the text.
        Bitmap scaled = frame;
        int maxSide = 720;
        if (frame.getWidth() > maxSide && frame.getWidth() >= frame.getHeight()) {
            scaled = Bitmap.createScaledBitmap(frame, maxSide,
                    frame.getHeight() * maxSide / frame.getWidth(), true);
        } else if (frame.getHeight() > maxSide) {
            scaled = Bitmap.createScaledBitmap(frame, frame.getWidth() * maxSide / frame.getHeight(), maxSide, true);
        }
        Bitmap send = scaled;
        ByteArrayOutputStream png = new ByteArrayOutputStream();
        send.compress(Bitmap.CompressFormat.PNG, 90, png);
        if (send != frame) {
            send.recycle();
        }
        String image = android.util.Base64.encodeToString(png.toByteArray(), android.util.Base64.NO_WRAP);

        String prompt = "这是复古游戏机屏幕截图。找出画面中所有含游戏文字的区域(对白、菜单、提示),"
                + "把日文或英文翻译成" + (targetLang == null || targetLang.isEmpty() ? "简体中文" : targetLang) + "。"
                + "只输出 JSON 数组,不要其它文字:每个元素格式 {\"x\":0..1,\"y\":0..1,\"w\":0..1,\"h\":0..1,\"t\":\"译文\"},"
                + "x/y 是文本块左上角(相对整图宽高),w/h 是文本块大小;没有文字就输出 []。";

        JSONObject body = new JSONObject();
        JSONArray contents = new JSONArray();
        JSONObject role = new JSONObject();
        JSONArray parts = new JSONArray();
        JSONObject textPart = new JSONObject().put("text", prompt);
        JSONObject inline = new JSONObject()
                .put("mime_type", "image/png")
                .put("data", image);
        parts.put(textPart);
        parts.put(new JSONObject().put("inline_data", inline));
        role.put("role", "user").put("parts", parts);
        contents.put(role);
        body.put("contents", contents);

        HttpURLConnection connection = (HttpURLConnection) new URL(ENDPOINT + apiKey.trim()).openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(45000);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        try (OutputStream out = connection.getOutputStream()) {
            out.write(body.toString().getBytes(StandardCharsets.UTF_8));
        }
        int code = connection.getResponseCode();
        InputStream stream = code >= 400 ? connection.getErrorStream() : connection.getInputStream();
        StringBuilder response = new StringBuilder();
        if (stream != null) {
            try (java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(stream, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line).append('\n');
                }
            }
        }
        connection.disconnect();
        if (code >= 400) {
            throw new IllegalStateException("HTTP " + code + ": " + trim(response.toString()));
        }
        JSONObject json = new JSONObject(response.toString());
        JSONArray candidates = json.optJSONArray("candidates");
        if (candidates == null || candidates.length() == 0) {
            throw new IllegalStateException("no candidates");
        }
        String text = candidates.getJSONObject(0)
                .getJSONObject("content")
                .getJSONArray("parts")
                .getJSONObject(0)
                .optString("text", "");
        return parseBlocks(text);
    }

    /** The model may wrap the JSON in prose or code fences; find the array. */
    static List<Block> parseBlocks(String text) {
        List<Block> out = new ArrayList<>();
        if (text == null) {
            return out;
        }
        String cleaned = text.replace("```json", "```");
        int start = cleaned.indexOf('[');
        int end = cleaned.lastIndexOf(']');
        if (start < 0 || end <= start) {
            return out;
        }
        try {
            JSONArray array = new JSONArray(cleaned.substring(start, end + 1));
            for (int i = 0; i < array.length(); i++) {
                JSONObject item = array.optJSONObject(i);
                if (item == null) {
                    continue;
                }
                Block block = new Block();
                block.x = (float) item.optDouble("x", 0);
                block.y = (float) item.optDouble("y", 0);
                block.w = (float) item.optDouble("w", 0);
                block.h = (float) item.optDouble("h", 0);
                block.text = item.optString("t", "").trim();
                if (!block.text.isEmpty() && block.w > 0.001f && block.h > 0.001f) {
                    out.add(block);
                }
            }
        } catch (Exception ignored) {
        }
        return out;
    }

    /** Scales a frame down for upload when it is larger than maxWidth. */
    public static Bitmap snapshot(Bitmap source, int maxWidth) {
        if (source == null || source.getWidth() <= maxWidth) {
            return source;
        }
        return Bitmap.createScaledBitmap(source, maxWidth,
                source.getHeight() * maxWidth / source.getWidth(), true);
    }

    private static String trim(String text) {
        return text.length() > 200 ? text.substring(0, 200) : text;
    }

    /** Average brightness 0-255 of a block region, to pick text color. */
    public static float blockBrightness(Bitmap frame, Block block) {
        int x = Math.max(0, Math.min(frame.getWidth() - 1, Math.round(block.x * frame.getWidth())));
        int y = Math.max(0, Math.min(frame.getHeight() - 1, Math.round(block.y * frame.getHeight())));
        int w = Math.max(1, Math.min(frame.getWidth() - x, Math.round(block.w * frame.getWidth())));
        int h = Math.max(1, Math.min(frame.getHeight() - y, Math.round(block.h * frame.getHeight())));
        int[] pixels = new int[w * h];
        frame.getPixels(pixels, 0, w, x, y, w, h);
        // Sample sparsely; a light backdrop wants dark text.
        long sum = 0;
        int count = 0;
        int step = Math.max(1, pixels.length / 256);
        for (int i = 0; i < pixels.length; i += step) {
            int pixel = pixels[i];
            int luma = ((pixel >> 16 & 0xFF) * 77 + (pixel >> 8 & 0xFF) * 151 + (pixel & 0xFF) * 28) >> 8;
            sum += luma;
            count++;
        }
        return count == 0 ? 0f : sum / (float) count;
    }
}
