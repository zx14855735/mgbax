import Darwin
import GameController
import UIKit
import UniformTypeIdentifiers

final class EmulatorViewController: UIViewController, UIDocumentPickerDelegate {
    private let defaults = UserDefaults.standard
    private let docs = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)[0]
    private var core: OpaquePointer?
    private let gameView = GameView()
    private let controls = ControlsView()
    private let hint = UILabel()
    private let fpsView = UILabel()
    private let savePathView = UILabel()
    private var pauseButton: UIButton!
    private var fastButton: UIButton!
    private var slotButton: UIButton!
    private let speedBar = UIScrollView()
    private var speedButtons: [UIButton] = []
    private var speedBarHeight: NSLayoutConstraint!
    private let gate = NSCondition()
    private var running = false
    private var paused = false
    private var speed = 1
    private var fastHold = false
    private var portrait = false
    private var touchKeys = 0
    private var hwKeys = 0
    private var padKeys = 0
    private var turboB = false
    private var slot = 1
    private var pendingPath: String?
    private var command = 0
    private let stopped = DispatchSemaphore(value: 0)
    private let audio = AudioOut()
    private var presentQueued = false
    private var remote: RemoteLink?
    private var linkStatusLabel: UILabel?
    private var linkRoomField: UITextField?
    private var lastLinkState = -1
    private var armWork: DispatchWorkItem?
    private var pulseWork: DispatchWorkItem?
    private var linkWatch: DispatchWorkItem?
    private var pickerKind = 0
    private let cmdSave = 1
    private let cmdLoad = 2
    private let cmdReset = 3
    private let layoutBar = UIView()
    private var keyLayout = KeyLayout()
    private var layoutEditing = false

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .black
        let savedSpeed = defaults.integer(forKey: "speed")
        speed = (1...16).contains(savedSpeed) ? savedSpeed : 1
        portrait = defaults.string(forKey: "orientation") == "portrait"
        buildChrome()
        let saves = docs.appendingPathComponent("saves").path
        let states = docs.appendingPathComponent("states").path
        core = mgbaMobileCreate(saves, states, "ios")
        controls.onKeysChanged = { [weak self] mask in
            guard let self else { return }
            let prev = self.touchKeys
            self.touchKeys = mask
            self.noteUserKeys(prevTouch: prev, prevHw: self.hwKeys, prevPad: self.padKeys)
            if (mask & ~prev) != 0 { self.wakeInput() }
        }
        keyLayout = KeyLayout.decode(defaults.string(forKey: "key_layout") ?? "")
        controls.setCenters(keyLayout.resolved())
        controls.onCursorMoved = { [weak self] key, x, y in
            guard let self else { return }
            self.keyLayout.place(key, x, y)
            self.controls.setCenters(self.keyLayout.resolved())
        }
        controls.onCursorStopped = { [weak self] key, x, y in
            guard let self else { return }
            self.keyLayout.place(key, x, y)
            self.controls.setCenters(self.keyLayout.resolved())
            self.defaults.set(self.keyLayout.encode(), forKey: "key_layout")
        }
        if let last = defaults.string(forKey: "lastRom"), FileManager.default.fileExists(atPath: last) {
            gate.lock()
            pendingPath = last
            gate.unlock()
        }
        running = true
        let thread = Thread(target: self, selector: #selector(emulationLoop), object: nil)
        thread.name = "mGBA"
        thread.qualityOfService = .userInteractive
        thread.start()
        NotificationCenter.default.addObserver(self, selector: #selector(bindControllers), name: .GCControllerDidConnect, object: nil)
        bindControllers()
        applyVideo()
    }

    override var prefersStatusBarHidden: Bool { true }
    override var prefersHomeIndicatorAutoHidden: Bool { true }
    override var shouldAutorotate: Bool { true }
    override var supportedInterfaceOrientations: UIInterfaceOrientationMask { portrait ? .portrait : .landscape }
    override var preferredInterfaceOrientationForPresentation: UIInterfaceOrientation { portrait ? .portrait : .landscapeRight }

    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        applyOrientation()
    }

    private func buildChrome() {
        let bar = UIScrollView()
        bar.backgroundColor = UIColor(white: 22 / 255, alpha: 1)
        bar.showsHorizontalScrollIndicator = false
        let stack = UIStackView()
        stack.axis = .horizontal
        stack.spacing = 6
        bar.addSubview(stack)
        let titles: [(String, Selector)] = [
            ("打开", #selector(openRom)),
            ("暂停", #selector(togglePause)),
            ("1倍", #selector(toggleSpeedBar)),
            ("复位", #selector(resetGame)),
            ("槽位 1", #selector(cycleSlot)),
            ("存档", #selector(saveState)),
            ("读档", #selector(loadState)),
            ("BIOS", #selector(openBios)),
            ("画质", #selector(showVideo)),
            ("联机", #selector(showLink)),
            ("键位", #selector(toggleLayout)),
            ("设置", #selector(showSettings))
        ]
        for (index, item) in titles.enumerated() {
            let button = UIButton(type: .system)
            button.setTitle(item.0, for: .normal)
            button.setTitleColor(.white, for: .normal)
            button.titleLabel?.font = .systemFont(ofSize: 15)
            button.contentEdgeInsets = UIEdgeInsets(top: 6, left: 10, bottom: 6, right: 10)
            button.addTarget(self, action: item.1, for: .touchUpInside)
            stack.addArrangedSubview(button)
            if index == 1 { pauseButton = button }
            if index == 2 {
                fastButton = button
                button.setTitle("\(speed)倍", for: .normal)
            }
            if index == 4 { slotButton = button }
        }
        fpsView.textColor = UIColor(red: 156 / 255, green: 204 / 255, blue: 156 / 255, alpha: 1)
        fpsView.font = .systemFont(ofSize: 12)
        stack.addArrangedSubview(fpsView)
        speedBar.backgroundColor = UIColor(red: 16 / 255, green: 24 / 255, blue: 16 / 255, alpha: 1)
        speedBar.showsHorizontalScrollIndicator = false
        speedBar.isHidden = true
        let speedStack = UIStackView()
        speedStack.axis = .horizontal
        speedStack.spacing = 4
        speedStack.alignment = .center
        speedStack.translatesAutoresizingMaskIntoConstraints = false
        speedBar.addSubview(speedStack)
        let speedLabel = UILabel()
        speedLabel.text = "倍速"
        speedLabel.textColor = .white
        speedLabel.font = .systemFont(ofSize: 13)
        speedStack.addArrangedSubview(speedLabel)
        for value in 1...16 {
            let button = UIButton(type: .system)
            button.setTitle("\(value)", for: .normal)
            button.titleLabel?.font = .systemFont(ofSize: 15, weight: .semibold)
            button.contentEdgeInsets = UIEdgeInsets(top: 4, left: 10, bottom: 4, right: 10)
            button.layer.cornerRadius = 6
            button.tag = value
            button.addTarget(self, action: #selector(pickSpeed(_:)), for: .touchUpInside)
            speedStack.addArrangedSubview(button)
            speedButtons.append(button)
        }
        refreshSpeedButtons()
        savePathView.textColor = UIColor(red: 183 / 255, green: 227 / 255, blue: 183 / 255, alpha: 1)
        savePathView.font = .systemFont(ofSize: 12)
        savePathView.numberOfLines = 3
        savePathView.isHidden = true
        savePathView.isUserInteractionEnabled = true
        savePathView.addGestureRecognizer(UITapGestureRecognizer(target: self, action: #selector(copySavePath)))
        hint.text = "点击「打开」选择 .gba、.gbc、.gb 或 .zip 游戏。打开后上方会显示 ROM 存档位置。"
        hint.textColor = UIColor(white: 0.87, alpha: 1)
        hint.numberOfLines = 0
        hint.textAlignment = .center
        let stage = UIView()
        stage.addSubview(gameView)
        stage.addSubview(hint)
        stage.addSubview(controls)
        buildLayoutBar()
        stage.addSubview(layoutBar)
        for item in [bar, stack, speedBar, savePathView, stage, gameView, hint, controls, layoutBar] {
            item.translatesAutoresizingMaskIntoConstraints = false
        }
        view.addSubview(bar)
        view.addSubview(speedBar)
        view.addSubview(savePathView)
        view.addSubview(stage)
        speedBarHeight = speedBar.heightAnchor.constraint(equalToConstant: 0)
        NSLayoutConstraint.activate([
            bar.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            bar.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            bar.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            bar.heightAnchor.constraint(equalToConstant: 44),
            stack.topAnchor.constraint(equalTo: bar.topAnchor),
            stack.bottomAnchor.constraint(equalTo: bar.bottomAnchor),
            stack.leadingAnchor.constraint(equalTo: bar.leadingAnchor, constant: 4),
            stack.trailingAnchor.constraint(equalTo: bar.trailingAnchor, constant: -4),
            stack.heightAnchor.constraint(equalTo: bar.heightAnchor),
            speedBar.topAnchor.constraint(equalTo: bar.bottomAnchor),
            speedBar.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            speedBar.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            speedBarHeight,
            speedStack.topAnchor.constraint(equalTo: speedBar.contentLayoutGuide.topAnchor),
            speedStack.bottomAnchor.constraint(equalTo: speedBar.contentLayoutGuide.bottomAnchor),
            speedStack.leadingAnchor.constraint(equalTo: speedBar.contentLayoutGuide.leadingAnchor, constant: 4),
            speedStack.trailingAnchor.constraint(equalTo: speedBar.contentLayoutGuide.trailingAnchor, constant: -4),
            speedStack.heightAnchor.constraint(equalTo: speedBar.frameLayoutGuide.heightAnchor),
            savePathView.topAnchor.constraint(equalTo: speedBar.bottomAnchor),
            savePathView.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 8),
            savePathView.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -8),
            stage.topAnchor.constraint(equalTo: savePathView.bottomAnchor),
            stage.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            stage.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            stage.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            gameView.topAnchor.constraint(equalTo: stage.topAnchor),
            gameView.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            gameView.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            gameView.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            hint.centerXAnchor.constraint(equalTo: stage.centerXAnchor),
            hint.centerYAnchor.constraint(equalTo: stage.centerYAnchor),
            hint.leadingAnchor.constraint(greaterThanOrEqualTo: stage.leadingAnchor, constant: 24),
            hint.trailingAnchor.constraint(lessThanOrEqualTo: stage.trailingAnchor, constant: -24),
            controls.topAnchor.constraint(equalTo: stage.topAnchor),
            controls.bottomAnchor.constraint(equalTo: stage.bottomAnchor),
            controls.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            controls.trailingAnchor.constraint(equalTo: stage.trailingAnchor),
            layoutBar.topAnchor.constraint(equalTo: stage.topAnchor),
            layoutBar.leadingAnchor.constraint(equalTo: stage.leadingAnchor),
            layoutBar.trailingAnchor.constraint(equalTo: stage.trailingAnchor)
        ])
    }

    private func buildLayoutBar() {
        layoutBar.backgroundColor = UIColor(red: 16 / 255, green: 24 / 255, blue: 16 / 255, alpha: 0.92)
        layoutBar.isHidden = true
        let hintLabel = UILabel()
        hintLabel.text = "直接拖动按键到想要的位置，松手即保存"
        hintLabel.textColor = UIColor(red: 246 / 255, green: 231 / 255, blue: 168 / 255, alpha: 1)
        hintLabel.font = .systemFont(ofSize: 12)
        hintLabel.numberOfLines = 2
        let reset = UIButton(type: .system)
        reset.setTitle("重置", for: .normal)
        reset.setTitleColor(.white, for: .normal)
        reset.titleLabel?.font = .systemFont(ofSize: 15)
        reset.addTarget(self, action: #selector(resetLayout), for: .touchUpInside)
        let done = UIButton(type: .system)
        done.setTitle("完成", for: .normal)
        done.setTitleColor(.white, for: .normal)
        done.titleLabel?.font = .systemFont(ofSize: 15)
        done.addTarget(self, action: #selector(finishLayout), for: .touchUpInside)
        let row = UIStackView(arrangedSubviews: [hintLabel, reset, done])
        row.axis = .horizontal
        row.spacing = 8
        row.alignment = .center
        row.translatesAutoresizingMaskIntoConstraints = false
        layoutBar.addSubview(row)
        NSLayoutConstraint.activate([
            row.topAnchor.constraint(equalTo: layoutBar.topAnchor, constant: 6),
            row.bottomAnchor.constraint(equalTo: layoutBar.bottomAnchor, constant: -6),
            row.leadingAnchor.constraint(equalTo: layoutBar.leadingAnchor, constant: 8),
            row.trailingAnchor.constraint(equalTo: layoutBar.trailingAnchor, constant: -8)
        ])
    }

    @objc private func toggleLayout() {
        layoutEditing.toggle()
        layoutBar.isHidden = !layoutEditing
        controls.editing = layoutEditing
    }

    @objc private func finishLayout() {
        layoutEditing = false
        layoutBar.isHidden = true
        controls.editing = false
    }

    @objc private func resetLayout() {
        keyLayout.resetAll()
        defaults.set(keyLayout.encode(), forKey: "key_layout")
        controls.setCenters([:])
        toast("已恢复默认键位")
    }

    @objc private func emulationLoop() {
        var frames: Int64 = 0
        var fpsStamp = DispatchTime.now().uptimeNanoseconds
        var nextFastPresent: UInt64 = 0
        let audioIn = UnsafeMutablePointer<Int16>.allocate(capacity: 8192 * 2)
        var video: UnsafeMutablePointer<UInt32>?
        var videoCap = 0
        defer {
            audioIn.deallocate()
            video?.deallocate()
        }
        while running {
            guard let core else { continue }
            mgbaMobilePumpLink(core)
            gate.lock()
            let path = pendingPath
            pendingPath = nil
            let cmd = command
            command = 0
            let isPaused = paused
            let mult = fastHold ? max(speed, 16) : speed
            gate.unlock()
            if let path { loadRom(path) }
            if cmd != 0 { runCommand(cmd) }
            if isPaused || !mgbaMobileIsLoaded(core) {
                gate.lock()
                let until = Date(timeIntervalSinceNow: 0.016)
                gate.wait(until: until)
                gate.unlock()
                continue
            }
            let slice = DispatchTime.now().uptimeNanoseconds
            audio.setFast(mult > 1)
            _ = mgbaMobileRunFrames(core, Int32(mult))
            if mult == 1 {
                let got = mgbaMobileReadAudio(core, audioIn, 8192)
                if got > 0 { audio.pump(samples: audioIn, frames: Int(got)) }
                present(core, &video, &videoCap)
            } else {
                let now = DispatchTime.now().uptimeNanoseconds
                if now >= nextFastPresent {
                    present(core, &video, &videoCap)
                    nextFastPresent = now + 80_000_000
                }
            }
            frames += Int64(mult)
            let remain = 1_000_000_000 / 60 - Int64(DispatchTime.now().uptimeNanoseconds - slice)
            if remain > 1_000_000 {
                gate.lock()
                gate.wait(until: Date(timeIntervalSinceNow: Double(remain) / 1_000_000_000))
                gate.unlock()
            }
            let now = DispatchTime.now().uptimeNanoseconds
            if now &- fpsStamp >= 1_000_000_000 {
                let shown = frames
                let shownSpeed = mult
                frames = 0
                fpsStamp = now
                DispatchQueue.main.async { [weak self] in
                    self?.fpsView.text = "\(shownSpeed)倍 \(shown)fps"
                }
            }
        }
        stopped.signal()
    }

    private func present(_ core: OpaquePointer, _ video: inout UnsafeMutablePointer<UInt32>?, _ cap: inout Int) {
        let w = Int(mgbaMobileWidth(core))
        let h = Int(mgbaMobileHeight(core))
        if w <= 0 || h <= 0 { return }
        if cap < w * h {
            video?.deallocate()
            video = UnsafeMutablePointer<UInt32>.allocate(capacity: w * h)
            cap = w * h
        }
        guard let video, mgbaMobileCopyVideo(core, video, Int32(w)) else { return }
        if presentQueued { return }
        presentQueued = true
        let data = Data(bytes: video, count: w * h * 4)
        DispatchQueue.main.async { [weak self] in
            guard let self else { return }
            data.withUnsafeBytes { raw in
                if let base = raw.bindMemory(to: UInt32.self).baseAddress {
                    self.gameView.present(pixels: base, width: w, height: h, stride: w)
                }
            }
            self.presentQueued = false
        }
    }

    private func loadRom(_ path: String) {
        guard let core else { return }
        audio.stop()
        let ok = mgbaMobileLoad(core, path)
        if !ok {
            DispatchQueue.main.async { [weak self] in
                self?.hint.isHidden = false
                self?.hint.text = "无法加载这个游戏"
                self?.toast("无法加载这个游戏")
            }
            return
        }
        var title = [CChar](repeating: 0, count: 32)
        mgbaMobileTitle(core, &title, 32)
        let name = String(cString: title).trimmingCharacters(in: .whitespaces)
        let rate = Int(mgbaMobileSampleRate(core))
        audio.start(sourceRate: rate)
        gate.lock()
        paused = false
        gate.unlock()
        DispatchQueue.main.async { [weak self] in
            guard let self else { return }
            self.hint.isHidden = true
            self.pauseButton.setTitle("暂停", for: .normal)
            self.title = name.isEmpty ? "mGBA" : name
            self.showSaveLocation()
            self.refreshSlotButton()
        }
    }

    private func runCommand(_ cmd: Int) {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        let current = slot
        if cmd == cmdSave {
            let ok = mgbaMobileSaveState(core, Int32(current))
            if ok { writePreview(current) }
            toast(ok ? "已保存即时存档 \(current)" : "即时存档失败")
            DispatchQueue.main.async { self.refreshSlotButton() }
        } else if cmd == cmdLoad {
            let ok = mgbaMobileLoadState(core, Int32(current))
            mgbaMobileClearAudio(core)
            if ok {
                _ = mgbaMobileRunFrames(core, 1)
            }
            toast(ok ? "已读取即时存档 \(current)" : "没有即时存档 \(current)")
            DispatchQueue.main.async { self.refreshSlotButton() }
        } else if cmd == cmdReset {
            mgbaMobileReset(core)
            mgbaMobileClearAudio(core)
            toast("已复位")
        }
    }

    private func noteUserKeys(prevTouch: Int, prevHw: Int, prevPad: Int) {
        let wasB = ((prevTouch | prevHw | prevPad) & ControlsView.B) != 0
        let nowB = ((touchKeys | hwKeys | padKeys) & ControlsView.B) != 0
        if nowB && !wasB {
            armWork?.cancel()
            let work = DispatchWorkItem { [weak self] in self?.armTurbo() }
            armWork = work
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.2, execute: work)
        } else if !nowB && wasB {
            armWork?.cancel()
            stopTurbo()
        }
        publishKeys()
    }

    private func publishKeys() {
        guard let core else { return }
        var mask = touchKeys | hwKeys | padKeys
        if turboB { mask &= ~ControlsView.B }
        mgbaMobileSetKeys(core, UInt32(mask))
    }

    private func armTurbo() {
        if ((touchKeys | hwKeys | padKeys) & ControlsView.B) == 0 || turboB { return }
        turboB = true
        publishKeys()
        if let core { mgbaMobileSetTurbo(core, UInt32(ControlsView.B)) }
        controls.setBTurbo(active: true, lit: false)
        schedulePulse()
    }

    private func schedulePulse() {
        let work = DispatchWorkItem { [weak self] in
            guard let self else { return }
            if !self.turboB || ((self.touchKeys | self.hwKeys | self.padKeys) & ControlsView.B) == 0 {
                self.stopTurbo()
                return
            }
            let lit = self.controls.layer.presentation() != nil
            self.controls.setBTurbo(active: true, lit: !self.pulseLit)
            self.pulseLit.toggle()
            self.schedulePulse()
        }
        pulseWork = work
        DispatchQueue.main.asyncAfter(deadline: .now() + 0.04, execute: work)
    }

    private var pulseLit = false

    private func stopTurbo() {
        let was = turboB
        turboB = false
        pulseLit = false
        pulseWork?.cancel()
        if let core { mgbaMobileSetTurbo(core, 0) }
        controls.setBTurbo(active: false, lit: false)
        if was { publishKeys() }
    }

    private func wakeInput() {
        gate.lock()
        gate.signal()
        gate.unlock()
    }

    @objc private func openRom() { pick(kind: 1) }
    @objc private func openBios() { pick(kind: 2) }

    private func pick(kind: Int) {
        pickerKind = kind
        let picker = UIDocumentPickerViewController(forOpeningContentTypes: [UTType.item], asCopy: true)
        picker.delegate = self
        present(picker, animated: true)
    }

    func documentPicker(_ controller: UIDocumentPickerViewController, didPickDocumentsAt urls: [URL]) {
        guard let url = urls.first else { return }
        if pickerKind == 1 {
            hint.isHidden = false
            hint.text = "正在读取游戏…"
            DispatchQueue.global().async { [weak self] in
                guard let self, let path = self.copyIn(url, self.docs.appendingPathComponent("roms"), nil) else {
                    self?.toast("无法加载这个游戏")
                    return
                }
                self.defaults.set(path, forKey: "lastRom")
                self.gate.lock()
                self.pendingPath = path
                self.gate.signal()
                self.gate.unlock()
            }
        } else {
            DispatchQueue.global().async { [weak self] in self?.importBios(url) }
        }
    }

    private func importBios(_ url: URL) {
        let name = url.lastPathComponent
        guard let copied = copyIn(url, docs.appendingPathComponent("tmp-bios", isDirectory: true), "bios-import.bin") else {
            toast("BIOS 导入失败")
            return
        }
        let size = (try? FileManager.default.attributesOfItem(atPath: copied)[.size] as? NSNumber)?.int64Value ?? 0
        var destName = [CChar](repeating: 0, count: 32)
        mgbaMobileBiosFileName(name, Int(size), &destName, 32)
        let folder = docs.appendingPathComponent("config/mgba", isDirectory: true)
        try? FileManager.default.createDirectory(at: folder, withIntermediateDirectories: true)
        let dest = folder.appendingPathComponent(String(cString: destName))
        try? FileManager.default.removeItem(at: dest)
        do {
            try FileManager.default.moveItem(atPath: copied, toPath: dest.path)
        } catch {
            toast("BIOS 导入失败")
            return
        }
        toast("已导入 \(dest.lastPathComponent)，重新打开游戏后生效")
        if let last = defaults.string(forKey: "lastRom") {
            gate.lock()
            pendingPath = last
            gate.signal()
            gate.unlock()
        }
    }

    private func copyIn(_ url: URL, _ dir: URL, _ forced: String?) -> String? {
        try? FileManager.default.createDirectory(at: dir, withIntermediateDirectories: true)
        let name = forced ?? sanitize(url.lastPathComponent)
        let dest = dir.appendingPathComponent(name)
        if url.startAccessingSecurityScopedResource() {
            defer { url.stopAccessingSecurityScopedResource() }
            return writeCopy(url, dest)
        }
        return writeCopy(url, dest)
    }

    private func writeCopy(_ url: URL, _ dest: URL) -> String? {
        do {
            if FileManager.default.fileExists(atPath: dest.path) {
                try FileManager.default.removeItem(at: dest)
            }
            try FileManager.default.copyItem(at: url, to: dest)
            return dest.path
        } catch {
            return nil
        }
    }

    private func sanitize(_ name: String) -> String {
        let cleaned = name.replacingOccurrences(of: "[\\\\/:*?\"<>|]", with: "_", options: .regularExpression).trimmingCharacters(in: .whitespaces)
        if cleaned.isEmpty { return "game.gba" }
        if cleaned.count > 120 { return String(cleaned.suffix(120)) }
        return cleaned
    }

    @objc private func togglePause() {
        gate.lock()
        paused.toggle()
        let value = paused
        gate.unlock()
        pauseButton.setTitle(value ? "继续" : "暂停", for: .normal)
        audio.setPaused(value)
        if !value { wakeInput() }
    }

    @objc private func toggleSpeedBar() {
        let show = speedBar.isHidden
        speedBar.isHidden = !show
        speedBarHeight.constant = show ? 40 : 0
    }

    @objc private func pickSpeed(_ sender: UIButton) {
        setSpeed(sender.tag)
    }

    private func setSpeed(_ value: Int) {
        speed = min(16, max(1, value))
        defaults.set(speed, forKey: "speed")
        refreshSpeedButtons()
        if let core { mgbaMobileClearAudio(core) }
    }

    private func refreshSpeedButtons() {
        fastButton.setTitle("\(speed)倍", for: .normal)
        for button in speedButtons {
            let on = button.tag == speed
            button.setTitleColor(on ? UIColor(red: 0.06, green: 0.13, blue: 0.06, alpha: 1) : .white, for: .normal)
            button.backgroundColor = on ? UIColor(red: 61 / 255, green: 220 / 255, blue: 132 / 255, alpha: 1) : .clear
        }
    }

    @objc private func showSettings() {
        let alert = UIAlertController(title: "屏幕方向", message: nil, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: portrait ? "横屏" : "横屏 ✓", style: .default) { [weak self] _ in
            self?.chooseOrientation(false)
        })
        alert.addAction(UIAlertAction(title: portrait ? "竖屏 ✓" : "竖屏", style: .default) { [weak self] _ in
            self?.chooseOrientation(true)
        })
        alert.addAction(UIAlertAction(title: "关闭", style: .cancel))
        present(alert, animated: true)
    }

    private func chooseOrientation(_ portrait: Bool) {
        self.portrait = portrait
        defaults.set(portrait ? "portrait" : "landscape", forKey: "orientation")
        DispatchQueue.main.async { [weak self] in
            self?.applyOrientation()
        }
    }

    private func applyOrientation() {
        let mask: UIInterfaceOrientationMask = portrait ? .portrait : .landscape
        if #available(iOS 16.0, *) {
            setNeedsUpdateOfSupportedInterfaceOrientations()
            view.window?.windowScene?.requestGeometryUpdate(.iOS(interfaceOrientations: mask)) { _ in }
        }
        let value = portrait ? UIInterfaceOrientation.portrait.rawValue : UIInterfaceOrientation.landscapeRight.rawValue
        UIDevice.current.setValue(value, forKey: "orientation")
        UIViewController.attemptRotationToDeviceOrientation()
    }

    @objc private func cycleSlot() {
        slot = slot % 9 + 1
        refreshSlotButton()
    }

    @objc private func resetGame() { postCommand(cmdReset) }
    @objc private func saveState() { chooseSlot(save: true) }
    @objc private func loadState() { chooseSlot(save: false) }

    private func postCommand(_ cmd: Int) {
        gate.lock()
        command = cmd
        gate.signal()
        gate.unlock()
    }

    private func stateURL(_ index: Int) -> URL {
        let rom = defaults.string(forKey: "lastRom") ?? "game"
        let base = URL(fileURLWithPath: rom).deletingPathExtension().lastPathComponent
        return docs.appendingPathComponent("states").appendingPathComponent("\(base).ss\(index)")
    }

    private func refreshSlotButton() {
        let file = stateURL(slot)
        let filled = FileManager.default.fileExists(atPath: file.path) && ((try? FileManager.default.attributesOfItem(atPath: file.path)[.size] as? NSNumber)?.int64Value ?? 0) > 0
        slotButton.setTitle(filled ? "槽位 \(slot) ●" : "槽位 \(slot)", for: .normal)
    }

    private func chooseSlot(save: Bool) {
        guard let core, mgbaMobileIsLoaded(core) else {
            toast("请先打开一个游戏")
            return
        }
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 8
        if save, let now = gameView.copyLast() {
            box.addArrangedSubview(slotRow("当前画面（存档前）", now, tag: 0))
        }
        let formatter = DateFormatter()
        formatter.dateFormat = "M月d日 HH:mm"
        for i in 1...9 {
            let file = stateURL(i)
            let filled = FileManager.default.fileExists(atPath: file.path)
            let when = filled ? formatter.string(from: (try? FileManager.default.attributesOfItem(atPath: file.path)[.modificationDate] as? Date) ?? Date()) : "空"
            let preview = filled ? UIImage(contentsOfFile: file.appendingPathExtension("png").path) ?? UIImage(contentsOfFile: file.path) : nil
            var label = "槽位 \(i)　\(when)"
            if filled && preview == nil { label += "　无画面" }
            box.addArrangedSubview(slotRow(label, preview, tag: i))
        }
        let sheet = SheetController(title: save ? "保存到哪个槽位" : "读取哪个槽位", content: box)
        for case let button as UIButton in box.arrangedSubviews {
            button.addAction(UIAction { [weak self, weak sheet] _ in
                guard let self, let tag = button.tag as Int?, tag > 0 else { return }
                if !save && !FileManager.default.fileExists(atPath: self.stateURL(tag).path) {
                    self.toast("没有即时存档 \(tag)")
                    return
                }
                self.slot = tag
                self.refreshSlotButton()
                self.postCommand(save ? self.cmdSave : self.cmdLoad)
                sheet?.dismiss(animated: true)
            }, for: .touchUpInside)
        }
        present(sheet, animated: true)
    }

    private func slotRow(_ label: String, _ image: UIImage?, tag: Int) -> UIButton {
        let button = UIButton(type: .system)
        button.tag = tag
        button.contentHorizontalAlignment = .left
        button.setTitle("  " + label, for: .normal)
        button.setTitleColor(.darkText, for: .normal)
        button.setImage(image, for: .normal)
        button.imageView?.contentMode = .scaleAspectFit
        button.heightAnchor.constraint(equalToConstant: 84).isActive = true
        if tag == 0 { button.isEnabled = false }
        return button
    }

    private func writePreview(_ index: Int) {
        guard let image = gameView.copyLast(), let data = image.pngData() else { return }
        try? data.write(to: stateURL(index).appendingPathExtension("png"))
    }

    private func showSaveLocation() {
        guard let core else { return }
        var path = [CChar](repeating: 0, count: 1200)
        mgbaMobileSaveFile(core, &path, 1200)
        let text = filesPath(String(cString: path))
        if text.isEmpty {
            savePathView.isHidden = true
            return
        }
        savePathView.isHidden = false
        savePathView.text = "ROM 存档位置：\(text)"
        savePathView.accessibilityValue = text
        toast(savePathView.text ?? "")
    }

    @objc private func copySavePath() {
        let text = savePathView.accessibilityValue ?? ""
        if text.isEmpty { return }
        UIPasteboard.general.string = text
        toast("已复制 ROM 存档位置")
    }

    private func filesPath(_ absolute: String) -> String {
        let root = docs.path
        let prefix = root.hasSuffix("/") ? root : root + "/"
        let label = UIDevice.current.userInterfaceIdiom == .pad ? "我的 iPad" : "我的 iPhone"
        guard absolute.hasPrefix(prefix) else { return absolute }
        let rest = String(absolute.dropFirst(prefix.count))
        return rest.isEmpty ? "\(label)/mGBA" : "\(label)/mGBA/\(rest)"
    }

    private func applyVideo() {
        let blend = defaults.bool(forKey: "vf_blend")
        let linear = defaults.object(forKey: "vf_linear") == nil ? true : defaults.bool(forKey: "vf_linear")
        let aspect = defaults.object(forKey: "vf_aspect") == nil ? true : defaults.bool(forKey: "vf_aspect")
        if let core {
            mgbaMobileSetInterframe(core, blend)
            mgbaMobileSetFrameskip(core, Int32(defaults.integer(forKey: "vf_skip")))
        }
        gameView.bilinear = linear
        gameView.lockAspect = aspect
        gameView.integerScale = defaults.bool(forKey: "vf_integer")
        gameView.scanlines = defaults.bool(forKey: "vf_scan")
        let bright = defaults.object(forKey: "vf_bright") == nil ? 100 : defaults.integer(forKey: "vf_bright")
        gameView.brightness = bright
    }

    @objc private func showVideo() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 10
        let blend = labeledSwitch("帧间混合", defaults.bool(forKey: "vf_blend"))
        let linear = labeledSwitch("双线性过滤", defaults.object(forKey: "vf_linear") == nil ? true : defaults.bool(forKey: "vf_linear"))
        let aspect = labeledSwitch("锁定宽高比", defaults.object(forKey: "vf_aspect") == nil ? true : defaults.bool(forKey: "vf_aspect"))
        let integer = labeledSwitch("整数缩放", defaults.bool(forKey: "vf_integer"))
        let scan = labeledSwitch("扫描线", defaults.bool(forKey: "vf_scan"))
        let skip = slider(max: 5, value: Float(defaults.integer(forKey: "vf_skip")))
        let bright = slider(max: 100, value: Float((defaults.object(forKey: "vf_bright") == nil ? 100 : defaults.integer(forKey: "vf_bright")) - 50))
        let skipLabel = UILabel()
        let brightLabel = UILabel()
        func refresh() {
            skipLabel.text = "跳帧 \(Int(skip.value))"
            brightLabel.text = "亮度 \(Int(bright.value) + 50)%"
            defaults.set(blend.1.isOn, forKey: "vf_blend")
            defaults.set(linear.1.isOn, forKey: "vf_linear")
            defaults.set(aspect.1.isOn, forKey: "vf_aspect")
            defaults.set(integer.1.isOn, forKey: "vf_integer")
            defaults.set(scan.1.isOn, forKey: "vf_scan")
            defaults.set(Int(skip.value), forKey: "vf_skip")
            defaults.set(Int(bright.value) + 50, forKey: "vf_bright")
            applyVideo()
        }
        for item in [blend, linear, aspect, integer, scan] {
            item.1.addAction(UIAction { _ in refresh() }, for: .valueChanged)
            box.addArrangedSubview(item.0)
        }
        box.addArrangedSubview(skipLabel)
        box.addArrangedSubview(skip)
        box.addArrangedSubview(brightLabel)
        box.addArrangedSubview(bright)
        skip.addAction(UIAction { _ in refresh() }, for: .valueChanged)
        bright.addAction(UIAction { _ in refresh() }, for: .valueChanged)
        refresh()
        present(SheetController(title: "画质", content: box), animated: true)
    }

    @objc private func showLink() {
        let box = UIStackView()
        box.axis = .vertical
        box.spacing = 8
        let help = UILabel()
        help.numberOfLines = 0
        help.text = "两边打开同一个游戏，保持 1 倍速，不要暂停。创建方是 1P。\n局域网：一边创建，另一边填写对方 IP 后加入。\n互联网：两边填写同一个中继地址。一边点远程创建，把房间号给对方。中继留空时由本机充当，只在对方能访问这个 IP 时可用。"
        let host = field(defaults.string(forKey: "link_host") ?? "", "对方 IP，例如 192.168.1.8")
        let port = field(String(defaults.object(forKey: "link_port") == nil ? 8765 : defaults.integer(forKey: "link_port")), nil)
        port.keyboardType = .numberPad
        let relay = field(defaults.string(forKey: "link_relay") ?? "", "中继地址，例如 1.2.3.4:8766，留空则本机当中继")
        let room = field(defaults.string(forKey: "link_room") ?? "", "房间号")
        linkRoomField = room
        let status = UILabel()
        status.numberOfLines = 0
        status.textColor = UIColor(red: 27 / 255, green: 94 / 255, blue: 32 / 255, alpha: 1)
        status.text = linkMessage()
        linkStatusLabel = status
        box.addArrangedSubview(help)
        box.addArrangedSubview(host)
        box.addArrangedSubview(port)
        box.addArrangedSubview(row(linkButton("局域网创建") { [weak self] in
            guard let self else { return }
            let p = Int32(port.text ?? "") ?? -1
            if p < 1 || p > 65535 {
                status.text = "端口无效"
                return
            }
            self.remote?.close()
            if let core = self.core, mgbaMobileLinkHost(core, p) {
                self.defaults.set(Int(p), forKey: "link_port")
                status.text = "等待连接\n本机 \(self.localIpv4()):\(p)\n你是 1P"
                self.startLinkWatch()
            } else {
                status.text = self.linkMessage()
            }
        }, linkButton("局域网加入") { [weak self] in
            guard let self else { return }
            let ip = host.text?.trimmingCharacters(in: .whitespaces) ?? ""
            let p = Int32(port.text ?? "") ?? -1
            if ip.isEmpty || p < 1 || p > 65535 {
                status.text = "端口无效"
                return
            }
            self.remote?.close()
            self.defaults.set(ip, forKey: "link_host")
            self.defaults.set(Int(p), forKey: "link_port")
            if let core = self.core {
                _ = mgbaMobileLinkJoin(core, ip, p)
            }
            status.text = self.linkMessage()
            self.startLinkWatch()
        }))
        box.addArrangedSubview(relay)
        box.addArrangedSubview(room)
        box.addArrangedSubview(row(linkButton("远程创建") { [weak self] in
            guard let self else { return }
            let text = relay.text?.trimmingCharacters(in: .whitespaces) ?? ""
            self.defaults.set(text, forKey: "link_relay")
            self.ensureRemote().create(relayField: text, localIp: self.localIpv4())
            self.startLinkWatch()
        }, linkButton("远程加入") { [weak self] in
            guard let self else { return }
            let text = relay.text?.trimmingCharacters(in: .whitespaces) ?? ""
            let code = room.text?.trimmingCharacters(in: .whitespaces) ?? ""
            self.defaults.set(text, forKey: "link_relay")
            self.defaults.set(code, forKey: "link_room")
            self.ensureRemote().join(relayField: text, code: code)
            self.startLinkWatch()
        }))
        box.addArrangedSubview(linkButton("断开") { [weak self] in
            guard let self else { return }
            if let remote = self.remote {
                remote.close()
            } else if let core = self.core {
                mgbaMobileLinkClose(core)
            }
            self.linkWatch?.cancel()
            self.lastLinkState = 0
            status.text = "断开"
        })
        box.addArrangedSubview(status)
        present(SheetController(title: "联机", content: box), animated: true)
    }

    private func ensureRemote() -> RemoteLink {
        if let remote { return remote }
        let link = RemoteLink()
        link.onStatus = { [weak self] text in self?.linkStatusLabel?.text = text }
        link.onRoom = { [weak self] code, advertise in
            guard let self else { return }
            self.linkRoomField?.text = code
            self.defaults.set(code, forKey: "link_room")
            UIPasteboard.general.string = code
            self.toast("房间号 \(code) 已复制\n对方中继填 \(advertise)")
        }
        link.hostLink = { [weak self] port in
            guard let self, let core = self.core else { return false }
            return mgbaMobileLinkHost(core, port)
        }
        link.joinLink = { [weak self] host, port in
            guard let self, let core = self.core else { return false }
            return mgbaMobileLinkJoin(core, host, port)
        }
        link.closeLink = { [weak self] in
            if let core = self?.core { mgbaMobileLinkClose(core) }
        }
        remote = link
        return link
    }

    private func startLinkWatch() {
        linkWatch?.cancel()
        let work = DispatchWorkItem { [weak self] in self?.watchLink() }
        linkWatch = work
        DispatchQueue.main.async(execute: work)
    }

    private func watchLink() {
        guard let core else { return }
        var text = [CChar](repeating: 0, count: 128)
        mgbaMobileLinkStatus(core, &text, 128)
        let status = String(cString: text)
        let state = Int(status.split(separator: " ").first ?? "0") ?? 0
        if state != lastLinkState && state == 3 { toast(linkMessage(status)) }
        lastLinkState = state
        if state == 1 || state == 2 {
            let work = DispatchWorkItem { [weak self] in self?.watchLink() }
            linkWatch = work
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.7, execute: work)
        }
    }

    private func linkMessage(_ status: String? = nil) -> String {
        var buffer = [CChar](repeating: 0, count: 128)
        let text: String
        if let status {
            text = status
        } else if let core {
            mgbaMobileLinkStatus(core, &buffer, 128)
            text = String(cString: buffer)
        } else {
            text = ""
        }
        let parts = text.split(separator: " ", maxSplits: 2, omittingEmptySubsequences: false)
        return parts.count >= 3 ? String(parts[2]) : text
    }

    private func localIpv4() -> String {
        var pointer: UnsafeMutablePointer<ifaddrs>?
        guard getifaddrs(&pointer) == 0, let first = pointer else { return "0.0.0.0" }
        defer { freeifaddrs(first) }
        var cursor: UnsafeMutablePointer<ifaddrs>? = first
        while let current = cursor {
            if let addr = current.pointee.ifa_addr, addr.pointee.sa_family == UInt8(AF_INET) {
                let flags = Int32(current.pointee.ifa_flags)
                if (flags & IFF_UP) != 0 && (flags & IFF_LOOPBACK) == 0 {
                    var host = [CChar](repeating: 0, count: Int(NI_MAXHOST))
                    if getnameinfo(addr, socklen_t(addr.pointee.sa_len), &host, socklen_t(host.count), nil, 0, NI_NUMERICHOST) == 0 {
                        return String(cString: host)
                    }
                }
            }
            cursor = current.pointee.ifa_next
        }
        return "0.0.0.0"
    }

    @objc private func bindControllers() {
        for controller in GCController.controllers() {
            controller.extendedGamepad?.valueChangedHandler = { [weak self] pad, _ in
                self?.updatePad(pad)
            }
        }
    }

    private func updatePad(_ pad: GCExtendedGamepad) {
        var mask = 0
        if pad.buttonA.isPressed { mask |= ControlsView.A }
        if pad.buttonB.isPressed { mask |= ControlsView.B }
        if pad.leftShoulder.isPressed || pad.leftTrigger.isPressed { mask |= ControlsView.l }
        if pad.rightShoulder.isPressed || pad.rightTrigger.isPressed { mask |= ControlsView.r }
        if pad.buttonMenu.isPressed { mask |= ControlsView.start }
        if pad.buttonOptions?.isPressed == true { mask |= ControlsView.select }
        if pad.dpad.up.isPressed { mask |= ControlsView.up }
        if pad.dpad.down.isPressed { mask |= ControlsView.down }
        if pad.dpad.left.isPressed { mask |= ControlsView.left }
        if pad.dpad.right.isPressed { mask |= ControlsView.right }
        let prev = padKeys
        padKeys = mask
        noteUserKeys(prevTouch: touchKeys, prevHw: hwKeys, prevPad: prev)
        if (mask & ~prev) != 0 { wakeInput() }
    }

    override func pressesBegan(_ presses: Set<UIPress>, with event: UIPressesEvent?) {
        var handled = false
        for press in presses {
            guard let key = press.key else { continue }
            if key.keyCode == .keyboardTab || key.keyCode == .keyboardSpacebar {
                fastHold = true
                handled = true
                continue
            }
            let bit = mapKey(key.keyCode)
            if bit == 0 { continue }
            let prev = hwKeys
            hwKeys |= bit
            noteUserKeys(prevTouch: touchKeys, prevHw: prev, prevPad: padKeys)
            if (bit & ~prev) != 0 { wakeInput() }
            handled = true
        }
        if !handled { super.pressesBegan(presses, with: event) }
    }

    override func pressesEnded(_ presses: Set<UIPress>, with event: UIPressesEvent?) {
        var handled = false
        for press in presses {
            guard let key = press.key else { continue }
            if key.keyCode == .keyboardTab || key.keyCode == .keyboardSpacebar {
                fastHold = false
                handled = true
                continue
            }
            let bit = mapKey(key.keyCode)
            if bit == 0 { continue }
            let prev = hwKeys
            hwKeys &= ~bit
            noteUserKeys(prevTouch: touchKeys, prevHw: prev, prevPad: padKeys)
            handled = true
        }
        if !handled { super.pressesEnded(presses, with: event) }
    }

    private func mapKey(_ code: UIKeyboardHIDUsage) -> Int {
        switch code {
        case .keyboardUpArrow, .keyboardW: return ControlsView.up
        case .keyboardDownArrow: return ControlsView.down
        case .keyboardLeftArrow: return ControlsView.left
        case .keyboardRightArrow: return ControlsView.right
        case .keyboardA: return ControlsView.l
        case .keyboardX: return ControlsView.A
        case .keyboardZ: return ControlsView.B
        case .keyboardS: return ControlsView.r
        case .keyboardReturnOrEnter: return ControlsView.start
        case .keyboardDeleteOrBackspace, .keyboardLeftShift, .keyboardRightShift: return ControlsView.select
        default: return 0
        }
    }

    private func labeledSwitch(_ title: String, _ on: Bool) -> (UIStackView, UISwitch) {
        let label = UILabel()
        label.text = title
        let toggle = UISwitch()
        toggle.isOn = on
        let row = UIStackView(arrangedSubviews: [label, toggle])
        row.axis = .horizontal
        row.distribution = .equalSpacing
        return (row, toggle)
    }

    private func slider(max: Float, value: Float) -> UISlider {
        let slider = UISlider()
        slider.minimumValue = 0
        slider.maximumValue = max
        slider.value = value
        return slider
    }

    private func field(_ text: String, _ placeholder: String?) -> UITextField {
        let field = UITextField()
        field.text = text
        field.placeholder = placeholder
        field.borderStyle = .roundedRect
        field.autocapitalizationType = .none
        field.autocorrectionType = .no
        field.heightAnchor.constraint(equalToConstant: 36).isActive = true
        return field
    }

    private func linkButton(_ title: String, _ action: @escaping () -> Void) -> UIButton {
        let button = UIButton(type: .system)
        button.setTitle(title, for: .normal)
        button.addAction(UIAction { _ in action() }, for: .touchUpInside)
        return button
    }

    private func row(_ left: UIView, _ right: UIView) -> UIStackView {
        let row = UIStackView(arrangedSubviews: [left, right])
        row.axis = .horizontal
        row.distribution = .fillEqually
        return row
    }

    private func toast(_ message: String) {
        DispatchQueue.main.async {
            let alert = UIAlertController(title: nil, message: message, preferredStyle: .alert)
            self.present(alert, animated: true)
            DispatchQueue.main.asyncAfter(deadline: .now() + 1.2) { alert.dismiss(animated: true) }
        }
    }

    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        gate.lock()
        paused = true
        gate.unlock()
        audio.setPaused(true)
    }

    deinit {
        running = false
        wakeInput()
        stopped.wait()
        remote?.close()
        audio.stop()
        if let core { mgbaMobileDestroy(core) }
    }
}

private final class SheetController: UIViewController {
    private let body: UIView
    private let heading: String

    init(title: String, content: UIView) {
        heading = title
        body = content
        super.init(nibName: nil, bundle: nil)
        modalPresentationStyle = .pageSheet
    }

    required init?(coder: NSCoder) { nil }

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .systemBackground
        let titleLabel = UILabel()
        titleLabel.text = heading
        titleLabel.font = .boldSystemFont(ofSize: 18)
        let scroll = UIScrollView()
        let close = UIButton(type: .system)
        close.setTitle("关闭", for: .normal)
        close.addAction(UIAction { [weak self] _ in self?.dismiss(animated: true) }, for: .touchUpInside)
        for item in [titleLabel, scroll, close, body] {
            item.translatesAutoresizingMaskIntoConstraints = false
        }
        view.addSubview(titleLabel)
        view.addSubview(close)
        view.addSubview(scroll)
        scroll.addSubview(body)
        NSLayoutConstraint.activate([
            titleLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 16),
            titleLabel.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 16),
            close.centerYAnchor.constraint(equalTo: titleLabel.centerYAnchor),
            close.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -16),
            scroll.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: 12),
            scroll.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            scroll.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            scroll.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            body.topAnchor.constraint(equalTo: scroll.topAnchor, constant: 8),
            body.leadingAnchor.constraint(equalTo: scroll.leadingAnchor, constant: 16),
            body.trailingAnchor.constraint(equalTo: scroll.trailingAnchor, constant: -16),
            body.bottomAnchor.constraint(equalTo: scroll.bottomAnchor, constant: -16),
            body.widthAnchor.constraint(equalTo: scroll.widthAnchor, constant: -32)
        ])
    }
}
