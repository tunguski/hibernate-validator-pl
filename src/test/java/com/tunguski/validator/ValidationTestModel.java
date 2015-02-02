package com.tunguski.validator;


/**
 * Created by marek on 04.07.14.
 */
public class ValidationTestModel {


  @PESEL
  protected String pesel;
  @NIP
  protected String nip;
  @Alpha
  protected String alpha;
  @Alpha(allowNumeric = true)
  protected String alpha1;
  @Alpha(allowSpace = true)
  protected String alpha2;
  @Alpha(allowSpace = true, allowNumeric = true)
  protected String alpha3;
  @AsciiPrintable
  protected String asciiPrintable;
  @ISBN
  protected String isbn;
  @LowerCase
  protected String lowerCase;
  @PNA
  protected String pna;
  @PWZ
  protected String pwz;
  @REGON
  protected String regon;


  public String getPesel() {
    return pesel;
  }
  public void setPesel(String pesel) {
    this.pesel = pesel;
  }
  public String getNip() {
    return nip;
  }
  public void setNip(String nip) {
    this.nip = nip;
  }
  public String getAlpha() {
    return alpha;
  }
  public void setAlpha(String alpha) {
    this.alpha = alpha;
  }
  public String getIsbn() {
    return isbn;
  }
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
  public String getLowerCase() {
    return lowerCase;
  }
  public void setLowerCase(String lowerCase) {
    this.lowerCase = lowerCase;
  }
  public String getPna() {
    return pna;
  }
  public void setPna(String pna) {
    this.pna = pna;
  }
  public String getPwz() {
    return pwz;
  }
  public void setPwz(String pwz) {
    this.pwz = pwz;
  }
  public String getRegon() {
    return regon;
  }
  public void setRegon(String regon) {
    this.regon = regon;
  }
  public String getAsciiPrintable() {
    return asciiPrintable;
  }
  public void setAsciiPrintable(String asciiPrintable) {
    this.asciiPrintable = asciiPrintable;
  }
  public String getAlpha1() {
    return alpha1;
  }
  public void setAlpha1(String alpha1) {
    this.alpha1 = alpha1;
  }
  public String getAlpha2() {
    return alpha2;
  }
  public void setAlpha2(String alpha2) {
    this.alpha2 = alpha2;
  }
  public String getAlpha3() {
    return alpha3;
  }
  public void setAlpha3(String alpha3) {
    this.alpha3 = alpha3;
  }
}

