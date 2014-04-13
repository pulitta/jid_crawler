import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import static java.lang.System.*;
import java.io.File;
import java.util.*;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;

import java.io.IOException;

public class jid_crawler {
	
public static List<String> get_html_page(String reference_to_vk) throws IOException
	{
	Document request_to_vk = Jsoup.connect(reference_to_vk).get();
	Elements links = request_to_vk.select("a[href]");
	List<String> list_of_ids = new ArrayList<String>();
	for (Element link : links) 
	{
		if (link.attr("href").startsWith("id"))
		{
			list_of_ids.add(link.attr("href"));
			//System.out.println(link.attr("href"));
		}
	}
	return list_of_ids;
	}
public static void page_counter() throws IOException
{
	String reference_to_vk = "http://vk.com/catalog.php?selection=";
	String page;
	int million = 200;
	int thousand = 99;
	int hundred = 99;
	BufferedWriter file = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ids.txt")));
	for (int i = 0; i <= million; i++)
	{
		for (int j = 0; j <= thousand; j++)
		{
			for (int k = 0; k <= hundred; k++)
			{
				page = reference_to_vk + Integer.toString(i) + "-" + Integer.toString(j) + "-" + Integer.toString(k);
				//System.out.println(page);
				write_to_file(file, get_html_page(page));
				
			}
		}
	}
	file.close();
}
public static void write_to_file(BufferedWriter file, List<String> list_of_ids) throws IOException
{
	for (String id : list_of_ids)
	{
		file.write(id+ " ,");
		//System.out.println(id + ",");
	}
}
public static void main(String[] args) throws IOException
	{
//	get_html_page("http://vk.com/catalog.php?selection=0-0-0");
	page_counter();
	}
}
