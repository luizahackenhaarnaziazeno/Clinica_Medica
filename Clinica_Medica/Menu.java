import java.util.Scanner;// importa a biblioteca Scanner
import java.util.Locale;// importa a biblioteca Locale <<<<<< NOVIDADE!!!! facilita insercao de valores double
public class Menu
{//atributos da classe Menu, os nomes dos atributos sao auto explicativos
    private int escolhaMenu, numConta, numContaDestino;
    private double saldoConta, depositoConta, saqueConta, valor;
    private String titularConta;
    private Scanner in;
    private Banco bancoGiraffa;

    public Menu()
    {// construtor
        in = new Scanner(System.in);// inicializei a variavel in do tipo Scanner (Scanner in = new Scanner(System.in)) olhe o codigo acima para entender a logica
        Locale.setDefault(Locale.US);// utilizarei a biblioteca Locale para nao ter problemas de "," "." na hora de separar a case decimal dos numeros reais (pode gerar um erro na utilizacao de "," ou "." dependendo da versao do compilador java)

        bancoGiraffa = new Banco();// inicaliza a variavei bancoGiraffa do tipo banco (Banco bancoGiraffa = new Banco();)
        //Atributos abaixo iniciados com valores nulos pelo ponto de vista de conta bancaria.
        escolhaMenu = -1;
        numConta = -1;
        numContaDestino = -1;
        saldoConta = -1;
        titularConta = "";
        depositoConta = -1;
        saqueConta = -1;
    }

