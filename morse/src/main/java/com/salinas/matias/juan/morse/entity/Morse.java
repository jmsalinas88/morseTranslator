package com.salinas.matias.juan.morse.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.salinas.matias.juan.morse.Constants;

/**
 *
 * @author Juan M. Salinas
 *
 */
public abstract class Morse {

	protected Map<String, String> dictionary = new HashMap<String, String>();
	
	/**
	 * Este constructor popula el diccionario necesario a partir de un archivo.
	 * @param dictionary nombre del archivo a procesar.
	 */
	protected Morse(String dictionary) {
		
		Resource resource = new ClassPathResource(dictionary);
		Stream<String> lines = null;
		try {
			lines = Files.lines(Paths.get(resource.getURI()));
			lines.forEach(line -> {

				String[] parts = line.split("=", 2);
				if (parts.length >= 2) {
					String key = parts[0];
					String value = parts[1];
					this.dictionary.put(key, value);
				}
			});
			lines.close();
		} catch (IOException io) {
			io.printStackTrace();
		}finally {
			if(lines != null) {
				lines.close();
			}
		}
		this.dictionary.put(Constants.WHITE_SPACE, Constants.WHITE_SPACE);
	}
}
