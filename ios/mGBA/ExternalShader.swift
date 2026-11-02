/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation

/// User-installed screen shaders.
///
/// Android lets the user drop a `.glsl` file into the app and use it as the
/// screen filter. iOS runs Metal, so GLSL cannot be handed to the compiler;
/// the adapter below rewrites the common single-sample GLSL into Metal
/// Shading Language. A `.metal` file is used as it is - the expected entry
/// point is described in the help text of the shader dialog.
///
/// The Metal contract the renderer expects:
///
///     fragment float4 gboyExternalFragment(FilterVaryings in [[stage_in]],
///                                          texture2d<float> uTex [[texture(0)]],
///                                          sampler s [[sampler(0)]],
///                                          constant FilterUniforms &u [[buffer(0)]])
enum ExternalShader {
    /// Filter id of the external shader; the built-in filters keep 1...11.
    static let filterId = 12
    static let fragmentName = "gboyExternalFragment"

    enum Failure: LocalizedError {
        case notText
        case notInstalled
        case compileFailed(String)

        var errorDescription: String? {
            switch self {
            case .notText:
                return "这个文件不是文本着色器"
            case .notInstalled:
                return "没有找到这个渲染器"
            case .compileFailed(let text):
                return "编译失败：\(text)"
            }
        }
    }

    private static let directoryName = "shaders"
    private static var cache: [String: String] = [:]
    private static var loaded = false
    private static var versionCounter = 0

    // MARK: - Storage

    private static var directory: URL {
        let base = FileManager.default.urls(for: .applicationSupportDirectory, in: .userDomainMask)[0]
        let dir = base.appendingPathComponent(directoryName, isDirectory: true)
        if !FileManager.default.fileExists(atPath: dir.path) {
            try? FileManager.default.createDirectory(at: dir, withIntermediateDirectories: true)
        }
        return dir
    }

    private static func load() {
        guard !loaded else { return }
        loaded = true
        cache.removeAll()
        let files = (try? FileManager.default.contentsOfDirectory(at: directory,
                                                                includingPropertiesForKeys: nil)) ?? []
        for file in files where file.pathExtension == "src" {
            guard let text = try? String(contentsOf: file, encoding: .utf8) else { continue }
            cache[file.deletingPathExtension().lastPathComponent] = text
        }
    }

    /// The installed shaders, by name.
    static var installed: [String] {
        load()
        return cache.keys.sorted()
    }

    /// The shader currently selected, if any.
    static var current: String? {
        UserDefaults.standard.string(forKey: "ext_shader")
    }

    /// The Metal source of the selected shader.
    static var source: String? {
        guard let name = current else { return nil }
        load()
        guard let original = cache[name] else { return nil }
        return adapt(original)
    }

    /// Bumped whenever the selection changes, so the renderer drops its
    /// cached pipeline.
    static var version: Int {
        versionCounter
    }

    static func select(_ name: String) throws {
        load()
        guard cache[name] != nil else {
            throw Failure.notInstalled
        }
        UserDefaults.standard.set(name, forKey: "ext_shader")
        versionCounter += 1
    }

    static func clear() {
        UserDefaults.standard.removeObject(forKey: "ext_shader")
        versionCounter += 1
    }

    /// Installs a shader file (.glsl or .metal) and selects it.
    @discardableResult
    static func install(from url: URL) throws -> String {
        load()
        let data = try Data(contentsOf: url)
        guard let text = String(data: data, encoding: .utf8) else {
            throw Failure.notText
        }
        var name = url.deletingPathExtension().lastPathComponent
        name = name.replacingOccurrences(of: "/", with: "_")
        if name.isEmpty {
            name = "shader"
        }
        try text.write(to: directory.appendingPathComponent(name + ".src"), atomically: true, encoding: .utf8)
        cache[name] = text
        try select(name)
        return name
    }

    static func remove(_ name: String) {
        load()
        cache.removeValue(forKey: name)
        try? FileManager.default.removeItem(at: directory.appendingPathComponent(name + ".src"))
        if current == name {
            clear()
        }
    }

    // MARK: - Adaptation

    /// Turns a shader source into Metal Shading Language.
    static func adapt(_ text: String) -> String {
        if text.contains("fragment") && text.contains("float4") {
            return adaptMetal(text)
        }
        return adaptGLSL(text)
    }

    /// A `.metal` file is used as it is; only the entry point name is fixed.
    private static func adaptMetal(_ text: String) -> String {
        if text.contains("fragment float4 \(fragmentName)") {
            return text
        }
        return replacing(pattern: "fragment\\s+float4\\s+([A-Za-z_][A-Za-z0-9_]*)\\s*\\(",
                         in: text, with: "fragment float4 \(fragmentName)(")
    }

