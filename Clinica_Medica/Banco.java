public class Banco
{
    private Conta[] banco;// vetor do tipo Conta (classe que criamos)
    private int proxLivre;// variavel que determina proxima posicao livre no vetor(com ela tambem sabemos ate aonde o vetor esta ocuado)
    private int tamMax;// variavel que armazena tamanho maximo que o vetor possui
    private int numConta;// variavel que armazena o numero da conta

    

    public Banco()
    {// Segundo construtor que nao recebe variavel parametrica( o uso de dois construtores em uma classe e denomidado de sobrecarga )
        tamMax = 100;// definimos que o atributo tamMax recebe o valor 100;
        banco = new Conta[tamMax];// inicializa o vetor com tamanho correspondente a tamMax
        proxLivre = 0;// inicializa proxLivre em 0 para poder inserir apartir da posicao 0 do vetor banco
        numConta = 1;// inicializa numConta com 1 pois utilizaremos ele para dizer que o numero da conta comeca em 1
    }

    public void criaConta(String titular, double dindin)
    {// metodo responsavel por criar contas
        Conta novaConta = new Conta(numConta, titular, dindin);//inicializa uma nova conta com o construtor da classe Conta
        banco[proxLivre] = novaConta;// insere no vetor a novaConta de acordo com a proxima posicao livre
        proxLivre++;//incrementa o proxLivre em 1 assim da posicao inicial (0) pulamos para proxima livre que seria (1) e assim por diante
        numConta++;//incrementa o numConta para ser preenchido automaticamente, assim nao e necessario o usuario escolher o numero da conta
    }

    public void removeConta(int numConta)
    {//Se podemos criar conta entao tambem podemos remover
        for(int i = 0; i < proxLivre; i++)// laco que percorre o vetor ate a ultima posicao ocupada por ele
        {
            if(banco[i].getNumConta() == numConta)// verifica se o numero da conta da posicao atual do vetor e o mesmo da variavel parametrica
            {
                for(int k = i; k < proxLivre; k++)//apos encontrar a conta que desejas remover e necessario realocar os dados do vetor
                    banco[k] = banco[k+1];
                
                proxLivre--;//decrementamos o proxLivre pois retivamos uma conta entao a proxima posicao a ser usado tambem sera decrementada
            }
        }
    }

    public void depositaConta(int numConta, double deposito)
    {// metodo responsavel por realizar deposito em uma conta, utiliza o numero da conta para encontrar no vetor a conta que deseja depositar o valor
        int i = 0;// contador, utilizado para percorrer o vetor
        boolean parar = false;// variavel utilizada para parar o laco assim que encontrar a conta no vetor
        while(!parar)
        {
            if(banco[i].getNumConta() == numConta)//pega o numero da conta da posicao atual do vetor e compara com o numero da conta da variavel parametrica
            {
                banco[i].setSaldo(deposito + banco[i].getSaldo());//altera o saldo da conta desejado, soma o deposito(valor que sera depositado) ao valor que ja existe na conta
                parar = true;// informa a estrutura de iteracao quando deve interromper sua atividade
            }
            i++;//incrementa o contador
        }
    }

    public void saqueConta(int numConta, double saque)
    {//metodo resposavel por sacar dinheiro da conta, segue a mesma logica da metodo depositaConta
        int i = 0;// contador, utilizado para percorrer o vetor
        boolean parar = false;// variavel utilizada para parar o laco assim que encontrar a conta no vetor
        while(!parar)
        {
            if(banco[i].getNumConta() == numConta)//pega o numero da conta da posicao atual do vetor e compara com o numero da conta da variavel parametrica
            {
                if((banco[i].getSaldo() * 1.1) >= saque)//apos encontrar pega 110% do valor e verifica se o saque que deseja realizar nao ultaprassa o limite disponivel( dinheiro existete mais 10% que o bando lhe da de credito virtual )
                {
                    banco[i].setSaldo((banco[i].getSaldo() - saque));//altera o saldo, decrementa do saldo existente o valor que deseja sacar
                }
                parar = true;// informa a estrutura de iteracao quando deve interromper sua atividade
            }
            i++;//incrementa o contador
        }
    }

    public void transfereConta(int numContaAtual, int numContaDestino, double tranferencia)
    {//metodo responsavel por realizar tranferencia entre contas
        /*
            Neste metodo e necessario encontrar a conta atual, ou seja a que deseja retirar dinheiro e a conta de destino, ou seja a conta que 
            recebera o incremento de dinheiro, assim realizamos duas buscas e verificamos como no saque se o valor de tranferencia nao sera
            maior do que 110% do valor existente na conta atual.
        */
        int i = 0;// contador, utilizado para percorrer o vetor
        boolean parar = false;// variavel utilizada para parar o laco assim que encontrar a conta no vetor
        while(!parar)
        {
            if(banco[i].getNumConta() == numContaAtual)//pega o numero da conta da posicao atual do vetor e compara com o numero da conta da variavel parametrica numContaAtual
            {
                if((banco[i].getSaldo() * 1.1) >= tranferencia)//apos encontrar pega 110% do valor e verifica se o saque que deseja realizar nao ultaprassa o limite disponivel( dinheiro existete mais 10% que o bando lhe da de credito virtual )
                {
                    banco[i].setSaldo(banco[i].getSaldo() - tranferencia);//altera o saldo, decrementa do saldo existente o valor que deseja tranferir
                }
                parar = true;// informa a estrutura de iteracao quando deve interromper sua atividade
            }
            
            i++;//incrementa o contador
        }

        int k = 0;// contador, utilizado para percorrer o vetor
        boolean para = false;// variavel utilizada para parar o laco assim que encontrar a conta no vetor
        while(!para)
        {
            if(banco[k].getNumConta() == numContaDestino)//pega o numero da conta da posicao atual do vetor e compara com o numero da conta da variavel parametrica numContaDestino
            {
                banco[k].setSaldo(banco[k].getSaldo() + tranferencia);//altera o saldo da conta desejada, soma a tranferencia(valor que sera tranferido de numContaAtual) ao valor que ja existe na conta (numContaDestino)
                para = true;// informa a estrutura de iteracao quando deve interromper sua atividade
            }
            
            k++;//incrementa o contador
        }
    }

    public double saldoConta(int numConta)
    {//metodo responsavel para informar em forma de numero o saldoCorrente(ou seja sem o saldo virtual) ao usuario
        int i = 0;// contador, utilizado para percorrer o vetor 
        boolean parar = false;// variavel utilizada para parar o laco assim que encontrar a conta no vetor
        while(!parar)
        {
            if(banco[i].getNumConta() == numConta)//pega o numero da conta da posicao atual do vetor e compara com o numero da conta da variavel parametrica numContaDestino
            {
                parar = true;// informa a estrutura de iteracao quando deve interromper sua atividade
                return(banco[i].getSaldo());//retornamos o valor da conta desejada (valor do tipo double)
            }
            
            i++;//incrementa o contador
        }
        return(0);//retorno de seguranca(caso nao encontre a conta retorna 0 "erro")
    }

    public void imprimeConta(int numConta)
    {//metodo responsavel por imprimir apenas a conta desejada
        System.out.println();//println apenas para formatacao de texto no terminal
        int i = 0;// contador, utilizado para percorrer o vetor 
        boolean parar = false;// variavel utilizada para parar o laco assim que encontrar a conta no vetor
        while(!parar)
        {
            if(banco[i].getNumConta() == numConta)//pega o numero da conta da posicao atual do vetor e compara com o numero da conta da variavel parametrica numContaDestino
            {
                banco[i].setNomeTitular((banco[i].getNomeTitular()).replaceAll("-", " "));//utilizo o metodo replaceAll(manipulacao de strings) para substituir '-' por 'espaco'
                System.out.printf("Numero da conta: %d\nNome do titulas da conta: %s\nSaldo disponivel: R$ %,.2f\n",// print dos dado da conta desejada
                    banco[i].getNumConta(), banco[i].getNomeTitular(), banco[i].getSaldo());//numero da conta, nome do titular, saldo
                parar = true;// informa a estrutura de iteracao quando deve interromper sua atividade
            }
            i++;//incrementa o contador
        }
    }

    public Conta copiaConta(int numConta)
    {//copia a conta, caso queira manipula-la na classe App ou na classe Menu, assim a manipulacao sera de uma copia e manteremos o dado original da conta
        int i = 0;// contador, utilizado para percorrer o vetor 
        boolean parar = false;// variavel utilizada para parar o laco assim que encontrar a conta no vetor
        Conta copia = null;// variavel do tipo Conta que foi inicializada com (null)
        while(!parar)
        {
            if(banco[i].getNumConta() == numConta)//pega o numero da conta da posicao atual do vetor e compara com o numero da conta da variavel parametrica numContaDestino
            {
                copia = banco[i];// "copia" o "conteudo" da conta desejada
                parar = true;// informa a estrutura de iteracao quando deve interromper sua atividade
            }
        }
        return(copia);// retorna a "copia" da conta
    }

    public void imprimeBanco()
    {// imprime todas as contas existentes do banco
        Conta[] copia = new Conta[proxLivre];// cria um novo vetor do tipo conta com o tamanho de contas existentes
        int i = 0;// contador, utilizado para percorrer o vetor 
        
        while(i < proxLivre)// estrutura iterativa responsavel por "copiar" o conteudo do vetor banco para o vetor copia
        {
            copia[i] = banco[i];// conteudo "copiado" com sucesso
            copia[i].setNomeTitular((copia[i].getNomeTitular()).replaceAll("-", " "));//utilizo o metodo replaceAll(manipulacao de strings) para substituir '-' por 'espaco'
            System.out.println(copia[i] + "\n");// realiza a impressao das contas (utilizou o metodo toString da classe Conta)
            i++;//incrementa o contador
        }
    }

    public void listaDono_Conta()
    {// imprime uma lista que informa o numero de conta e o nome do titular da conta correspondente para se localizar
        Conta[] copia = new Conta[proxLivre];// cria um novo vetor do tipo conta com o tamanho de contas existentes
        int i = 0;// contador, utilizado para percorrer o vetor 

        while(i < proxLivre)// estrutura iterativa responsavel por "copiar" o conteudo do vetor banco para o vetor copia
        {    
            copia[i] = banco[i];// conteudo "copiado" com sucesso
            copia[i].setNomeTitular((copia[i].getNomeTitular()).replaceAll("-", " "));//utilizo o metodo replaceAll(manipulacao de strings) para substituir '-' por 'espaco'
            System.out.printf("Numero Conta: %d .... Titular: %s\n", copia[i].getNumConta(), copia[i].getNomeTitular());// realiza a impressao conforme a formatacao desejada
            i++;//incrementa o contador
        }
    }
}






















