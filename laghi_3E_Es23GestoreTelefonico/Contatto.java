enum tipoContratto{abitazione, cellulare, aziendale};

public class Contatto {
    public String nome;
    public String cognome;
    public String telefono;
    public tipoContratto tipo;

    public String stampa()
    {
        return String.format("Nome: %s \tCognome: %s \nTelefono: %s, \ttipo: %s\n", nome, cognome, telefono, tipo.toString());
    }
}
