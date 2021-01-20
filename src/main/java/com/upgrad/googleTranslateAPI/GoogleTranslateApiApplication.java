package com.upgrad.googleTranslateAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoogleTranslateApiApplication {

	public static void main(String[] args) throws Exception{

		SpringApplication.run(GoogleTranslateApiApplication.class, args);
		;



				GoogleAPI.setHttpReferrer(/* Enter the URL of your site here */);


				GoogleAPI.setKey(/* Enter your API key here */);

				String translatedText = Translate.DEFAULT.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH);

				System.out.println(translatedText);
			}
		}

	}

}
