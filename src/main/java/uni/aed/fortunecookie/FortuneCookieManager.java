package uni.aed.fortunecookie;

import java.util.Random;
import uni.aed.listTDA.ListTDA;

public class FortuneCookieManager {
    private ListTDA<String> fortunas;

    public FortuneCookieManager() {
        FortuneCookieFile fortuneCookieFile=new FortuneCookieFile();
        fortunas=fortuneCookieFile.getLista();        
    }
    
    public String nexFortune() {
        Random random = new Random();
        int index = random.nextInt(fortunas.size());
        return fortunas.get(index);
        
    }
}
