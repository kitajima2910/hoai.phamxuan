namespace StartProjectKeyClient
{
    partial class mainForm
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
            this.siticoneElipse = new ns1.SiticoneElipse(this.components);
            this.btnClose = new ns1.SiticoneButton();
            this.btnSend = new ns1.SiticoneButton();
            this.rtxtContent = new System.Windows.Forms.RichTextBox();
            this.siticoneDragControl = new ns1.SiticoneDragControl(this.components);
            this.SuspendLayout();
            // 
            // siticoneElipse
            // 
            this.siticoneElipse.TargetControl = this;
            // 
            // btnClose
            // 
            this.btnClose.CheckedState.Parent = this.btnClose;
            this.btnClose.CustomImages.Parent = this.btnClose;
            this.btnClose.Font = new System.Drawing.Font("Segoe UI", 9F, System.Drawing.FontStyle.Bold);
            this.btnClose.ForeColor = System.Drawing.Color.White;
            this.btnClose.HoveredState.Parent = this.btnClose;
            this.btnClose.Location = new System.Drawing.Point(935, 12);
            this.btnClose.Name = "btnClose";
            this.btnClose.ShadowDecoration.Parent = this.btnClose;
            this.btnClose.Size = new System.Drawing.Size(32, 27);
            this.btnClose.TabIndex = 0;
            this.btnClose.TabStop = false;
            this.btnClose.Text = "X";
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // btnSend
            // 
            this.btnSend.CheckedState.Parent = this.btnSend;
            this.btnSend.CustomImages.Parent = this.btnSend;
            this.btnSend.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.btnSend.ForeColor = System.Drawing.Color.White;
            this.btnSend.HoveredState.Parent = this.btnSend;
            this.btnSend.Location = new System.Drawing.Point(387, 364);
            this.btnSend.Name = "btnSend";
            this.btnSend.ShadowDecoration.Parent = this.btnSend;
            this.btnSend.Size = new System.Drawing.Size(180, 45);
            this.btnSend.TabIndex = 1;
            this.btnSend.Text = "Gửi Dữ Liệu";
            this.btnSend.Click += new System.EventHandler(this.btnSend_Click);
            // 
            // rtxtContent
            // 
            this.rtxtContent.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(89)))), ((int)(((byte)(98)))), ((int)(((byte)(117)))));
            this.rtxtContent.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.rtxtContent.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rtxtContent.ForeColor = System.Drawing.Color.White;
            this.rtxtContent.Location = new System.Drawing.Point(69, 55);
            this.rtxtContent.Name = "rtxtContent";
            this.rtxtContent.Size = new System.Drawing.Size(823, 274);
            this.rtxtContent.TabIndex = 2;
            this.rtxtContent.Text = "";
            // 
            // siticoneDragControl
            // 
            this.siticoneDragControl.TargetControl = this;
            // 
            // mainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(48)))), ((int)(((byte)(57)))), ((int)(((byte)(82)))));
            this.ClientSize = new System.Drawing.Size(979, 447);
            this.Controls.Add(this.rtxtContent);
            this.Controls.Add(this.btnSend);
            this.Controls.Add(this.btnClose);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "mainForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.mainForm_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private ns1.SiticoneElipse siticoneElipse;
        private ns1.SiticoneButton btnClose;
        private ns1.SiticoneButton btnSend;
        private System.Windows.Forms.RichTextBox rtxtContent;
        private ns1.SiticoneDragControl siticoneDragControl;
    }
}

