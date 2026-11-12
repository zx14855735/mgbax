$ErrorActionPreference = 'Stop'
$credInput = "protocol=https`nhost=github.com`n`n"
$cred = $credInput | git credential fill
$token = ($cred | Where-Object { $_ -like 'password=*' }).Substring('password='.Length)
$headers = @{ Authorization = "token $token"; 'User-Agent' = 'zx14855735'; Accept = 'application/vnd.github+json' }

# branches on both repos
foreach ($repo in 'mgbax-ios', 'mgbax-pc-android') {
  try {
    $b = Invoke-RestMethod -Uri "https://api.github.com/repos/zx14855735/$repo/branches" -Headers $headers
    Write-Host ("BRANCHES ${repo}: " + (($b | ForEach-Object { $_.name }) -join ', '))
  } catch { Write-Host ("BRANCHES ${repo}: ERR " + $_.Exception.Message) }
}

# download run #12 logs
$zip = 'D:\mgba-android-version\tmp_handover\ci12_logs.zip'
Invoke-WebRequest -Uri 'https://api.github.com/repos/zx14855735/mgbax-ios/actions/runs/43264808356/logs' -Headers $headers -OutFile $zip
if (Test-Path 'D:\mgba-android-version\tmp_handover\ci12_logs') { Remove-Item -Recurse -Force 'D:\mgba-android-version\tmp_handover\ci12_logs' }
Expand-Archive -Path $zip -DestinationPath 'D:\mgba-android-version\tmp_handover\ci12_logs' -Force
Write-Host 'LOGS_EXTRACTED'
Get-ChildItem 'D:\mgba-android-version\tmp_handover\ci12_logs' -Recurse -File | ForEach-Object { Write-Host $_.FullName.Replace('D:\mgba-android-version\tmp_handover\ci12_logs\','') }
