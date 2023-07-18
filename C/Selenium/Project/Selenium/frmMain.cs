using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace Selenium
{
    public partial class frmMain : Form
    {

        public frmMain()
        {
            InitializeComponent();
        }

        private void btnOpenBrowser_Click(object sender, EventArgs e)
        {
            // Ẩn CMD
            ChromeDriverService chromeDriverService = ChromeDriverService.CreateDefaultService();
            chromeDriverService.HideCommandPromptWindow = true;
            
            // Mở trình duyệt vào trang Google
            IWebDriver driver = new ChromeDriver(chromeDriverService);
            driver.Navigate().GoToUrl("https://www.google.com/");

            // Đóng
            //driver.Close();
            IWebElement element = driver.FindElement(By.Name("q"));
            element.SendKeys("Học lập trình C#");
        }

        private void btnOpenBrowser02_Click(object sender, EventArgs e)
        {
            try
            {
                // Mở trình duyệt vào trang Google
                IWebDriver driver = new ChromeDriver();
                driver.Url = txtUrl.Text;
                driver.Navigate();
            }
            catch
            {

            }
        }

        private void btn03_Click(object sender, EventArgs e)
        {
            // Ẩn CMD
            ChromeDriverService chromeDriverService = ChromeDriverService.CreateDefaultService();
            chromeDriverService.HideCommandPromptWindow = true;

            IWebDriver driver = new ChromeDriver(chromeDriverService);
            driver.Url = "https://katalon-demo-cura.herokuapp.com/profile.php#login";
            driver.Navigate();

            IWebElement username = driver.FindElement(By.Name("username"));
            IWebElement password = driver.FindElement(By.Name("password"));
            IWebElement btnLogin = driver.FindElement(By.Id("btn-login"));

            username.SendKeys("hoai.phamxuan");
            password.SendKeys("123456");
            Thread.Sleep(2000);
            btnLogin.Click();
        }
    }
}
