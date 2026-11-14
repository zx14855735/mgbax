$ErrorActionPreference = 'Stop'
$credInput = "protocol=https`nhost=github.com`n`n"
$cred = $credInput | git credential fill
$token = ($cred | Where-Object { $_ -like 'password=*' }).Substring('password='.Length)
$zip = 'D:\mgba-android-version\tmp_handover\ios35_logs.zip'
Invoke-WebRequest -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs/43558059716/logs' -Headers @{ Authorization = "token $token"; 'User-Agent' = 'zx' } -OutFile $zip
$d = 'D:\mgba-android-version\tmp_handover\ios35_logs'
if (Test-Path $d) { Remove-Item -Recurse -Force $d }
Expand-Archive -Path $zip -DestinationPath $d -Force
Write-Host EXTRACTED
