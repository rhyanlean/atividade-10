import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Modelo (Model)
class NumeroModel {
    private List<Integer> numeros;

    public NumeroModel() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.numeros.add(numero);
    }

    public int buscarNumero(int alvo) {
        for (int i = 0; i < this.numeros.size(); i++) {
            if (this.numeros.get(i) == alvo) {
                return i;
            }
        }
        return -1;
    }
}

// Visualização (View)
class NumeroView {
    public int solicitarNumero() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Digite o número que deseja procurar: ");
			return scanner.nextInt();
		}
    }

    public void mostrarResultado(int index) {
        if (index != -1) {
            System.out.println("O número foi encontrado na posição " + index + ".");
        } else {
            System.out.println("O número não foi encontrado.");
        }
    }
}

// Controlador (Controller)
class NumeroController {
    private NumeroModel model;
    private NumeroView view;

    public NumeroController(NumeroModel model, NumeroView view) {
        this.model = model;
        this.view = view;
    }

    public void adicionarNumeros(int[] numeros) {
        for (int num : numeros) {
            this.model.adicionarNumero(num);
        }
    }

    public void buscarNumero(int alvo) {
        int index = this.model.buscarNumero(alvo);
        this.view.mostrarResultado(index);
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        NumeroModel modelo = new NumeroModel();
        NumeroView visao = new NumeroView();
        NumeroController controlador = new NumeroController(modelo, visao);

        // Armazenando 10 números
        int[] numeros = {4, 7, 2, 9, 5, 1, 8, 3, 6, 10};
        controlador.adicionarNumeros(numeros);

        // Solicitando o número a ser procurado
        int alvo = visao.solicitarNumero();

        // Realizando a busca sequencial
        controlador.buscarNumero(alvo);
    }
}


	


