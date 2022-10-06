import data.CadastroDB;
import model.CadastroCNES;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        List<CadastroCNES> listcnes = leitor("C:\\Users\\Logatti\\Desktop\\cadastro_estabelecimentos_cnes.csv");
        for (CadastroCNES cne : listcnes) {
            System.out.println(cne);
            CadastroDB cadastro = new CadastroDB();
            cadastro.insert(cne);
        }


    }

    public static List<CadastroCNES> leitor(String path) throws IOException {
        List<CadastroCNES> listcnes = new ArrayList<>();
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        boolean primeiraLinha = false;
        while (true) {
            linha = buffRead.readLine();
            if (linha != null) {
                if(!primeiraLinha){
                    primeiraLinha = true;
                    continue;
                }
                String[] split = linha.split(";");
                System.out.println(Arrays.toString(split));
                CadastroCNES cadastro = new CadastroCNES();
                cadastro.setCnes(split[0]);
                cadastro.setUf(split[1]);
                cadastro.setIbge(split[2]);
                cadastro.setNome(split[3]);
                cadastro.setLogradouro(split[4]);
                cadastro.setBairro(split[5]);
                listcnes.add(cadastro);

            } else
                break;

        }
        buffRead.close();
        return listcnes;


    }
}
