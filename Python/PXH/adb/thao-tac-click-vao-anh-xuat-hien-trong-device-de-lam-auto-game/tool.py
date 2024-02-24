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
        time.sleep(.5)
        os.system(f'adb -s {self.handle} exec-out screencap -p > {name}.png')
        
    def click(self, x, y):
        os.system(f'adb -s {self.handle} shell input tap {x} {y}')
            
    def sendText(self, text):
        os.system(f'adb -s {self.handle} shell input text {text}')
        
    def home(self):
        os.system(f'adb -s {self.handle} shell input keyevent 3')
    
    def enter(self):
        os.system(f'adb -s {self.handle} shell input keyevent 66')
        
    def swipe(self, x1, y1, x2, y2):
        os.system(f'adb -s {self.handle} shell input swipe {x1} {y1} {x2} {y2} 1000')
        
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
    def __init__(self, nameLD, i, account):
        super().__init__()
        self.nameLD = nameLD
        self.device = i
        self.account = account
        
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
        
        def testSwipe(device: Auto):
            while True:
                try:
                    # Vuốt lên
                    device.swipe(257.0, 688.6, 253.1, 338.2)
                except:
                    return 0
        
        def zingID(device: Auto):
            while True:
                try:
                    acc = self.account.split(" | ")
                    username = acc[0]
                    password = acc[1]
                    
                    # Nhấp vào System Apps
                    imgSystemApps = device.find("System_Apps.png")
                    if imgSystemApps > [(0, 0)]:
                        device.click(imgSystemApps[0][0], imgSystemApps[0][1])
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'System Apps' | Time:", time.ctime(time.time()))
                    
                    # Nhấp vào Browser
                    imgBrowser = device.find("Browser.png")
                    if imgBrowser > [(0, 0)]:
                        device.click(imgBrowser[0][0], imgBrowser[0][1])
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'Browser' | Time:", time.ctime(time.time()))
                        
                    # Nhấp vào Search Google
                    imgSearchGoogle = device.find("Search-google.png")
                    if imgSearchGoogle > [(0, 0)]:
                        device.click(imgSearchGoogle[0][0], imgSearchGoogle[0][1])
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'Search Google' | Time:", time.ctime(time.time()))
                        
                        # Ghi text "zing id login"
                        device.sendText("zing\ id\ login")
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap 'zing id login' | Time:", time.ctime(time.time()))
                        
                        device.enter()
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhan 'enter' | Time:", time.ctime(time.time()))
                    
                    # Enter khi đã nhập "zing id login"
                    imgTextZingIDLogin = device.find("Zing-id-login.PNG")
                    if imgTextZingIDLogin > [(0, 0)]:
                        device.enter()
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'enter' | Time:", time.ctime(time.time()))
                    
                    
                    # Nhấp vào URL "Zing ID"
                    imgURLZingIDLogin = device.find("Zing-ID-URL.PNG")
                    if imgURLZingIDLogin > [(0, 0)]:
                        device.click(imgURLZingIDLogin[0][0], imgURLZingIDLogin[0][1])
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'URL Zing ID' | Time:", time.ctime(time.time()))
                    
                    # Nhập USER
                    imgUSER = device.find("USER.PNG")
                    if imgUSER > [(0, 0)]:
                        device.click(imgUSER[0][0], imgUSER[0][1])
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'USER' | Time:", time.ctime(time.time()))
                        
                        device.sendText(username)
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao '", username,"' | Time:", time.ctime(time.time()))
                    else:
                        # Nhập PASS
                        imgPASS = device.find("PASS.PNG")
                        if imgPASS > [(0, 0)]:
                            device.click(imgPASS[0][0], imgPASS[0][1])
                            print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'PASS' | Time:", time.ctime(time.time()))
                            
                            device.sendText(password)
                            print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao '", password,"' | Time:", time.ctime(time.time()))
                    
                    # Nhập PASSED
                    imgPASSED = device.find("PASSED.PNG")
                    if imgPASSED > [(0, 0)]:
                        print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'PASSED' | Time:", time.ctime(time.time()))
                        
                        imgLogin = device.find("Login.PNG")
                        if imgLogin > [(0, 0)]:
                            device.click(imgLogin[0][0], imgLogin[0][1])
                            print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'Login' | Time:", time.ctime(time.time()))
                            
                            time.sleep(.3)
                            imgWORNGUSERPASS = device.find("WORNG-USER-PASS.PNG")
                            if imgWORNGUSERPASS > [(0, 0)]:
                                with open("list_tk_sai.txt", "a", encoding="utf8") as f:
                                    f.write("{} | {}\n".format(username, password))
                                print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Viet vao file list_tk_sai.txt | Time:", time.ctime(time.time()))
                                
                                time.sleep(.3)
                                imgURLID = device.find("url_id.PNG")
                                if imgLogin > [(0, 0)]:
                                    device.click(imgURLID[0][0], imgURLID[0][1])
                                    print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'url id.zing.vn' | Time:", time.ctime(time.time()))
                                    
                                    device.sendText("https://id.zing.vn/")
                                    print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'https://id.zing.vn/' | Time:", time.ctime(time.time()))
                                    
                                    device.enter()
                                    print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'enter' | Time:", time.ctime(time.time()))
                                break
                            else:
                                time.sleep(.3)
                                imgExit = device.find("Exit.PNG")
                                if imgExit > [(0, 0)]:
                                    with open("list_tk_dung.txt", "a", encoding="utf8") as f:
                                        f.write("{} | {}\n".format(username, password))
                                    print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Viet vao file list_tk_dung.txt | Time:", time.ctime(time.time()))
                                
                                    device.click(imgExit[0][0], imgExit[0][1])
                                    print(" \033[1;31m |\033[1;37m[", self.nameLD ,"]\033[1;31m Nhap vao 'Thoat' | Time:", time.ctime(time.time()))
                                    break 
                except:
                    return 0
        
        # LDStore(device)
        # searchGames(device)
        # testSwipe(device)
        zingID(device)
        
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

# Lấy data tài khoản từ file list_tk.txt
with open("list_tk.txt", "r", encoding="utf8") as f:
    accounts = f.read().splitlines()
print("PXH: ", accounts, " - : ", len(accounts))

def main(m):
    device = GetDevices()[m]
    for i in range(len(accounts)):
        account = accounts[i]
        run = Starts(device, device, account)
        run.run()
        
for m in range(thread_count):
    threading.Thread(target=main, args=(m, )).start()
    