package org.apache.airavata;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;

/**
 * Created by ssapra on 2/20/16.
 */
public class Soup {
    private String url;
    private String professorName;
    private int page;
    public Soup(String url, String name){

        this.url = url;
        this.professorName = name;
        this.url += "&q="+this.professorName+"&num=20";
        this.page = 1;
    }

    /**
     * 
     * @return JSONArray representing publications attributed to a inputted person
     * @throws IOException 
     */
    public JSONArray getCitations() throws IOException {
        String pagedUrl = this.url;
        System.out.println(pagedUrl);
        Document doc = Jsoup.connect(pagedUrl).
            	timeout(5000).ignoreHttpErrors(true).followRedirects(true).userAgent("Mozilla").get();

        Elements div_links = doc.select(".gs_fl > a:nth-child(1)");
        Elements publication_names = doc.select(".gs_ri > .gs_rt");
        JSONArray publication_list = new JSONArray();
        for (int i = 0; i < div_links.size(); i++) {
            Element link = div_links.get(i);
            Element pub_name = publication_names.get(i);
            String[] words = link.text().split(" ");
            int numCitations = Integer.parseInt(words[2]);
            System.out.println(pub_name.text() + " : " + numCitations);
            JSONObject publication = new JSONObject();
            publication.put("name", pub_name.text());
            publication.put("num_citations", numCitations);
            publication_list.add(publication);
        }
        return publication_list;
    }
}
