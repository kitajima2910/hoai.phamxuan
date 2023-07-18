using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace upanh.org
{
    public partial class frmMain : Form
    {
        #region Textbox Padding
        private const int EM_SETRECT = 0xB3;

        [DllImport(@"User32.dll", EntryPoint = @"SendMessage", CharSet = CharSet.Auto)]
        private static extern int SendMessageRefRect(IntPtr hWnd, uint msg, int wParam, ref RECT rect);

        [StructLayout(LayoutKind.Sequential)]
        private struct RECT
        {
            public readonly int Left;
            public readonly int Top;
            public readonly int Right;
            public readonly int Bottom;

            private RECT(int left, int top, int right, int bottom)
            {
                Left = left;
                Top = top;
                Right = right;
                Bottom = bottom;
            }

            public RECT(Rectangle r) : this(r.Left, r.Top, r.Right, r.Bottom)
            {
            }
        }
        public void SetPadding(TextBox textBox, Padding padding)
        {
            var rect = new Rectangle(padding.Left, padding.Top, textBox.ClientSize.Width - padding.Left - padding.Right, textBox.ClientSize.Height - padding.Top - padding.Bottom);
            RECT rc = new RECT(rect);
            SendMessageRefRect(textBox.Handle, EM_SETRECT, 0, ref rc);
        }
        #endregion

        private int i = 1;

        public frmMain()
        {
            InitializeComponent();
        }

        private void btnSelect_Click(object sender, EventArgs e)
        {
            ofdImage.Filter = GetImageFilter();
            if(ofdImage.ShowDialog() == DialogResult.OK)
            {
                txtShowPath.Text = ofdImage.FileName;
                pbShow.ImageLocation = ofdImage.FileName;
            }
        }

        private void frmMain_Load(object sender, EventArgs e)
        {
            //Thread thread = new Thread(Marquee);
            //thread.Start();

            //tMarquee.Start();

            SetPadding(txtShowPath, new Padding(5, 5, 5, 5));
            SetPadding(txtResultUrl, new Padding(5, 5, 5, 5));
        }

        private void Marquee()
        {
            while(true)
            {
                lMarquee.Left += i;
                if (lMarquee.Left >= (this.Size.Width - lMarquee.Size.Width - 25) || lMarquee.Left <= 10)
                {
                    i = -i;
                }
                Thread.Sleep(10);
            }
        }

        private static string GetImageFilter()
        {
            return
                "All Files (*.*)|*.*" +
                "|All Pictures (*.emf;*.wmf;*.jpg;*.jpeg;*.jfif;*.jpe;*.png;*.bmp;*.dib;*.rle;*.gif;*.emz;*.wmz;*.tif;*.tiff;*.svg;*.ico)" +
                    "|*.emf;*.wmf;*.jpg;*.jpeg;*.jfif;*.jpe;*.png;*.bmp;*.dib;*.rle;*.gif;*.emz;*.wmz;*.tif;*.tiff;*.svg;*.ico" +
                "|Windows Enhanced Metafile (*.emf)|*.emf" +
                "|Windows Metafile (*.wmf)|*.wmf" +
                "|JPEG File Interchange Format (*.jpg;*.jpeg;*.jfif;*.jpe)|*.jpg;*.jpeg;*.jfif;*.jpe" +
                "|Portable Network Graphics (*.png)|*.png" +
                "|Bitmap Image File (*.bmp;*.dib;*.rle)|*.bmp;*.dib;*.rle" +
                "|Compressed Windows Enhanced Metafile (*.emz)|*.emz" +
                "|Compressed Windows MetaFile (*.wmz)|*.wmz" +
                "|Tag Image File Format (*.tif;*.tiff)|*.tif;*.tiff" +
                "|Scalable Vector Graphics (*.svg)|*.svg" +
                "|Icon (*.ico)|*.ico";
        }

        private void tMarquee_Tick(object sender, EventArgs e)
        {
            lMarquee.Left += i;
            if (lMarquee.Left >= (this.Size.Width - lMarquee.Size.Width - 25) || lMarquee.Left <= 10)
            {
                i = -i;
            }
        }

        private void btnUpload_Click(object sender, EventArgs e)
        {
            if(txtShowPath.Text.Trim().Length > 0)
            {
                //Thread thread = new Thread(Upload);
                //thread.Start();

                Upload();
            }
            else
            {
                MessageBox.Show("Bạn cần chọn ảnh trước khi tải ảnh lên!", "THÔNG BÁO");
            }
        }

        private void Upload()
        {
            // Off Console
            ChromeDriverService chromeDriverService = ChromeDriverService.CreateDefaultService();
            chromeDriverService.HideCommandPromptWindow = true;

            IWebDriver driver = new ChromeDriver(chromeDriverService);
            driver.Url = "https://upanh.tv/?lang=vi";
            driver.Navigate();

            // Button Strart Uploading
            IWebElement btnStartUploading = driver.FindElement(By.Id("anywhere-upload-input"));
            Thread.Sleep(2000);
            btnStartUploading.SendKeys(txtShowPath.Text);

            // Button Upload
            IWebElement btnUpload = driver.FindElement(By.XPath("/html/body/div[3]/div[1]/div/div[2]/div[1]/button"));
            Thread.Sleep(2000);
            btnUpload.Click();

            // Select
            IWebElement codeEmbed = driver.FindElement(By.Id("uploaded-embed-toggle"));
            SelectElement selectCodeEmbed = new SelectElement(codeEmbed);
            Thread.Sleep(5000);
            selectCodeEmbed.SelectByText("Link trực tiếp");

            // Copy
            IWebElement copyLink = driver.FindElement(By.Id("uploaded-embed-code-1"));
            Thread.Sleep(2000);
            txtResultUrl.Text = copyLink.GetAttribute("value");
        }

        private void txtResultUrl_TextChanged(object sender, EventArgs e)
        {
            if(txtResultUrl.Text.Trim().Length > 0)
            {
                btnUpload.Enabled = false;
            }
            else
            {
                btnUpload.Enabled = true;
            }
        }
    }
}
