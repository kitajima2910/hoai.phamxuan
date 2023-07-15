using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ToolActivePXH
{
    public partial class frmMain : Form
    {

        private int DAY = -1;
        //private bool check = false;

        public frmMain()
        {
            InitializeComponent();
        }

        private void txtKey_TextChanged(object sender, EventArgs e)
        {
            //check = false;
            //processMain();
        }

        private void processMain()
        {
            var SIGNATURE = "KITAJIMA";
            var userName = txtUsername.Text;
            var userNameClone = userName.ToUpper();
            if (userNameClone.Length < 8)
            {
                var len = 8 - userNameClone.Length;
                for (int i = 1; i <= len; i++)
                {
                    userNameClone += "M";
                }
            }
            var key = txtKey.Text;

            if (!String.Empty.Equals(txtKey.Text) && !String.Empty.Equals(txtUsername.Text))
            {
                if (txtKey.Text.Length > 0 && txtUsername.Text.Length > 0)
                {
                    key = key.Replace("-", "");
                    var checkSIGNATURE = "";
                    var checkDate = "";
                    var checkDays = "";
                    var checkUsername = "";
                    try
                    {
                        checkSIGNATURE = key.Substring(0, 8);
                        checkDate = key.Substring(8, 16);
                        checkDays = key.Substring(24, key.Length - 32);
                        var checkDaysTemp = checkDays;
                        checkUsername = Reverse(key).Substring(0, 8);

                        bool check = true;

                        if (!CheckSIGNATURE(SIGNATURE, checkSIGNATURE))
                        {
                            check = false;
                        }

                        if (!CheckUsername(userNameClone, checkUsername))
                        {
                            check = false;
                        }

                        if (!CheckAntiHackDate(checkDate, checkDays, key, checkDaysTemp))
                        {
                            lblInfo.Text = "Bạn đang cố tình HACK KEY???";
                            check = false;
                            return;
                        }

                        if (check)
                        {
                            lblStatus.Text = "Trạng thái: Đã kích hoạt";
                            var infor = "";
                            infor += "Thông tin:";
                            infor += "\n - Tài khoản: " + userName;
                            infor += "\n - Thời hạn: " + DAY + " ngày";
                            lblInfo.Text = infor;
                            lblKey.Text = txtKey.Text;
                        }
                        else
                        {
                            lblStatus.Text = "Trạng thái: Chưa Có";
                            lblInfo.Text = "Thông tin: Chưa Có";
                            lblKey.Text = "SAI KEY + TÀI KHOẢN KÍCH HOẠT";
                        }
                    }
                    catch
                    {
                        lblStatus.Text = "Trạng thái: Chưa Có";
                        lblInfo.Text = "Thông tin: Chưa Có";
                        lblKey.Text = "";
                    }
                }
                else
                {
                    lblStatus.Text = "Trạng thái: Chưa Có";
                    lblInfo.Text = "Thông tin: Chưa Có";
                    lblKey.Text = "";
                }
            }
            else
            {
                lblStatus.Text = "Trạng thái: Chưa Có";
                lblInfo.Text = "Thông tin: Chưa Có";
                lblKey.Text = "";
            }
        }

        public static string Reverse(string s)
        {
            char[] charArray = s.ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray);
        }


        private bool CheckSIGNATURE(string SIGNATURE, string chain)
        {
            var charSIGNATURE = SIGNATURE.ToCharArray();
            var charChain = chain.ToCharArray();

            for (int i = 0; i < charSIGNATURE.Length; i++)
            {
                for (int j = 0; j < charChain.Length; j++)
                {
                    if (charSIGNATURE[i] == charChain[j])
                    {
                        charChain[j] = char.Parse(" ");
                        break;
                    }
                }
            }


            return String.Join("", charChain).Trim().Length == 0;
        }

        private bool CheckUsername(string Username, string chain)
        {
            var charUsername = Username.ToCharArray();
            var charChain = chain.ToCharArray();

            for (int i = 0; i < charUsername.Length; i++)
            {
                for (int j = 0; j < charChain.Length; j++)
                {
                    if (charUsername[i] == charChain[j])
                    {
                        charChain[j] = char.Parse(" ");
                        break;
                    }
                }
            }


            return String.Join("", charChain).Trim().Length == 0;
        }

        private bool CheckAntiHackDate(string checkDate, string checkDays, string key, string checkDaysTemp)
        {
            // Get DateTime
            var dateToStrs = new Dictionary<int, string>()
            {
                { 0, "OP" }, { 1, "IO" }, { 2, "AS" }, { 3, "ER" }, { 4, "UI" },
                { 5, "SD" }, { 6, "YU" }, { 7, "TY" }, { 8, "BN" }, { 9, "XC" }
            };

            foreach (KeyValuePair<int, string> dts in dateToStrs)
            {
                if(checkDate.Contains(dts.Value))
                {
                    checkDate = checkDate.Replace(dts.Value, dts.Key.ToString());
                }
            }

            // Get Days
            var daysToStrs = new Dictionary<int, string>()
            {
                { 0, "ZERO" }, { 1, "ONEE" }, { 2, "TWOO" }, { 3, "THRE" }, { 4, "FOUR" },
                { 5, "FIVE" }, { 6, "SIXX" }, { 7, "SEVE" }, { 8, "EIGH" }, { 9, "NICE" }
            };

            foreach (KeyValuePair<int, string> dsts in daysToStrs)
            {
                if (checkDays.Contains(dsts.Value))
                {
                    checkDays = checkDays.Replace(dsts.Value, dsts.Key.ToString());
                }
            }

            // Check Anti Hack
            var year = DateTime.Now.Year.ToString();
            var month = DateTime.Now.Month < 10 ? "0" + DateTime.Now.Month.ToString() : DateTime.Now.Month.ToString();
            var day = DateTime.Now.Day < 10 ? "0" + DateTime.Now.Day.ToString() : DateTime.Now.Day.ToString();

            var yearCus = checkDate.Substring(0, 4);
            var monthCus = checkDate.Substring(4, 2);
            var dayCus = checkDate.Substring(6, 2);

            // Way 1
            DateTime dateTime1 = new DateTime();
            dateTime1 = Convert.ToDateTime(year + "/" + month + "/" + day);
            DateTimePicker dtpDateSystem = new DateTimePicker();
            dtpDateSystem.Value = dateTime1;

            DateTime dateTime2 = new DateTime();
            dateTime2 = Convert.ToDateTime(yearCus + "/" + monthCus + "/" + dayCus);
            DateTimePicker dtpDateCustomize = new DateTimePicker();
            dtpDateCustomize.Value = dateTime2;

            int days = dtpDateCustomize.Value.DayOfYear - dtpDateSystem.Value.DayOfYear;
            DAY = days;

            // Way 2
            DateTime dt1 = dtpDateSystem.Value;
            DateTime dt2 = dtpDateCustomize.Value;

            TimeSpan ts = dt2 - dt1;

            int days02 = ts.Days;
            DAY = days02;

            return days02 == Int32.Parse(checkDays) && key.Contains(days02 < 10 && !checkDaysTemp.Contains("ZERO") ? "ZERO" + checkDaysTemp : checkDaysTemp);
        }

        private void txtUsername_TextChanged(object sender, EventArgs e)
        {
            //check = false;
            //processMain();
        }

        private void btnCheck_Click(object sender, EventArgs e)
        {
            //check = false;
            processMain();
        }
    }
}
