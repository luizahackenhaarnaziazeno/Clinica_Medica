


//organizando a colecao de gatos "lista" que não e lista! eum vetor de objetos tipo Gato

public class CadastroGatos
{
    private Gato [] vetor;
    private int index;

    public CadastroGatos(int tamanho){
        //criação de vetor de objetos
        vetor = new Gato[tamanho];
        index = 0;
    }
    //Verifica se há espaço disponível no vetor. 
    //Se houver, o objeto Gato é adicionado ao vetor na posição index e esta 
    //é incrementada. Se o vetor estiver cheio retorna false.
    public boolean adicionaNoVetor(Gato c){
        if(index >= vetor.length){
            return false;
        } else {
            vetor[index] = c;
            index++;
            return true;
        }
    }
    //Percorre o vetor e verifica se o objeto g está nele. Se o objeto for 
    //encontrado, o método retorna a posição em que foi encontrado. 
    //Senão retorna -1 para indicar que o objeto não foi encontrado.
     public int localizaGato(Gato g) 
     {  int local=-1;
         for(int i=0; i<index; i++)
         {
            if(vetor[i]==g){local=i;}            
                      
        }
        return local;
    }
    
    //remove o objeto Gato especificado do vetor. Encontra a posição do 
    //objeto usando o método localizaGato(g), desloca todos os elementos 
    //subsequentes uma posição para a esquerda e decrementa o valor de index.
    //Retorna true para indicar que a remoção foi realizada com sucesso.
    public boolean removeGato(Gato g)
    {
        int posicao= localizaGato(g);
               {
                for(int i= posicao; i<index-1; i++){
                    vetor[i] = vetor[i+1];
                }
                vetor[index-1] = null;      
                index--;        
                return true; 
            }
    }
        //imprime o vetor    
        public void imprimeVetor(){
        for(int i=0; i<index; i++){
            System.out.println("\nCadastro de gatos na posicao" + (i+1)+ "\n********* ** ***** ** *******");            
            System.out.println(vetor[i].toString());
        }        
    }

    // itera sobre o array de gatos g e conta quantos gatos possuem a cor 
    //"Branca". O método retorna o valor de conta, que representa 
    //o número total de gatos brancos encontrados.
    public int contaGatosBrancos(Gato [] g){
        int conta = 0;        
        for(int i=0; i<g.length; i++){
            if(g[i].getCor().equalsIgnoreCase("Branca")){                
                conta++;
            }
        }
        return conta;
    }
    //retorna o vetor de gatos armazenado na classe CadastroGatos. 
    //Permite que o vetor seja acessado fora da classe e seja utilizado 
    //para obter informações sobre os gatos ou realizar operações adicionais.
    public Gato[] getGato() {
        return vetor; 
    }
    
    //retorna a média das idades dos três primeiros gatos armazenados no vetor
    //Acessa as idades dos gatos no vetor e realiza o cálculo da média 
    public double media() 
    {
     return (vetor[0].getIdade()+vetor[1].getIdade()+vetor[2].getIdade())/3;
    
    }
     
    
    }