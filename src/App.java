import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class App {
   
    public static void main(String[] args) throws Exception {

        List<Produto> listaProdutos = new ArrayList<>();
        List<Venda> ListaVendido = new ArrayList<>();
        DateTimeFormatter dataformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.print("\033[H\033[2J");   
        System.out.flush();

      do {

        System.out.println("1 - INCLUIR PRODUTO");
        System.out.println("2 - CONSULTAR PRODUTO");
        System.out.println("3 - LISTA PRODUTO");
        System.out.println("4 - VENDA DO PERÍODO");
        System.out.println("5 - REALIZAR VENDA");
        System.out.println("0 - SAIR");
        opcao =sc.nextInt();

       if(opcao == 1){

        System.out.println("Digite o código do produto: ");
        String codigo = sc.next();

        System.out.println("Digite o nome do produto: ");
        String nome = sc.next();

        System.out.println("Digite o valor do produto: ");
        double valor= sc.nextDouble();

        System.out.println("Digite a quantida em estoque: ");
        int quantEstoque  = sc.nextInt();

        listaProdutos.add (new Produto( codigo, nome, valor, quantEstoque));
       }

       if(opcao == 2){
        System.out.println(" Digite o código do produto");
        String codigo = sc.next();
 
        List<Produto> novaList = listaProdutos.stream()
        .filter(p -> p .getCodigo().equals(codigo)).collect(Collectors.toList());;
        if(novaList.isEmpty()){
         System.out.println("Produto não encontrado!");
     }
       else{
         for (Produto produto: novaList) {
            System.out.println( "\n" + produto);
         }
       }
       
        }

      if(opcao == 3){
       for (Produto produto  : listaProdutos) {
        System.out.println(produto);
       }
       DoubleSummaryStatistics batata = listaProdutos.stream()
       .filter( p-> p instanceof Produto)
       .collect(Collectors.summarizingDouble(Produto::getValor));

       System.out.println("Média: " + batata.getAverage());
       System.out.println("Máximo valor: " + batata.getMax());
       System.out.println("Mínimo valor: " + batata.getMin());
      }
     

      if(opcao == 4){

    

     System.out.println("Informe a primeira data");
     String data1 = sc.next();

     System.out.println("Informe a segunda data");
     String data2 = sc.next();

     LocalDate periodo1 = LocalDate.parse(data1, dataformat);
     LocalDate periodo2 = LocalDate.parse(data2, dataformat);

     for (Venda venda : ListaVendido) {
      if(venda.getDataVenda().compareTo(periodo1) >= 0 && venda.getDataVenda().compareTo(periodo2) < 1 ){
      System.out.println(venda);
      }
     
     
     }


     
      }
      if(opcao == 5){

        System.out.println("Informe o código do produto");
      String codigodevenda = sc.next();

     List<Produto> novaLista = listaProdutos.stream()
.filter( p -> p .getCodigo().equals(codigodevenda)).collect(Collectors.toList());;
    
if(novaLista.isEmpty()){
      System.out.println("Produto não Localizado!!");
     }
     else{
          System.out.println("Informe a data da venda");
         String dataVenda = sc.next();
         LocalDate dt = LocalDate.parse(dataVenda,dataformat);
   
      
       System.out.println("Informe a quantidade");
       int quantVendida = sc.nextInt();

     Produto produto = novaLista.get(0);
     Venda venda = new Venda(dt, produto.getNome() , quantVendida);
     if(produto.getQuantEstoque() < quantVendida ){
      System.out.println("Quantidade insuficiente");
     }else{

     ListaVendido.add(venda);
     produto.setQuantEstoque(produto.getQuantEstoque() - quantVendida);

     System.out.println("Venda Realizada com Sucesso");
    }
      }
    }

      }while( opcao != 0);

      System.out.println(" **PROGRAMA FINALIZADO** ");
    }

   
   
    }

    
  
  
