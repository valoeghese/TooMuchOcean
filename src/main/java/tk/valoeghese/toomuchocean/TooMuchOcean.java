package tk.valoeghese.toomuchocean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import net.fabricmc.api.ModInitializer;

public class TooMuchOcean implements ModInitializer {

	public static TMOConfig config = new TMOConfig();
	public static final Logger log = LogManager.getLogger("TooMuchOcean");
	
	@Override
	public void onInitialize() {
		log.info("Initialising TooMuchOcean");
		
		File configFile = new File("./config/toomuchocean.json");
		try {
			if (configFile.createNewFile()) {
				log.info("Creating config file.");
				try (FileWriter writer = new FileWriter(configFile)) {
					writer.write("{\n  \"replacementChance\": 0.3\n}");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try (FileReader reader = new FileReader(configFile)) {
					Gson gson = new Gson();

					config = gson.fromJson(reader, TMOConfig.class);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			e.printStackTrace();
		}
		log.info("Configured Replacement Chance (should be 0.0-1.0): ".concat(String.valueOf(config.replacementChance)));
	}

}
