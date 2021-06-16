/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Interface.BanHang.jpBanHang;
import Interface.Home.JpHome;
import Interface.QuanLy.JpQuanLy;
import Interface.Setting.JpSetting;
import Models.Ban;
import Models.TaiKhoan;
import Mysql.ConnectSQL;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import Interface.ThongKe.JpThongKe;

import java.awt.Image;
import javax.swing.JRootPane;


public final class frmMain extends javax.swing.JFrame {
    ConnectSQL cn = new ConnectSQL();

    /**
     * Creates new form frmMain
     */
    public TaiKhoan loadtaikhoan(String user, String pass) {
        return cn.GetTaiKhoan(user, pass);
    }

    public frmMain() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Interface/Images/logo.png"));
        Image image = icon.getImage();
        setIconImage(image);
        fill();
        Clock clock = new Clock();
        clock.start();
        txtqtv.setText(Run.tk.Gettdn());
        
        // Điều chỉnh False nếu không phải Admin 
        if (Run.tk.GetLv() != 1 && Run.tk.GetLv() != 0) {
            btnQuanLy.setEnabled(false);
            btnThongKe.setEnabled(false);
        }


    }

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

    public class Clock extends Thread {
        public Clock() {
        }

        @Override
        public void run() {
            while (true) {
                Calendar calendar = Calendar.getInstance();
                String str;
                str = sdf.format(calendar.getTime());
                lbltime.setText(str);
                try {
                    sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void fill() {
        home = new JpHome();
        jpLayout.add(home);
        jpLayout.updateUI();
        mp3 = new MP3("src/Sound/openmusic.MP3");
        mp3.play();
        //btnmute.setVisible(false);

        //Khai bao dinh dang ngay thang


    }

    MP3 mp3;
    jpBanHang banhang;
    JpHome home;
    JpSetting Set;
    JpQuanLy ql;
    JpThongKe tk;

    public void reloadPanel(int i) {
        jpLayout.removeAll();
        switch (i) {
            case 1:
                if (banhang == null) {
                    banhang = new jpBanHang();
                }
                btnBanHang.setPressedIcon(new ImageIcon("down.png"));
                mp3 = new MP3("src/Sound/kasya.MP3");
                mp3.play();
                jpLayout.add(banhang);
                break;
            case 2:
                if (home == null) {
                    home = new JpHome();
                }
                btnTrangChu.setPressedIcon(new ImageIcon("down.png"));
                mp3 = new MP3("src/Sound/kasya.MP3");
                mp3.play();
                jpLayout.add(home);
                break;
            case 3:
                if (ql == null) {
                    ql = new JpQuanLy();
                }
                btnQuanLy.setPressedIcon(new ImageIcon("down.png"));
                jpLayout.add(ql);
                mp3 = new MP3("src/Sound/kasya.MP3");
                mp3.play();
                break;
            case 4:
                tk = new JpThongKe();

                btnThongKe.setPressedIcon(new ImageIcon("down.png"));
                jpLayout.add(tk);
                mp3 = new MP3("src/Sound/kasya.MP3");
                mp3.play();
                break;
            case 6:
                if (Set == null) {
                    Set = new JpSetting();
                }
                btnThietLap.setPressedIcon(new ImageIcon("down.png"));
                mp3 = new MP3("src/Sound/kasya.MP3");
                mp3.play();
                jpLayout.add(Set);
                break;
            default:
                break;
        }
        jpLayout.updateUI();
    }

    class MP3 {
        private Player player;
        private String filename;

        public MP3(String filename) {
            this.filename = filename;
        }

        public void stop() {
            if (player != null)
                player.close();
        }

        public void play() {
            try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
                player = new Player(bis);
            } catch (FileNotFoundException | JavaLayerException ex) {
                System.out.println(ex);
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        player.play();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }).start();
        }
    }
    //Lam gi do trong thoi gian phat nhac

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnThietLap = new javax.swing.JButton();
        btnQuanLy = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        jpLayout = new javax.swing.JPanel();
        btnthoat = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();
        lbltime = new javax.swing.JLabel();
        txtqtv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cafe Manger Main");
        setBackground(Color.decode("#e6e6e6")
        );
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(new java.awt.Color(255, 204, 255));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(56, 25, 15), 1, true));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 600));

        btnThietLap.setBackground(new java.awt.Color(100, 50, 0));
        btnThietLap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThietLap.setForeground(new java.awt.Color(255, 255, 255));
        btnThietLap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/setting.png"))); // NOI18N
        btnThietLap.setText("THIẾT LẬP");
        btnThietLap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThietLap.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThietLap.setIconTextGap(5);
        btnThietLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThietLapActionPerformed(evt);
            }
        });

        btnQuanLy.setBackground(new java.awt.Color(100, 50, 0));
        btnQuanLy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuanLy.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/manage.png"))); // NOI18N
        btnQuanLy.setText("QUẢN LÝ");
        btnQuanLy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLy.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuanLy.setIconTextGap(5);
        btnQuanLy.setPreferredSize(new java.awt.Dimension(140, 49));
        btnQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyActionPerformed(evt);
            }
        });

        btnBanHang.setBackground(new java.awt.Color(100, 50, 0));
        btnBanHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBanHang.setForeground(new java.awt.Color(255, 255, 255));
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/sell.png"))); // NOI18N
        btnBanHang.setText("BÁN HÀNG");
        btnBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBanHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBanHang.setIconTextGap(5);
        btnBanHang.setMaximumSize(new java.awt.Dimension(157, 49));
        btnBanHang.setMinimumSize(new java.awt.Dimension(157, 49));
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(100, 50, 0));
        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/statistics.png"))); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThongKe.setIconTextGap(5);
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jpLayout.setBackground(new java.awt.Color(255, 255, 255));
        jpLayout.setLayout(new java.awt.BorderLayout());

        btnthoat.setBackground(new java.awt.Color(100, 50, 0));
        btnthoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnthoat.setForeground(new java.awt.Color(255, 255, 255));
        btnthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/thoat.png"))); // NOI18N
        btnthoat.setText("ĐĂNG XUẤT");
        btnthoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthoat.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnthoat.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        btnTrangChu.setBackground(new java.awt.Color(100, 50, 0));
        btnTrangChu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        btnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/0-Image/home-run.png"))); // NOI18N
        btnTrangChu.setText("TRANG CHỦ");
        btnTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrangChu.setDefaultCapable(false);
        btnTrangChu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTrangChu.setIconTextGap(5);
        btnTrangChu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnTrangChuFocusGained(evt);
            }
        });
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTrangChuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseReleased(evt);
            }
        });
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        lbltime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltime.setForeground(new java.awt.Color(56, 25, 15));
        lbltime.setText("Thời gian");

        txtqtv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtqtv.setForeground(new java.awt.Color(56, 25, 15));
        txtqtv.setText("Tên tài khoản");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 25, 15));
        jLabel1.setText("Xin chào:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnTrangChu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThietLap, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtqtv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lbltime)
                .addGap(40, 40, 40)
                .addComponent(btnthoat)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnthoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThietLap)
                        .addComponent(jLabel1)
                        .addComponent(txtqtv)
                        .addComponent(lbltime)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTrangChu)))
                .addGap(4, 4, 4)
                .addComponent(jpLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        reloadPanel(1);
    }//GEN-LAST:event_btnBanHangActionPerformed

    public void thoat() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        int kq = JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng phần mềm ?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (kq == 0) {
            System.exit(0);
        }
    }

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        // TODO add your handling code here:
        int kq = JOptionPane.showConfirmDialog(null, "Đăng xuất khỏi tài khoản " + Run.tk.Gettdn() + "?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (kq == 0) {
            MP3 mp3 = new MP3("src/Sound/tyaran.MP3");
            mp3.play();
            Run.frmlg.setVisible(true);
            Run.frmlg.thoat();
            this.setVisible(false);
        }

    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
        reloadPanel(2);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnThietLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThietLapActionPerformed
        // TODO add your handling code here:
        reloadPanel(6);
    }//GEN-LAST:event_btnThietLapActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        reloadPanel(4);
//        this.dispose();
//        Run.rerun();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnTrangChuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnTrangChuFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_btnTrangChuFocusGained

    private void btnTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnTrangChuMouseClicked

    private void btnTrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_btnTrangChuMouseEntered

    private void btnTrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_btnTrangChuMouseExited

    private void btnTrangChuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_btnTrangChuMouseReleased

    private void btnTrangChuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMousePressed

    }//GEN-LAST:event_btnTrangChuMousePressed

    MP3 nhacnen;

    private void btnQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyActionPerformed
        // TODO add your handling code here:
        reloadPanel(3);
    }//GEN-LAST:event_btnQuanLyActionPerformed

    private boolean flag;
    private int x, y;

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (flag) {
            this.setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        flag = true;
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        flag = false;
    }//GEN-LAST:event_formMouseReleased

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnQuanLy;
    private javax.swing.JButton btnThietLap;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnthoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpLayout;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel txtqtv;
    // End of variables declaration//GEN-END:variables
}
