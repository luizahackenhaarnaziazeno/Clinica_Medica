
//completando estudo de vetor de Objetos
// Fundamentos 2023

public class Principal
{
    public static void main(String [] args)
    {
         CadastroGatos cg= new CadastroGatos (3);
         Gato g1= new Gato ("Fufu",2,"branca");
         Gato g2= new Gato ("Felix",3,"preto e branco");
         Gato g3= new Gato ("Ulisses",1,"amarelo");
         cg.adicionaNoVetor(g1);
         cg.adicionaNoVetor(g2);
         cg.adicionaNoVetor(g3);
         cg.imprimeVetor();
         
         double media=(g1.getIdade()+g2.getIdade()+g3.getIdade())/3;
         System.out.println("\n Media de idade dos gatos direto dos objetos: " + media);
         
         //***direto do vetor de objeto
         System.out.println("\n Media de idade dos gatos usando metodo da classe cadastro: " + cg.media());
         
         int quant1=0;
         if (g1.getCor().equalsIgnoreCase("Branca")) {quant1++;}
         if (g2.getCor().equalsIgnoreCase("Branca")) {quant1++;}
         if (g3.getCor().equalsIgnoreCase("Branca")) {quant1++;}
         
         System.out.println("\n Quantidade de gatos brancos direto dos objetos: "+ quant1);
                
         // como  o metodo pede o endereço do vetor para poder usar terei de combinar para acessar o vetor na memoria
         System.out.println ("\n Endereco do vetor: " +cg.getGato());
         //*** agora pego direto do objeto
         int quant=cg.contaGatosBrancos(cg.getGato());
         System.out.println("\n Quantidade de gatos brancos pegos usando metodo da classe cadastro: " +quant);
         
         cg.removeGato(g2);
         cg.imprimeVetor();
       
          
         
       
        

    }
}
