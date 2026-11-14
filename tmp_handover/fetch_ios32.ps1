$ErrorActionPreference = 'Stop'
$credInput = "protocol=https`nhost=github.com`n`n"
$cred = $credInput | git credential fill
$token = ($cred | Where-Object { $_ -like 'password=*' }).Substring('password='.Length)
$zip = 'D:\mgba-android-version\tmp_handover\ios32_logs.zip'
Invoke-WebRequest -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs/43552355987/logs' -Headers @{ Authorization = "token $token"; 'User-Agent' = 'zx' } -OutFile $zip
$d = 'D:\mgba-android-version\tmp_handover\ios32_logs'
if (Test-Path $d) { Remove-Item -Recurse -Force $d }
Expand-Archive -Path $zip -DestinationPath $d -Force
Write-Host EXTRACTED
