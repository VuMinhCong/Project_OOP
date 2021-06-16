/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.BanHang;

import Models.Ban;
import Models.DsOrder;
import Models.HoaDon;
import Mysql.ConnectSQL;
import com.itextpdf.text.BaseColor;

import javax.swing.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import javax.swing.JRootPane;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DLThanhToan extends javax.swing.JDialog {

    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    ConnectSQL cn = new ConnectSQL();
    /**
     * Creates new form DLThanhToan
     *
     * @param parent
     */
    public static int MaHD;
    public static String tenban;
    int tong;
    int MaBan;

    public DLThanhToan(java.awt.Frame parent, boolean modal, int tongtien, String tenban, int maban, int mahd) {
        super(parent, modal);
        initComponents();
        JRootPane rp = this.getRootPane();
        rp.setDefaultButton(btnXacNhan);
        tong = tongtien;
        MaHD = mahd;
        MaBan = maban;
        jLabel1.setText(tenban + " - Thanh toán");
        lblTongTien.setText(String.valueOf(chuyentien.format(tongtien) + " VNĐ"));
        this.tenban = tenban;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTongTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTienDua = new javax.swing.JTextField();
        btnHuy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbltienthoi = new javax.swing.JLabel();
        btnXacNhan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 51)));

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(114, 79, 43));
        lblTongTien.setText("....");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(114, 79, 43));
        jLabel4.setText("Tiền thừa:");

        txtTienDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienDuaActionPerformed(evt);
            }
        });
        txtTienDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienDuaKeyReleased(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(100, 50, 0));
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy bỏ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 25, 15));
        jLabel1.setText("Hoá đơn thanh toán");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(114, 79, 43));
        jLabel3.setText("Số tiền khách đưa:");

        lbltienthoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltienthoi.setForeground(new java.awt.Color(114, 79, 43));
        lbltienthoi.setText("....");

        btnXacNhan.setBackground(new java.awt.Color(100, 50, 0));
        btnXacNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(114, 79, 43));
        jLabel2.setText("Số tiền cần thanh toán:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnXacNhan)
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHuy)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(lbltienthoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTienDua, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTongTien))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltienthoi)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtTienDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienDuaKeyReleased
        try {
            int tiendua = Integer.parseInt(txtTienDua.getText());
            if (txtTienDua.getText().equals("")) {
                lbltienthoi.setText("....");
            } else if (tiendua - tong >= 0) {
                lbltienthoi.setText(String.valueOf(chuyentien.format(tiendua - tong)) + " VNĐ");
            } else {
                lbltienthoi.setText("không hợp lệ");
            }
        } catch (Exception e) {
            txtTienDua.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienDuaKeyReleased

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        int tiendua = Integer.parseInt(txtTienDua.getText());
        if (tiendua < tong) {
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công ! \nSố tiền thanh toán không hợp lệ !", "Lỗi Thanh Toán", JOptionPane.ERROR_MESSAGE);
//            System.out.println("Thanh toán không thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Thanh toán thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
//            System.out.println("Thanh toán thành công!");
            Ban b = new Ban();
            b.SetTrangThai("Trống");
            b.SetMaBan(MaBan);
            cn.UpDateTrangThaiBan(b);

            HoaDon hd = new HoaDon();
            hd.SetTongTien(tong);
            hd.SetMaHD(MaHD);
            cn.ThanhToan(hd);

            jpBanHang.bh.FillBan();
            JpGoiMon.gm.removeAll();
            jpBanHang.bh.fillLb();
            this.dispose();
            //In hoa don
            Document document = new Document();
            NumberFormat chuyentien = new DecimalFormat("#,###,###");
            try {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\GitHub\\Cafe-Manager\\src\\Hoadon\\hoa_don_ma_" + MaHD + ".pdf"));

                document.open();
                BaseFont bf = BaseFont.createFont("D:\\GitHub\\Cafe-Manager\\src\\Hoadon\\vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Font font = new Font(bf, 12);
                Font font1 = new Font(bf, 12, Font.BOLD);
                Font font2 = new Font(bf, 16, Font.BOLD, new BaseColor(114, 79, 43));

                ArrayList<DsOrder> arrDs = cn.GetDsOrder(MaHD);
                Image logo = Image.getInstance("D:\\GitHub\\Cafe-Manager\\src\\Interface\\Images\\logohd.png");

                logo.scaleAbsolute(125, 125);
                logo.setIndentationLeft(195);
                document.add(logo);
                Paragraph ten_quan = new Paragraph("COFFEE HOUSE", font2);
                ten_quan.setAlignment(Element.ALIGN_CENTER);
                document.add(ten_quan);
                Paragraph dia_chi = new Paragraph("D9 - Đại Học Bách Khoa Hà Nội", font2);
                dia_chi.setAlignment(Element.ALIGN_CENTER);
                document.add(dia_chi);

                Paragraph title = new Paragraph("---------------HÓA ĐƠN THANH TOÁN---------------", font1);
                title.setAlignment(Element.ALIGN_CENTER);
                title.setSpacingBefore(20);
                title.setSpacingAfter(20);
                document.add(title);

                PdfPTable table = new PdfPTable(4);
                PdfPCell cell = new PdfPCell(new Phrase("-------------------------------------------------------------------------------------------------------"));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(4);
                cell.setBorder(Rectangle.NO_BORDER);

                PdfPCell ma = new PdfPCell(new Phrase("Mã hóa đơn: " + MaHD, font));
                ma.setColspan(4);
                ma.setBorder(Rectangle.NO_BORDER);
                table.addCell(ma);

                HoaDon hd1 = cn.GetHDbyMa(MaHD);
                PdfPCell maban = new PdfPCell(new Phrase("Bàn: " + String.valueOf(hd1.GetMaBan()), font));
                maban.setColspan(4);
                maban.setBorder(Rectangle.NO_BORDER);
                table.addCell(maban);

                PdfPCell time = new PdfPCell(new Phrase("Thời gian: " + String.valueOf(hd1.GetGioDen()), font));
                time.setColspan(4);
                time.setBorder(Rectangle.NO_BORDER);
                table.addCell(time);
                table.addCell(cell);

                PdfPCell cell1 = new PdfPCell(new Phrase("Tên Món", font1));

                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell1);
                PdfPCell cell2 = new PdfPCell(new Phrase("Số Lượng", font1));

                cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell2.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell2);
                PdfPCell cell3 = new PdfPCell(new Phrase("Đơn Giá", font1));
                cell3.setBorder(Rectangle.NO_BORDER);
                cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);

                table.addCell(cell3);

                PdfPCell cell4 = new PdfPCell(new Phrase("Thành Tiền", font1));
                cell4.setBorder(Rectangle.NO_BORDER);
                cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);

                table.addCell(cell4);
                table.addCell(cell);

                for (DsOrder ds : arrDs) {
                    PdfPCell cell5 = new PdfPCell(new Phrase(ds.GetTenMon(), font));
                    cell5.setBorder(Rectangle.NO_BORDER);
                    table.addCell(cell5);
                    PdfPCell cell6 = new PdfPCell(new Phrase(String.valueOf(ds.GetSoLuong()), font));
                    cell6.setBorder(Rectangle.NO_BORDER);
                    cell6.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell6);
                    PdfPCell cell7 = new PdfPCell(new Phrase(String.valueOf(chuyentien.format(ds.GetGia())) + "VND", font));
                    cell7.setBorder(Rectangle.NO_BORDER);
                    cell7.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell7);
                    int tien = ds.GetSoLuong() * ds.GetGia();
                    PdfPCell cell8 = new PdfPCell(new Phrase(String.valueOf(chuyentien.format(tien)) + "VND", font));
                    cell8.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell8.setBorder(Rectangle.NO_BORDER);
                    table.addCell(cell8);
                }
                table.addCell(cell);
                PdfPCell cell9 = new PdfPCell(new Phrase("Giảm Giá", font1));
                cell9.setColspan(3);
                cell9.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell9);
                PdfPCell cell10 = new PdfPCell(new Phrase(String.valueOf(hd1.GetGiamGia()) + "%", font));
                cell10.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell10.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell10);

                cell9 = new PdfPCell(new Phrase("Tổng", font1));
                cell9.setColspan(3);
                cell9.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell9);
                cell10 = new PdfPCell(new Phrase(String.valueOf(chuyentien.format(tong)) + "VND", font));
                cell10.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell10.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell10);

                cell9 = new PdfPCell(new Phrase("Tiền Khách Đưa", font1));
                cell9.setColspan(3);
                cell9.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell9);
                String tien_dua = chuyentien.format(Integer.parseInt(txtTienDua.getText()));
                cell10 = new PdfPCell(new Phrase(tien_dua + "VND", font));
                cell10.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell10.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell10);
                table.addCell(cell);

                cell9 = new PdfPCell(new Phrase("Tiền Thừa", font1));
                cell9.setColspan(3);
                cell9.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell9);
                int thua = tiendua - tong;
                cell10 = new PdfPCell(new Phrase(String.valueOf(chuyentien.format(thua)) + "VND", font));
                cell10.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell10.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell10);
                table.addCell(cell);
                document.add(table);

                Paragraph footer = new Paragraph("Chúc quý khách vui vẻ, hẹn gặp lại !", font1);
                footer.setAlignment(Element.ALIGN_CENTER);
                footer.setSpacingBefore(30);
                document.add(footer);

                document.close();
                writer.close();
                System.out.println("In hoá đơn thành công!");
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(DLThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btnXacNhanActionPerformed

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

    private void txtTienDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienDuaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lbltienthoi;
    private javax.swing.JTextField txtTienDua;
    // End of variables declaration//GEN-END:variables

    private void insertCell(PdfPTable table, String order_No, int ALIGN_LEFT, int par, Font font) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
