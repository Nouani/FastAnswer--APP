package bd.dbos;

/**
A classe Lista representa uma lista de uma tabela Listas.
Tem como m�todos get's e set's de valores.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class Lista implements Cloneable
{
    private int    codLista;
    private int    codMateria;
    private String arquivo;
    private String nomeLista;
    
    /**
	Seta o c�digo da lista.
	@param codLista codigo desejado para inclus�o
	@throws Exception caso codigo seja menor que zero
	*/
    public void setCodigo (int codLista) throws Exception
    {
        if (codLista < 0)
            throw new Exception ("Codigo da lista � invalidp");

        this.codLista = codLista;
    }
    
    /**
	Seta o c�digo da mat�ria.
	@param codMateria codigo desejado para inclus�o
	@throws Exception caso codigo seja menor que zero
	*/
    public void setCodMateria (int codMateria) throws Exception
    {
        if (codMateria <= 0)
            throw new Exception ("Codigo da mat�ria � invalido");

        this.codMateria = codMateria;
    }   
    
    /**
	Seta o diretorio do arquivo.
	@param arquivo arquivo/diretorio desejado para inclus�o
	@throws Exception caso arquivo seja nulo ou vazio
	*/
    public void setArquivo (String arquivo) throws Exception
    {
        if (arquivo==null || arquivo.trim().equals(""))
            throw new Exception ("Diret�rio nao fornecido");

        this.arquivo = arquivo;
    }
    
    /**
	Seta o nome da lista.
	@param nomeLista nome desejado para inclus�o
	@throws Exception caso arquivo seja nulo ou vazio
	*/
    public void setNomeLista (String nomeLista) throws Exception
    {
        if (nomeLista==null || nomeLista.trim().equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nomeLista = nomeLista;
    }
    
    /**
	Pega o c�digo da lista
	@return codigo da lista
	*/
    public int getCodigo ()
    {
        return this.codLista;
    }
    
    /**
	Pega o c�digo da mat�ria
	@return RA do aluno
	*/
    public int getCodMateria ()
    {
        return this.codMateria;
    }
    
    /**
	Pega o diretorio da lista
	@return diretorio da lista
	*/
    public String getArquivo ()
    {
        return this.arquivo;
    }
    
    /**
	Pega o nome da lista
	@return nome da lista
	*/
    public String getNomeLista ()
    {
        return this.nomeLista;
    }
    
    /**
	Construtor da classe Lista.
	Seta os atributos da classe.
	@param codLista c�digo da lista
	@param codMateria c�digo da mat�ria
	@param arquivo diret�rio da lista
	@param nomeLista nome da lista
	@throws Exception caso o par�metro seja nulo, vazio ou menor que zero
	*/
    public Lista (int codLista, int codMateria, String arquivo, String nomeLista) throws Exception
    {
    	System.out.println("dasdas");
        this.setCodigo (codLista);
        System.out.println("dasdas");
        this.setCodMateria (codMateria);
        System.out.println("dasdas");
        this.setArquivo (arquivo);
        System.out.println("dasdas");
        this.setNomeLista(nomeLista);
        System.out.println("dasdas");
    }
    
    /**
	Transforma e retorna a inst�ncia em formato de String
	@return string com os valores da inst�ncia
	*/
    public String toString ()
    {
        String ret="";

        ret+="Codigo da Lista: "+this.codLista+"\n";
        ret+="Codigo da Mat�ria..: "+this.codMateria  +"\n";
        ret+="Arquivo..: "+this.arquivo  +"\n";
        ret+="Nome da Lista..: "+this.nomeLista;

        return ret;
    }
    
    /**
	Verifica se a inst�ncia � igual a outra.
	@param obj objeto a ser comparado com a inst�ncia
	@return true se os atributos forem iguais, false se n�o forem
	*/
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Lista))
            return false;

        Lista list = (Lista)obj;

        if (this.codLista!=list.codLista)
            return false;

        if (this.codMateria!=list.codMateria)
            return false;

        if (this.arquivo.equals(list.arquivo))
            return false;
        
        if (this.nomeLista.equals(list.nomeLista))
            return false;

        return true;
    }
    
    /**
	Calcula e devolve o c�digo hash da inst�ncia.
	@return o c�digo hash.
	*/
    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.codLista).hashCode();
        ret = 7*ret + new Integer(this.codMateria).hashCode();
        ret = 7*ret + this.arquivo.hashCode();
        ret = 7*ret + this.nomeLista.hashCode();

        return ret;
    }
    
    /**
	Construtor de c�pia da classe.
	Seta os atributos da inst�ncia com os do passado como par�metro
	@param inst�ncia a ser copiada
	*/
    public Lista (Lista modelo) throws Exception
    {
        this.codLista = modelo.codLista;
        this.codMateria = modelo.codMateria;   
        this.arquivo = modelo.arquivo;  
        this.nomeLista = modelo.arquivo;  
    }
    
    /**
	Clona a inst�ncia.
	@return a inst�ncia clonada
	*/
    public Object clone ()
    {
        Lista ret=null;

        try
        {
            ret = new Lista (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca � null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}