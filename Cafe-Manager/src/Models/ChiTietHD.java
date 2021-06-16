/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class ChiTietHD {
    private int MaChiTietHD, MaHoaDon, SoLuong, Gia;
    private String MaMon;

    public ChiTietHD() {
        MaMon = "";
        MaChiTietHD = 0;
        MaHoaDon = 0;
        SoLuong = 0;
        Gia = 0;
    }

    public ChiTietHD(int machitiet, int mahoadon, String mamon, int soluong, int gia) {
        MaMon = mamon;
        MaChiTietHD = machitiet;
        MaHoaDon = mahoadon;
        SoLuong = soluong;
        Gia = gia;
    }

    public void SetMaChiTietHD(int machitiet) {
        MaChiTietHD = machitiet;
    }

    public int GetMaChiTietHD() {
        return MaChiTietHD;
    }

    public void SetMaHD(int ma) {
        MaHoaDon = ma;
    }

    public int GetMaHD() {
        return MaHoaDon;
    }

    public void SetMaMon(String mamon) {
        MaMon = mamon;
    }

    public String GetMaMon() {
        return MaMon;
    }

    public void SetSoLuong(int soluong) {
        SoLuong = soluong;
    }

    public int GetSoLuong() {
        return SoLuong;
    }

    public void SetGia(int gia) {
        Gia = gia;
    }

    public int GetGia() {
        return Gia;
    }
}
