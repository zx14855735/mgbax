@echo off
chcp 65001 >nul
title mGBA 联机中继
cd /d "%~dp0"
echo 正在启动联机中继...
python ".workbuddy\gboy\serve_relay.py"
pause
