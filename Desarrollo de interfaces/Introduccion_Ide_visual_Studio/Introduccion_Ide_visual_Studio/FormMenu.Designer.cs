namespace Introduccion_Ide_visual_Studio
{
    partial class FormMenu
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
            label1 = new Label();
            formDoc = new Button();
            form1 = new Button();
            form3 = new Button();
            btnFormFlowLayaout = new Button();
            FormTableLayaout = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(23, 36);
            label1.Name = "label1";
            label1.Size = new Size(0, 20);
            label1.TabIndex = 0;
            label1.Click += label1_Click;
            // 
            // formDoc
            // 
            formDoc.Location = new Point(253, 12);
            formDoc.Name = "formDoc";
            formDoc.Size = new Size(288, 69);
            formDoc.TabIndex = 1;
            formDoc.Text = "Form Anchor";
            formDoc.UseVisualStyleBackColor = true;
            formDoc.Click += FormDoc_Click;
            // 
            // form1
            // 
            form1.Location = new Point(253, 116);
            form1.Name = "form1";
            form1.Size = new Size(288, 60);
            form1.TabIndex = 2;
            form1.Text = "Login";
            form1.UseVisualStyleBackColor = true;
            form1.Click += form1_Click;
            // 
            // form3
            // 
            form3.Location = new Point(253, 217);
            form3.Name = "form3";
            form3.Size = new Size(288, 48);
            form3.TabIndex = 3;
            form3.Text = "Form Doc";
            form3.UseVisualStyleBackColor = true;
            form3.Click += form3_Click;
            // 
            // btnFormFlowLayaout
            // 
            btnFormFlowLayaout.Location = new Point(300, 315);
            btnFormFlowLayaout.Name = "btnFormFlowLayaout";
            btnFormFlowLayaout.Size = new Size(228, 44);
            btnFormFlowLayaout.TabIndex = 4;
            btnFormFlowLayaout.Text = "FormFlowLayaout";
            btnFormFlowLayaout.UseVisualStyleBackColor = true;
            btnFormFlowLayaout.Click += btnFormFlowLayaout_Click;
            // 
            // FormTableLayaout
            // 
            FormTableLayaout.Location = new Point(316, 386);
            FormTableLayaout.Name = "FormTableLayaout";
            FormTableLayaout.Size = new Size(194, 34);
            FormTableLayaout.TabIndex = 5;
            FormTableLayaout.Text = "FormTableLayaout";
            FormTableLayaout.UseVisualStyleBackColor = true;
            FormTableLayaout.Click += FormTableLayaout_Click;
            // 
            // FormMenu
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(795, 432);
            Controls.Add(FormTableLayaout);
            Controls.Add(btnFormFlowLayaout);
            Controls.Add(form3);
            Controls.Add(form1);
            Controls.Add(formDoc);
            Controls.Add(label1);
            Name = "FormMenu";
            Text = "FormMenu";
            Load += FormMenu_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Button formDoc;
        private Button form1;
        private Button form3;
        private Button btnFormFlowLayaout;
        private Button FormTableLayaout;
    }
}