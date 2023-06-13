import java.time.LocalDate;

public class Venda {
    
    @Override
    public String toString() {
        return "Venda [data da venda=" + dataVenda + ", produto vendido=" + produtoVendido + ", quantidade vendida=" + quantVendida
                + "]";
    }
    private LocalDate dataVenda;
    private String produtoVendido;
    private int quantVendida;

public Venda( LocalDate dataVenda, String produtoVendido, int quantVendida){
    this.dataVenda = dataVenda;
    this.produtoVendido = produtoVendido;
    this.quantVendida = quantVendida;
}

    public LocalDate getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
    public String getProdutoVendido() {
        return produtoVendido;
    }
    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }
    public int getQuantVendida() {
        return quantVendida;
    }
    public void setQuantVendida(int quantVendida) {
        this.quantVendida = quantVendida;
    }

}
