$ErrorActionPreference = 'Continue'
$env:ANDROID_AVD_HOME = 'D:\avd-home\avd'
$env:TEMP = 'D:\avd-temp'
$env:TMP = 'D:\avd-temp'
$adb = 'D:\Android\Sdk\platform-tools\adb.exe'
$emu = 'D:\Android\Sdk\emulator\emulator.exe'
$log = 'D:\mgba-android-version\.workbuddy'

& $adb start-server | Out-Null

$pa = Start-Process -FilePath $emu -ArgumentList @('-avd','mgba_test','-no-snapshot','-no-boot-anim','-no-audio','-no-window','-gpu','swiftshader_indirect','-memory','1536','-cores','2','-port','5554') -RedirectStandardOutput "$log\emu_a.log" -RedirectStandardError "$log\emu_a.err.log" -PassThru -WindowStyle Hidden
$pb = Start-Process -FilePath $emu -ArgumentList @('-avd','zx_link_test','-no-snapshot','-no-boot-anim','-no-audio','-no-window','-gpu','swiftshader_indirect','-memory','1536','-cores','2','-port','5556') -RedirectStandardOutput "$log\emu_b.log" -RedirectStandardError "$log\emu_b.err.log" -PassThru -WindowStyle Hidden
Write-Output "A pid $($pa.Id), B pid $($pb.Id)"
$pa.WaitForExit()
$pb.WaitForExit()
Write-Output "emulators exited"
