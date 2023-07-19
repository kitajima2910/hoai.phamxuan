
namespace upanh.org
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
            this.components = new System.ComponentModel.Container();
            this.ofdImage = new System.Windows.Forms.OpenFileDialog();
            this.txtShowPath = new System.Windows.Forms.TextBox();
            this.btnSelect = new System.Windows.Forms.Button();
            this.pbShow = new System.Windows.Forms.PictureBox();
            this.tMarquee = new System.Windows.Forms.Timer(this.components);
            this.lMarquee = new System.Windows.Forms.Label();
            this.btnUpload = new System.Windows.Forms.Button();
            this.txtResultUrl = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pbShow)).BeginInit();
            this.SuspendLayout();
            // 
            // txtShowPath
            // 
            this.txtShowPath.BackColor = System.Drawing.Color.White;
            this.txtShowPath.Cursor = System.Windows.Forms.Cursors.No;
            this.txtShowPath.Enabled = false;
            this.txtShowPath.Location = new System.Drawing.Point(28, 20);
            this.txtShowPath.Multiline = true;
            this.txtShowPath.Name = "txtShowPath";
            this.txtShowPath.ReadOnly = true;
            this.txtShowPath.Size = new System.Drawing.Size(397, 39);
            this.txtShowPath.TabIndex = 1;
            this.txtShowPath.TabStop = false;
            // 
            // btnSelect
            // 
            this.btnSelect.Location = new System.Drawing.Point(431, 19);
            this.btnSelect.Name = "btnSelect";
            this.btnSelect.Size = new System.Drawing.Size(108, 42);
            this.btnSelect.TabIndex = 2;
            this.btnSelect.TabStop = false;
            this.btnSelect.Text = "Chọn Ảnh";
            this.btnSelect.UseVisualStyleBackColor = true;
            this.btnSelect.Click += new System.EventHandler(this.btnSelect_Click);
            // 
            // pbShow
            // 
            this.pbShow.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pbShow.Location = new System.Drawing.Point(28, 86);
            this.pbShow.Name = "pbShow";
            this.pbShow.Size = new System.Drawing.Size(160, 159);
            this.pbShow.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbShow.TabIndex = 3;
            this.pbShow.TabStop = false;
            // 
            // tMarquee
            // 
            this.tMarquee.Interval = 10;
            this.tMarquee.Tick += new System.EventHandler(this.tMarquee_Tick);
            // 
            // lMarquee
            // 
            this.lMarquee.AutoSize = true;
            this.lMarquee.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(254)));
            this.lMarquee.ForeColor = System.Drawing.Color.Red;
            this.lMarquee.Location = new System.Drawing.Point(25, 263);
            this.lMarquee.Name = "lMarquee";
            this.lMarquee.Size = new System.Drawing.Size(392, 17);
            this.lMarquee.TabIndex = 4;
            this.lMarquee.Text = "THỬ NGHIỆM TOOL TỰ ĐỘNG VERSION 1.0.1 - PXH";
            // 
            // btnUpload
            // 
            this.btnUpload.Location = new System.Drawing.Point(431, 85);
            this.btnUpload.Name = "btnUpload";
            this.btnUpload.Size = new System.Drawing.Size(108, 42);
            this.btnUpload.TabIndex = 5;
            this.btnUpload.TabStop = false;
            this.btnUpload.Text = "Tải Ảnh Lên";
            this.btnUpload.UseVisualStyleBackColor = true;
            this.btnUpload.Click += new System.EventHandler(this.btnUpload_Click);
            // 
            // txtResultUrl
            // 
            this.txtResultUrl.BackColor = System.Drawing.Color.White;
            this.txtResultUrl.Location = new System.Drawing.Point(194, 86);
            this.txtResultUrl.Multiline = true;
            this.txtResultUrl.Name = "txtResultUrl";
            this.txtResultUrl.ReadOnly = true;
            this.txtResultUrl.Size = new System.Drawing.Size(231, 140);
            this.txtResultUrl.TabIndex = 6;
            this.txtResultUrl.TabStop = false;
            this.txtResultUrl.TextChanged += new System.EventHandler(this.txtResultUrl_TextChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(194, 229);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(234, 17);
            this.label1.TabIndex = 7;
            this.label1.Text = "Áp dụng cho Chrome: 114.0.5735.X";
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(566, 300);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtResultUrl);
            this.Controls.Add(this.btnUpload);
            this.Controls.Add(this.lMarquee);
            this.Controls.Add(this.pbShow);
            this.Controls.Add(this.btnSelect);
            this.Controls.Add(this.txtShowPath);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "frmMain";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Tự động tải ảnh lên web -  PXH";
            this.Load += new System.EventHandler(this.frmMain_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pbShow)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.OpenFileDialog ofdImage;
        private System.Windows.Forms.TextBox txtShowPath;
        private System.Windows.Forms.Button btnSelect;
        private System.Windows.Forms.PictureBox pbShow;
        private System.Windows.Forms.Timer tMarquee;
        private System.Windows.Forms.Label lMarquee;
        private System.Windows.Forms.Button btnUpload;
        private System.Windows.Forms.TextBox txtResultUrl;
        private System.Windows.Forms.Label label1;
    }
}

