package Interface;

import Models.TaiKhoan;

public class Run {
    public static frmMain QlCafe;
    public static frmLogIn frmlg;
    public static TaiKhoan tk;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lg();
    }

    public static void lg() {
        frmlg = new frmLogIn();
        frmlg.setVisible(true);
    }

    public static void QLCF() {
        QlCafe = new frmMain();
        QlCafe.setVisible(true);
    }
}
