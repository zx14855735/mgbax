$ErrorActionPreference = 'Stop'

# 1. gitignore for the mirror
$gi = @'
build/
.gradle/
.idea/
local.properties
*.apk
*.keystore
'@
Set-Content -Path 'D:\mgba-pc-android-mirror\.gitignore' -Value $gi -Encoding ASCII

# 2. init + commit
git -C D:\mgba-pc-android-mirror init -b main 2>$null | Out-Null
git -C D:\mgba-pc-android-mirror add -A
git -C D:\mgba-pc-android-mirror -c user.name=zx14855735 -c user.email=525612743@qq.com commit -m "Initial mirror: PC(Qt) + Android app + shared core (sync 2026-11-13)" | Out-Null

# 3. get stored GitHub credential (GCM)
$credInput = "protocol=https`nhost=github.com`n`n"
$cred = $credInput | git credential fill
$line = ($cred | Where-Object { $_ -like 'password=*' })
$token = $line.Substring('password='.Length)
Write-Host ("TOKEN_PREFIX=" + $token.Substring(0, 4))

# 4. create repo via API
$headers = @{
  Authorization = "token $token"
  'User-Agent'  = 'zx14855735'
  Accept        = 'application/vnd.github+json'
}
$body = @{
  name        = 'mgbax-pc-android'
  description = 'mGBAx PC(Qt) and Android mirror - sanitized, no history (see mgbax-ios for the iOS mirror)'
  private     = $false
} | ConvertTo-Json
try {
  $repo = Invoke-RestMethod -Method Post -Uri 'https://api.github.com/user/repos' -Headers $headers -Body $body -ContentType 'application/json'
  Write-Host ("REPO_CREATED=" + $repo.full_name)
} catch {
  $msg = $_.ErrorDetails.Message
  if ($msg -match 'already_exists') {
    Write-Host "REPO_EXISTS"
  } else {
    Write-Host ("REPO_CREATE_FAILED: " + $msg.Substring(0, [Math]::Min(300, $msg.Length)))
    exit 1
  }
}

# 5. push
git -C D:\mgba-pc-android-mirror remote add origin https://github.com/zx14855735/mgbax-pc-android.git 2>$null
git -C D:\mgba-pc-android-mirror push -u origin main 2>&1 | ForEach-Object { $_ }
Write-Host "PUSH_DONE"
