package GUI;

import excecoes.NomeNuloException;
import negocio.Fachada;
import negocio.entidades.Cliente;

/**
 * Classe que representa a interface grafica. A partir daqui que o sistema sera inicializado
 *
 * @author Luciano
 */
public class Main {

    public static void main(String[] args) {

        //Inicializar a fachada
        Fachada fachada = new Fachada();

        /*
        * Aqui seria a parte de fazer leitura de dados do usuario
        *
        * vou colocar aqui simplificado sem leitura de dados
         */
       /* while (true) {
            try {
                //Fazer leitura de dados com JOptionPane

                //Exemplo de inserir um cliente
                Cliente c1 = new Cliente("Luciano", "000.000.000-12");

                fachada.inserirCliente(c1);                

                //se deu tudo certo vai sair do while
                break;
            } catch (NomeNuloException ex) {
                //exibir mensagem de erro
                continue;
            }
        }*/

        //.. Fazer remover, atualizar, procurar, verificar se existe lendo dados do usuário e utilizando
        //JOPtionPane
        //Dar a opção pro usuario escolher qual operacao quer fazer. Cadastrar, procurar, etc
        //
    }

}
