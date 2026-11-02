/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import UIKit

/**
 * Debug tools: memory viewer, cheat search and the GBA PPU viewers.
 * A Swift port of the Android `DebugViewers`.
 *
 * Everything reads the live core through the native bus API
 * (`mgbaMobileBusRead` / `mgbaMobileBusWrite` / `mgbaMobileBusReadBlock`),
 * exactly like a debugger would.
 */
enum DebugViewers {
    /// A block of memory the tools can look at.
    struct Region {
        let name: String
        let address: UInt32
        let size: Int
    }

    private static let gbaRegions: [Region] = [
        Region(name: "IWRAM", address: 0x03000000, size: 0x8000),
        Region(name: "EWRAM", address: 0x02000000, size: 0x40000),
        Region(name: "PAL", address: 0x05000000, size: 0x400),
        Region(name: "VRAM", address: 0x06000000, size: 0x18000),
        Region(name: "OAM", address: 0x07000000, size: 0x400),
        Region(name: "IO", address: 0x04000000, size: 0x400),
        Region(name: "ROM", address: 0x08000000, size: 0x2000000)
    ]

    private static let gbRegions: [Region] = [
        Region(name: "WRAM0", address: 0xC000, size: 0x1000),
        Region(name: "WRAMX", address: 0xD000, size: 0x1000),
        Region(name: "VRAM", address: 0x8000, size: 0x2000),
        Region(name: "OAM", address: 0xFE00, size: 0xA0),
        Region(name: "HRAM", address: 0xFF80, size: 0x7F)
    ]

    static func regions(_ core: OpaquePointer?) -> [Region] {
        guard let core, mgbaMobileWidth(core) == 240 else {
            return gbRegions
        }
        return gbaRegions
    }

    /// RAM regions the cheat search sweeps.
    static func searchRegions(_ core: OpaquePointer?) -> [Region] {
        regions(core).filter {
            $0.name.hasPrefix("IWRAM") || $0.name.hasPrefix("EWRAM")
                || $0.name.hasPrefix("WRAM") || $0.name.hasPrefix("HRAM")
        }
    }

    // MARK: - Hub

    /// Entry sheet listing the tools.
    static func showHub(core: OpaquePointer?, presenter: UIViewController) {
        guard let core, mgbaMobileIsLoaded(core) else {
            alert(title: "调试工具", message: "请先打开一个游戏", presenter: presenter)
            return
        }
        let gba = mgbaMobileWidth(core) == 240
        let sheet = DebugSheet(title: "调试工具")
        sheet.add(button("内存查看", action: { sheet.dismiss(); showMemory(core: core, presenter: presenter) }))
        sheet.add(button("数值搜索（金手指）", action: { sheet.dismiss(); showSearch(core: core, presenter: presenter) }))
        let bg = button("BG 图层", action: { sheet.dismiss(); showBg(core: core, presenter: presenter) })
        let oam = button("OAM 精灵", action: { sheet.dismiss(); showOam(core: core, presenter: presenter) })
        let palette = button("调色板", action: { sheet.dismiss(); showPalette(core: core, presenter: presenter) })
        if !gba {
            for item in [bg, oam, palette] {
                item.isEnabled = false
                item.alpha = 0.4
            }
        }
        sheet.add(bg)
        sheet.add(oam)
        sheet.add(palette)
        presenter.present(sheet, animated: true)
    }

    // MARK: - Memory viewer

    private static let bytesPerRow = 16
    private static let rowsPerPage = 16

