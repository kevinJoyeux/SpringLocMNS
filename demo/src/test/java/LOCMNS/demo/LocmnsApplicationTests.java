package LOCMNS.demo;

import LOCMNS.demo.model.TableAssociative.MaterielEtatMateriel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
class LocmnsApplicationTests{

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}
	@Test
	public void verificationBonneAppartenanceDeLocation() throws Exception {
		mvc.perform(get("/locationUtilisateur/{$id}", 1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
	}

	@Test
	public void peutRentrerUnUtilisateur() throws Exception{
		String jsonBody = "{\"nom\": \"Test\", \"prenom\": \"test\"}";
		mvc.perform(MockMvcRequestBuilders.post("/utilisateur").contentType(MediaType.APPLICATION_JSON).content(jsonBody))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void retourneToutesLesLocations() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/location").accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}






}
