/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation
import UIKit

/**
 * AI screen translation, in the spirit of Pizza Boy's 翻译: the current frame
 * goes to a Gemini model, which locates the text blocks and returns them
 * translated. The overlay draws each block on top of the game.
 *
 * The request and the response format match the Android build exactly, so the
 * same API key and model keep working and the parsed blocks stay normalized
 * to the picture.
 */
enum AiTranslate {
    private static let endpoint =
        "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key="

    struct Block {
        /// Top-left corner and size, normalized to the whole image (0..1).
        var x: CGFloat
        var y: CGFloat
        var w: CGFloat
        var h: CGFloat
        var text: String
    }

    /// Sends the frame for translation and reports on the main queue.
    static func translate(frame: UIImage, apiKey: String, targetLang: String,
                          completion: @escaping ([Block]?, String?) -> Void) {
        let key = apiKey.trimmingCharacters(in: .whitespacesAndNewlines)
        guard !key.isEmpty else {
            DispatchQueue.main.async { completion(nil, "no key") }
            return
        }
        let upload = snapshot(frame, maxSide: 720)
        guard let png = upload.pngData() else {
            DispatchQueue.main.async { completion(nil, "no image") }
            return
        }
        let language = targetLang.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty
            ? "简体中文" : targetLang
        let prompt = "这是复古游戏机屏幕截图。找出画面中所有含游戏文字的区域(对白、菜单、提示),"
            + "把日文或英文翻译成\(language)。"
            + "只输出 JSON 数组,不要其它文字:每个元素格式 {\"x\":0..1,\"y\":0..1,\"w\":0..1,\"h\":0..1,\"t\":\"译文\"},"
            + "x/y 是文本块左上角(相对整图宽高),w/h 是文本块大小;没有文字就输出 []。"
        let body: [String: Any] = [
            "contents": [[
                "role": "user",
                "parts": [
                    ["text": prompt],
                    ["inline_data": ["mime_type": "image/png", "data": png.base64EncodedString()]],
                ],
            ]],
        ]
        guard let payload = try? JSONSerialization.data(withJSONObject: body) else {
            DispatchQueue.main.async { completion(nil, "bad request") }
            return
        }
        guard let url = URL(string: endpoint + (key.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed) ?? key)) else {
            DispatchQueue.main.async { completion(nil, "bad key") }
            return
        }
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        request.timeoutInterval = 45
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = payload
        URLSession.shared.dataTask(with: request) { data, response, error in
            if let error {
                DispatchQueue.main.async { completion(nil, error.localizedDescription) }
                return
            }
            let code = (response as? HTTPURLResponse)?.statusCode ?? 0
            let text = data.flatMap { String(data: $0, encoding: .utf8) } ?? ""
            if code >= 400 {
                DispatchQueue.main.async { completion(nil, "HTTP \(code): \(trim(text))") }
                return
            }
            guard let data,
                  let json = try? JSONSerialization.jsonObject(with: data) as? [String: Any],
                  let candidates = json["candidates"] as? [[String: Any]],
                  let first = candidates.first,
                  let content = first["content"] as? [String: Any],
                  let parts = content["parts"] as? [[String: Any]],
                  let answer = parts.first?["text"] as? String else {
                DispatchQueue.main.async { completion(nil, "no candidates") }
                return
            }
            let blocks = parseBlocks(answer)
            DispatchQueue.main.async { completion(blocks, nil) }
        }.resume()
    }

    /// The model may wrap the JSON in prose or code fences; find the array.
    static func parseBlocks(_ text: String) -> [Block] {
        var cleaned = text.replacingOccurrences(of: "```json", with: "```")
        cleaned = cleaned.trimmingCharacters(in: .whitespacesAndNewlines)
        guard let start = cleaned.firstIndex(of: "["),
              let end = cleaned.lastIndex(of: "]"), start < end else { return [] }
        let slice = String(cleaned[start...end])
        guard let data = slice.data(using: .utf8),
              let array = try? JSONSerialization.jsonObject(with: data) as? [[String: Any]] else { return [] }
        var out: [Block] = []
        for item in array {
            let block = Block(
                x: number(item["x"]),
                y: number(item["y"]),
                w: number(item["w"]),
                h: number(item["h"]),
                text: (item["t"] as? String ?? "").trimmingCharacters(in: .whitespacesAndNewlines))
            if !block.text.isEmpty && block.w > 0.001 && block.h > 0.001 {
                out.append(block)
            }
        }
        return out
    }

    private static func number(_ value: Any?) -> CGFloat {
        if let number = value as? NSNumber { return CGFloat(number.doubleValue) }
        if let text = value as? String, let parsed = Double(text) { return CGFloat(parsed) }
        return 0
    }

    /// Scales a frame down so its longest side is no larger than `maxSide`.
    static func snapshot(_ source: UIImage, maxSide: CGFloat) -> UIImage {
        let width = max(1, source.size.width)
        let height = max(1, source.size.height)
        guard width > maxSide || height > maxSide else { return source }
        let scale = maxSide / max(width, height)
        let size = CGSize(width: max(1, (width * scale).rounded()),
                          height: max(1, (height * scale).rounded()))
        let renderer = UIGraphicsImageRenderer(size: size)
        return renderer.image { _ in
            source.draw(in: CGRect(origin: .zero, size: size))
        }
    }

    /// Average luma 0-255 of a block region, used to pick the text color.
    /// The image is sampled through a small RGBA context, so even large
    /// screenshots stay cheap for a dozen blocks.
    static func blockBrightness(_ image: UIImage, _ block: Block) -> CGFloat {
        guard let cg = image.cgImage else { return 0 }
        let maxSide: CGFloat = 96
        let scale = min(1, maxSide / CGFloat(max(cg.width, cg.height)))
        let w = max(1, Int(CGFloat(cg.width) * scale))
        let h = max(1, Int(CGFloat(cg.height) * scale))
        var pixels = [UInt8](repeating: 0, count: w * h * 4)
        let ok: Bool = pixels.withUnsafeMutableBytes { raw in
            guard let base = raw.baseAddress,
                  let ctx = CGContext(data: base, width: w, height: h, bitsPerComponent: 8,
                                      bytesPerRow: w * 4, space: CGColorSpaceCreateDeviceRGB(),
                                      bitmapInfo: CGImageAlphaInfo.premultipliedLast.rawValue) else {
                return false
            }
            ctx.interpolationQuality = .low
            ctx.translateBy(x: 0, y: CGFloat(h))
            ctx.scaleBy(x: 1, y: -1)
            ctx.draw(cg, in: CGRect(x: 0, y: 0, width: w, height: h))
            return true
        }
        guard ok else { return 0 }
        let x0 = max(0, min(w - 1, Int((block.x * CGFloat(w)).rounded())))
        let y0 = max(0, min(h - 1, Int((block.y * CGFloat(h)).rounded())))
        let bw = max(1, min(w - x0, Int((block.w * CGFloat(w)).rounded())))
        let bh = max(1, min(h - y0, Int((block.h * CGFloat(h)).rounded())))
        var sum = 0
        var count = 0
        let step = max(1, (bw * bh) / 256)
        for y in stride(from: y0, to: y0 + bh, by: max(1, Int(sqrt(Double(step))))) {
            for x in stride(from: x0, to: x0 + bw, by: max(1, Int(sqrt(Double(step))))) {
                let base = (y * w + x) * 4
                let luma = (Int(pixels[base]) * 77 + Int(pixels[base + 1]) * 151 + Int(pixels[base + 2]) * 28) >> 8
                sum += luma
                count += 1
            }
        }
        return count == 0 ? 0 : CGFloat(sum) / CGFloat(count)
    }

    private static func trim(_ text: String) -> String {
        text.count > 200 ? String(text.prefix(200)) : text
    }
}
