#!/bin/bash

declare -A array_
BOOK_NUM=3
BOOK_NAME='name_t'

array_["$BOOK_NUM"]="$BOOK_NAME"

echo "[value]array_ = ${array_[$BOOK_NUM]}"

declare -p array_

