namespace Introduccion_Ide_visual_Studio
{
    partial class FormAnchor
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
            button1 = new Button();
            button2 = new Button();
            button3 = new Button();
            button4 = new Button();
            button5 = new Button();
            SuspendLayout();
            // 
            // button1
            // 
            button1.Anchor = AnchorStyles.Top | AnchorStyles.Right;
            button1.Location = new Point(612, 26);
            button1.Name = "button1";
            button1.Size = new Size(155, 29);
            button1.TabIndex = 0;
            button1.Text = "Anchor top right";
            button1.UseVisualStyleBackColor = true;
            // 
            // button2
            // 
            button2.Anchor = AnchorStyles.Bottom | AnchorStyles.Right;
            button2.Location = new Point(612, 386);
            button2.Name = "button2";
            button2.Size = new Size(155, 29);
            button2.TabIndex = 1;
            button2.Text = "Anchor bottom right";
            button2.UseVisualStyleBackColor = true;
            // 
            // button3
            // 
            button3.Anchor = AnchorStyles.Top | AnchorStyles.Left | AnchorStyles.Right;
            button3.Location = new Point(306, 12);
            button3.Name = "button3";
            button3.Size = new Size(185, 29);
            button3.TabIndex = 2;
            button3.Text = "Anchor top left_right";
            button3.UseVisualStyleBackColor = true;
            // 
            // button4
            // 
            button4.Anchor = AnchorStyles.Left | AnchorStyles.Right;
            button4.Location = new Point(306, 148);
            button4.Name = "button4";
            button4.Size = new Size(185, 29);
            button4.TabIndex = 3;
            button4.Text = "Anchor  left_right";
            button4.UseVisualStyleBackColor = true;
            // 
            // button5
            // 
            button5.Anchor = AnchorStyles.Top | AnchorStyles.Bottom;
            button5.Location = new Point(306, 315);
            button5.Name = "button5";
            button5.Size = new Size(185, 29);
            button5.TabIndex = 4;
            button5.Text = "Anchor  top_bottom";
            button5.UseVisualStyleBackColor = true;
            // 
            // FormDoc2
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(button5);
            Controls.Add(button4);
            Controls.Add(button3);
            Controls.Add(button2);
            Controls.Add(button1);
            ForeColor = SystemColors.ControlText;
            Name = "FormDoc2";
            Text = "FormDoc2";
            ResumeLayout(false);
        }

        #endregion

        private Button button1;
        private Button button2;
        private Button button3;
        private Button button4;
        private Button button5;
    }
}