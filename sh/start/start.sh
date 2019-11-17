#!/bin/bash

### function Area
function bg_magenta_echo() {
    echo -e "\e[45m$*\e[m";
}

function yellow_echo() {
    echo -e "\e[1;33m$*\e[m";
}

### main Area
# shの位置を保存
SH_DIR=`pwd`

# java実行 エクセルのシート一覧を取得する
cd ../../
#mvn clean package -Dtest=test.jp.co.daich.selenium.logic.GetScenarioListTest

# shの位置に戻る
cd $SH_DIR

# javaで生成したエクセルのシート一覧をターミナルに表示
cat ./temp/scenarioList.txt | while read line
do
    # grepを使ってBook行なのかSheet行なのか判定
    echo -e "$line" | grep "^\[Book\]" >/dev/null
    if [[ $? == 0 ]];
    # Bookの場合
    then
        bg_magenta_echo $line
    # Sheetの場合
    else
        echo "    "$line
    fi
done

# 実行するシートを選んでもらう
echo -n "実行したいシート名のNoを入力してください。"
yellow_echo "  ※,区切りで複数指定可"
read -p " > " INP_SHEET_NO

# 繰り返し処理用にカンマ区切り形式をスペース形式に変換
FORMED_SHEET_NO=`echo $INP_SHEET_NO | sed "s/,/ /g"`

SHEET_ARRAY=()

# Book一覧を格納する連想配列
declare -A bookList_

grep -n "\[Book\]" ./temp/scenarioList.txt | while read line
do
    #
    BOOK_NUM=`echo $line | sed "s/:.*//"`
    echo $BOOK_NUM
    BOOK_NAME=`echo $line | sed "s/^.*\[Book\] *//"`
    echo $BOOK_NAME
    bookList_["$BOOK_NUM"]="$BOOK_NAME"
    declare -p bookList_
    echo "[value]bookList_="${!bookList_[@]}
done

# 指定されたシートごとに繰り返し
for i in $FORMED_SHEET_NO ; do
    EXE_SHEET_NAME=`grep -E "^    $i   " ./temp/scenarioList.txt | sed "s/^    $i   //"`
    EXE_SHEET_LINE_NUM=`grep -nE "^    $i   " ./temp/scenarioList.txt | sed "s/:.*//" | sed "s/ //g"`
    EXE_BOOK_NAME=""
    for ((i=$EXE_SHEET_LINE_NUM; 0<i; i--));
    do
        echo "[value]i=$i"
        EXE_BOOK_NAME=${bookList_[$i]}
        echo "[value] bookList_=$EXE_BOOK_NAME"
        if [ -n "$EXE_BOOK_NAME" ];
        then
            echo "[value] EXE_BOOK_NAME=$EXE_BOOK_NAME"
            break;
        fi
    done

    # セレニウム実行
    echo "java -jar -cp Main $EXE_BOOK_NAME $EXE_SHEET_NAME"
done

echo "[END]"


