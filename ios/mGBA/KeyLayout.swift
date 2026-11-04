import CoreGraphics
import Foundation

struct KeyLayout {
    static let keys = ["dpad", "a", "b", "l", "r", "select", "start", "ta", "tb", "lr", "c", "c2", "save", "load", "ff", "shot", "rewind"]
    static let minScale: CGFloat = 0.4
    static let maxScale: CGFloat = 3.0

    private var saved: [String: CGPoint] = [:]
    private var scales: [String: CGFloat] = [:]

    static func decode(_ text: String) -> KeyLayout {
        var layout = KeyLayout()
        if text.isEmpty { return layout }
        for part in text.split(separator: ";") {
            let piece = String(part)
            guard let eq = piece.firstIndex(of: "=") else { continue }
            let key = String(piece[..<eq])
            let value = String(piece[piece.index(after: eq)...])
            if key.hasSuffix(".s") {
                let base = String(key.dropLast(2))
                guard keys.contains(base), let s = Double(value.trimmingCharacters(in: .whitespaces)) else { continue }
                layout.scales[base] = clampScale(CGFloat(s))
                continue
            }
            guard keys.contains(key) else { continue }
            let fields = value.split(separator: ",")
            guard fields.count >= 2,
                  let x = Double(fields[0].trimmingCharacters(in: .whitespaces)),
                  let y = Double(fields[1].trimmingCharacters(in: .whitespaces)) else { continue }
            layout.saved[key] = CGPoint(x: CGFloat(clamp01(x)), y: CGFloat(clamp01(y)))
            if fields.count >= 3, let s = Double(fields[2].trimmingCharacters(in: .whitespaces)) {
                layout.scales[key] = clampScale(CGFloat(s))
            }
        }
        return layout
    }

    func encode() -> String {
        var parts: [String] = []
        for key in Self.keys {
            guard let point = saved[key] else { continue }
            parts.append(String(format: "%@=%.4f,%.4f", key, Double(point.x), Double(point.y)))
        }
        for key in Self.keys {
            guard let scale = scales[key], abs(scale - 1) > 0.001 else { continue }
            parts.append(String(format: "%@.s=%.3f", key, Double(scale)))
        }
        return parts.joined(separator: ";")
    }

    mutating func place(_ key: String, _ x: CGFloat, _ y: CGFloat) {
        guard Self.keys.contains(key) else { return }
        saved[key] = CGPoint(x: Self.clamp01(x), y: Self.clamp01(y))
    }

    mutating func setScale(_ key: String, _ scale: CGFloat) {
        guard Self.keys.contains(key) else { return }
        let clamped = Self.clampScale(scale)
        if abs(clamped - 1) < 0.001 {
            scales.removeValue(forKey: key)
        } else {
            scales[key] = clamped
        }
    }

    func scale(for key: String) -> CGFloat {
        scales[key] ?? 1
    }

    func resolvedScales() -> [String: CGFloat] {
        scales
    }

    mutating func resetAll() {
        saved.removeAll()
        scales.removeAll()
    }

    func resolved() -> [String: CGPoint] {
        saved
    }

    static func clamp01(_ value: CGFloat) -> CGFloat {
        min(1, max(0, value))
    }

    static func clamp01(_ value: Double) -> Double {
        min(1, max(0, value))
    }

    static func clampScale(_ value: CGFloat) -> CGFloat {
        min(maxScale, max(minScale, value))
    }

    static func clampCenter(_ center: CGFloat, _ half: CGFloat, _ span: CGFloat) -> CGFloat {
        if span <= 0 { return 0 }
        if half * 2 >= span { return span / 2 }
        if center < half { return half }
        if center > span - half { return span - half }
        return center
    }
}
