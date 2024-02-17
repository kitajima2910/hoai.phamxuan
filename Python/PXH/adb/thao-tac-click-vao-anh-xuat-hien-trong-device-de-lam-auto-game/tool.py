import os, time, sys

try:
    import numpy as np
    import threading, subprocess, base64, cv2, random
except:
    os.system("pip install --force-reinstall --no-cache opencv-python==4.5.5.64")
    os.system('pip install numpy')
import numpy as np
import threading, subprocess, base64, cv2, random
from datetime import datetime


class Auto:
    def __init__(self, handle):
        self.handle = handle
        
    def screen_capture(self, name):
        # Chờ 0.5s để thực hiện chụp ảnh màn hình
        time.sleep(0.5)
        os.system(f'adb -s {self.handle} exec-out screencap -p > {name}.png')
        
    def click(self, x, y):
        os.system(f'adb -s {self.handle} shell input tap {x} {y}')
            
    def sendText(self, text):
        os.system(f'adb -s {self.handle} shell input text {text}')
        
    def home(self):
        os.system(f'adb -s {self.handle} shell input keyevent 3')
    
    def enter(self):
        os.system(f'adb -s {self.handle} shell input keyevent 66')
        
    def find(self, img = "", template_pic_name = False, threshold = 0.99):
        if template_pic_name == False:
            self.screen_capture(self.handle)
            template_pic_name = self.handle + '.png'
        else:
            self.screen_capture(template_pic_name)
        
        img = cv2.imread(img)
        img2 = cv2.imread(template_pic_name)
        result = cv2.matchTemplate(img, img2, cv2.TM_CCOEFF_NORMED)
        loc = np.where(result >= threshold)
        test_data = list(zip(*loc[::-1]))
        return test_data

class Starts(threading.Thread):
    def __init__(self, nameLD, i):
        super().__init__()
        self.nameLD = nameLD
        self.device = i
        
    def run(self):
        device = Auto(self.device)
            
        def LDStore(device: Auto):
            while True:
                try:
                    # Nhấp vào biểu tượng LD Store
                    imgLDStore = device.find("LD_Store.png")
                    if imgLDStore > [(0, 0)]:
                        device.click(imgLDStore[0][0], imgLDStore[0][1])
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Da nhap vao 'LD Store' | Time:", time.ctime(time.time()))
                    
                    # Nhấp vào tab Pre-Register
                    imgPre_Register = device.find("Pre_register.png")
                    print("imgPre_Register: ", imgPre_Register)
                    if imgPre_Register > [(0, 0)]:
                        device.click(imgPre_Register[0][0], imgPre_Register[0][1])
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Da nhap vao 'Pre-Register' | Time:", time.ctime(time.time()))
                except:
                    return 0
        
        def searchGames(device: Auto):
            
            # Đọc file txt
            with open("text.txt", "r", encoding="utf8") as f:
                listText = f.read().splitlines()
            
            while True:
                try:
                    # Nhấp vào biểu tượng Search Games
                    imgSearchGames = device.find("Search-games.png")
                    if imgSearchGames > [(0, 0)]:
                        device.click(imgSearchGames[0][0], imgSearchGames[0][1])
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Da nhap vao 'Search games' | Time:", time.ctime(time.time()))
                        
                    # Nhấp vào biểu tượng Search for Apps or Games
                    imgSearchAppsOrGames = device.find("Search-for-apps-or-games.png")
                    if imgSearchAppsOrGames > [(0, 0)]:
                        device.click(imgSearchAppsOrGames[0][0], imgSearchAppsOrGames[0][1])
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Da nhap vao 'Search for apps or games' | Time:", time.ctime(time.time()))
                        
                        # Chọn dòng ngẫu nhiên
                        line = random.choice(listText)
                        device.sendText(line)
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Da nhap vao '", line,"' | Time:", time.ctime(time.time()))
                        
                        device.enter()
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Da nhap vao 'Enter' | Time:", time.ctime(time.time()))
                except:
                    return 0
        
        # LDStore(device)
        searchGames(device)
        
def GetDevices():
        devices = subprocess.check_output("adb devices")
        p = str(devices).replace("b'List of devices attached","").replace('\\r\\n',"").replace(" ","").replace("'","").replace('b*daemonnotrunning.startingitnowonport5037**daemonstartedsuccessfully*Listofdevicesattached',"")
        if len(p) > 0:
            listDevices = p.split("\\tdevice")
            listDevices.pop()
            return listDevices
        else:
            return 0
        
GetDevices()
thread_count = len(GetDevices())

def main(m):
    device = GetDevices()[m]
    run = Starts(device, device, )
    run.run()
        
for m in range(thread_count):
    threading.Thread(target=main, args=(m, )).start()
    