import AVFoundation

final class AudioOut {
    private let engine = AVAudioEngine()
    private let speedNode = AVAudioUnitVarispeed()
    private let lock = NSLock()
    private var storage: [Int16]
    private var readPos = 0
    private var writePos = 0
    private let capacity: Int
    private var paused = false
    private var rate: Float = 1
    private(set) var outputRate = 48000
    var sourceRate = 32768
    private var resamplePos = 0.0
    private var started = false
    private var soundEnabled = true

    init() {
        capacity = 48000 * 4
        storage = [Int16](repeating: 0, count: capacity)
    }

    func start(sourceRate: Int) {
        self.sourceRate = sourceRate > 0 ? sourceRate : 32768
        let session = AVAudioSession.sharedInstance()
        try? session.setCategory(.playback, mode: .default, options: [.mixWithOthers])
        try? session.setPreferredSampleRate(Double(self.sourceRate))
        try? session.setActive(true)
        outputRate = Int(session.sampleRate.rounded())
        if outputRate <= 0 { outputRate = 48000 }
        if started {
            applyRate()
            return
        }
        let format = AVAudioFormat(standardFormatWithSampleRate: Double(outputRate), channels: 2)!
        let node = AVAudioSourceNode(format: format) { [weak self] _, _, frameCount, audioBufferList -> OSStatus in
            self?.render(frameCount: Int(frameCount), list: audioBufferList)
            return noErr
        }
        engine.attach(node)
        engine.attach(speedNode)
        engine.connect(node, to: speedNode, format: format)
        engine.connect(speedNode, to: engine.mainMixerNode, format: format)
        applyRate()
        try? engine.start()
        started = true
    }

    func setPaused(_ value: Bool) {
        paused = value
        if value { clear() }
    }

    func setSoundEnabled(_ value: Bool) {
        soundEnabled = value
        if !value { clear() }
    }

    /// 兼容旧调用：是否倍速（静音式）。现在默认有声，由 setRate 接管。
    func setFast(_ value: Bool) {
        // 不再丢弃音频，变速由 setRate 控制
        if !value {
            setRate(1)
        }
    }

    func setRate(_ value: Float) {
        let clamped = min(16, max(1, value))
        if abs(clamped - rate) < 0.001 { return }
        rate = clamped
        resamplePos = 0
        clear()
        applyRate()
    }

    private func applyRate() {
        // Varispeed 同时变速+变调（磁带式），和安卓 PlaybackParams(speed+pitch) 一致。
        speedNode.rate = rate
    }

    func stop() {
        engine.stop()
        started = false
        clear()
    }

    func pump(samples: UnsafePointer<Int16>, frames: Int) {
        if paused || frames <= 0 { return }
        if !soundEnabled { return }
        if outputRate == sourceRate {
            write(samples, frames: frames)
            return
        }
        var converted = [Int16](repeating: 0, count: max(frames * 4, 4096))
        let outFrames = withUnsafeMutablePointer(to: &resamplePos) { pos in
            converted.withUnsafeMutableBufferPointer { buffer -> Int32 in
                guard let base = buffer.baseAddress else { return 0 }
                return mgbaMobileResample(samples, Int32(frames), Int32(sourceRate), Int32(outputRate), base, Int32(buffer.count / 2), pos)
            }
        }
        if outFrames > 0 {
            converted.withUnsafeBufferPointer { raw in
                if let base = raw.baseAddress {
                    write(base, frames: Int(outFrames))
                }
            }
        }
    }

    private func write(_ samples: UnsafePointer<Int16>, frames: Int) {
        let shorts = frames * 2
        lock.lock()
        var i = 0
        while i < shorts {
            storage[writePos] = samples[i]
            writePos = (writePos + 1) % capacity
            if writePos == readPos {
                readPos = (readPos + 1) % capacity
            }
            i += 1
        }
        lock.unlock()
    }

    private func clear() {
        lock.lock()
        readPos = 0
        writePos = 0
        lock.unlock()
    }

    private func render(frameCount: Int, list: UnsafeMutablePointer<AudioBufferList>) {
        let buffers = UnsafeMutableAudioBufferListPointer(list)
        guard buffers.count >= 2,
              let leftData = buffers[0].mData?.assumingMemoryBound(to: Float.self),
              let rightData = buffers[1].mData?.assumingMemoryBound(to: Float.self) else { return }
        lock.lock()
        let available = (writePos - readPos + capacity) % capacity
        let frames = min(frameCount, available / 2)
        for i in 0..<frameCount {
            if i < frames {
                let l = storage[readPos]
                readPos = (readPos + 1) % capacity
                let r = storage[readPos]
                readPos = (readPos + 1) % capacity
                leftData[i] = Float(l) / 32768
                rightData[i] = Float(r) / 32768
            } else {
                leftData[i] = 0
                rightData[i] = 0
            }
        }
        lock.unlock()
    }
}
