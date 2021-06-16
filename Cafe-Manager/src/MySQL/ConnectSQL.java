/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mysql;

import Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * @author thanhhff
 */
public class ConnectSQL {

    private Connection connect;

    /**
     * 0. Connect
     * <p>
     * ConnectSQL()
     */
    public ConnectSQL() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe-manager?useUnicode=true&characterEncoding=utf8", "root", "");
            System.out.println("Kết nối SQL thành công !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi ConnectSQL: kết nối tới SQL thất bại !");
        }
    }

    /**
     * 1. Ban
     * <p>
     * public Ban(int maBan, String tenBan, String trangThai)
     */
    public ArrayList<Ban> GetBan(int maban) {
        ArrayList<Ban> arrBan = null;
        String sql;
        if (maban == 0) {
            sql = "Select * From ban";
        } else {
            sql = "Select * From ban Where MaBan = '" + maban + "'";
        }
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<Ban>();
            while (rs.next()) {

                // public Ban(int maBan, String tenBan, String trangThai)
                Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrBan.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetBan: (from table ban) !");
        }
        return arrBan;
    }

    public int UpdateBan(Ban b) {
        int update = 0;
        String sql = "UPDATE ban SET TenBan = '" + b.GetTenBan() + "', TrangThai = '" + b.GetTrangThai() + "' WHERE MaBan = '" + b.GetMaBan() + "'";
        try {
            Statement st = connect.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi UpdateBan: cập nhật bàn không thành công !");
        }
        return update;
    }

    public int UpDateTrangThaiBan(Ban b) {
        int update = 0;
        String sql = "UPDATE ban SET TrangThai = '" + b.GetTrangThai() + "' WHERE MaBan = '" + b.GetMaBan() + "'";
        try {
            Statement st = connect.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi UpdateTrangThaiBan: update trạng thái bàn không thành công !");
        }
        return update;
    }

    public int InsertBan(Ban b) {
        int insert = 0;
        String sql = "Insert into ban (TenBan, TrangThai) values ('" + b.GetTenBan() + "', '" + b.GetTrangThai() + "')";
        try {
            Statement st = connect.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi InsertBan: Insert bàn thất bại !");
        }
        return insert;
    }

    public boolean DeleteBan(ArrayList<Integer> listMaBan) {
        boolean check = false;
        try {
            String sql;
            for (int ma : listMaBan) {
                sql = "Delete From ban Where MaBan = '" + ma + "'";
                Statement st = connect.createStatement();
                st.executeUpdate(sql);
            }
            check = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi DeleteBan: Delete bàn thất bại !");
        }
        return check;
    }

    public ArrayList<Ban> SearchBan(String ten) {
        ArrayList<Ban> arrtd = null;
        String sql;
        sql = "SELECT * FROM ban WHERE TenBan LIKE '" + ten + "%'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<Ban>();
            while (rs.next()) {
                Ban td = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrtd.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi SearchBan: thất bại !");
        }
        return arrtd;
    }

    /**
     * 2. ChiTietHD
     * <p>
     * public ChiTietHD(int maChiTietHD, int maHoaDon, String maMon, int
     * soLuong, int gia)
     */
    public ChiTietHD GetDsChiTiet(String mamon, int maban) {
        ChiTietHD arrDs = null;
        String sql;

        sql = "Select SoLuong, Gia, MaChiTietHD From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon Where MaMon = '" + mamon + "' AND MaBan = '" + maban + "' AND hd.TrangThai = 0";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrDs = new ChiTietHD();
                arrDs.SetSoLuong(rs.getInt(1));
                arrDs.SetGia(rs.getInt(2));
                arrDs.SetMaChiTietHD(rs.getInt(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetDSChiTiet: không lấy được danh sách Order !");
        }
        return arrDs;
    }

    public int UpdateChiTiet(ChiTietHD ct) {
        int update = 0;
        String sql = "UPDATE chitiethd SET SoLuong = '" + ct.GetSoLuong() + "', Gia = '" + ct.GetGia() + "' WHERE MaChiTietHD = '" + ct.GetMaChiTietHD() + "'";
        try {
            Statement st = connect.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi UpdateChiTiet: Update chi tiết không thành công !");
        }
        return update;
    }

    public int CheckDsMon(int mahd, int maban) {
        String sql;
        int dem = 0;
        sql = "Select * From hoadon AS hd INNER JOIN chitiethd AS ct ON ct.MaHoaDon = hd.MaHoaDon Where MaBan = '" + maban + "' AND ct.MaHoaDon = '" + mahd + "' AND TrangThai = 0";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dem++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi CheckDSMon: không lấy được danh sách hóa đơn !");
        }
        return dem;
    }

    public int DeleteMon(String mamon, int mahd, int maban) {
        int check = 0;
        try {
            String sql;
            sql = "Delete From chitiethd Where MaMon = '" + mamon + "' AND MaHoaDon = '" + mahd + "'";
            Statement st = connect.createStatement();
            st.executeUpdate(sql);
            check = 1;
            if (CheckDsMon(mahd, maban) == 0) {
                check = 2;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi DeleteMon !");
        }
        return check;
    }

    public int InsertChiTietHD(ChiTietHD cthd) {
        int insert = 0;
        String sql = "Insert into chitiethd (MaChiTietHD, MaHoaDon, MaMon, SoLuong, Gia) values ('" + cthd.GetMaChiTietHD() + "', '" + cthd.GetMaHD() + "', '" + cthd.GetMaMon() + "', '" + cthd.GetSoLuong() + "', '" + cthd.GetGia() + "')";
        try {
            Statement st = connect.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi InsertChiTietHD: thêm chi tiết hóa đơn không thành công !" + ex.toString());
        }
        return insert;
    }

    public ArrayList<DsOrder> GetCtHDByDate(int ma, String d1, String d2) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        if (d1.equals(d2)) {
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '" + ma + "' AND hd.GioDen >= '" + d1 + "'";
        } else {
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '" + ma + "' AND hd.GioDen BETWEEN '" + d1 + "' AND '" + d2 + "'";
        }
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetCtHDByDate: Không lấy được danh sách chi tiết hoa đơn !" + ex.toString());
        }
        return arrDs;
    }

    /**
     * 3. DsOrder
     * <p>
     * public DsOrder(String maMon, String tenMon, String dvt, int soLuong, int
     * gia, int maHoaDon)
     */
    public ArrayList<DsOrder> GetDsOrder(int ma) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon Where ct.MaHoaDon = '" + ma + "'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {

                // public DsOrder(String maMon, String tenMon, String dvt, int soLuong, int gia, int maHoaDon)
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;
    }

    /**
     * 4. HoaDon
     * <p>
     * public HoaDon(int MaHoaDon, int GiamGia, int MaBan, Date GioDen, int
     * TongTien, int TrangThai)
     */
    public int ThanhToan(HoaDon hd) {
        int update = 0;
        String sql = "UPDATE hoadon SET TongTien = '" + hd.GetTongTien() + "', TrangThai = 1 WHERE MaHoaDon = '" + hd.GetMaHD() + "'";
        try {
            Statement st = connect.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi ThanhToan: thanh toán không thành công !");
        }
        return update;
    }

    public int HuyHD(HoaDon hd) {
        int update = 0;
        String sql = "Delete From hoadon WHERE MaHoaDon = '" + hd.GetMaHD() + "'";
        try {
            Statement st = connect.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi HuyHD: Thanh toán không thành công !");
        }
        return update;
    }

    public int InsertHoaDon(HoaDon hd, String gio) {
        int insert = 0;
        String sql = "Insert into hoadon (MaBan, GioDen, TrangThai) values ('" + hd.GetMaBan() + "', '" + gio + "', '" + hd.GetTrangThai() + "')";
        try {
            Statement st = connect.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
        }
        return insert;
    }

    public HoaDon GetHDbyMaBan(int ma) {
        String sql;
        HoaDon arrhd = null;
        sql = "Select * From hoadon Where MaBan = '" + ma + "' AND TrangThai = 0";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrhd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetHDbyMaBan: Không lấy được danh sách hóa đơn !");
        }
        return arrhd;
    }

    public HoaDon GetHDbyMa(int ma) {
        String sql;
        HoaDon arrhd = null;
        sql = "Select * From hoadon Where MaHoaDon = " + ma;
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrhd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetHDbyMaBan: Không lấy được danh sách hóa đơn !");
        }
        return arrhd;
    }

    public int GetMaHD(int ma) {
        String sql;
        int mahd = 0;
        sql = "Select MaHoaDon From hoadon Where MaBan = '" + ma + "' AND TrangThai = 0";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                mahd = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetMaHD: không lấy được danh sách thực đơn !");
        }
        return mahd;
    }

    public int UpdateHD(HoaDon hd) {
        int update = 0;
        String sql = "UPDATE hoadon SET GiamGia = '" + hd.GetGiamGia() + "' WHERE MaHoaDon = '" + hd.GetMaHD() + "'";
        try {
            Statement st = connect.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi UpdateHD: giảm giá không thành công !");
        }
        return update;
    }

    public ArrayList<HoaDon> GetDSHD() {
        ArrayList<HoaDon> arrDs = null;
        String sql;
        sql = "Select * From hoadon Where TrangThai = 1";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<HoaDon>();
            while (rs.next()) {
                HoaDon order = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetDSHD: thất bại !");
        }
        return arrDs;
    }

    public ArrayList<DsOrder> GetHdByDate(String d1, String d2, String m) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        if (d1.equals(d2)) {
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen >= '" + d1 + "' AND ct.MaMon ='" + m + "'";
        } else {
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen BETWEEN '" + d1 + "' AND '" + d2 + "' AND ct.MaMon ='" + m + "'";
        }
        try {

            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder();
                order.SetGia(rs.getInt(1));
                order.SetSoLuong(rs.getInt(2));
                order.SetTenMon(rs.getString(3));
                order.SetDVT(rs.getString(4));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetHDByDate !");
        }
        return arrDs;
    }

    /**
     * 5. Loai
     * <p>
     * public Loai(String MaLoai, String TenLoai, String MauSac)
     */
    public ArrayList<Loai> GetLoai() {
        ArrayList<Loai> arrloai = null;
        String sql = "Select * From nhommon";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new ArrayList<Loai>();
            while (rs.next()) {

                // public Loai(String MaLoai, String TenLoai, String MauSac)
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetLoai: (from table nhommon) !");
        }
        return arrloai;
    }

    public String GetMaLoai(String TenLoai) {
        String maloai = null;
        String sql = "Select MaLoai From nhommon Where TenLoai = '" + TenLoai + "'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                maloai = rs.getString(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetMaLoai: không lấy được mã loại !");
        }
        return maloai;
    }

    public int InsertLoai(Loai b) {
        int insert = 0;
        String sql = "Insert into nhommon (TenLoai, MauSac) values ('" + b.GetTenLoai() + "', '" + b.GetMauSac() + "')";
        try {
            Statement st = connect.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi InsertLoai: chèn loại thất bại !");
        }
        return insert;
    }

    public boolean DeleteNhom(ArrayList<String> lismanhom) {
        boolean check = false;
        try {
            String sql;
            for (String ma : lismanhom) {
                sql = "Delete From nhommon Where MaLoai = '" + ma + "'";
                Statement st = connect.createStatement();
                st.executeUpdate(sql);
            }
            check = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi DeleteNhom: xoá nhóm thất bại !");
        }
        return check;
    }

    public Loai GetLoaiByMa(String manhom) {
        Loai loai = null;
        String sql = "Select * From nhommon Where MaLoai = '" + manhom + "'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                loai = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetLoaiByMa: thất bại !");
        }
        return loai;
    }

    public int UpdateLoai(Loai b) {
        int update = 0;
        String sql = "UPDATE nhommon SET TenLoai = '" + b.GetTenLoai() + "', MauSac = '" + b.GetMauSac() + "' WHERE MaLoai = '" + b.GetMaLoai() + "'";
        try {
            Statement st = connect.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi UpdateLoai: update Loại không thành công !");
        }
        return update;
    }

    public ArrayList<Loai> SearchLoai(String ten) {
        ArrayList<Loai> arrtd = null;
        String sql;
        sql = "SELECT * FROM nhommon WHERE TenLoai LIKE '" + ten + "%'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<Loai>();
            while (rs.next()) {
                Loai td = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrtd.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi UpdateLoai: thất bại !");
        }
        return arrtd;
    }

    /**
     * 6. TaiKhoan
     * <p>
     * public TaiKhoan(int id, String tdn, String mk, int lv)
     */
    public boolean CheckLogin(TaiKhoan tk) {
        boolean check = false;
        String sql;
        sql = "Select * From taikhoan Where username = '" + tk.Gettdn() + "' AND password='" + tk.Getmk() + "'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi CheckLogin: đã xảy ra lỗi khi đăng nhập !");
        }
        return check;
    }

    public int LVTK(TaiKhoan tk) {
        int lvtk = 0;
        String sql;
        sql = "Select lv From taikhoan Where username = '" + tk.Gettdn() + "' AND password='" + tk.Getmk() + "'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lvtk = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi LVTK !");
        }
        return lvtk;
    }

    public boolean DeleteTaiKhoan(ArrayList<Integer> listMaBan) {
        boolean check = false;
        try {
            String sql;
            for (int ma : listMaBan) {
                sql = "Delete From taikhoan Where id = '" + ma + "'";
                Statement st = connect.createStatement();
                st.executeUpdate(sql);
            }
            check = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi DeleteTaiKhoan: xoá tài khoản thất bại !");

        }
        return check;
    }

    public int InserTK(TaiKhoan b) {
        int insert = 0;
        String sql = "Insert into taikhoan (username, password, lv) values ('" + b.Gettdn() + "', '" + b.Getmk() + "', '" + b.GetLv() + "')";
        try {
            Statement st = connect.createStatement();
            insert = st.executeUpdate(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi InsertTK: chèn tải khoản thất bại !");
        }
        return insert;
    }

    public ArrayList<TaiKhoan> GetTaiKhoan() {
        ArrayList<TaiKhoan> arrtd = null;
        String sql;
        sql = "SELECT * FROM taikhoan WHERE lv != 0";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<TaiKhoan>();
            while (rs.next()) {
                TaiKhoan td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                arrtd.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetTaiKhoan: thất bại !");
        }
        return arrtd;
    }

    public TaiKhoan GetTaiKhoan(int id) {
        TaiKhoan td = null;
        String sql;
        sql = "SELECT * FROM taikhoan WHERE id = '" + id + "'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetTaiKhoan: thất bại !");
        }
        return td;
    }

    public TaiKhoan GetTaiKhoan(String name, String pass) {
        TaiKhoan td = null;
        String sql;
        sql = "SELECT * FROM taikhoan Where username = '" + name + "' AND password='" + pass + "'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetTaiKhoan: thất bại !");
        }
        return td;
    }

    public int UpdateTK(TaiKhoan b) {
        int update = 0;
        String sql = "UPDATE taikhoan SET username = '" + b.Gettdn() + "', password = '" + b.Getmk() + "', lv = '" + b.GetLv() + "' WHERE id = '" + b.GetID() + "'";
        try {
            Statement st = connect.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return update;
    }

    /**
     * 7. ThucDon
     * <p>
     * public ThucDon(String MaMon, String TenMon, String MaLoai, int DonGia,
     * String DVT)
     */
    public ArrayList<ThucDon> GetThucDonByMa(String ma) {
        ArrayList<ThucDon> arrThucDon = null;
        String sql;

        sql = "Select * From thucdon Where MaMon = '" + ma + "'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while (rs.next()) {

                // public ThucDon(String MaMon, String TenMon, String MaLoai, int DonGia, String DVT)
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetThucDonByMa: không lấy được danh sách thực đơn !");
        }
        return arrThucDon;
    }

    public ArrayList<ThucDon> GetThucDon(String ma) {
        ArrayList<ThucDon> arrThucDon = null;
        String sql;
        if (ma == null) {
            sql = "Select * From thucdon";
        } else {
            sql = "Select * From thucdon Where MaLoai = '" + ma + "'";
        }
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetThucDon: không lấy được danh sách thực đơn !");
        }
        return arrThucDon;
    }

    public Vector GetNhomMon() {
        Vector arrloai = null;
        String sql = "Select * From nhommon";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new Vector();
            Loai all = new Loai(null, "Tất cả các món", "");
            arrloai.add(all);
            while (rs.next()) {
                // Không thêm nhóm được yêu thích vào danh sách => Tránh trùng lặp !!!
                if (rs.getString(1).equals("1")) {
                    continue;
                }
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetNhomMon: lấy nhóm món thất bại !");
        }
        return arrloai;
    }

    public int InsertThucDon(ThucDon td) {
        int insert = 0;
        String sql = "Insert into thucdon (TenMon, MaLoai, DonGia, DVT) values ('" + td.GetTenMon() + "', '" + td.GetMaLoai() + "', '" + td.GetDonGia() + "', '" + td.GetDVT() + "')";
        try {
            Statement st = connect.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi InsertThucDon: chèn thực đơn thất bại !");
        }
        return insert;
    }

    public boolean DeleteThucDon(ArrayList<String> listMamon) {
        boolean check = false;
        try {
            String sql;
            for (String ma : listMamon) {
                sql = "Delete From thucdon Where MaMon = '" + ma + "'";
                Statement st = connect.createStatement();
                st.executeUpdate(sql);
            }
            check = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi DeleteThucDon: xoá thực đơn thất bại !");
        }
        return check;
    }

    public int UpdateThucDon(ThucDon td) {
        int update = 0;
        String sql = "UPDATE thucdon SET TenMon = '" + td.GetTenMon() + "', MaLoai = '" + td.GetMaLoai() + "', DonGia = '" + td.GetDonGia() + "', DVT = '" + td.GetDVT() + "' WHERE MaMon = '" + td.GetMaMon() + "'";
        try {
            Statement st = connect.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi UpdaetThucDon: update món không thành công !");
        }
        return update;
    }

    public ArrayList<ThucDon> SearchMon(String ten) {
        ArrayList<ThucDon> arrtd = null;
        String sql;
        sql = "SELECT * FROM thucdon WHERE TenMon LIKE '" + ten + "%'";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrtd.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi SearchMon: thất bại !");
        }
        return arrtd;
    }

    public ArrayList<ThucDon> GetDsMonBan() {
        ArrayList<ThucDon> arrDs = null;
        String sql;
        sql = "Select TenMon, MaMon, DVT From thucdon WHERE MaMon in (Select MaMon From chitiethd) AND hoadon.TrangThai = 1";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon order = new ThucDon();
                order.SetTenMon(rs.getString(1));
                order.SetMaMon(rs.getString(2));
                order.SetDVT(rs.getString(3));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetDSMonBan: danh sách món bán thất bại !");
        }
        return arrDs;
    }

    // Interface BanHang 
    public ArrayList<ThucDon> GetChiTietMonByMa() {
        ArrayList<ThucDon> arrDs = null;
        String sql;
        sql = "SELECT TenMon, MaMon, DVT FROM thucdon where MaMon in (Select MaMon From chitiethd)";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon order = new ThucDon();
                order.SetTenMon(rs.getString(1));
                order.SetMaMon(rs.getString(2));
                order.SetDVT(rs.getString(3));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetChiTiteMonByMa: thất bại !");
        }
        return arrDs;
    }

    public ThucDon GetThucDonMa(String ma) {
        ThucDon td = null;
        String sql;
        sql = "Select * From thucdon Where MaMon = '" + ma + "'";

        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetThucDonMa: không lấy được danh sách thực đơn !");
        }
        return td;
    }

    public ArrayList<ThucDon> GetMonYeuThich() {
        ArrayList<ThucDon> arrThucDon = null;
        String sql;
        sql = "Select ct.MaMon From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 order by SoLuong DESC Limit 10";
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while (rs.next()) {
//                System.out.println(rs.getString(1));
                ThucDon td = GetThucDonMa(rs.getString(1));
                arrThucDon.add(td);
//                System.out.println(td.GetTenMon());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetMonYeuThich: thất bại !");
        }
        return arrThucDon;
    }

    /**
     * 8. Other
     * <p>
     */
    public ArrayList<DsOrder> GetGiaSoLuong(String ma) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND ct.MaMon = '" + ma + "'";
        try {

            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {

                DsOrder order = new DsOrder();
                order.SetGia(rs.getInt(1));
                order.SetSoLuong(rs.getInt(2));
                order.SetTenMon(rs.getString(3));
                order.SetDVT(rs.getString(4));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi GetGiaSoLuong !");
        }
        return arrDs;
    }

}
