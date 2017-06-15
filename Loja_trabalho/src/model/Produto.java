
package model;

public class Produto {
    
private int codproduto;
private String nomeproduto;
private double precoproduto;
private int qtdproduto;

    public Produto() {
        
    }

    

    public int getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public double getPrecoproduto() {
        return precoproduto;
    }

    public void setPrecoproduto(double precoproduto) {
        this.precoproduto = precoproduto;
    }

    public int getQtdproduto() {
        return qtdproduto;
    }

    public void setQtdproduto(int qtdproduto) {
        this.qtdproduto = qtdproduto;
    }

}
