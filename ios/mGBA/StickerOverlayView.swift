/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import UIKit

/**
 * Picture stickers laid over the game, in the spirit of Pizza Boy's stickers.
 * In edit mode each sticker can be dragged and pinch-scaled; otherwise the
 * view lets every touch pass through to the game and keys below.
 *
 * A sticker stores its center and width normalized to this view; its height
 * follows the image's aspect ratio. Positions are persisted per orientation
 * by the controller (`ver_` / `hor_` preference prefixes).
 */
final class StickerOverlayView: UIView {
    static let maxStickers = 10

    struct Sticker {
        var path: String
        /// Center position and width, normalized to the view.
        var x: CGFloat
        var y: CGFloat
        var w: CGFloat
        /// 0-255.
        var alpha: Int
    }

    /// Fired after an edit settled, so the controller can persist the list.
    var onStickersChanged: (() -> Void)?

    /// True while stickers can be moved; outside edit mode touches pass
    /// through to the controls.
    var editing = false {
        didSet {
            if !editing {
                dragIndex = -1
                dragTouch = nil
                pinchTouch = nil
            }
            setNeedsDisplay()
        }
    }

    private(set) var stickers: [Sticker] = []
    private var images: [String: UIImage] = [:]
    private var failed: Set<String> = []
    private var dragIndex = -1
    private var dragTouch: UITouch?
    private var pinchTouch: UITouch?
    private var grabDx: CGFloat = 0
    private var grabDy: CGFloat = 0
    private var pinchStartDistance: CGFloat = 10
    private var pinchStartW: CGFloat = 0.3

    override init(frame: CGRect) {
        super.init(frame: frame)
        isOpaque = false
        backgroundColor = .clear
        isMultipleTouchEnabled = true
        isHidden = false
    }

    required init?(coder: NSCoder) { nil }

    // MARK: - Content

    func setStickers(_ next: [Sticker]) {
        stickers = Array(next.prefix(Self.maxStickers))
        preload()
        setNeedsDisplay()
    }

    /// Adds an image at the center. False when the list is full or the file
    /// cannot be decoded.
    @discardableResult
    func addSticker(path: String) -> Bool {
        guard stickers.count < Self.maxStickers, let image = image(path) else { return false }
        var sticker = Sticker(path: path, x: 0.5, y: 0.4, w: 0.3, alpha: 255)
        // Start at roughly the image's own size, but never fill the screen.
        sticker.w = min(0.5, max(0.05, image.size.width / max(1, bounds.width) * 1.2))
        stickers.append(sticker)
        setNeedsDisplay()
        onStickersChanged?()
        return true
    }

    func clear() {
        stickers.removeAll()
        setNeedsDisplay()
        onStickersChanged?()
    }

    private func image(_ path: String) -> UIImage? {
        if let cached = images[path] { return cached }
        if failed.contains(path) { return nil }
        guard let image = UIImage(contentsOfFile: path) else {
            failed.insert(path)
            return nil
        }
        images[path] = image
        return image
    }

    private func preload() {
        for sticker in stickers {
            _ = image(sticker.path)
        }
    }

    private func box(_ sticker: Sticker, in size: CGSize) -> CGRect {
        guard let image = image(sticker.path), size.width > 0, size.height > 0 else { return .zero }
        let w = sticker.w * size.width
        let h = w * image.size.height / max(1, image.size.width)
        let cx = sticker.x * size.width
        let cy = sticker.y * size.height
        return CGRect(x: cx - w / 2, y: cy - h / 2, width: w, height: h)
    }

    // MARK: - Drawing

    override func draw(_ rect: CGRect) {
        guard let ctx = UIGraphicsGetCurrentContext() else { return }
        for (index, sticker) in stickers.enumerated() {
            guard let image = image(sticker.path) else { continue }
            let frame = box(sticker, in: bounds.size)
            guard frame.width > 0, frame.height > 0 else { continue }
            ctx.saveGState()
            ctx.setAlpha(CGFloat(min(255, max(0, sticker.alpha))) / 255)
            image.draw(in: frame)
            ctx.restoreGState()
            if editing && index == dragIndex {
                let outline = UIBezierPath(rect: frame)
                UIColor(red: 1, green: 214 / 255, blue: 64 / 255, alpha: 1).setStroke()
                outline.lineWidth = 2
                outline.stroke()
            }
        }
    }

    // MARK: - Touches

    /// Outside edit mode the overlay is transparent to touch handling.
    override func hitTest(_ point: CGPoint, with event: UIEvent?) -> UIView? {
        guard editing && !stickers.isEmpty else { return nil }
        return super.hitTest(point, with: event)
    }

    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        guard editing else { return }
        if dragTouch == nil {
            // Topmost sticker wins, matching the draw order.
            let point = touches.first?.location(in: self) ?? .zero
            for index in stickers.indices.reversed() where box(stickers[index], in: bounds.size).contains(point) {
                dragIndex = index
                break
            }
            guard dragIndex >= 0, let touch = touches.first else {
                setNeedsDisplay()
                return
            }
            dragTouch = touch
            let center = box(stickers[dragIndex], in: bounds.size)
            let point = touch.location(in: self)
            grabDx = point.x - center.midX
            grabDy = point.y - center.midY
            pinchStartW = stickers[dragIndex].w
            pinchTouch = nil
            setNeedsDisplay()
        }
        guard dragIndex >= 0, pinchTouch == nil else { return }
        for touch in touches where touch !== dragTouch {
            // The second finger starts a pinch against the dragged sticker.
            pinchTouch = touch
            pinchStartDistance = max(10, distance(dragTouch!, touch))
            pinchStartW = stickers[dragIndex].w
            break
        }
    }

    override func touchesMoved(_ touches: Set<UITouch>, with event: UIEvent?) {
        guard editing, dragIndex >= 0, let drag = dragTouch, touches.contains(where: { $0 === drag }) else { return }
        let point = drag.location(in: self)
        let w = max(1, bounds.width)
        let h = max(1, bounds.height)
        stickers[dragIndex].x = min(1, max(0, (point.x - grabDx) / w))
        stickers[dragIndex].y = min(1, max(0, (point.y - grabDy) / h))
        if let pinch = pinchTouch, pinch.phase != .ended, pinch.phase != .cancelled {
            let next = pinchStartW * max(10, distance(drag, pinch)) / max(10, pinchStartDistance)
            stickers[dragIndex].w = min(1.5, max(0.05, next))
        }
        setNeedsDisplay()
    }

    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        guard editing else { return }
        let endedDrag = dragTouch.map { drag in touches.contains(where: { $0 === drag }) } ?? false
        let endedPinch = pinchTouch.map { pinch in touches.contains(where: { $0 === pinch }) } ?? false
        if endedPinch {
            pinchTouch = nil
        }
        if endedDrag {
            dragTouch = nil
            pinchTouch = nil
            dragIndex = -1
            onStickersChanged?()
        }
        setNeedsDisplay()
    }

    override func touchesCancelled(_ touches: Set<UITouch>, with event: UIEvent?) {
        dragTouch = nil
        pinchTouch = nil
        dragIndex = -1
        setNeedsDisplay()
    }

    private func distance(_ a: UITouch, _ b: UITouch) -> CGFloat {
        let pa = a.location(in: self)
        let pb = b.location(in: self)
        return hypot(pa.x - pb.x, pa.y - pb.y)
    }
}
