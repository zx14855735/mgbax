# G1 EX-0 determinism baseline - reproducible runner (parent session, serial only)
# Frozen artifacts, md5 self-attest, unique tag, CPU<=70%, two serial instances,
# fail-closed judge. No party/state fabrication, no fake PASS.
# Usage: powershell -File tools\g1_det_run.ps1 -Tag T -Rom <abs.gba> -Exe <abs.exe> -Frames 100
param(
  [string]$Tag = "G1DET-EX0-r1",
  [string]$Rom = "$PSScriptRoot\..\.zcode-tmp\G1DET-EX0-r1\rom_frozen.gba",
  [string]$Exe = "$PSScriptRoot\..\build-mobile-test\mgba_mobile_test.exe",
  [int]$Frames = 100
)

$ErrorActionPreference = "SilentlyContinue"
$Rom = (Resolve-Path $Rom).Path
$Exe = (Resolve-Path $Exe).Path
$dir = Join-Path (Join-Path $PSScriptRoot "..") ".zcode-tmp\$Tag"
New-Item -ItemType Directory -Force -Path $dir | Out-Null

$cpu = (Get-CimInstance Win32_Processor | Measure-Object LoadPercentage -Average).Average
if ($cpu -gt 70) { throw "CPU=$cpu percent >70, stop (AGENTS 2.5)" }
Write-Output "CPU=$cpu percent OK"

$romMd5 = (Get-FileHash $Rom -Algorithm MD5).Hash
$exeMd5 = (Get-FileHash $Exe -Algorithm MD5).Hash
Write-Output "ROM_MD5=$romMd5"
Write-Output "EXE_MD5=$exeMd5"
"rom_md5=$romMd5`nexe_md5=$exeMd5`nframes=$Frames`ntag=$Tag`ntime=$(Get-Date -Format o)" |
  Out-File "$dir\manifest.txt" -Encoding utf8

$env:PATH = "C:\msys64\mingw64\bin;C:\msys64\usr\bin;$env:PATH"

# Two SERIAL instances. GBA log lines on stderr are informational; ignore them.
& $Exe --g1det $Rom "$dir\A.csv" $Frames 2>$null
$a = $LASTEXITCODE
& $Exe --g1det $Rom "$dir\B.csv" $Frames 2>$null
$b = $LASTEXITCODE
$rowsA = if (Test-Path "$dir\A.csv") { (Get-Content "$dir\A.csv" | Measure-Object -Line).Lines } else { 0 }
$rowsB = if (Test-Path "$dir\B.csv") { (Get-Content "$dir\B.csv" | Measure-Object -Line).Lines } else { 0 }
Write-Output "[A] exit=$a rows=$rowsA"
Write-Output "[B] exit=$b rows=$rowsB"

if ($a -ne 0 -or $b -ne 0 -or $rowsA -lt 2 -or $rowsB -lt 2) {
  Write-Output "VERDICT=UNOBSERVED (one/both instances crashed or empty)"
  exit 2
}
python "$PSScriptRoot\g1_det_judge.py" "$dir\A.csv" "$dir\B.csv"
exit $LASTEXITCODE
