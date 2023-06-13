import java.util.stream.Stream;

public class Produto {
    
private String codigo;
private String nome;
private Double valor;
private int quantEstoque;

public String getCodigo() {
    return codigo;
}


public void setCodigo(String codigo) {
    this.codigo = codigo;
}


public String getNome() {
    return nome;
}


public void setNome(String nome) {
    this.nome = nome;
}


public Double getValor() {
    return valor;
}


public void setValor(Double valor) {
    this.valor = valor;
}


public int getQuantEstoque() {
    return quantEstoque;
}


public void setQuantEstoque(int quantEstoque) {
    this.quantEstoque = quantEstoque;
}


@Override
public String toString() {
    return String.format("Código: %s | Nome: %s | Valor: %.2f | Quantidade em estoque: %d", codigo, nome, valor, quantEstoque);
}


public Produto( String codigo, String nome, Double valor, int quantEstoque){
    this.codigo = codigo;
    this.nome = nome;
    this.valor = valor;
    this.quantEstoque = quantEstoque;
}








}
