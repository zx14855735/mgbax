$ErrorActionPreference = 'Continue'

# 1. commit the unified tree
git -C D:\mgba-ios-mirror add -A
git -C D:\mgba-ios-mirror -c user.name=zx14855735 -c user.email=525612743@qq.com commit -q -m "Unify: PC + Android + iOS in one repo; add android/pc CI; fix link_lockstep.h bridging include"
git -C D:\mgba-ios-mirror log --oneline -1

# 2. rename repo mgbax-ios -> mgbax
$credInput = "protocol=https`nhost=github.com`n`n"
$cred = $credInput | git credential fill
$token = ($cred | Where-Object { $_ -like 'password=*' }).Substring('password='.Length)
$headers = @{ Authorization = "token $token"; 'User-Agent' = 'zx14855735'; Accept = 'application/vnd.github+json' }

try {
  $r = Invoke-RestMethod -Method Patch -Uri 'https://api.github.com/repos/zx14855735/mgbax-ios' -Headers $headers -Body '{"name":"mgbax"}' -ContentType 'application/json'
  Write-Host ("RENAMED_TO=" + $r.full_name)
} catch {
  Write-Host ("RENAME_FAILED: " + $_.Exception.Message)
}

# 3. push unified tree to renamed remote
git -C D:\mgba-ios-mirror remote set-url origin https://github.com/zx14855735/mgbax.git
git -C D:\mgba-ios-mirror push -f origin main 2>&1 | ForEach-Object { Write-Host $_ }
Write-Host "PUSH_DONE"

# 4. try deleting the redundant mgbax-pc-android repo
try {
  Invoke-RestMethod -Method Delete -Uri 'https://api.github.com/repos/zx14855735/mgbax-pc-android' -Headers $headers
  Write-Host "PC_ANDROID_DELETED"
} catch {
  $msg = $_.ErrorDetails.Message
  Write-Host ("PC_ANDROID_DELETE_FAILED: " + $msg.Substring(0, [Math]::Min(200, $msg.Length)))
}
