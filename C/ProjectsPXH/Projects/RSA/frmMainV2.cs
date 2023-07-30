using Org.BouncyCastle.Asn1.Pkcs;
using Org.BouncyCastle.Asn1.X509;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Generators;
using Org.BouncyCastle.Pkcs;
using Org.BouncyCastle.Security;
using Org.BouncyCastle.X509;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RSA
{
    public partial class frmMainV2 : Form
    {
        private string privatePem = string.Empty;
        private string publicPem = string.Empty;
        private RSACryptoServiceProvider rsa = default;

        public frmMainV2()
        {
            InitializeComponent();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnPrivateKey_Click(object sender, EventArgs e)
        {
            try
            {
                rtxtPrivateKey.Clear();
                OpenFileDialog openFile = new OpenFileDialog();
                openFile.Filter = "Private Key .PEM|*.PEM";
                openFile.Title = "Vui lòng chọn Private Key";

                if(openFile.ShowDialog() == DialogResult.OK)
                {
                    if(openFile.FileName != string.Empty)
                    {
                        using (StreamReader sr = new StreamReader(openFile.FileName))
                        {
                            privatePem = sr.ReadToEnd();
                            sr.Close();
                        }
                        rtxtPrivateKey.Text = privatePem;
                    }
                }
                else
                {
                    MessageBox.Show("Vui lòng chọn đúng file và định dạng!", "Hệ thống", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            catch
            {
                MessageBox.Show("Có lỗi trong quá trình tải Private Key!", "Hệ thống", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

        private void frmMainV2_Load(object sender, EventArgs e)
        {
            rsa = new RSACryptoServiceProvider();
            rsa.ExportParameters(true);

            cbLength.SelectedIndex = 1;
        }

        private void btnPublicKey_Click(object sender, EventArgs e)
        {
            try
            {
                rtxtPublicKey.Clear();
                OpenFileDialog openFile = new OpenFileDialog();
                openFile.Filter = "Public Key .PEM|*.PEM";
                openFile.Title = "Vui lòng chọn Public Key";

                if (openFile.ShowDialog() == DialogResult.OK)
                {
                    if (openFile.FileName != string.Empty)
                    {
                        using (StreamReader sr = new StreamReader(openFile.FileName))
                        {
                            publicPem = sr.ReadToEnd();
                            sr.Close();
                        }
                        rtxtPublicKey.Text = publicPem;
                    }
                }
                else
                {
                    MessageBox.Show("Vui lòng chọn đúng file và định dạng!", "Hệ thống", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            catch
            {
                MessageBox.Show("Có lỗi trong quá trình tải Public Key!", "Hệ thống", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

        private void btnEncrypt_Click(object sender, EventArgs e)
        {
            try
            {
                //if (publicPem.Trim().Length == 0)
                //{
                //    publicPem = rtxtPublicKey.Text;
                //}
                rtxtEncrypt.Text = RSA2910EncryptAndDecrypt.RsaEncryptWithPublic(rtxtContent.Text, rtxtPublicKey.Text);
            }
            catch
            {
                MessageBox.Show("Có lỗi trong quá trình mã hoá, vui lòng kiểm tra lại!", "Hệ thống", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnDecrypt_Click(object sender, EventArgs e)
        {
            try
            {
                //if (privatePem.Trim().Length == 0)
                //{
                //    privatePem = rtxtPrivateKey.Text;
                //}
                rtxtDecrypt.Text = RSA2910EncryptAndDecrypt.RsaDecryptWithPrivate(rtxtEncrypt.Text, rtxtPrivateKey.Text);
            }
            catch
            {
                MessageBox.Show("Có lỗi trong quá trình giải mã, vui lòng kiểm tra lại!", "Hệ thống", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnTutorial_Click(object sender, EventArgs e)
        {
            StringBuilder builder = new StringBuilder();
            builder.Append("Bước 1: Chọn độ lớn của key, có các lựa chọn [512, 1024, 2048] bit, số bit càng cao có độ bảo mật càng cao và giải mã càng lâu, ngược lại số bit càng nhỏ độ bảo mật thấp và giải mã nhanh hơn!\n\n");
            builder.Append("Bước 2: Nhấn vào tạo cặp key.\n\n");
            builder.Append("Bước 3: Thử nghiệm mã hoá và giải mã bằng cách nhập nội dung và chạy thử.\n\n");
            builder.Append("Bước 4: Lưu lại cặp key dưới dạng file .pem để sử dụng!\n\n");
            builder.Append("Bước 5: Có thể thử nghiệm với file .pem");
            MessageBox.Show(builder.ToString(), "Hệ thống", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void btnCreate_Click(object sender, EventArgs e)
        {
            RsaKeyPairGenerator generator = new RsaKeyPairGenerator();
            generator.Init(new KeyGenerationParameters(new SecureRandom(), Int32.Parse(cbLength.SelectedItem.ToString())));
            var pair = generator.GenerateKeyPair();


            PrivateKeyInfo privateKeyInfo = PrivateKeyInfoFactory.CreatePrivateKeyInfo(pair.Private);
            byte[] serializedPrivateBytes = privateKeyInfo.ToAsn1Object().GetDerEncoded();
            rtxtPrivateKey.Clear();
            rtxtPrivateKey.AppendText("-----BEGIN PRIVATE KEY-----");
            rtxtPrivateKey.AppendText(Environment.NewLine);
            rtxtPrivateKey.AppendText(WrapText(Convert.ToBase64String(serializedPrivateBytes), 64));
            rtxtPrivateKey.AppendText(Environment.NewLine);
            rtxtPrivateKey.AppendText("-----END PRIVATE KEY-----");
            privatePem = rtxtPrivateKey.Text;

            SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfoFactory.CreateSubjectPublicKeyInfo(pair.Public);
            byte[] serializedPublicBytes = publicKeyInfo.ToAsn1Object().GetDerEncoded();
            rtxtPublicKey.Clear();
            rtxtPublicKey.AppendText("-----BEGIN PUBLIC KEY-----");
            rtxtPublicKey.AppendText(Environment.NewLine);
            rtxtPublicKey.AppendText(WrapText(Convert.ToBase64String(serializedPublicBytes), 64));
            rtxtPublicKey.AppendText(Environment.NewLine);
            rtxtPublicKey.AppendText("-----END PUBLIC KEY-----");
            publicPem = rtxtPublicKey.Text;
        }

        private string WrapText(string text, int maxLineLength)
        {
            StringBuilder wrappedText = new StringBuilder();
            int currentIndex = 0;

            while (currentIndex < text.Length)
            {
                int remainingChars = text.Length - currentIndex;
                int charsToCopy = Math.Min(maxLineLength, remainingChars);

                wrappedText.Append(text, currentIndex, charsToCopy);
                currentIndex += charsToCopy;

                if (currentIndex < text.Length)
                {
                    wrappedText.AppendLine();
                }
            }

            return wrappedText.ToString();
        }

        private void btnSavePrivateKey_Click(object sender, EventArgs e)
        {
            saveFile("Private Key", rtxtPrivateKey.Text);
        }

        private void btnSavePublicKey_Click(object sender, EventArgs e)
        {
            saveFile("Public Key", rtxtPublicKey.Text);
        }

        private void saveFile(string nameKey, string content)
        {
            SaveFileDialog saveFileDialog = new SaveFileDialog();
            saveFileDialog.Title = "Lưu " + nameKey;
            saveFileDialog.DefaultExt = "PEM";
            saveFileDialog.Filter = "PEM|*.PEM";


            var sdl = saveFileDialog.ShowDialog();
            if (sdl == DialogResult.OK)
            {
                File.WriteAllText(saveFileDialog.FileName, content);
            }

            saveFileDialog.Dispose();
        }
    }
}
