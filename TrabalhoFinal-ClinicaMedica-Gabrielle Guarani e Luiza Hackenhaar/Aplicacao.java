import java.util.Scanner;
//classe aplicação aonde uso todos os métodos criados na classe cadastro paciente e os printo na tela.
class Aplicacao {
    public static void main(String[] args) {
        CadastroPacientes cadastro = new CadastroPacientes();
        Scanner in = new Scanner(System.in);
        int opcao = -1;
        System.out.println("\f");
        while (opcao != 0) {
            System.out.println("——— MENU ———");
            System.out.println("1 — Adicionar paciente");
            System.out.println("2 — Remover paciente");
            System.out.println("3 — Escrever todo o cadastro do paciente");
            System.out.println("4 — Escrever em ordem alfabética crescente");
            System.out.println("5 — Média das consultas dos pacientes");
            System.out.println("6 — Porcentagem dos pacientes com Covid, Dengue, Influenza, Meningite, Outro");
            System.out.println("0 — Sair do programa");
            System.out.print("Informe a opção: ");
            opcao = in.nextInt();
            in.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do paciente: ");
                    String nome = in.nextLine();
                    System.out.print("Digite o CPF do paciente: ");
                    String cpf = in.nextLine();
                    System.out.print("Digite o telefone do paciente: ");
                    String telefone = in.nextLine();
                    System.out.print("Digite o convênio do paciente: ");
                    String convenio = in.nextLine();
                    System.out.println("Escolha o diagnóstico do paciente:");
                    System.out.println("1 - Covid");
                    System.out.println("2 - Dengue");
                    System.out.println("3 - Influenza");
                    System.out.println("4 - Meningite");
                    System.out.println("5 - Outro");
                    System.out.print("Opção: ");
                    int diagnostico = in.nextInt();
                    System.out.print("Digite o número de consultas do mês: ");
                    int numConsultasMes = in.nextInt();
                    Paciente paciente = new Paciente(nome, cpf, telefone, convenio, diagnostico, numConsultasMes);
                    cadastro.adicionarPaciente(paciente);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Digite o índice do paciente a ser removido: (começa em 0) ");
                    int index = in.nextInt();
                    cadastro.removerPaciente(index);
                    System.out.println();
                    break;

                case 3:
                    cadastro.escreverCadastro();
                    break;

                case 4:
                    cadastro.escreverNomesEmOrdemAlfabetica();
                    break;

                case 5:
                    double media = cadastro.mediaConsultas();
                    System.out.println("Média de consultas dos pacientes: " + media);
                    break;

                case 6:
                    cadastro.porcentagemDiagnostico();
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    System.out.println();
            }
        }
        
        in.close();
    }
}