    static func showMemory(core: OpaquePointer?, presenter: UIViewController) {
        guard let core, mgbaMobileIsLoaded(core) else {
            alert(title: "内存查看", message: "请先打开一个游戏", presenter: presenter)
            return
        }
        let all = regions(core)
        let sheet = DebugSheet(title: "内存查看")
        let addressLabel = UILabel()
        addressLabel.font = .monospacedDigitSystemFont(ofSize: 13, weight: .regular)
        addressLabel.textColor = UIColor(white: 0.3, alpha: 1)
        let dump = UITextView()
        dump.isEditable = false
        dump.font = .monospacedSystemFont(ofSize: 11, weight: .regular)
        dump.backgroundColor = UIColor(white: 0.96, alpha: 1)
        dump.textColor = .black
        dump.layer.cornerRadius = 6
        dump.isUserInteractionEnabled = true
        dump.translatesAutoresizingMaskIntoConstraints = false
        dump.heightAnchor.constraint(equalToConstant: 330).isActive = true

        var regionIndex = 0
        var page = 0
        var width = 32

        func refresh() {
            let region = all[regionIndex]
            let maxPage = max(0, (region.size - 1) / (bytesPerRow * rowsPerPage))
            page = min(max(page, 0), maxPage)
            let base = region.address + UInt32(page * bytesPerRow * rowsPerPage)
            var text = "\(region.name)  \(hex(base))  +0x\(String(page * bytesPerRow * rowsPerPage, radix: 16))\n"
            for row in 0..<rowsPerPage {
                let offset = page * bytesPerRow * rowsPerPage + row * bytesPerRow
                if offset >= region.size {
                    break
                }
                let count = min(bytesPerRow, region.size - offset)
                let bytes = readBlock(core, base + UInt32(offset), count)
                var hexPart = ""
                var ascii = ""
                for byte in bytes {
                    hexPart += String(format: "%02X ", byte)
                    ascii += (byte >= 32 && byte < 127) ? String(UnicodeScalar(byte)) : "."
                }
                while hexPart.count < bytesPerRow * 3 {
                    hexPart += "   "
                }
                text += "\(hex(base + UInt32(offset)))  \(hexPart) \(ascii)\n"
            }
            dump.text = text
            addressLabel.text = "\(region.name)  地址 \(hex(base))  · 宽度 \(width) 位 · 第 \(page + 1)/\(maxPage + 1) 页"
        }

        let regionRow = UIStackView()
        regionRow.axis = .horizontal
        regionRow.spacing = 4
        regionRow.distribution = .fillEqually
        for (index, region) in all.enumerated() {
            let item = button(region.name) { [weak self] in
                regionIndex = index
                page = 0
                self?.refresh()
            }
            regionRow.addArrangedSubview(item)
        }

        let widthRow = UIStackView()
        widthRow.axis = .horizontal
        widthRow.spacing = 6
        for bits in [8, 16, 32] {
            let item = button("\(bits) 位") { [weak self] in
                width = bits
                self?.refresh()
            }
            widthRow.addArrangedSubview(item)
        }

        let pageRow = UIStackView()
        pageRow.axis = .horizontal
        pageRow.spacing = 6
        pageRow.addArrangedSubview(button("上一页") { [weak self] in
            page -= 1
            self?.refresh()
        })
        pageRow.addArrangedSubview(button("下一页") { [weak self] in
            page += 1
            self?.refresh()
        })
        pageRow.addArrangedSubview(button("刷新") { [weak self] in
            self?.refresh()
        })

        sheet.add(regionRow)
        sheet.add(widthRow)
        sheet.add(addressLabel)
        sheet.add(dump)
        sheet.add(pageRow)

        // 点某一行可以改值
        let tap = UITapGestureRecognizer(target: DebugTap.shared, action: #selector(DebugTap.handle))
        DebugTap.shared.handler = { [weak self] point in
            guard let self else { return }
            let line = Int(point.y / 15)
            guard line >= 1 else { return }
            let region = all[regionIndex]
            let offset = page * bytesPerRow * rowsPerPage + (line - 1) * bytesPerRow
            guard offset >= 0, offset < region.size else { return }
            let address = region.address + UInt32(offset)
            self.editValue(core: core, presenter: presenter, address: address, width: width)
        }
        dump.addGestureRecognizer(tap)

        refresh()
        presenter.present(sheet, animated: true)
    }

    private static func editValue(core: OpaquePointer, presenter: UIViewController,
                                  address: UInt32, width: Int) {
        let current = mgbaMobileBusRead(core, Int32(width), address)
        let prompt = UIAlertController(title: "修改内存",
                                       message: "\(hex(address))\n当前值 \(hex(current))",
                                       preferredStyle: .alert)
        prompt.addTextField { field in
            field.keyboardType = .numbersAndPunctuation
            field.text = String(UInt32(current))
        }
        prompt.addAction(UIAlertAction(title: "取消", style: .cancel))
        prompt.addAction(UIAlertAction(title: "写入", style: .default) { _ in
            let text = prompt.textFields?.first?.text ?? ""
            guard let value = UInt32(text, radix: 16) ?? UInt32(text) else { return }
            _ = mgbaMobileBusWrite(core, Int32(width), address, value)
        })
        presenter.present(prompt, animated: true)
    }

    // MARK: - Cheat search

    private static let opLabels = ["=", "≠", "<", ">", "变了", "没变", "增大", "减小"]

    static func showSearch(core: OpaquePointer?, presenter: UIViewController) {
        guard let core, mgbaMobileIsLoaded(core) else {
            alert(title: "数值搜索", message: "请先打开一个游戏", presenter: presenter)
            return
        }
        struct Hit {
            let address: UInt32
            var last: UInt32
        }

        let sheet = DebugSheet(title: "数值搜索")
        let valueField = UITextField()
        valueField.placeholder = "要找的数值（十进制或 0x 开头）"
        valueField.borderStyle = .roundedRect
        valueField.keyboardType = .numbersAndPunctuation
        valueField.autocapitalizationType = .none
        valueField.heightAnchor.constraint(equalToConstant: 34).isActive = true

        var width = 8
        var op = 0
        var hits: [Hit] = []
        /// 上一轮扫描时各地址的值：「变了/没变/增大/减小」要和它比较
        var previous: [UInt32: UInt32] = [:]

        let widthRow = UIStackView()
        widthRow.axis = .horizontal
        widthRow.spacing = 6
        for bits in [8, 16, 32] {
            let item = button("\(bits) 位") { [weak self] in
                width = bits
                _ = self
            }
            widthRow.addArrangedSubview(item)
        }

        let opRow = UIStackView()
        opRow.axis = .horizontal
        opRow.spacing = 4
        opRow.distribution = .fillEqually
        for (index, label) in opLabels.enumerated() {
            let item = button(label) { [weak self] in
                op = index
                _ = self
            }
            opRow.addArrangedSubview(item)
        }

        let info = UILabel()
        info.numberOfLines = 0
        info.font = .systemFont(ofSize: 12)
        info.textColor = UIColor(white: 0.3, alpha: 1)

        let list = UIStackView()
        list.axis = .vertical
        list.spacing = 4

        func renderList() {
            list.arrangedSubviews.forEach { $0.removeFromSuperview() }
            let shown = min(hits.count, 400)
            for index in 0..<shown {
                let hit = hits[index]
                let row = UIStackView()
                row.axis = .horizontal
                row.spacing = 6
                let label = UILabel()
                label.font = .monospacedDigitSystemFont(ofSize: 12, weight: .regular)
                label.text = "\(hex(hit.address))   \(hex(mgbaMobileBusRead(core, Int32(width), hit.address)))"
                label.flexibleWidth()
                row.addArrangedSubview(label)
                row.addArrangedSubview(button("改值") { [weak self] in
                    guard let self else { return }
                    self.editValue(core: core, presenter: presenter, address: hit.address, width: width)
                })
                list.addArrangedSubview(row)
            }
            if hits.isEmpty {
                let label = UILabel()
                label.text = "没有匹配的地址"
                label.textColor = UIColor(white: 0.5, alpha: 1)
                list.addArrangedSubview(label)
            }
        }

        func scan() {
            let text = valueField.text ?? ""
            let target = parseNumber(text)
            let first = previous.isEmpty
            var found: [Hit] = []
            for region in searchRegions(core) {
                var offset = 0
                while offset + width <= region.size {
                    let address = region.address + UInt32(offset)
                    let value = mgbaMobileBusRead(core, Int32(width), address)
                    let keep: Bool
                    if first {
                        // 第一轮固定是「等于目标值」
                        keep = value == target
                    } else {
                        let old = previous[address] ?? value
                        switch op {
                        case 0: keep = value == target
                        case 1: keep = value != target
                        case 2: keep = value < target
                        case 3: keep = value > target
                        case 4: keep = value != old
                        case 5: keep = value == old
                        case 6: keep = value > old
                        default: keep = value < old
                        }
                    }
                    if keep {
                        found.append(Hit(address: address, last: value))
                        if found.count >= 20000 {
                            break
                        }
                    }
                    offset += width
                }
            }
            // 记下本轮的值，供下一轮「变了/没变/增大/减小」比较
            var next: [UInt32: UInt32] = [:]
            for hit in found {
                next[hit.address] = mgbaMobileBusRead(core, Int32(width), hit.address)
            }
            previous = next
            hits = found
            info.text = "命中 \(found.count) 个地址（最多显示 400 个）"
            renderList()
        }

        sheet.add(valueField)
        sheet.add(widthRow)
        sheet.add(opRow)
        sheet.add(button("搜索") { scan() })
        sheet.add(info)
        sheet.add(list)
        presenter.present(sheet, animated: true)
    }

    // MARK: - BG layer viewer

    static func showBg(core: OpaquePointer?, presenter: UIViewController) {
        guard let core, mgbaMobileIsLoaded(core), mgbaMobileWidth(core) == 240 else {
            alert(title: "BG 图层", message: "仅 GBA 游戏可用", presenter: presenter)
            return
        }
        let sheet = DebugSheet(title: "BG 图层")
        let info = UILabel()
        info.numberOfLines = 0
        info.font = .systemFont(ofSize: 12)
        let imageView = UIImageView()
        imageView.contentMode = .scaleAspectFit
        imageView.backgroundColor = .black
        imageView.translatesAutoresizingMaskIntoConstraints = false
        imageView.heightAnchor.constraint(equalToConstant: 320).isActive = true

        let tabs = UIStackView()
        tabs.axis = .horizontal
        tabs.spacing = 6
        for bg in 0..<4 {
            let item = button("BG\(bg)") { [weak self] in
                guard let self else { return }
                if let rendered = self.renderBg(core: core, bg: bg) {
                    imageView.image = rendered
                    info.text = "BG\(bg)  \(rendered.size.width)x\(rendered.size.height)"
                }
            }
            tabs.addArrangedSubview(item)
        }
        tabs.addArrangedSubview(button("导出") { [weak self] in
            guard let self, let image = imageView.image else { return }
            self.saveToPhotos(image, presenter: presenter)
        })
        sheet.add(tabs)
        sheet.add(info)
        sheet.add(imageView)
        if let first = renderBg(core: core, bg: 0) {
            imageView.image = first
            info.text = "BG0  \(first.size.width)x\(first.size.height)"
        }
        presenter.present(sheet, animated: true)
    }

    private static func renderBg(core: OpaquePointer, bg: Int) -> UIImage? {
        let dispcnt = Int(mgbaMobileBusRead(core, 16, 0x04000000))
        let mode = dispcnt & 7
        if mode == 3 {
            return bitmapMode(core: core, base: 0x06000000, width: 240, height: 160, bpp: 16)
        }
        if mode == 4 {
            let frame = (dispcnt & 0x10) != 0 ? 0xA000 : 0
            return bitmapMode(core: core, base: 0x06000000 + UInt32(frame), width: 240, height: 160, bpp: 8)
        }
        if mode == 5 {
            return bitmapMode(core: core, base: 0x06000000, width: 160, height: 128, bpp: 16)
        }
        let cnt = Int(mgbaMobileBusRead(core, 16, 0x04000008 + UInt32(bg * 2)))
        let affine = bg >= 2 && (mode == 2 || (mode == 1 && bg == 2))
        let charBase = ((cnt >> 2) & (affine ? 7 : 3)) * (affine ? 0x8000 : 0x4000)
        let pal256 = !affine && (cnt & 0x80) != 0
        let screenBase = ((cnt >> 8) & 31) * 0x800
        let size = (cnt >> 14) & 3
        let mapBase = 0x06000000 + UInt32(screenBase)
        let tilesBase = 0x06000000 + UInt32(charBase)
        let wTiles: Int
        let hTiles: Int
        if affine {
            wTiles = 16 << size
            hTiles = wTiles
        } else {
            wTiles = (size & 1) != 0 ? 64 : 32
            hTiles = (size & 2) != 0 ? 64 : 32
        }
        let pixelW = wTiles * 8
        let pixelH = hTiles * 8
        if pixelW > 1024 || pixelH > 1024 {
            return nil
        }
        let bpp = (affine || pal256) ? 8 : 4
        var pixels = [UInt32](repeating: 0, count: pixelW * pixelH)
        let map = readBlock(core, mapBase, affine ? wTiles * hTiles : wTiles * hTiles * 2)
        for ty in 0..<hTiles {
            for tx in 0..<wTiles {
                var tile = 0
                var palette = 0
                var hflip = false
                var vflip = false
                if affine {
                    let index = ty * wTiles + tx
                    if index < map.count {
                        tile = Int(map[index])
                    }
                } else {
                    let index = (ty * wTiles + tx) * 2
                    guard index + 1 < map.count else { continue }
                    let entry = Int(map[index]) | (Int(map[index + 1]) << 8)
                    tile = entry & 0x3FF
                    hflip = (entry & 0x400) != 0
                    vflip = (entry & 0x800) != 0
                    palette = (entry >> 12) & 15
                }
                drawTile(core: core, pixels: &pixels, outWidth: pixelW,
                         vramAddress: tilesBase + UInt32(tile * (bpp == 4 ? 32 : 64)),
                         dstX: tx * 8, dstY: ty * 8, bpp: bpp, palette: palette,
                         hflip: hflip, vflip: vflip)
            }
        }
        return image(pixels: pixels, width: pixelW, height: pixelH)
    }

    private static func drawTile(core: OpaquePointer, pixels: inout [UInt32], outWidth: Int,
                                 vramAddress: UInt32, dstX: Int, dstY: Int, bpp: Int,
                                 palette: Int, hflip: Bool, vflip: Bool) {
        for row in 0..<8 {
            for col in 0..<8 {
                let sx = hflip ? 7 - col : col
                let sy = vflip ? 7 - row : row
                var color = 0
                if bpp == 4 {
                    let address = vramAddress + UInt32(sy * 4 + (sx >> 1))
                    let byte = Int(mgbaMobileBusRead(core, 8, address))
                    let index = (sx & 1) != 0 ? (byte >> 4) : (byte & 0xF)
                    color = index == 0 ? 0 : paletteColor(core, palette * 16 + index)
                } else {
                    let index = Int(mgbaMobileBusRead(core, 8, vramAddress + UInt32(sy * 8 + sx)))
                    color = index == 0 ? 0 : paletteColor(core, index)
                }
                let px = dstX + col
                let py = dstY + row
                if px < outWidth && py * outWidth + px < pixels.count {
                    pixels[py * outWidth + px] = color == 0 ? 0xFF101010 : color
                }
            }
        }
    }

    private static func bitmapMode(core: OpaquePointer, base: UInt32, width: Int, height: Int,
                                   bpp: Int) -> UIImage? {
        let stride = bpp == 8 ? 1 : 2
        let data = readBlock(core, base, width * height * stride)
        var pixels = [UInt32](repeating: 0, count: width * height)
        for index in 0..<min(width * height, data.count / stride) {
            var rgb = 0
            if bpp == 8 {
                rgb = paletteColor(core, Int(data[index]))
            } else {
                rgb = bgr15(Int(data[index * 2]) | (Int(data[index * 2 + 1]) << 8))
            }
            pixels[index] = rgb == 0 ? 0xFF000000 : rgb
        }
        return image(pixels: pixels, width: width, height: height)
    }

    // MARK: - OAM viewer

    static func showOam(core: OpaquePointer?, presenter: UIViewController) {
        guard let core, mgbaMobileIsLoaded(core), mgbaMobileWidth(core) == 240 else {
            alert(title: "OAM 精灵", message: "仅 GBA 游戏可用", presenter: presenter)
            return
        }
        let sheet = DebugSheet(title: "OAM 精灵")
        let grid = UIStackView()
        grid.axis = .vertical
        grid.spacing = 6
        let oam = readBlock(core, 0x07000000, 0x400)
        var shown = 0
        var row = UIStackView()
        row.axis = .horizontal
        row.spacing = 6
        for index in 0..<128 {
            let base = index * 8
            guard base + 7 < oam.count else { break }
            let attr0 = Int(oam[base]) | (Int(oam[base + 1]) << 8)
            let attr1 = Int(oam[base + 2]) | (Int(oam[base + 3]) << 8)
            let attr2 = Int(oam[base + 4]) | (Int(oam[base + 5]) << 8)
            if (attr0 & 0x0200) != 0 {
                continue    // hidden sprite
            }
            let thumb = renderSprite(core: core, attr0: attr0, attr1: attr1, attr2: attr2)
            let button = UIButton(type: .system)
            button.setImage(thumb, for: .normal)
            button.backgroundColor = .black
            button.addAction(UIAction { [weak self] _ in
                guard let self else { return }
                self.spriteInfo(core: core, presenter: presenter, index: index,
                                attr0: attr0, attr1: attr1, attr2: attr2)
            }, for: .touchUpInside)
            button.widthAnchor.constraint(equalToConstant: 48).isActive = true
            button.heightAnchor.constraint(equalToConstant: 48).isActive = true
            row.addArrangedSubview(button)
            shown += 1
            if shown % 8 == 0 {
                grid.addArrangedSubview(row)
                row = UIStackView()
                row.axis = .horizontal
                row.spacing = 6
            }
        }
        if row.arrangedSubviews.count > 0 {
            grid.addArrangedSubview(row)
        }
        let info = UILabel()
        info.text = "可见精灵 \(shown) 个"
        info.font = .systemFont(ofSize: 12)
        sheet.add(info)
        sheet.add(grid)
        sheet.add(button("导出精灵表") { [weak self] in
            guard let self else { return }
            if let sheet = self.oamSheet(core: core) {
                self.saveToPhotos(sheet, presenter: presenter)
            }
        })
        presenter.present(sheet, animated: true)
    }

    private static func spriteDims(attr0: Int, attr1: Int) -> (Int, Int) {
        let shape = (attr0 >> 14) & 3
        let size = (attr1 >> 14) & 3
        let width: Int
        let height: Int
        switch shape {
        case 0:
            width = 8; height = 8
        case 1:
            width = 16; height = 16
        case 2:
            width = 8; height = 16
        default:
            width = 16; height = 8
        }
        switch size {
        case 1: break
        case 2: width *= 2; height *= 2
        case 3: width *= 4; height *= 4
        default: break
        }
        return (width, height)
    }

    /// Renders one sprite from VRAM/OAM (transparent where empty).
    private static func renderSprite(core: OpaquePointer, attr0: Int, attr1: Int, attr2: Int) -> UIImage? {
        let dims = spriteDims(attr0: attr0, attr1: attr1)
        let width = dims.0
        let height = dims.1
        let tileIndex = attr2 & 0x03FF
        let tileBase = 0x06000000 + UInt32(tileIndex * 32)
        let palette = (attr2 >> 12) & 15
        let hflip = (attr1 & 0x1000) != 0
        let vflip = (attr1 & 0x2000) != 0
        let sizeFlag = (attr1 >> 14) & 3
        var pixels = [UInt32](repeating: 0, count: width * height)
        for py in 0..<height {
            for px in 0..<width {
                let tx = px / 8
                let ty = py / 8
                let inside = px % 8
                let row = ty * 8 + inside
                let tileOffset = tileBase + UInt32((sizeFlag == 1 ? 32 : 0) * tx + row * 4)
                let byte = Int(mgbaMobileBusRead(core, 8, tileOffset + UInt32(inside >> 1)))
                let index = (inside & 1) != 0 ? (byte >> 4) : (byte & 0xF)
                if index == 0 {
                    continue
                }
                let color = paletteColor(core, palette * 16 + index)
                let sx = hflip ? width - 1 - px : px
                let sy = vflip ? height - 1 - py : py
                if sy * width + sx < pixels.count {
                    pixels[sy * width + sx] = color
                }
            }
        }
        return image(pixels: pixels, width: width, height: height)
    }

    private static func spriteInfo(core: OpaquePointer, presenter: UIViewController, index: Int,
                                   attr0: Int, attr1: Int, attr2: Int) {
        let dims = spriteDims(attr0: attr0, attr1: attr1)
        let message = "尺寸 \(dims.0)x\(dims.1)\n"
            + "X \(attr1 & 0x1FF)  Y \(attr0 & 0xFF)\n"
            + "图块 \(attr2 & 0x3FF)  调色板 \((attr2 >> 12) & 15)\n"
            + "地址 \(hex(0x07000000 + UInt32(index * 8)))"
        alert(title: "精灵 #\(index)", message: message, presenter: presenter)
    }

    // MARK: - Palette viewer

    static func showPalette(core: OpaquePointer?, presenter: UIViewController) {
        guard let core, mgbaMobileIsLoaded(core), mgbaMobileWidth(core) == 240 else {
            alert(title: "调色板", message: "仅 GBA 游戏可用", presenter: presenter)
            return
        }
        let sheet = DebugSheet(title: "调色板")
        sheet.add(label("背景调色板"))
        sheet.add(paletteGrid(core: core, base: 0x05000000, title: "背景", presenter: presenter))
        sheet.add(label("对象调色板"))
        sheet.add(paletteGrid(core: core, base: 0x05000400, title: "对象", presenter: presenter))
        sheet.add(button("导出调色板") { [weak self] in
            guard let self else { return }
            if let sheet = self.paletteSheet(core: core) {
                self.saveToPhotos(sheet, presenter: presenter)
            }
        })
        presenter.present(sheet, animated: true)
    }

    private static func paletteGrid(core: OpaquePointer, base: UInt32, title: String,
                                     presenter: UIViewController) -> UIStackView {
        let grid = UIStackView()
        grid.axis = .vertical
        grid.spacing = 2
        let data = readBlock(core, base, 512)
        for row in 0..<16 {
            let line = UIStackView()
            line.axis = .horizontal
            line.spacing = 2
            for col in 0..<16 {
                let index = row * 16 + col
                let value = index * 2 + 1 < data.count
                    ? (Int(data[index * 2]) | (Int(data[index * 2 + 1]) << 8))
                    : 0
                let swatch = UIButton(type: .system)
                swatch.backgroundColor = value == 0 ? .black : UIColor(rgb: bgr15(value))
                swatch.setTitle(String(index), for: .normal)
                swatch.titleLabel?.font = .systemFont(ofSize: 7)
                swatch.titleLabel?.textColor = UIColor(white: 0.7, alpha: 1)
                swatch.addAction(UIAction { _ in
                    let rgb = bgr15(value)
                    alert(title: "\(title)调色板 #\(index)",
                          message: "R \(rgb >> 16 & 0xFF)  G \(rgb >> 8 & 0xFF)  B \(rgb & 0xFF)\n"
                            + "地址 \(hex(base + UInt32(index * 2)))",
                          presenter: presenter)
                }, for: .touchUpInside)
                swatch.widthAnchor.constraint(equalToConstant: 24).isActive = true
                swatch.heightAnchor.constraint(equalToConstant: 24).isActive = true
                line.addArrangedSubview(swatch)
            }
            grid.addArrangedSubview(line)
        }
        return grid
    }

    // MARK: - Export

    /// Contact sheet of every visible sprite.
    private static func oamSheet(core: OpaquePointer) -> UIImage? {
        let oam = readBlock(core, 0x07000000, 0x400)
        let cell = 64
        let columns = 8
        var sprites: [[UInt32]] = []
        var sizes: [(Int, Int)] = []
        for index in 0..<128 {
            let base = index * 8
            guard base + 7 < oam.count else { break }
            let attr0 = Int(oam[base]) | (Int(oam[base + 1]) << 8)
            let attr1 = Int(oam[base + 2]) | (Int(oam[base + 3]) << 8)
            let attr2 = Int(oam[base + 4]) | (Int(oam[base + 5]) << 8)
            if (attr0 & 0x0200) != 0 {
                continue
            }
            guard let rendered = renderSprite(core: core, attr0: attr0, attr1: attr1, attr2: attr2),
                  let pixels = pixelsOf(rendered) else {
                continue
            }
            sprites.append(pixels.pixels)
            sizes.append(pixels.size)
        }
        guard !sprites.isEmpty else {
            return nil
        }
        let rows = (sprites.count + columns - 1) / columns
        var canvas = [UInt32](repeating: 0xFF303030, count: cell * columns * cell * rows)
        for (index, pixels) in sprites.enumerated() {
            let size = sizes[index]
            let column = index % columns
            let row = index / columns
            let originX = column * cell
            let originY = row * cell
            for y in 0..<min(size.1, cell) {
                for x in 0..<min(size.0, cell) {
                    let source = y * size.0 + x
                    guard source < pixels.count else { continue }
                    let color = pixels[source]
                    if color == 0 {
                        continue
                    }
                    let target = (originY + y) * (cell * columns) + originX + x
                    if target < canvas.count {
                        canvas[target] = color
                    }
                }
            }
        }
        return image(pixels: canvas, width: cell * columns, height: cell * rows)
    }

    /// Both palette banks on one sheet.
    private static func paletteSheet(core: OpaquePointer) -> UIImage? {
        let cell = 24
        let width = 16 * cell
        let height = 32 * cell + 16
        var canvas = [UInt32](repeating: 0xFF202020, count: width * height)
        let data = readBlock(core, 0x05000000, 512)
        for bank in 0..<2 {
            for index in 0..<256 {
                let position = bank * 256 + index
                guard position * 2 + 1 < data.count else { continue }
                let value = Int(data[position * 2]) | (Int(data[position * 2 + 1]) << 8)
                let color: UInt32 = value == 0 ? 0xFF000000 : UInt32(bitPattern: bgr15(value))
                let x = (index % 16) * cell + 1
                let y = bank * (16 * cell + 16) + (index / 16) * cell + 1
                for dy in 0..<(cell - 2) {
                    for dx in 0..<(cell - 2) {
                        let target = (y + dy) * width + x + dx
                        if target < canvas.count {
                            canvas[target] = color
                        }
                    }
                }
            }
        }
        return image(pixels: canvas, width: width, height: height)
    }

    /// Reads the pixels back out of a rendered image.
    private static func pixelsOf(_ image: UIImage) -> (pixels: [UInt32], size: (Int, Int))? {
        guard let cg = image.cgImage else {
            return nil
        }
        let width = cg.width
        let height = cg.height
        var pixels = [UInt32](repeating: 0, count: width * height)
        let space = CGColorSpaceCreateDeviceRGB()
        let context = CGContext(data: &pixels, width: width, height: height,
                                bitsPerComponent: 8, bitsPerPixel: 32, bytesPerRow: width * 4,
                                space: space,
                                bitmapInfo: CGImageAlphaInfo.premultipliedLast.rawValue)
        guard let context else {
            return nil
        }
        context.draw(cg, in: CGRect(x: 0, y: 0, width: width, height: height))
        return (pixels, (width, height))
    }

    /// Saves a picture into the photo library.
    private static func saveToPhotos(_ image: UIImage, presenter: UIViewController) {
        UIImageWriteToSavedPhotosAlbum(image, nil, nil, nil)
        alert(title: "已导出", message: "图片已保存到相册", presenter: presenter)
    }

    // MARK: - Helpers

    private static func readBlock(_ core: OpaquePointer, _ address: UInt32, _ size: Int) -> [UInt8] {
        if size <= 0 {
            return []
        }
        var buffer = [UInt8](repeating: 0, count: size)
        let read = buffer.withUnsafeMutableBytes { raw -> Int in
            guard let base = raw.baseAddress else {
                return 0
            }
            return mgbaMobileBusReadBlock(core, address, Int32(size),
                                          base.assumingMemoryBound(to: UInt8.self))
        }
        guard read > 0 else {
            return []
        }
        return Array(buffer[0..<min(read, buffer.count)])
    }

    /// BGR555 to 0xAARRGGBB.
    private static func bgr15(_ value: Int) -> Int {
        let r = (value & 31) << 3
        let g = ((value >> 5) & 31) << 3
        let b = ((value >> 10) & 31) << 3
        return 0xFF000000 | (r | (r >> 5)) << 16 | (g | (g >> 5)) << 8 | (b | (b >> 5))
    }

    private static func paletteColor(_ core: OpaquePointer, _ index: Int) -> Int {
        bgr15(Int(mgbaMobileBusRead(core, 16, 0x05000000 + UInt32(index * 2))))
    }

    private static func parseNumber(_ text: String) -> UInt32 {
        let trimmed = text.trimmingCharacters(in: .whitespaces)
        if trimmed.hasPrefix("0x") || trimmed.hasPrefix("0X") {
            return UInt32(trimmed.dropFirst(2), radix: 16) ?? 0
        }
        return UInt32(trimmed, radix: 10) ?? 0
    }

    private static func hex(_ value: UInt32) -> String {
        String(format: "0x%08X", value)
    }

    private static func image(pixels: [UInt32], width: Int, height: Int) -> UIImage? {
        guard width > 0, height > 0, pixels.count == width * height else {
            return nil
        }
        var data = Data(capacity: width * height * 4)
        for pixel in pixels {
            data.append(UInt8((pixel >> 16) & 0xFF))
            data.append(UInt8((pixel >> 8) & 0xFF))
            data.append(UInt8(pixel & 0xFF))
            data.append(UInt8((pixel >> 24) & 0xFF))
        }
        guard let provider = CGDataProvider(data: data as CFData),
              let cgImage = CGImage(dataProvider: provider, width: width, height: height,
                                    bitsPerComponent: 8, bitsPerPixel: 32, bytesPerRow: width * 4,
                                    space: CGColorSpaceCreateDeviceRGB(),
                                    bitmapInfo: CGBitmapInfo(rawValue:
                                        CGImageAlphaInfo.premultipliedLast.rawValue)) else {
            return nil
        }
        return UIImage(cgImage: cgImage)
    }

    private static func alert(title: String, message: String, presenter: UIViewController) {
        let controller = UIAlertController(title: title, message: message, preferredStyle: .alert)
        controller.addAction(UIAlertAction(title: "好", style: .default))
        presenter.present(controller, animated: true)
    }

    private static func button(_ title: String, action: @escaping () -> Void) -> UIButton {
        let item = UIButton(type: .system)
        item.setTitle(title, for: .normal)
        item.titleLabel?.font = .systemFont(ofSize: 13)
        item.layer.cornerRadius = 6
        item.layer.borderWidth = 1
        item.layer.borderColor = UIColor(white: 0.75, alpha: 1).cgColor
        item.addAction(UIAction { _ in action() }, for: .touchUpInside)
        return item
    }

    private static func label(_ text: String) -> UILabel {
        let item = UILabel()
        item.text = text
        item.font = .systemFont(ofSize: 13, weight: .semibold)
        return item
    }
}

// MARK: - Sheet

/// A simple scrollable sheet used by the debug tools.
final class DebugSheet: UIViewController {
    private let heading: String
    private let stack = UIStackView()

