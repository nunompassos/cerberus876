package br.com.letscode.modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Banco implements Serializable {
	private static final long serialVersionUID = 4000000L;
	public static Agencia selecionada;
	public static final ArrayList<Agencia> agencias = new ArrayList<>();
}
