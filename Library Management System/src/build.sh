#!/bin/bash

if [ -z "$JAVA_HOME" ]; then
  echo "JAVA_HOME is not set. Please set it to your Java installation directory."
  echo "For example: export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home"
  exit 1
fi

export PATH="$JAVA_HOME/bin:$PATH"

if java com.library.ui.App; then
  echo "Program executed successfully using class name."
else
  if [ -f "LibraryManagementSystem.jar" ]; then
    if java -jar LibraryManagementSystem.jar; then
      echo "Program executed successfully using JAR file."
    else
      echo "Failed to execute the program using JAR file."
      exit 1
    fi
  else
    echo "Failed to execute the program using class name. LibraryManagementSystem.jar not found."
    exit 1
  fi
fi

exit 0