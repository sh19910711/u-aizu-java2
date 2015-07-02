cmake_minimum_required(VERSION 2.8)

find_package(Java REQUIRED)
include(UseJava)

project(ex09)
file(GLOB sources *.java)
message(${sources})
add_jar(ex09 ${sources})

