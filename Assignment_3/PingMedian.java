import java.io.*;
import java.lang.reflect.Type.*;
import java.util.Arrays;

/**
* Asks the user to input the number of times to ping an IP address/website, and the IP address/website itself.
* Starts a process to ping the specified website and collects the ping times and prints out the median time.
*/

class PingMedian {

	public static void main(String[] args)throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of times to ping");
		int n=0;
		String str = buff.readLine();
		if(str.equals("")) {
			System.out.println("Invalid Input");
			return;
		}
		else
			n = Integer.parseInt(str);
		System.out.println("Enter the site/IP address to ping");
		String site = buff.readLine();
		if(site.equals("")) {
			System.out.println("Invalid input.");
			return;
		}
		else {
			double median = pingMedianFinder(n, site);
			System.out.println(median);
		}
	}
	
	/**
	* Takes the IP address to be pinged and the number of times of doing so as arguments and initiates a process to ping the site.
	* Returns the median of the ping times after sorting them.
	* @param n integer containing the number of times to ping the site
	* @param site String containing the IP address/URL of the website to ping
	*/
	
	public static double pingMedianFinder(int n, String site)throws IOException {
		if(site != null) {
			Process p = Runtime.getRuntime().exec("ping -c " + n + " " + site);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String s = "" , pingResult = "", time = "";
			double ping[] = new double[n];
			int c = 0;
			while ((s = br.readLine()) != null) {
				pingResult += s;
			}
			String[] fields = pingResult.split(" " , 0);
			for(String i : fields) {
				if(i.contains("time=")) {
					time=i.substring(5);
					if(time.contains(".")) {
						ping[c] = Double.parseDouble(time);
						c++;
					}
					else {
						ping[c] = (double)Integer.parseInt(time);
						c++;
					}
				}
			}
			Arrays.sort(ping);
			double median;
			if(n % 2 == 0)
				median = (ping[n/2-1] + ping[n/2]) / 2;
			else
				median = ping[n/2];
			return median;
		}
		else
			throw new IllegalArgumentException("Site name should not be a null value.");
	}
}
