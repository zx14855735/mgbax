$ErrorActionPreference = 'Stop'
$credInput = "protocol=https`nhost=github.com`n`n"
$cred = $credInput | git credential fill
$token = ($cred | Where-Object { $_ -like 'password=*' }).Substring('password='.Length)
Invoke-RestMethod -Method Post `
  -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/workflows/ios-build.yml/dispatches' `
  -Headers @{ Authorization = "token $token"; 'User-Agent' = 'zx'; Accept = 'application/vnd.github+json' } `
  -Body '{"ref":"main"}'
Write-Host 'IOS_DISPATCHED'
