call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startexplorer
echo.
echo runcrud error occured
goto fail

:startexplorer
start firefox http://localhost:8080/crud/v1/tasks/
if "%ERRORLEVEL%" == "0" goto end
echo.
echo unable to open firefox
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.