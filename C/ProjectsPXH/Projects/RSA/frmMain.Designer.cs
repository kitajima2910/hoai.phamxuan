
namespace RSA
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtPrivateKey = new System.Windows.Forms.TextBox();
            this.txtPublicKey = new System.Windows.Forms.TextBox();
            this.btnCreate = new System.Windows.Forms.Button();
            this.txtContent = new System.Windows.Forms.TextBox();
            this.txtResult = new System.Windows.Forms.TextBox();
            this.btnEncryption = new System.Windows.Forms.Button();
            this.btnDecryption = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.cbbLength = new System.Windows.Forms.ComboBox();
            this.lblEncrypt = new System.Windows.Forms.Label();
            this.txtContentEncrypt = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.btnSavePrivateKey = new System.Windows.Forms.Button();
            this.btnSavePublicKey = new System.Windows.Forms.Button();
            this.btnTutorial = new System.Windows.Forms.Button();
            this.label7 = new System.Windows.Forms.Label();
            this.txtPemPrivate = new System.Windows.Forms.TextBox();
            this.txtPemPublic = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.btnPrivatePEM = new System.Windows.Forms.Button();
            this.btnPublicPEM = new System.Windows.Forms.Button();
            this.btnModeFile = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(504, 81);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(78, 17);
            this.label1.TabIndex = 0;
            this.label1.Text = "Public Key:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 81);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(84, 17);
            this.label2.TabIndex = 0;
            this.label2.Text = "Private Key:";
            // 
            // txtPrivateKey
            // 
            this.txtPrivateKey.BackColor = System.Drawing.Color.White;
            this.txtPrivateKey.Location = new System.Drawing.Point(15, 101);
            this.txtPrivateKey.Multiline = true;
            this.txtPrivateKey.Name = "txtPrivateKey";
            this.txtPrivateKey.Size = new System.Drawing.Size(476, 178);
            this.txtPrivateKey.TabIndex = 1;
            this.txtPrivateKey.TabStop = false;
            // 
            // txtPublicKey
            // 
            this.txtPublicKey.BackColor = System.Drawing.Color.White;
            this.txtPublicKey.Location = new System.Drawing.Point(507, 101);
            this.txtPublicKey.Multiline = true;
            this.txtPublicKey.Name = "txtPublicKey";
            this.txtPublicKey.Size = new System.Drawing.Size(476, 178);
            this.txtPublicKey.TabIndex = 1;
            this.txtPublicKey.TabStop = false;
            // 
            // btnCreate
            // 
            this.btnCreate.Location = new System.Drawing.Point(174, 24);
            this.btnCreate.Name = "btnCreate";
            this.btnCreate.Size = new System.Drawing.Size(101, 34);
            this.btnCreate.TabIndex = 2;
            this.btnCreate.TabStop = false;
            this.btnCreate.Text = "Tạo cặp key";
            this.btnCreate.UseVisualStyleBackColor = true;
            this.btnCreate.Click += new System.EventHandler(this.btnCreate_Click);
            // 
            // txtContent
            // 
            this.txtContent.BackColor = System.Drawing.Color.White;
            this.txtContent.Location = new System.Drawing.Point(15, 416);
            this.txtContent.Multiline = true;
            this.txtContent.Name = "txtContent";
            this.txtContent.Size = new System.Drawing.Size(476, 93);
            this.txtContent.TabIndex = 3;
            this.txtContent.TabStop = false;
            // 
            // txtResult
            // 
            this.txtResult.BackColor = System.Drawing.Color.White;
            this.txtResult.Location = new System.Drawing.Point(507, 416);
            this.txtResult.Multiline = true;
            this.txtResult.Name = "txtResult";
            this.txtResult.ReadOnly = true;
            this.txtResult.Size = new System.Drawing.Size(476, 270);
            this.txtResult.TabIndex = 3;
            this.txtResult.TabStop = false;
            // 
            // btnEncryption
            // 
            this.btnEncryption.Location = new System.Drawing.Point(15, 515);
            this.btnEncryption.Name = "btnEncryption";
            this.btnEncryption.Size = new System.Drawing.Size(101, 34);
            this.btnEncryption.TabIndex = 4;
            this.btnEncryption.TabStop = false;
            this.btnEncryption.Text = "Mã Hoá";
            this.btnEncryption.UseVisualStyleBackColor = true;
            this.btnEncryption.Click += new System.EventHandler(this.btnEncryption_Click);
            // 
            // btnDecryption
            // 
            this.btnDecryption.Location = new System.Drawing.Point(15, 554);
            this.btnDecryption.Name = "btnDecryption";
            this.btnDecryption.Size = new System.Drawing.Size(101, 34);
            this.btnDecryption.TabIndex = 4;
            this.btnDecryption.TabStop = false;
            this.btnDecryption.Text = "Giải Mã";
            this.btnDecryption.UseVisualStyleBackColor = true;
            this.btnDecryption.Click += new System.EventHandler(this.btnDecryption_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 396);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(69, 17);
            this.label3.TabIndex = 0;
            this.label3.Text = "Nội dung:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(504, 396);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(61, 17);
            this.label4.TabIndex = 0;
            this.label4.Text = "Kết quả:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(12, 33);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(53, 17);
            this.label5.TabIndex = 0;
            this.label5.Text = "Độ lớn:";
            // 
            // cbbLength
            // 
            this.cbbLength.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbbLength.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(254)));
            this.cbbLength.FormattingEnabled = true;
            this.cbbLength.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.cbbLength.Items.AddRange(new object[] {
            "80",
            "112",
            "512",
            "1024",
            "2048",
            "4096"});
            this.cbbLength.Location = new System.Drawing.Point(67, 26);
            this.cbbLength.Name = "cbbLength";
            this.cbbLength.Size = new System.Drawing.Size(101, 32);
            this.cbbLength.TabIndex = 5;
            this.cbbLength.TabStop = false;
            // 
            // lblEncrypt
            // 
            this.lblEncrypt.AutoSize = true;
            this.lblEncrypt.Location = new System.Drawing.Point(571, 396);
            this.lblEncrypt.Name = "lblEncrypt";
            this.lblEncrypt.Size = new System.Drawing.Size(78, 17);
            this.lblEncrypt.TabIndex = 6;
            this.lblEncrypt.Text = "lưu mã hoá";
            this.lblEncrypt.Visible = false;
            // 
            // txtContentEncrypt
            // 
            this.txtContentEncrypt.BackColor = System.Drawing.Color.White;
            this.txtContentEncrypt.Location = new System.Drawing.Point(15, 594);
            this.txtContentEncrypt.Multiline = true;
            this.txtContentEncrypt.Name = "txtContentEncrypt";
            this.txtContentEncrypt.Size = new System.Drawing.Size(476, 93);
            this.txtContentEncrypt.TabIndex = 3;
            this.txtContentEncrypt.TabStop = false;
            // 
            // label6
            // 
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 40F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(254)));
            this.label6.ForeColor = System.Drawing.Color.Red;
            this.label6.Location = new System.Drawing.Point(122, 516);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(369, 71);
            this.label6.TabIndex = 0;
            this.label6.Text = "RSA";
            this.label6.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // btnSavePrivateKey
            // 
            this.btnSavePrivateKey.Location = new System.Drawing.Point(281, 24);
            this.btnSavePrivateKey.Name = "btnSavePrivateKey";
            this.btnSavePrivateKey.Size = new System.Drawing.Size(129, 34);
            this.btnSavePrivateKey.TabIndex = 2;
            this.btnSavePrivateKey.TabStop = false;
            this.btnSavePrivateKey.Text = "Lưu private key";
            this.btnSavePrivateKey.UseVisualStyleBackColor = true;
            this.btnSavePrivateKey.Click += new System.EventHandler(this.btnSavePrivateKey_Click);
            // 
            // btnSavePublicKey
            // 
            this.btnSavePublicKey.Location = new System.Drawing.Point(416, 24);
            this.btnSavePublicKey.Name = "btnSavePublicKey";
            this.btnSavePublicKey.Size = new System.Drawing.Size(129, 34);
            this.btnSavePublicKey.TabIndex = 2;
            this.btnSavePublicKey.TabStop = false;
            this.btnSavePublicKey.Text = "Lưu public key";
            this.btnSavePublicKey.UseVisualStyleBackColor = true;
            this.btnSavePublicKey.Click += new System.EventHandler(this.btnSavePublicKey_Click);
            // 
            // btnTutorial
            // 
            this.btnTutorial.Location = new System.Drawing.Point(686, 24);
            this.btnTutorial.Name = "btnTutorial";
            this.btnTutorial.Size = new System.Drawing.Size(129, 34);
            this.btnTutorial.TabIndex = 2;
            this.btnTutorial.TabStop = false;
            this.btnTutorial.Text = "Hướng dẫn";
            this.btnTutorial.UseVisualStyleBackColor = true;
            this.btnTutorial.Click += new System.EventHandler(this.btnTutorial_Click);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(12, 304);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(41, 17);
            this.label7.TabIndex = 0;
            this.label7.Text = "PEM:";
            // 
            // txtPemPrivate
            // 
            this.txtPemPrivate.Location = new System.Drawing.Point(150, 301);
            this.txtPemPrivate.Name = "txtPemPrivate";
            this.txtPemPrivate.ReadOnly = true;
            this.txtPemPrivate.Size = new System.Drawing.Size(432, 22);
            this.txtPemPrivate.TabIndex = 7;
            this.txtPemPrivate.TabStop = false;
            // 
            // txtPemPublic
            // 
            this.txtPemPublic.Location = new System.Drawing.Point(150, 329);
            this.txtPemPublic.Name = "txtPemPublic";
            this.txtPemPublic.ReadOnly = true;
            this.txtPemPublic.Size = new System.Drawing.Size(432, 22);
            this.txtPemPublic.TabIndex = 7;
            this.txtPemPublic.TabStop = false;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(59, 304);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(84, 17);
            this.label8.TabIndex = 0;
            this.label8.Text = "Private Key:";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(59, 332);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(78, 17);
            this.label9.TabIndex = 0;
            this.label9.Text = "Public Key:";
            // 
            // btnPrivatePEM
            // 
            this.btnPrivatePEM.Location = new System.Drawing.Point(588, 300);
            this.btnPrivatePEM.Name = "btnPrivatePEM";
            this.btnPrivatePEM.Size = new System.Drawing.Size(75, 25);
            this.btnPrivatePEM.TabIndex = 8;
            this.btnPrivatePEM.TabStop = false;
            this.btnPrivatePEM.Text = "Chọn";
            this.btnPrivatePEM.UseVisualStyleBackColor = true;
            this.btnPrivatePEM.Click += new System.EventHandler(this.btnPrivatePEM_Click);
            // 
            // btnPublicPEM
            // 
            this.btnPublicPEM.Location = new System.Drawing.Point(588, 329);
            this.btnPublicPEM.Name = "btnPublicPEM";
            this.btnPublicPEM.Size = new System.Drawing.Size(75, 25);
            this.btnPublicPEM.TabIndex = 8;
            this.btnPublicPEM.TabStop = false;
            this.btnPublicPEM.Text = "Chọn";
            this.btnPublicPEM.UseVisualStyleBackColor = true;
            this.btnPublicPEM.Click += new System.EventHandler(this.btnPublicPEM_Click);
            // 
            // btnModeFile
            // 
            this.btnModeFile.Location = new System.Drawing.Point(551, 24);
            this.btnModeFile.Name = "btnModeFile";
            this.btnModeFile.Size = new System.Drawing.Size(129, 34);
            this.btnModeFile.TabIndex = 2;
            this.btnModeFile.TabStop = false;
            this.btnModeFile.Text = "Test File PEM";
            this.btnModeFile.UseVisualStyleBackColor = true;
            this.btnModeFile.Click += new System.EventHandler(this.btnModeFile_Click);
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(997, 710);
            this.Controls.Add(this.btnPublicPEM);
            this.Controls.Add(this.btnPrivatePEM);
            this.Controls.Add(this.txtPemPublic);
            this.Controls.Add(this.txtPemPrivate);
            this.Controls.Add(this.lblEncrypt);
            this.Controls.Add(this.cbbLength);
            this.Controls.Add(this.btnDecryption);
            this.Controls.Add(this.btnEncryption);
            this.Controls.Add(this.txtResult);
            this.Controls.Add(this.txtContentEncrypt);
            this.Controls.Add(this.txtContent);
            this.Controls.Add(this.btnModeFile);
            this.Controls.Add(this.btnTutorial);
            this.Controls.Add(this.btnSavePublicKey);
            this.Controls.Add(this.btnSavePrivateKey);
            this.Controls.Add(this.btnCreate);
            this.Controls.Add(this.txtPublicKey);
            this.Controls.Add(this.txtPrivateKey);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "frmMain";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "CHƯƠNG TRÌNH TẠO CẶP KEY RSA - PHẠM XUÂN HOÀI";
            this.Load += new System.EventHandler(this.frmMain_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtPrivateKey;
        private System.Windows.Forms.TextBox txtPublicKey;
        private System.Windows.Forms.Button btnCreate;
        private System.Windows.Forms.TextBox txtContent;
        private System.Windows.Forms.TextBox txtResult;
        private System.Windows.Forms.Button btnEncryption;
        private System.Windows.Forms.Button btnDecryption;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ComboBox cbbLength;
        private System.Windows.Forms.Label lblEncrypt;
        private System.Windows.Forms.TextBox txtContentEncrypt;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button btnSavePrivateKey;
        private System.Windows.Forms.Button btnSavePublicKey;
        private System.Windows.Forms.Button btnTutorial;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox txtPemPrivate;
        private System.Windows.Forms.TextBox txtPemPublic;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Button btnPrivatePEM;
        private System.Windows.Forms.Button btnPublicPEM;
        private System.Windows.Forms.Button btnModeFile;
    }
}

