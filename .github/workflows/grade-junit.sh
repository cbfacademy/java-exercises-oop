#!/bin/sh
passed=$1
failed=$2
skipped=$3
total=$((passed + failed + skipped))

if [ -n "$GITHUB_OUTPUT" ]; then
  echo "total=$total" >> "$GITHUB_OUTPUT"
fi

echo "$passed of $total tests passed"
