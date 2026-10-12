import CoreGraphics
import Foundation

struct KeyLayout {
    static let keys = ["dpad", "a", "b", "l", "r", "select", "start"]

    private var saved: [String: CGPoint] = [:]

    static func decode(_ text: String) -> KeyLayout {
        var layout = KeyLayout()
        if text.isEmpty { return layout }
        for part in text.split(separator: ";") {
            let piece = String(part)
            guard let eq = piece.firstIndex(of: "="), let comma = piece.firstIndex(of: ","), comma > eq else { continue }
            let key = String(piece[..<eq])
            guard keys.contains(key) else { continue }
            let xText = piece[piece.index(after: eq)..<comma]
            let yText = piece[piece.index(after: comma)...]
            guard let x = Double(xText), let y = Double(yText) else { continue }
            layout.saved[key] = CGPoint(x: CGFloat(clamp01(x)), y: CGFloat(clamp01(y)))
        }
        return layout
    }

    func encode() -> String {
        var parts: [String] = []
        for key in Self.keys {
            guard let point = saved[key] else { continue }
            parts.append(String(format: "%@=%.4f,%.4f", key, Double(point.x), Double(point.y)))
        }
        return parts.joined(separator: ";")
    }

    mutating func place(_ key: String, _ x: CGFloat, _ y: CGFloat) {
        guard Self.keys.contains(key) else { return }
        saved[key] = CGPoint(x: Self.clamp01(x), y: Self.clamp01(y))
    }

    mutating func resetAll() {
        saved.removeAll()
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

    static func clampCenter(_ center: CGFloat, _ half: CGFloat, _ span: CGFloat) -> CGFloat {
        if span <= 0 { return 0 }
        if half * 2 >= span { return span / 2 }
        if center < half { return half }
        if center > span - half { return span - half }
        return center
    }
}
