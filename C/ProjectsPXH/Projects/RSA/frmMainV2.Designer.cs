
namespace RSA
{
    partial class frmMainV2
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
            this.components = new System.ComponentModel.Container();
            this.siticoneDragControl = new ns1.SiticoneDragControl(this.components);
            this.btnClose = new ns1.SiticoneButton();
            this.btnPrivateKey = new ns1.SiticoneButton();
            this.btnPublicKey = new ns1.SiticoneButton();
            this.label1 = new System.Windows.Forms.Label();
            this.rtxtPrivateKey = new System.Windows.Forms.RichTextBox();
            this.rtxtPublicKey = new System.Windows.Forms.RichTextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.rtxtContent = new System.Windows.Forms.RichTextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.rtxtEncrypt = new System.Windows.Forms.RichTextBox();
            this.rtxtDecrypt = new System.Windows.Forms.RichTextBox();
            this.btnEncrypt = new ns1.SiticoneButton();
            this.btnDecrypt = new ns1.SiticoneButton();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.cbLength = new ns1.SiticoneComboBox();
            this.btnCreate = new ns1.SiticoneButton();
            this.btnSavePrivateKey = new ns1.SiticoneButton();
            this.btnSavePublicKey = new ns1.SiticoneButton();
            this.btnTutorial = new ns1.SiticoneButton();
            this.SuspendLayout();
            // 
            // siticoneDragControl
            // 
            this.siticoneDragControl.TargetControl = this;
            // 
            // btnClose
            // 
            this.btnClose.CheckedState.Parent = this.btnClose;
            this.btnClose.CustomImages.Parent = this.btnClose;
            this.btnClose.FillColor = System.Drawing.Color.Red;
            this.btnClose.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.btnClose.ForeColor = System.Drawing.Color.White;
            this.btnClose.HoveredState.Parent = this.btnClose;
            this.btnClose.Location = new System.Drawing.Point(1051, 12);
            this.btnClose.Name = "btnClose";
            this.btnClose.ShadowDecoration.Parent = this.btnClose;
            this.btnClose.Size = new System.Drawing.Size(25, 25);
            this.btnClose.TabIndex = 0;
            this.btnClose.TabStop = false;
            this.btnClose.Text = "X";
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // btnPrivateKey
            // 
            this.btnPrivateKey.CheckedState.Parent = this.btnPrivateKey;
            this.btnPrivateKey.CustomImages.Parent = this.btnPrivateKey;
            this.btnPrivateKey.FillColor = System.Drawing.Color.Red;
            this.btnPrivateKey.Font = new System.Drawing.Font("Segoe UI", 9F, System.Drawing.FontStyle.Bold);
            this.btnPrivateKey.ForeColor = System.Drawing.Color.White;
            this.btnPrivateKey.HoveredState.Parent = this.btnPrivateKey;
            this.btnPrivateKey.Location = new System.Drawing.Point(111, 154);
            this.btnPrivateKey.Name = "btnPrivateKey";
            this.btnPrivateKey.ShadowDecoration.Parent = this.btnPrivateKey;
            this.btnPrivateKey.Size = new System.Drawing.Size(148, 30);
            this.btnPrivateKey.TabIndex = 1;
            this.btnPrivateKey.TabStop = false;
            this.btnPrivateKey.Text = "Chọn Private Key";
            this.btnPrivateKey.Click += new System.EventHandler(this.btnPrivateKey_Click);
            // 
            // btnPublicKey
            // 
            this.btnPublicKey.CheckedState.Parent = this.btnPublicKey;
            this.btnPublicKey.CustomImages.Parent = this.btnPublicKey;
            this.btnPublicKey.FillColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(180)))), ((int)(((byte)(97)))));
            this.btnPublicKey.Font = new System.Drawing.Font("Segoe UI", 9F, System.Drawing.FontStyle.Bold);
            this.btnPublicKey.ForeColor = System.Drawing.Color.White;
            this.btnPublicKey.HoveredState.Parent = this.btnPublicKey;
            this.btnPublicKey.Location = new System.Drawing.Point(654, 154);
            this.btnPublicKey.Name = "btnPublicKey";
            this.btnPublicKey.ShadowDecoration.Parent = this.btnPublicKey;
            this.btnPublicKey.Size = new System.Drawing.Size(148, 30);
            this.btnPublicKey.TabIndex = 2;
            this.btnPublicKey.TabStop = false;
            this.btnPublicKey.Text = "Chọn Public Key";
            this.btnPublicKey.Click += new System.EventHandler(this.btnPublicKey_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(254)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(9, 166);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(96, 17);
            this.label1.TabIndex = 3;
            this.label1.Text = "Private Key:";
            // 
            // rtxtPrivateKey
            // 
            this.rtxtPrivateKey.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(46)))), ((int)(((byte)(52)))), ((int)(((byte)(54)))));
            this.rtxtPrivateKey.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.rtxtPrivateKey.ForeColor = System.Drawing.Color.White;
            this.rtxtPrivateKey.Location = new System.Drawing.Point(12, 186);
            this.rtxtPrivateKey.Name = "rtxtPrivateKey";
            this.rtxtPrivateKey.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.None;
            this.rtxtPrivateKey.Size = new System.Drawing.Size(514, 162);
            this.rtxtPrivateKey.TabIndex = 4;
            this.rtxtPrivateKey.TabStop = false;
            this.rtxtPrivateKey.Text = "";
            // 
            // rtxtPublicKey
            // 
            this.rtxtPublicKey.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(46)))), ((int)(((byte)(52)))), ((int)(((byte)(54)))));
            this.rtxtPublicKey.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.rtxtPublicKey.ForeColor = System.Drawing.Color.White;
            this.rtxtPublicKey.Location = new System.Drawing.Point(562, 186);
            this.rtxtPublicKey.Name = "rtxtPublicKey";
            this.rtxtPublicKey.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.None;
            this.rtxtPublicKey.Size = new System.Drawing.Size(514, 162);
            this.rtxtPublicKey.TabIndex = 4;
            this.rtxtPublicKey.TabStop = false;
            this.rtxtPublicKey.Text = "";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(254)));
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(559, 166);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(89, 17);
            this.label2.TabIndex = 3;
            this.label2.Text = "Public Key:";
            // 
            // rtxtContent
            // 
            this.rtxtContent.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(46)))), ((int)(((byte)(52)))), ((int)(((byte)(54)))));
            this.rtxtContent.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.rtxtContent.ForeColor = System.Drawing.Color.White;
            this.rtxtContent.Location = new System.Drawing.Point(12, 397);
            this.rtxtContent.Name = "rtxtContent";
            this.rtxtContent.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.None;
            this.rtxtContent.Size = new System.Drawing.Size(1064, 162);
            this.rtxtContent.TabIndex = 4;
            this.rtxtContent.TabStop = false;
            this.rtxtContent.Text = "";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(254)));
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(12, 377);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(173, 17);
            this.label3.TabIndex = 3;
            this.label3.Text = "Nội Dung Cần Mã Hoá:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(254)));
            this.label4.ForeColor = System.Drawing.Color.White;
            this.label4.Location = new System.Drawing.Point(111, 596);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(160, 17);
            this.label4.TabIndex = 3;
            this.label4.Text = "Nội Dung Đã Mã Hoá";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(254)));
            this.label5.ForeColor = System.Drawing.Color.White;
            this.label5.Location = new System.Drawing.Point(658, 596);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(160, 17);
            this.label5.TabIndex = 3;
            this.label5.Text = "Nội Dung Đã Giải Mã";
            // 
            // rtxtEncrypt
            // 
            this.rtxtEncrypt.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(46)))), ((int)(((byte)(52)))), ((int)(((byte)(54)))));
            this.rtxtEncrypt.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.rtxtEncrypt.ForeColor = System.Drawing.Color.White;
            this.rtxtEncrypt.Location = new System.Drawing.Point(12, 619);
            this.rtxtEncrypt.Name = "rtxtEncrypt";
            this.rtxtEncrypt.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.None;
            this.rtxtEncrypt.Size = new System.Drawing.Size(514, 162);
            this.rtxtEncrypt.TabIndex = 4;
            this.rtxtEncrypt.TabStop = false;
            this.rtxtEncrypt.Text = "";
            // 
            // rtxtDecrypt
            // 
            this.rtxtDecrypt.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(46)))), ((int)(((byte)(52)))), ((int)(((byte)(54)))));
            this.rtxtDecrypt.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.rtxtDecrypt.ForeColor = System.Drawing.Color.White;
            this.rtxtDecrypt.Location = new System.Drawing.Point(562, 619);
            this.rtxtDecrypt.Name = "rtxtDecrypt";
            this.rtxtDecrypt.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.None;
            this.rtxtDecrypt.Size = new System.Drawing.Size(514, 162);
            this.rtxtDecrypt.TabIndex = 4;
            this.rtxtDecrypt.TabStop = false;
            this.rtxtDecrypt.Text = "";
            // 
            // btnEncrypt
            // 
            this.btnEncrypt.CheckedState.Parent = this.btnEncrypt;
            this.btnEncrypt.CustomImages.Parent = this.btnEncrypt;
            this.btnEncrypt.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnEncrypt.ForeColor = System.Drawing.Color.White;
            this.btnEncrypt.HoveredState.Parent = this.btnEncrypt;
            this.btnEncrypt.Location = new System.Drawing.Point(15, 583);
            this.btnEncrypt.Name = "btnEncrypt";
            this.btnEncrypt.ShadowDecoration.Parent = this.btnEncrypt;
            this.btnEncrypt.Size = new System.Drawing.Size(90, 30);
            this.btnEncrypt.TabIndex = 5;
            this.btnEncrypt.TabStop = false;
            this.btnEncrypt.Text = "Encrypt";
            this.btnEncrypt.Click += new System.EventHandler(this.btnEncrypt_Click);
            // 
            // btnDecrypt
            // 
            this.btnDecrypt.CheckedState.Parent = this.btnDecrypt;
            this.btnDecrypt.CustomImages.Parent = this.btnDecrypt;
            this.btnDecrypt.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnDecrypt.ForeColor = System.Drawing.Color.White;
            this.btnDecrypt.HoveredState.Parent = this.btnDecrypt;
            this.btnDecrypt.Location = new System.Drawing.Point(562, 583);
            this.btnDecrypt.Name = "btnDecrypt";
            this.btnDecrypt.ShadowDecoration.Parent = this.btnDecrypt;
            this.btnDecrypt.Size = new System.Drawing.Size(90, 30);
            this.btnDecrypt.TabIndex = 5;
            this.btnDecrypt.TabStop = false;
            this.btnDecrypt.Text = "Decrypt";
            this.btnDecrypt.Click += new System.EventHandler(this.btnDecrypt_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(254)));
            this.label6.ForeColor = System.Drawing.Color.White;
            this.label6.Location = new System.Drawing.Point(12, 12);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(669, 25);
            this.label6.TabIndex = 6;
            this.label6.Text = "CHƯƠNG TRÌNH THỬ NGHIỆM RSA OFFLINE - PHẠM XUÂN HOÀI";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(254)));
            this.label7.ForeColor = System.Drawing.Color.White;
            this.label7.Location = new System.Drawing.Point(9, 80);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(60, 17);
            this.label7.TabIndex = 7;
            this.label7.Text = "Độ dài:";
            // 
            // cbLength
            // 
            this.cbLength.BackColor = System.Drawing.Color.Transparent;
            this.cbLength.DrawMode = System.Windows.Forms.DrawMode.OwnerDrawFixed;
            this.cbLength.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbLength.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.cbLength.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(68)))), ((int)(((byte)(88)))), ((int)(((byte)(112)))));
            this.cbLength.FormattingEnabled = true;
            this.cbLength.HoveredState.Parent = this.cbLength;
            this.cbLength.ItemHeight = 30;
            this.cbLength.Items.AddRange(new object[] {
            "512",
            "1024",
            "2048"});
            this.cbLength.ItemsAppearance.Parent = this.cbLength;
            this.cbLength.Location = new System.Drawing.Point(75, 68);
            this.cbLength.Name = "cbLength";
            this.cbLength.ShadowDecoration.Parent = this.cbLength;
            this.cbLength.Size = new System.Drawing.Size(110, 36);
            this.cbLength.TabIndex = 8;
            // 
            // btnCreate
            // 
            this.btnCreate.CheckedState.Parent = this.btnCreate;
            this.btnCreate.CustomImages.Parent = this.btnCreate;
            this.btnCreate.FillColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(180)))), ((int)(((byte)(97)))));
            this.btnCreate.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnCreate.ForeColor = System.Drawing.Color.White;
            this.btnCreate.HoveredState.Parent = this.btnCreate;
            this.btnCreate.Location = new System.Drawing.Point(191, 68);
            this.btnCreate.Name = "btnCreate";
            this.btnCreate.ShadowDecoration.Parent = this.btnCreate;
            this.btnCreate.Size = new System.Drawing.Size(180, 44);
            this.btnCreate.TabIndex = 9;
            this.btnCreate.Text = "Tạo cặp key";
            this.btnCreate.Click += new System.EventHandler(this.btnCreate_Click);
            // 
            // btnSavePrivateKey
            // 
            this.btnSavePrivateKey.CheckedState.Parent = this.btnSavePrivateKey;
            this.btnSavePrivateKey.CustomImages.Parent = this.btnSavePrivateKey;
            this.btnSavePrivateKey.FillColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(180)))), ((int)(((byte)(97)))));
            this.btnSavePrivateKey.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnSavePrivateKey.ForeColor = System.Drawing.Color.White;
            this.btnSavePrivateKey.HoveredState.Parent = this.btnSavePrivateKey;
            this.btnSavePrivateKey.Location = new System.Drawing.Point(377, 68);
            this.btnSavePrivateKey.Name = "btnSavePrivateKey";
            this.btnSavePrivateKey.ShadowDecoration.Parent = this.btnSavePrivateKey;
            this.btnSavePrivateKey.Size = new System.Drawing.Size(180, 44);
            this.btnSavePrivateKey.TabIndex = 9;
            this.btnSavePrivateKey.Text = "Lưu Private Key";
            this.btnSavePrivateKey.Click += new System.EventHandler(this.btnSavePrivateKey_Click);
            // 
            // btnSavePublicKey
            // 
            this.btnSavePublicKey.CheckedState.Parent = this.btnSavePublicKey;
            this.btnSavePublicKey.CustomImages.Parent = this.btnSavePublicKey;
            this.btnSavePublicKey.FillColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(180)))), ((int)(((byte)(97)))));
            this.btnSavePublicKey.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnSavePublicKey.ForeColor = System.Drawing.Color.White;
            this.btnSavePublicKey.HoveredState.Parent = this.btnSavePublicKey;
            this.btnSavePublicKey.Location = new System.Drawing.Point(562, 68);
            this.btnSavePublicKey.Name = "btnSavePublicKey";
            this.btnSavePublicKey.ShadowDecoration.Parent = this.btnSavePublicKey;
            this.btnSavePublicKey.Size = new System.Drawing.Size(180, 44);
            this.btnSavePublicKey.TabIndex = 9;
            this.btnSavePublicKey.Text = "Lưu Public Key";
            this.btnSavePublicKey.Click += new System.EventHandler(this.btnSavePublicKey_Click);
            // 
            // btnTutorial
            // 
            this.btnTutorial.CheckedState.Parent = this.btnTutorial;
            this.btnTutorial.CustomImages.Parent = this.btnTutorial;
            this.btnTutorial.FillColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(111)))), ((int)(((byte)(30)))));
            this.btnTutorial.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnTutorial.ForeColor = System.Drawing.Color.White;
            this.btnTutorial.HoveredState.Parent = this.btnTutorial;
            this.btnTutorial.Location = new System.Drawing.Point(748, 68);
            this.btnTutorial.Name = "btnTutorial";
            this.btnTutorial.ShadowDecoration.Parent = this.btnTutorial;
            this.btnTutorial.Size = new System.Drawing.Size(180, 44);
            this.btnTutorial.TabIndex = 9;
            this.btnTutorial.Text = "Hướng dẫn";
            this.btnTutorial.Click += new System.EventHandler(this.btnTutorial_Click);
            // 
            // frmMainV2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(41)))), ((int)(((byte)(41)))), ((int)(((byte)(41)))));
            this.ClientSize = new System.Drawing.Size(1090, 794);
            this.Controls.Add(this.btnTutorial);
            this.Controls.Add(this.btnSavePublicKey);
            this.Controls.Add(this.btnSavePrivateKey);
            this.Controls.Add(this.btnCreate);
            this.Controls.Add(this.cbLength);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.btnDecrypt);
            this.Controls.Add(this.btnEncrypt);
            this.Controls.Add(this.rtxtDecrypt);
            this.Controls.Add(this.rtxtPublicKey);
            this.Controls.Add(this.rtxtContent);
            this.Controls.Add(this.rtxtEncrypt);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.rtxtPrivateKey);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnPublicKey);
            this.Controls.Add(this.btnPrivateKey);
            this.Controls.Add(this.btnClose);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "frmMainV2";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "frmMainV2";
            this.Load += new System.EventHandler(this.frmMainV2_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private ns1.SiticoneDragControl siticoneDragControl;
        private ns1.SiticoneButton btnClose;
        private ns1.SiticoneButton btnPublicKey;
        private ns1.SiticoneButton btnPrivateKey;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.RichTextBox rtxtPublicKey;
        private System.Windows.Forms.RichTextBox rtxtPrivateKey;
        private System.Windows.Forms.Label label2;
        private ns1.SiticoneButton btnDecrypt;
        private ns1.SiticoneButton btnEncrypt;
        private System.Windows.Forms.RichTextBox rtxtDecrypt;
        private System.Windows.Forms.RichTextBox rtxtContent;
        private System.Windows.Forms.RichTextBox rtxtEncrypt;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private ns1.SiticoneComboBox cbLength;
        private ns1.SiticoneButton btnCreate;
        private ns1.SiticoneButton btnTutorial;
        private ns1.SiticoneButton btnSavePublicKey;
        private ns1.SiticoneButton btnSavePrivateKey;
    }
}