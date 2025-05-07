import com.google.gson.Gson;
import java.io.IOException;
import java.util.Scanner;
import model.Filme;
import dto.FilmeDTO;
import services.OmdbClient;
import services.Serialize;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner s = new Scanner(System.in);

        // escolha de filme
        System.out.print("Digite o nome do filme: ");
        String name = s.nextLine();

        final String API_KEY = "";

        // envio de requisição para API
        OmdbClient response = new OmdbClient(name, API_KEY);

        // definição de padrão de nomenclatura
        Gson gson = Serialize.upperCamelCase();

        // transferencia de dados entre objetos show e titulo
        FilmeDTO show = gson.fromJson(response.getResponse(), FilmeDTO.class);
        Filme filme = new Filme(show);
        System.out.println(filme);


    }
}

