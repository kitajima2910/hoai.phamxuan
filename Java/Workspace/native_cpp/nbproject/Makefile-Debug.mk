#
# Generated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
GREP=grep
NM=nm
CCADMIN=CCadmin
RANLIB=ranlib
CC=gcc
CCC=g++
CXX=g++
FC=gfortran
AS=as

# Macros
CND_PLATFORM=MinGW-Windows
CND_DLIB_EXT=dll
CND_CONF=Debug
CND_DISTDIR=dist
CND_BUILDDIR=build

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=${CND_BUILDDIR}/${CND_CONF}/${CND_PLATFORM}

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/_ext/94b84731/TestOverloading.o \
	${OBJECTDIR}/_ext/d8c1e291/Overload1.o


# C Compiler Flags
CFLAGS=-m64

# CC Compiler Flags
CCFLAGS=-m64
CXXFLAGS=-m64

# Fortran Compiler Flags
FFLAGS=

# Assembler Flags
ASFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS}
	"${MAKE}"  -f nbproject/Makefile-${CND_CONF}.mk ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/libnative_cpp.${CND_DLIB_EXT}

${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/libnative_cpp.${CND_DLIB_EXT}: ${OBJECTFILES}
	${MKDIR} -p ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}
	${LINK.cc} -o ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/libnative_cpp.${CND_DLIB_EXT} ${OBJECTFILES} ${LDLIBSOPTIONS} -shared

${OBJECTDIR}/_ext/94b84731/TestOverloading.o: /Z/hoai.phamxuan/Java/Workspace/native_cpp/TestOverloading.cpp
	${MKDIR} -p ${OBJECTDIR}/_ext/94b84731
	${RM} "$@.d"
	$(COMPILE.cc) -g -I/C/Program\ Files/Java/jdk1.8.0_281/include -I/C/Program\ Files/Java/jdk1.8.0_281/include/win32 -std=c++14  -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/_ext/94b84731/TestOverloading.o /Z/hoai.phamxuan/Java/Workspace/native_cpp/TestOverloading.cpp

${OBJECTDIR}/_ext/d8c1e291/Overload1.o: /Z/hoai.phamxuan/Java/Workspace/native_cpp/dist/Debug/MinGW-Windows/Overload1.cpp
	${MKDIR} -p ${OBJECTDIR}/_ext/d8c1e291
	${RM} "$@.d"
	$(COMPILE.cc) -g -I/C/Program\ Files/Java/jdk1.8.0_281/include -I/C/Program\ Files/Java/jdk1.8.0_281/include/win32 -std=c++14  -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/_ext/d8c1e291/Overload1.o /Z/hoai.phamxuan/Java/Workspace/native_cpp/dist/Debug/MinGW-Windows/Overload1.cpp

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf: ${CLEAN_SUBPROJECTS}
	${RM} -r ${CND_BUILDDIR}/${CND_CONF}

# Subprojects
.clean-subprojects:

# Enable dependency checking
.dep.inc: .depcheck-impl

include .dep.inc
