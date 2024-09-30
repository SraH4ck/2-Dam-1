namespace Introduccion_Ide_visual_Studio
{
    partial class FormDoc
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
            label4 = new Label();
            label2 = new Label();
            label5 = new Label();
            label3 = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.BackColor = Color.Red;
            label1.Dock = DockStyle.Top;
            label1.Location = new Point(0, 0);
            label1.Margin = new Padding(0);
            label1.Name = "label1";
            label1.Size = new Size(800, 65);
            label1.TabIndex = 0;
            label1.Text = "Top";
            label1.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // label4
            // 
            label4.BackColor = Color.Cyan;
            label4.Dock = DockStyle.Bottom;
            label4.Location = new Point(0, 348);
            label4.Margin = new Padding(0);
            label4.Name = "label4";
            label4.Size = new Size(800, 102);
            label4.TabIndex = 3;
            label4.Text = "Bottom";
            label4.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // label2
            // 
            label2.BackColor = Color.Lime;
            label2.Dock = DockStyle.Right;
            label2.Location = new Point(661, 65);
            label2.Margin = new Padding(0);
            label2.Name = "label2";
            label2.Size = new Size(139, 283);
            label2.TabIndex = 4;
            label2.Text = "Right";
            label2.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // label5
            // 
            label5.BackColor = Color.FromArgb(224, 224, 224);
            label5.Dock = DockStyle.Fill;
            label5.Location = new Point(0, 65);
            label5.Margin = new Padding(0);
            label5.Name = "label5";
            label5.Size = new Size(661, 283);
            label5.TabIndex = 5;
            label5.Text = "Fill";
            label5.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // label3
            // 
            label3.BackColor = Color.Yellow;
            label3.Dock = DockStyle.Left;
            label3.Location = new Point(0, 65);
            label3.Margin = new Padding(0);
            label3.Name = "label3";
            label3.Size = new Size(57, 283);
            label3.TabIndex = 6;
            label3.Text = "Left";
            label3.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // Form3
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(label3);
            Controls.Add(label5);
            Controls.Add(label2);
            Controls.Add(label4);
            Controls.Add(label1);
            Name = "Form3";
            Text = "Form3";
            ResumeLayout(false);
        }

        #endregion

        private Label label1;
        private Label label4;
        private Label label2;
        private Label label5;
        private Label label3;
    }
}