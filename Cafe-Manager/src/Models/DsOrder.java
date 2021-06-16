/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class DsOrder {
    private String TenMon, MaMon, DVT;
    private int Gia, SoLuong, MaHoaDon;

    public DsOrder() {
        TenMon = MaMon = DVT = "";
        Gia = SoLuong = MaHoaDon = 0;
    }

    public DsOrder(String mamon, String tenmon, String dvt, int soluong, int gia, int mahd) {
        MaMon = mamon;
        MaHoaDon = mahd;
        TenMon = tenmon;
        DVT = dvt;
        Gia = gia;
        SoLuong = soluong;
    }

    public void SetMaHD(int mahd) {
        MaHoaDon = mahd;
    }

    public int GetMaHD() {
        return MaHoaDon;
    }

    public void SetMaMon(String mamon) {
        this.MaMon = mamon;
    }

    public String GetMaMon() {
        return this.MaMon;
    }

    public void SetTenMon(String ten) {
        this.TenMon = ten;
    }

    public String GetTenMon() {
        return this.TenMon;
    }

    public void SetDVT(String dvt) {
        this.DVT = dvt;
    }

    public String GetDVT() {
        return this.DVT;
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
