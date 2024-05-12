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
    //2pc
    public void AddFortuneCookie(String fortune){
        fortunas.add(fortune);
    }
    public void DeleteFortuneCookie(String fortune){
        fortunas.delete(fortune);
    }
    public void DeleteFortuneCookie(int index){
        fortunas.delete(index);
    }
    public String getLastFortuneCookie() {
        return fortunas.get(fortunas.size());
    }
    public String getFortuneCookie(int index){
        return fortunas.get(index);
    }
    public int getSizeFortuneCookie() {
        return fortunas.size();
    }
    @Override
    public String toString() {
        return "FortuneCookieManager{" + "fortunas=" + fortunas + '}';
    }
}
