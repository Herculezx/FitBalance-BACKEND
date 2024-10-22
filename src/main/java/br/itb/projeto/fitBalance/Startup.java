package br.itb.projeto.fitBalance;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.itb.projeto.fitBalance.model.entity.Exercicios;
import br.itb.projeto.fitBalance.model.entity.Mensagem;
import br.itb.projeto.fitBalance.model.entity.Usuario;
import br.itb.projeto.fitBalance.service.ExerciciosService;
import br.itb.projeto.fitBalance.service.MensagemService;
import br.itb.projeto.fitBalance.service.UsuarioService;

@SpringBootApplication
// @CrossOrigin(origins = "*")
public class Startup {
	@Autowired
	ExerciciosService exerciciosService;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	MensagemService mensagemService;

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			if (usuarioService.findAll().size() == 0) {
				usuarioService.create(new Usuario("Admin Riberker", "admin@email.com", "Admin111", "ADMIN",
						LocalDate.of(2006, 10, 2), "ATIVO"));
				usuarioService.create(new Usuario("Usuario", "usuario@email.com", "Usuario1", "USER",
						LocalDate.of(2006, 10, 2), "ATIVO"));
			}
			if (exerciciosService.findAll().size() == 0) {
				
				/* STARTER */ 
				
				//Alongamento Estático  nao tem video 

				//Agachamentos
				exerciciosService.create(new Exercicios("Agachamentos", "Iniciante", 1, 8,
						"Posicione-se em pé, mantendo os pés afastados na largura dos ombros. Dobre os joelhos e desça o quadril, simulando o ato de se sentar em uma cadeira. Mantenha as costas retas e verifique se os joelhos estão alinhados com os tornozelos. Volte à posição inicial.",
						new String(((InputStream) getClass().getResourceAsStream("/images/agachamento.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/agachamento.txt")).readAllBytes())
						));

				//Flexão com Joelho Apoiado
				exerciciosService.create(new Exercicios("Flexão com o joelho apoiado", "Iniciante", 1, 10,
						"Afastar os joelhos um pouco para trás, de forma a que as coxas fiquem oblíquas em relação ao chão , contrair os músculos abdominais e das nádegas e dobrar os cotovelos e baixar o tronco e as coxas em direção ao chão.",
						new String(((InputStream) getClass().getResourceAsStream("/images/flexao_joelho_apoiado.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/flexaoComJoelhoApoiado.txt")).readAllBytes())
						));

				//Prancha
				exerciciosService.create(new Exercicios("Prancha", "Iniciante", 1, 30,
						"Deite-se de barriga para baixo e apoie-se nos antebraços e nas pontas dos pés, mantendo o corpo reto. Mantenha essa posição por 30 segundos a 1 minuto, focando em contrair os músculos do core (abdômen e região lombar) durante todo o exercício.",
						new String(((InputStream) getClass().getResourceAsStream("/images/prancha.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/prancha.txt")).readAllBytes())
						));


				//Polichinelos
				exerciciosService.create(new Exercicios("Polichinelos", "Iniciante", 1, 30,
						"Em pé, com os pés juntos, dê um salto enquanto abre os braços e as pernas para os lados, formando um “X” no ar. Em seguida, dê outro salto para voltar à posição inicial. Repita o movimento por 30 segundos a 1 minuto.",
						new String(((InputStream) getClass().getResourceAsStream("/images/polichinelo.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/polichinelo.txt")).readAllBytes())
						));

				//Passada Afundo
				exerciciosService.create(new Exercicios("Passada afundo", "Iniciante", 1, 10,
						"Dê um grande passo à frente e faça um agachamento afundo, distribuindo o peso entre os quadris e joelhos. Junte as pernas ao retornar para a posição em pé. Dê um passo à frente com a outra perna e repita o agachamento",
						new String(((InputStream) getClass().getResourceAsStream("/images/passada_afundo.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/passadaAfundo.txt")).readAllBytes())
						));

				// Abdominais
				exerciciosService.create(new Exercicios("Abdominais", "Iniciante", 2, 10,
						"Deite-se de costas, com os joelhos dobrados e os pés apoiados no chão. Coloque as mãos atrás da cabeça e contraia o abdômen enquanto levanta os ombros do chão, aproximando o peito dos joelhos. Mantenha a posição por um segundo e, em seguida, abaixe lentamente o corpo de volta ao chão. ",
						new String(((InputStream) getClass().getResourceAsStream("/images/abdominais.txt")).readAllBytes()),
						new String(((InputStream) getClass().getResourceAsStream("/videos/abdominais.txt")).readAllBytes())
						));

				//Mergulho na Cadeira
				exerciciosService.create(new Exercicios("Mergulho Na Cadeira", "Iniciante", 2, 10,
						"Sente-se em um banco/cadeira e posicione as palmas das mãos no apoio, afaste-as em uma distância um pouco maior do que a largura dos ombros. Estenda as pernas e mantenha os calcanhares apoiados no solo. Mova o corpo para frente até tirar os glúteos do banco.",
						new String(((InputStream) getClass().getResourceAsStream("/images/mergulho_cadeira.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/mergulhoNaCadeira.txt")).readAllBytes())
						));

				//Pular Corda
				exerciciosService.create(new Exercicios("Pular corda", "Iniciante", 2, 100,
						"Pular corda é uma atividade física que consiste em saltar e girar em torno de uma corda em movimento.",
						new String(((InputStream) getClass().getResourceAsStream("/images/pular_corda.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/pularCorda.txt")).readAllBytes())
						));

				
				
				
				
				
				
				
				/* INTERMEDIARY */
				
				//Agachamentos
				exerciciosService.create(new Exercicios("Agachamentos", "Intermediário", 2, 15,
						"Posicione-se em pé, mantendo os pés afastados na largura dos ombros. Dobre os joelhos e desça o quadril, simulando o ato de se sentar em uma cadeira. Mantenha as costas retas e verifique se os joelhos estão alinhados com os tornozelos. Volte à posição inicial.",
						new String(((InputStream) getClass().getResourceAsStream("/images/agachamento.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/agachamento.txt")).readAllBytes())
						));

				//Flexão com Joelho Apoiado
				exerciciosService.create(new Exercicios("Flexão com o joelho apoiado", "Intermediário", 2, 15,
						"Afastar os joelhos um pouco para trás, de forma a que as coxas fiquem oblíquas em relação ao chão , contrair os músculos abdominais e das nádegas e dobrar os cotovelos e baixar o tronco e as coxas em direção ao chão.",
						new String(((InputStream) getClass().getResourceAsStream("/images/flexao_joelho_apoiado.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/flexaoComJoelhoApoiado.txt")).readAllBytes())
						));

				// Prancha
				exerciciosService.create(new Exercicios("Prancha", "Intermediário", 2, 45,
						"Deite-se de barriga para baixo e apoie-se nos antebraços e nas pontas dos pés, mantendo o corpo reto. Mantenha essa posição por 30 segundos a 1 minuto, focando em contrair os músculos do core (abdômen e região lombar) durante todo o exercício.",
						new String(((InputStream) getClass().getResourceAsStream("/images/prancha.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/prancha.txt")).readAllBytes())
						));

				// Polichinelos
				exerciciosService.create(new Exercicios("Polichinelos", "Intermediário", 2, 30,
						"Em pé, com os pés juntos, dê um salto enquanto abre os braços e as pernas para os lados, formando um “X” no ar. Em seguida, dê outro salto para voltar à posição inicial. Repita o movimento por 30 segundos a 1 minuto.",
						new String(((InputStream) getClass().getResourceAsStream("/images/polichinelo.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/polichinelo.txt")).readAllBytes())
						));

				//Passada Afundo
				exerciciosService.create(new Exercicios("Passada afundo", "Intermediário", 2, 20,
						"Dê um grande passo à frente e faça um agachamento afundo, distribuindo o peso entre os quadris e joelhos. Junte as pernas ao retornar para a posição em pé. Dê um passo à frente com a outra perna e repita o agachamento",
						new String(((InputStream) getClass().getResourceAsStream("/images/passada_afundo.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/passadaAfundo.txt")).readAllBytes())
						));
				
				// Abdominais
				exerciciosService.create(new Exercicios("Abdominais", "Intermediário", 2, 25,
						"Deite-se de costas, com os joelhos dobrados e os pés apoiados no chão. Coloque as mãos atrás da cabeça e contraia o abdômen enquanto levanta os ombros do chão, aproximando o peito dos joelhos. Mantenha a posição por um segundo e, em seguida, abaixe lentamente o corpo de volta ao chão. ",
						new String(((InputStream) getClass().getResourceAsStream("/images/abdominais.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/abdominais.txt")).readAllBytes())
						));

				//Mergulho na Cadeira
				exerciciosService.create(new Exercicios("Mergulho Na Cadeira", "Intermediário", 3, 10,
						"Sente-se em um banco/cadeira e posicione as palmas das mãos no apoio, afaste-as em uma distância um pouco maior do que a largura dos ombros. Estenda as pernas e mantenha os calcanhares apoiados no solo. Mova o corpo para frente até tirar os glúteos do banco.",
						new String(((InputStream) getClass().getResourceAsStream("/images/mergulho_cadeira.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/mergulhoNaCadeira.txt")).readAllBytes())
						));
				
				//Pular Corda
				exerciciosService.create(new Exercicios("Pular corda", "Intermediário", 4, 100,
						"Pular corda é uma atividade física que consiste em saltar e girar em torno de uma corda em movimento.",
						new String(((InputStream) getClass().getResourceAsStream("/images/pular_corda.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/pularCorda.txt")).readAllBytes())
						));

				//Mountain Climbers
				exerciciosService.create(new Exercicios("Mountain Climbers", "Intermediário", 3, 30,
						"Comece numa posição de prancha alta, ombros sobre os pulsos, pélvis contraída. A seguir, conduza o joelho direito em direção ao peito, depois o esquerdo. Puxar o joelho direito em direção ao peito e fazer uma pausa. Depois repetir o padrão começando com o joelho esquerdo",
						new String(((InputStream) getClass().getResourceAsStream("/images/mountain_climber.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/mountainClimbers.txt")).readAllBytes())
						));

				//Flexão
				exerciciosService.create(new Exercicios("Flexão De Braço", "Intermediário", 2, 10,
						"Encoste as mãos na parede, levemente mais abertas do que a largura dos ombros. Inspire e faça a flexão de braço, dobrando os cotovelos. Expire e empurre a parede para voltar à posição inicial.",
						new String(((InputStream) getClass().getResourceAsStream("/images/flexao_braco.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/flexao.txt")).readAllBytes())
						));
				
				// Abdominal Com Pernas Elevadas
				exerciciosService.create(new Exercicios("Abdominal com pernas elevadas", "Intermediário", 2, 10,
						"Flexione a cintura para levantar o tronco do chão. Mantenha a parte interior das costas em contato com o chão e levante o tronco o máximo possível. Depois desça o tronco, até que a parte posterior dos ombros entre em contato com o chão. Você pode manter as mãos estendidas para a frente, ou cruzá-las na frente do peito.",
						new String(((InputStream) getClass().getResourceAsStream("/images/abdominal_perna_elevada.txt")).readAllBytes()),
						new String(((InputStream) getClass().getResourceAsStream("/videos/abdominaisComPernasElevadas.txt")).readAllBytes())
						));

				
				
				
				
				
				
				/* ADVANCED */
				
//				exerciciosService.create(new Exercicios("Alongamento estático", "Avançado", 4, 30,
//						"No alongamento estático, você deve esticar o músculo até atingir uma determinada posição, mantendo-o assim por aproximadamente 30 segundos. A ideia é que você se alongue até chegar a um limite considerado confortável.",
//						new String(((InputStream) getClass().getResourceAsStream("/images/alongamento_estatico.txt")).readAllBytes()), ""));

				//Agachamentos
				exerciciosService.create(new Exercicios("Agachamentos", "Avançado", 4, 20,
						"Posicione-se em pé, mantendo os pés afastados na largura dos ombros. Dobre os joelhos e desça o quadril, simulando o ato de se sentar em uma cadeira. Mantenha as costas retas e verifique se os joelhos estão alinhados com os tornozelos. Volte à posição inicial.",
						new String(((InputStream) getClass().getResourceAsStream("/images/agachamento.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/agachamento.txt")).readAllBytes())
						));

				//Flexão com Joelho Apoiado
				exerciciosService.create(new Exercicios("Flexão com o joelho apoiado", "Avançado", 2, 15,
						"Afastar os joelhos um pouco para trás, de forma a que as coxas fiquem oblíquas em relação ao chão , contrair os músculos abdominais e das nádegas e dobrar os cotovelos e baixar o tronco e as coxas em direção ao chão.",
						new String(((InputStream) getClass().getResourceAsStream("/images/flexao_joelho_apoiado.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/flexaoComJoelhoApoiado.txt")).readAllBytes())
						));

				//Prancha
				exerciciosService.create(new Exercicios("Prancha", "Avançado", 4, 30,
						"Deite-se de barriga para baixo e apoie-se nos antebraços e nas pontas dos pés, mantendo o corpo reto. Mantenha essa posição por 30 segundos a 1 minuto, focando em contrair os músculos do core (abdômen e região lombar) durante todo o exercício.",
						new String(((InputStream) getClass().getResourceAsStream("/images/prancha.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/prancha.txt")).readAllBytes())
						));

				//Polichinelos
				exerciciosService.create(new Exercicios("Polichinelos", "Avançado", 5, 30,
						"Em pé, com os pés juntos, dê um salto enquanto abre os braços e as pernas para os lados, formando um “X” no ar. Em seguida, dê outro salto para voltar à posição inicial. Repita o movimento por 30 segundos a 1 minuto.",
						new String(((InputStream) getClass().getResourceAsStream("/images/polichinelo.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/polichinelo.txt")).readAllBytes())
						));

				//Passada Afundo
				exerciciosService.create(new Exercicios("Passada afundo", "Avançado", 4, 15,
						"Dê um grande passo à frente e faça um agachamento afundo, distribuindo o peso entre os quadris e joelhos. Junte as pernas ao retornar para a posição em pé. Dê um passo à frente com a outra perna e repita o agachamento",
						new String(((InputStream) getClass().getResourceAsStream("/images/passada_afundo.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/passadaAfundo.txt")).readAllBytes())
						));

				// Abdominais
				exerciciosService.create(new Exercicios("Abdominais", "Avançado", 3, 25,
						"Deite-se de costas, com os joelhos dobrados e os pés apoiados no chão. Coloque as mãos atrás da cabeça e contraia o abdômen enquanto levanta os ombros do chão, aproximando o peito dos joelhos. Mantenha a posição por um segundo e, em seguida, abaixe lentamente o corpo de volta ao chão. ",
						new String(((InputStream) getClass().getResourceAsStream("/images/abdominais.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/abdominais.txt")).readAllBytes())
						));

				//Mergulho na Cadeira
				exerciciosService.create(new Exercicios("Mergulho Na Cadeira", "Avançado", 3, 20,
						"Sente-se em um banco/cadeira e posicione as palmas das mãos no apoio, afaste-as em uma distância um pouco maior do que a largura dos ombros. Estenda as pernas e mantenha os calcanhares apoiados no solo. Mova o corpo para frente até tirar os glúteos do banco.",
						new String(((InputStream) getClass().getResourceAsStream("/images/mergulho_cadeira.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/mergulhoNaCadeira.txt")).readAllBytes())
						));

				//Pular Corda
				exerciciosService.create(new Exercicios("Pular corda", "Avançado", 6, 100,
						"Pular corda é uma atividade física que consiste em saltar e girar em torno de uma corda em movimento.",
						new String(((InputStream) getClass().getResourceAsStream("/images/pular_corda.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/pularCorda.txt")).readAllBytes())
						));

				//Mountain CLimbers
				exerciciosService.create(new Exercicios("Mountain Climbers", "Avançado", 5, 30,
						"Comece numa posição de prancha alta, ombros sobre os pulsos, pélvis contraída. A seguir, conduza o joelho direito em direção ao peito, depois o esquerdo. Puxar o joelho direito em direção ao peito e fazer uma pausa. Depois repetir o padrão começando com o joelho esquerdo",
						new String(((InputStream) getClass().getResourceAsStream("/images/mountain_climber.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/mountainClimbers.txt")).readAllBytes())
						));

				//Flexão
				exerciciosService.create(new Exercicios("Flexão De Braço", "Avançado", 4, 10,
						"Encoste as mãos na parede, levemente mais abertas do que a largura dos ombros. Inspire e faça a flexão de braço, dobrando os cotovelos. Expire e empurre a parede para voltar à posição inicial.",
						new String(((InputStream) getClass().getResourceAsStream("/images/flexao_braco.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/flexao.txt")).readAllBytes())
						));
				
				//Abdominal Com Pernas Elevadas
				exerciciosService.create(new Exercicios("Abdominal com pernas elevadas", "Avançado", 4, 10,
						"Flexione a cintura para levantar o tronco do chão. Mantenha a parte interior das costas em contato com o chão e levante o tronco o máximo possível. Depois desça o tronco, até que a parte posterior dos ombros entre em contato com o chão. Você pode manter as mãos estendidas para a frente, ou cruzá-las na frente do peito.",
						new String(((InputStream) getClass().getResourceAsStream("/images/abdominal_perna_elevada.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/abdominaisComPernasElevadas.txt")).readAllBytes())
						));
				
				//Flexão Diamante
				exerciciosService.create(new Exercicios("Flexão diamante", "Avançado", 2, 10,
						"Apoiar as mãos no chão próximas uma da outra formando um triângulo ou “diamante” com as pontas dos dedos,esticar as pernas para trás, mantendo os pés juntos e tocando o chão apenas com os dedos, posicionar o centro peito diretamente acima as mãos e esticar os braços, mantendo as costas retas e na mesma linha das pernas, dobrar os cotovelos para descer com o corpo durante a inspiração; Elevar o corpo de volta para posição inicial, empurrando o chão com as mãos e exalando.",
						new String(((InputStream) getClass().getResourceAsStream("/images/flexao_diamante.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/flexaoDiamante.txt")).readAllBytes())
						));
						
				//Burpee
				exerciciosService.create(new Exercicios("Burpees", "Avançado", 2, 10,
						"Comece ficando de pé, com a postura ereta, Agache, colocando as mãos no chão e jogando o seu peso nelas, Posicione os pés para trás, como se fizesse uma prancha, Execute uma flexão de braço até seu corpo todo tocar o chão, Levante, aproximando os pés das mãos, empurrando os braços e saltando com os braços acima da cabeça.",
						new String(((InputStream) getClass().getResourceAsStream("/images/burpees.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/burpee.txt")).readAllBytes())
						));

				//Alongamento Cobra
				exerciciosService.create(new Exercicios("Alongamento Cobra", "Avançado", 3, 20,
						"Deite se no chão, de barriga para baixo, e apoie-se sobre os antebraços, com os cotovelos no chão na altura dos ombros, pressione a barriga no chão e procure levantar o peito para cima, sem tensionar a parte de baixo das costas, procure afastar os ombros das orelhas, empurrando os ombros para baixo.",
						new String(((InputStream) getClass().getResourceAsStream("/images/alongamento_cobra.txt")).readAllBytes()), 
						new String(((InputStream) getClass().getResourceAsStream("/videos/alongamentoCobra.txt")).readAllBytes())
						));

			}
		};
	}
}