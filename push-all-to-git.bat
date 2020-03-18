cd C:\Users\Bruno\Desktop\workspace\shoppolis
for /F "tokens=2" %%i in ('date /t') do set mydate=%%i
set mytime=%time%
git add .
git commit -m "Committed all on date: %mydate%:%mytime%"
git push -u origin master
pause