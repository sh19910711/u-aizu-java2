cmake_minimum_required(VERSION 2.8)

find_package(Java REQUIRED)
include(UseJava)

project(ex-review2)
file(GLOB sources *.java)
add_jar(ex-review2 ${sources})

add_jar(testjar packagetest/UsageDemoPackage.java)

