/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import UIKit

/**
 * Draws the translated text blocks over the game. A tap anywhere dismisses
 * the overlay; each block picks black or white text by its backdrop's
 * brightness, like Pizza Boy's translation overlay.
 */
final class AiOverlayView: UIView {
    private var blocks: [AiTranslate.Block] = []
    private var sourceImage: UIImage?
    /// Where the game picture sits inside this overlay. Blocks are normalized
    /// to the emulator frame, so letterboxed/shell layouts must map them into
    /// this rect instead of the whole stage.
    var pictureFrame: CGRect = .zero {
        didSet {
            if pictureFrame != oldValue { setNeedsDisplay() }
        }
    }

    override init(frame: CGRect) {
        super.init(frame: frame)
        backgroundColor = .clear
        isOpaque = false
        isHidden = true
    }

    required init?(coder: NSCoder) { nil }

    func show(_ result: [AiTranslate.Block], frame: UIImage?) {
        blocks = result
        self.sourceImage = frame
        isHidden = blocks.isEmpty
        setNeedsDisplay()
    }

    func hide() {
        blocks.removeAll()
        sourceImage = nil
        isHidden = true
    }

    override func draw(_ rect: CGRect) {
        guard !blocks.isEmpty, bounds.width > 0, bounds.height > 0,
              let ctx = UIGraphicsGetCurrentContext() else { return }
        let density: CGFloat = 1
        let picture = pictureFrame.width > 0 && pictureFrame.height > 0 ? pictureFrame : bounds
        for block in blocks {
            let left = picture.minX + block.x * picture.width
            let top = picture.minY + block.y * picture.height
            let right = left + block.w * picture.width
            let bottom = top + block.h * picture.height
            guard right > left, bottom > top else { continue }
            let box = CGRect(x: left - 3 * density, y: top - 3 * density,
                             width: right - left + 6 * density,
                             height: bottom - top + 6 * density)
            guard box.width > 2, box.height > 2 else { continue }
            let brightness = sourceImage.map { AiTranslate.blockBrightness($0, block) } ?? 0
            let darkBackdrop = brightness < 128
            let panel = darkBackdrop
                ? UIColor(white: 0, alpha: 0x99 / 255)
                : UIColor(white: 1, alpha: 0x99 / 255)
            let textColor = darkBackdrop ? UIColor.white : UIColor(red: 0x11 / 255, green: 0x11 / 255, blue: 0x11 / 255, alpha: 1)
            ctx.saveGState()
            let path = UIBezierPath(roundedRect: box, cornerRadius: 4 * density)
            panel.setFill()
            path.fill()
            path.addClip()
            drawWrapped(block.text, in: box, color: textColor)
            ctx.restoreGState()
        }
    }

    private func drawWrapped(_ message: String, in box: CGRect, color: UIColor) {
        let size = max(11, box.height * 0.62)
        let paragraph = NSMutableParagraphStyle()
        paragraph.alignment = .center
        paragraph.lineBreakMode = .byWordWrapping
        let attrs: [NSAttributedString.Key: Any] = [
            .font: UIFont.systemFont(ofSize: size),
            .foregroundColor: color,
            .paragraphStyle: paragraph,
        ]
        let text = message as NSString
        let width = max(1, box.width - 4)
        let bounding = text.boundingRect(with: CGSize(width: width, height: .greatestFiniteMagnitude),
                                         options: [.usesLineFragmentOrigin, .usesFontLeading],
                                         attributes: attrs, context: nil)
        let target = CGRect(x: box.minX + 2,
                            y: box.midY - bounding.height / 2,
                            width: width,
                            height: min(bounding.height, box.height))
        text.draw(with: target, options: [.usesLineFragmentOrigin, .usesFontLeading],
                  attributes: attrs, context: nil)
    }

    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        hide()
    }
}
