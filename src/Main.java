import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        int i;
        String cor = "a", marca = "a", modelo = "a", placa = "a";
        float potencia = 0;
        double velocidadeAtual = 0, quantidadeCombustivel = 0, capacidadeTanque = 0;
        Carro[] carro = new Carro[3];
        for (i = 0; i < 3; i++){
            carro[i] = new Carro(cor, marca, modelo, placa, potencia, velocidadeAtual, quantidadeCombustivel, capacidadeTanque);
        }

        Scanner scan = new Scanner(System.in);


        for (i = 0; i <= 2; i++){
            System.out.printf("Digite a cor do carro %d: ", i+1);
            //usando apenas scan.next pq o scan.nextLine tinha buffer cheio no proximo carro
            System.out.printf("> ");
            carro[i].setCor(cor = scan.next());
            System.out.printf("Digite a marca do carro %d: ", i+1);
            System.out.printf("> ");
            carro[i].setMarca(marca = scan.next());
            System.out.printf("Digite a Modelo do carro %d: ", i+1);
            System.out.printf("> ");
            carro[i].setModelo(modelo = scan.next());
            System.out.printf("Digite a potencia do carro %d: ", i+1);
            System.out.printf("> ");
            carro[i].setPotencia(potencia = scan.nextFloat());
            carro[i].setVelocidadeAtual(velocidadeAtual);
            System.out.printf("Digite a Capacidade MAXIMA do tanque: ");
            System.out.printf("> ");
            carro[i].setCapacidadeTanque(capacidadeTanque = scan.nextInt());
            System.out.printf("Digite a quantidade de combustivel ATUAL: ");
            System.out.printf("> ");
            carro[i].setQuantidadeCombustivel(quantidadeCombustivel = scan.nextInt());
            System.out.println("Digite a placa do carro: ");
            carro[i].setPlaca(placa = scan.next());
        }

        menu(carro);

    }

    public static void menu(Carro[] carro) throws IOException {

        Scanner scan = new Scanner(System.in);

        int e_carro = 0, op_fazer = 0;
        float qtd_abast = 0;

        for (int i = 0; i < 20; ++i) {
            System.out.println();
        }

        System.out.println("=============================================");
        System.out.println("       Bem-vindo a concessionaria DO IF      ");
        System.out.println("     Escolha qual monstrao vc quer dirigir   ");
        System.out.println("=============================================");

        for (int i = 0; i < 3; i++) {
            System.out.println(i+1 + "- " + carro[i].toString());
        }
        do {
            System.out.printf("> ");
            e_carro = scan.nextInt();
        }while (e_carro < 1 || e_carro > 3);
        e_carro -= 1;

        do {
            for (int i = 0; i < 10; ++i) {
                System.out.println();
            }

            System.out.println("Voce escolheu o carro " + carro[e_carro].getMarca() + " " + carro[e_carro].getModelo() + " Para dirigir");
            System.out.println("Vamos Jogar um jogo? O que quer fazer?");
            System.out.println("1 - acelerar");
            System.out.println("2 - abastecer");
            System.out.println("3 - mostrar o estado");
            System.out.println("4 - Frear");
            System.out.println("0 - SAIR");
            System.out.printf("> ");
            op_fazer = scan.nextInt();

            switch (op_fazer){
                case 1:
                    System.out.println("Voce acelerou VRUM VRUM, cuidado pra nao ir mt rapido");
                    if(carro[e_carro].getVelocidadeAtual() > 200){
                        System.out.println("Desculpe não eh possivel acelerar mais pra sua seguranca");
                    }
                    else {
                        carro[e_carro].acelerar();
                    }
                    break;
                case 2:
                    if (qtd_abast + carro[e_carro].getQuantidadeCombustivel() == carro[e_carro].getCapacidadeTanque()){
                        System.out.println("Seu tanque esta cheio");
                    }
                    else {
                        System.out.print("Quantos litros vc quer abastecer? ");
                        System.out.printf("> ");
                        qtd_abast = scan.nextFloat();
                        if (qtd_abast + carro[e_carro].getQuantidadeCombustivel() < carro[e_carro].getCapacidadeTanque()) {
                            carro[e_carro].abastecer(qtd_abast);
                            carro[e_carro].setVelocidadeAtual(0);
                        } else {
                            System.out.println("Pera la neh amigao nao vamo estourar o tanque");
                        }
                    }
                    break;
                case 3:
                    System.out.println("o Carro " +carro[e_carro].getMarca() + " " + carro[e_carro].getModelo());
                    System.out.println("Esta na velocidade: " +carro[e_carro].getVelocidadeAtual() + " Km/h");
                    System.out.println("E o Combustivel em seu tanque é de: " +carro[e_carro].getQuantidadeCombustivel());
                    break;
                case 4:
                    int freada;
                    if(carro[e_carro].getVelocidadeAtual() == 0){
                        System.out.println("Voce esta parado");
                    }
                    else {
                        do {
                            System.out.println("1- Freada Forte");
                            System.out.println("2- Freada Normal");
                            freada = scan.nextInt();

                            if (freada == 1) {
                                float reducao;
                                do {
                                    System.out.println("Digite a Quantos porcento da velocidade a ser reduzido: ");
                                    reducao = scan.nextInt();
                                } while (reducao < 0 || reducao > 100);
                                carro[e_carro].frear(reducao);
                            } else {
                                carro[e_carro].frear();
                            }
                        } while (freada < 1 || freada > 2);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Tente novamente");
                    break;
            }
            System.out.println("Pressione [ENTER]");
            System.in.read();
        }while (op_fazer != 0);
    }
}