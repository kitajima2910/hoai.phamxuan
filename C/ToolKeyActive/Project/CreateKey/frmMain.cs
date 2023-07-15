using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CreateKey
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
        }

        private void frmMain_Load(object sender, EventArgs e)
        {
            txtUsername.Text = "Tài khoản";
            txtUsername.ForeColor = Color.Red;
        }

        private void txtUsername_Enter(object sender, EventArgs e)
        {
            if("Tài khoản".Equals(txtUsername.Text))
            {
                txtUsername.Text = String.Empty;
                txtUsername.ForeColor = Color.Black;
            }
        }

        private void txtUsername_Leave(object sender, EventArgs e)
        {
            if(String.Empty.Equals(txtUsername.Text))
            {
                txtUsername.Text = "Tài khoản";
                txtUsername.ForeColor = Color.Red;
            }
        }

        private void btnCreatKey_Click(object sender, EventArgs e)
        {
            var SIGNATURE = "KITAJIMA";
            var userName = "Tài khoản".Equals(txtUsername.Text) ? "" : txtUsername.Text.ToUpper();

            if(userName.Trim().Length == 0)
            {
                MessageBox.Show("Tên đang rỗng", "Thông báo");
                return;
            }

            if (userName.Length < 8)
            {
                var len = 8 - userName.Length;
                for (int i = 1; i <= len; i++)
                {
                    userName += "M";
                }
            }

            // Get Date
            var year = dtpDate.Value.Year.ToString().Select(y => int.Parse(y.ToString())).ToArray();
            var month = dtpDate.Value.Month.ToString().Select(m => int.Parse(m.ToString())).ToArray();
            var day = dtpDate.Value.Day.ToString().Select(d => int.Parse(d.ToString())).ToArray();

            // Encode Date
            var dateToStrs = new Dictionary<int, string>()
            {
                { 0, "OP" }, { 1, "IO" }, { 2, "AS" }, { 3, "ER" }, { 4, "UI" },
                { 5, "SD" }, { 6, "YU" }, { 7, "TY" }, { 8, "BN" }, { 9, "XC" }
            };

            var encodeDate = "";
            encodeDate += createEncodeDate(dateToStrs, year, true);
            encodeDate += createEncodeDate(dateToStrs, month, true);
            encodeDate += createEncodeDate(dateToStrs, day, true);


            if(resultDays().Equals(String.Empty))
            {
                return;
            }

            txtResultKey.Text = (shuffle(SIGNATURE) + encodeDate + resultDays() + shuffle(userName));
            txtResultKey.ForeColor = Color.Blue;
        }


        private string createNewString(string chain)
        {
            string[] chains = chain.ToCharArray().Select(c => c.ToString()).ToArray();
            int count = 1;
            string newChain = "";
            for(int i = 0; i < chains.Length; i++)
            {
                newChain += chains[i];
                if (count == 5)
                {
                    newChain += " ";
                    count = 0;
                }
                count++;
            }
            return newChain.Trim().Replace(' ', '-');
        }

        private string createEncodeDate(Dictionary<int, string> dateToStrs,  int[] numbers, bool flag = true)
        {
            var encodeDate = new List<string>();

            if(numbers.Length == 1)
            {
                var numTemp = numbers[0];
                numbers = new int[2];
                numbers[0] = 0;
                numbers[1] = numTemp;
            }

            foreach(int num in numbers)
            {
                foreach (KeyValuePair<int, string> dts in dateToStrs)
                {
                    if (num == dts.Key)
                    {
                        encodeDate.Add(dts.Value);
                    }
                }
            }
            
            return String.Join("", encodeDate.ToArray());
        }

        private string createEncodeDate(Dictionary<int, string> dateToStrs, int[] numbers)
        {
            var encodeDate = "";

            foreach (int num in numbers)
            {
                foreach (KeyValuePair<int, string> dts in dateToStrs)
                {
                    if (num == dts.Key)
                    {
                        encodeDate += dts.Value;
                    }
                }
            }

            return encodeDate;
        }

        private string shuffle(string chain)
        {
            Random random = new Random();
            var chains = chain.ToCharArray().Select(c => c.ToString())
                              .OrderBy(x => random.Next(-1, 1))
                              .OrderBy(x => random.Next(-1, 1))
                              .OrderBy(x => random.Next(-1, 1))
                              .OrderBy(x => random.Next(-1, 1))
                              .OrderBy(x => random.Next(-1, 1))
                              .ToArray();
            return String.Join("", chains);
        }

        private string shuffle(string[] chains, bool flag = true)
        {
            Random random = new Random();
            return String.Join("", chains.Select(c => c.ToString())
                              .OrderBy(x => random.Next(-1, 1))
                              .OrderBy(x => random.Next(-1, 1))
                              .OrderBy(x => random.Next(-1, 1))
                              .OrderBy(x => random.Next(-1, 1))
                              .OrderBy(x => random.Next(-1, 1))
                              .ToArray());
        }

        private string resultDays()
        {
            var year = DateTime.Now.Year.ToString();
            var month = DateTime.Now.Month < 10 ? "0" + DateTime.Now.Month.ToString() : DateTime.Now.Month.ToString();
            var day = DateTime.Now.Day < 10 ? "0" + DateTime.Now.Day.ToString() : DateTime.Now.Day.ToString();

            var yearCus = dtpDate.Value.Year;
            var monthCus = dtpDate.Value.Month < 10 ? "0" + dtpDate.Value.Month.ToString() : dtpDate.Value.Month.ToString();
            var dayCus = dtpDate.Value.Day < 10 ? "0" + dtpDate.Value.Day.ToString() : dtpDate.Value.Day.ToString();

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


            // Way 2
            DateTime dt1 = dtpDateSystem.Value;
            DateTime dt2 = dtpDateCustomize.Value;

            TimeSpan ts = dt2 - dt1;

            int days02 = ts.Days;


            if (days02 < 1 || days02 > 999)
            {
                MessageBox.Show("Ngày phải >= 1 và <= 999", "Thông báo");
                return "";
            }


            // Encode Date
            var daysToStrs = new Dictionary<int, string>()
            {
                { 0, "ZERO" }, { 1, "ONEE" }, { 2, "TWOO" }, { 3, "THRE" }, { 4, "FOUR" },
                { 5, "FIVE" }, { 6, "SIXX" }, { 7, "SEVE" }, { 8, "EIGH" }, { 9, "NICE" }
            };

            lblInfo.Text = "Thời gian: " + days02.ToString() + " ngày";
            lblInfo.ForeColor = Color.Red;

            return createEncodeDate(daysToStrs, days02.ToString().Select(y => int.Parse(y.ToString())).ToArray(), true);
        }
    }
}
