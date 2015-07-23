cmake_minimum_required(VERSION 2.8)

find_package(Java REQUIRED)
include(UseJava)

project(ex-review3)
file(GLOB sources *.java)
add_jar(ex-review3 ${sources})

