import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import static java.lang.System.*;

import java.io.IOException;

public class jid_crawler {
	
public static void get_html_page(String reference_to_vk) throws IOException
	{
	Document request_to_vk = Jsoup.connect(reference_to_vk).get();
	Elements links = request_to_vk.select("a[href]");
	for (Element link : links) {
		if (link.attr("href").startsWith("id"))
		{
			System.out.println(link.attr("href"));
		}
	}
	}
public static void main(String[] args) throws IOException
	{
	get_html_page("http://vk.com/catalog.php?selection=0-0-0");
	}
}
