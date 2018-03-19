#!/bin/bash
dbUser="root"
dbPasswd="123456"
bakDir="/home/mysql/bakmysql"
bakDirOld="/home/mysql/bakmysqlold"

if [ ! -d "$bakDir" ]; then
　　mkdir -p "$bakDir"
fi

if [ ! -d "$bakDirOld" ]; then
　　mkdir -p "$bakDirOld"
fi

cd "$bakDir"

#mv *.sql "$bakDirOld"

time=$(date +"%Y-%m-%d")

dbNameArr=("ets_budget" "ets_common_api" "ets_contract" "ets_delive" "ets_energy" "ets_platform" "ets_purchase" "ets_resource" "ets_work_flow")
hostIp=("10.0.6.168" "10.0.6.220" "10.0.6.221" "10.0.6.221" "10.0.6.221" "10.0.6.220" "10.0.6.223" "10.0.6.223" "10.0.6.223")
num=0
for dbName in ${dbNameArr[@]}
  do
     mysqldump -h"${hostIp[$num]}" -u$dbUser -p$dbPasswd -x $dbName  > "$bakDir/$dbName"-"$time.sql"
    let num++
  done

#bakup proc
dbNameArr=("ets_budget" "ets_contract" "ets_delive" "ets_energy" "ets_purchase" "ets_resource")
num=0
for dbName in ${dbNameArr[@]}
  do
     echo $num
     mysqldump -R -ndt $dbName -h"${hostIp[$num]}" -u$dbUser -p$dbPasswd > "$bakDir/$dbName"_proc-"$time.sql"
     let num++
  done

cd cd "$bakDir"
zip xcdb_"$time".zip ./*.sql
rm -f ./*.sql
sevenDays=$(date -d -5day  +"%Y-%m-%d")
rm -f ./xcdb_"$sevenDays".zip 