    public void menuAcoes()
    {//Aqui onde a integracao acontece
        perguntaMenu();// chamo o metodo perguntaMenu() onde tem as opcoes do menu
        System.out.print("\nEscolha: ");// print para se localizar onde esta sua escolha para "andar" no menu
        escolhaMenu = in.nextInt();// variavel que ira receber do teclado a informacao para "andar" no menu

        switch(escolhaMenu)// o switch ira se "guiar" de acordo com o valor atribuido na variavel escolhaMenu
        {
            case 1://caso escolhaMenu tenha o valor 1
            {
                System.out.println("\f");//limpa a tela
                                
                System.out.print("\nInforme o nome do titular da conta: ");//realiza uma pergunta
                titularConta = in.next();// informe o nome do titular, caso queira separar o nome (Osvaldo Junior) utilize "-" para evitar erro (Osvaldo-Junior) a impressao sera (Osvaldo Junior)
                saldoConta = validaDeposito();// atribui um valor real acima ou igual a 50(valor minimo definido no enunciado) utiliza o metodo validaDeposito()

                bancoGiraffa.criaConta(titularConta, saldoConta);//chama o metodo criaConta que esta presente na classe Banco e passa as variaveis parametricar necessarios presentes dentro dos parenteses
                menuAcoes();//chama novamente o menuAcoes(), desta forma funciona como uma funcao recursiva, logo nao sera necessario a utilizacao de estuturas iterativas para fazer mais de uma operacoa no menu
                break;//para a execucao da opcao 1 do switch
            }
            case 2:
            {
                System.out.println("\f");//limpa a tela
                
                System.out.print("\nInforme o numero da conta: ");//realiza uma pergunta
                numConta = in.nextInt();//informa o numero da conta que deseja realizar a operacao 

                bancoGiraffa.removeConta(numConta);//chama o metodo removeConta que esta presente na classe Banco e passa as variaveis parametricar necessarios presentes dentro dos parenteses
                menuAcoes();//chama novamente o menuAcoes(), desta forma funciona como uma funcao recursiva, logo nao sera necessario a utilizacao de estuturas iterativas para fazer mais de uma operacoa no menu
                break;//para a execucao da opcao 2 do switch
            }
            case 3:
            {
                System.out.println("\f");//limpa a tela
                
                System.out.print("\nInforme o valor de depositado: R$ ");//realiza uma pergunta
                depositoConta = in.nextDouble();//informa o valor de deposito
                System.out.print("\nInforme o numero da conta: ");//realiza uma pergunta
                numConta = in.nextInt();//informa o numero da conta que deseja realizar a operacao 

                bancoGiraffa.depositaConta(numConta, depositoConta);//chama o metodo depositaConta que esta presente na classe Banco e passa as variaveis parametricar necessarios presentes dentro dos parenteses
                menuAcoes();//chama novamente o menuAcoes(), desta forma funciona como uma funcao recursiva, logo nao sera necessario a utilizacao de estuturas iterativas para fazer mais de uma operacoa no menu
                break;//para a execucao da opcao 3 do switch
            }
            case 4:
            {
                System.out.println("\f");//limpa a tela
                                
                System.out.print("\nInforme o valor de saque: R$ ");//realiza uma pergunta
                saqueConta = in.nextDouble();//informa o valor de saque
                System.out.print("\nInforme o numero da conta: ");//realiza uma pergunta
                numConta = in.nextInt();//informa o numero da conta que deseja realizar a operacao 

                bancoGiraffa.saqueConta(numConta, saqueConta);//chama o metodo saqueConta que esta presente na classe Banco e passa as variaveis parametricar necessarios presentes dentro dos parenteses
                menuAcoes();//chama novamente o menuAcoes(), desta forma funciona como uma funcao recursiva, logo nao sera necessario a utilizacao de estuturas iterativas para fazer mais de uma operacoa no menu
                break;//para a execucao da opcao 4 do switch
            }
            case 5:
            {
                System.out.println("\f");//limpa a tela
                
                System.out.print("\nInforme o valor de tranferencia: R$ ");//realiza uma pergunta
                valor = in.nextDouble();//informa o valor de tranferencia
                System.out.print("\nInforme o numero da conta: ");//realiza uma pergunta
                numConta = in.nextInt();//informa o numero da conta que deseja realizar a operacao 
                System.out.print("\nInforme o numero da conta de destino: ");//realiza uma pergunta
                numContaDestino = in.nextInt();//informa o numero da conta de destino da tranferencia

                bancoGiraffa.transfereConta(numConta, numContaDestino, valor);//chama o metodo tranfereConta que esta presente na classe Banco e passa as variaveis parametricar necessarios presentes dentro dos parenteses
                menuAcoes();//chama novamente o menuAcoes(), desta forma funciona como uma funcao recursiva, logo nao sera necessario a utilizacao de estuturas iterativas para fazer mais de uma operacoa no menu
                break;//para a execucao da opcao 5 do switch
            }
            case 6:
            {
                System.out.println("\f");//limpa a tela
                //System.out.print("\033[H\033[2J");// Utilizo para limpar o terminal da linha de comando

                System.out.print("\nInforme o numero da conta: ");//realiza uma pergunta
                numConta = in.nextInt();//informa o numero da conta que deseja realizar a operacao 

                System.out.printf("Saldo disponivel: R$ %,.2f\n", bancoGiraffa.saldoConta(numConta));//chama o metodo saldoCorrenteConta que esta presente na classe Banco e passa as variaveis parametricar necessarios presentes dentro dos parenteses
                menuAcoes();//chama novamente o menuAcoes(), desta forma funciona como uma funcao recursiva, logo nao sera necessario a utilizacao de estuturas iterativas para fazer mais de uma operacoa no menu
                break;//para a execucao da opcao 6 do switch
            }
            case 7:
            {
                System.out.println("\f");//limpa a tela
                
                bancoGiraffa.imprimeBanco();//chama o metodo imprimeBanco que esta presente na classe Banco e passa as variaveis parametricar necessarios presentes dentro dos parenteses
                menuAcoes();//chama novamente o menuAcoes(), desta forma funciona como uma funcao recursiva, logo nao sera necessario a utilizacao de estuturas iterativas para fazer mais de uma operacoa no menu
                break;//para a execucao da opcao 7 do switch
            }
            case 8:
            {
                System.out.println("\f");//limpa a tela
                

                System.out.print("\nInforme o numero da conta: ");//realiza uma pergunta
                numConta = in.nextInt();//informa o numero da conta que deseja realizar a operacao 

                bancoGiraffa.imprimeConta(numConta);//chama o metodo imprimeConta que esta presente na classe Banco e passa as variaveis parametricar necessarios presentes dentro dos parenteses
                menuAcoes();//chama novamente o menuAcoes(), desta forma funciona como uma funcao recursiva, logo nao sera necessario a utilizacao de estuturas iterativas para fazer mais de uma operacoa no menu
                break;//para a execucao da opcao 8 do switch
            }
            case 9:
            {
                System.out.println("\f");//limpa a tela
                //System.out.print( "33H332J" );alternativa para limpar o terminal da linha de comando

                bancoGiraffa.imprimeBanco();//chama o metodo imprimeBanco que esta presente na classe Banco e passa as variaveis parametricar necessarios presentes dentro dos parenteses
                menuAcoes();//chama novamente o menuAcoes(), desta forma funciona como uma funcao recursiva, logo nao sera necessario a utilizacao de estuturas iterativas para fazer mais de uma operacoa no menu
                break;//para a execucao da opcao 9 do switch
            }
            case 10:
            {
                break;//para a execucao da opcao 10 do switch e sai da menuAcoes() fazendo com que o programa pare
            }
        }
    }

    private void perguntaMenu()
    {// metodo privado que possui os prints para informar as opcoes do menu
        System.out.println("\n[1] ........ Criar Conta");
        System.out.println("[2] ........ Remover Conta");
        System.out.println("[3] ........ Depositar");
        System.out.println("[4] ........ Sacar");
        System.out.println("[5] ........ Tranferencia Entre Contas");
        System.out.println("[6] ........ Saldo Corrente");
        System.out.println("[7] ........ Situacao Atual do Banco");
        System.out.println("[8] ........ Situacao Atual da Conta");
        System.out.println("[9] ........ Lista de Contas do Banco");
        System.out.println("[10] ....... Sair");
    }

    private double validaDeposito()
    {// metodo privador responsavel pela validacao de deposito da abertura da conta (valor minimo R$ 50.00)
        double valor = 0; // inicializa uma variavel do tipo primitivo double e atribui o valor 0 nela (nao era necessario inicalizar pelo do-while)
        do//estrutura iterativo do-while (executa primeiro e verifica depois)
        {
            System.out.println("\nInforme o valor da abertura da conta.");// imprime informacoes para o usuario
            System.out.print("O valor minimo dde deposito de R$ 50.00: R$ ");
            valor = in.nextDouble();// realiza a leitura do teclado
        }while(valor < 50);// condicao de parada ( valor ser maior ou igual a 50 )

        return(valor);// retorna o valor verificado ( garante que o valor seja maior ou igual a 50 )
    }
}