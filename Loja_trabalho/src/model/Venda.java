
package model;


public class Venda {
private int codvenda;
private int codvendedor;
private int codproduto;
private double totalvenda;
private int qtdvendida;

    public Venda() {
       
    }

    public int getCodvenda() {
        return codvenda;
    }

    public void setCodvenda(int codvenda) {
        this.codvenda = codvenda;
    }

    public int getCodvendedor() {
        return codvendedor;
    }

    public void setCodvendedor(int codvendedor) {
        this.codvendedor = codvendedor;
    }

    public int getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }

    public double getTotalvenda() {
        return totalvenda;
    }

    public void setTotalvenda(double totalvenda) {
        this.totalvenda = totalvenda;
    }

    public int getQtdvendida() {
        return qtdvendida;
    }

    public void setQtdvendida(int qtdvendida) {
        this.qtdvendida = qtdvendida;
    }

}
