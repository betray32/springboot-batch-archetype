package cl.arquetipo.sb.launcher.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArquetipoJavaSpringTest {
	
	/**
	 * LOG
	 */
	private static final Logger log = LoggerFactory.getLogger(ArquetipoJavaSpringTest.class);

	/**
	 * setUp
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		log.info("-----------------------------------------");
		log.info("Inicializando Test");
	}

	/**
	 * tearDown
	 * 
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		log.info("Finalizando Test");
	}

	/**
	 * test
	 */
	@Test
	void test() {
		log.info("Test [Testing para Arquetipo Batch]");
		assertTrue(true);
	}

}
