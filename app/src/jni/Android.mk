LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE     := patch
LOCAL_SRC_FILES  := patch.c

LOCAL_LDLIBS     := -lz -llog

include $(BUILD_SHARED_LIBRARY)