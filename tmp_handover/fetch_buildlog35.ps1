$ErrorActionPreference = 'Stop'
$credInput = "protocol=https`nhost=github.com`n`n"
$cred = $credInput | git credential fill
$token = ($cred | Where-Object { $_ -like 'password=*' }).Substring('password='.Length)
$H = @{ Authorization = "token $token"; 'User-Agent' = 'zx' }
$arts = Invoke-RestMethod -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs/43558059716/artifacts' -Headers $H
$art = $arts.artifacts | Where-Object { $_.name -eq 'build-log' } | Select-Object -First 1
if (-not $art) { Write-Host 'NO_BUILDLOG'; exit 1 }
$zip = 'D:\mgba-android-version\tmp_handover\buildlog35.zip'
Invoke-WebRequest -Uri $art.archive_download_url -Headers $H -OutFile $zip -MaximumRedirection 5
$d = 'D:\mgba-android-version\tmp_handover\buildlog35'
if (Test-Path $d) { Remove-Item -Recurse -Force $d }
Expand-Archive -Path $zip -DestinationPath $d -Force
Write-Host EXTRACTED
