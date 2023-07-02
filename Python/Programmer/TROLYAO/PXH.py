import os
import playsound
import speech_recognition as sr
import time
import sys
import ctypes
import wikipedia
import datetime
import json
import re
import webbrowser
import smtplib
import requests
import urllib
import urllib.request as urllib2
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from webdriver_manager.chrome import ChromeDriverManager
from time import strftime
from gtts import gTTS
from youtube_search import YoutubeSearch

language = "vi"

def speak(strText):
    print(f"Máy: {strText}")

    # Truyền strText để đọc lên
    tts = gTTS(text=strText, lang=language, slow=False)
    tts.save("sound.mp3")  # Lưu âm thanh lại
    playsound.playsound("sound.mp3", False)  # Chạy file âm thanh
    os.remove("sound.mp3")  # Xoá file âm thanh, để không bị đầy

def get_voice():
    r = sr.Recognizer()
    with sr.Microphone() as source:
        print("Tôi: ", end="")
        audio = r.listen(source, phrase_time_limit=5)
        try:
            text = r.recognize_google(audio, language="vi-VI")
            print(text)
            return text
        except:
            print("...")
            return 0

def stop():
    speak("Hẹn gặp lại bạn!")

def get_text():
    for i in range(3):
        text = get_voice()
        if text:
            return text.lower()
        elif i < 2:
            speak("Máy không nghe rõ, bạn có thể nói lại không?")
    time.sleep(10)
    stop()
    return 0

def talk(name):
    day_time = int(strftime("%H"))
    if day_time < 12:
        speak(f"Chào buổi sáng {name}. Chúc bạn ngày mới tốt lành!")
    elif day_time < 18:
        speak(f"Chào buổi chiều {name}.")
    else:
        speak(f"Chào buổi tối {name}.")
    time.sleep(5)
    speak(f"Bạn có khoẻ không?")
    time.sleep(3)
    ans = get_voice()
    if ans:
        if "có" in ans:
            speak(f"Thật là tốt!")
        else:
            speak(f"Bạn nên nghỉ ngơi!")

def call_pxh():
    speak("Xin chào!, bạn tên là gì?")
    time.sleep(3)
    name = get_text()

    if name:
        speak(f"Xin chào {name}")
        time.sleep(3)
        speak(f"Bạn cần tôi giúp gì?")
        time.sleep(3)
        while True:
            text = get_text()
            if not text:
                break
            elif "trò chuyện" in text or "nói chuyện" in text:
                talk(name)
            elif "dừng" in text or "thôi" in text or "biến" in text:
                stop()
                break
            
call_pxh()