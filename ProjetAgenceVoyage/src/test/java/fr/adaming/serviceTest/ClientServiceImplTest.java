package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ClientServiceImplTest {
	
	@Autowired
	private IClientService clService;
	
	// ----- Test READ ALL
		@Ignore
		@Test
		@Transactional(readOnly = true)
		public void testGetAllClientService() {
			
			double tailleAtt = 0;
			double tailleReelle = clService.getAllClient().size();

			assertEquals(new Double(tailleAtt), new Double(tailleReelle));
		}

		// ----- Test ADD ALL
		@Ignore
		@Test
		@Transactional(readOnly = true)
		public void testAddClientService(){
			
			// Instanciation d'un client vide
			Client clIn = new Client();
			
			int tailleAvant = clService.getAllClient().size();
			
			clService.addClient(clIn);
			
			int tailleApres = clService.getAllClient().size();
			
			assertEquals(new Double(++tailleAvant), new Double(tailleApres));
		}
		
		// ----- Test UPDATE
		@Ignore
		@Test
		@Transactional
		@Rollback(true)
		public void testUpdateClientService(){
			
			Client clModif = clService.getClientById(1);
			
			clModif.setNom("DUPONT");
			
		//	assertEquals("DUPONT", clService.updateClient(clModif.getNom()));
			
		}
		
		// ----- Test DELETE
		@Ignore
		@Test
		@Transactional
		@Rollback(true)
		public void testDeleteClientService() {
		int tailleAvant = clService.getAllClient().size();
		clService.deleteClient(1);
		int tailleApres = clService.getAllClient().size();
		assertEquals(new Double(--tailleAvant), new Double(tailleApres));
		}

}
