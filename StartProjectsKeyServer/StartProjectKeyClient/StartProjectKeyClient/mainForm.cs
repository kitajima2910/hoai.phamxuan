using RestSharp;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace StartProjectKeyClient
{
    public partial class mainForm : Form
    {
        public mainForm()
        {
            InitializeComponent();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void mainForm_Load(object sender, EventArgs e)
        {
            AppService.rsaForClient = new RSACryptoServiceProvider();
            AppService.rsaForServer = new RSACryptoServiceProvider();

            if (!AppService.LoadServerPublic() || !AppService.LoadClientPrivate())
            {
                MessageBox.Show("Không thể khởi tạo kết nối bảo mật!", "Hệ thống", MessageBoxButtons.OK, MessageBoxIcon.Error);
                Environment.Exit(0);
            }
        }

        private void btnSend_Click(object sender, EventArgs e)
        {
            string biosSerial = AppService.getBiosSerial();
            biosSerial = AppService.MD5Hash(biosSerial);
            //var encryptedData = AppService.rsaForServer.Encrypt(Encoding.UTF8.GetBytes(biosSerial), false);
            var encryptedData = RSAKey.RsaEncryptWithPublic(biosSerial, AppService.serverPublic);
            //string requestData = Convert.ToBase64String(encryptedData);
            RestClient restClient = new RestClient("http://testrsakey.com");
            RestRequest restRequest = new RestRequest(Method.POST);
            restRequest.AddParameter("data", encryptedData);
            IRestResponse response = restClient.Execute(restRequest);
            string responseData = response.Content;
            MsgRes msgRes = JsonSerializer.Deserialize<MsgRes>(responseData);
            //var decryptedData = AppService.rsaForClient.Decrypt(Convert.FromBase64String(msgRes.data), false);
            var decryptedData = RSAKey.RsaDecryptWithPrivate(msgRes.data, AppService.clientPrivate);
            //rtxtContent.Text = Encoding.UTF8.GetString(decryptedData);
            rtxtContent.Text = decryptedData;
        }
    }
}
