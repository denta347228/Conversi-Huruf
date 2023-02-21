package aca.fasilkomunsri.pemvis.appschallenge.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class textedit implements txtedit{
    private String txt;
    public textedit() {
        this.txt = "";
    }

    public String gtTxt() {
        return txt;
    }

    public void stTxt(String txt) {
        this.txt = txt;
    }
    
    public static void loadStopwords() throws IOException {
        List<String> stopwords = Files.readAllLines(Paths.get("C:\\Users\\asus\\Downloads\\Stopword.txt"));
}
    
    @Override
    public String casefolding() {
        String result;
        result = this.txt.toLowerCase();
        return result;
    }

    @Override
    public String[] tokenizer() {
        int a = 0;
        StringTokenizer tkn = new StringTokenizer(txt," ");
        String [] token = new String[tkn.countTokens()];
        while(tkn.hasMoreTokens()){
            token[a] = tkn.nextToken() + " + ";
            a++;
        }
        return token;
    }

    @Override
    public String stopwordremoval() {
        List<String> stopwords = null;
        try {
            stopwords = Files.readAllLines(Paths.get("D:\\KODING\\Stopword.txt"));
        } catch (IOException ex) {
            Logger.getLogger(textedit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String original = this.txt;
        String[] allWords = original.toLowerCase().split(" ");
 
        StringBuilder builder = new StringBuilder();
        for(String word : allWords) {
            if(!stopwords.contains(word)) {
            builder.append(word);
            builder.append(' ');
            }
        }
        String result = builder.toString().trim();
        return result;
    }

    @Override
    public int termfrequency(String term) {
        String original = this.txt;
        String[] allWords = original.split(" ");
        int result = 0;
        for (String allWord : allWords) {
            if (term.equalsIgnoreCase(allWord))
                result++;
        }
        return result;
    }
    
}
