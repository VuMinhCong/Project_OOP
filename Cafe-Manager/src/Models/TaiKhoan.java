/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class TaiKhoan {
    private int id, lv;
    private String tdn, mk;

    public TaiKhoan() {
        id = lv = 0;
        tdn = "";
        mk = "";
    }

    public TaiKhoan(int id, String tdn, String mk, int lv) {
        this.id = id;
        this.lv = lv;
        this.tdn = tdn;
        this.mk = mk;
    }

    public void SetID(int id) {
        this.id = id;
    }

    public int GetID() {
        return this.id;
    }

    public void SetLv(int lv) {
        this.lv = lv;
    }

    public int GetLv() {
        return this.lv;
    }

    public void Settdn(String tdn) {
        this.tdn = tdn;
    }

    public String Gettdn() {
        return this.tdn;
    }

    public void Setmk(String mk) {
        this.mk = mk;
    }

    public String Getmk() {
        return this.mk;
    }
}
