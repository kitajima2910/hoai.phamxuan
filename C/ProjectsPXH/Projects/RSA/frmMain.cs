using Org.BouncyCastle.Asn1.Pkcs;
using Org.BouncyCastle.Asn1.X509;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Encodings;
using Org.BouncyCastle.Crypto.Engines;
using Org.BouncyCastle.Crypto.Generators;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.OpenSsl;
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
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RSA
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
        }

        private void btnCreate_Click(object sender, EventArgs e)
        {

            RsaKeyPairGenerator generator = new RsaKeyPairGenerator();
            generator.Init(new KeyGenerationParameters(new SecureRandom(), Int32.Parse(cbbLength.SelectedItem.ToString())));
            var pair = generator.GenerateKeyPair();


            PrivateKeyInfo privateKeyInfo = PrivateKeyInfoFactory.CreatePrivateKeyInfo(pair.Private);
            byte[] serializedPrivateBytes = privateKeyInfo.ToAsn1Object().GetDerEncoded();
            txtPrivateKey.Clear();
            txtPrivateKey.AppendText("-----BEGIN PRIVATE KEY-----");
            txtPrivateKey.AppendText(Environment.NewLine);
            txtPrivateKey.AppendText(WrapText(Convert.ToBase64String(serializedPrivateBytes), 64));
            txtPrivateKey.AppendText(Environment.NewLine);
            txtPrivateKey.AppendText("-----END PRIVATE KEY-----");

            SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfoFactory.CreateSubjectPublicKeyInfo(pair.Public);
            byte[] serializedPublicBytes = publicKeyInfo.ToAsn1Object().GetDerEncoded();
            txtPublicKey.Clear();
            txtPublicKey.AppendText("-----BEGIN PUBLIC KEY-----");
            txtPublicKey.AppendText(Environment.NewLine);
            txtPublicKey.AppendText(WrapText(Convert.ToBase64String(serializedPublicBytes), 64));
            txtPublicKey.AppendText(Environment.NewLine);
            txtPublicKey.AppendText("-----END PUBLIC KEY-----");

            btnSavePrivateKey.Enabled = true;
            btnSavePublicKey.Enabled = true;
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

        private void frmMain_Load(object sender, EventArgs e)
        {
            cbbLength.SelectedIndex = 2;
            txtPrivateKey.ScrollBars = ScrollBars.Vertical;
            txtPublicKey.ScrollBars = ScrollBars.Vertical;
            txtContent.ScrollBars = ScrollBars.Vertical;
            txtContentEncrypt.ScrollBars = ScrollBars.Vertical;
            txtResult.ScrollBars = ScrollBars.Vertical;
            btnDecryption.Enabled = false;
            btnSavePrivateKey.Enabled = false;
            btnSavePublicKey.Enabled = false;
            btnPrivatePEM.Enabled = false;
            btnPublicPEM.Enabled = false;
            txtPrivateKey.WordWrap = true;
            txtPublicKey.WordWrap = true;
        }

        private void btnEncryption_Click(object sender, EventArgs e)
        {
            if(txtPrivateKey.Text.Trim().Length == 0 || txtPublicKey.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn chưa tạo cặp key!", "HỆ THỐNG", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (txtContent.Text.Trim().Length == 0)
            {
                MessageBox.Show("Bạn chưa nhập nội dung!", "HỆ THỐNG", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            try
            {
                var encrypt = RSA2910EncryptAndDecrypt.RsaEncryptWithPublic(txtContent.Text, txtPublicKey.Text);
                txtResult.Text = encrypt;
                lblEncrypt.Text = encrypt;
                txtContentEncrypt.Text = encrypt;
                btnDecryption.Enabled = true;
            }
            catch
            {
                MessageBox.Show("Dữ liệu quá lớn!", "HỆ THỐNG", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            
        }

        private void btnDecryption_Click(object sender, EventArgs e)
        {
            try
            {
                txtResult.Text = RSA2910EncryptAndDecrypt.RsaDecryptWithPrivate(lblEncrypt.Text, txtPrivateKey.Text);
            }
            catch
            {
                MessageBox.Show("Private Key của bạn không đúng!", "HỆ THỐNG", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
        }

        private void btnSavePrivateKey_Click(object sender, EventArgs e)
        {
            saveFile("Private Key", txtPrivateKey.Text);
        }

        private void btnSavePublicKey_Click(object sender, EventArgs e)
        {
            saveFile("Public Key", txtPublicKey.Text);
        }

        private void saveFile(string nameKey, string content)
        {
            SaveFileDialog saveFileDialog = new SaveFileDialog();
            saveFileDialog.Title = "Lưu " + nameKey;
            saveFileDialog.DefaultExt = "pem";
            saveFileDialog.Filter = "PEM|*.pem";


            var sdl = saveFileDialog.ShowDialog();
            if(sdl == DialogResult.OK)
            {
                File.WriteAllText(saveFileDialog.FileName, content);
            }

            saveFileDialog.Dispose();
        }

        private (string, string) openFile(string nameKey)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            openFileDialog.Title = "Mở " + nameKey;
            openFileDialog.DefaultExt = "pem";
            openFileDialog.Filter = "PEM|*.pem";

            var ofd = openFileDialog.ShowDialog();
            string content = default;
            if(ofd == DialogResult.OK)
            {
                content = File.ReadAllText(openFileDialog.FileName);
            }

            openFileDialog.Dispose();
            return (content, openFileDialog.FileName);
        }

        private void btnTutorial_Click(object sender, EventArgs e)
        {
            StringBuilder builder = new StringBuilder();
            builder.Append("Bước 1: Chọn độ lớn của key, có các lựa chọn [80, 112, 512, 1024, 2048, 4096] bit, số bit càng cao có độ bảo mật càng cao và giải mã càng lâu, ngược lại số bit càng nhỏ độ bảo mật thấp và giải mã nhanh hơn!\n\n");
            builder.Append("Bước 2: Nhấn vào tạo cặp key.\n\n");
            builder.Append("Bước 3: Thử nghiệm mã hoá và giải mã bằng cách nhập nội dung và chạy thử.\n\n");
            builder.Append("Bước 4: Lưu lại cặp key dưới dạng file .pem để sử dụng!\n\n");
            builder.Append("Bước 5: Có thể thử nghiệm với file .pem");
            MessageBox.Show(builder.ToString(), "HỆ THỐNG", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void btnPrivatePEM_Click(object sender, EventArgs e)
        {
            (txtPrivateKey.Text, txtPemPrivate.Text) = openFile("Private Key");
        }

        private void btnPublicPEM_Click(object sender, EventArgs e)
        {
            (txtPublicKey.Text, txtPemPublic.Text) = openFile("Public Key");
        }

        private void btnModeFile_Click(object sender, EventArgs e)
        {
            btnPublicPEM.Enabled = !btnPublicPEM.Enabled;
            btnPrivatePEM.Enabled = !btnPrivatePEM.Enabled;
            btnCreate.Enabled = !btnCreate.Enabled;

            if(!btnCreate.Enabled)
            {
                btnModeFile.Text = "Test Tạo Key";
                btnSavePrivateKey.Enabled = false;
                btnSavePublicKey.Enabled = false;
                txtPublicKey.Clear();
                txtPrivateKey.Clear();
                btnDecryption.Enabled = false;
            }
            else
            {
                btnModeFile.Text = "Test File PEM";
                txtPublicKey.Clear();
                txtPrivateKey.Clear();
                txtPemPublic.Clear();
                txtPemPrivate.Clear();
            }
        }
    }
}