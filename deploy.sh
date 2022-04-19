#!/usr/bin/bash
module=${!#}
FOLLOW=FALSE
RESTART=FALSE
while  getopts :fr args ;
do
  case $args in
  f) FOLLOW=TRUE
    ;;
  r) RESTART=TRUE
    ;;
  *) echo error
    exit
    ;;
  esac
done
git reset --hard
git pull -r
export GRADLE_OPTS="-Dorg.gradle.jvmargs=-Xms2024M -Xmx512M -XX:+CMSClassUnloadingEnabled -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8"
if [ $RESTART == TRUE ]; then
      cd ../../service/${module} || exit
    else
      ./gradlew :${module}:bootJar || exit
      \cp ${module}/build/libs/*.jar  ../../service/${module}/${module}.jar
      cd ../../service/${module} || exit
fi
kill -9 "`cat pid`" || true
nohup java -jar -XX:+CMSClassUnloadingEnabled -XX:+HeapDumpOnOutOfMemoryError -Dlog.base=$LOG_PATH ${module}.jar > server.log 2>&1 & echo $! > pid
if [ $FOLLOW == TRUE ]; then
    tail -f server.log
else
  exit 0
fi
