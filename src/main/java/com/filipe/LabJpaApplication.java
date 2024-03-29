package com.filipe;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.filipe.model.Cargo;
import com.filipe.model.Departamento;
import com.filipe.model.Endereco;
import com.filipe.model.Funcionario;
import com.filipe.model.InfoFuncionarioDTO;
import com.filipe.model.TipoFuncionario;
import com.filipe.repository.CargoRepository;
import com.filipe.repository.EnderecoRepository;
import com.filipe.repository.FuncionarioRepository;
import com.filipe.service.CargoService;
import com.filipe.service.DepartamentoService;
import com.filipe.service.FuncionarioService;

@SpringBootApplication
public class LabJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LabJpaApplication.class, args);
	}
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Departamento dp1 = new Departamento(null, "FINANCAS");
		
		Departamento dp2 = new Departamento(null, "TI");
		
		Cargo c1 = new Cargo(null, "Técnico em Informática", dp2);
		
		Cargo c2 = new Cargo(null, "Programador", dp2);
		
		Cargo c3 = new Cargo(null, "Contador", dp1);
		
		Cargo c4 = new Cargo(null, "Tesoureiro", dp1);
		
		Funcionario f1 = new Funcionario(null, "Filipe Castro", 2000.0,TipoFuncionario.PERIODO_INTEGRAL, c2);
		Funcionario f2 = new Funcionario(null, "Franklin", 2100.0, TipoFuncionario.PERIODO_INTEGRAL, c2);
		Funcionario f3 = new Funcionario(null, "Reinaldo Santos",1700.0, TipoFuncionario.MEIO_PERIODO, c3);
		Funcionario f4 = new Funcionario(null, "Lucas Davi", 2300.0, TipoFuncionario.PERIODO_INTEGRAL, c1);
		
		Endereco end1 = new Endereco(null, "São Cristovão", f1);
		Endereco end2 = new Endereco(null, "Rua A", f2);
		Endereco end3 = new Endereco(null, "Rua B", f3);
		Endereco end4 = new Endereco(null, "Rua C", f4);
		
		departamentoService.inserir(dp1);
		departamentoService.inserir(dp2);
		cargoRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		funcionarioRepository.saveAll(Arrays.asList(f1,f2,f3,f4));
		enderecoRepository.saveAll(Arrays.asList(end1,end2,end3, end4));
		
		
		Departamento departamento = departamentoService.buscar(1L);
		System.out.println(departamento);
		List<Cargo> cargos = departamento.getCargos();
		
		System.out.println(cargos);
		
		System.out.println("Buscando Todos os departamentos....");
		List<Departamento> departamentos = departamentoService.buscarTodos();
		System.out.println(departamentos);
		
		//System.out.println(departamentos.get(0).getCargos()); //LAZY EXCEPTION
		
		System.out.println("Contando o Total de departamentos: ");
		System.out.println(departamentoService.contar());
		
		System.out.println("Buscando Departamento TI pelo nome...");
		System.out.println(departamentoService.buscarPorNome("TI"));
		
		System.out.println("Buscando nome por id....");
		System.out.println(departamentoService.buscarNomePorId(2L));
		
		System.out.println("Buscando nome do cargo com id = 1....");
		System.out.println(cargoService.buscarNomeCargo(1L));
		
		System.out.println("Buscando nome do cargo e do departamento onde Cargo id = 1....");
		List<Object[]> nomes = cargoService.buscarNomeCargoEdepartamento(1L);
		for(Object[] nome : nomes) {
			System.out.println("cargo: "+ nome[0] + "| departamento: "+ nome[1]);
		}
		
		System.out.println("Buscando nomes de cargos com Like...");
		List<String> listaCargos = cargoService.buscarCargoLike("o");
		System.out.println(listaCargos);

		System.out.println("Buscando nome de Funcionarios com salario entre 1600 e 2200");
		System.out.println(funcionarioService.buscarFuncionariosSalarioEntre(1600.00, 2200.00));
		
		System.out.println("Buscando nome de Funcionarios com salarios NOT BETWEEN 1600 e 2200");
		System.out.println(funcionarioService.buscarFuncionarioNotSalarioEntre(1600.00, 2200.00));
		
		System.out.println("Buscando nome de Funcionarios pertencentes aos cargos contidos na lista ....");
		System.out.println(funcionarioService.buscarFuncionariosNosCargos(Arrays.asList("Técnico em Informática", "Programador")));
		
		System.out.println("Buscando Funcionarios com Salario maior que 1600.0 e ordenados pelo salario");
		System.out.println(funcionarioService.buscarFuncionariosOrdenadosPorSalario());		
		
		System.out.println("Buscando informações do funcionario com INNER JOIN");
		List<Object[]> infoFuncionarios = funcionarioService.buscarInformacoesComJoin();
		for(Object[] info : infoFuncionarios) {
			
			int tam = info.length;
			
			for(int i = 0; i < tam; i++) {
				System.out.print(" "+ info[i]);
				
				if(i == (tam-1)) {
					System.out.println();
				}
			}
		}
		
		System.out.println("Buscando informações do funcionario,cargo,departamento com INNER JOIN");
		List<Object[]> infoFuncionarios2 = funcionarioService.buscarInformacoesComJoin2();
		for(Object[] info : infoFuncionarios2) {
			
			int tam = info.length;
			
			for(int i = 0; i < tam; i++) {
				System.out.print(" "+ info[i]);
				
				if(i == (tam-1)) {
					System.out.println();
				}
			}
		}
		
		System.out.println("Buscando informações dos funcionarios via DTO");
		List<InfoFuncionarioDTO> infoFuncionariosDTOs = funcionarioService.buscarListaDeInformacoes();
		System.out.println(infoFuncionariosDTOs);
		
		System.out.println("Busca de Cargos por paginação....");
		System.out.println(cargoService.findPage(0, 2));
	}

}
