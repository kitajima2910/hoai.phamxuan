
namespace Selenium
{
    partial class frmMain
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnOpenBrowser = new System.Windows.Forms.Button();
            this.btnOpenBrowser02 = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.txtUrl = new System.Windows.Forms.TextBox();
            this.btn03 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnOpenBrowser
            // 
            this.btnOpenBrowser.Location = new System.Drawing.Point(12, 12);
            this.btnOpenBrowser.Name = "btnOpenBrowser";
            this.btnOpenBrowser.Size = new System.Drawing.Size(125, 52);
            this.btnOpenBrowser.TabIndex = 0;
            this.btnOpenBrowser.TabStop = false;
            this.btnOpenBrowser.Text = "Mở Trình Duyệt Tới Google 01";
            this.btnOpenBrowser.UseVisualStyleBackColor = true;
            this.btnOpenBrowser.Click += new System.EventHandler(this.btnOpenBrowser_Click);
            // 
            // btnOpenBrowser02
            // 
            this.btnOpenBrowser02.Location = new System.Drawing.Point(143, 12);
            this.btnOpenBrowser02.Name = "btnOpenBrowser02";
            this.btnOpenBrowser02.Size = new System.Drawing.Size(125, 52);
            this.btnOpenBrowser02.TabIndex = 1;
            this.btnOpenBrowser02.TabStop = false;
            this.btnOpenBrowser02.Text = "Mở Trình Duyệt Tới Google 02";
            this.btnOpenBrowser02.UseVisualStyleBackColor = true;
            this.btnOpenBrowser02.Click += new System.EventHandler(this.btnOpenBrowser02_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(9, 88);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(82, 17);
            this.label1.TabIndex = 2;
            this.label1.Text = "Đường dẫn:";
            // 
            // txtUrl
            // 
            this.txtUrl.Location = new System.Drawing.Point(97, 85);
            this.txtUrl.Name = "txtUrl";
            this.txtUrl.Size = new System.Drawing.Size(345, 22);
            this.txtUrl.TabIndex = 3;
            this.txtUrl.TabStop = false;
            // 
            // btn03
            // 
            this.btn03.Location = new System.Drawing.Point(12, 131);
            this.btn03.Name = "btn03";
            this.btn03.Size = new System.Drawing.Size(430, 52);
            this.btn03.TabIndex = 4;
            this.btn03.TabStop = false;
            this.btn03.Text = "Test 03: https://katalon-demo-cura.herokuapp.com/profile.php#login";
            this.btn03.UseVisualStyleBackColor = true;
            this.btn03.Click += new System.EventHandler(this.btn03_Click);
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(454, 231);
            this.Controls.Add(this.btn03);
            this.Controls.Add(this.txtUrl);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnOpenBrowser02);
            this.Controls.Add(this.btnOpenBrowser);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "frmMain";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Selenium";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnOpenBrowser;
        private System.Windows.Forms.Button btnOpenBrowser02;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtUrl;
        private System.Windows.Forms.Button btn03;
    }
}