    /// Rewrites a single-sample GLSL ES shader into Metal Shading Language.
    private static func adaptGLSL(_ text: String) -> String {
        var body = text
        // 版本与精度声明由 Metal 自己处理
        body = removing(pattern: "^\\s*#version[^\\n]*\\n", in: body)
        body = removing(pattern: "^\\s*precision\\s+\\w+\\s+\\w+\\s*;\\s*\\n", in: body)
        // 我们自己要提供的 uniform / varying
        for pattern in ["^\\s*uniform\\s+sampler2D\\s+uTex\\s*;[^\\n]*\\n",
                        "^\\s*uniform\\s+vec2\\s+uTexSize\\s*;[^\\n]*\\n",
                        "^\\s*uniform\\s+vec2\\s+uOutSize\\s*;[^\\n]*\\n",
                        "^\\s*uniform\\s+float\\s+uBrightness\\s*;[^\\n]*\\n",
                        "^\\s*uniform\\s+float\\s+uContrast\\s*;[^\\n]*\\n",
                        "^\\s*uniform\\s+float\\s+uScanlines\\s*;[^\\n]*\\n",
                        "^\\s*varying\\s+vec2\\s+vTexCoord\\s*;[^\\n]*\\n",
                        "^\\s*#define\\s+texture\\b[^\\n]*\\n"] {
            body = removing(pattern: pattern, in: body)
        }
        // RetroArch 风格的尺寸别名
        body = replacing(pattern: "\\b(TextureSize|InputSize|uInputSize|textureSize)\\b",
                         in: body, with: "uTexSize")
        body = replacing(pattern: "\\b(OutputSize|uOutputSize|OutSize)\\b", in: body, with: "uOutSize")
        // 采样
        body = replacing(pattern: "\\btexture2D\\s*\\(\\s*uTex\\s*,\\s*([^)]*?)\\s*\\)",
                         in: body, with: "uTex.sample(s, $1)")
        body = replacing(pattern: "\\btexture\\s*\\(\\s*uTex\\s*,\\s*([^)]*?)\\s*\\)",
                         in: body, with: "uTex.sample(s, $1)")
        body = replacing(pattern: "\\bCOMPAT_TEXTURE\\s*\\(\\s*[^,]+?\\s*,\\s*([^)]*?)\\s*\\)",
                         in: body, with: "uTex.sample(s, $1)")
        // uniform 映射到结构体字段
        body = replacing(pattern: "\\buTexSize\\b", in: body, with: "u.texSize")
        body = replacing(pattern: "\\buOutSize\\b", in: body, with: "u.outSize")
        body = replacing(pattern: "\\buBrightness\\b", in: body, with: "u.brightness")
        body = replacing(pattern: "\\buContrast\\b", in: body, with: "u.contrast")
        body = replacing(pattern: "\\buScanlines\\b", in: body, with: "u.scanlines")
        // varying
        body = replacing(pattern: "\\bvTexCoord\\b", in: body, with: "in.texCoord")
        // gl_FragColor → 引用参数
        body = replacing(pattern: "\\bgl_FragColor\\b", in: body, with: "result")
        body = replacing(pattern: "\\bvoid\\s+main\\s*\\(\\s*\\)\\s*\\{",
                         in: body, with: "void gboyMain(thread float4 &result) {")
        return """
        #include <metal_stdlib>
        using namespace metal;

        struct FilterVaryings {
            float4 position [[position]];
            float2 texCoord;
        };

        struct FilterUniforms {
            float2 texSize;
            float2 outSize;
            float brightness;
            float contrast;
            float scanlines;
        };

        fragment float4 \(fragmentName)(FilterVaryings in [[stage_in]],
                                         texture2d<float> uTex [[texture(0)]],
                                         sampler s [[sampler(0)]],
                                         constant FilterUniforms &u [[buffer(0)]]) {
            float4 result = float4(0.0, 0.0, 0.0, 1.0);
        \(body)
            gboyMain(result);
            return result;
        }
        """
    }

    // MARK: - Regex helpers

    private static func removing(pattern: String, in text: String) -> String {
        guard let regex = try? NSRegularExpression(pattern: pattern, options: [.anchorsMatchLines]) else {
            return text
        }
        let range = NSRange(text.startIndex..<text.endIndex, in: text)
        return regex.stringByReplacingMatches(in: text, options: [], range: range, withTemplate: "")
    }

    private static func replacing(pattern: String, in text: String, with template: String) -> String {
        guard let regex = try? NSRegularExpression(pattern: pattern, options: []) else {
            return text
        }
        let range = NSRange(text.startIndex..<text.endIndex, in: text)
        return regex.stringByReplacingMatches(in: text, options: [], range: range, withTemplate: template)
    }
}
