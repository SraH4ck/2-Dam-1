namespace Introduccion_Ide_visual_Studio
{
    partial class Login
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            btnAceptar = new Button();
            btnCancelar = new Button();
            txbUser = new TextBox();
            label1 = new Label();
            lblUsuario = new Label();
            txbPassword = new TextBox();
            tableLayoutPanel1 = new TableLayoutPanel();
            tableLayoutPanel1.SuspendLayout();
            SuspendLayout();
            // 
            // btnAceptar
            // 
            btnAceptar.Anchor = AnchorStyles.Right;
            btnAceptar.BackColor = SystemColors.ControlLight;
            btnAceptar.FlatStyle = FlatStyle.Flat;
            btnAceptar.Location = new Point(310, 382);
            btnAceptar.Name = "btnAceptar";
            btnAceptar.Size = new Size(105, 41);
            btnAceptar.TabIndex = 0;
            btnAceptar.Text = "Aceptar";
            btnAceptar.UseVisualStyleBackColor = false;
            btnAceptar.Click += button1_Click;
            // 
            // btnCancelar
            // 
            btnCancelar.Anchor = AnchorStyles.Right;
            btnCancelar.BackColor = SystemColors.ControlLight;
            btnCancelar.FlatStyle = FlatStyle.Flat;
            btnCancelar.Location = new Point(685, 382);
            btnCancelar.Name = "btnCancelar";
            btnCancelar.Size = new Size(127, 41);
            btnCancelar.TabIndex = 1;
            btnCancelar.Text = "Cancelar";
            btnCancelar.UseVisualStyleBackColor = false;
            btnCancelar.Click += btnCancelar_Click;
            // 
            // txbUser
            // 
            txbUser.Anchor = AnchorStyles.Left | AnchorStyles.Right;
            txbUser.BackColor = SystemColors.ControlLight;
            txbUser.BorderStyle = BorderStyle.FixedSingle;
            txbUser.Location = new Point(441, 65);
            txbUser.Name = "txbUser";
            txbUser.Size = new Size(371, 27);
            txbUser.TabIndex = 3;
            txbUser.TextChanged += textBox1_TextChanged;
            // 
            // label1
            // 
            label1.Anchor = AnchorStyles.Right;
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 10F);
            label1.Location = new Point(314, 224);
            label1.Name = "label1";
            label1.Size = new Size(101, 23);
            label1.TabIndex = 4;
            label1.Text = "Contraseña:";
            label1.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // lblUsuario
            // 
            lblUsuario.Anchor = AnchorStyles.Right;
            lblUsuario.AutoSize = true;
            lblUsuario.Font = new Font("Segoe UI", 10F);
            lblUsuario.Location = new Point(343, 67);
            lblUsuario.Name = "lblUsuario";
            lblUsuario.Size = new Size(72, 23);
            lblUsuario.TabIndex = 2;
            lblUsuario.Text = "Usuario:";
            lblUsuario.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // txbPassword
            // 
            txbPassword.Anchor = AnchorStyles.Left | AnchorStyles.Right;
            txbPassword.BackColor = SystemColors.ControlLight;
            txbPassword.BorderStyle = BorderStyle.FixedSingle;
            txbPassword.Location = new Point(441, 222);
            txbPassword.Name = "txbPassword";
            txbPassword.Size = new Size(371, 27);
            txbPassword.TabIndex = 5;
            txbPassword.TextChanged += txbPassword_TextChanged;
            // 
            // tableLayoutPanel1
            // 
            tableLayoutPanel1.BackColor = SystemColors.InactiveCaption;
            tableLayoutPanel1.ColumnCount = 5;
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 23.999609F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 15.9997444F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Absolute, 20F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 35.999424F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 24.001215F));
            tableLayoutPanel1.Controls.Add(label1, 1, 1);
            tableLayoutPanel1.Controls.Add(lblUsuario, 1, 0);
            tableLayoutPanel1.Controls.Add(txbUser, 3, 0);
            tableLayoutPanel1.Controls.Add(txbPassword, 3, 1);
            tableLayoutPanel1.Controls.Add(btnAceptar, 1, 2);
            tableLayoutPanel1.Controls.Add(btnCancelar, 3, 2);
            tableLayoutPanel1.Dock = DockStyle.Fill;
            tableLayoutPanel1.Location = new Point(0, 0);
            tableLayoutPanel1.Name = "tableLayoutPanel1";
            tableLayoutPanel1.RowCount = 3;
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 32.08714F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 32.2468376F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 35.66602F));
            tableLayoutPanel1.Size = new Size(1069, 491);
            tableLayoutPanel1.TabIndex = 6;
            tableLayoutPanel1.Paint += tableLayoutPanel1_Paint;
            // 
            // Login
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1069, 491);
            Controls.Add(tableLayoutPanel1);
            MinimumSize = new Size(500, 500);
            Name = "Login";
            Text = "Login";
            Load += Form1_Load;
            tableLayoutPanel1.ResumeLayout(false);
            tableLayoutPanel1.PerformLayout();
            ResumeLayout(false);
        }

        #endregion

        private Button btnAceptar;
        private Button btnCancelar;
        private TextBox txbUser;
        private Label label1;
        private Label lblUsuario;
        private TextBox txbPassword;
        private TableLayoutPanel tableLayoutPanel1;
    }
}
