package com.example.desafioPrime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LerCSV {

	public static void main(String[] args) {

		String csvArquivo = "C:\\Users\\Frederico Rocha\\OneDrive\\Área de Trabalho\\Coding Interview\\baseDados.csv";
		List<Pessoa> pessoas = new ArrayList<>();
		String linha = "";

		String csvSepadorCampo = ";";

		try (FileReader fileReader = new FileReader(csvArquivo);
			 CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader())) {

			for (CSVRecord csvRecord : csvParser) {
				String nome = csvRecord.get("Nome");
				double altura = Double.parseDouble(csvRecord.get("Altura"));
				double peso = Double.parseDouble(csvRecord.get("Peso"));
				String funcao = csvRecord.get("Funcao");
				String empresa = csvRecord.get("Empresa");

				Pessoa pessoa = new Pessoa(nome, altura, peso, funcao, empresa);
				pessoas.add(pessoa);
			}


		} catch (IOException e) {

		}
		//PESSOA MAIOR PESO
		double calculoPeso = pessoas.stream().mapToDouble(Pessoa::getPeso).max().orElse(0);
		List<Pessoa> listaPeso = new ArrayList<>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getPeso() == calculoPeso) {
				listaPeso.add(pessoa);
			}
		}
		if (!listaPeso.isEmpty()) {
			System.out.println("Maior peso:");
			for (Pessoa pessoa : listaPeso) {
				System.out.println(pessoa.getNome() + "");
			}
		}

		//PESSOA MAIOR ALTURA
		double calculoAltura = pessoas.stream().mapToDouble(Pessoa::getPeso).max().orElse(0);
		List<Pessoa> listaAltura = new ArrayList<>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getAltura() == calculoAltura) {
				listaAltura.add(pessoa);
			}
		}
		if (!listaAltura.isEmpty()) {
			System.out.println("Maior Altura:");
			for (Pessoa pessoa : listaAltura) {
				System.out.println(pessoa.getNome() + "");
			}
		}

		//FUNÇÃO MAIS ENCONTRADA
		Map<String, Integer> contagem = new HashMap<>();
		for (Pessoa pessoa : pessoas) {
			String funcao = pessoa.getFuncao();
			contagem.put(funcao, contagem.getOrDefault(funcao,0) +1);
		}
		int maxFunc = contagem.values().stream().max(Integer::compare).orElse(0);
		List<String> max = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : contagem.entrySet()) {
			if (entry.getValue() == maxFunc) {
				max.add(entry.getKey() + " (" + entry.getValue() + " vezes)");
			}
		}
		System.out.println("" + maxFunc);

		//EMPRESA MAIS PESSOAS

		Map<String, Integer> empresaContagem = new HashMap<>();
		for (Pessoa pessoa : pessoas) {
			String empresa = pessoa.getEmpresa();
			empresaContagem.put(empresa, empresaContagem.getOrDefault(empresa, 0) + 1);
		}
		int maiorContagemEmpresa = empresaContagem.values().stream().max(Integer::compare).orElse(0);
		List<String> empresasMaisPessoas = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : empresaContagem.entrySet()) {
			if (entry.getValue() == maiorContagemEmpresa) {
				empresasMaisPessoas.add(entry.getKey() + " (" + entry.getValue() + " pessoas)");
			}
		}
		System.out.println("" + empresasMaisPessoas);

	}


	}

class Pessoa {
	private String nome;
	private double altura;
	private double peso;
	private String funcao;
	private String empresa;

	public Pessoa(String nome, double altura, double peso, String funcao, String empresa) {
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.funcao = funcao;
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public double getAltura() {

		return altura;
	}

	public double getPeso() {

		return peso;
	}

	public String getFuncao() {

		return funcao;
	}

	public String getEmpresa() {

		return empresa;
	}

	public double calcularIMC() {

		return peso / ((altura / 100) * (altura / 100));
	}
}
