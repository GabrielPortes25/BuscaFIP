package com.ApiCar.ApiCar.Principal;

import com.ApiCar.ApiCar.Models.*;
import com.ApiCar.ApiCar.Services.ConsumoAPI;
import com.ApiCar.ApiCar.Services.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    public void ExibeMenu(){
        System.out.println("Digite a o codigo da categoria do veiculo que deseja pesquisar: \n 1- Carros \n 2- Motos \n 3- Caminhão");
        var categoriaSelecionada = leitura.nextInt();
        leitura.nextLine();

        var categoria = "error";

        switch (categoriaSelecionada){
            case 1: categoria = "carros";
                break;

            case 2: categoria = "motos";
                break;

            case 3: categoria = "caminhoes";
                break;
        }

        if(categoria.equals("error")){
            System.out.println("Categoria Invalida!");
        }
        System.out.println(categoria);
         var json = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/"+categoria+"/marcas");

        List<DadosCategoria> dados = conversor.obterLista(json, DadosCategoria.class);

        for (DadosCategoria item : dados) {
            System.out.println("Código: " + item.getCodigo() + " - Nome: " + item.getNome());
        }

        System.out.println("Selecione o codigo da marca desejada: ");

        var marca = leitura.nextInt();
        leitura.nextLine();

        var marcaSelecionada = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/"+categoria+"/marcas/"+marca+"/modelos");

        DadosModelos modelos = conversor.obterDados(marcaSelecionada, DadosModelos.class);

        List<DadosMarca> marcas = new ArrayList<>();

        for (DadosMarca item : modelos.modelos()) {
            marcas.add(item);
            System.out.println(item);
        }
        System.out.println(marcas);

        System.out.println("Digite o nome do Veiculo que deseja Filtrar: ");

        var nomeVeiculo = leitura.nextLine();

        List<DadosMarca> marcaBuscada = marcas.stream()
                .filter(e -> e.nome().toUpperCase().contains(nomeVeiculo.toUpperCase()))
                        .toList();
        if(marcaBuscada.isEmpty()){
            System.out.println("Marca não encontrada!");
        }else{
            System.out.println("Marcas encontradas:");
            for (DadosMarca m : marcaBuscada){
                System.out.println("Código: " + m.codigo() + " - Nome: " + m.nome());

            }
        }

        System.out.println("Digite o codigo do veiculo a ser consultado: ");
        var escolhaDoVeiculo = leitura.nextInt();
        leitura.nextLine();

        var consultaDoVeiculo = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/"+categoria+"/marcas/"+marca+"/modelos/"+escolhaDoVeiculo+"/anos");

        List<DadosAno> veiculosBuscado = conversor.obterLista(consultaDoVeiculo, DadosAno.class);

        if (veiculosBuscado == null || veiculosBuscado.isEmpty()) {
            System.out.println("Nenhum ano disponível para este veículo.");
            return;
        }

        for (DadosAno ano : veiculosBuscado) {
            var urlFipe = "https://parallelum.com.br/fipe/api/v1/" + categoria + "/marcas/" + marca + "/modelos/" + escolhaDoVeiculo + "/anos/" + ano.codigo();
            var jsonFipe = consumo.obterDados(urlFipe);
            DadosVeiculo dadosFipe = conversor.obterDados(jsonFipe, DadosVeiculo.class);

            System.out.println("Ano: " + dadosFipe.anoModelo() +
                    " | Valor: " + dadosFipe.valor() +
                    " | Combustível: " + dadosFipe.combustivel() +
                    " | Modelo: " + dadosFipe.modelo());
        }

    }

}