    init(title: String) {
        heading = title
        super.init(nibName: nil, bundle: nil)
        modalPresentationStyle = .pageSheet
    }

    required init?(coder: NSCoder) { nil }

    func add(_ view: UIView) {
        stack.addArrangedSubview(view)
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .systemBackground
        let titleLabel = UILabel()
        titleLabel.text = heading
        titleLabel.font = .boldSystemFont(ofSize: 18)
        let close = UIButton(type: .system)
        close.setTitle("关闭", for: .normal)
        close.addAction(UIAction { [weak self] _ in self?.dismiss(animated: true) }, for: .touchUpInside)
        let scroll = UIScrollView()
        stack.axis = .vertical
        stack.spacing = 8
        stack.alignment = .fill
        for item in [titleLabel, scroll, close, stack] {
            item.translatesAutoresizingMaskIntoConstraints = false
        }
        view.addSubview(titleLabel)
        view.addSubview(close)
        view.addSubview(scroll)
        scroll.addSubview(stack)
        NSLayoutConstraint.activate([
            titleLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 16),
            titleLabel.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 16),
            close.centerYAnchor.constraint(equalTo: titleLabel.centerYAnchor),
            close.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -16),
            scroll.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: 12),
            scroll.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            scroll.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            scroll.bottomAnchor.constraint(equalTo: close.topAnchor, constant: -8),
            stack.topAnchor.constraint(equalTo: scroll.topAnchor, constant: 8),
            stack.bottomAnchor.constraint(equalTo: scroll.bottomAnchor, constant: -8),
            stack.leadingAnchor.constraint(equalTo: scroll.leadingAnchor, constant: 16),
            stack.trailingAnchor.constraint(equalTo: scroll.trailingAnchor, constant: -16),
            stack.widthAnchor.constraint(equalTo: scroll.widthAnchor, constant: -32)
        ])
    }
}

/// Routes taps on a text view to the memory viewer.
final class DebugTap: NSObject {
    static let shared = DebugTap()
    var handler: ((CGPoint) -> Void)?

    @objc func handle(_ gesture: UITapGestureRecognizer) {
        guard let view = gesture.view else { return }
        handler?(gesture.location(in: view))
    }
}

private extension UILabel {
    func flexibleWidth() {
        setContentCompressionResistancePriority(.defaultLow, for: .horizontal)
    }
}

private extension UIColor {
    convenience init(rgb: Int) {
        self.init(red: CGFloat((rgb >> 16) & 0xFF) / 255.0,
                  green: CGFloat((rgb >> 8) & 0xFF) / 255.0,
                  blue: CGFloat(rgb & 0xFF) / 255.0,
                  alpha: CGFloat((rgb >> 24) & 0xFF) / 255.0)
    }
}
