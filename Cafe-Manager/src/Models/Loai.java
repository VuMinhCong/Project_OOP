/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class Loai {
    private String MaLoai, TenLoai, MauSac;

    public Loai() {
        this.MaLoai = "";
        this.TenLoai = "";
        this.MauSac = "";
    }

    public Loai(String ma, String ten, String mau) {
        this.MaLoai = ma;
        this.TenLoai = ten;
        this.MauSac = mau;
    }

    public void SetMauSac(String mau) {
        this.MauSac = mau;
    }

    public String GetMauSac() {
        return this.MauSac;
    }

    public void SetMaLoai(String ma) {
        this.MaLoai = ma;
    }

    public String GetMaLoai() {
        return this.MaLoai;
    }

    public void SetTenLoai(String ten) {
        this.TenLoai = ten;
    }

    public String GetTenLoai() {
        return this.TenLoai;
    }

    @Override
    public String toString() {
        return this.TenLoai;
    }

}
