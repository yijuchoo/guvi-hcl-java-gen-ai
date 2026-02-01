#!/usr/bin/env bash
set -e

ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
SRC="$ROOT_DIR/src/main/java"
OUT="$ROOT_DIR/out"

rm -rf "$OUT"
mkdir -p "$OUT"

find "$SRC" -name "*.java" > "$OUT/sources.txt"

javac -d "$OUT" @"$OUT/sources.txt"

java -cp "$OUT" com.guvi.module4.student.main.AppMain
