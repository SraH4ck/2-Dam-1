using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Introduccion_Ide_visual_Studio
{
    public partial class FormMenu : Form
    {
        public FormMenu()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void FormDoc_Click(object sender, EventArgs e)
        {
            FormAnchor formAnchor = new FormAnchor();
            formAnchor.ShowDialog();
        }

        private void form1_Click(object sender, EventArgs e)
        {
            Login login = new Login();
            login.ShowDialog();
        }

        private void form3_Click(object sender, EventArgs e)
        {
            FormDoc formDoc = new FormDoc();
            formDoc.ShowDialog();
        }

        private void formenu_Click(object sender, EventArgs e)
        {
            FormMenu menu = new FormMenu();
            menu.ShowDialog();
        }

        private void FormMenu_Load(object sender, EventArgs e)
        {

        }

        private void btnFormFlowLayaout_Click(object sender, EventArgs e)
        {
            FormFlowLayaout formFlowLayaout = new FormFlowLayaout();
            formFlowLayaout.ShowDialog();
        }

        private void FormTableLayaout_Click(object sender, EventArgs e)
        {
            FormTable form = new FormTable();
            form.ShowDialog();
        }
    }
}
