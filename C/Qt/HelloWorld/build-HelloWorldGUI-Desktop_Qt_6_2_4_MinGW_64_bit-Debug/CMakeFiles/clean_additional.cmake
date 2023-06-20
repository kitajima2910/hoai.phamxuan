# Additional clean files
cmake_minimum_required(VERSION 3.16)

if("${CONFIG}" STREQUAL "" OR "${CONFIG}" STREQUAL "Debug")
  file(REMOVE_RECURSE
  "CMakeFiles\\HelloWorldGUI_autogen.dir\\AutogenUsed.txt"
  "CMakeFiles\\HelloWorldGUI_autogen.dir\\ParseCache.txt"
  "HelloWorldGUI_autogen"
  )
endif()
