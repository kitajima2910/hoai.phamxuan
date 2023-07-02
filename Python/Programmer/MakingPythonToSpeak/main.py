import pyttsx3

engine = pyttsx3.init()

voices = engine.getProperty('voices')
for voice in voices:
    if "vietnam" in voice.name.lower():
        engine.setProperty('voice', voice.id)
        break


if __name__ == "__main__":
    text = "Xin chào, đây là một ví dụ về pyttsx3 đọc tiếng Việt."
    engine.say(text)
    engine.runAndWait()
